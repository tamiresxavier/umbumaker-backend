package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;

import br.edu.ifpb.umbumaker.presentation.dto.IDto;
import br.edu.ifpb.umbumaker.presentation.dto.SaidaEstoqueDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SaidaEstoque implements IDto<SaidaEstoqueDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private LocalDate dataEntrada;
	private LocalDate dataValidade;
	private float quantidade;
	
	public SaidaEstoque(LocalDate dataEntrada, LocalDate dataValidade, float quantidade) {
		this.dataEntrada = dataEntrada;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
	}

	public SaidaEstoque() {
		
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
	public SaidaEstoqueDto toModel() {
		return new SaidaEstoqueDto(this.dataEntrada, this.dataValidade, this.quantidade);
	}
	
}