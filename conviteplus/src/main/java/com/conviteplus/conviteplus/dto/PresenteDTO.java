package com.conviteplus.conviteplus.dto;

import com.conviteplus.conviteplus.model.Presente;

public class PresenteDTO {

    private Long id;
    private String nome;
    private String descricao;

    public PresenteDTO() {
    }

    public PresenteDTO(Presente presente) {
        this.id = presente.getId();
        this.nome = presente.getNome();
        this.descricao = presente.getDescricao();
    }

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
}
