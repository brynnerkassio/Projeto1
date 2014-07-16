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

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.DespesaBO;

/**
 * Servlet implementation class EditarHonorario
 */
@WebServlet("/editarDespesa")
public class EditarDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarDespesa() {
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

		Despesa despesa = new Despesa();
		
		int codigoLancamento = Integer.parseInt(request.getParameter("codigoLancamento"));
		despesa.setCodigoLancamento(codigoLancamento);
		
		int nroProcesso = Integer.parseInt(request.getParameter("nroProcesso"));
		Processo processo = new Processo();
		processo.setNroProcesso(nroProcesso);
		
		short codigoDespesa = Short.parseShort(request.getParameter("codigoDespesa"));
		TipoDespesa tipoDespesa = new TipoDespesa();
		tipoDespesa.setCodigoDespesa(codigoDespesa);
		despesa.setTipoDespesa(tipoDespesa);

		String data = request.getParameter("data");
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		despesa.setDataDespesa(sqlDate);
		
		double valor = Double.parseDouble(request.getParameter("valor"));
		despesa.setValorDespesa(valor);
		
		String obs = request.getParameter("obs");
		despesa.setObservacao(obs);
		
		boolean desp = false;
		DespesaBO despesaBO = new DespesaBO();
		
		try {
			desp = despesaBO.editarDespesa(despesa);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		if(desp == true)
			msg = "Despesa Editada no processo nº " + processo.getNroProcesso();
		else
			msg = "Despesa NÃO Editada!";
		
		request.setAttribute("mensagem", msg);
		request.getRequestDispatcher("editar/despesa/resultado.jsp").forward(request, response);
	}

}
