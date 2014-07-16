package br.com.fiap.am.druida.bo.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bo.ProcessoDespesaBO;

public class RecuperarProcessos {

	public static void main(String[] args) {
	
		int controleIf = 0;

		Processo objP = new Processo();
		String nroProcesso = "";							// Informe aqui o número do processo para buscar.
		nroProcesso = "";

		Cliente objC = new Cliente();
		String nomeCliente = "";
		nomeCliente = "maromba";							// Informe aqui o nome do cliente para buscar.

		Processo objD = new Processo();
		String dataInicial = "";
		String dataFinal = "";
		dataInicial = "10/10/2011";							// Informe aqui o período para buscar.
		dataFinal = "10/10/2013";
		
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

		for (Processo pro : lista) {
			System.out.print("Número do Processo: ");
			System.out.print(pro.getNroProcesso());
			System.out.print(" | Descrição: ");
			System.out.print(pro.getDescricao());
			System.out.print(" | Cliente: ");
			Cliente cli = new Cliente();
			cli = pro.getCliente();
			System.out.print(cli.getRazaoSocial());
			System.out.println("");
		}
	}
}