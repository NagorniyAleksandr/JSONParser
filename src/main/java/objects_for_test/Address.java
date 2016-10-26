package objects_for_test;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class Address {

    private String city;
    private String buildingNumber;

    public Address() {
    }

    public Address(String city, String buildingNumber) {
        this.city = city;
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
