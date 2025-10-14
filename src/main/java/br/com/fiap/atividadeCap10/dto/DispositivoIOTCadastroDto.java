package br.com.fiap.atividadeCap10.dto;

import jakarta.validation.constraints.NotBlank;

public record DispositivoIOTCadastroDto(
        Long id,
        @NotBlank(message = "Nome do dispositivo é obrigatório")
        String nome,
        String modelo,
        String fabricante
) {
}
