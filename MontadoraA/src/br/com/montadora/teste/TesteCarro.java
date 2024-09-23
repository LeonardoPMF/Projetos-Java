package br.com.montadora.teste;

import javax.swing.JOptionPane;

import br.com.montadora.model.Carro;

public class TesteCarro {

	public static void main(String[] args) {
		
		Carro carro = new Carro();
	
		carro.setMontadora(JOptionPane.showInputDialog("Digite a montadora"));
		carro.setModelo(JOptionPane.showInputDialog("Digite o modelo"));
		carro.setQuantidadePortas(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de portas")));
		
		System.out.println(carro.getMontadora() + "\n" +
				carro.getModelo() + "\n" +
				carro.getQuantidadePortas() + "\n"
				);

	}
}
