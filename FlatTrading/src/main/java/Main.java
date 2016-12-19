import Models.Flat;
import Service.FlatServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args){
        /* Dao.FlatDaoImpl flatDao = new FlatDaoImpl(co);
        List list = flatDao.getFlatsByUserId(2);*/
        FlatServiceImpl flatService = new FlatServiceImpl();
        List list = flatService.getAll();
       System.out.println(((Flat)list.get(0)).getFloor());
    }
}
