package com.zholud.usersgroupsrest.service.impl;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.mapper.jpa.impl.group.GroupJpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import com.zholud.usersgroupsrest.repository.GroupJpaRepository;
import com.zholud.usersgroupsrest.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupJpaRepository groupJpaRepository;

    @Autowired
    GroupJpaSymmetricMapper groupJpaSymmetricMapper;

    @Override
    public long createGroup(GroupDto groupDto) {
        return groupJpaRepository.save(groupJpaSymmetricMapper.createEntityFromDto(groupDto)).getGroupId();
    }

    @Override
    public List<GroupDto> findAll() {
        return groupJpaRepository.findAll().stream()
                .map(groupJpaSymmetricMapper::entityToDtoWithUserId)
                .collect(Collectors.toList());
    }

    @Override
    public GroupDto findById(long id) {
        return groupJpaSymmetricMapper.entityToDto(groupJpaRepository.findById(id).get());
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        GroupEntity groupEntity = groupJpaRepository.save(groupJpaSymmetricMapper.dtoToEntity(groupDto));

        return groupJpaSymmetricMapper.entityToDto(groupEntity);
    }
}
