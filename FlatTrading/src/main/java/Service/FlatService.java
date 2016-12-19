package Service;

import Models.Flat;

import java.util.List;

public interface FlatService {
    List<Flat> getAll();
    void delete(int id);
    void add(int districtId, String reqId, String amtRoom, String sqrKitchen, String type, String floor, String sqr);
    List<Flat> getFlatsByUserId(int id);
    void addToFlatClient(int idClient, int idFLat);
    int findIdByParameters(int districtId, String reqId, String amtRoom, String sqrKitchen, String type, String floor, String sqr);
    Flat findById(int id);
}
