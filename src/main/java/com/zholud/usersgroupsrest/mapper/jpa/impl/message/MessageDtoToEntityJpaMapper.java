package com.zholud.usersgroupsrest.mapper.jpa.impl.message;

import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.mapper.jpa.DtoToEntityJpaMapper;
import com.zholud.usersgroupsrest.mapper.jpa.impl.user.UserJpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;
import com.zholud.usersgroupsrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDtoToEntityJpaMapper implements DtoToEntityJpaMapper<MessageEntity, MessageDto> {

    @Autowired
    UserService userService;

    @Autowired
    UserJpaSymmetricMapper userJpaSymmetricMapper;

    @Override
    public MessageEntity dtoToEntity(MessageDto dto) {
        return null;
    }

    @Override
    public MessageEntity createEntityFromDto(MessageDto dto) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setToUserId(dto.getToUserId());
        messageEntity.setAuthor(userJpaSymmetricMapper.dtoToEntity(userService.getCurrentUser()));
        messageEntity.setMessage(dto.getMessage());
        return messageEntity;
    }
}
