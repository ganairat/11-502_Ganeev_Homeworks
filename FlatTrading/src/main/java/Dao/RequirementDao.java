package Dao;

import Models.Requirement;

import java.util.List;

public interface RequirementDao {

    int add(Requirement requirement);
    void delete(int id);
    List<Requirement> getAll();

    Requirement findById(int id);

}
