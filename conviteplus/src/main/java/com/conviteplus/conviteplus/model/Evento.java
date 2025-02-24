package com.conviteplus.conviteplus.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "eventos")
@Data
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDateTime dataHora;
    private String local;

    @JsonManagedReference
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Convidado> convidados;

    @ManyToOne
    @JoinColumn(name = "anfitriao_id", nullable = false)
    private Anfitriao anfitriao;

    public Evento() {
        // Construtor sem parâmetros
    }

    public Evento(Long id, String nome, String descricao, LocalDateTime dataHora, String local, List<Convidado> convidados, Anfitriao anfitriao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
        this.convidados = convidados;
        this.anfitriao = anfitriao;
    }

	public Anfitriao getAnfitriao() {
		return anfitriao;
	}

	public void setAnfitriao(Anfitriao anfitriao) {
		this.anfitriao = anfitriao;
	}

	public List<Convidado> getConvidados() {
		return convidados;
	}

	public void setConvidados(List<Convidado> convidados) {
		this.convidados = convidados;
	}
    
}
