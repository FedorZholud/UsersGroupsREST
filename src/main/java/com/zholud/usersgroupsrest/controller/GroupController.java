package com.zholud.usersgroupsrest.controller;

import com.zholud.usersgroupsrest.dto.impl.GroupDto;
import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/groups")
public interface GroupController {

    @PostMapping("/")
    ResponseEntity<?> createGroup(@RequestBody GroupDto groupDto);

    @GetMapping("/")
    ResponseEntity<List<GroupDto>> findAllGroups();

    @GetMapping("/{id}")
    ResponseEntity<GroupDto> findGroupById(@PathVariable("id") long id);

    @PutMapping("/")
    ResponseEntity<GroupDto> updateGroup(@RequestBody GroupDto groupDto);
}
