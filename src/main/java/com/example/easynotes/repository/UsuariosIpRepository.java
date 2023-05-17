package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.easynotes.model.UsuarioIp;

public interface UsuariosIpRepository extends JpaRepository<UsuarioIp, Long>{
	UsuarioIp findByUsuario(String usuario);
}
