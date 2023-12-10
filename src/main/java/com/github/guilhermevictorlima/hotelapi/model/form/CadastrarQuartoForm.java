package com.github.guilhermevictorlima.hotelapi.model.form;

import com.github.guilhermevictorlima.hotelapi.model.enums.Comodidade;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class CadastrarQuartoForm {

    @NotBlank
    @Size(max = 100)
    private String titulo;
    @NotBlank
    @Size(max = 1000)
    private String descricao;
    @Min(1)
    private int capacidadeMaxima;
    @Min(1)
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
