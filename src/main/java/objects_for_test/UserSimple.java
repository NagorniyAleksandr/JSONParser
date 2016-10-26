package objects_for_test;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserSimple {

    private int localId;
    private long longId;
    private String name;
    private double salary;

    public UserSimple() {
    }

    public UserSimple(int localId, long longId, String name, double salary) {
        this.localId = localId;
        this.longId = longId;
        this.name = name;
        this.salary = salary;
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
}
