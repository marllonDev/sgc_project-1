package com.basis.sgcproject.resource;

import com.basis.sgcproject.domain.Senioridade;
import com.basis.sgcproject.service.SenioridadeService;
import com.basis.sgcproject.service.dto.SenioridadeDTO;
import com.basis.sgcproject.service.dto.StatusDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/senioridades")
@AllArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService senioridadeService;

    @GetMapping
    public ResponseEntity<List<SenioridadeDTO>> buscar(){

        return ResponseEntity.ok(senioridadeService.buscar());

    }
}
