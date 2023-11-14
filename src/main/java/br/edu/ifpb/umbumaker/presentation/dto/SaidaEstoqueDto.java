package br.edu.ifpb.umbumaker.presentation.dto;

import java.time.LocalDate;
import br.edu.ifpb.umbumaker.model.SaidaEstoque;

public class SaidaEstoqueDto implements IDto<SaidaEstoque> {
	private LocalDate dataSaida;
	private float quantidade;
	
	public SaidaEstoqueDto(LocalDate dataSaida, float quantidade) {
		this.dataSaida = dataSaida;
		this.quantidade = quantidade;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public SaidaEstoque toModel() {
		return new SaidaEstoque (this.dataSaida, this.quantidade);
	}
	
}