package com.zholud.usersgroupsrest.controller.impl;

import com.zholud.usersgroupsrest.controller.UserController;
import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        final List<UserDto> userDtos = userService.findAll();

        return userDtos != null && !userDtos.isEmpty()
                ? new ResponseEntity<>(userDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<UserDto> findById(long id) {
        final UserDto userDto = userService.findById(id);

        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public long createUser(UserDto userDto) {
        return userService.createUser(userDto);
    }
}
