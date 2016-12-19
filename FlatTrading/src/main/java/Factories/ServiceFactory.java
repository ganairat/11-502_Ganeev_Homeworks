package Factories;

import Models.Client;
import Service.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServiceFactory {


        private static Factories.ServiceFactory instance;
        private Properties properties;
        private FlatService flatService;
        private ClientService clientService;
        private DistrictService districtService;
        private RequirementService requirementService;

        private ServiceFactory() {
            try {
                properties = new Properties();
                properties.load(
                        new FileInputStream("C:\\Users\\Айрат\\IdeaProjects\\FlatTrading\\src\\main\\resources\\service.properties"));

                String flatClass = properties.getProperty("flat.class");
                String clientClass = properties.getProperty("client.class");
                String districtClass = properties.getProperty("district.class");
                String requirementClass = properties.getProperty("requirement.class");

                this.flatService = (FlatService) Class.forName(flatClass).newInstance();
                this.clientService = (ClientService) Class.forName(clientClass).newInstance();
                this.districtService = (DistrictService) Class.forName(districtClass).newInstance();
                this.requirementService = (RequirementService) Class.forName(requirementClass).newInstance();
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
            instance = new Factories.ServiceFactory();
        }

        public FlatService getFlatService() {
            return flatService;
        }

        public ClientService getClientService() {
            return clientService;
        }

        public RequirementService getRequirementService() {
            return requirementService;
        }

        public DistrictService getDistrictService(){ return districtService; }



        public static Factories.ServiceFactory getInstance() {
            return instance;
        }
}

