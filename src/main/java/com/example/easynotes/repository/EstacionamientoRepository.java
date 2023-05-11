package com.example.easynotes.repository;

import com.example.easynotes.model.Estacionamiento;

import java.util.Date;
import javax.transaction.Transactional;

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
	@Modifying
    @Query("DELETE FROM Estacionamiento e WHERE e.id = :id")
    void deleteById(@Param("id") Long id);
	
	@Transactional
	@Modifying
    @Query(value = "INSERT INTO Estacionamiento (uid, H_Entrada, H_Salida, H_Pago, Posicion, fecha, monto_pago, pagado, descuento, importe_descuento, fecha_cap) "
    		+ "VALUES (:uid, :hEntrada, :hSalida, :hPago, :posicion, :fecha, :montoPago, :pagado, :descuento, :importeDescuento, :fechaCap)", nativeQuery = true)
    void insertarEstacionamiento(
    		@Param("uid") String uid, 
    		@Param("hEntrada") Date hEntrada, 
    		@Param("hSalida") Date hSalida,
            @Param("hPago") Date hPago, 
            @Param("posicion") Long posicion, 
            @Param("fecha") Date fecha,
            @Param("montoPago") Double montoPago, 
            @Param("pagado") Double pagado, 
            @Param("descuento") Long descuento,
            @Param("importeDescuento") Double importeDescuento, 
            @Param("fechaCap") Date fechaCap);
}
