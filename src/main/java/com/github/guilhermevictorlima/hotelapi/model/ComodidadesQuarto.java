package com.github.guilhermevictorlima.hotelapi.model;

import com.github.guilhermevictorlima.hotelapi.model.enums.Comodidade;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Entity
public class ComodidadesQuarto {

    @Id
    @EmbeddedId
    private PkComodidadesQuarto pk;

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

        @Enumerated(EnumType.STRING)
        private Comodidade comodidade;

        @ManyToOne
        @JoinColumn(name = "quarto_id")
        private Quarto quarto;

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
