package com.zholud.usersgroupsrest.dto.impl;

import com.zholud.usersgroupsrest.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;

@Builder
public class UserDto extends BaseDto {

    @Getter
    private final long id;

    @Getter
    private final String firstName;

    @Getter
    private final String lastName;

    @Getter
    private final long groupId;
}
