package Models;

public class Flat {

    private int id;
    private int clientId;
    private int districtId;
    private int reqId;
    private int amtRoom;
    private double sqrKitchen;
    private String type;
    private int floor;
    private double sqr;

    public Flat(int clientId, int districtId, int reqId, int amtRoom, double sqrKitchen, String type, int floor, double sqr) {
        this.clientId = clientId;
        this.districtId = districtId;
        this.reqId = reqId;
        this.amtRoom = amtRoom;
        this.sqrKitchen = sqrKitchen;
        this.type = type;
        this.floor = floor;
        this.sqr = sqr;
    }
    public Flat(int districtId, int reqId, int amtRoom, double sqrKitchen, String type, int floor, double sqr) {
        this.districtId = districtId;
        this.reqId = reqId;
        this.amtRoom = amtRoom;
        this.sqrKitchen = sqrKitchen;
        this.type = type;
        this.floor = floor;
        this.sqr = sqr;
    }

    public Flat(int id, int clientId, int districtId, int reqId, int amtRoom, double sqrKitchen, String type, int floor, double sqr) {
        this.id = id;
        this.clientId = clientId;
        this.districtId = districtId;
        this.reqId = reqId;
        this.amtRoom = amtRoom;
        this.sqrKitchen = sqrKitchen;
        this.type = type;
        this.floor = floor;
        this.sqr = sqr;
    }

    public int getDistrictId() {
        return districtId;
    }

    public int getReqId() {
        return reqId;
    }

    public int getAmtRoom() {
        return amtRoom;
    }

    public double getSqrKitchen() {
        return sqrKitchen;
    }

    public String getType() {
        return type;
    }






    public int getClientId() {
        return clientId;
    }

    public int getId() {
        return id;
    }

    public double getSqr() {
        return sqr;
    }

    public int getFloor() {
        return floor;
    }

}
