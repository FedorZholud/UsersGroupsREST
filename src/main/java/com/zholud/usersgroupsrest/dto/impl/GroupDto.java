package com.zholud.usersgroupsrest.dto.impl;

import com.zholud.usersgroupsrest.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
public class GroupDto extends BaseDto {

    @Getter
    private final long groupId;

    @Getter
    private final String groupName;

    @Getter
    private final String description;

    @Getter
    private final List<UserDto> userDtos;

    @Getter
    private final List<Long> userIds;

    @SuppressWarnings("unused")
    private GroupDto() {
        this(0,null,null,null, null);
    }
}
