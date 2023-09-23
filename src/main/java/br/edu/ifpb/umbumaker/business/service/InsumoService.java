package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.Insumo;
import br.edu.ifpb.umbumaker.model.repository.InsumoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class InsumoService {
	
	@Autowired
    private InsumoRepository insumoRepository;

    public Insumo criarInsumo(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    public Insumo atualizarInsumo(Long codigo, Insumo insumo) {
    	Insumo insumoExistente = insumoRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Insumo não encontrado."));

    	insumoExistente.setNome(insumo.getNome());  
    	insumoExistente.setQuantidadeTotal(insumo.getQuantidadeTotal());
    	insumoExistente.setQuantidadeMinimaEstoque(insumo.getQuantidadeMinimaEstoque());
    	insumoExistente.setQuantidadeDiasAlertaVencimento(insumo.getQuantidadeDiasAlertaVencimento());
    	insumoExistente.setUnidadeMedida(insumo.getUnidadeMedida());
    	insumoExistente.setArmario(insumo.getArmario());
    	insumoExistente.setNicho(insumo.getNicho());
    	
        return insumoRepository.save(insumoExistente);
    }

    public void deletarInsumo(Long codigo) {
        if (!insumoRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Insumo não encontrado.");
        }

        insumoRepository.deleteById(codigo);
    }

    public List<Insumo> listarInsumos() {
        return insumoRepository.findAll();
    }
    
}