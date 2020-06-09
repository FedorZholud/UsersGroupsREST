package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.dto.impl.UserDto;

import java.util.List;

public interface UserService {

    long createUser(UserDto userDto);

    UserDto findById(long id);

    List<UserDto> findAll();

    long updateUser(UserDto userDto);

    long deleteUser(UserDto userDto);
}
