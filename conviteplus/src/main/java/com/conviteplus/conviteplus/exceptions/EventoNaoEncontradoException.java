package com.conviteplus.conviteplus.exceptions;

public class EventoNaoEncontradoException extends RuntimeException {
    public EventoNaoEncontradoException(Long id) {
        super("Evento com ID " + id + " não encontrado");
    }
}
