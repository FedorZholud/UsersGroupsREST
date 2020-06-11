package com.zholud.usersgroupsrest.mapper.jpa.impl.group;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.EntityToDtoJpaMapper;
import com.zholud.usersgroupsrest.mapper.jpa.impl.user.UserEntityToDtoJpaMapper;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GroupEntityToDtoJpaMapper implements EntityToDtoJpaMapper<GroupEntity, GroupDto> {

    @Autowired
    UserEntityToDtoJpaMapper userEntityToDtoJpaMapper;

    @Override
    public GroupDto entityToDto(GroupEntity entity) {
        List<UserDto> userDtos = entity.getUserEntities().stream()
                .map(userEntityToDtoJpaMapper::entityToDto)
                .collect(Collectors.toList());

        return GroupDto.builder()
                .groupId(entity.getGroupId())
                .groupName(entity.getGroupName())
                .description(entity.getDescription())
                .userDtos(userDtos)
                .build();
    }

    public GroupDto entityToDtoWithUserId(GroupEntity entity) {
        List<Long> userIds = entity.getUserEntities().stream()
                .map(UserEntity::getId)
                .collect(Collectors.toList());

        return GroupDto.builder()
                .groupId(entity.getGroupId())
                .groupName(entity.getGroupName())
                .description(entity.getDescription())
                .userIds(userIds)
                .build();
    }
}
