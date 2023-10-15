package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import model.Cliente;

public class FormCliente {

	private Scanner s = new Scanner(System.in);
	private ClienteDAO clienteDAO = new ClienteDAO();
	private String nome = "", email = "", senha = "", tel = "";

	private int opcao, id; 

	public void cadastrar() { 

		System.out.println("Digite o nome:");
		nome = s.nextLine();
		System.out.println("Digite o email:");
		email = s.nextLine();
		System.out.println("Digite o tel:");
		tel = s.nextLine();
		System.out.println("Digite a senha:");
		senha = s.nextLine();

		Cliente cliente1 = new Cliente(nome, email, tel, senha);

		clienteDAO.create(cliente1);
	}

	public void consultar() {

		for (Cliente u : clienteDAO.read()) {
			System.out.println(u.toString());
		}
	}

	public void atualizar() {

		System.out.println("Digite o id:");
		id = s.nextInt();
		s.nextLine();
		System.out.println("Digite o nome:");
		nome = s.nextLine();
		System.out.println("Digite o email:");
		email = s.nextLine();
		System.out.println("Digite o tel:");
		tel = s.nextLine();
		System.out.println("Digite a senha:");
		senha = s.nextLine();

		Cliente cliente2 = new Cliente(id, nome, email, tel, senha);

		clienteDAO.update(cliente2);
	}

}
