package com.zholud.usersgroupsrest.repository;

import com.zholud.usersgroupsrest.model.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String userName);
}
