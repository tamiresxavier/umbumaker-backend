package br.edu.ifpb.umbumaker.presentation.dto;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.umbumaker.model.AgendamentoZona;
import br.edu.ifpb.umbumaker.model.Tutor;
import br.edu.ifpb.umbumaker.model.ZonaTrabalho;
import br.edu.ifpb.umbumaker.model.enums.DiasDaSemana;

public class AgendamentoZonaDto implements IDto<AgendamentoZona> {
	private LocalDate dataSolicitacao;
	private LocalDate dataAgendamento;
	private LocalDate tempoReservado;
	private LocalDate horaInicial;
	private LocalDate horaFinal;
	private LocalDate dataDeTermino;
	private String descricao;
	private String politicaDeAceite;
	private List<DiasDaSemana> diasDaSemana;
	private List<ZonaTrabalho> zonas;
	private List<Tutor> tutores;
	
	public AgendamentoZonaDto(LocalDate dataSolicitacao, LocalDate dataAgendamento, LocalDate tempoReservado,
			LocalDate horaInicial, LocalDate horaFinal, LocalDate dataDeTermino, String descricao,
			String politicaDeAceite, List<DiasDaSemana> diasDaSemana, List<ZonaTrabalho> zonas, List<Tutor> tutores) {
		this.dataSolicitacao = dataSolicitacao;
		this.dataAgendamento = dataAgendamento;
		this.tempoReservado = tempoReservado;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.dataDeTermino = dataDeTermino;
		this.descricao = descricao;
		this.politicaDeAceite = politicaDeAceite;
		this.diasDaSemana = diasDaSemana;
		this.zonas = zonas;
		this.tutores = tutores;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalDate getTempoReservado() {
		return tempoReservado;
	}

	public void setTempoReservado(LocalDate tempoReservado) {
		this.tempoReservado = tempoReservado;
	}

	public LocalDate getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(LocalDate horaInicial) {
		this.horaInicial = horaInicial;
	}

	public LocalDate getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalDate horaFinal) {
		this.horaFinal = horaFinal;
	}

	public LocalDate getDataDeTermino() {
		return dataDeTermino;
	}

	public void setDataDeTermino(LocalDate dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPoliticaDeAceite() {
		return politicaDeAceite;
	}

	public void setPoliticaDeAceite(String politicaDeAceite) {
		this.politicaDeAceite = politicaDeAceite;
	}

	public List<DiasDaSemana> getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(List<DiasDaSemana> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	public List<ZonaTrabalho> getZonas() {
		return zonas;
	}

	public void setZonas(List<ZonaTrabalho> zonas) {
		this.zonas = zonas;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	@Override
	public AgendamentoZona toModel() {
		return new AgendamentoZona(this.dataSolicitacao, this.dataAgendamento, this.tempoReservado,
		this.horaInicial, this.horaFinal, this.dataDeTermino, this.descricao, this.politicaDeAceite, 
		this.diasDaSemana, this.zonas, this.tutores);
	}

}