package com.example.easynotes.dto;

import java.sql.Date;

public class expiradosDTO {
	
	private Long id;
	private String empleado;
	private String password;
	private String correo;
	private Date expiracion;
	private Long idPerfil;
	private String perfil;
	
	public expiradosDTO(Long id, String empleado, String password, String correo, Date expiracion, Long idPerfil, String perfil) {
        this.id = id;
        this.empleado = empleado;
        this.password = password;
        this.correo = correo;
        this.expiracion = expiracion;
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }
	
	
    
}
