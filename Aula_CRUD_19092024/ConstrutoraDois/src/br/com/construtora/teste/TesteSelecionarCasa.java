package br.com.construtora.teste;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.construtora.beans.Casa;
import br.com.construtora.conexao.Conexao;
import br.com.construtora.dao.CasaDAO;

public class TesteSelecionarCasa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = Conexao.abrirConexao();

		CasaDAO casadao = new CasaDAO(con);

		ArrayList<Casa> lista = casadao.retornarDadosCasa();

		if (lista != null) {
			for (Casa p : lista) {
				System.out.println("Metros quadrados: " + p.getMetrosQuadrados());
				System.out.println("Quantidade de quartos " + p.getQuantidadeQuarto());
				System.out.println("Quantidade de banheiros " + p.getQuantidadeBanheiro());
				System.out.println("Endeço completo " + p.getEnderecoCompleto());
				System.out.println("Quantidade quinta " + p.getQuantidadeQuintal());
			}
		}
		 Conexao.fecharConexao(con);
	}

}
