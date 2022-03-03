package com.basis.sgcproject.resource;

import com.basis.sgcproject.service.CategoriaService;
import com.basis.sgcproject.service.dto.CategoriaDTO;
import com.basis.sgcproject.service.dto.DropdownDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaResource {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<DropdownDTO>> buscar(){
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
