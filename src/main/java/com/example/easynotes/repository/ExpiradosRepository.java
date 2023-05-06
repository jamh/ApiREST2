package com.example.easynotes.repository;

import com.example.easynotes.model.Expirados;
import com.example.easynotes.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.List;

@Repository
public interface ExpiradosRepository extends JpaRepository<Expirados, Long>{
	/*
	@Query(value="SELECT * from test1.login where empleado = 'Lauree Yapp' ", nativeQuery=true)
	List<Expirados>findEmpleado(); */
	
	@Query( 
			value="SELECT * from test1.login l, test1.perfiles p where l.expiracion < NOW() order by p.perfil", 
			nativeQuery= true)
	List<Expirados>findExpiracion();
	
}
