package br.com.testedoisbd.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.testedoisbd.conexao.Conexao;
import br.com.testedoisbd.dao.PessoaDAO;
import br.com.testedoisbd.model.Pessoa;

public class TesteSelecionarPessoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = Conexao.abrirConexao();
		
		
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		ArrayList<Pessoa> lista = pessoadao.retornarDadosPessoa();
		
		if(lista != null) {
			for(Pessoa p : lista) {
				System.out.println("Nome: " + p.getNome());
				System.out.println("Endereco " + p.getEndereco());
			}
		}
		
		Conexao.fecharConexao(con);
	}

}
