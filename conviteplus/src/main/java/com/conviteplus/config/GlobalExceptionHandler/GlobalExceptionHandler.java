package com.conviteplus.config.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.conviteplus.conviteplus.exceptions.AnfitriaoNaoEncontradoException;
import com.conviteplus.conviteplus.exceptions.EventoNaoEncontradoException;
import com.conviteplus.conviteplus.exceptions.PresenteNaoEncontradoException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(EventoNaoEncontradoException.class)
    public ResponseEntity<String> handleEventoNaoEncontrado(EventoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AnfitriaoNaoEncontradoException.class)
    public ResponseEntity<String> handleAnfitriaoNaoEncontrado(AnfitriaoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PresenteNaoEncontradoException.class)
    public ResponseEntity<String> handlePresenteNaoEncontrado(PresenteNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
    }
   
}