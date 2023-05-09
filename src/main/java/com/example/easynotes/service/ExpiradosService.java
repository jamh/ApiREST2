package com.example.easynotes.service;

import java.util.List;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.repository.ExpiradosRepository;

public class ExpiradosService {
	private final ExpiradosRepository expiradosRepository;
	public ExpiradosService(ExpiradosRepository expiradosRepository) {
		this.expiradosRepository = expiradosRepository;
	}
	
	public List<expiradosDTO> getDataFromTwoTables() {
		return expiradosRepository.findDataFromTwoTables();
	}
}
