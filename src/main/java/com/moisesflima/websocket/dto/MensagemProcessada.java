package com.moisesflima.websocket.dto;

public class MensagemProcessada {

    private String origem;
    private String texto;
    private String horario;

    public MensagemProcessada(final String origem, final String texto, final String horario) {

        this.origem = origem;
        this.texto = texto;
        this.horario = horario;
    }

    public String getTexto() {
        return texto;
    }

    public String getHorario() {
        return horario;
    }

    public String getOrigem() {
        return origem;
    }
}