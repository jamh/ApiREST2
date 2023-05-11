package com.example.easynotes.repository;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.model.Estacionamiento;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Long> {
	
	@Modifying
    @Transactional
    @Query("UPDATE Estacionamiento SET Posicion = 1 WHERE Posicion = 99")
    int actualizarPosicion();
	
	@Transactional
	void deleteByPosicion(Long posicion);
}
