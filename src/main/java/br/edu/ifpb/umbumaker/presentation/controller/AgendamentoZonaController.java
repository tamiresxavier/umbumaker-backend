package br.edu.ifpb.umbumaker.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.umbumaker.business.service.AgendamentoZonaService;
import br.edu.ifpb.umbumaker.model.AgendamentoZona;
import jakarta.persistence.EntityNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/agendamentozona")
public class AgendamentoZonaController {

    @Autowired
    private AgendamentoZonaService agendamentoZonaService;

    @PostMapping
    public ResponseEntity<AgendamentoZona> criarAgendamentoZona(@RequestBody AgendamentoZona agendamentoZona) {
    	AgendamentoZona novoAgendamentoZona = agendamentoZonaService.criarAgendamentoZona(agendamentoZona);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamentoZona);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<AgendamentoZona> atualizarAgendamentoZona(@PathVariable Long codigo, @RequestBody AgendamentoZona agendamentoZona) {
        try {
        	AgendamentoZona agendamentoZonaAtualizado = agendamentoZonaService.atualizarAgendamentoZona(codigo, agendamentoZona);
            return ResponseEntity.ok(agendamentoZonaAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarAgendamentoZona(@PathVariable Long codigo) {
        try {
        	agendamentoZonaService.deletarAgendamentoZona(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoZona>> listarAgendamentoZonas() {
        List<AgendamentoZona> agendamentoDispositivos = agendamentoZonaService.listarAgendamentoZonas();
        return ResponseEntity.ok(agendamentoDispositivos);
    }

}