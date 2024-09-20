package br.com.testetresbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.testetresbd.model.Aluno;


public class AlunoDAO {
	
	private Connection con;

	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public AlunoDAO() {
	}
	public AlunoDAO(Connection con) {
		setCon(con);
	}
	
	
	public String inserir(Aluno aluno) {
		String sql = "insert into alunodois(nome, endereco, rm) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getEndereco());
			ps.setInt(3, aluno.getRm());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
