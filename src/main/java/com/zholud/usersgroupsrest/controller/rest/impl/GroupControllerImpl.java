package com.zholud.usersgroupsrest.controller.rest.impl;

import com.zholud.usersgroupsrest.controller.rest.GroupController;
import com.zholud.usersgroupsrest.dto.impl.GroupDto;
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
    public ResponseEntity<?> createGroup(GroupDto groupDto) {
        final long id = groupService.createGroup(groupDto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GroupDto>> findAllGroups() {
        final List<GroupDto> groupDtos = groupService.findAll();

        return groupDtos != null && !groupDtos.isEmpty()
                ? new ResponseEntity<>(groupDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<GroupDto> findGroupById(long id) {
        final GroupDto groupDto = groupService.findById(id);

        return groupDto != null
                ? new ResponseEntity<>(groupDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<GroupDto> updateGroup(GroupDto groupDto) {
        final GroupDto dto = groupService.updateGroup(groupDto);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
