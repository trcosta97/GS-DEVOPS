package com.br.global.apialimentos.domain;

public record RestauranteDTO(String nome, String email, String senha, String cnpj, EnderecoRestauranteDTO endereco) {
}
