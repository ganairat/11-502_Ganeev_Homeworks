package Service;


import Dao.ClientDao;
import Dao.FlatDao;
import Factories.DaoFactory;
import Models.Flat;

import java.util.List;

public class FlatServiceImpl  implements FlatService {
    private FlatDao flatDao;

    public FlatServiceImpl(){
        flatDao = DaoFactory.getInstance().getFlatDao();
    }
    public List<Flat> getAll() {
        return flatDao.getAll();
    }


    public void delete(int id) {
        flatDao.delete(id);
    }



    public void add(int districtId, String reqId, String amtRoom, String sqrKitchen, String type, String floor, String sqr) {

        Flat flat = new Flat(Integer.parseInt(String.valueOf(districtId)), Integer.parseInt(String.valueOf(reqId)), Integer.parseInt(String.valueOf(amtRoom)), Double.parseDouble(String.valueOf(sqrKitchen)), type, Integer.parseInt(String.valueOf(floor)), Double.parseDouble(sqr));

        flatDao.add(flat);
    }

    public List<Flat> getFlatsByUserId(int id) {
        FlatDao flatDao = DaoFactory.getInstance().getFlatDao();
        return flatDao.getFlatsByUserId(id);
    }

    public void addToFlatClient(int idClient, int idFLat) {
        FlatDao flatDao = DaoFactory.getInstance().getFlatDao();
        flatDao.addToFlatClient(idClient, idFLat);
    }

    @Override
    public int findIdByParameters(int districtId, String reqId, String amtRoom, String sqrKitchen, String type, String floor, String sqr) {
        FlatDao flatDao = DaoFactory.getInstance().getFlatDao();
        Flat flat = new Flat(districtId, Integer.parseInt(reqId), Integer.parseInt(amtRoom), Double.parseDouble(sqrKitchen), type, Integer.parseInt(floor), Double.parseDouble(sqr));
        return flatDao.findIdByParametrs(flat);
    }

    @Override
    public Flat findById(int id) {
        return flatDao.findById(id);
    }

}
