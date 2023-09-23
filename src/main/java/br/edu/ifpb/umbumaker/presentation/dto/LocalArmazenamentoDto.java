package br.edu.ifpb.umbumaker.presentation.dto;

import br.edu.ifpb.umbumaker.model.LocalArmazenamento;

public class LocalArmazenamentoDto implements IDto<LocalArmazenamento> {
	private Long codigoArmario;
	private Long codigoNicho;
	
	public LocalArmazenamentoDto(Long codigoArmario, Long codigoNicho) {
		this.codigoArmario = codigoArmario;
		this.codigoNicho = codigoNicho;
	}

	public Long getCodigoArmario() {
		return codigoArmario;
	}

	public void setCodigoArmario(Long codigoArmario) {
		this.codigoArmario = codigoArmario;
	}

	public Long getCodigoNicho() {
		return codigoNicho;
	}

	public void setCodigoNicho(Long codigoNicho) {
		this.codigoNicho = codigoNicho;
	}

	@Override
	public LocalArmazenamento toModel() {
		return new LocalArmazenamento (this.codigoArmario, this.codigoNicho);
	}
}