package com.zholud.usersgroupsrest.dto.impl;

import com.zholud.usersgroupsrest.dto.BaseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageDto extends BaseDto {

    @Getter
    private final long id;

    @Getter
    private final long toUserId;

    @Getter
    private final long author;

    @Getter
    private final String message;

    @Getter
    private final String timestamp;

    @SuppressWarnings("unused")
    private MessageDto() {
        this(0, 0, 0, null, null);
    }
}
