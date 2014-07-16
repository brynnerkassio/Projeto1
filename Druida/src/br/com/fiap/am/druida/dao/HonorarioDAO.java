package br.com.fiap.am.druida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.druida.bean.Advogado;
import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.jdbc.DBManager;

public class HonorarioDAO {

	public Honorario recuperarDadosClienteLancar(Honorario honorario) {

		Processo processo = honorario.getProcesso();

		Connection conn = DBManager.getInstancia().getConexao();
		Honorario hn = new Honorario();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT PR.NR_PROCESSO, CL.DS_RAZAO_SOCIAL, PS.NM_PESSOA FROM T_AM_DRD_PROCESSO PR, T_AM_DRD_CLIENTE CL, T_AM_DRD_ADVOGADO AD, T_AM_DRD_PESSOA PS WHERE PR.NR_PROCESSO = ? AND PR.CD_CLIENTE = CL.CD_CLIENTE AND PR.CD_ADVOGADO = AD.CD_ADVOGADO AND AD.CD_ADVOGADO = PS.CD_PESSOA");

			ps.setInt(1, processo.getNroProcesso());

			rs = ps.executeQuery();

			rs.next();

			Processo proc = new Processo();
			Cliente cli = new Cliente();
			Advogado adv = new Advogado();

			cli.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
			adv.setNome(rs.getString("NM_PESSOA"));

			proc.setNroProcesso(rs.getInt("NR_PROCESSO"));
			proc.setCliente(cli);
			proc.setAdvogado(adv);

			hn.setProcesso(proc);

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hn;
	}

	public Honorario recuperarDadosClienteListar(Honorario honorario) {

		Processo processo = honorario.getProcesso();

		Connection conn = DBManager.getInstancia().getConexao();
		Honorario hn = new Honorario();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT PR.NR_PROCESSO, CL.DS_RAZAO_SOCIAL FROM T_AM_DRD_PROCESSO PR, T_AM_DRD_CLIENTE CL WHERE PR.CD_CLIENTE = CL.CD_CLIENTE AND PR.NR_PROCESSO = ?");

			ps.setInt(1, processo.getNroProcesso());

			rs = ps.executeQuery();

			rs.next();

			Processo proc = new Processo();
			Cliente cli = new Cliente();

			cli.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
			proc.setCliente(cli);
			proc.setNroProcesso(rs.getInt("NR_PROCESSO"));

			hn.setProcesso(proc);

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hn;
	}

	
	public boolean cadastrarHonorario(Honorario honorario) {

		boolean rtn = true;
		
		TipoTarefa tipoTarefa = new TipoTarefa();
		tipoTarefa = honorario.getTipoTarefa();
		short codigoTarefa = tipoTarefa.getCodigoTarefa();

		Processo processo = new Processo();
		processo = honorario.getProcesso();
		int nroProcesso = processo.getNroProcesso();
				
		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConexao();

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("INSERT INTO T_AM_DRD_LANCA_HONORARIO (CD_LANCAMENTO, CD_TIPO_TAREFA, NR_PROCESSO, DT_HONORARIO, QT_HORA, DS_OBSERVACAO) VALUES (SQ_AM_LANCA_HONORARIO.NEXTVAL,?,?,?,?,?)");

			ps.setInt(1, codigoTarefa);
			ps.setInt(2, nroProcesso);
			ps.setDate(3, honorario.getDataHonorario());
			ps.setDouble(4, honorario.getQntHora());
			ps.setString(5, honorario.getObservacao());

			ps.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			rtn = false;
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rtn;
	}

