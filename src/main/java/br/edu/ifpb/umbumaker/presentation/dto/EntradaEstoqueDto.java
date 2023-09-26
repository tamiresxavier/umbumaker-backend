package br.edu.ifpb.umbumaker.presentation.dto;

import java.time.LocalDate;
import br.edu.ifpb.umbumaker.model.EntradaEstoque;

public class EntradaEstoqueDto implements IDto<EntradaEstoque> {
	private LocalDate dataSaida;
	private float quantidade;
	
	public EntradaEstoqueDto(LocalDate dataSaida, float quantidade) {
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
	public EntradaEstoque toModel() {
		return new EntradaEstoque (this.dataSaida, this.quantidade);
	}
	
}