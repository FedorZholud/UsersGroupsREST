package com.zholud.usersgroupsrest.controller.rest.impl;

import com.zholud.usersgroupsrest.controller.rest.MessageController;
import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageControllerImpl implements MessageController {

    @Autowired
    MessageService messageService;

    @Override
    public ResponseEntity<?> createMessage(MessageDto messageDto) {
        final long id = messageService.createMessage(messageDto);

        return id != 0
                ? new ResponseEntity<>(id, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<MessageDto>> findMessagesWithUser(long withUserId) {
        final List<MessageDto> messageDtos = messageService.findMessagesWithUser(withUserId);

        return messageDtos != null && !messageDtos.isEmpty()
                ? new ResponseEntity<>(messageDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<MessageDto> findFirstMessageWithUser(long withUserId) {
        final MessageDto message = messageService.findFirstMessageWithUser(withUserId);

        return message != null
                ? new ResponseEntity<>(message, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
