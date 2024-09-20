package br.com.testedoisbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.testedoisbd.model.Pessoa;

public class PessoaDAO {
	
	private Connection con;

	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public PessoaDAO() {
	}
	public PessoaDAO(Connection con) {
		setCon(con);
	}
	
	
	public String inserir(Pessoa pessoa) {
		String sql = "insert into pessoa(nome, endereco) values (?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEndereco());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletarPessoaSemWhere() {
		String sql = "delete from pessoa;";
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

	
	public String deletarPessoaComWhere(Pessoa pessoa) {
		String sql = "delete from pessoa where nome like (?);";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public String modificarPessoaComWhere(Pessoa pessoa) {
		String sql = "update pessoa set nome = (?) where endereço = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEndereco());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Pessoa> retornarDadosPessoa(){
		String sql = "select * from pessoa";
		ArrayList<Pessoa> retornarPessoa = new ArrayList<Pessoa>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(rs.getString(1));
					pessoa.setEndereco(rs.getString(2));
					retornarPessoa.add(pessoa);
				}
				return retornarPessoa;
			}else {
				return null;
			}
		}catch (SQLException e) {
			return null;
		}
	}
}
