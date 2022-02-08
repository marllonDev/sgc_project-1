package com.basis.sgcproject.service.mapper;


import com.basis.sgcproject.domain.Colaborador;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador>{

}
