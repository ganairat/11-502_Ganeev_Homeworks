package Models;

public class Requirement {

    private int id;
    private int idDistrict;
    private double sqrMin;
    private double sqrMax;
    private int amtRoom;
    private double sqrKitchenMin;
    private double sqrKitchenMax;
    private int floor;
    private String kind;



    public Requirement(int idDistrict, double sqrMin, double sqrMax, int amtRoom, double sqrKitchenMin, double sqrKitchenMax, int floor, String kind) {
        this.idDistrict = idDistrict;
        this.sqrMin = sqrMin;
        this.sqrMax = sqrMax;
        this.amtRoom = amtRoom;
        this.sqrKitchenMin = sqrKitchenMin;
        this.sqrKitchenMax = sqrKitchenMax;
        this.floor = floor;
        this.kind = kind;
    }
    public Requirement(int id, int idDistrict, double sqrMin, double sqrMax, int amtRoom, double sqrKitchenMin, double sqrKitchenMax, int floor, String kind) {
        this.id = id;
        this.idDistrict = idDistrict;
        this.sqrMin = sqrMin;
        this.sqrMax = sqrMax;
        this.amtRoom = amtRoom;
        this.sqrKitchenMin = sqrKitchenMin;
        this.sqrKitchenMax = sqrKitchenMax;
        this.floor = floor;
        this.kind = kind;
    }

    public int getId() {
        return id;
    }


    public int getIdDistrict() {
        return idDistrict;
    }

    public double getSqrMin() {
        return sqrMin;
    }

    public double getSqrMax() {
        return sqrMax;
    }

    public int getAmtRoom() {
        return amtRoom;
    }

    public double getSqrKitchenMin() {
        return sqrKitchenMin;
    }

    public double getSqrKitchenMax() {
        return sqrKitchenMax;
    }

    public String getKind() {
        return kind;
    }

    public int getFloor() {
        return floor;
    }

}
