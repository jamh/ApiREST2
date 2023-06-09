package com.example.easynotes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.easynotes.model.Estacionamiento;


public interface ImprimirRepository extends JpaRepository<Estacionamiento, Long> {
	
	@Query(value = "SELECT * FROM estacionamiento WHERE fecha = CURDATE() AND uid = :uid", nativeQuery = true)
	Estacionamiento findByUid(@Param("uid") String uid);

	
}
