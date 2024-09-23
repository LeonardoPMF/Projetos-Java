package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;

public class TesteDeletarChinelo {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Chinelo chinelo = new Chinelo();
		ChineloDAO chinelodao = new ChineloDAO(con);

		
		
		chinelo.setNome("Havaianas blue");
		

		System.out.println(chinelodao.deletarChineloWhere(chinelo));

		Conexao.fecharConexao(con);
	}
}
