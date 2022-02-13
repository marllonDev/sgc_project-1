package com.basis.sgcproject.service.mapper;

import com.basis.sgcproject.domain.Senioridade;
import com.basis.sgcproject.service.dto.SenioridadeDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SenioridadeMapper extends EntityMapper<SenioridadeDTO, Senioridade> {
}
