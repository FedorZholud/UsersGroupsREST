package com.zholud.usersgroupsrest.mapper.jpa.impl.message;

import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.mapper.jpa.JpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageJpaSymmetricMapper implements JpaSymmetricMapper<MessageEntity, MessageDto> {

    @Autowired
    MessageDtoToEntityJpaMapper messageDtoToEntityJpaMapper;

    @Autowired
    MessageEntityToDtoJpaMapper messageEntityToDtoJpaMapper;

    @Override
    public MessageEntity dtoToEntity(MessageDto dto) {
        return null;
    }

    @Override
    public MessageEntity createEntityFromDto(MessageDto dto) {
        return messageDtoToEntityJpaMapper.createEntityFromDto(dto);
    }

    @Override
    public MessageDto entityToDto(MessageEntity entity) {
        return messageEntityToDtoJpaMapper.entityToDto(entity);
    }
}
