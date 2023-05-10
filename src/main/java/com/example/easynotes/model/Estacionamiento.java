package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "Estacionamiento")
@EntityListeners(AuditingEntityListener.class)
public class Estacionamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	private String uid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "H.Entrada")
    private Date Hentrada;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "H.Salida")
    private Date Hsalida;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "H.Pago")
    private Date Hpago;
    
    @NotBlank
	private String posicion;
    
    @NotBlank
	private Date fecha;
    
    @Column(name = "monto_pago")
    private Long montoPago;
    
    @NotBlank
	private Long pagado;
    
    @NotBlank
	private Long descuento;
    
    @Column(name = "importe_descuento")
    private Long importeDescuento;
    
    @Column(name = "fecha_cap")
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

	public Date getHentrada() {
		return Hentrada;
	}

	public void setHentrada(Date hentrada) {
		Hentrada = hentrada;
	}

	public Date getHsalida() {
		return Hsalida;
	}

	public void setHsalida(Date hsalida) {
		Hsalida = hsalida;
	}

	public Date getHpago() {
		return Hpago;
	}

	public void setHpago(Date hpago) {
		Hpago = hpago;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(Long montoPago) {
		this.montoPago = montoPago;
	}

	public Long getPagado() {
		return pagado;
	}

	public void setPagado(Long pagado) {
		this.pagado = pagado;
	}

	public Long getDescuento() {
		return descuento;
	}

	public void setDescuento(Long descuento) {
		this.descuento = descuento;
	}

	public Long getImporteDescuento() {
		return importeDescuento;
	}

	public void setImporteDescuento(Long importeDescuento) {
		this.importeDescuento = importeDescuento;
	}

	public Date getFechaCap() {
		return fechaCap;
	}

	public void setFechaCap(Date fechaCap) {
		this.fechaCap = fechaCap;
	}
}
