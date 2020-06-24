package com.zholud.usersgroupsrest.mapper.jpa.impl.user;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.DtoToEntityJpaMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDtoToEntityJpaMapper implements DtoToEntityJpaMapper<UserEntity, UserDto> {

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserEntity dtoToEntity(UserDto dto) {

        UserEntity userEntity = userJpaRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Not found Entity with id: " + dto.getId()));
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setGroupId(dto.getGroupId());

        if (dto.getContacts() != null) {
            Set<UserEntity> contacts = dto.getContacts().stream()
                    .map(this::contactsToEntity)
                    .collect(Collectors.toSet());

            userEntity.setContacts(contacts);
        }

        return userEntity;
    }

    @Override
    public UserEntity createEntityFromDto(UserDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setGroupId(dto.getGroupId());
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userEntity;
    }

    private UserEntity contactsToEntity(UserDto dto) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(dto.getId());
//        userEntity.setFirstName(dto.getFirstName());
//        userEntity.setLastName(dto.getLastName());
//        userEntity.setGroupId(dto.getGroupId());

        return userJpaRepository.findById(dto.getId()).get();
    }
}
