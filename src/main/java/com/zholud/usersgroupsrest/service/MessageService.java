package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;

import java.util.List;

public interface MessageService {

    List<MessageDto> findForToUser(long toUserId);

    long createMessage(MessageDto messageDto);
}
