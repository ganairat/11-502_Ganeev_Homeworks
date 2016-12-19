package Service;

import Dao.RequirementDao;
import Factories.DaoFactory;
import Models.Requirement;

import java.util.List;

public class RequirementSeviceImpl implements RequirementService {

    private RequirementDao requirementDao;

    public RequirementSeviceImpl() {
        this.requirementDao = DaoFactory.getInstance().getRequirementDao();
    }

    public int add(int idDistrict, String sqrMin, String sqrMax, String amtRoom, String sqrKitchenMin, String sqrKitchenMax, String floor, String kind) {
        Requirement requirement = new Requirement(idDistrict, Double.parseDouble(sqrMin), Double.parseDouble(sqrMax), Integer.parseInt(amtRoom), Double.parseDouble(sqrKitchenMin), Double.parseDouble(sqrKitchenMax), Integer.parseInt(floor), kind);
        return requirementDao.add(requirement);
    }

    public void delete(int id) {
        requirementDao.delete(id);
    }

    public List<Requirement> getAll() {
        return null;
    }

    @Override
    public Requirement findById(int id) {
       return requirementDao.findById(id);
    }
}
