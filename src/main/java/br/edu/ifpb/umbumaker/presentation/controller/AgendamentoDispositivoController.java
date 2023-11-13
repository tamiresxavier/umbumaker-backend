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

import br.edu.ifpb.umbumaker.business.service.AgendamentoDispositivoService;
import br.edu.ifpb.umbumaker.model.AgendamentoDispositivo;
import jakarta.persistence.EntityNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/agendamentodispositivo")
public class AgendamentoDispositivoController {

    @Autowired
    private AgendamentoDispositivoService agendamentoDispositivoService;

    @PostMapping
    public ResponseEntity<AgendamentoDispositivo> criarAgendamentoDispositivo(@RequestBody AgendamentoDispositivo agendamentoDispositivo) {
    	AgendamentoDispositivo novoAgendamentoDispositivo = agendamentoDispositivoService.criarAgendamentoDispositivo(agendamentoDispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamentoDispositivo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<AgendamentoDispositivo> atualizarAgendamentoDispositivo(@PathVariable Long codigo, @RequestBody AgendamentoDispositivo agendamentoDispositivo) {
        try {
        	AgendamentoDispositivo agendamentoDispositivoAtualizado = agendamentoDispositivoService.atualizarAgendamentoDispositivo(codigo, agendamentoDispositivo);
            return ResponseEntity.ok(agendamentoDispositivoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarAgendamentoDispositivo(@PathVariable Long codigo) {
        try {
        	agendamentoDispositivoService.deletarAgendamentoDispositivo(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDispositivo>> listarAgendamentoDispositivos() {
        List<AgendamentoDispositivo> agendamentoDispositivos = agendamentoDispositivoService.listarAgendamentoDispositivos();
        return ResponseEntity.ok(agendamentoDispositivos);
    }

}