package com.github.guilhermevictorlima.hotelapi.controller;

import com.github.guilhermevictorlima.hotelapi.model.dto.QuartoDTO;
import com.github.guilhermevictorlima.hotelapi.model.form.CadastrarQuartoForm;
import com.github.guilhermevictorlima.hotelapi.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/quartos")
public class QuartoController {

    private final QuartoService service;

    public QuartoController(QuartoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public QuartoDTO obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PostMapping
    public QuartoDTO cadastrar(@RequestBody @Valid CadastrarQuartoForm form) {
        return service.cadastrar(form);
    }

}
