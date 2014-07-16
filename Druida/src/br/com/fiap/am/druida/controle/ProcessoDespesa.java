package br.com.fiap.am.druida.controle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bo.ProcessoDespesaBO;

@WebServlet("/processoDespesa")
public class ProcessoDespesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessoDespesa() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int controleIf = 0;

		Processo objP = new Processo();
		String nroProcesso = "";
		nroProcesso = request.getParameter("nroProcesso");

		Cliente objC = new Cliente();
		String nomeCliente = "";
		nomeCliente = request.getParameter("nomeCliente");

		Processo objD = new Processo();
		String dataInicial = "";
		String dataFinal = "";
		dataInicial = request.getParameter("dataInicial");
		dataFinal = request.getParameter("dataFinal");
		
		if (!nroProcesso.trim().equals("")) {
			int nroProc = Integer.parseInt(nroProcesso);
			objP.setNroProcesso(nroProc);
			controleIf = 1;
		} else if (!nomeCliente.trim().equals("")) {
			objC.setRazaoSocial(nomeCliente);
			controleIf = 2;
		} else if (!dataInicial.trim().equals("") && !dataFinal.trim().equals("")) {

			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date1 = null;
			java.util.Date date2 = null;
			try {
				date1 = format.parse(dataInicial);
				date2 = format.parse(dataFinal);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
			java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
			
			objD.setDataAbertura(sqlDate1);
			objD.setDataFechamento(sqlDate2);
			controleIf = 3;
		}

		ProcessoDespesaBO pDBO = new ProcessoDespesaBO();

		List<Processo> lista = null;

		try {

			if (controleIf == 1)
				lista = pDBO.recuperarProcPorNro(objP);
			else if (controleIf == 2)
				lista = pDBO.recuperarProcPorCliente(objC);
			else if (controleIf == 3)
				lista = pDBO.recuperarProcPorPeriodo(objD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("lista", lista);

		request.getRequestDispatcher("listar/processo/despesa/resultado.jsp")
				.forward(request, response);
	}
}
