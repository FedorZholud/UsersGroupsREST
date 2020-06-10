package com.zholud.usersgroupsrest.mapper;

import com.zholud.usersgroupsrest.dto.Dto;
import com.zholud.usersgroupsrest.model.Entity;

public interface SymmetricMapper<EntityT extends Entity, DtoT extends Dto> extends EntityToDtoMapper<EntityT, DtoT>, DtoToEntityMapper<EntityT, DtoT> {

}
