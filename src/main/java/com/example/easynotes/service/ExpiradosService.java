package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.repository.ExpiradosRepository;

@Service
public class ExpiradosService {
	
	@Autowired
	private  ExpiradosRepository expiradosRepository ;
	
	
	public List<expiradosDTO> buscaExpiradosData() {
		return expiradosRepository.buscaExpirados();
	}
}
