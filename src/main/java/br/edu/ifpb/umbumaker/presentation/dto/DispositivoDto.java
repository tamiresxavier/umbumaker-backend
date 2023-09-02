package br.edu.ifpb.umbumaker.presentation.dto;

import java.util.Date;
import java.util.List;

public class DispositivoDto {
    private String modelo;
    private Date ultimaManutencao;
    private String temperaturaMaxima;
    private Integer eixo;
    private List<FilamentoDto> filamentosSuportados;

	
	public DispositivoDto(String modelo, Date ultimaManutencao, String temperaturaMaxima, Integer eixo,
			List<FilamentoDto> filamentosSuportados) {
		this.modelo = modelo;
		this.ultimaManutencao = ultimaManutencao;
		this.temperaturaMaxima = temperaturaMaxima;
		this.eixo = eixo;
		this.filamentosSuportados = filamentosSuportados;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getUltimaManutencao() {
		return ultimaManutencao;
	}
	public void setUltimaManutencao(Date ultimaManutencao) {
		this.ultimaManutencao = ultimaManutencao;
	}
	public String getTemperaturaMaxima() {
		return temperaturaMaxima;
	}
	public void setTemperaturaMaxima(String temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}
	public Integer getEixo() {
		return eixo;
	}
	public void setEixo(Integer eixo) {
		this.eixo = eixo;
	}
	public List<FilamentoDto> getFilamentosSuportados() {
		return filamentosSuportados;
	}
	public void setFilamentosSuportados(List<FilamentoDto> filamentosSuportados) {
		this.filamentosSuportados = filamentosSuportados;
	}

}