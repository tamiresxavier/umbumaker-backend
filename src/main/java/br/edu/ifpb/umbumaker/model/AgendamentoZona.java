package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.umbumaker.model.enums.DiasDaSemana;
import br.edu.ifpb.umbumaker.presentation.dto.AgendamentoZonaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class AgendamentoZona implements IModel<AgendamentoZonaDto> {
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

	@Enumerated(EnumType.STRING)
	private List<DiasDaSemana> diasDaSemana;
	
	@OneToMany
	@JoinColumn(name = "zonas")
	private List<ZonaTrabalho> zonas;
	
	@OneToMany
	@JoinColumn(name = "tutores")
	private List<Tutor> tutores;

	public AgendamentoZona(LocalDate dataSolicitacao, LocalDate dataAgendamento, LocalDate tempoReservado,
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

	public AgendamentoZona() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public AgendamentoZonaDto toDto() {
		return new AgendamentoZonaDto (this.dataSolicitacao, this.dataAgendamento, this.tempoReservado,
				this.horaInicial, this.horaFinal, this.dataDeTermino, this.descricao, this.politicaDeAceite, 
				this.diasDaSemana, this.zonas, this.tutores);
	}
	
}