package Dao;

import Models.District;

public interface DistrictDao {
    int add(District district);
    String findById(int id);
}
