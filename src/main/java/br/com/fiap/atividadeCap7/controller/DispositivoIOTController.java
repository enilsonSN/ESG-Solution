package br.com.fiap.atividadeCap7.controller;

import br.com.fiap.atividadeCap7.model.DispositivoIOT;
import br.com.fiap.atividadeCap7.service.DispositivoIOTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DispositivoIOTController {

    @Autowired
    private DispositivoIOTService service;

    @PostMapping("/dispositivo")
    @ResponseStatus(HttpStatus.CREATED)
    public DispositivoIOT cadastrarDispositivo(@Valid @RequestBody DispositivoIOT dispositivo) {
        return service.cadastrar(dispositivo);
    }

    @GetMapping("/dispositivo")
    @ResponseStatus(HttpStatus.OK)
    public List<DispositivoIOT> listar() {
        return service.listar();
    }

    @DeleteMapping("/dispositivo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {

    }
}
