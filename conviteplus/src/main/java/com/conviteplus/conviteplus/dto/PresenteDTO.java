package com.conviteplus.conviteplus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PresenteDTO {

    private Long id; // Apenas para o retorno, quando o presente for persistido
    private String nome;
    private String descricao;

    @JsonProperty("eventoId") // Exibe apenas o ID do evento
    private Long eventoId;

    @JsonProperty("reservadoPorId") // Exibe apenas o ID do convidado
    private Long reservadoPorId;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getReservadoPorId() {
        return reservadoPorId;
    }

    public void setReservadoPorId(Long reservadoPorId) {
        this.reservadoPorId = reservadoPorId;
    }
}
