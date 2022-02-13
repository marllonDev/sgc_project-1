package com.basis.sgcproject.resource;

import com.basis.sgcproject.service.TurmaFormacaoService;
import com.basis.sgcproject.service.dto.TurmaFormacaoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@AllArgsConstructor
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
    public ResponseEntity<TurmaFormacaoDto> salvar(@RequestBody @Valid TurmaFormacaoDto turmaFormacaoDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(turmaFormacaoService.salvar(turmaFormacaoDto));
    }

    @PutMapping("/{turmaFormacaoId}")
    public ResponseEntity<TurmaFormacaoDto> atualizar(@PathVariable Integer turmaFormacaoId, @RequestBody TurmaFormacaoDto turmaFormacaoDto) {
        turmaFormacaoDto = turmaFormacaoService.atualizar(turmaFormacaoId, turmaFormacaoDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(turmaFormacaoDto);
    }

    @DeleteMapping("/{turmaFormacaoId}")
    public ResponseEntity<?> excluir(@PathVariable Integer turmaFormacaoId) {
        turmaFormacaoService.excluir(turmaFormacaoId);
        return ResponseEntity.noContent().build();
    }
}
