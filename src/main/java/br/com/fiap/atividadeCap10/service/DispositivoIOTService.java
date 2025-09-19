package br.com.fiap.atividadeCap10.service;

import br.com.fiap.atividadeCap10.dto.DispositivoIOTCadastroDto;
import br.com.fiap.atividadeCap10.dto.DispositivoIOTDto;
import br.com.fiap.atividadeCap10.model.DispositivoIOT;
import br.com.fiap.atividadeCap10.repository.DispositivoIOTRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoIOTService {

    @Autowired
    private DispositivoIOTRepository dispositivoIOTRepository;


    public DispositivoIOTDto buscarPorId(Long id){

        Optional<DispositivoIOT> dispositivoIOTOptional = dispositivoIOTRepository.findById(id);

        if (dispositivoIOTOptional.isPresent()){
            DispositivoIOTDto dispositivoIOTDto = new DispositivoIOTDto(
                    dispositivoIOTOptional.get().getId(),
                    dispositivoIOTOptional.get().getNome(),
                    dispositivoIOTOptional.get().fabricante,
                    dispositivoIOTOptional.get().modelo
            );
            return dispositivoIOTDto;
        } else {
            throw new RuntimeException("Dispositivo não Existe!!!");
        }
    }

    public DispositivoIOTDto cadastrarDispositivo(DispositivoIOTCadastroDto dispositivoIOTCadastroDto){
        DispositivoIOT dispositivo = new DispositivoIOT();
        BeanUtils.copyProperties(dispositivoIOTCadastroDto, dispositivo);

        return new DispositivoIOTDto(dispositivoIOTRepository.save(dispositivo));
    }

    public List<DispositivoIOT> listarTodosOsDispositivos(){
        return dispositivoIOTRepository.findAll();
    }

    public void excluir(Long id){
        Optional<DispositivoIOT> dispositivoIOTOptional = dispositivoIOTRepository.findById(id);

        if(dispositivoIOTOptional.isPresent()){
            dispositivoIOTRepository.delete(dispositivoIOTOptional.get());
        }
    }
}

