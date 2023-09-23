package br.edu.ifpb.umbumaker.model;

import br.edu.ifpb.umbumaker.presentation.dto.LocalArmazenamentoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LocalArmazenamento implements IModel<LocalArmazenamentoDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoArmario;
	private Long codigoNicho;
	
	public LocalArmazenamento(Long codigoArmario, Long codigoNicho) {
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
	public LocalArmazenamentoDto toDto() {
		return new LocalArmazenamentoDto (this.codigoArmario, this.codigoNicho);
	}

}