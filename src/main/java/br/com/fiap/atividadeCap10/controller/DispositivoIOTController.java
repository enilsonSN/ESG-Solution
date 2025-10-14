package br.com.fiap.atividadeCap10.controller;

import br.com.fiap.atividadeCap10.dto.DispositivoIOTCadastroDto;
import br.com.fiap.atividadeCap10.dto.DispositivoIOTDto;
import br.com.fiap.atividadeCap10.model.DispositivoIOT;
import br.com.fiap.atividadeCap10.service.DispositivoIOTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DispositivoIOTController {

    @Autowired
    private DispositivoIOTService service;


    @PostMapping("/dispositivo")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DispositivoIOTDto> cadastrarDispositivo(@RequestBody @Valid DispositivoIOTCadastroDto dispositivoIOTCadastroDto){
        DispositivoIOTDto dispositivoIOTDto = service.cadastrarDispositivo(dispositivoIOTCadastroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoIOTDto);
    }

    @GetMapping("/dispositivo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DispositivoIOTDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/dispositivo/{id}")
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @GetMapping("/dispositivo")
    @ResponseStatus(HttpStatus.OK)
    public List<DispositivoIOT> listarTodos(){
        return service.listarTodosOsDispositivos();
    }
}
