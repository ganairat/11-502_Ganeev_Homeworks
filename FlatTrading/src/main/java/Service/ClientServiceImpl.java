package Service;

import Dao.ClientDao;
import Factories.DaoFactory;
import Models.Client;

public class ClientServiceImpl implements ClientService{
   private ClientDao clientDao;

    public ClientServiceImpl(){
        clientDao = DaoFactory.getInstance().getClientDao();
    }

    public void add(String phone, String login, String pas, String firstName, String middleName, String lastName) {
        Client client = new Client(firstName, middleName, lastName, phone, login, pas);
        clientDao.add(client);
    }


    public Client findClientByLogin(String login) {
        return clientDao.findClientByLogin(login);
    }


    public boolean checkLoginWithPassword(String login, String password) {
        return clientDao.checkLoginWithPassword(login, password);
    }
}
