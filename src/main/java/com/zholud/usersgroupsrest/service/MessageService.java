package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.model.impl.MessageEntity;

import java.util.List;

public interface MessageService {

    List<MessageEntity> findForToUser(long toUserId);

    long createMessage(MessageEntity messageEntity);
}
