package br.com.fiap.am.druida.controle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.bo.HonorarioBO;

/**
 * Servlet implementation class EditarHonorario
 */
@WebServlet("/editarHonorario")
public class EditarHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarHonorario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Honorario honorario = new Honorario();
		
		int codigoLancamento = Integer.parseInt(request.getParameter("codigoLancamento"));
		honorario.setCodigoLancamento(codigoLancamento);
		
		int nroProcesso = Integer.parseInt(request.getParameter("nroProcesso"));
		Processo processo = new Processo();
		processo.setNroProcesso(nroProcesso);
		
		short codigoTarefa = Short.parseShort(request.getParameter("codigoTarefa"));
		TipoTarefa tipoTarefa = new TipoTarefa();
		tipoTarefa.setCodigoTarefa(codigoTarefa);
		honorario.setTipoTarefa(tipoTarefa);

		String data = request.getParameter("data");
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		honorario.setDataHonorario(sqlDate);
		
		double qntHoras = Double.parseDouble(request.getParameter("qntHoras"));
		honorario.setQntHora(qntHoras);
		
		String obs = request.getParameter("obs");
		honorario.setObservacao(obs);
		
		boolean hn = false;
		HonorarioBO honorarioBO = new HonorarioBO();
		
		try {
			hn = honorarioBO.editarHonorario(honorario);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		if(hn == true)
			msg = "Honorário Editado no processo nº " + processo.getNroProcesso();
		else
			msg = "Honorário NÃO Editado!";
		
		request.setAttribute("mensagem", msg);
		request.getRequestDispatcher("editar/honorario/resultado.jsp").forward(request, response);
	}

}
