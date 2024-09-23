package br.com.construtora.teste;

import java.sql.Connection;

import br.com.construtora.beans.Casa;
import br.com.construtora.conexao.Conexao;
import br.com.construtora.dao.CasaDAO;



public class TesteInserir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = Conexao.abrirConexao();

	CasaDAO casadao = new CasaDAO(con);
	
	Casa casa = new Casa();
	
	casa.setMetrosQuadrados(33);
	casa.setQuantidadeQuarto(2);
	casa.setQuantidadeBanheiro(1);
	casa.setEnderecoCompleto("RuaXXX");
	casa.setQuantidadeQuintal(1);

 System.out.println(casadao.inserirCasa(casa));
 Conexao.fecharConexao(con);
	
	}
	
	

}
