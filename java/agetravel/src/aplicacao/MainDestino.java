package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import dao.DestinoDAO;
import model.Destino;

public class MainDestino {
	
	public static void main(String[] args) throws ParseException {

	Scanner s = new Scanner(System.in);
	DestinoDAO destinoDAO = new DestinoDAO();
	int opcao = 0, id = 0;

	String destino = "";
	float preco; 
	Date dataPartida1;
	
	do
	{

		System.out.println("\n============================== DESTINOS =================================\n");
		System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
		opcao = s.nextInt();
		s.nextLine();
		
		SimpleDateFormat dateFormata = new SimpleDateFormat("dd/MM/yyyy");

		switch (opcao) {
		case 1: 

			System.out.println("Digite o destino:");
			destino = s.nextLine();
			System.out.println("Digite o preço:");
			preco = s.nextFloat();
			s.nextLine();
//			System.out.println("Digite a data da viagem:");
//			data_Destino = s.nextLine();
			System.out.println("Digite a data da viagem (dd/MM/yyyy):");
			String dataPartidaStr = s.nextLine();
			Date dataPartida = dateFormata.parse(dataPartidaStr);

			Destino destino1 = new Destino(destino, preco, dataPartida);
			destinoDAO.create(destino1);
			break;
		case 2:

			for (Destino d : destinoDAO.read()) {
				System.out.println(d.toString());
			}

			break;

		case 3:

			System.out.println("Digite o id:");
			id = s.nextInt();
			s.nextLine();
			System.out.println("Digite o destino:");
			destino = s.nextLine();
			System.out.println("Digite o preço:");
			preco = s.nextFloat();
			s.nextLine(); 
			System.out.println("Digite a data da viagem (dd/MM/yyyy):"); 
			String dataPartidaStr1 = s.nextLine(); 
			dataPartida1 = dateFormata.parse(dataPartidaStr1);

			Destino destino2 = new Destino(id, destino, preco, dataPartida1);

			destinoDAO.update(destino2);
			break;

		case 4:
			System.out.println("Digite um id:");
			id = s.nextInt();
			s.nextLine();

			destinoDAO.delete(id);
			break;

		case 5:
			System.out.println("Digite um id:");
			id = s.nextInt();
			s.nextLine();

			Destino destino3 = destinoDAO.readById(id);

			System.out.println(destino3.toString());
			break;
		default:

			break;
		}

	}while(opcao!=0);

	System.out.println("Até mais!");s.close();

}

}

