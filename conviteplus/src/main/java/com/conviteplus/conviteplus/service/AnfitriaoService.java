package com.conviteplus.conviteplus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conviteplus.conviteplus.dto.EventoComPresentesDTO;
import com.conviteplus.conviteplus.exceptions.AnfitriaoNaoEncontradoException;
import com.conviteplus.conviteplus.exceptions.EventoNaoEncontradoException;
import com.conviteplus.conviteplus.model.Anfitriao;
import com.conviteplus.conviteplus.model.Evento;
import com.conviteplus.conviteplus.repository.AnfitriaoRepository;
import com.conviteplus.conviteplus.repository.EventoRepository;

import jakarta.transaction.Transactional;

@Service
public class AnfitriaoService {
	
	  @Autowired
	    private AnfitriaoRepository anfitriaoRepository;

	    @Autowired
	    private EventoRepository eventoRepository;
	    
    public AnfitriaoService(AnfitriaoRepository anfitriaoRepository) {
        this.anfitriaoRepository = anfitriaoRepository;
    }

    public Anfitriao cadastrarAnfitriao(Anfitriao anfitriao) {
        return anfitriaoRepository.save(anfitriao);
    }

       
    public Anfitriao buscarPorId(Long id) {
        return anfitriaoRepository.findById(id)
                .orElseThrow(() -> new AnfitriaoNaoEncontradoException(id));
    }
    @Transactional
    public EventoComPresentesDTO buscarEventoComPresentes(Long anfitriaoId, Long eventoId) {
        Anfitriao anfitriao = anfitriaoRepository.findById(anfitriaoId)
            .orElseThrow(() -> new AnfitriaoNaoEncontradoException(anfitriaoId));

        Evento evento = eventoRepository.findById(eventoId)
            .filter(e -> e.getAnfitriao().getId().equals(anfitriaoId))
            .orElseThrow(() -> new EventoNaoEncontradoException(eventoId));

        return new EventoComPresentesDTO(evento);
    }
}
