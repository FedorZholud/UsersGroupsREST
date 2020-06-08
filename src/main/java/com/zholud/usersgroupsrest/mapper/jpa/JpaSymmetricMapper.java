package com.zholud.usersgroupsrest.mapper.jpa;

import com.zholud.usersgroupsrest.dto.BaseDto;
import com.zholud.usersgroupsrest.mapper.SymmetricMapper;
import com.zholud.usersgroupsrest.model.JpaBaseEntity;

public interface JpaSymmetricMapper<EntityT extends JpaBaseEntity, DtoT extends BaseDto> extends SymmetricMapper<EntityT, DtoT> {

}
