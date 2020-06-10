package com.zholud.usersgroupsrest.service;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    long createGroup(GroupDto groupDto);

    List<GroupDto> findAll();

    GroupDto findById(long id);

    GroupDto updateGroup(GroupDto groupDto);
}
