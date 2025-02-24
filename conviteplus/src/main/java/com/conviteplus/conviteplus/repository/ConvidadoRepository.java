package com.conviteplus.conviteplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conviteplus.conviteplus.model.Convidado;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
