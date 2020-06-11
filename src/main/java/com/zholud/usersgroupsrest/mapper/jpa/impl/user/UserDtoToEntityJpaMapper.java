package com.zholud.usersgroupsrest.mapper.jpa.impl.user;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.DtoToEntityJpaMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class UserDtoToEntityJpaMapper implements DtoToEntityJpaMapper<UserEntity, UserDto> {

    @Autowired
    UserJpaRepository userJpaRepository;

    @Override
    public UserEntity dtoToEntity(UserDto dto) {
        try {
            UserEntity userEntity = userJpaRepository.findById(dto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Not found Entity with id: " + dto.getId()));
            userEntity.setFirstName(dto.getFirstName());
            userEntity.setLastName(dto.getLastName());
            userEntity.setGroupId(dto.getGroupId());

            return userEntity;

        } catch (Exception e) {
            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName(dto.getFirstName());
            userEntity.setLastName(dto.getLastName());
            userEntity.setGroupId(dto.getGroupId());

            return userEntity;
        }
    }

    @Override
    public UserEntity createEntityFromDto(UserDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setGroupId(dto.getGroupId());

        return userEntity;
    }
}
