package br.com.fiap.am.druida.bo;

//import br.com.fiap.advocacia.AdvocaciaException;
import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.dao.ProcessoHonorarioDAO;

public class ProcessoHonorarioBO {

	public List<Processo> recuperarProcPorNro(Processo objP) {
		ProcessoHonorarioDAO processoDAO = new ProcessoHonorarioDAO();
		return processoDAO.recuperarProcPorNro(objP);
	}
	
	public List<Processo> recuperarProcPorCliente(Cliente objC) {
		ProcessoHonorarioDAO processoDAO = new ProcessoHonorarioDAO();
		return processoDAO.recuperarProcPorCliente(objC);
	}
	
	public List<Processo> recuperarProcPorPeriodo(Processo objD) {
		ProcessoHonorarioDAO processoDAO = new ProcessoHonorarioDAO();
		return processoDAO.recuperarProcPorPeriodo(objD);
	}
}
