package com.br.global.apialimentos.domain;

public record UsuarioDTO(String nome, String email, String senha, String cnpj, EnderecoUsuarioDTO endereco) {
}
