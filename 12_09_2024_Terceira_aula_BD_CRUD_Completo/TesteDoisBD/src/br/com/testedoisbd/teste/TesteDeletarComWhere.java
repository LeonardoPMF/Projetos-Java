package br.com.testedoisbd.teste;

import java.sql.Connection;

import br.com.testedoisbd.conexao.Conexao;
import br.com.testedoisbd.dao.PessoaDAO;
import br.com.testedoisbd.model.Pessoa;

public class TesteDeletarComWhere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		pessoa.setNome("Rafael");
		
		
		System.out.println(pessoadao.deletarPessoaComWhere(pessoa));
		
		Conexao.fecharConexao(con);
	}

}
