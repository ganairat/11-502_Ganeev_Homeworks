package Factories;


import Dao.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
    private static DaoFactory instance;
    private Properties properties;

    private FlatDao flatDao;
    private ClientDao clientDao;
    private DistrictDao districtDao;
    private RequirementDao requirementDao;

    private DaoFactory() {
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\Айрат\\IdeaProjects\\FlatTrading\\src\\main\\resources\\dao.properties"));

            String flatClass = properties.getProperty("flat.class");
            String clientClass = properties.getProperty("client.class");
            String districtClass = properties.getProperty("district.class");
            String requirementClass = properties.getProperty("requirement.class");

            this.flatDao = (FlatDao) Class.forName(flatClass).newInstance();
            this.clientDao = (ClientDao) Class.forName(clientClass).newInstance();
            this.districtDao = (DistrictDao) Class.forName(districtClass).newInstance();
            this.requirementDao = (RequirementDao) Class.forName(requirementClass).newInstance();


        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException();
        }
    }

    static  {
        instance = new DaoFactory();
    }

    public FlatDao getFlatDao() {
        return flatDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public DistrictDao getDistrictDao() {
        return districtDao;
    }

    public RequirementDao getRequirementDao(){return requirementDao; }

    public static DaoFactory getInstance() {
        return instance;
    }
}