package com.zholud.usersgroupsrest.mapper;

import com.zholud.usersgroupsrest.dto.Dto;
import com.zholud.usersgroupsrest.model.Entity;

@FunctionalInterface
public interface DtoToEntityMapper<EntityT extends Entity, DtoT extends Dto> {

    EntityT dtoToEntity(DtoT dto);
}
