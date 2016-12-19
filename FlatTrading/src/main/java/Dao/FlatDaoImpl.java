package Dao;


import Factories.JdbcConnection;
import Models.Flat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlatDaoImpl implements FlatDao{
    private Connection connection = JdbcConnection.getInstance().getConnection();
    public void add(Flat flat) {
        if (connection != null && flat != null) {
            String query = "INSERT INTO flat ( id_req, id_dist, amt_room, sqr_kitchen, floor, kind, sqr) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement preparedStatement = JdbcConnection.getInstance().getConnection().prepareStatement(query);
                preparedStatement.setInt(1, flat.getReqId());
                preparedStatement.setInt(2, flat.getDistrictId());
                preparedStatement.setInt(3, flat.getAmtRoom());
                preparedStatement.setDouble(4, flat.getSqrKitchen());
                preparedStatement.setInt(5, flat.getFloor());
                preparedStatement.setString(6, flat.getType());
                preparedStatement.setDouble(7, flat.getSqr());
                preparedStatement.executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        if(connection != null){
        String query = "DELETE FROM flats WHERE id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=JdbcConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }


    public List<Flat> getAll() {
        List<Flat> list = new ArrayList<Flat>();
        if (connection != null) {
            String request = "SELECT * FROM flat, flat_client WHERE flat_client.id_flat = flat.id";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(request);
                ResultSet rs = preparedStatement.executeQuery();


                Flat flat = null;
                while (rs.next()) {
                    flat = new Flat(rs.getInt("id"), rs.getInt("id_client"), rs.getInt("id_dist"),rs.getInt("id_req"), rs.getInt("amt_room"),  rs.getDouble("sqr_kitchen"),  rs.getString("kind"), rs.getInt("floor"), rs.getDouble("sqr"));
                    list.add(flat);
                }

            } catch (SQLException sql) {
                sql.printStackTrace();
                return  null;
            }
        }
        return list;
    }

    public int findIdByParametrs(Flat flat) {
        int id = 1;
        if(connection != null){
            String query = "SELECT id FROM flat WHERE id_req = ? AND id_dist = ? AND sqr = ? AND amt_room = ? AND sqr_kitchen = ? AND floor = ? AND kind = ?";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1, flat.getReqId());
                preparedStatement.setInt(2, flat.getDistrictId());
                preparedStatement.setDouble(3, flat.getSqr());
                preparedStatement.setInt(4, flat.getAmtRoom());
                preparedStatement.setDouble(5, flat.getSqrKitchen());
                preparedStatement.setInt(6, flat.getFloor());
                preparedStatement.setString(7, flat.getType());

                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    id = rs.getInt("id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return id;
    }

    public List<Flat> getFlatsByUserId(int id) {
        List<Flat> list = new ArrayList<Flat>();
        if(connection != null){
            String query = "SELECT * FROM flat, flat_client WHERE flat.id = flat_client.id_flat AND id_client = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();

                Flat flat = null;
                while (rs.next()) {
                    flat = new Flat(rs.getInt("id"), rs.getInt("id_dist"),rs.getInt("id_req"), rs.getInt("amt_room"),  rs.getDouble("sqr_kitchen"),  rs.getString("kind"), rs.getInt("floor"), rs.getDouble("sqr"));
                    list.add(flat);
                }

            } catch (SQLException sql) {
                sql.printStackTrace();
                return  null;
            }

        }
        return list;
    }

    public void addToFlatClient(int idFlat, int idClient) {
        if (connection != null && idClient!=0 && idFlat != 0) {
            String query = "INSERT INTO flat_client(id_client, id_flat) VALUES (?, ?)";
            try {
                PreparedStatement preparedStatement = JdbcConnection.getInstance().getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idClient);
                preparedStatement.setInt(2, idFlat);
                preparedStatement.executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
    }

    public Flat findById(int id) {
        Flat flat = null;
        if (connection != null){
            String query = "SELECT * FROM flat, flat_client WHERE flat_client.id_flat = flat.id AND flat.id = ?";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()){
                    flat = new Flat(rs.getInt("id"), rs.getInt("id_client"), rs.getInt("id_dist"),rs.getInt("id_req"), rs.getInt("amt_room"),  rs.getDouble("sqr_kitchen"),  rs.getString("kind"), rs.getInt("floor"), rs.getDouble("sqr"));
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return flat;
    }
}
