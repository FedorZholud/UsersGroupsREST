package com.zholud.usersgroupsrest.mapper.jpa.impl.user;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.JpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserJpaSymmetricMapper implements JpaSymmetricMapper<UserEntity, UserDto> {

    @Autowired
    UserEntityToDtoJpaMapper userEntityToDtoJpaMapper;

    @Autowired
    UserDtoToEntityJpaMapper userDtoToEntityJpaMapper;

    @Override
    public UserEntity dtoToEntity(UserDto dto) {
        return userDtoToEntityJpaMapper.dtoToEntity(dto);
    }

    @Override
    public UserDto entityToDto(UserEntity entity) {
        return userEntityToDtoJpaMapper.entityToDto(entity);
    }

    @Override
    public UserEntity createEntityFromDto(UserDto dto) {
        return null;
    }
}
