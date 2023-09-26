package br.edu.ifpb.umbumaker.presentation.dto;

import java.time.LocalDate;

import br.edu.ifpb.umbumaker.model.SaidaEstoque;

public class SaidaEstoqueDto implements IDto<SaidaEstoque> {
	private LocalDate dataEntrada;
	private LocalDate dataValidade;
	private float quantidade;
	
	public SaidaEstoqueDto(LocalDate dataEntrada, LocalDate dataValidade, float quantidade) {
		this.dataEntrada = dataEntrada;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public SaidaEstoque toModel() {
		return new SaidaEstoque(this.dataEntrada, this.dataValidade, this.quantidade);
	}

}