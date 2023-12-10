package com.github.guilhermevictorlima.hotelapi.model.entity;

import com.github.guilhermevictorlima.hotelapi.model.enums.Comodidade;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Entity
public class ComodidadesQuarto {

    @Id
    @EmbeddedId
    private PkComodidadesQuarto pk;

    public ComodidadesQuarto() {}

    public ComodidadesQuarto(Quarto quarto, Comodidade comodidade) {
        this.pk = new PkComodidadesQuarto(quarto, comodidade);
    }

    public Comodidade getComodidade() {
        return pk.getComodidade();
    }

    public void setComodidade(Comodidade comodidade) {
        this.pk.setComodidade(comodidade);
    }

    public Quarto getQuarto() {
        return pk.getQuarto();
    }

    public void setQuarto(Quarto quarto) {
        this.pk.setQuarto(quarto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ComodidadesQuarto that = (ComodidadesQuarto) o;

        return new EqualsBuilder()
                .append(getComodidade(), that.getComodidade())
                .append(getQuarto(), that.getQuarto())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getComodidade())
                .append(getQuarto())
                .toHashCode();
    }

    @Embeddable
    private static class PkComodidadesQuarto implements Serializable {

        @ManyToOne
        @JoinColumn(name = "quarto_id")
        private Quarto quarto;

        @Enumerated(EnumType.STRING)
        private Comodidade comodidade;

        public PkComodidadesQuarto() {}

        public PkComodidadesQuarto(Quarto quarto, Comodidade comodidade) {
            this.comodidade = comodidade;
            this.quarto = quarto;
        }

        public Comodidade getComodidade() {
            return comodidade;
        }

        public void setComodidade(Comodidade comodidade) {
            this.comodidade = comodidade;
        }

        public Quarto getQuarto() {
            return quarto;
        }

        public void setQuarto(Quarto quarto) {
            this.quarto = quarto;
        }
    }

}
