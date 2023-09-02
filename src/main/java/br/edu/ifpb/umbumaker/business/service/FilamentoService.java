package br.edu.ifpb.umbumaker.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.Filamento;
import br.edu.ifpb.umbumaker.model.repository.FilamentoRepository;

import java.util.List;

@Service
public class FilamentoService {
    private final FilamentoRepository filamentoRepository;

    @Autowired
    public FilamentoService(FilamentoRepository filamentoRepository) {
        this.filamentoRepository = filamentoRepository;
    }

    public List<Filamento> getFilamentosByDispositivoId(Long dispositivoId) {
        return filamentoRepository.findByDispositivoCodigo(dispositivoId);
    }

	public Filamento criarFilamento(Filamento filamento) {
		return filamentoRepository.save(filamento);
	}

}