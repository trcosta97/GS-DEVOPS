package com.br.global.apialimentos.service;

import com.br.global.apialimentos.domain.Alimento;
import com.br.global.apialimentos.domain.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentoService {

    @Autowired
    AlimentoRepository alimentoRepository;


    public Alimento salvarAlimento(Alimento newAlimento){
            return alimentoRepository.save(newAlimento);
    }

    public Alimento findById(Long id){
        Optional<Alimento> optionalAlimento = alimentoRepository.findById(id);
        return optionalAlimento.orElse(null);
    }

    public List<Alimento> todosAlimentosAtivos(){
        return alimentoRepository.findAllByAtivoTrue();
    }

    public Alimento removerAlimento(Long id){
        Optional<Alimento> optionalAlimento = alimentoRepository.findById(id);
        if(optionalAlimento.isPresent()){
            Alimento alimentoRemovido = optionalAlimento.get();
            alimentoRemovido.desativarAlimento();
            alimentoRepository.save(alimentoRemovido);
            return alimentoRemovido;
        }
        return null;
    }
}
