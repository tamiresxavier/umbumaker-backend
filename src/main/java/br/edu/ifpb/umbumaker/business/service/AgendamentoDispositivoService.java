package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.AgendamentoDispositivo;
import br.edu.ifpb.umbumaker.model.repository.AgendamentoDispositivoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendamentoDispositivoService {
	
	@Autowired
    private AgendamentoDispositivoRepository agendamentoDispositivoRepository;

    public AgendamentoDispositivo criarAgendamentoDispositivo(AgendamentoDispositivo agendamentoDispositivo) {
        return agendamentoDispositivoRepository.save(agendamentoDispositivo);
    }

    public AgendamentoDispositivo atualizarAgendamentoDispositivo(Long codigo, AgendamentoDispositivo agendamentoDispositivo) {
    	AgendamentoDispositivo agendamentoDispositivoExistente = agendamentoDispositivoRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento de dispositivo não encontrado."));

    	agendamentoDispositivoExistente.setCodigo(agendamentoDispositivo.getCodigo());  
    	agendamentoDispositivoExistente.setDataSolicitacao(agendamentoDispositivo.getDataSolicitacao());
    	agendamentoDispositivoExistente.setEmail(agendamentoDispositivo.getEmail());
    	agendamentoDispositivoExistente.setDataAgendamento(agendamentoDispositivo.getDataAgendamento());
    	agendamentoDispositivoExistente.setDescricao(agendamentoDispositivo.getDescricao());
    	agendamentoDispositivoExistente.setPoliticaDeAceite(agendamentoDispositivo.getPoliticaDeAceite());
    	agendamentoDispositivoExistente.setStatus(agendamentoDispositivo.getStatus());
    	agendamentoDispositivoExistente.setDispositivos(agendamentoDispositivo.getDispositivos());
    	
        return agendamentoDispositivoRepository.save(agendamentoDispositivoExistente);
    }

    public void deletarAgendamentoDispositivo(Long codigo) {
        if (!agendamentoDispositivoRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Agendamento de dispositivo não encontrado.");
        }

        agendamentoDispositivoRepository.deleteById(codigo);
        
    }

    public List<AgendamentoDispositivo> listarAgendamentoDispositivos() {
        return agendamentoDispositivoRepository.findAll();
    }
    
}