package com.zholud.usersgroupsrest.repository;

import com.zholud.usersgroupsrest.model.impl.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJpaRepository extends JpaRepository<GroupEntity, Long> {
}
