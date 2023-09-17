package br.edu.ifpb.umbumaker.presentation.dto;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.umbumaker.model.Dispositivo;

import br.edu.ifpb.umbumaker.model.enums.TipoDispositivo;
import br.edu.ifpb.umbumaker.model.enums.TipoFilamento;

public class DispositivoDto implements IDto<Dispositivo> {
    private String modelo;
    private LocalDate ultimaManutencao;
    private String temperaturaMaxima;
    private Integer eixoX;
    private Integer eixoY;
    private Integer eixoZ;
    private TipoDispositivo tipo;
    private List<TipoFilamento> tipoFilamentoSuportado;

	public DispositivoDto(String modelo, LocalDate ultimaManutencao, String temperaturaMaxima, Integer eixoX,
			Integer eixoY, Integer eixoZ, TipoDispositivo tipo, List<TipoFilamento> tipoFilamentoSuportado) {
		this.modelo = modelo;
		this.ultimaManutencao = ultimaManutencao;
		this.temperaturaMaxima = temperaturaMaxima;
		this.eixoX = eixoX;
		this.eixoY = eixoY;
		this.eixoZ = eixoZ;
		this.tipo = tipo;
		this.tipoFilamentoSuportado = tipoFilamentoSuportado;
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
		return tipo;
	}

	public void setTipo(TipoDispositivo tipo) {
		this.tipo = tipo;
	}
	
	public List<TipoFilamento> getTipofilamentoSuportado() {
		return tipoFilamentoSuportado;
	}

	public void setTipofilamentoSuportado(List<TipoFilamento> tipofilamentoSuportado) {
		this.tipoFilamentoSuportado = tipofilamentoSuportado;
	}

	@Override
	public Dispositivo toModel() {
		return new Dispositivo (this.modelo, this.ultimaManutencao,this.temperaturaMaxima,
				this.eixoX,this.eixoY,this.eixoZ,this.tipo,this.tipoFilamentoSuportado);
	}
	
}