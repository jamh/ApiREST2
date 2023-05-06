package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Expirados;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.ExpiradosRepository;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpiradosController {

	@Autowired
    ExpiradosRepository expiradosRepository;

    @GetMapping("/expirados")
    public List<Expirados> findExpiracion() {
        return expiradosRepository.findExpiracion();
    }
}
