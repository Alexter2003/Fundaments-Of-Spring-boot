package spring.fit_zone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.fit_zone.Services.ClientService;
import spring.fit_zone.Services.IClientService;
import spring.fit_zone.models.Client;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FitZoneApplication implements CommandLineRunner {

	@Autowired
	private ClientService clientService;

	String nl = System.lineSeparator();

	//to send information to the console
	private static final Logger logger = LoggerFactory.getLogger(FitZoneApplication.class);

	public static void main(String[] args) {
		logger.info("Starting application");
		SpringApplication.run(FitZoneApplication.class, args);
		logger.info("Application ended");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Application fit zone");
		fitZone();
	}

	private void fitZone(){
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		int option;

		logger.info(nl + "*** Fit zone ***" + nl);

		while(!exit){
			option = showMenu(sc);
			exit = exectOption(sc, option);
			logger.info(nl);
		}
	}

	private int showMenu(Scanner sc){
		logger.info("1. Show all clients");
		logger.info("2. Search client by id");
		logger.info("3. Add client");
		logger.info("4. Delete client");
		logger.info("5. Edit client");
		logger.info("6. Exit");
		logger.info("Choose an option: ");
		return Integer.parseInt(sc.nextLine());
	}

	private boolean exectOption(Scanner sc, int option){
		var exit = false;
		switch (option){
			case 1 -> {
				logger.info(nl + "All clients: " + nl);
				List<Client> clients = clientService.allClients();
				clients.forEach(client -> logger.info(client.toString() + nl));

			}
			case 2 -> {
				logger.info("Enter the id to search: ");
				var id = Integer.parseInt(sc.nextLine());
				Client client = clientService.searchClientById(id);
				if(client == null){
					logger.info("Client not found");
				}else{
					logger.info(client.toString());
				}
			}

			case 3 -> {
				logger.info("Enter the name: ");
				var name = sc.nextLine();
				logger.info("Enter the last name: ");
				var lastName = sc.nextLine();
				logger.info("Enter the membership: ");
				var membership = Integer.parseInt(sc.nextLine());
				Client client = new Client();
				client.setNombre(name);
				client.setApellidos(lastName);
				client.setMembresia(membership);
				//save client
				clientService.saveClient(client);

				logger.info("Client saved" + client + nl);
			}

			case 4 -> {
				logger.info("Enter the id to delete: ");
				var id  = Integer.parseInt(sc.nextLine());
				Client client = clientService.searchClientById(id);
				if(client == null){
					logger.info("Client not found");
				}else{
					clientService.deleteClient(client);
					logger.info("The client has been elminated");
				}
			}

			case 5 -> {
				logger.info("Enter the id to edit: ");
				var id = Integer.parseInt(sc.nextLine());
				Client client = clientService.searchClientById(id);
				if(client == null){
					logger.info("Client not found");
				}else{
					logger.info("Enter the name: ");
					var name = sc.nextLine();
					logger.info("Enter the last name: ");
					var lastName = sc.nextLine();
					logger.info("Enter the membership: ");
					var membership = Integer.parseInt(sc.nextLine());
					client.setNombre(name);
					client.setApellidos(lastName);
					client.setMembresia(membership);
					clientService.saveClient(client);
					logger.info("Client updated" + client + nl);
				}
			}

			case 6 -> {
				exit = true;
				logger.info("Bye");
			}

			default -> logger.info("Invalid option");
		}

		return exit;
	}
}
