package br.com.fiap.atividadeCap10.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.fiap.atividadeCap10.dto.DispositivoIOTCadastroDto;
import br.com.fiap.atividadeCap10.dto.DispositivoIOTDto;
import br.com.fiap.atividadeCap10.service.DispositivoIOTService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
public class DispositivoIOTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DispositivoIOTService service;

    @DisplayName("Teste de criação de DispositivoIOT com sucesso")
    @Test
    void testCreateDispositivoIOT() throws Exception {
        // Mocka o retorno do service.cadastrarDispositivo()
        given(service.cadastrarDispositivo(any(DispositivoIOTCadastroDto.class)))
                .willReturn(new DispositivoIOTDto(1L, "Sensor de Temperatura", "STX-1000", "TechSens"));

        // Corpo JSON correspondente ao DispositivoIOTCadastroDto
        String body = """
            {
                "id": 1,
                "nome": "Sensor de Temperatura",
                "modelo": "STX-1000",
                "fabricante": "TechSens"
            }
            """;

        // Chama o endpoint POST /dispositivos
        mockMvc.perform(MockMvcRequestBuilders.post("/api/dispositivo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated());
    }

    @DisplayName("Teste de falha na criação de DispositivoIOT (dados inválidos)")
    @Test
    void testCreateDispositivoIOT_Fail() throws Exception {
        // Corpo inválido (nome e modelo vazios)
        String body = """
            {
                "id": null,
                "nome": "",
                "modelo": "",
                "fabricante": "TechSens"
            }
            """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/dispositivo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }
}