package com.xjt.movie.config.shiro;

import com.xjt.movie.entity.TPerms;
import com.xjt.movie.entity.TRole;
import com.xjt.movie.entity.TUser;
import com.xjt.movie.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    private TUserService tUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("======doGetAuthenticationInfo=======");

        String principal = (String) principals.getPrimaryPrincipal();
        TUser tUser = tUserService.findRolesByUsername(principal);

        List<TRole> rolesList = tUser.getRolesList();

        if(!ObjectUtils.isEmpty(rolesList)){
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            //1、给认证用户添加角色信息
            for (TRole role : rolesList) {
                authorizationInfo.addRole(role.getName());
                //2、给认证用户添加权限信息
                List<TPerms> permsList = tUserService.findPermsListByRoleId(role.getRoleId());
                if(!CollectionUtils.isEmpty(permsList) && permsList.get(0) != null){
                    for (TPerms perms : permsList) {
                        authorizationInfo.addStringPermission(perms.getPermName());
                    }
                }
            }
            return authorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("======doGetAuthenticationInfo=======");

        //从token获取到的用户名
        String principal = (String) token.getPrincipal();
        TUser tUser = tUserService.findUserByName(principal);
        if(!ObjectUtils.isEmpty(tUser)){
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    principal,
                    tUser.getPassword(),
                    new SimpleByteSource(tUser.getSalt()),
                    this.getName());

            //将用户存入session
            SecurityUtils.getSubject().getSession().setAttribute("login_user",tUser);

            return authenticationInfo;
        }

        return null;
    }
}
