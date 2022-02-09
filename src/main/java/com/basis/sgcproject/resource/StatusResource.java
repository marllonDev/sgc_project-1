package com.basis.sgcproject.resource;

import com.basis.sgcproject.domain.Status;
import com.basis.sgcproject.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/status")
@AllArgsConstructor
public class StatusResource {

    StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> listarTodas() {

        return ResponseEntity.ok().body(statusService.listarTodas());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Status> buscarId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(statusService.buscarId(id));
    }


}
