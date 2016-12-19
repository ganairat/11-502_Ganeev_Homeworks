package Dao;

import Factories.JdbcConnection;
import Models.District;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictDaoImpl implements DistrictDao{
    private Connection connection = JdbcConnection.getInstance().getConnection();

    public int add(District district) {
        int id = 0;
        if (JdbcConnection.getInstance().getConnection() != null && district != null) {
            String query1 = "SELECT id_district FROM district WHERE district_name = ?";

            String query = "INSERT INTO district (district_name) VALUES (?)";
            try {
                PreparedStatement preparedStatement1 = JdbcConnection.getInstance().getConnection().prepareStatement(query1);
                preparedStatement1.setString(1, district.getDistrictName());
                ResultSet rs = preparedStatement1.executeQuery();
                while (rs.next()){
                    id = rs.getInt("id_district");
                }
                if(id != 0)
                    return id;
                else {

                    PreparedStatement preparedStatement = JdbcConnection.getInstance().getConnection().prepareStatement(query);
                    preparedStatement.setString(1, district.getDistrictName());
                    preparedStatement.executeUpdate();

                    rs = preparedStatement1.executeQuery();
                    while (rs.next()) {
                        id = rs.getInt("id_district");
                    }
                    return id;
                }
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return id;
    }

    @Override
    public String findById(int id) {
        String name = "";
        if(connection != null){
            String query = "SELECT district_name FROM district WHERE id_district = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next())
                    name = rs.getString(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

}
