package br.com.fiap.am.druida.bo;

import java.util.List;

import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.dao.TipoTarefaDAO;

public class TipoTarefaBO {

	public List<TipoTarefa> recuperarTipoTarefa() {
		TipoTarefaDAO tipoTarefaDAO = new TipoTarefaDAO();
		return tipoTarefaDAO.recuperarTipoTarefa();
	}
}
