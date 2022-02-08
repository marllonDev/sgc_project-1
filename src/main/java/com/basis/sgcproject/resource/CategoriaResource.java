package com.basis.sgcproject.resource;

import com.basis.sgcproject.domain.Categoria;
import com.basis.sgcproject.service.CategoriaService;
import com.basis.sgcproject.service.dto.CategoriaDTO;
import jdk.jfr.internal.Repository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaResource {

    private final CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscar(){

        return ResponseEntity.ok(categoriaService.buscar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarId(@PathVariable Integer id){

        return ResponseEntity.ok(categoriaService.buscaId(id));

    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> salvar(@RequestBody CategoriaDTO categoriaDTO){

         return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.salvar(categoriaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){

        categoriaService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> atualizar(@RequestBody CategoriaDTO categoriaDTO){


        return ResponseEntity.ok(categoriaService.salvar(categoriaDTO));

    }
}
