
package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import model.Cliente;

public class MainCliente {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		FormCliente formcliente = new FormCliente();
		int opcao = 0, id = 0;

		String nome = "", email = "", senha = "", tel = "";

		do {

			System.out.println("\n============================== USUARIOS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				formcliente.cadastrar();
				break;
			case 2:

				formcliente.consultar();

				break;
			case 3:

				formcliente.atualizar();
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				clienteDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Cliente cliente3 = clienteDAO.readById(id);

				System.out.println(cliente3.toString());
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}

}
