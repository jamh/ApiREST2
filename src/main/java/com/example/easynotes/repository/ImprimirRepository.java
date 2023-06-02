package com.example.easynotes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.easynotes.model.Estacionamiento;


public interface ImprimirRepository extends JpaRepository<Estacionamiento, Long> {
	
	Estacionamiento findByUid(String uid);
	
	
}
