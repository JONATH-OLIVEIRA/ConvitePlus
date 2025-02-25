package com.conviteplus.conviteplus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "midias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Midia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String url;
    
    @Enumerated(EnumType.STRING)
  //  private TipoMidia tipo;
    
    @ManyToOne
    @JoinColumn(name = "postado_por")
    private Anfitriao postadoPor;
    
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
}