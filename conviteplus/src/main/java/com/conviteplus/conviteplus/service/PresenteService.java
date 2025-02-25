package com.conviteplus.conviteplus.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.conviteplus.conviteplus.model.Evento;
import com.conviteplus.conviteplus.model.Presente;
import com.conviteplus.conviteplus.repository.EventoRepository;
import com.conviteplus.conviteplus.repository.PresenteRepository;

import jakarta.transaction.Transactional;

@Service
public class PresenteService {
    private final PresenteRepository presenteRepository;
    private final EventoRepository eventoRepository;

    public PresenteService(PresenteRepository presenteRepository, EventoRepository eventoRepository) {
        this.presenteRepository = presenteRepository;
        this.eventoRepository = eventoRepository;
    }

    @Transactional
    public Presente adicionarPresente(Long eventoId, Presente presente) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
  //      presente.setEvento(evento);
        return presenteRepository.save(presente);
    }
}