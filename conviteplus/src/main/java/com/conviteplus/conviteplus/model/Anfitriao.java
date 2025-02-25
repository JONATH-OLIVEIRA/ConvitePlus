package com.conviteplus.conviteplus.model;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "anfitrioes")
public class Anfitriao implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @Email(message = "Email inválido")
    private String email;

    @Schema(description = "Número de telefone no formato (00) 99999-9999")
    @Size(min = 14, max = 15, message = "Telefone deve ter entre 14 e 15 caracteres, incluindo os parênteses e espaço")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Formato do telefone inválido. Use (00) 99999-9999 ou (00) 9999-9999")
    private String telefone;
    
    public Anfitriao() {
    }

    public Anfitriao(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Anfitriao [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Anfitriao other = (Anfitriao) obj;
        return Objects.equals(id, other.id);
    }
}
