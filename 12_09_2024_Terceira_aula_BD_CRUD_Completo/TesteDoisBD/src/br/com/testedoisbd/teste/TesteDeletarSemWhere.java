package br.com.testedoisbd.teste;

import java.sql.Connection;

import br.com.testedoisbd.conexao.Conexao;
import br.com.testedoisbd.dao.PessoaDAO;
import br.com.testedoisbd.model.Pessoa;

public class TesteDeletarSemWhere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = Conexao.abrirConexao();
		
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		System.out.println(pessoadao.deletarPessoaSemWhere());
		
		Conexao.fecharConexao(con);
	}

}
