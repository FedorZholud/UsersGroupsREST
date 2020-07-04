package com.zholud.usersgroupsrest.service.impl;

import com.zholud.usersgroupsrest.mapper.jpa.impl.user.UserJpaSymmetricMapper;
import com.zholud.usersgroupsrest.model.impl.MessageEntity;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import com.zholud.usersgroupsrest.repository.MessageJpaRepository;
import com.zholud.usersgroupsrest.service.MessageService;
import com.zholud.usersgroupsrest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageJpaRepository messageJpaRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserJpaSymmetricMapper userJpaSymmetricMapper;

    @Override
    public List<MessageEntity> findForToUser(long toUserId) {
        UserEntity userEntity = userJpaSymmetricMapper.dtoToEntity(userService.getCurrentUser());
        return userEntity != null ? messageJpaRepository.findByAuthorAndToUserId(userEntity, toUserId) : null;
    }

    @Override
    public long createMessage(MessageEntity messageEntity) {
        messageEntity.setAuthor(userJpaSymmetricMapper.dtoToEntity(userService.getCurrentUser()));
        return messageJpaRepository.save(messageEntity).getId();
    }
}
