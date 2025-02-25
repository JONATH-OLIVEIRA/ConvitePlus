package com.conviteplus.conviteplus.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "convidados")
public class Convidado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private int numeroConvidado;

	private String linkConvite; // Campo para armazenar o link de convite gerado
	private String nomeEditado; // Nome que pode ser editado pelo convidado após confirmação

	@Enumerated(EnumType.STRING)
	private StatusConfirmacao statusConfirmacao; // Status de confirmação (PENDENTE, CONFIRMADO, RECUSADO)

	@ManyToOne
	@JoinColumn(name = "presente_id")
	private Presente presenteEscolhido;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	public Convidado() {
	}

	public Convidado(Long id, String nome, int numeroConvidado, String linkConvite, String nomeEditado,
			StatusConfirmacao statusConfirmacao, Presente presenteEscolhido, Evento evento) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroConvidado = numeroConvidado;
		this.linkConvite = linkConvite;
		this.nomeEditado = nomeEditado;
		this.statusConfirmacao = statusConfirmacao;
		this.presenteEscolhido = presenteEscolhido;
		this.evento = evento;
	}

	public String getLinkConvite() {
		return linkConvite;
	}

	public void setLinkConvite(String linkConvite) {
		this.linkConvite = linkConvite;
	}

	public String getNomeEditado() {
		return nomeEditado;
	}

	public void setNomeEditado(String nomeEditado) {
		this.nomeEditado = nomeEditado;
	}

	public StatusConfirmacao getStatusConfirmacao() {
		return statusConfirmacao;
	}

	public void setStatusConfirmacao(StatusConfirmacao statusConfirmacao) {
		this.statusConfirmacao = statusConfirmacao;
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

	public int getNumeroConvidado() {
		return numeroConvidado;
	}

	public void setNumeroConvidado(int numeroConvidado) {
		this.numeroConvidado = numeroConvidado;
	}

	public Presente getPresenteEscolhido() {
		return presenteEscolhido;
	}

	public void setPresenteEscolhido(Presente presenteEscolhido) {
		this.presenteEscolhido = presenteEscolhido;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Convidado [id=" + id + ", nome=" + nome + ", numeroConvidado=" + numeroConvidado + ", linkConvite="
				+ linkConvite + ", nomeEditado=" + nomeEditado + ", statusConfirmacao=" + statusConfirmacao
				+ ", presenteEscolhido=" + presenteEscolhido + ", evento=" + evento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convidado other = (Convidado) obj;
		return Objects.equals(id, other.id);
	}

}
