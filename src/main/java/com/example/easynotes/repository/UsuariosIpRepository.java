package com.example.easynotes.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.easynotes.model.UsuarioIp;

public interface UsuariosIpRepository extends JpaRepository<UsuarioIp, Long>{
	UsuarioIp findByUsuario(String usuario);
	
	@Transactional
	@Modifying
	@Query("SELECT DISTINCT u.Ip FROM UsuarioIp u WHERE u.Ip IS NOT NULL")
    List<String> findDistinctIp();
}
