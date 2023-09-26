package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntradaEstoque {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private LocalDate dataSaida;
	private float quantidade;
	
	public EntradaEstoque(LocalDate dataSaida, float quantidade) {
		this.dataSaida = dataSaida;
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

}