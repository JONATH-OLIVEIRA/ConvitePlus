package com.conviteplus.conviteplus.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "convidado")
public class Convidado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String status; // Exemplo: "Confirmado", "Aguardando"

	private boolean linkAtivo; // Indica se o link de convite está ativo ou desativado

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	public Convidado() {
		// Nome aleatório no momento da criação
		this.nome = "Convidado " + (int) (Math.random() * 1000); // Nome aleatório
		this.status = "Aguardando";
		this.linkAtivo = true;
	}

	public Convidado(Long id, String nome, String email, String status, Evento evento, boolean linkAtivo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.status = status;
		this.evento = evento;
		this.linkAtivo = linkAtivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isLinkAtivo() {
		return linkAtivo;
	}

	public void setLinkAtivo(boolean linkAtivo) {
		this.linkAtivo = linkAtivo;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
