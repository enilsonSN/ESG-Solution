package br.com.fiap.atividadeCap10.dto;

import br.com.fiap.atividadeCap10.model.DispositivoIOT;

public record DispositivoIOTDto(
        Long id,
        String nome,
        String modelo,
        String fabricante) {

    public DispositivoIOTDto(DispositivoIOT dispositivoIOT){
        this(
                dispositivoIOT.getId(),
                dispositivoIOT.getNome(),
                dispositivoIOT.getModelo(),
                dispositivoIOT.getFabricante()
        );
    }
}
