package objects_for_test;

import java.util.List;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class UserWithList extends UserSimple{

    private List<String> companiesList;

    public UserWithList() {
    }

    public UserWithList(int localId, long longId, String name, double salary, List<String> companiesList) {
        super(localId, longId, name, salary);
        this.companiesList = companiesList;
    }

    public List<String> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(List<String> companiesList) {
        this.companiesList = companiesList;
    }
}
