package com.basis.sgcproject.service;

import com.basis.sgcproject.repository.CategoriaRepository;
import com.basis.sgcproject.service.dto.CategoriaDTO;
import com.basis.sgcproject.service.mapper.CategoriaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {


    private final CategoriaMapper categoriaMapper;

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> buscar(){

        return categoriaMapper.toDto(categoriaRepository.findAll());
    }

    public CategoriaDTO buscaId(Integer id){

        return categoriaMapper.toDto(categoriaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Categoria não encontrada!")));
    }

    public CategoriaDTO salvar(CategoriaDTO categoriaDTO){

        return categoriaMapper.toDto(categoriaRepository.save(categoriaMapper.toEntity(categoriaDTO)));

    }

    public void delete(Integer id){

        categoriaRepository.deleteById(id);

    }

}
