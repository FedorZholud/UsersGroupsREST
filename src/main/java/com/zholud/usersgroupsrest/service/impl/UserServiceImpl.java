package com.zholud.usersgroupsrest.service.impl;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.impl.user.UserJpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.repository.UserJpaRepository;
import com.zholud.usersgroupsrest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpaSymmetricMapper userJpaSymmetricMapper;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userJpaRepository.findByUsername(userName);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userJpaRepository.save(userJpaSymmetricMapper.createEntityFromDto(userDto));
        return userJpaSymmetricMapper.entityToDto(userEntity);
    }

    @Override
    public UserDto findById(long id) {
        try {
            return userJpaSymmetricMapper.entityToDto(userJpaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Not found Entity with id: " + id)));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserDto> findAll() {
        return userJpaRepository.findAll().stream()
                .map(userJpaSymmetricMapper::entityToDtoWithoutContacts)
                .collect(Collectors.toList());
    }

    @Override
    public long updateUser(UserDto userDto) {
        try {
            UserEntity userEntity = userJpaSymmetricMapper.dtoToEntity(userDto);

            if (userDto.getId() == userEntity.getId()) {
                return userJpaRepository.save(userEntity).getId();
            }

            throw new EntityNotFoundException("Not found Entity with id: " + userDto.getId());

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public long deleteUser(long id) {
        try {
            userJpaRepository.deleteById(id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public UserDto addContact(long contactId, UserDto userDto) {
        UserEntity userEntity = userJpaSymmetricMapper.dtoToEntity(userDto);
        userEntity.getContacts().add(userJpaRepository.findById(contactId).get());

        return userJpaSymmetricMapper.entityToDto(userJpaRepository.save(userEntity));
    }

    @Override
    public UserDto removeContact(long contactId, UserDto userDto) {
        UserEntity userEntity = userJpaSymmetricMapper.dtoToEntity(userDto);
        userEntity.getContacts().remove(userJpaRepository.findById(contactId).get());

        return userJpaSymmetricMapper.entityToDto(userJpaRepository.save(userEntity));
    }

    @Override
    public long getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        return authentication != null ? ((UserEntity) authentication.getPrincipal()).getId() : 0;
    }
}
