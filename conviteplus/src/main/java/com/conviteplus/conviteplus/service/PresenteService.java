package com.conviteplus.conviteplus.service;

import com.conviteplus.conviteplus.dto.PresenteDTO;
import com.conviteplus.conviteplus.model.Presente;
import com.conviteplus.conviteplus.model.Evento;
import com.conviteplus.conviteplus.model.Convidado;
import com.conviteplus.conviteplus.repository.PresenteRepository;
import com.conviteplus.conviteplus.repository.EventoRepository;
import com.conviteplus.conviteplus.repository.ConvidadoRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class PresenteService {

    private final PresenteRepository presenteRepository;
    private final EventoRepository eventoRepository;
    private final ConvidadoRepository convidadoRepository;

    public PresenteService(PresenteRepository presenteRepository, EventoRepository eventoRepository, ConvidadoRepository convidadoRepository) {
        this.presenteRepository = presenteRepository;
        this.eventoRepository = eventoRepository;
        this.convidadoRepository = convidadoRepository;
    }

    @Transactional
    public PresenteDTO adicionarPresente(PresenteDTO presenteDTO) {
        // Verificando se o evento existe
        Evento evento = eventoRepository.findById(presenteDTO.getEventoId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        
        // Verificando se o convidado existe
        Convidado convidado = convidadoRepository.findById(presenteDTO.getReservadoPorId())
                .orElseThrow(() -> new RuntimeException("Convidado não encontrado"));

        // Criando o presente
        Presente presente = new Presente();
        presente.setNome(presenteDTO.getNome());
        presente.setDescricao(presenteDTO.getDescricao());
        presente.setEvento(evento);
        presente.setReservadoPor(convidado);

        // Salvando o presente no banco
        presente = presenteRepository.save(presente); // O banco irá gerar o ID automaticamente

        // Retorna o DTO do presente recém-criado com o ID gerado
        return mapToDTO(presente);
    }

    // Método para mapear o objeto Presente para o DTO
    private PresenteDTO mapToDTO(Presente presente) {
        PresenteDTO dto = new PresenteDTO();
        dto.setId(presente.getId()); // O ID gerado pelo banco será atribuído aqui
        dto.setNome(presente.getNome());
        dto.setDescricao(presente.getDescricao());
        dto.setEventoId(presente.getEvento().getId()); // Apenas o ID do evento
        dto.setReservadoPorId(presente.getReservadoPor().getId()); // Apenas o ID do convidado
        return dto;
    }

    // Método para buscar o presente por ID
    public PresenteDTO encontrarPresentePorId(Long presenteId) {
        Presente presente = presenteRepository.findById(presenteId)
                .orElseThrow(() -> new RuntimeException("Presente não encontrado"));
        return mapToDTO(presente); // Retorna o DTO com os dados do presente
    }
}
