package br.com.fiap.am.druida.bo;

//import br.com.fiap.advocacia.AdvocaciaException;
import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.dao.ProcessoDespesaDAO;

public class ProcessoDespesaBO {

	public List<Processo> recuperarProcPorNro(Processo objP) {
		ProcessoDespesaDAO processoDAO = new ProcessoDespesaDAO();
		return processoDAO.recuperarProcPorNro(objP);
	}
	
	public List<Processo> recuperarProcPorCliente(Cliente objC) {
		ProcessoDespesaDAO processoDAO = new ProcessoDespesaDAO();
		return processoDAO.recuperarProcPorCliente(objC);
	}
	
	public List<Processo> recuperarProcPorPeriodo(Processo objD) {
		ProcessoDespesaDAO processoDAO = new ProcessoDespesaDAO();
		return processoDAO.recuperarProcPorPeriodo(objD);
	}
}
