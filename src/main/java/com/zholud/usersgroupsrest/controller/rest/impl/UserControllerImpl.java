package com.zholud.usersgroupsrest.controller.rest.impl;

import com.zholud.usersgroupsrest.controller.rest.UserController;
import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userDto != null
                ? (userDto.getUsername().equals(authentication.getName())
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.FORBIDDEN))
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        try {
            final UserDto user = userService.createUser(userDto);

            return user != null
                    ? new ResponseEntity<>(user, HttpStatus.CREATED)
                    : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @Override
    public ResponseEntity<?> getCurrentUserId() {
        final long id = userService.getCurrentUserId();

        return id != 0
                ? new ResponseEntity<>(id, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<?> checkUsernameExist(String username) {
        return userService.loadUserByUsername(username) != null
                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> findContactsWithMessages() {
        final List<UserDto> userDtos = userService.findContactsWithMessages();

        return userDtos != null && !userDtos.isEmpty()
                ? new ResponseEntity<>(userDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
