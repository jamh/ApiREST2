package com.example.easynotes.repository;

import com.example.easynotes.model.Perfiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.List;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfiles, Long> {
	/*
	@Query( 
			value="SELECT * from test1.login l, test1.perfiles p where l.expiracion < NOW() order by l.empleado", 
			nativeQuery= true)
	List<Perfiles> findPerfiles();
	*/

}
