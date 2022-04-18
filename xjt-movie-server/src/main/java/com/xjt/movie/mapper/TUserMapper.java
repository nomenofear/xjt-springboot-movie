package com.xjt.movie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjt.movie.entity.TPerms;
import com.xjt.movie.entity.TUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserMapper extends BaseMapper<TUser> {
    TUser findRolesByUsername(String principal);

    List<TPerms> findPermsListByRoleId(Integer roleid);
}
