package com.aluralatam.api_rest.controller;

import com.aluralatam.api_rest.dto.TópicoRequest;
import com.aluralatam.api_rest.dto.TópicoResponse;
import com.aluralatam.api_rest.model.Tópico;
import com.aluralatam.api_rest.repository.RepositorioTópicos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tópicos")
public class ControladorTópicos {

    @Autowired
    private RepositorioTópicos repositorioTópicos;

    @PostMapping
    public ResponseEntity<TópicoResponse> crearTópico(@RequestBody @Valid TópicoRequest request) {
        Tópico tópico = new Tópico();
        tópico.setTítulo(request.getTítulo());
        tópico.setMensaje(request.getMensaje());
        tópico.setUsuarioId(request.getUsuarioId());
        Tópico savedTópico = repositorioTópicos.save(tópico);
        return ResponseEntity.status(201).body(new TópicoResponse(savedTópico));
    }

    @GetMapping
    public ResponseEntity<List<TópicoResponse>> listarTópicos() {
        List<TópicoResponse> tópicos = repositorioTópicos.findAll()
                .stream()
                .map(TópicoResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tópicos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTópico(@PathVariable Long id) {
        if (repositorioTópicos.existsById(id)) {
            repositorioTópicos.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}