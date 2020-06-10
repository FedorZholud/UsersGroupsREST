package com.zholud.usersgroupsrest.controller;

import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/groups")
public interface GroupController {

    @PostMapping("/")
    ResponseEntity<?> createGroup(GroupEntity groupEntity);

    @GetMapping("/")
    ResponseEntity<List<GroupEntity>> findAllGroups();
}
