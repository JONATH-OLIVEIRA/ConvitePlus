package com.conviteplus.conviteplus.service;

import org.springframework.stereotype.Service;

import com.conviteplus.conviteplus.dto.EventoDTO;
import com.conviteplus.conviteplus.exceptions.AnfitriaoNaoEncontradoException;
import com.conviteplus.conviteplus.exceptions.EventoNaoEncontradoException;
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
    public Evento criarEvento(Long anfitriaoId, EventoDTO eventoDTO) {
        // Buscar o anfitrião pelo ID
        Anfitriao anfitriao = anfitriaoRepository.findById(anfitriaoId)
                .orElseThrow(() -> new AnfitriaoNaoEncontradoException(anfitriaoId));

        // Criar um evento a partir do DTO
        Evento evento = new Evento();
        evento.setTitulo(eventoDTO.getTitulo());
        evento.setDescricao(eventoDTO.getDescricao());
        evento.setDataHora(eventoDTO.getDataHora());
        evento.setLocal(eventoDTO.getLocal());
        evento.setAnfitriao(anfitriao);

        // Salvar o evento
        return eventoRepository.save(evento);
    }

    public Evento encontrarEventoPorId(Long id) {
        // Encontrar o evento ou lançar exceção caso não encontre
        return eventoRepository.findById(id)
                .orElseThrow(() -> new EventoNaoEncontradoException(id));
    }
}
