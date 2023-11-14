package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.umbumaker.model.enums.TipoDispositivo;
import br.edu.ifpb.umbumaker.model.enums.TipoFilamento;
import br.edu.ifpb.umbumaker.presentation.dto.DispositivoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dispositivo implements IModel<DispositivoDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private String modelo;
	private LocalDate ultimaManutencao;
	private String temperaturaMaxima;
	private Integer eixoX;
	private Integer eixoY;
	private Integer eixoZ;
	
	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipoDispositivo;
	
	@Enumerated(EnumType.STRING)
	private List<TipoFilamento> tipoFilamentoSuportado;

	public Dispositivo(String modelo, LocalDate ultimaManutencao, String temperaturaMaxima, Integer eixoX, Integer eixoY,
			Integer eixoZ, TipoDispositivo tipo, List<TipoFilamento> tipoFilamentoSuportado) {
		this.modelo = modelo;
		this.ultimaManutencao = ultimaManutencao;
		this.temperaturaMaxima = temperaturaMaxima;
		this.eixoX = eixoX;
		this.eixoY = eixoY;
		this.eixoZ = eixoZ;
		this.tipoDispositivo = tipo;
		this.tipoFilamentoSuportado = tipoFilamentoSuportado;
	}

	public Dispositivo() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getUltimaManutencao() {
		return ultimaManutencao;
	}

	public void setUltimaManutencao(LocalDate ultimaManutencao) {
		this.ultimaManutencao = ultimaManutencao;
	}

	public String getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(String temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Integer getEixoX() {
		return eixoX;
	}

	public void setEixoX(Integer eixoX) {
		this.eixoX = eixoX;
	}

	public Integer getEixoY() {
		return eixoY;
	}

	public void setEixoY(Integer eixoY) {
		this.eixoY = eixoY;
	}

	public Integer getEixoZ() {
		return eixoZ;
	}

	public void setEixoZ(Integer eixoZ) {
		this.eixoZ = eixoZ;
	}

	public TipoDispositivo getTipo() {
		return tipoDispositivo;
	}

	public void setTipo(TipoDispositivo tipo) {
		this.tipoDispositivo = tipo;
	}

	public List<TipoFilamento> getTipoFilamentoSuportado() {
		return tipoFilamentoSuportado;
	}

	public void setTipoFilamentoSuportado(List<TipoFilamento> tipoFilamentoSuportado) {
		this.tipoFilamentoSuportado = tipoFilamentoSuportado;
	}

	@Override
	public DispositivoDto toDto() {
		return new DispositivoDto (this.modelo, this.ultimaManutencao,this.temperaturaMaxima,
				this.eixoX,this.eixoY,this.eixoZ,this.tipoDispositivo,this.tipoFilamentoSuportado);
	}

}