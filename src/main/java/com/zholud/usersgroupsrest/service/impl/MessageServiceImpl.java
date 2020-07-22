package com.zholud.usersgroupsrest.service.impl;

import com.zholud.usersgroupsrest.dto.impl.MessageDto;
import com.zholud.usersgroupsrest.mapper.jpa.impl.message.MessageJpaSymmetricMapper;
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
import java.util.stream.Collectors;

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

    @Autowired
    MessageJpaSymmetricMapper messageJpaSymmetricMapper;

    @Override
    public List<MessageDto> findMessagesWithUser(long withUserId) {
        UserEntity userEntity = userJpaSymmetricMapper.dtoToEntity(userService.getCurrentUser());
        UserEntity fromUser = userJpaSymmetricMapper.dtoToEntity(userService.findById(withUserId));
        return userEntity != null && fromUser != null
                ? messageJpaRepository.findByAuthorAndToUserIdOrAuthorAndToUserIdOrderByTimestamp(userEntity, withUserId, fromUser, userEntity.getId()).stream().map(messageJpaSymmetricMapper::entityToDto).collect(Collectors.toList())
                : null;
    }

    @Override
    public long createMessage(MessageDto messageDto) {
//        messageDto.setAuthor(userJpaSymmetricMapper.dtoToEntity(userService.getCurrentUser()));
//        return messageJpaRepository.save(messageEntity).getId();

        return messageJpaRepository.save(messageJpaSymmetricMapper.createEntityFromDto(messageDto)).getId();
    }

    @Override
    public MessageDto findFirstMessageWithUser(long withUserId) {
        UserEntity userEntity = userJpaSymmetricMapper.dtoToEntity(userService.getCurrentUser());
        UserEntity fromUser = userJpaSymmetricMapper.dtoToEntity(userService.findById(withUserId));

        return userEntity != null && fromUser != null
                ? messageJpaSymmetricMapper.entityToDto(messageJpaRepository.findFirstByAuthorAndToUserIdOrAuthorAndToUserIdOrderByTimestampDesc(userEntity, withUserId, fromUser, userEntity.getId()))
                : null;
    }
}
