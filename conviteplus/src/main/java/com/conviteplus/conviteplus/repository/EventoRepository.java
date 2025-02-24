package com.conviteplus.conviteplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conviteplus.conviteplus.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Long> {

}
