package com.example.easynotes.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "usuarioip")
@EntityListeners(AuditingEntityListener.class)
public class UsuarioIp{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	private String usuario;
	
	private String Contraseña;
	
	private String Ip;

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}
	
	
    
}