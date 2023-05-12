package com.example.easynotes.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easynotes.dto.EstacionamientoDTO;
import com.example.easynotes.model.Descuentos;

@Repository
public interface DescuentosRepository extends JpaRepository<Descuentos, Long>{
	
	@Modifying
    @Transactional
    @Query("UPDATE Descuentos SET estatus = 'usado' WHERE estatus = 1")
    int actualizarEstatus();
	
	@Transactional
	@Modifying
    @Query("DELETE FROM Descuentos d WHERE d.id = :id")
    void BorrarPorId(@Param("id") Long id);
	
	@Transactional
	@Modifying
    @Query(value = "INSERT INTO est_descuentos (estatus, fecha_cap, tarjeta) "
    		+ "VALUES (:estatus, :fechaCap, :tarjeta)", nativeQuery = true)
    void insertarDescuentos(
    		@Param("estatus") String estatus,
    		@Param("fechaCap") Date fechaCap,
    		@Param("tarjeta") String tarjeta);
    		
	@Query(value="SELECT * FROM est_descuentos WHERE estatus= 1", nativeQuery=true)
	List<Descuentos>findEstatus(); 
	
	@Query(value= "SELECT e.id as idEstacionamiento, e.uid, d.id as idDescuento, d.estatus, d.tarjeta " +
	           "FROM est_descuentos d, estacionamiento e " +
	           "WHERE d.tarjeta = e.uid", nativeQuery= true)
	    List<EstacionamientoDTO> obtenerInformacionDescuento();
	
}
