package br.edu.ifpb.umbumaker.presentation.controller;

import br.edu.ifpb.umbumaker.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.DispositivoService;
import br.edu.ifpb.umbumaker.model.Dispositivo;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/dispositivos")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping
    public ResponseEntity<Dispositivo> criarDispositivo(@RequestBody Dispositivo dispositivo) {
    	Dispositivo novoDispositivo = dispositivoService.criarDispositivo(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDispositivo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Dispositivo> update(@PathVariable(value = "codigo") Long codigo, @RequestBody Dispositivo dispositivoModel, HttpServletRequest request){
        var dispositivo = this.dispositivoService.findById(codigo).orElse(null);
        if(dispositivo == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(dispositivo);
        }
        Utils.copyNonNUllProperties(dispositivoModel,dispositivo);
        var dispositivoUpdate =  this.dispositivoService.atualizarDispositivo(dispositivo.getCodigo(),dispositivo);
        return ResponseEntity.ok().body(dispositivoUpdate);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarDispositivo(@PathVariable(value = "codigo")  Long codigo) {
        try {
        	dispositivoService.deletarDispositivo(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Dispositivo>> listarDispositivos() {
        List<Dispositivo> dispositivos = dispositivoService.listarDispositivos();
        return ResponseEntity.ok(dispositivos);
    }

}