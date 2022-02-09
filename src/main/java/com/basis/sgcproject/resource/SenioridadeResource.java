package com.basis.sgcproject.resource;

import com.basis.sgcproject.domain.Senioridade;
import com.basis.sgcproject.service.SenioridadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/senioridades")
@AllArgsConstructor

public class SenioridadeResource {
    private final SenioridadeService senioridadeService;

    @GetMapping
    public ResponseEntity<List<Senioridade>> listarTodas() {

        return ResponseEntity.ok().body(senioridadeService.listarTodas());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Senioridade> buscarId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(senioridadeService.buscarId(id));
    }


}