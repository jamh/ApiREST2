package com.example.easynotes.repository;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.model.Login;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	@Query(value="select l.EMPLEADO as empleado,p.PERFIL as perfil, l.EXPIRACION  from test1.login l,test1.perfiles p where l.ID_PERFIL =p.ID_PERFIL and p.PERFIL in ('empleado','admin')  ", nativeQuery=  true)
	List<expiradosDTO> buscaExpirados();
}
