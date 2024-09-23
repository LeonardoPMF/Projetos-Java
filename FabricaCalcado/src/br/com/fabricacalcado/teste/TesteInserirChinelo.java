package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;

public class TesteInserirChinelo {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Chinelo chinelo = new Chinelo();
		ChineloDAO chinelodao = new ChineloDAO(con);

		
		chinelo.setTamanho(43);
		chinelo.setPeso(300);
		chinelo.setNome("Rider");
		chinelo.setQuantidadeTiras(2);

		System.out.println(chinelodao.inserirChinelo(chinelo));

		Conexao.fecharConexao(con);
	}
}
