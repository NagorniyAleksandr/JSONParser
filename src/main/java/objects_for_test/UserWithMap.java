package objects_for_test;

import java.util.Map;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserWithMap extends UserSimple {

    private Map<String, Double> salaryHistoty;

    public UserWithMap() {
    }

    public UserWithMap(int localId, long longId, String name, double salary, Map<String, Double> salaryHistoty) {
        super(localId, longId, name, salary);
        this.salaryHistoty = salaryHistoty;
    }

    public Map<String, Double> getSalaryHistoty() {
        return salaryHistoty;
    }

    public void setSalaryHistoty(Map<String, Double> salaryHistoty) {
        this.salaryHistoty = salaryHistoty;
    }
}
