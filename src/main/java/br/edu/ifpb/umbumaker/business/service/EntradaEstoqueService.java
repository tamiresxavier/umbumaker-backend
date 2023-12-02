package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.EntradaEstoque;
import br.edu.ifpb.umbumaker.model.repository.EntradaEstoqueRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EntradaEstoqueService {
	
	@Autowired
    private EntradaEstoqueRepository entradaEstoqueRepository;

    public EntradaEstoque criarEntradaEstoque(EntradaEstoque entradaEstoque) {
        return entradaEstoqueRepository.save(entradaEstoque);
    }

    public EntradaEstoque atualizarEntradaEstoque(Long codigo, EntradaEstoque entradaEstoque) {
    	EntradaEstoque entradaEstoqueExistente = entradaEstoqueRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Entrada de Estoque não encontrado."));

    	entradaEstoqueExistente.setCodigo(entradaEstoque.getCodigo());  
    	entradaEstoqueExistente.setDataEntrada(entradaEstoque.getDataEntrada());
    	entradaEstoqueExistente.setDataValidade(entradaEstoque.getDataValidade());
    	entradaEstoqueExistente.setQuantidade(entradaEstoque.getQuantidade());
    
        return entradaEstoqueRepository.save(entradaEstoqueExistente);
    }

    public void deletarEntradaEstoque(Long codigo) {
        if (!entradaEstoqueRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Entrada de Estoque não encontrado.");
        }

        entradaEstoqueRepository.deleteById(codigo);
    }

    public List<EntradaEstoque> listarEntradaEstoques() {
        return entradaEstoqueRepository.findAll();
    }
    
}