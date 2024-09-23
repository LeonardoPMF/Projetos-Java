package br.com.construtora.teste;

import java.sql.Connection;

import br.com.construtora.beans.Casa;
import br.com.construtora.conexao.Conexao;
import br.com.construtora.dao.CasaDAO;



public class TesteDeletarCasa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = Conexao.abrirConexao();

	CasaDAO casadao = new CasaDAO(con);


 System.out.println(casadao.deletarCasaSemWhere());
 Conexao.fecharConexao(con);
	
	}
	
	

}
