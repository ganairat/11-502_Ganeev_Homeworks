package Dao;


import Factories.JdbcConnection;
import Models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDaoImpl implements ClientDao{
    private Connection connection = JdbcConnection.getInstance().getConnection();

    public void add(Client client) {
        if (connection != null && client != null) {
            int id = 0;
            String insertClients = "INSERT INTO clients (phone, login, pas) VALUES (?, ?, ?)";
            String selectIdClient = "SELECT id FROM clients WHERE login = ?";
            String query1 = "INSERT INTO client_info(id_info, first_name, middle_name, last_name) VALUES (?,?,?,?)";
            try {
                PreparedStatement preparedStatement1 = connection.prepareStatement(insertClients);
                PreparedStatement preparedStatement2 = connection.prepareStatement(selectIdClient);
                PreparedStatement preparedStatement3 = connection.prepareStatement(query1);

                preparedStatement1.setString(1, client.getPhone());
                preparedStatement1.setString(2, client.getLogin());
                preparedStatement1.setString(3, client.getPassword());
                preparedStatement1.executeUpdate();

                preparedStatement2.setString(1, client.getLogin());
                ResultSet resultSet = preparedStatement2.executeQuery();
                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                }

                preparedStatement3.setInt(1, id);
                preparedStatement3.setString(2, client.getFirstName());
                preparedStatement3.setString(3, client.getMiddleName());
                preparedStatement3.setString(4, client.getLastName());
                preparedStatement3.executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
    }


    public Client findClientByLogin(String login) {
        Client client = null;
        if (connection != null) {
            String request = "SELECT * FROM clients_view WHERE login = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(request);
                preparedStatement.setString(1, login);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    if (rs.getString("login") != null && rs.getString("login").equals(login)) {
                        client = new Client(rs.getInt("id"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"), rs.getString("phone"), rs.getString("login"), rs.getString("pas"));
                    }
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                return  null;
            }
        }
        return client;
    }

    public boolean checkLoginWithPassword(String login, String password) {
        Client client = null;
        if (connection != null) {
            String request = "SELECT * FROM return_client_info_by_login_and_pas(?, ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(request);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        client = new Client(rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"), rs.getString("phone"), rs.getString("login"), rs.getString("pas"));

                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                return  false;
            }
        }
        return client != null;
    }
}
