package Models;


public class District {

    private int id;
    private String districtName;



    public District(String districtName) {
        this.districtName = districtName;
    }

    public int getId() {
        return id;
    }

    public String getDistrictName() {
        return districtName;
    }

}
