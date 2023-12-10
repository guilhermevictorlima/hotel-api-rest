package com.github.guilhermevictorlima.hotelapi.model.dto;

import com.github.guilhermevictorlima.hotelapi.model.entity.ComodidadesQuarto;
import com.github.guilhermevictorlima.hotelapi.model.entity.Quarto;
import com.github.guilhermevictorlima.hotelapi.model.enums.Comodidade;

import java.util.List;

public record QuartoDTO(
    String titulo,
    String descricao,
    int capacidadeMaxima,
    int dimensao,
    List<Comodidade> comodidades
) {
    public static QuartoDTO from(Quarto quarto) {
        List<Comodidade> comodidadesDoQuarto = quarto.getComodidades()
                .stream()
                .map(ComodidadesQuarto::getComodidade)
                .toList();

        return new QuartoDTO(quarto.getTitulo(), quarto.getDescricao(), quarto.getCapacidadeMaxima(), quarto.getDimensao(), comodidadesDoQuarto);
    }
}
