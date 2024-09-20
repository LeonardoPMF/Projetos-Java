package br.com.testetresbd.teste;

import java.sql.Connection;

import br.com.testetresbd.conexao.Conexao;
import br.com.testetresbd.dao.AlunoDAO;
import br.com.testetresbd.model.Aluno;

public class TesteInserir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = Conexao.abrirConexao();
		
		Aluno aluno = new Aluno();
		
		AlunoDAO alunodao = new AlunoDAO(con);
		
		aluno.setNome("Rafael");
		aluno.setEndereco("Rua X");
		aluno.setRm(123);
		
		System.out.println(alunodao.inserir(aluno));
		
		Conexao.fecharConexao(con);
	}

}
