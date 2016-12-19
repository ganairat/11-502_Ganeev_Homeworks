package Models;


public class Client {

    private int id;
    private int idFlat;
    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    public Client(String firstName, String middleName, String lastName, String phone, String login, String password) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;

    }

    public Client(int id, String firstName, String middleName, String lastName, String phone, String login, String pas) {
        this.id = id;
        this.login = login;
        this.password = pas;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }
    public int getIdFlat() {
        return idFlat;
    }





}
