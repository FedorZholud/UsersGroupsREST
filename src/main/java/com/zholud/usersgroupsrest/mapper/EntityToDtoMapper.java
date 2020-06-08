package com.zholud.usersgroupsrest.mapper;

import com.zholud.usersgroupsrest.dto.Dto;
import com.zholud.usersgroupsrest.model.Entity;

@FunctionalInterface
public interface EntityToDtoMapper<EntityT extends Entity, DtoT extends Dto> {

    DtoT entityToDto(EntityT entity);
}
