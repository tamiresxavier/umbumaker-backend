package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;

import br.edu.ifpb.umbumaker.presentation.dto.SaidaEstoqueDto;
import br.edu.ifpb.umbumaker.presentation.dto.IDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SaidaEstoque implements IDto<SaidaEstoqueDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private LocalDate dataSaida;
	private float quantidade;
	
	public SaidaEstoque(LocalDate dataSaida, float quantidade) {
		this.dataSaida = dataSaida;
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
	public SaidaEstoqueDto toModel() {
		return new SaidaEstoqueDto (this.dataSaida, this.quantidade);
	}

}