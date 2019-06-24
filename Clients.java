package HW_3_1;

public class Clients {
    private String name;
    private String phoneNumber;

    public Clients(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Subscriber {" +
                "Surname = '" + name + '\'' +
                ", telephone number = '" + phoneNumber + '\'' +
                '}';
    }

}