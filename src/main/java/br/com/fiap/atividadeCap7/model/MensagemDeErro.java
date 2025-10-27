package br.com.fiap.atividadeCap7.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemDeErro {
    private String campo;
    private String mensagem;
}