	public List<Honorario> listarHonorario(Honorario honorario) {

		Processo processo = honorario.getProcesso();
		List<Honorario> lista = new ArrayList<Honorario>();
		
		Connection conn = DBManager.getInstancia().getConexao();
	
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT HN.CD_LANCAMENTO, HN.DT_HONORARIO, TT.DS_TIPO_TAREFA, HN.QT_HORA FROM T_AM_DRD_LANCA_HONORARIO HN, T_AM_DRD_TIPO_TAREFA TT WHERE HN.CD_TIPO_TAREFA = TT.CD_TIPO_TAREFA AND HN.NR_PROCESSO = ? ORDER BY CD_LANCAMENTO DESC");

			ps.setInt(1, processo.getNroProcesso());

			rs = ps.executeQuery();

			while (rs.next()) {

				Honorario hn = new Honorario();
				TipoTarefa tt = new TipoTarefa();

				hn.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
				
				String dataConfig = "dd/MM/yyyy";  
				SimpleDateFormat formatada = new SimpleDateFormat(dataConfig);
				java.sql.Date datar = rs.getDate("DT_HONORARIO");
				hn.setDataHonorarioReturn(formatada.format(datar));
				
				hn.setQntHora(rs.getDouble("QT_HORA"));

				tt.setTipoTarefa(rs.getString("DS_TIPO_TAREFA"));
				hn.setTipoTarefa(tt);

				lista.add(hn);
			}

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	
	public boolean excluirHonorario(Honorario honorario) {

		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConexao();
		boolean rtn = true;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("DELETE FROM T_AM_DRD_LANCA_HONORARIO WHERE CD_LANCAMENTO = ?");

			ps.setInt(1, honorario.getCodigoLancamento());

			ps.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			rtn = false;
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rtn;
	}

	public Honorario editarHonorarioSetup(Honorario honorario) {

		Connection conn = DBManager.getInstancia().getConexao();
		
		Honorario hn = new Honorario();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT LH.CD_LANCAMENTO, LH.NR_PROCESSO, CL.DS_RAZAO_SOCIAL, PS.NM_PESSOA, LH.CD_TIPO_TAREFA, LH.DT_HONORARIO, LH.QT_HORA, LH.DS_OBSERVACAO FROM T_AM_DRD_LANCA_HONORARIO LH, T_AM_DRD_PROCESSO PR, T_AM_DRD_CLIENTE CL, T_AM_DRD_ADVOGADO AD, T_AM_DRD_PESSOA PS WHERE LH.NR_PROCESSO = PR.NR_PROCESSO AND PR.CD_ADVOGADO = AD.CD_ADVOGADO AND AD.CD_ADVOGADO = PS.CD_PESSOA AND PR.CD_CLIENTE = CL.CD_CLIENTE AND LH.CD_LANCAMENTO = ?");

			ps.setInt(1, honorario.getCodigoLancamento());

			rs = ps.executeQuery();

			rs.next();

			Processo processo = new Processo();
			hn.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
			processo.setNroProcesso(rs.getInt("NR_PROCESSO"));
			
			Cliente cliente = new Cliente();
			cliente.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
			processo.setCliente(cliente);
			
			Advogado advogado = new Advogado();
			advogado.setNome(rs.getString("NM_PESSOA"));
			processo.setAdvogado(advogado);
						
			TipoTarefa tipoTarefa = new TipoTarefa();
			tipoTarefa.setCodigoTarefa(rs.getShort("CD_TIPO_TAREFA"));
			
			String dataConfig = "dd/MM/yyyy";  
			SimpleDateFormat formatada = new SimpleDateFormat(dataConfig);
			java.sql.Date datar = rs.getDate("DT_HONORARIO");
			hn.setDataHonorarioReturn(formatada.format(datar));
			
			hn.setQntHora(rs.getDouble("QT_HORA"));
			hn.setObservacao(rs.getString("DS_OBSERVACAO"));

			hn.setTipoTarefa(tipoTarefa);
			hn.setProcesso(processo);
			
		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return hn;
	}

	public boolean editarHonorario(Honorario honorario) {
		
		boolean rtn = true;
		
		TipoTarefa tipoTarefa = new TipoTarefa();
		tipoTarefa = honorario.getTipoTarefa();
		short codigoTarefa = tipoTarefa.getCodigoTarefa();

		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConexao();

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("UPDATE T_AM_DRD_LANCA_HONORARIO SET CD_TIPO_TAREFA = ?, DT_HONORARIO = ?, QT_HORA = ?, DS_OBSERVACAO = ? WHERE CD_LANCAMENTO = ?");

			ps.setShort(1, codigoTarefa);
			ps.setDate(2, honorario.getDataHonorario());
			ps.setDouble(3, honorario.getQntHora());
			ps.setString(4, honorario.getObservacao());
			ps.setInt(5, honorario.getCodigoLancamento());
			
			ps.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			rtn = false;
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rtn;
	}
}
