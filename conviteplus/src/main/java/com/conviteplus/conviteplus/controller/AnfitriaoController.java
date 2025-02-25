package com.conviteplus.conviteplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conviteplus.conviteplus.dto.EventoComPresentesDTO;
import com.conviteplus.conviteplus.exceptions.AnfitriaoNaoEncontradoException;
import com.conviteplus.conviteplus.model.Anfitriao;
import com.conviteplus.conviteplus.service.AnfitriaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/anfitrioes")
public class AnfitriaoController {
    
    @Autowired
    private AnfitriaoService anfitriaoService;
    
    @PostMapping
    public ResponseEntity<Anfitriao> cadastrarAnfitriao(@RequestBody @Valid Anfitriao anfitriao) {
        Anfitriao criado = anfitriaoService.cadastrarAnfitriao(anfitriao);
        return ResponseEntity.ok(criado);  // Retorna o anfitrião criado com status 200 OK
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Anfitriao> buscarAnfitriaoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(anfitriaoService.buscarPorId(id));
    }

    // Captura a exceção e retorna HTTP 404 Not Found
    @ExceptionHandler(AnfitriaoNaoEncontradoException.class)
    public ResponseEntity<String> tratarAnfitriaoNaoEncontradoException(AnfitriaoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
 // Endpoint para listar anfitrião, evento e presentes
    @GetMapping("/{anfitriaoId}/eventos/{eventoId}")
    public ResponseEntity<EventoComPresentesDTO> buscarEventoComPresentes(
            @PathVariable Long anfitriaoId,
            @PathVariable Long eventoId) {
        EventoComPresentesDTO eventoComPresentes = anfitriaoService.buscarEventoComPresentes(anfitriaoId, eventoId);
        return ResponseEntity.ok(eventoComPresentes);
    }
}
