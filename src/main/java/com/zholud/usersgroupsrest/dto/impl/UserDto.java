package com.zholud.usersgroupsrest.dto.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zholud.usersgroupsrest.dto.BaseDto;
import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto extends BaseDto {

    @Getter
    private final long id;

    @Getter
    private final String firstName;

    @Getter
    private final String lastName;

    @Getter
    private final long groupId;

    @SuppressWarnings("unused")
    private UserDto() {
        this(0, null, null, 0);
    }
}
