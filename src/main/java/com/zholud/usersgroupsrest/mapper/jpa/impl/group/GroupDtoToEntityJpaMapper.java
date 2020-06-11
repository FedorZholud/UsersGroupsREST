package com.zholud.usersgroupsrest.mapper.jpa.impl.group;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.mapper.jpa.DtoToEntityJpaMapper;
import com.zholud.usersgroupsrest.mapper.jpa.impl.user.UserDtoToEntityJpaMapper;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.repository.GroupJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class GroupDtoToEntityJpaMapper implements DtoToEntityJpaMapper<GroupEntity, GroupDto> {

    @Autowired
    GroupJpaRepository groupJpaRepository;

    @Override
    public GroupEntity dtoToEntity(GroupDto dto) {
        GroupEntity groupEntity = groupJpaRepository.findById(dto.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("Not found Entity with id: " + dto.getGroupId()));
        groupEntity.setGroupName(dto.getGroupName());
        groupEntity.setDescription(dto.getDescription());

        return groupEntity;
    }

    @Override
    public GroupEntity createEntityFromDto(GroupDto dto) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupName(dto.getGroupName());
        groupEntity.setDescription(dto.getDescription());

        return groupEntity;
    }
}
