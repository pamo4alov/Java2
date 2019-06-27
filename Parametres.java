package HW_4_1;

public class Parametres {
    private String userName = "P.M.";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void saveToXml(){
        // todo From the elements of the Settings form, take values and write them into the fields of the Parametres class
        setUserName(Settings.textUserName.getText());
        // todo Save from Parametres class fields to xml file
        System.out.println("To save the Parametres class fields in the xml file");

    }

    public void loadFromXml(){
        //
        //TODO write code :: load from xml file
        System.out.println("Loading from XML...");
        setUserName("P.M.");
    }
}
