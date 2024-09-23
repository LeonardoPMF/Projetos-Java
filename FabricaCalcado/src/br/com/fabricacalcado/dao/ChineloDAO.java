package br.com.fabricacalcado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricacalcado.model.Chinelo;


public class ChineloDAO {
	
	
	private Connection con;

	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public ChineloDAO() {
	}
	public ChineloDAO(Connection con) {
		setCon(con);
	}
	
	
	public String inserirChinelo(Chinelo chinelo) {
		String sql = "insert into chinelo(tamanho, peso, nome, quantidadeTiras) values (?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setInt(1, chinelo.getTamanho());
			ps.setDouble(2, chinelo.getPeso());
			ps.setString(3, chinelo.getNome());
			ps.setInt(4, chinelo.getQuantidadeTiras());
			if (ps.executeUpdate() > 0) {
				return "Chinelo iserido com sucesso.";
			} else {
				return "Erro ao inserir o chinelo.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public String deletarChineloWhere(Chinelo chinelo) {
		String sql = "delete from chinelo where nome like (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setString(1, chinelo.getNome());
			
			if (ps.executeUpdate() > 0) {
				return "Chinelo deletado com sucesso.";
			} else {
				return "Erro ao deletar o chinelo.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	
	public String alterarTamanhoChinelo(Chinelo chinelo) {
		String sql = "update chinelo set tamanho = (?) where nome = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setInt(1, chinelo.getTamanho());
			ps.setString(2, chinelo.getNome());
			
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	//Método selecionar
		public ArrayList<Chinelo> retornarDadosChinelo(){
			String sql = "select * from chinelo";
			ArrayList<Chinelo> retornarDadosChinelo = new ArrayList<Chinelo>();
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs != null) {
					while(rs.next()) {
						Chinelo chinelo = new Chinelo();
						chinelo.setTamanho(rs.getInt(1));
						chinelo.setPeso(rs.getDouble(2));
						chinelo.setNome(rs.getString(3));
						chinelo.setQuantidadeTiras(rs.getInt(4));
						
						retornarDadosChinelo.add(chinelo);
					} return retornarDadosChinelo;
				} else {
					return null;
				}
			} catch(SQLException e) {
				return null;
			}
		}
		
		//Método selecionar com where
				public ArrayList<Chinelo> retornarDadosChineloWhere(double tamanho){
					String sql = "select * from chinelo where tamanho = (tamanho)";
					ArrayList<Chinelo> retornarDadosChinelo = new ArrayList<Chinelo>();
					try {
						PreparedStatement ps = getCon().prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						if(rs != null) {
							while(rs.next()) {
								Chinelo chinelo = new Chinelo();
								chinelo.setTamanho(rs.getInt(1));
								chinelo.setPeso(rs.getDouble(2));
								chinelo.setNome(rs.getString(3));
								chinelo.setQuantidadeTiras(rs.getInt(4));
								
								retornarDadosChinelo.add(chinelo);
							} return retornarDadosChinelo;
						} else {
							return null;
						}
					} catch(SQLException e) {
						return null;
					}
				}
}
