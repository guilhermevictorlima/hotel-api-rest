package com.github.guilhermevictorlima.hotelapi.model.form;

import com.github.guilhermevictorlima.hotelapi.model.enums.Comodidade;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class CadastrarQuartoForm {

    @NotBlank(message = "Forneça um título válido")
    @Size(max = 100, message = "Título deve ter no máximo 100 caracteres")
    private String titulo;
    @NotBlank(message = "Forneça uma descrção válida")
    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    private String descricao;
    @Min(value = 1, message = "A capacidade máxima deve ser de pelo menos 1 pessoa")
    private int capacidadeMaxima;
    @Min(value = 1, message = "Forneça uma dimensão em metros quadrados válida")
    private int dimensao;

    private List<Comodidade> comodidades = new ArrayList<>();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    public List<Comodidade> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<Comodidade> comodidades) {
        this.comodidades = comodidades;
    }
}
