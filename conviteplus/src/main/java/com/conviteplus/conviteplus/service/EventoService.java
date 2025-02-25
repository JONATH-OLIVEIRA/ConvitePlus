package com.conviteplus.conviteplus.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.conviteplus.conviteplus.model.Anfitriao;
import com.conviteplus.conviteplus.model.Evento;
import com.conviteplus.conviteplus.repository.AnfitriaoRepository;
import com.conviteplus.conviteplus.repository.EventoRepository;

import jakarta.transaction.Transactional;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;
    private final AnfitriaoRepository anfitriaoRepository;

    public EventoService(EventoRepository eventoRepository, AnfitriaoRepository anfitriaoRepository) {
        this.eventoRepository = eventoRepository;
        this.anfitriaoRepository = anfitriaoRepository;
    }

    @Transactional
    public Evento criarEvento(Long anfitriaoId, Evento evento) {
        Anfitriao anfitriao = anfitriaoRepository.findById(anfitriaoId)
                .orElseThrow(() -> new RuntimeException("Anfitrião não encontrado"));
        evento.setAnfitriao(anfitriao);
        return eventoRepository.save(evento);
    }

   
}