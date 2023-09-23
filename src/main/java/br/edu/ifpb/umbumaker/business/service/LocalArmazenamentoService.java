package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.LocalArmazenamento;
import br.edu.ifpb.umbumaker.model.repository.LocalArmazenamentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LocalArmazenamentoService {
	
	@Autowired
    private LocalArmazenamentoRepository localArmazenamentoRepository;

    public LocalArmazenamento criarLocalArmazenamento(LocalArmazenamento localArmazenamento) {
        return localArmazenamentoRepository.save(localArmazenamento);
    }

    public LocalArmazenamento atualizarLocalArmazenamento(Long codigo, LocalArmazenamento localArmazenamento) {
    	LocalArmazenamento localArmazenamentoExistente = localArmazenamentoRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Local de Armazenamento não encontrado."));

    	localArmazenamentoExistente.setCodigoArmario(localArmazenamento.getCodigoArmario());  
    	localArmazenamentoExistente.setCodigoNicho(localArmazenamento.getCodigoNicho());
    
        return localArmazenamentoRepository.save(localArmazenamentoExistente);
    }

    public void deletarLocalArmazenamento(Long codigo) {
        if (!localArmazenamentoRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Local de Armazenamento não encontrado.");
        }

        localArmazenamentoRepository.deleteById(codigo);
    }

    public List<LocalArmazenamento> listarLocalArmazenamentos() {
        return localArmazenamentoRepository.findAll();
    }
    
}