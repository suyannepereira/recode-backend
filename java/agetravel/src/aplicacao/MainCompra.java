package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.DestinoDAO;
import model.Cliente;
import model.Compra;
import model.Destino;

public class MainCompra {

	public static void main(String[] args) throws ParseException {

		Scanner s = new Scanner(System.in);
		CompraDAO compraDAO = new CompraDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		int opcao = 0, id = 0, id_Destino, id_Cliente;
		String data_CompraStr;
		float total_Compra; 
		Date data_Compra;
		
		do
		{

			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			SimpleDateFormat dateFormata = new SimpleDateFormat("dd/MM/yyyy");

			switch (opcao) {
			case 1: 

				System.out.println("Digite o id do cliente:");
				id_Cliente = s.nextInt();
				s.nextLine();
				Cliente	cliente = clienteDAO.readById(id_Cliente);		
				System.out.println("Digite o id do destino:");
				id_Destino = s.nextInt();
				s.nextLine();
				Destino destino = destinoDAO.readById(id_Destino);
				System.out.println("Digite o preço total:");
				total_Compra = s.nextFloat();
				s.nextLine();
				System.out.println("Digite a data da viagem (dd/MM/yyyy):");
				data_CompraStr = s.nextLine();
				data_Compra = dateFormata.parse(data_CompraStr);

				Compra compra1 = new Compra(data_Compra, total_Compra, destino, cliente );
				compraDAO.create(compra1);
				break;
			case 2:

				for (Compra c : compraDAO.read()) {
					System.out.println(c.toString());
				}

				break;

			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do cliente:");
				id_Cliente = s.nextInt();
				Cliente	cliente1 = clienteDAO.readById(id_Cliente);		
				System.out.println("Digite o destino:");
				id_Destino = s.nextInt();
				s.nextLine();
				Destino destino1 = destinoDAO.readById(id_Destino);
				System.out.println("Digite o preço total:");
				total_Compra = s.nextFloat();
				s.nextLine();
				System.out.println("Digite a data da viagem (dd/MM/yyyy):");
				data_CompraStr = s.nextLine();
				data_Compra = dateFormata.parse(data_CompraStr);

				Compra compra2 = new Compra(id, data_Compra, total_Compra, destino1, cliente1);

				compraDAO.update(compra2);
				break;

			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				compraDAO.delete(id);
				break;

			case 5:
				System.out.println("Digite um id:"); 
				id = s.nextInt();
				s.nextLine();

				Compra compra3 = compraDAO.readById(id);

				System.out.println(compra3.toString());
				break;
			default:

				break;
			}

		}while(opcao!=0);

		System.out.println("Até mais!");s.close();

	}

	
}
