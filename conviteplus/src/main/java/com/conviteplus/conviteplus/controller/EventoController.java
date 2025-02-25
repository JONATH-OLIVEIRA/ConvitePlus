package com.conviteplus.conviteplus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conviteplus.conviteplus.dto.EventoDTO;
import com.conviteplus.conviteplus.model.Evento;
import com.conviteplus.conviteplus.service.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    // Endpoint para criar um evento
    @PostMapping("/{anfitriaoId}")
    public ResponseEntity<EventoDTO> criarEvento(@PathVariable Long anfitriaoId, @RequestBody @Valid EventoDTO eventoDTO) {
        Evento eventoCriado = eventoService.criarEvento(anfitriaoId, eventoDTO);

        // Converter o Evento para DTO para responder com os dados de forma controlada
        EventoDTO responseDTO = new EventoDTO(
                eventoCriado.getId(),
                eventoCriado.getTitulo(),
                eventoCriado.getDescricao(),
                eventoCriado.getDataHora(),
                eventoCriado.getLocal(),
                eventoCriado.getAnfitriao().getId()  // Apenas o ID do anfitrião
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // Endpoint para exibir evento
    @GetMapping("/{eventoId}")
    public ResponseEntity<EventoDTO> getEvento(@PathVariable Long eventoId) {
        Evento evento = eventoService.encontrarEventoPorId(eventoId);

        // Converter o Evento para DTO para retornar os dados controlados
        EventoDTO responseDTO = new EventoDTO(
                evento.getId(),
                evento.getTitulo(),
                evento.getDescricao(),
                evento.getDataHora(),
                evento.getLocal(),
                evento.getAnfitriao().getId()  // Apenas o ID do anfitrião
        );

        return ResponseEntity.ok(responseDTO);
    }
}
