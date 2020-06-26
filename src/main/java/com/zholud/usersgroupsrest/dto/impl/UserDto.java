package com.zholud.usersgroupsrest.dto.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zholud.usersgroupsrest.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(Include.NON_NULL)
public class UserDto extends BaseDto {

    @Getter
    private final long id;

    @Getter
    private final String firstName;

    @Getter
    private final String lastName;

    @Getter
    private final long groupId;

    @Getter
    private final String username;

    @Getter
    private final String password;

    @Getter
    @JsonInclude(Include.NON_EMPTY)
    private final Set<UserDto> contacts;

    @SuppressWarnings("unused")
    private UserDto() {
        this(0, null, null, 0, null, null, null);
    }
}
