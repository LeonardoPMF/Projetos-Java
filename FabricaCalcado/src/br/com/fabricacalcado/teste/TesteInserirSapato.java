package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;

public class TesteInserirSapato {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Sapato sapato = new Sapato();
		SapatoDAO sapatodao = new SapatoDAO(con);

		
		sapato.setTamanho(42);
		sapato.setPeso(200);
		sapato.setNome("Sapato de bico quadrado");
		sapato.setTipoTecido("Couro");

		System.out.println(sapatodao.inserirSapato(sapato));

		Conexao.fecharConexao(con);
	}
}
