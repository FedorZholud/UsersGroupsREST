package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto findById(long id);

    List<UserDto> findAll();

    long updateUser(UserDto userDto);

    long deleteUser(long id);

    UserDto addContact(long contactId, UserDto userDto);

    UserDto removeContact(long contactId, UserDto userDto);
}
