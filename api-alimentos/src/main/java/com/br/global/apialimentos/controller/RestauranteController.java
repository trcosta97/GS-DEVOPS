package com.br.global.apialimentos.controller;


import com.br.global.apialimentos.domain.Restaurante;
import com.br.global.apialimentos.domain.RestauranteDTO;
import com.br.global.apialimentos.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/restaurantes")
    public ResponseEntity<Restaurante> salvarRestaurante(@RequestBody RestauranteDTO dados){
        var newRestaurante = new Restaurante(dados);
        Restaurante restauranteSalvo = restauranteService.salvarRestaurante(newRestaurante);
        return ResponseEntity.ok(restauranteSalvo);
    }

    @PostMapping("/restaurantes/login")
    public ResponseEntity<String> loginUsuario(@RequestParam String email, @RequestParam String senha){
        Restaurante restaurante = restauranteService.loginRestaurante(email, senha);
        if(restaurante !=null){
            return ResponseEntity.ok("Login realizado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Dados de login inválidos");
        }
    }

    @GetMapping("/restaurantes")
    public ResponseEntity<List<Restaurante>> todosRestaurantes(){
        List<Restaurante> restaurantesAtivos = restauranteService.todosRestaurantesAtivos();
        return ResponseEntity.ok(restaurantesAtivos);
    }

}
