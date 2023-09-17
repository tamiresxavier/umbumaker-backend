package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.repository.DispositivoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivoService {
	
	@Autowired
    private DispositivoRepository dispositivoRepository;

    public Dispositivo criarDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public Dispositivo atualizarDispositivo(Long codigo, Dispositivo dispositivo) {
    	Dispositivo dispositivoExistente = dispositivoRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Dispositivo não encontrado."));

    	dispositivoExistente.setModelo(dispositivo.getModelo());  
    	dispositivoExistente.setUltimaManutencao(dispositivo.getUltimaManutencao());
    	dispositivoExistente.setTemperaturaMaxima(dispositivo.getTemperaturaMaxima());
    	dispositivoExistente.setEixoX(dispositivo.getEixoX());
    	dispositivoExistente.setEixoY(dispositivo.getEixoY());
    	dispositivoExistente.setEixoZ(dispositivo.getEixoZ());
    	dispositivoExistente.setTipo(dispositivo.getTipo());
    	dispositivoExistente.setTipoFilamentoSuportado(dispositivo.getTipoFilamentoSuportado());

        return dispositivoRepository.save(dispositivoExistente);
    }

    public void deletarDispositivo(Long codigo) {
        if (!dispositivoRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Dispositivo não encontrado.");
        }

        dispositivoRepository.deleteById(codigo);
    }

    public List<Dispositivo> listarDispositivos() {
        return dispositivoRepository.findAll();
    }
    
}