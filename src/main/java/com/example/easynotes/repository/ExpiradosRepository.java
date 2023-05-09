package com.example.easynotes.repository;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.model.Expirados;
import com.example.easynotes.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ExpiradosRepository extends CrudRepository<Expirados, Long>{
	
	@Query(value="SELECT * from test1.expirados ", nativeQuery=true)
	List<Expirados>findEmpleado(); 
	
	@Query(value="select l.EMPLEADO as empleado,p.PERFIL as perfil, l.EXPIRACION  from test1.login l,test1.perfiles p where l.ID_PERFIL =p.ID_PERFIL and p.PERFIL in ('empleado','admin')  ", nativeQuery=  true)
	List<expiradosDTO> buscaExpirados();
	
}
