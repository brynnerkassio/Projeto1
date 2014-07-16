package br.com.fiap.am.druida.bo.teste;

import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.bo.HonorarioBO;

public class ListarHonorario {

	public static void main(String[] args) {
		
		Processo processo = new Processo();
		int nroProcesso = 3;								// Informe aqui o número do processo para para honorários relacionados.
		processo.setNroProcesso(nroProcesso);

		Honorario honorario = new Honorario();
		honorario.setProcesso(processo);

		//
		
		Honorario id = new Honorario();
		HonorarioBO lhBO = new HonorarioBO();
		
		List<Honorario> lista = null;
		
		try {

			id = lhBO.recuperarDadosClienteListar(honorario);
			lista = lhBO.listarHonorario(honorario);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Processo processo2 = new Processo();
		processo2 = id.getProcesso();
		
		Cliente cliente = new Cliente();
		cliente = processo2.getCliente();
		
		System.out.println("Número do Processo: " + processo2.getNroProcesso());
		System.out.println("Cliente: " + cliente.getRazaoSocial());
		System.out.println("");

		for (Honorario hon : lista) {
			System.out.print("Data: ");
			System.out.print(hon.getDataHonorario());
			System.out.print(" | Nome: ");
			TipoTarefa tt = new TipoTarefa();
			tt = hon.getTipoTarefa();
			System.out.print(tt.getTipoTarefa());
			System.out.print(" | Quantidade de Horas: ");
			System.out.print(hon.getQntHora());
			System.out.print(" | Código Lançamento: ");
			System.out.print(hon.getCodigoLancamento());
			System.out.print(" | número Processo: ");
			System.out.print(processo2.getNroProcesso());
			System.out.println("");
		}
	}
}
