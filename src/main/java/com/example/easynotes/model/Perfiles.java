package com.example.easynotes.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "perfiles")
@EntityListeners(AuditingEntityListener.class)
public class Perfiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long idPerfil;
	
	@NotBlank
	private String perfil;
	

    
    public Long getidPerfil() {
        return idPerfil;
    }

    public void setidPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}
