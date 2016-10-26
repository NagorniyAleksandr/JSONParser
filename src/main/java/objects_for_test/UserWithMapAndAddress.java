package objects_for_test;

import java.util.Map;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserWithMapAndAddress extends UserWithMap {

    private Address currentAddress;

    public UserWithMapAndAddress() {
    }

    public UserWithMapAndAddress(int localId, long longId, String name, double salary,
                                 Map<String, Double> salaryHistoty, Address currentAddress) {
        super(localId, longId, name, salary, salaryHistoty);
        this.currentAddress = currentAddress;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }
}
