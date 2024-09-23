package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;

public class TesteDeletarSapato {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Sapato sapato = new Sapato();
		SapatoDAO sapatodao = new SapatoDAO(con);

		sapato.setNome("Havaianas blue");
		
		System.out.println(sapatodao.deletarSapatoWhere(sapato));

		Conexao.fecharConexao(con);
	}
}
