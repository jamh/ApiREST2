package com.example.easynotes.repository;

import com.example.easynotes.model.Estacionamiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Long> {
	
	/*
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
    @Query(value = "INSERT INTO Estacionamiento (uid, H.Entrada, H.Salida, H.Pago, Posicion, fecha, monto_pago, pagado, descuento, importe_descuento, fecha_cap) "
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
            @Param("fechaCap") Date fechaCap);.*/
}
