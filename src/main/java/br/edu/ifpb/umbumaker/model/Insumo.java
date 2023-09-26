package br.edu.ifpb.umbumaker.model;

import br.edu.ifpb.umbumaker.model.enums.StatusEstoque;
import br.edu.ifpb.umbumaker.model.enums.UnidadeMedida;
import br.edu.ifpb.umbumaker.presentation.dto.InsumoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insumo implements IModel<InsumoDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private String nome;
	private Integer quantidadeTotal;
	private Integer quantidadeMinimaEstoque;
	private Integer quantidadeDiasAlertaVencimento;
	
	@Enumerated(EnumType.STRING)
	private UnidadeMedida unidadeMedida;
	
	@Enumerated(EnumType.STRING)
	private StatusEstoque statusEstoque;
	
	public Insumo(String nome, Integer quantidadeTotal, Integer quantidadeMinimaEstoque,
			Integer quantidadeDiasAlertaVencimento, UnidadeMedida unidadeMedida, StatusEstoque statusEstoque) {
		this.nome = nome;
		this.quantidadeTotal = quantidadeTotal;
		this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
		this.quantidadeDiasAlertaVencimento = quantidadeDiasAlertaVencimento;
		this.unidadeMedida = unidadeMedida;
		this.statusEstoque = statusEstoque;
	}

	public Insumo() {
		
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	
	public StatusEstoque getStatusEstoque() {
		return statusEstoque;
	}

	public void setStatusEstoque(StatusEstoque statusEstoque) {
		this.statusEstoque = statusEstoque;
	}

	@Override
	public InsumoDto toDto() {
		return new InsumoDto (this.nome, this.quantidadeTotal, this.quantidadeMinimaEstoque, 
				this.quantidadeDiasAlertaVencimento, this.unidadeMedida, this.statusEstoque);
	}

}