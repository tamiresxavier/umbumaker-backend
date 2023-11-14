package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;

import br.edu.ifpb.umbumaker.presentation.dto.ZonaTrabalhoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ZonaTrabalho implements IModel<ZonaTrabalhoDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private String nome;
	private LocalDate dataAgendada;
	private LocalDate tempoReservado;
	private boolean reservada;
	private Integer qtdPessoas;
	
	@ManyToOne
	@JoinColumn(name = "dispositivo_equipamentos")
	private Dispositivo equipamentos;
	
	public ZonaTrabalho(String nome, LocalDate dataAgendada, LocalDate tempoReservado, boolean reservada,
			Integer qtdPessoas, Dispositivo equipamentos) {
		this.nome = nome;
		this.dataAgendada = dataAgendada;
		this.tempoReservado = tempoReservado;
		this.reservada = reservada;
		this.qtdPessoas = qtdPessoas;
		this.equipamentos = equipamentos;
	}
	
	public ZonaTrabalho() {
		
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public ZonaTrabalhoDto toDto() {
		return new ZonaTrabalhoDto(this.nome, this.dataAgendada, this.tempoReservado, this.reservada,
				this.qtdPessoas, this.equipamentos);
	}
	
}