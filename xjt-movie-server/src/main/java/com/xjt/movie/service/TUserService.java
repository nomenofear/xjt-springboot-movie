package com.xjt.movie.service;

import com.xjt.movie.entity.TPerms;
import com.xjt.movie.entity.TUser;
import com.xjt.movie.utils.RespBean;

import java.util.List;

public interface TUserService {
    TUser findRolesByUsername(String principal);

    List<TPerms> findPermsListByRoleId(Integer roleid);

    TUser findUserByName(String username);

    RespBean registerNewTUser(String username,String password,String email);

    RespBean deleteUserById(String uid);

    RespBean findUserByLikeName(String username);

    RespBean findUserById(String uid);

    RespBean findAllUser();

    TUser findUserByEmail(String email);
}
