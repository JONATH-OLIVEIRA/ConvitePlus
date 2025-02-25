package com.conviteplus.conviteplus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.conviteplus.conviteplus.dto.PresenteDTO;
import com.conviteplus.conviteplus.service.PresenteService;

import java.util.List;

@RestController
@RequestMapping("/eventos/{eventoId}/presentes")
public class PresenteController {

    private final PresenteService presenteService;

    public PresenteController(PresenteService presenteService) {
        this.presenteService = presenteService;
    }

    @PostMapping
    public ResponseEntity<List<PresenteDTO>> adicionarListaDePresentes(
            @PathVariable Long eventoId,
            @RequestBody List<PresenteDTO> presentesDTO) {
        List<PresenteDTO> listaCriada = presenteService.adicionarListaDePresentes(eventoId, presentesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(listaCriada);
    }

    @GetMapping
    public ResponseEntity<List<PresenteDTO>> listarPresentesPorEvento(@PathVariable Long eventoId) {
        List<PresenteDTO> presentes = presenteService.listarPresentesPorEvento(eventoId);
        return ResponseEntity.ok(presentes);
    }
}
