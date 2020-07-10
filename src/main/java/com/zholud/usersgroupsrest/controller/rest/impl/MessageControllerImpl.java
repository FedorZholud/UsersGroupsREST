package com.zholud.usersgroupsrest.controller.rest.impl;

import com.zholud.usersgroupsrest.controller.rest.MessageController;
import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;
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
        long id = messageService.createMessage(messageDto);

        return id != 0
                ? new ResponseEntity<>(id, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<MessageDto>> findMessagesToUser(long toUserId) {
        List<MessageDto> messageDtos = messageService.findForToUser(toUserId);

        return messageDtos != null && !messageDtos.isEmpty()
                ? new ResponseEntity<>(messageDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
