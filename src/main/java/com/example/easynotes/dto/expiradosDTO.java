package com.example.easynotes.dto;

import java.sql.Date;

public class expiradosDTO {
	

	private String empleado;

	private String expiracion;

	private String perfil;

	
	
	
	public expiradosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public expiradosDTO(String empleado, String expiracion, String perfil) {
		super();
		this.empleado = empleado;
		this.expiracion = expiracion;
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "expiradosDTO [empleado=" + empleado + ", expiracion=" + expiracion + ", perfil=" + perfil + "]";
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getExpiracion() {
		return expiracion;
	}

	public void setExpiracion(String expiracion) {
		this.expiracion = expiracion;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
	
    
}
