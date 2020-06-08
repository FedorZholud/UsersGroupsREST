package com.zholud.usersgroupsrest.service.impl;

import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.repository.UserJpaRepository;
import com.zholud.usersgroupsrest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public long createUser(UserEntity userEntity) {
        return userJpaRepository.save(userEntity).getId();
    }

    @Override
    public UserEntity findById(long id) {
        return userJpaRepository.getOne(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public long updateUser(UserEntity userEntity) {
        return userJpaRepository.save(userEntity).getId();
    }

    @Override
    public long deleteUser(UserEntity userEntity) {
        userJpaRepository.delete(userEntity);
        return userEntity.getId();
    }
}
