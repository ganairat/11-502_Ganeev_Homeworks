package Service;

import Models.Client;

public interface ClientService {
    void add(String phone, String login, String pas, String firstName, String middleName, String lastName);
    Client findClientByLogin(String login);
    boolean checkLoginWithPassword(String login, String password);
}
