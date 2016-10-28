package objects_for_test;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserWithArray {

    private int localId;
    private long longId;
    private String name;
    private double salary;
    private String[] cityLivingArray;

    public UserWithArray() {
    }

    public UserWithArray(int localId, long longId, String name, double salary, String[] cityLivingArray) {
        this.localId = localId;
        this.longId = longId;
        this.name = name;
        this.salary = salary;
        this.cityLivingArray = cityLivingArray;
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

    public String[] getCityLivingArray() {
        return cityLivingArray;
    }

    public void setCityLivingArray(String[] cityLivingArray) {
        this.cityLivingArray = cityLivingArray;
    }
}

