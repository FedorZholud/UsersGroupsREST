package com.zholud.usersgroupsrest.controller.rest.impl;

import com.zholud.usersgroupsrest.controller.rest.UserController;
import com.zholud.usersgroupsrest.dto.impl.UserDto;
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
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        final UserDto user = userService.createUser(userDto);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.CREATED)
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
    public ResponseEntity<UserDto> addContact(long contactId, UserDto userDto) {
        final UserDto dto = userService.addContact(contactId, userDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> removeContact(long contactId, UserDto userDto) {
        final UserDto dto = userService.removeContact(contactId, userDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
