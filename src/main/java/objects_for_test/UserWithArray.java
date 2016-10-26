package objects_for_test;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserWithArray extends UserSimple {

    private String[] cityLivingArray;

    public UserWithArray() {
    }

    public UserWithArray(int localId, long longId, String name, double salary, String[] cityLivingArray) {
        super(localId, longId, name, salary);
        this.cityLivingArray = cityLivingArray;
    }

    public String[] getCityLivingArray() {
        return cityLivingArray;
    }

    public void setCityLivingArray(String[] cityLivingArray) {
        this.cityLivingArray = cityLivingArray;
    }
}
