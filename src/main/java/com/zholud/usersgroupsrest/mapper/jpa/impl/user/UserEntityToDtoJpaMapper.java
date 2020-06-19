package com.zholud.usersgroupsrest.mapper.jpa.impl.user;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.EntityToDtoJpaMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserEntityToDtoJpaMapper implements EntityToDtoJpaMapper<UserEntity, UserDto> {

    @Override
    public UserDto entityToDto(UserEntity entity) {
        Set<UserDto> contacts = entity.getContacts().stream()
                .map(this::contactsToDto)
                .collect(Collectors.toSet());

        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .groupId(entity.getGroupId())
                .username(entity.getUsername())
                .contacts(contacts)
                .build();
    }

    private UserDto contactsToDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .groupId(entity.getGroupId())
                .username(entity.getUsername())
                .build();
    }
}
