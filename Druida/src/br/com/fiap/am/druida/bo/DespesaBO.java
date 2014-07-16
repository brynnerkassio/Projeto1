package br.com.fiap.am.druida.bo;

import java.util.List;

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.dao.DespesaDAO;

public class DespesaBO {
	
	DespesaDAO despesaDAO = new DespesaDAO();

	public Despesa recuperarDadosClienteLancar(Despesa despesa) {
		return despesaDAO.recuperarDadosClienteLancar(despesa);
	}

	public Despesa recuperarDadosClienteListar(Despesa despesa) {
		return despesaDAO.recuperarDadosClienteListar(despesa);
	}
	
	public boolean cadastrarDespesa(Despesa despesa) {
		return despesaDAO.cadastrarDespesa(despesa);
	}

	public List<Despesa> listarDespesa(Despesa despesa) {
		return despesaDAO.listarDespesa(despesa);
	}

	public boolean excluirDespesa(Despesa despesa) {
		return despesaDAO.excluirDespesa(despesa);
	}

	public Despesa editarDespesaSetup(Despesa despesa) {
		return despesaDAO.editarDespesaSetup(despesa);
	}

	public boolean editarDespesa(Despesa despesa) {
		return despesaDAO.editarDespesa(despesa);
	}
}
