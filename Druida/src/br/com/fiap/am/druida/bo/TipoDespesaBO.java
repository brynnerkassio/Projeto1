package br.com.fiap.am.druida.bo;

import java.util.List;

import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.dao.TipoDespesaDAO;

public class TipoDespesaBO {

	public List<TipoDespesa> recuperarTipoDespesa() {
		TipoDespesaDAO tipoDespesaDAO = new TipoDespesaDAO();
		return tipoDespesaDAO.recuperarTipoDespesa();
	}
}
