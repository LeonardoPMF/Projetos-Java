package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;

public class TesteAlterarChinelo {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Chinelo chinelo = new Chinelo();
		ChineloDAO chinelodao = new ChineloDAO(con);

		
		chinelo.setTamanho(51);
		
		chinelo.setNome("Havaianas blue");
		

		System.out.println(chinelodao.alterarTamanhoChinelo(chinelo));

		Conexao.fecharConexao(con);
	}
}
