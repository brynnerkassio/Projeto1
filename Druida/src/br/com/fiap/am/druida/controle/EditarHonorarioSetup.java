package br.com.fiap.am.druida.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.bo.HonorarioBO;
import br.com.fiap.am.druida.bo.TipoTarefaBO;

/**
 * Servlet implementation class EditarHonorarioSetup
 */
@WebServlet("/editarHonorarioSetup")
public class EditarHonorarioSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarHonorarioSetup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Honorario honorario = new Honorario();
		int codigoLancamento = Integer.parseInt(request.getParameter("codigoLancamento"));
		honorario.setCodigoLancamento(codigoLancamento);

		Honorario id = new Honorario();
		HonorarioBO lhBO = new HonorarioBO();
		
		List<TipoTarefa> lista = null;
		TipoTarefaBO tarefaBO = new TipoTarefaBO();
		
		try {

			id = lhBO.editarHonorarioSetup(honorario);
			lista = tarefaBO.recuperarTipoTarefa();

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("id", id);
		request.setAttribute("tarefas", lista);

		request.getRequestDispatcher("editar/honorario/index.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
