package com.github.guilhermevictorlima.hotelapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
public class Quarto {

    @Id
    @GeneratedValue(generator="seq_quarto", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_quarto", sequenceName="seq_quarto", allocationSize = 1)
    private Long quartoId;

    @OneToMany(mappedBy = "pk.quarto")
    private List<ComodidadesQuarto> comodidades;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 1000, nullable = false)
    private String descricao;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int capacidadeMaxima;

    @Column(nullable = false)
    private int dimensao;

    public Long getQuartoId() {
        return quartoId;
    }

    public List<ComodidadesQuarto> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<ComodidadesQuarto> comodidades) {
        this.comodidades = comodidades;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Quarto quarto = (Quarto) o;

        return new EqualsBuilder()
                .append(capacidadeMaxima, quarto.capacidadeMaxima)
                .append(dimensao, quarto.dimensao)
                .append(comodidades, quarto.comodidades)
                .append(titulo, quarto.titulo)
                .append(descricao, quarto.descricao)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(quartoId)
                .append(comodidades)
                .append(titulo)
                .append(descricao)
                .append(capacidadeMaxima)
                .append(dimensao)
                .toHashCode();
    }
}
