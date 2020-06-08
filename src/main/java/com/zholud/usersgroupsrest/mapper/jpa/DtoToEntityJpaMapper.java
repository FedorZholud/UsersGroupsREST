package com.zholud.usersgroupsrest.mapper.jpa;

import com.zholud.usersgroupsrest.dto.BaseDto;
import com.zholud.usersgroupsrest.mapper.DtoToEntityMapper;
import com.zholud.usersgroupsrest.model.JpaBaseEntity;

public interface DtoToEntityJpaMapper<EntityT extends JpaBaseEntity, DtoT extends BaseDto> extends DtoToEntityMapper<EntityT, DtoT> {

}
