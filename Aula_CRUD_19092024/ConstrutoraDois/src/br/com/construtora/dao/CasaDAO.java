package br.com.construtora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.construtora.beans.Casa;


public class CasaDAO {

	private Connection con;

	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public CasaDAO (){
		
	}
	
	public CasaDAO (Connection con){
		this.con = con;
	}
	
	public String inserirCasa(Casa casa) {
		String sql = "insert into casa(metrosQuadrados, quantidadeQuarto, quantidadeBanheiro, enderecoCompleto, quantidadeQuintal) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setDouble(1, casa.getMetrosQuadrados());
			ps.setInt(2, casa.getQuantidadeQuarto());
			ps.setInt(3, casa.getQuantidadeBanheiro());
			ps.setString(4, casa.getEnderecoCompleto());
			ps.setInt(5, casa.getQuantidadeQuintal());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	
	
	public String deletarCasaSemWhere() {
		String sql = "delete from casa";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Casa> retornarDadosCasa(){
		String sql = "select * from casa";
		ArrayList<Casa> retornarCasa = new ArrayList<Casa>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Casa casa = new Casa();
					casa.setMetrosQuadrados(rs.getDouble(1));
					casa.setQuantidadeQuarto(rs.getInt(2));
					casa.setQuantidadeBanheiro(rs.getInt(3));
					casa.setEnderecoCompleto(rs.getString(4));
					casa.setQuantidadeQuintal(rs.getInt(5));

					retornarCasa.add(casa);
				}
				return retornarCasa;
			}else {
				return null;
			}
		}catch (SQLException e) {
			return null;
		}
	}
}
