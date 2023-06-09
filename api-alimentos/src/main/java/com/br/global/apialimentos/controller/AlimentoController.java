package com.br.global.apialimentos.controller;


import com.br.global.apialimentos.domain.Alimento;
import com.br.global.apialimentos.domain.AlimentoDTO;
import com.br.global.apialimentos.domain.Restaurante;
import com.br.global.apialimentos.service.AlimentoService;
import com.br.global.apialimentos.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/alimentos")
    public ResponseEntity<Alimento> cadastrarAlimento(@RequestBody AlimentoDTO alimentoDTO) {
        Restaurante restauranteDoador = restauranteService.findRestauranteById(alimentoDTO.restauranteDoadorId());
        if (restauranteDoador == null) {
            return ResponseEntity.notFound().build();
        }

        Alimento alimento = new Alimento(alimentoDTO);
        alimento.setRestauranteDoador(restauranteDoador);
        Alimento novoAlimento = alimentoService.salvarAlimento(alimento);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlimento);
    }



    @GetMapping("/alimentos")
    public ResponseEntity<List<Alimento>> todosAlimentosAtivos() {
        List<Alimento> alimentosAtivos = alimentoService.todosAlimentosAtivos();
        return ResponseEntity.ok(alimentosAtivos);
    }

    @DeleteMapping("/alimentos/{id}")
    @Transactional
    public ResponseEntity<Alimento> deletarAlimento(@PathVariable Long id){
        Alimento alimento = alimentoService.findById(id);
        alimentoService.removerAlimento(id);
        return ResponseEntity.ok(alimento);
    }

}
