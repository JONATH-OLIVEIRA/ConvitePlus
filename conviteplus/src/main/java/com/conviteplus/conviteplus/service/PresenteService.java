package com.conviteplus.conviteplus.service;

import com.conviteplus.conviteplus.dto.PresenteDTO;
import com.conviteplus.conviteplus.model.Presente;
import com.conviteplus.conviteplus.model.Evento;
import com.conviteplus.conviteplus.repository.PresenteRepository;
import com.conviteplus.conviteplus.repository.EventoRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresenteService {
    
    private final PresenteRepository presenteRepository;
    private final EventoRepository eventoRepository;

    public PresenteService(PresenteRepository presenteRepository, EventoRepository eventoRepository) {
        this.presenteRepository = presenteRepository;
        this.eventoRepository = eventoRepository;
    }

    @Transactional
    public List<PresenteDTO> adicionarListaDePresentes(Long eventoId, List<PresenteDTO> presentesDTO) {
        Evento evento = eventoRepository.findById(eventoId)
            .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado"));

        List<Presente> presentes = presentesDTO.stream().map(dto -> {
            Presente presente = new Presente();
            presente.setNome(dto.getNome());
            presente.setDescricao(dto.getDescricao());
            presente.setEvento(evento);
            return presente;
        }).collect(Collectors.toList());

        presenteRepository.saveAll(presentes);

        return presentes.stream().map(PresenteDTO::new).collect(Collectors.toList());
    }

    public List<PresenteDTO> listarPresentesPorEvento(Long eventoId) {
        List<Presente> presentes = presenteRepository.findByEventoId(eventoId);
        return presentes.stream().map(PresenteDTO::new).collect(Collectors.toList());
    }
}
