package com.zholud.usersgroupsrest.mapper.jpa.impl.user;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.DtoToEntityJpaMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntityJpaMapper implements DtoToEntityJpaMapper<UserEntity, UserDto> {

    @Override
    public UserEntity dtoToEntity(UserDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setGroupId(dto.getGroupId());

        return userEntity;
    }
}
