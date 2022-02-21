package com.basis.sgcproject.resource;

import com.basis.sgcproject.service.TurmaFormacaoService;
import com.basis.sgcproject.service.dto.TurmaFormacaoDto;
import com.basis.sgcproject.service.dto.input.TurmaFormacaoDtoInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TurmaFormacaoResource {

    private final TurmaFormacaoService turmaFormacaoService;

    @GetMapping
    public ResponseEntity<List<TurmaFormacaoDto>> listar() {
        return ResponseEntity.ok(turmaFormacaoService.listarTodas());
    }

    @GetMapping("/{turmaFormacaoId}")
    public ResponseEntity<TurmaFormacaoDto> buscarPeloId(@PathVariable Integer turmaFormacaoId) {
        return ResponseEntity.ok(turmaFormacaoService.buscarPeloId(turmaFormacaoId));
    }

    @PostMapping
    public ResponseEntity<TurmaFormacaoDto> salvar(@RequestBody @Valid TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(turmaFormacaoService.salvar(turmaFormacaoDtoInput));
    }

    @PutMapping("/{turmaFormacaoId}")
    public ResponseEntity<TurmaFormacaoDto> atualizar(@PathVariable Integer turmaFormacaoId, @RequestBody TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
        TurmaFormacaoDto turmaFormacaoDto = turmaFormacaoService.atualizar(turmaFormacaoId, turmaFormacaoDtoInput);
        return ResponseEntity.status(HttpStatus.OK)
                .body(turmaFormacaoDto);
    }

    @DeleteMapping("/{turmaFormacaoId}")
    public ResponseEntity<?> excluir(@PathVariable Integer turmaFormacaoId) {
        turmaFormacaoService.excluir(turmaFormacaoId);
        return ResponseEntity.noContent().build();
    }
}
