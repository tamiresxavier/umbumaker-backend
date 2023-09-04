package br.edu.ifpb.umbumaker.model;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dispositivo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private String modelo;
	private Date ultimaManutencao;
	private String temperaturaMaxima;
	private Integer eixo;
	
	@OneToMany(mappedBy = "dispositivo")
	private List<Filamento> filamentosSuportados;

	public Dispositivo(String modelo, Date ultimaManutencao, String temperaturaMaxima, Integer eixo,
			List<Filamento> filamentosSuportados) {
		this.modelo = modelo;
		this.ultimaManutencao = ultimaManutencao;
		this.temperaturaMaxima = temperaturaMaxima;
		this.eixo = eixo;
		this.filamentosSuportados = filamentosSuportados;
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

	public List<Filamento> getFilamentosSuportados() {
		return filamentosSuportados;
	}

	public void setFilamentosSuportados(List<Filamento> filamentosSuportados) {
		this.filamentosSuportados = filamentosSuportados;
	}

}