package objects_for_test;

import java.util.List;
import java.util.Map;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserWithMapsArrayList extends UserWithMap {

    private List<String> childNames;

    public UserWithMapsArrayList() {
    }

    public UserWithMapsArrayList(int localId, long longId, String name, double salary,
                                 Map<String, Double> salaryHistoty, List<String> childNames) {
        super(localId, longId, name, salary, salaryHistoty);
        this.childNames = childNames;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildNames(List<String> childNames) {
        this.childNames = childNames;
    }
}
