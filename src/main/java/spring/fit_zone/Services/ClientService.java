package spring.fit_zone.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fit_zone.models.Client;
import spring.fit_zone.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService{

    //injection reference
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> allClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Client searchClientById(Integer id) {
        Client client = clientRepository.findById(id).orElse(null);
        return client;
    }

    @Override
    public void saveClient(Client client) {
         clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
}
