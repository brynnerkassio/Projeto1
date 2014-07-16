package br.com.fiap.am.druida.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.DespesaBO;
import br.com.fiap.am.druida.bo.TipoDespesaBO;

/**
 * Servlet implementation class EditarHonorarioSetup
 */
@WebServlet("/editarDespesaSetup")
public class EditarDespesaSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarDespesaSetup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Despesa despesa = new Despesa();
		int codigoLancamento = Integer.parseInt(request.getParameter("codigoLancamento"));
		despesa.setCodigoLancamento(codigoLancamento);

		Despesa id = new Despesa();
		DespesaBO ldBO = new DespesaBO();
		
		List<TipoDespesa> lista = null;
		TipoDespesaBO despesaBO = new TipoDespesaBO();
		
		try {

			id = ldBO.editarDespesaSetup(despesa);
			lista = despesaBO.recuperarTipoDespesa();

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("id", id);
		request.setAttribute("despesas", lista);

		request.getRequestDispatcher("editar/despesa/index.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
