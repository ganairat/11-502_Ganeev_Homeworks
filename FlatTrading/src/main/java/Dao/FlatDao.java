package Dao;


import Models.Flat;

import java.util.List;

public interface FlatDao {


    void add(Flat flat);
    void delete(int id);
    List<Flat> getAll();
    int findIdByParametrs(Flat flat);
    List<Flat> getFlatsByUserId(int id);
    void addToFlatClient(int idFlat, int idClient);

    Flat findById(int id);


}



