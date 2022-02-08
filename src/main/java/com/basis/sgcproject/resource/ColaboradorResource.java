package com.basis.sgcproject.resource;


import com.basis.sgcproject.service.ColaboradorService;
import com.basis.sgcproject.service.dto.ColaboradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador")
@RequiredArgsConstructor
public class ColaboradorResource {
//aqui foi criado uma variável service usando o import da class Colaborador service para que se posssa usar seus serviços.
    private final ColaboradorService service;

    @GetMapping
    public ResponseEntity obterTodos() {
        return ResponseEntity.ok(service.obterTodos());
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ColaboradorDTO colaboradorDTO){
        return ResponseEntity.ok(service.salvar(colaboradorDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity obterPorId(@PathVariable("id")Integer id){
        return ResponseEntity.ok(service.obterPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id")Integer id){
        service.deletar(id);
    }

    @PutMapping
    public ResponseEntity editar(@RequestBody  ColaboradorDTO colaboradorDTO){
        return ResponseEntity.ok(service.salvar(colaboradorDTO));
    }


}
