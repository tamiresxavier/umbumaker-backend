package br.edu.ifpb.umbumaker.presentation.dto;

import java.time.LocalDate;

import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.ZonaTrabalho;

public class ZonaTrabalhoDto implements IDto<ZonaTrabalho> {
	private String nome;
	private LocalDate dataAgendada;
	private LocalDate tempoReservado;
	private boolean reservada;
	private Integer qtdPessoas;
	private Dispositivo equipamentos;
	
	public ZonaTrabalhoDto(String nome, LocalDate dataAgendada, LocalDate tempoReservado, boolean reservada,
			Integer qtdPessoas, Dispositivo equipamentos) {
		this.nome = nome;
		this.dataAgendada = dataAgendada;
		this.tempoReservado = tempoReservado;
		this.reservada = reservada;
		this.qtdPessoas = qtdPessoas;
		this.equipamentos = equipamentos;
	}

	public ZonaTrabalhoDto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(LocalDate dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public LocalDate getTempoReservado() {
		return tempoReservado;
	}

	public void setTempoReservado(LocalDate tempoReservado) {
		this.tempoReservado = tempoReservado;
	}

	public boolean isReservada() {
		return reservada;
	}

	public void setReservada(boolean reservada) {
		this.reservada = reservada;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Dispositivo getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(Dispositivo equipamentos) {
		this.equipamentos = equipamentos;
	}

	@Override
	public ZonaTrabalho toModel() {
		return new ZonaTrabalho(this.nome, this.dataAgendada, this.tempoReservado, this.reservada,
				this.qtdPessoas, this.equipamentos);
	}

}