package com.aluralatam.api_rest.dto;

import com.aluralatam.api_rest.model.Tópico;
import lombok.Data;

@Data
public class TópicoResponse {
    private Long id;
    private String título;
    private String mensaje;
    private Long usuarioId;

    public TópicoResponse(Tópico tópico) {
        this.id = tópico.getId();
        this.título = tópico.getTítulo();
        this.mensaje = tópico.getMensaje();
        this.usuarioId = tópico.getUsuarioId();
    }
}