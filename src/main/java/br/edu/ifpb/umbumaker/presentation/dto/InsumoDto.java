package br.edu.ifpb.umbumaker.presentation.dto;

import br.edu.ifpb.umbumaker.model.Insumo;
import br.edu.ifpb.umbumaker.model.LocalArmazenamento;
import br.edu.ifpb.umbumaker.model.enums.UnidadeMedida;

public class InsumoDto implements IDto<Insumo> {
	private String nome;
	private Integer quantidadeTotal;
	private Integer quantidadeMinimaEstoque;
	private Integer quantidadeDiasAlertaVencimento;
	private UnidadeMedida unidadeMedida;
	private LocalArmazenamento armario;
	private LocalArmazenamento nicho;
	
	public InsumoDto(String nome, Integer quantidadeTotal, Integer quantidadeMinimaEstoque,
			Integer quantidadeDiasAlertaVencimento, UnidadeMedida unidadeMedida, LocalArmazenamento armario,
			LocalArmazenamento nicho) {
		this.nome = nome;
		this.quantidadeTotal = quantidadeTotal;
		this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
		this.quantidadeDiasAlertaVencimento = quantidadeDiasAlertaVencimento;
		this.unidadeMedida = unidadeMedida;
		this.armario = armario;
		this.nicho = nicho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Integer quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Integer getQuantidadeMinimaEstoque() {
		return quantidadeMinimaEstoque;
	}

	public void setQuantidadeMinimaEstoque(Integer quantidadeMinimaEstoque) {
		this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
	}

	public Integer getQuantidadeDiasAlertaVencimento() {
		return quantidadeDiasAlertaVencimento;
	}

	public void setQuantidadeDiasAlertaVencimento(Integer quantidadeDiasAlertaVencimento) {
		this.quantidadeDiasAlertaVencimento = quantidadeDiasAlertaVencimento;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public LocalArmazenamento getArmario() {
		return armario;
	}

	public void setArmario(LocalArmazenamento armario) {
		this.armario = armario;
	}

	public LocalArmazenamento getNicho() {
		return nicho;
	}

	public void setNicho(LocalArmazenamento nicho) {
		this.nicho = nicho;
	}

	@Override
	public Insumo toModel() {
		return new Insumo (this.nome, this.quantidadeTotal, this.quantidadeMinimaEstoque, 
				this.quantidadeDiasAlertaVencimento, this.unidadeMedida, this.armario, this.nicho);
	}
	
}