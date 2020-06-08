package com.zholud.usersgroupsrest.mapper.jpa.impl.user;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.EntityToDtoJpaMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToDtoJpaMapper implements EntityToDtoJpaMapper<UserEntity, UserDto> {

    @Override
    public UserDto entityToDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .groupId(entity.getGroupId())
                .build();
    }
}
