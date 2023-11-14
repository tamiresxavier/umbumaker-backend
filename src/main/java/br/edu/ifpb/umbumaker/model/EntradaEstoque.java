package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;

import br.edu.ifpb.umbumaker.presentation.dto.IDto;
import br.edu.ifpb.umbumaker.presentation.dto.EntradaEstoqueDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntradaEstoque implements IDto<EntradaEstoqueDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private LocalDate dataEntrada;
	private LocalDate dataValidade;
	private float quantidade;
	
	public EntradaEstoque(LocalDate dataEntrada, LocalDate dataValidade, float quantidade) {
		this.dataEntrada = dataEntrada;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
	}

	public EntradaEstoque() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public EntradaEstoqueDto toModel() {
		return new EntradaEstoqueDto(this.dataEntrada, this.dataValidade, this.quantidade);
	}
	
}