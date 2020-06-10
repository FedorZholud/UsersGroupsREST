package com.zholud.usersgroupsrest.mapper.jpa.impl.group;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.mapper.jpa.JpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupJpaSymmetricMapper extends GroupEntityToDtoJpaMapper implements JpaSymmetricMapper<GroupEntity, GroupDto> {

    @Autowired
    GroupEntityToDtoJpaMapper groupEntityToDtoJpaMapper;

    @Autowired
    GroupDtoToEntityJpaMapper groupDtoToEntityJpaMapper;

    @Override
    public GroupEntity dtoToEntity(GroupDto dto) {
        return groupDtoToEntityJpaMapper.dtoToEntity(dto);
    }

    @Override
    public GroupDto entityToDto(GroupEntity entity) {
        return groupEntityToDtoJpaMapper.entityToDto(entity);
    }

    @Override
    public GroupEntity createEntityFromDto(GroupDto dto) {
        return groupDtoToEntityJpaMapper.createEntityFromDto(dto);
    }
}