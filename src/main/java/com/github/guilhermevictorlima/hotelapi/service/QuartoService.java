package com.github.guilhermevictorlima.hotelapi.service;

import com.github.guilhermevictorlima.hotelapi.model.dto.QuartoDTO;
import com.github.guilhermevictorlima.hotelapi.model.entity.ComodidadesQuarto;
import com.github.guilhermevictorlima.hotelapi.model.entity.ComodidadesQuarto.PkComodidadesQuarto;
import com.github.guilhermevictorlima.hotelapi.model.entity.Quarto;
import com.github.guilhermevictorlima.hotelapi.model.form.CadastrarQuartoForm;
import com.github.guilhermevictorlima.hotelapi.repository.ComodidadesQuartoRepository;
import com.github.guilhermevictorlima.hotelapi.repository.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;
    private final ComodidadesQuartoRepository comodidadesQuartoRepository;

    public QuartoService(QuartoRepository quartoRepository, ComodidadesQuartoRepository comodidadesQuartoRepository) {
        this.quartoRepository = quartoRepository;
        this.comodidadesQuartoRepository = comodidadesQuartoRepository;
    }

    public QuartoDTO obter(Long id) {
        Quarto quarto = quartoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Não foi encontrado um quarto cadastrado para o ID informado"));

        return QuartoDTO.from(quarto);
    }

    @Transactional(rollbackOn = Exception.class)
    public QuartoDTO cadastrar(CadastrarQuartoForm cadastrarQuartoForm) {
        Quarto quartoSalvo = quartoRepository.save(new Quarto(cadastrarQuartoForm));

        List<ComodidadesQuarto> comodidadesParaSalvar = cadastrarQuartoForm.getComodidades()
                        .stream()
                        .map(comodidade -> new ComodidadesQuarto(quartoSalvo, comodidade))
                        .toList();

        comodidadesQuartoRepository.saveAll(comodidadesParaSalvar);

        return QuartoDTO.from(quartoSalvo);
    }

}
