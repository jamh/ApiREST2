package com.example.easynotes.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.easynotes.model.Estacionamiento;


public interface ImprimirRepository extends JpaRepository<Estacionamiento, Long> {
	
	@Query(value = "SELECT * FROM estacionamiento WHERE fecha = CURDATE() AND pagado >0 AND id = (SELECT MAX(id) FROM estacionamiento) AND ticket IS NULL", nativeQuery = true)
	Estacionamiento findById();
	
	@Modifying
    @Transactional
    @Query(value= "UPDATE estacionamiento SET ticket = 1 WHERE id = (SELECT MAX_id FROM (SELECT MAX(id) as MAX_id FROM estacionamiento) AS subquery)", nativeQuery=true)
    int actualizarTicket();
	

	
}
