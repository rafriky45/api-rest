package com.aluralatam.api_rest.controller;

import com.aluralatam.api_rest.dto.LoginRequest;
import com.aluralatam.api_rest.service.ServicioJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorAutenticación {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ServicioJwt servicioJwt;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNombreUsuario(),
                        request.getContraseña()
                )
        );
        String token = servicioJwt.generarToken(authentication.getName());
        return ResponseEntity.ok(token);
    }
}