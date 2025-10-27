package br.com.fiap.atividadeCap7.model;

import jakarta.validation.constraints.NotBlank;

public class DispositivoIOT {
    private Long id;
    @NotBlank(message = "O nome do dispositivo é obrigatório")
    private String nome;
    private String tipo;
    private String consumo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
}
