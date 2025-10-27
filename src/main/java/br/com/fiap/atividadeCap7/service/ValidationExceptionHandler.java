package br.com.fiap.atividadeCap7.service;

import br.com.fiap.atividadeCap7.model.MensagemDeErro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public List<MensagemDeErro> handleValidationExceptions(
            MethodArgumentNotValidException ex) {


        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> MensagemDeErro.builder() // Usa o @Builder
                        .campo(error.getField())
                        .mensagem(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
    }
}
