package com.basis.sgcproject.resource;


import com.basis.sgcproject.service.ColaboradorService;
import com.basis.sgcproject.service.dto.ColaboradorCompetenciaListNivelDTO;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import com.basis.sgcproject.service.dto.ColaboradorSenioridadeListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ColaboradorResource {

    private final ColaboradorService service;

    @GetMapping
    public ResponseEntity<List<ColaboradorSenioridadeListDTO>> obterTodos() {
        return ResponseEntity.ok(service.obterTodos());
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> salvar( @RequestBody ColaboradorDTO colaboradorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(colaboradorDTO));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> obterPorId( @PathVariable("id")Integer id){
        return ResponseEntity.ok(service.obterPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id")Integer id){
            service.deletar(id);
    }


    @PutMapping
    public ResponseEntity<ColaboradorDTO> editar( @RequestBody  ColaboradorDTO colaboradorDTO){
        return ResponseEntity.ok(service.salvar(colaboradorDTO));
    }

    @GetMapping("/competencia/{idCompetencia}")
    public ResponseEntity<List<ColaboradorDTO>> obterListaColaboradorPorCompetencia(@PathVariable("idCompetencia") Integer idCompetencia) {
        return ResponseEntity.ok(service.findAllColaboradorPorCompetencia(idCompetencia));
    }

    @GetMapping("/nivel")
    public ResponseEntity<List<ColaboradorCompetenciaListNivelDTO>> obterListaColaboradorPorCompetenciaNivel() {
        return ResponseEntity.ok(service.buscarColaboradorCompetenciaNivel());
    }
}
