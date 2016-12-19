package Service;

import Dao.DistrictDao;
import Factories.DaoFactory;
import Models.District;

public class DistrictServiceImpl implements DistrictService {
    private DistrictDao districtDao;

    public DistrictServiceImpl()
    {
        districtDao = DaoFactory.getInstance().getDistrictDao();
    }
    public int add(String district) {
        District district1 = new District(district);
        return districtDao.add(district1);
    }

    @Override
    public String findById(int id) {
        return districtDao.findById(id);
    }
}
