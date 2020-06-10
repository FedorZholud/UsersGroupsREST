package com.zholud.usersgroupsrest.service.impl;

import com.zholud.usersgroupsrest.dto.impl.UserDto;
import com.zholud.usersgroupsrest.mapper.jpa.impl.user.UserJpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.repository.UserJpaRepository;
import com.zholud.usersgroupsrest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public long createUser(UserDto userDto) {
        try {
            return userJpaRepository.save(userJpaSymmetricMapper.dtoToEntity(userDto)).getId();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public UserDto findById(long id) {
        try {
            return userJpaSymmetricMapper.entityToDto(userJpaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Not found Entity with id: " + id)));
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    @Override
    public List<UserDto> findAll() {
        return userJpaRepository.findAll().stream()
                .map(userJpaSymmetricMapper::entityToDto)
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
}
