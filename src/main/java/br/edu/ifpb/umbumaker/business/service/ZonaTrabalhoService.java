package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.ZonaTrabalho;
import br.edu.ifpb.umbumaker.model.repository.ZonaTrabalhoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ZonaTrabalhoService {
	
	@Autowired
    private ZonaTrabalhoRepository zonaTrabalhoRepository;

    public ZonaTrabalho criarZonaTrabalho(ZonaTrabalho zonaTrabalho) {
        return zonaTrabalhoRepository.save(zonaTrabalho);
    }

    public ZonaTrabalho atualizarZonaTrabalho(Long codigo, ZonaTrabalho zonaTrabalho) {
    	ZonaTrabalho zonaTrabalhoExistente = zonaTrabalhoRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Zona de Trabalho não encontrada."));

    	zonaTrabalhoExistente.setNome(zonaTrabalho.getNome());  
    	zonaTrabalhoExistente.setDataAgendada(zonaTrabalho.getDataAgendada());
    	zonaTrabalhoExistente.setTempoReservado(zonaTrabalho.getTempoReservado());
    	zonaTrabalhoExistente.setReservada(zonaTrabalho.isReservada());
    	zonaTrabalhoExistente.setQtdPessoas(zonaTrabalho.getQtdPessoas());
    	zonaTrabalhoExistente.setEquipamentos(zonaTrabalho.getEquipamentos());
    	
        return zonaTrabalhoRepository.save(zonaTrabalhoExistente);
    }

    public void deletarZonaTrabalho(Long codigo) {
        if (!zonaTrabalhoRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Zona de Trabalho não encontrada.");
        }

        zonaTrabalhoRepository.deleteById(codigo);
    }

    public List<ZonaTrabalho> listarZonaTrabalhos() {
        return zonaTrabalhoRepository.findAll();
    }
    
}