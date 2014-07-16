package br.com.fiap.am.druida.bo.teste;

import java.util.List;

import br.com.fiap.am.druida.bean.Advogado;
import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.bo.HonorarioBO;
import br.com.fiap.am.druida.bo.TipoTarefaBO;

public class EditarHonorarioSetup {

	public static void main(String[] args) {
		
		Honorario Honorario = new Honorario();
		int codigoLancamento = 36;							// Informe aqui o código de lançamento do honorário a ser recuperado.
		Honorario.setCodigoLancamento(codigoLancamento);

		Honorario id = new Honorario();
		HonorarioBO ldBO = new HonorarioBO();
		
		List<TipoTarefa> lista = null;
		TipoTarefaBO HonorarioBO = new TipoTarefaBO();
		
		try {

			id = ldBO.editarHonorarioSetup(Honorario);
			lista = HonorarioBO.recuperarTipoTarefa();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Processo processo2 = new Processo();
		processo2 = id.getProcesso();
		
		Cliente cliente = new Cliente();
		cliente = processo2.getCliente();
		
		Advogado advogado = new Advogado();
		advogado = processo2.getAdvogado();
		
		System.out.println("Número do Processo: " + processo2.getNroProcesso());
		System.out.println("Cliente: " + cliente.getRazaoSocial());
		System.out.println("Advogado: " + advogado.getNome());
		System.out.println("");
		System.out.print("Código do Tipo Honorario: ");
		TipoTarefa tt = new TipoTarefa();
		tt = id.getTipoTarefa();
		System.out.print(tt.getCodigoTarefa());
		System.out.print(" | Data: ");
		System.out.print(id.getDataHonorario());
		System.out.print(" | Quantidade de Horas: ");
		System.out.print(id.getQntHora());
		System.out.print(" | Código Lançamento: ");
		System.out.print(id.getCodigoLancamento());
		System.out.print(" | Observações: ");
		System.out.print(id.getObservacao());
		System.out.println("");
		System.out.println("");
		
		for (TipoTarefa desp : lista) {
			System.out.print(desp.getCodigoTarefa());
			System.out.print(" ");
			System.out.println(desp.getTipoTarefa());
		}
	}
}
