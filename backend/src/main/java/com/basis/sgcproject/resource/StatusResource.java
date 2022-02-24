package com.basis.sgcproject.resource;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.service.StatusService;
import com.basis.sgcproject.service.dto.CompetenciaDTO;
import com.basis.sgcproject.service.dto.StatusDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StatusResource {
    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusDTO>> listar(){

        return ResponseEntity.ok(statusService.buscar());

    }

}
