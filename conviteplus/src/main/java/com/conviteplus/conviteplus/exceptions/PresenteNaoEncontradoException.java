package com.conviteplus.conviteplus.exceptions;

public class PresenteNaoEncontradoException extends RuntimeException {
    public PresenteNaoEncontradoException(Long id) {
        super("Presente com ID " + id + " não encontrado");
    }
}
