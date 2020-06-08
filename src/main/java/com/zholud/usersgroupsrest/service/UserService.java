package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.model.impl.UserEntity;

import java.util.List;

public interface UserService {

    long createUser(UserEntity userEntity);

    UserEntity findById(long id);

    List<UserEntity> findAll();

    long updateUser(UserEntity userEntity);

    long deleteUser(UserEntity userEntity);
}
