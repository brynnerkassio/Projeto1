package br.com.fiap.am.druida.bean;

import java.sql.Date;

import br.com.fiap.am.druida.bean.Cliente;

public class Processo {

	private int nroProcesso;
	private Cliente cliente;
	private Date dataAbertura;
	private Date dataFechamento;
	private String descricao;
	private Despesa despesa;
	private Honorario honorario;
	private Advogado advogado;

	public int getNroProcesso() {
		return nroProcesso;
	}

	public void setNroProcesso(int nroProcesso) {
		this.nroProcesso = nroProcesso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public Honorario getHonorario() {
		return honorario;
	}

	public void setHonorario(Honorario honorario) {
		this.honorario = honorario;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

}
