package com.conviteplus.conviteplus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "presentes")
public class Presente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    
    @OneToOne
    @JoinColumn(name = "reservado_por")
    private Convidado reservadoPor;

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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Convidado getReservadoPor() {
        return reservadoPor;
    }

    public void setReservadoPor(Convidado reservadoPor) {
        this.reservadoPor = reservadoPor;
    }
}
