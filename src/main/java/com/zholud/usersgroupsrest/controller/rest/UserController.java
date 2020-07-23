package com.zholud.usersgroupsrest.controller.rest;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
public interface UserController {

    @GetMapping("/")
    ResponseEntity<List<UserDto>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<UserDto> findById(@PathVariable("id") long id);

    @PostMapping("/add_user")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

    @PutMapping("/")
    ResponseEntity<?> updateUser(@RequestBody UserDto userDto);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") long id);

    @GetMapping("/contacts/add/{contact}")
    ResponseEntity<UserDto> addContact(
            @PathVariable("contact") long conactId,
            @RequestBody UserDto userDto
    );

    @GetMapping("/contacts/remove/{contact}")
    ResponseEntity<UserDto> removeContact(
            @PathVariable("contact") long conactId,
            @RequestBody UserDto userDto
    );

    @GetMapping("/currentuserId")
    ResponseEntity<?> getCurrentUserId();

    @GetMapping("/currentuser")
    ResponseEntity<UserDto> getCurrentUser();

    @PostMapping("/username_exist")
    ResponseEntity<?> checkUsernameExist(@RequestParam("username") String username);

    @GetMapping("/contacts/withmessages")
    ResponseEntity<List<UserDto>> findContactsWithMessages();
}