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
    public ResponseEntity<?> createUser(UserDto userDto) {
        final long id = userService.createUser(userDto);

        return id != 0
                ? new ResponseEntity<>(id, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateUser(UserDto userDto) {
        final long userId = userService.updateUser(userDto);

        return userId != 0
                ? new ResponseEntity<>(userId, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteUser(long id) {
        long userId = userService.deleteUser(id);

        return userId != 0
                ? new ResponseEntity<>(userId, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<UserEntity> addContact(long contactId, UserEntity userEntity) {
        final UserEntity entity = userService.addContact(contactId, userEntity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
