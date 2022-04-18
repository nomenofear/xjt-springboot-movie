package com.xjt.movie.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xjt.movie.entity.TPerms;
import com.xjt.movie.entity.TUser;
import com.xjt.movie.mapper.TUserMapper;
import com.xjt.movie.service.TUserService;
import com.xjt.movie.utils.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Slf4j
@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser findRolesByUsername(String principal) {
        return tUserMapper.findRolesByUsername(principal);
    }

    @Override
    public List<TPerms> findPermsListByRoleId(Integer roleid) {
        return tUserMapper.findPermsListByRoleId(roleid);
    }

    @Override
    public TUser findUserByName(String username) {
        return tUserMapper.selectOne(new QueryWrapper<TUser>().eq("username",username));
    }

    @Override
    public TUser findUserByEmail(String email) {
        return tUserMapper.selectOne(new QueryWrapper<TUser>().eq("email",email));
    }

    @Override
    public RespBean registerNewTUser(String username,String password,String email) {
        //1、先检查用户名和邮箱是否已存在
        if(!ObjectUtils.isEmpty(this.findUserByName(username))){
            return RespBean.error("用户名已存在请重新输入");
        }
        if(!ObjectUtils.isEmpty(findUserByEmail(email))){
            return RespBean.error("邮箱已存在请重新输入");
        }
        //2、产生随机盐
        String ss = RandomUtil.randomString(6);
        log.warn("密码盐的随机字符串为==="+ss);
        Md5Hash md5Hash = new Md5Hash(password, ss, 1024);

        TUser tUser = new TUser().setUsername(username).setPassword(md5Hash.toHex()).setSalt(ss).setEmail(email);

        int insert = tUserMapper.insert(tUser);
        log.warn("成功向数据库添加用户 tUser={}",tUser);

        if(insert >=0){
            return RespBean.success("用户创建成功username="+tUser.getUsername(),tUser);
        }else{
            return RespBean.error("创建失败！");
        }
    }

    @Override
    public RespBean deleteUserById(String uid) {
        int i = tUserMapper.deleteById(uid);
        if(i<0){
            return RespBean.error("error");
        }else{
            return RespBean.success("ok");
        }
    }

    @Override
    public RespBean findUserByLikeName(String username) {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.like("username",username);
        List<TUser> userList = tUserMapper.selectList(wrapper);
        if(ObjectUtils.isEmpty(userList)){
            return RespBean.error("error");
        }else{
            return RespBean.success("ok",userList);
        }
    }

    @Override
    public RespBean findUserById(String uid) {
        TUser tUser = tUserMapper.selectById(uid);

        if(ObjectUtils.isEmpty(tUser)){
            return RespBean.error("error");
        }else{
            return RespBean.success("ok",tUser);
        }
    }

    @Override
    public RespBean findAllUser() {
        List<TUser> userList = tUserMapper.selectList(null);

        if(ObjectUtils.isEmpty(userList)){
            return RespBean.error("error");
        }else{
            return RespBean.success("ok",userList);
        }
    }
}
