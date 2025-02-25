package com.conviteplus.conviteplus.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.conviteplus.conviteplus.model.Evento;

public class EventoComPresentesDTO {
    private Long eventoId;
    private String nomeEvento;
    private Long anfitriaoId;
    private String nomeAnfitriao;
    private List<PresenteDTO> presentes;

    public EventoComPresentesDTO(Evento evento) {
        this.eventoId = evento.getId();
        this.nomeEvento = evento.getTitulo();
        this.anfitriaoId = evento.getAnfitriao().getId();
        this.nomeAnfitriao = evento.getAnfitriao().getNome();
        this.presentes = evento.getPresentes().stream()
                               .map(presente -> new PresenteDTO(presente))
                               .collect(Collectors.toList());
    }

	public Long getEventoId() {
		return eventoId;
	}

	public void setEventoId(Long eventoId) {
		this.eventoId = eventoId;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Long getAnfitriaoId() {
		return anfitriaoId;
	}

	public void setAnfitriaoId(Long anfitriaoId) {
		this.anfitriaoId = anfitriaoId;
	}

	public String getNomeAnfitriao() {
		return nomeAnfitriao;
	}

	public void setNomeAnfitriao(String nomeAnfitriao) {
		this.nomeAnfitriao = nomeAnfitriao;
	}

	public List<PresenteDTO> getPresentes() {
		return presentes;
	}

	public void setPresentes(List<PresenteDTO> presentes) {
		this.presentes = presentes;
	}

  
}
