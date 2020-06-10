package com.zholud.usersgroupsrest.mapper.jpa;

import com.zholud.usersgroupsrest.dto.BaseDto;
import com.zholud.usersgroupsrest.mapper.EntityToDtoMapper;
import com.zholud.usersgroupsrest.model.JpaBaseEntity;

public interface EntityToDtoJpaMapper<EntityT extends JpaBaseEntity, DtoT extends BaseDto> extends EntityToDtoMapper<EntityT, DtoT> {

}
