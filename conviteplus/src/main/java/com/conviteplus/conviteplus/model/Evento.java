package com.conviteplus.conviteplus.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "eventos", uniqueConstraints = @UniqueConstraint(columnNames = {"titulo", "dataHora"}))
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @Size(max = 255)
    private String descricao;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    @Size(max = 255)
    private String local;

    @ManyToOne
    @JoinColumn(name = "anfitriao_id", nullable = false)
    private Anfitriao anfitriao;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Convidado> listaConvidados;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Midia> galeria;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Presente> presentes;

    // Construtores
    public Evento() {}

    public Evento(Long id, String titulo, String descricao, LocalDateTime dataHora, String local, Anfitriao anfitriao,
                  List<Convidado> listaConvidados, List<Midia> galeria, List<Presente> presentes) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
        this.anfitriao = anfitriao;
        this.listaConvidados = listaConvidados;
        this.galeria = galeria;
        this.presentes = presentes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Anfitriao getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(Anfitriao anfitriao) {
        this.anfitriao = anfitriao;
    }

    public List<Convidado> getListaConvidados() {
        return listaConvidados;
    }

    public void setListaConvidados(List<Convidado> listaConvidados) {
        this.listaConvidados = listaConvidados;
    }

    public List<Midia> getGaleria() {
        return galeria;
    }

    public void setGaleria(List<Midia> galeria) {
        this.galeria = galeria;
    }

    public List<Presente> getPresentes() {
        return presentes;
    }

    public void setPresentes(List<Presente> presentes) {
        this.presentes = presentes;
    }

    @Override
    public String toString() {
        return "Evento [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataHora=" + dataHora
                + ", local=" + local + ", anfitriao=" + anfitriao + ", listaConvidados=" + listaConvidados
                + ", galeria=" + galeria + ", presentes=" + presentes + "]";
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
        Evento other = (Evento) obj;
        return Objects.equals(id, other.id);
    }
}
