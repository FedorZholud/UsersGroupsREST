package com.zholud.usersgroupsrest.controller.impl;

import com.zholud.usersgroupsrest.controller.GroupController;
import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import com.zholud.usersgroupsrest.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupControllerImpl implements GroupController {

    @Autowired
    GroupService groupService;

    @Override
    public ResponseEntity<?> createGroup(GroupEntity groupEntity) {
        final long id = groupService.createGroup(groupEntity);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GroupEntity>> findAllGroups() {
        final List<GroupEntity> groupEntities = groupService.findAll();

        return groupEntities != null && !groupEntities.isEmpty()
                ? new ResponseEntity<>(groupEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
