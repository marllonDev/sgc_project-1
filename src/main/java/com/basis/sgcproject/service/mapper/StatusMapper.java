package com.basis.sgcproject.service.mapper;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.service.dto.StatusDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper  extends EntityMapper<StatusDTO, Status> {
}
