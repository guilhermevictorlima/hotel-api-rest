package com.github.guilhermevictorlima.hotelapi.service;

import com.github.guilhermevictorlima.hotelapi.model.dto.QuartoDTO;
import com.github.guilhermevictorlima.hotelapi.model.entity.Quarto;
import com.github.guilhermevictorlima.hotelapi.model.form.CadastrarQuartoForm;
import com.github.guilhermevictorlima.hotelapi.repository.QuartoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class QuartoService {

    private final QuartoRepository repository;

    public QuartoService(QuartoRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackOn = Exception.class)
    public QuartoDTO cadastrar(CadastrarQuartoForm cadastrarQuartoForm) {
        Quarto quartoSalvo = repository.save(new Quarto(cadastrarQuartoForm));
        return QuartoDTO.from(quartoSalvo);
    }

}
