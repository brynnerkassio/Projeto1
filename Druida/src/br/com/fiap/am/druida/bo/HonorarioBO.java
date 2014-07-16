package br.com.fiap.am.druida.bo;

import java.util.List;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.dao.HonorarioDAO;

public class HonorarioBO {

	HonorarioDAO honorarioDAO = new HonorarioDAO();

	public Honorario recuperarDadosClienteLancar(Honorario honorario) {
		return honorarioDAO.recuperarDadosClienteLancar(honorario);
	}

	public Honorario recuperarDadosClienteListar(Honorario honorario) {
		return honorarioDAO.recuperarDadosClienteListar(honorario);
	}
	
	public boolean cadastrarHonorario(Honorario honorario) {
		return honorarioDAO.cadastrarHonorario(honorario);
	}

	public List<Honorario> listarHonorario(Honorario honorario) {
		return honorarioDAO.listarHonorario(honorario);
	}

	public boolean excluirHonorario(Honorario honorario) {
		return honorarioDAO.excluirHonorario(honorario);
	}

	public Honorario editarHonorarioSetup(Honorario honorario) {
		return honorarioDAO.editarHonorarioSetup(honorario);
	}

	public boolean editarHonorario(Honorario honorario) {
		return honorarioDAO.editarHonorario(honorario);
	}

}
