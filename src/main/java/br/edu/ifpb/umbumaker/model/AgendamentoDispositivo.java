package br.edu.ifpb.umbumaker.model;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.umbumaker.model.enums.StatusObjeto;
import br.edu.ifpb.umbumaker.presentation.dto.AgendamentoDispositivoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class AgendamentoDispositivo implements IModel<AgendamentoDispositivoDto> {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	private LocalDate dataSolicitacao;
	private String email;
	private LocalDate dataAgendamento;
	private String descricao;
	private String politicaDeAceite;
	
	@Enumerated(EnumType.STRING)
	private StatusObjeto status;
	
	@OneToMany
	@JoinColumn(name = "dispositivos")
	private List<Dispositivo> dispositivos;
	
	public AgendamentoDispositivo(LocalDate dataSolicitacao, String email, LocalDate dataAgendamento, String descricao,
			String politicaDeAceite, StatusObjeto status, List<Dispositivo> dispositivos) {
		this.dataSolicitacao = dataSolicitacao;
		this.email = email;
		this.dataAgendamento = dataAgendamento;
		this.descricao = descricao;
		this.politicaDeAceite = politicaDeAceite;
		this.status = status;
		this.dispositivos = dispositivos;
	}

	public AgendamentoDispositivo() {
	
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPoliticaDeAceite() {
		return politicaDeAceite;
	}

	public void setPoliticaDeAceite(String politicaDeAceite) {
		this.politicaDeAceite = politicaDeAceite;
	}

	public StatusObjeto getStatus() {
		return status;
	}

	public void setStatus(StatusObjeto status) {
		this.status = status;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	@Override
	public AgendamentoDispositivoDto toDto() {
		return new AgendamentoDispositivoDto (this.dataSolicitacao, this.email, this.dataAgendamento, this.descricao,
				this.politicaDeAceite, this.status, this.dispositivos);
	}

}