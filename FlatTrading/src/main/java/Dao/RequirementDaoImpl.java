package Dao;

import Factories.JdbcConnection;
import Models.Requirement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RequirementDaoImpl implements RequirementDao {
    private Connection connection = JdbcConnection.getInstance().getConnection();

    private  int findByPar(int idDistrict, double sqrMin, double sqrMax, int amtRoom, double sqrKitchenMin, double sqrKitchenMax, int floor, String kind){
        int id = 0;
        String query2 = "SELECT id FROM requirement WHERE (id_district = ? AND sqr_min = ? AND sqr_max = ? AND amt_room = ? AND sqr_kitchen_min = ? AND sqr_kitchen_max = ? AND floor = ? AND kind = ?);";
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(query2);
            preparedStatement1.setInt(1, idDistrict);
            preparedStatement1.setDouble(2, sqrMin);
            preparedStatement1.setDouble(3, sqrMax);
            preparedStatement1.setInt(4, amtRoom);
            preparedStatement1.setDouble(5, sqrKitchenMin);
            preparedStatement1.setDouble(6, sqrKitchenMax);
            preparedStatement1.setInt(7, floor);
            preparedStatement1.setString(8, kind);
            ResultSet rs = preparedStatement1.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public int add(Requirement requirement) {
        int id = 0;
        if (connection != null && requirement != null) {
            String query1 = "SELECT * FROM insert_req_and_return_id(?, ?, ?, ?, ?, ?, ?, ?);";


            String query = "INSERT INTO requirement (id_district, sqr_min, sqr_max, amt_room, sqr_kitchen_min, sqr_kitchen_max, floor, kind) VALUES ( ?,?,?,?,?,?,?,?);";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                id = findByPar(requirement.getIdDistrict(), requirement.getSqrMin(), requirement.getSqrMax(), requirement.getAmtRoom(), requirement.getSqrKitchenMin(), requirement.getSqrKitchenMax(), requirement.getFloor(), requirement.getKind());

                if(id == 0) {

               /* PreparedStatement preparedStatement = connection.prepareStatement(query1);*/
                    preparedStatement.setInt(1, requirement.getIdDistrict());
                    preparedStatement.setDouble(2, requirement.getSqrMin());
                    preparedStatement.setDouble(3, requirement.getSqrMax());
                    preparedStatement.setInt(4, requirement.getAmtRoom());
                    preparedStatement.setDouble(5, requirement.getSqrKitchenMin());
                    preparedStatement.setDouble(6, requirement.getSqrKitchenMax());
                    preparedStatement.setInt(7, requirement.getFloor());
                    preparedStatement.setString(8, requirement.getKind());
                    preparedStatement.executeUpdate();
                    id = findByPar(requirement.getIdDistrict(), requirement.getSqrMin(), requirement.getSqrMax(), requirement.getAmtRoom(), requirement.getSqrKitchenMin(), requirement.getSqrKitchenMax(), requirement.getFloor(), requirement.getKind());

                }

            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return id;
    }

    public void delete(int id) {
        if (connection != null){
        String query = "DELETE FROM requirement where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    }

    public List<Requirement> getAll() {
        return null;
    }

    @Override
    public Requirement findById(int id) {
        Requirement requirement = null;
        if(connection != null){
            String query = "SELECT * FROM requirement WHERE id = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1, id);

                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                    requirement = new Requirement(rs.getInt("id"), rs.getInt("id_district"), rs.getDouble("sqr_min"), rs.getDouble("sqr_max"), rs.getInt("amt_room"), rs.getDouble("sqr_kitchen_min"), rs.getDouble("sqr_kitchen_max"), rs.getInt("floor"), rs.getString("kind"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return requirement;
    }
}
