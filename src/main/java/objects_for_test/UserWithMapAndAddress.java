package objects_for_test;

import java.util.Map;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserWithMapAndAddress {

    private int localId;
    private long longId;
    private String name;
    private double salary;

    private Map<String, Double> salaryHistoty;
    private Address currentAddress;

    public UserWithMapAndAddress() {
    }

    public UserWithMapAndAddress(int localId, long longId, String name, double salary, Map<String, Double> salaryHistoty, Address currentAddress) {
        this.localId = localId;
        this.longId = longId;
        this.name = name;
        this.salary = salary;
        this.salaryHistoty = salaryHistoty;
        this.currentAddress = currentAddress;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public long getLongId() {
        return longId;
    }

    public void setLongId(long longId) {
        this.longId = longId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Map<String, Double> getSalaryHistoty() {
        return salaryHistoty;
    }

    public void setSalaryHistoty(Map<String, Double> salaryHistoty) {
        this.salaryHistoty = salaryHistoty;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }
}