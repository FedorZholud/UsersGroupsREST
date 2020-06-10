package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;

import java.util.List;

public interface GroupService {

    long createGroup(GroupEntity groupDto);

    List<GroupEntity> findAll();
}
