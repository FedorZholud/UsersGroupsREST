package com.zholud.usersgroupsrest.mapper.jpa.impl.message;

import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.mapper.jpa.DtoToEntityJpaMapper;
import com.zholud.usersgroupsrest.mapper.jpa.EntityToDtoJpaMapper;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class MessageEntityToDtoJpaMapper implements EntityToDtoJpaMapper<MessageEntity, MessageDto> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public MessageDto entityToDto(MessageEntity entity) {
        return MessageDto.builder()
                .id(entity.getId())
                .toUserId(entity.getToUserId())
                .author(entity.getAuthor().getId())
                .message(entity.getMessage())
                .timestamp(dateFormat.format(entity.getTimestamp()))
                .build();
    }
}
