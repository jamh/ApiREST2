package com.example.easynotes.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name = "estacionamiento")
@EntityListeners(AuditingEntityListener.class)
public class Estacionamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	private String uid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "H_Entrada")
    private Date hEntrada;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "H_Salida")
    private Date hSalida;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "H_Pago")
    private Date hPago;
    
	@Column(name = "Posicion")
	@NotBlank
	private Long posicion;
    
	private Date fecha;
    
    @Column(name = "monto_pago")
    private Double montoPago;
    
	private Double pagado;
    
	private Long descuento;
    
    @Column(name = "importe_descuento")
    private Double importeDescuento;
    
    @Column(name = "fecha_cap")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date fechaCap;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date gethEntrada() {
		return hEntrada;
	}

	public void sethEntrada(Date hEntrada) {
		this.hEntrada = hEntrada;
	}

	public Date gethSalida() {
		return hSalida;
	}

	public void sethSalida(Date hSalida) {
		this.hSalida = hSalida;
	}

	public Date gethPago() {
		return hPago;
	}

	public void sethPago(Date hPago) {
		this.hPago = hPago;
	}

	public Long getPosicion() {
		return posicion;
	}

	public void setPosicion(Long posicion) {
		this.posicion = posicion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	public Double getPagado() {
		return pagado;
	}

	public void setPagado(Double pagado) {
		this.pagado = pagado;
	}

	public Long getDescuento() {
		return descuento;
	}

	public void setDescuento(Long descuento) {
		this.descuento = descuento;
	}

	

	public Double getImporteDescuento() {
		return importeDescuento;
	}

	public void setImporteDescuento(Double importeDescuento) {
		this.importeDescuento = importeDescuento;
	}

	public Date getFechaCap() {
		return fechaCap;
	}

	public void setFechaCap(Date fechaCap) {
		this.fechaCap = fechaCap;
	}

	

	
    
	
}
