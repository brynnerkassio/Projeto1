package br.com.fiap.am.druida.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.DespesaBO;
import br.com.fiap.am.druida.bo.TipoDespesaBO;

@WebServlet("/lancarDespesaSetup")
public class LancarDespesaSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LancarDespesaSetup() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Processo processo = new Processo();
		int nroProcesso = Integer.parseInt(request.getParameter("nroProcesso"));
		processo.setNroProcesso(nroProcesso);

		Despesa despesa = new Despesa();
		despesa.setProcesso(processo);

		Despesa id = new Despesa();
		DespesaBO ldBO = new DespesaBO();

		List<TipoDespesa> lista = null;
		TipoDespesaBO despesaBO = new TipoDespesaBO();

		try {

			id = ldBO.recuperarDadosClienteLancar(despesa);
			lista = despesaBO.recuperarTipoDespesa();

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("id", id);
		request.setAttribute("despesas", lista);

		request.getRequestDispatcher("lancar/despesa/index.jsp").forward(
				request, response);
	}
}
