package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;

import java.util.List;

public interface MessageService {

    List<MessageDto> findMessagesWithUser(long withUserId);

    long createMessage(MessageDto messageDto);

    MessageDto findFirstMessageWithUser(long withUserId);
}
