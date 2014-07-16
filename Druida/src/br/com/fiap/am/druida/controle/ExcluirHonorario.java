package br.com.fiap.am.druida.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bo.HonorarioBO;

/**
 * Servlet implementation class ExcluirHonorario
 */
@WebServlet("/excluirHonorario")
public class ExcluirHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirHonorario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Honorario honorario = new Honorario();
		
		int nroProcesso = Integer.parseInt(request.getParameter("nroProcesso"));
		int codigoLancamento = Integer.parseInt(request.getParameter("codigoLancamento"));
		honorario.setCodigoLancamento(codigoLancamento);
		
		boolean hn = false;
		HonorarioBO honorarioBO = new HonorarioBO();
		
		try {
			hn = honorarioBO.excluirHonorario(honorario);    		
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		if(hn == true)
			response.sendRedirect("listarHonorario?nroProcesso=" + nroProcesso);
		else {
			msg = "Honorário NÃO Excluído!";
			request.setAttribute("mensagem", msg);
			request.getRequestDispatcher("excluir/honorario/resultado.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
