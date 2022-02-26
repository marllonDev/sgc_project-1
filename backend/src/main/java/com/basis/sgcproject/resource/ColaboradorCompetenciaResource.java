package com.basis.sgcproject.resource;


import com.basis.sgcproject.service.ColaboradorCompetenciaService;
import com.basis.sgcproject.service.ColaboradorService;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaborador-competencia")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ColaboradorCompetenciaResource {

    private final ColaboradorCompetenciaService service;

    @GetMapping
    public ResponseEntity<List<ColaboradorCompetenciaListNivelDTO>> obterTodos() {
        return ResponseEntity.ok(service.buscar());
    }

    @PostMapping
    public ResponseEntity<ColaboradorCompetenciaListNivelDTO> salvar(@RequestBody ColaboradorCompetenciaNivelDTO colaboradorCompetenciaNivelDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(colaboradorCompetenciaNivelDTO));

    }
}