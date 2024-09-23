package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;

public class TesteAlterarSapato {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Sapato sapato = new Sapato();
		SapatoDAO sapatodao = new SapatoDAO(con);

		
		sapato.setTamanho(51);
		
		sapato.setNome("Sapato de bico quadrado");
		
		System.out.println(sapatodao.alterarTamanhoSapato(sapato));

		Conexao.fecharConexao(con);
	}
}
