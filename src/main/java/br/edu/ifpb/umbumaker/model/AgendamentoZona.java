package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;

import br.edu.ifpb.umbumaker.presentation.dto.DispositivoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AgendamentoZona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private LocalDate dataSolicitacao;
	private LocalDate dataAgendamento;
	private LocalDate tempoReservado;
	private LocalDate horaInicial;
	private LocalDate horaFinal;
	private LocalDate dataDeTermino;
	private String descricao;
	private String politicaDeAceite;

	//diasDaSemana:Array<DiasDaSemana>
	//zonas:Array<ZonaTrabalho>
	//colaboradores:Array<Colaboradores>
	
}