package com.conviteplus.conviteplus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conviteplus.conviteplus.dto.PresenteDTO;
import com.conviteplus.conviteplus.service.PresenteService;

@RestController
@RequestMapping("/presentes")
public class PresenteController {

    private final PresenteService presenteService;

    public PresenteController(PresenteService presenteService) {
        this.presenteService = presenteService;
    }

    @PostMapping
    public ResponseEntity<PresenteDTO> criarPresente(@RequestBody PresenteDTO presenteDTO) {
        PresenteDTO presenteCriado = presenteService.adicionarPresente(presenteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(presenteCriado); 
    }

    @GetMapping("/{presenteId}")
    public ResponseEntity<PresenteDTO> getPresente(@PathVariable Long presenteId) {
        PresenteDTO presenteDTO = presenteService.encontrarPresentePorId(presenteId);
        return ResponseEntity.ok(presenteDTO);
    }
}
