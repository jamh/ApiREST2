package com.example.easynotes.model;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "expirados")
public class Expirados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String empleado;
	
	@NotBlank
	private String password;

	@NotBlank
	private String correo;

	@NotBlank
	private Date expiracion;
	
	/* @ManyToOne
	 @JoinColumn(name = "idPerfil")
	 private Perfiles perfiles;
	*/
	
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Date getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(Date expiracion) {
        this.expiracion = expiracion;
    }
    
    
    
    
}


