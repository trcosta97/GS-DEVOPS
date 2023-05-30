package com.br.global.apialimentos.service;

import com.br.global.apialimentos.domain.Restaurante;
import com.br.global.apialimentos.domain.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    public Restaurante salvarRestaurante(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }


    public List<Restaurante> todosRestaurantesAtivos() {
        return restauranteRepository.findAllByAtivoTrue();
    }

    public Restaurante loginRestaurante(String email, String senha){
        return restauranteRepository.findAllByEmailAndSenha(email, senha);
    }

    public Restaurante findRestauranteById(Long id){
        Optional<Restaurante> optionalRestaurante = restauranteRepository.findById(id);
        return optionalRestaurante.orElse(null);
    }


}
