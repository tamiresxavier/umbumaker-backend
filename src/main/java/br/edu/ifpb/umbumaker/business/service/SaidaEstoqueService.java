package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.SaidaEstoque;
import br.edu.ifpb.umbumaker.model.repository.SaidaEstoqueRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SaidaEstoqueService {
	
	@Autowired
    private SaidaEstoqueRepository saidaEstoqueRepository;

    public SaidaEstoque criarSaidaEstoque(SaidaEstoque saidaEstoque) {
        return saidaEstoqueRepository.save(saidaEstoque);
    }

    public SaidaEstoque atualizarSaidaEstoque(Long codigo, SaidaEstoque saidaEstoque) {
    	SaidaEstoque saidaEstoqueExistente = saidaEstoqueRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Saida de Estoque não encontrado."));

    	saidaEstoqueExistente.setCodigo(saidaEstoque.getCodigo());  
    	saidaEstoqueExistente.setDataSaida(saidaEstoque.getDataSaida());
    	saidaEstoqueExistente.setQuantidade(saidaEstoque.getQuantidade());
    
        return saidaEstoqueRepository.save(saidaEstoqueExistente);
    }

    public void deletarSaidaEstoque(Long codigo) {
        if (!saidaEstoqueRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Saida de Estoque não encontrado.");
        }

        saidaEstoqueRepository.deleteById(codigo);
    }

    public List<SaidaEstoque> listarSaidaEstoques() {
        return saidaEstoqueRepository.findAll();
    }
    
}