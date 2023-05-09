package com.example.easynotes.repository;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.model.Expirados;
import com.example.easynotes.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface ExpiradosRepository extends JpaRepository<Login, Long>{
	/*
	@Query(value="SELECT * from test1.login where empleado = 'Lauree Yapp' ", nativeQuery=true)
	List<Expirados>findEmpleado(); */
	
	@Query(value="SELECT new com.example.easynotes.dto(l.id, l.empleado, l.password, l.expedicion, p.perfil) FROM login l, perfil p order by l.empleado", nativeQuery=  true)
	List<expiradosDTO> findDataFromTwoTables();
	
}
