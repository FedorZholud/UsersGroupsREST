package com.zholud.usersgroupsrest.service.impl;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import com.zholud.usersgroupsrest.repository.GroupJpaRepository;
import com.zholud.usersgroupsrest.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupJpaRepository groupJpaRepository;

    @Override
    public long createGroup(GroupEntity groupDto) {
        return groupJpaRepository.save(groupDto).getGroupId();
    }

    @Override
    public List<GroupEntity> findAll() {
        return groupJpaRepository.findAll();
    }
}
