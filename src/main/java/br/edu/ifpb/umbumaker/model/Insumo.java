package br.edu.ifpb.umbumaker.model;

import br.edu.ifpb.umbumaker.model.enums.UnidadeMedida;
import br.edu.ifpb.umbumaker.presentation.dto.InsumoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(name = "codigoArmario")
	private LocalArmazenamento armario;
	
	@ManyToOne
	@JoinColumn(name = "codigoNicho")
	private LocalArmazenamento nicho;
	
	public Insumo(String nome, Integer quantidadeTotal, Integer quantidadeMinimaEstoque,
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
	public InsumoDto toDto() {
		return new InsumoDto (this.nome, this.quantidadeTotal, this.quantidadeMinimaEstoque, 
				this.quantidadeDiasAlertaVencimento, this.unidadeMedida, this.armario, this.nicho);
	}

}