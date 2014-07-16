package br.com.fiap.am.druida.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bo.HonorarioBO;

@WebServlet("/listarHonorario")
public class ListarHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarHonorario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Processo processo = new Processo();
		int nroProcesso = Integer.parseInt(request.getParameter("nroProcesso"));
		processo.setNroProcesso(nroProcesso);

		Honorario honorario = new Honorario();
		honorario.setProcesso(processo);

		Honorario id = new Honorario();
		HonorarioBO lhBO = new HonorarioBO();
		
		List<Honorario> lista = null;
		
		try {

			id = lhBO.recuperarDadosClienteListar(honorario);
			lista = lhBO.listarHonorario(honorario);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("id", id);
		request.setAttribute("honorarios", lista);
		request.getRequestDispatcher("listar/honorario/resultado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
