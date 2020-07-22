package com.zholud.usersgroupsrest.controller.rest;

import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/messages")
public interface MessageController {

    @PostMapping("/create")
    ResponseEntity<?> createMessage(@RequestBody MessageDto messageDto);

    @GetMapping("/with/{id}")
    ResponseEntity<List<MessageDto>> findMessagesWithUser(@PathVariable("id") long withUserId);

    @GetMapping("/first_with/{id}")
    ResponseEntity<MessageDto> findFirstMessageWithUser(@PathVariable("id") long withUserId);
}
