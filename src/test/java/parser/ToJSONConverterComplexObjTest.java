package parser;

import com.google.gson.Gson;
import objects_for_test.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by nagornyyalek on 28.10.2016.
 */
public class ToJSONConverterComplexObjTest {

    private static UserSimple userSimple;
    private static UserWithArray userWithArray;
    private static UserWithList userWithList;
    private static UserWithMap userWithMap;
    private static UserWithMapAndAddress userWithMapAndAddress;
    private static UserWithMapsArrayList userWithMapsArrayList;

    private static JSONConverter myConverter;
    private static Gson gson;

    @BeforeClass
    public static void setUp() throws Exception {

        int localId = 3;
        long longId = 1234;
        String name = "Ivan";
        double salary = 300.5;

        String[] cityLivingArray = {"Kiev", "Kharkiv", "Lviv"};

        List<String> companiesList = new ArrayList<>();
        companiesList.add("EPAM");
        companiesList.add("INCOM");
        companiesList.add("ArtCode");

        Map<String, Double> salaryHistoty = new HashMap<>();
        salaryHistoty.put("march", 350.4);
        salaryHistoty.put("april", 123.0);
        salaryHistoty.put("may", 250.1);

        Address currentAddress = new Address("Kiev", "31/33");

        List<String> childNames = new LinkedList<>();
        childNames.add("Sasha");
        childNames.add("Elena");
        childNames.add("Petro");


        userSimple = new UserSimple(localId, longId, name, salary);
        userWithArray = new UserWithArray(localId, longId, name, salary, cityLivingArray);
        userWithList = new UserWithList(localId, longId, name, salary, companiesList);
        userWithMap = new UserWithMap(localId, longId, name, salary, salaryHistoty);
        userWithMapAndAddress = new UserWithMapAndAddress(localId, longId, name, salary, salaryHistoty, currentAddress);
        userWithMapsArrayList = new UserWithMapsArrayList(localId, longId, name, salary, salaryHistoty, childNames);

        gson = new Gson();
        myConverter = new JSONConverterImpl();
    }

    @Test
    public void toJsonUserSimple() throws Exception {
        assertEquals(gson.toJson(userSimple),
                myConverter.toJson(userSimple));
    }

    @Test
    public void toJsonUserWithArray() throws Exception {
        assertEquals(gson.toJson(userWithArray),
                myConverter.toJson(userWithArray));
    }

    @Test
    public void toJsonUserWithList() throws Exception {
        assertEquals(gson.toJson(userWithList),
                myConverter.toJson(userWithList));
    }

    @Test
    public void toJsonUserWithMap() throws Exception {
        assertEquals(gson.toJson(userWithMap),
                myConverter.toJson(userWithMap));
    }

    @Test
    public void toJsonUserWithMapAndAddress() throws Exception {
        assertEquals(gson.toJson(userWithMapAndAddress),
                myConverter.toJson(userWithMapAndAddress));
    }

    @Test
    public void toJsonUserWithMapsArrayList() throws Exception {
        assertEquals(gson.toJson(userWithMapsArrayList),
                myConverter.toJson(userWithMapsArrayList));
    }
}