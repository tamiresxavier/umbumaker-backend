package br.edu.ifpb.umbumaker.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.FilamentoService;
import br.edu.ifpb.umbumaker.model.Filamento;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/filamento")
public class FilamentoController {
    private final FilamentoService filamentoService;

    @Autowired
    public FilamentoController(FilamentoService filamentoService) {
        this.filamentoService = filamentoService;
    }

    @GetMapping("/dispositivo/{dispositivoId}")
    public List<Filamento> getFilamentosByDispositivoId(@PathVariable Long dispositivoId) {
        return filamentoService.getFilamentosByDispositivoId(dispositivoId);
    }

    // Endpoint para criar filamentos (se necessário)
    @PostMapping
    public Filamento criarFilamento(@RequestBody Filamento filamento) {
        return filamentoService.criarFilamento(filamento);
    }

}