package com.zholud.usersgroupsrest.controller.rest;

import com.zholud.usersgroupsrest.model.impl.MessageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/messages")
public interface MessageController {

    @PostMapping("/create")
    ResponseEntity<?> createMessage(@RequestBody MessageEntity messageEntity);

    @GetMapping("/touser/{id}")
    ResponseEntity<List<MessageEntity>> findMessagesToUser(@PathVariable("id") long toUserId);
}
