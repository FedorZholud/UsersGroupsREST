package com.zholud.usersgroupsrest.repository;

import com.zholud.usersgroupsrest.model.impl.MessageEntity;
import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageJpaRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findByAuthorAndToUserId(UserEntity author, long toUserId);
}
