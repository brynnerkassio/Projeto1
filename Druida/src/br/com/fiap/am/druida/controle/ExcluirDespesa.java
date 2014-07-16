package br.com.fiap.am.druida.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bo.DespesaBO;

/**
 * Servlet implementation class ExcluirHonorario
 */
@WebServlet("/excluirDespesa")
public class ExcluirDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirDespesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Despesa despesa = new Despesa();
		
		int nroProcesso = Integer.parseInt(request.getParameter("nroProcesso"));
		int codigoLancamento = Integer.parseInt(request.getParameter("codigoLancamento"));
		despesa.setCodigoLancamento(codigoLancamento);
		
		boolean desp = false;
		DespesaBO despesaBO = new DespesaBO();
		
		try {
			desp = despesaBO.excluirDespesa(despesa);    		
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		if(desp == true)
			response.sendRedirect("listarDespesa?nroProcesso=" + nroProcesso);
		else {
			msg = "Despesa NÃO Excluída!";
			request.setAttribute("mensagem", msg);
			request.getRequestDispatcher("excluir/despesa/resultado.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
