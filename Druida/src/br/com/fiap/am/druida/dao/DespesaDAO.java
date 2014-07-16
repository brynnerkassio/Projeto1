package br.com.fiap.am.druida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.jdbc.DBManager;

public class DespesaDAO {

	public Despesa recuperarDadosClienteLancar(Despesa despesa) {

		Processo processo = despesa.getProcesso();

		Connection conn = DBManager.getInstancia().getConexao();
		Despesa desp = new Despesa();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT PR.NR_PROCESSO, CL.DS_RAZAO_SOCIAL FROM T_AM_DRD_PROCESSO PR, T_AM_DRD_CLIENTE CL WHERE PR.NR_PROCESSO = ? AND PR.CD_CLIENTE = CL.CD_CLIENTE");

			ps.setInt(1, processo.getNroProcesso());

			rs = ps.executeQuery();

			rs.next();

			Processo proc = new Processo();
			Cliente cli = new Cliente();

			cli.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));

			proc.setNroProcesso(rs.getInt("NR_PROCESSO"));
			proc.setCliente(cli);

			desp.setProcesso(proc);

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
		return desp;
	}

	public Despesa recuperarDadosClienteListar(Despesa despesa) {

		Processo processo = despesa.getProcesso();

		Connection conn = DBManager.getInstancia().getConexao();
		Despesa desp = new Despesa();

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

			desp.setProcesso(proc);

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
		return desp;
	}

	
	public boolean cadastrarDespesa(Despesa despesa) {

		boolean rtn = true;
		
		TipoDespesa tipoDespesa = new TipoDespesa();
		tipoDespesa = despesa.getTipoDespesa();
		short codigoDespesa = tipoDespesa.getCodigoDespesa();

		Processo processo = new Processo();
		processo = despesa.getProcesso();
		int nroProcesso = processo.getNroProcesso();
				
		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConexao();

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("INSERT INTO T_AM_DRD_LANCA_DESPESA (CD_LANCAMENTO, CD_TIPO_DESPESA, NR_PROCESSO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) VALUES (SQ_AM_LANCA_HONORARIO.NEXTVAL,?,?,?,?,?)");

			ps.setInt(1, codigoDespesa);
			ps.setInt(2, nroProcesso);
			ps.setDate(3, despesa.getDataDespesa());
			ps.setDouble(4, despesa.getValorDespesa());
			ps.setString(5, despesa.getObservacao());

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

	public List<Despesa> listarDespesa(Despesa despesa) {

		Processo processo = despesa.getProcesso();
		List<Despesa> lista = new ArrayList<Despesa>();
		
		Connection conn = DBManager.getInstancia().getConexao();
	
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT DP.CD_LANCAMENTO, DP.DT_DESPESA, TD.DS_TIPO_DESPESA, DP.VL_DESPESA FROM T_AM_DRD_LANCA_DESPESA DP, T_AM_DRD_TIPO_DESPESA TD WHERE DP.CD_TIPO_DESPESA = TD.CD_TIPO_DESPESA AND DP.NR_PROCESSO = ? ORDER BY CD_LANCAMENTO DESC");

			ps.setInt(1, processo.getNroProcesso());

			rs = ps.executeQuery();

			while (rs.next()) {

				Despesa desp = new Despesa();
				TipoDespesa td = new TipoDespesa();

				desp.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
				
				String dataConfig = "dd/MM/yyyy";  
				SimpleDateFormat formatada = new SimpleDateFormat(dataConfig);
				java.sql.Date datar = rs.getDate("DT_DESPESA");
				desp.setDataDespesaReturn(formatada.format(datar));
				
				desp.setValorDespesa(rs.getDouble("VL_DESPESA"));

				td.setTipoDespesa(rs.getString("DS_TIPO_DESPESA"));
				desp.setTipoDespesa(td);

				lista.add(desp);
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
	
	public boolean excluirDespesa(Despesa despesa) {

		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConexao();
		boolean rtn = true;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("DELETE FROM T_AM_DRD_LANCA_DESPESA WHERE CD_LANCAMENTO = ?");

			ps.setInt(1, despesa.getCodigoLancamento());

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

	public Despesa editarDespesaSetup(Despesa despesa) {

		Connection conn = DBManager.getInstancia().getConexao();
		
		Despesa desp = new Despesa();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT LD.CD_LANCAMENTO, LD.NR_PROCESSO, CL.DS_RAZAO_SOCIAL, LD.CD_TIPO_DESPESA, LD.DT_DESPESA, LD.VL_DESPESA, LD.DS_OBSERVACAO FROM T_AM_DRD_LANCA_DESPESA LD, T_AM_DRD_PROCESSO PR, T_AM_DRD_CLIENTE CL WHERE LD.NR_PROCESSO = PR.NR_PROCESSO AND PR.CD_CLIENTE = CL.CD_CLIENTE AND LD.CD_LANCAMENTO = ?");

			ps.setInt(1, despesa.getCodigoLancamento());

			rs = ps.executeQuery();

			rs.next();

			Processo processo = new Processo();
			desp.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
			processo.setNroProcesso(rs.getInt("NR_PROCESSO"));
			
			Cliente cliente = new Cliente();
			cliente.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
			processo.setCliente(cliente);
			
			TipoDespesa tipoDespesa = new TipoDespesa();
			tipoDespesa.setCodigoDespesa(rs.getShort("CD_TIPO_DESPESA"));
			
			String dataConfig = "dd/MM/yyyy";  
			SimpleDateFormat formatada = new SimpleDateFormat(dataConfig);
			java.sql.Date datar = rs.getDate("DT_DESPESA");
			desp.setDataDespesaReturn(formatada.format(datar));
			
			desp.setValorDespesa(rs.getDouble("VL_DESPESA"));
			desp.setObservacao(rs.getString("DS_OBSERVACAO"));

			desp.setTipoDespesa(tipoDespesa);
			desp.setProcesso(processo);
			
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
		return desp;
	}

	public boolean editarDespesa(Despesa despesa) {
		
		boolean rtn = true;
		
		TipoDespesa tipoDespesa = new TipoDespesa();
		tipoDespesa = despesa.getTipoDespesa();
		short codigoDespesa = tipoDespesa.getCodigoDespesa();

		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConexao();

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("UPDATE T_AM_DRD_LANCA_DESPESA SET CD_TIPO_DESPESA = ?, DT_DESPESA = ?, VL_DESPESA = ?, DS_OBSERVACAO = ? WHERE CD_LANCAMENTO = ?");

			ps.setShort(1, codigoDespesa);
			ps.setDate(2, despesa.getDataDespesa());
			ps.setDouble(3, despesa.getValorDespesa());
			ps.setString(4, despesa.getObservacao());
			ps.setInt(5, despesa.getCodigoLancamento());
			
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
