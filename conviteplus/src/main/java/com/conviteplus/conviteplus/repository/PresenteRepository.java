package com.conviteplus.conviteplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conviteplus.conviteplus.model.Presente;

public interface PresenteRepository extends JpaRepository<Presente, Long> {

	List<Presente> findByEventoId(Long eventoId);
}
