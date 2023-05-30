package com.br.global.apialimentos.domain;

import java.util.List;

    public record AlimentoDTO(List<String> tags, Long restauranteDoadorId) {
}
