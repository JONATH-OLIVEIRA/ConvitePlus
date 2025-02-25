package com.conviteplus.conviteplus.exceptions;

public class AnfitriaoNaoEncontradoException extends RuntimeException {
    // Construtor que aceita o id e cria a mensagem
    public AnfitriaoNaoEncontradoException(Long id) {
        super("Anfitrião com ID " + id + " não encontrado");
    }

}
