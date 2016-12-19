package Dao;

import Models.Client;

public interface ClientDao {

    void add(Client client);
    Client findClientByLogin(String login);
    boolean checkLoginWithPassword(String login, String password);
}
