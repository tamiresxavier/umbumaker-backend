package br.edu.ifpb.umbumaker.presentation.controller;

import br.edu.ifpb.umbumaker.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.InsumoService;
import br.edu.ifpb.umbumaker.model.Insumo;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/insumos")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;


    @PostMapping
    public ResponseEntity<Insumo> criarInsumo(@RequestBody Insumo insumo) {
    	Insumo novoInsumo = insumoService.criarInsumo(insumo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoInsumo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Insumo> atualizarInsumo(@PathVariable Long codigo, @RequestBody Insumo insumoModel) {
        var insumo = this.insumoService.findById(codigo).orElse(null);
        if(insumo == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(insumo);
        }
        Utils.copyNonNUllProperties(insumoModel,insumo);
        var dispositivoUpdate =  this.insumoService.atualizarInsumo(insumo.getCodigo(),insumo);
        return ResponseEntity.ok().body(dispositivoUpdate);
    }
    
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarInsumo(@PathVariable Long codigo) {
        try {
        	insumoService.deletarInsumo(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Insumo>> listarInsumos() {
        List<Insumo> insumos = insumoService.listarInsumos();
        return ResponseEntity.ok(insumos);
    }

}