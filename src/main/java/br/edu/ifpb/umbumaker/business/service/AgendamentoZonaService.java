package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.AgendamentoZona;
import br.edu.ifpb.umbumaker.model.repository.AgendamentoZonaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendamentoZonaService {
	
	@Autowired
    private AgendamentoZonaRepository agendamentoZonaRepository;

    public AgendamentoZona criarAgendamentoZona(AgendamentoZona agendamentoZona) {
        return agendamentoZonaRepository.save(agendamentoZona);
    }

    public AgendamentoZona atualizarAgendamentoZona(Long codigo, AgendamentoZona agendamentoZona) {
    	AgendamentoZona agendamentoZonaExistente = agendamentoZonaRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento de dispositivo não encontrado."));

    	//agendamentoZonaExistente.setCodigo(agendamentoZona.getCodigo());  
    	agendamentoZonaExistente.setDataSolicitacao(agendamentoZona.getDataSolicitacao());
    	agendamentoZonaExistente.setDataAgendamento(agendamentoZona.getDataAgendamento());
    	agendamentoZonaExistente.setTempoReservado(agendamentoZona.getTempoReservado());
    	agendamentoZonaExistente.setHoraInicial(agendamentoZona.getHoraInicial());
    	agendamentoZonaExistente.setHoraFinal(agendamentoZona.getHoraFinal());
    	agendamentoZonaExistente.setDataDeTermino(agendamentoZona.getDataDeTermino());
    	agendamentoZonaExistente.setDescricao(agendamentoZona.getDescricao());
    	agendamentoZonaExistente.setPoliticaDeAceite(agendamentoZona.getPoliticaDeAceite());
    	agendamentoZonaExistente.setDiasDaSemana(agendamentoZona.getDiasDaSemana());
    	agendamentoZonaExistente.setZonas(agendamentoZona.getZonas());
    	agendamentoZonaExistente.setTutores(agendamentoZona.getTutores());
    	
        return agendamentoZonaRepository.save(agendamentoZonaExistente);
    }

    public void deletarAgendamentoZona(Long codigo) {
        if (!agendamentoZonaRepository.existsById(codigo)) {
            throw new EntityNotFoundException("Agendamento de zona não encontrado.");
        }

        agendamentoZonaRepository.deleteById(codigo);
        
    }

    public List<AgendamentoZona> listarAgendamentoZonas() {
        return agendamentoZonaRepository.findAll();
    }
    
}