package spring.fit_zone.Services;

import spring.fit_zone.models.Client;

import java.util.List;

public interface IClientService {
    public List<Client> allClients();
    public Client searchClientById(Integer id);
    public void saveClient(Client client);
    public void deleteClient(Client client);
}
