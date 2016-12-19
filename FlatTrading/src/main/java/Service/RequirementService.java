package Service;

import Models.Requirement;

import java.util.List;

public interface RequirementService {


    int add(int idDistrict, String sqrMin, String sqrMax, String amtRoom, String sqrKitchenMin, String sqrKitchenMax, String floor, String kind);
    void delete(int id);
    List<Requirement> getAll();
    Requirement findById(int id);
}
