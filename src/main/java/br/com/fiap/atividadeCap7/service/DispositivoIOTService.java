package br.com.fiap.atividadeCap7.service;

import br.com.fiap.atividadeCap7.model.DispositivoIOT;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispositivoIOTService {


        private final List<DispositivoIOT> dispositivos = new ArrayList<>();
        private Long contador = 1L;

        public List<DispositivoIOT> listar() {
            return dispositivos;
        }

        public DispositivoIOT cadastrar(DispositivoIOT dispositivo) {
            dispositivo.setId(contador++);
            dispositivos.add(dispositivo);
            return dispositivo;
        }

        public String selecionaContrato(String contrato){
            switch (contrato){
                case "contrato dispositivo com sucesso":
                    return "schemas/cadastro-dispositivo-com-sucesso.json";
                case "contrato dispositivo com erro":
                    return "schemas/cadastro-dispositivo-com-erro.json";
                default:
                    return null;
            }
        }
}

