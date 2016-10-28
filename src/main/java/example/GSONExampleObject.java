package example;

import com.google.gson.Gson;
import objects_for_test.*;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by nagornyyalek on 27.10.2016.
 */
public class GSONExampleObject {

    public static void main(String[] args) {

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


        UserSimple userSimple = new UserSimple(localId, longId, name, salary);
        UserWithArray userWithArray = new UserWithArray(localId, longId, name, salary, cityLivingArray);
        UserWithList userWithList = new UserWithList(localId, longId, name, salary, companiesList);
        UserWithMap userWithMap = new UserWithMap(localId, longId, name, salary, salaryHistoty);
        UserWithMapAndAddress userWithMapAndAddress = new UserWithMapAndAddress(localId, longId, name, salary, salaryHistoty, currentAddress);
        UserWithMapsArrayList userWithMapsArrayList = new UserWithMapsArrayList(localId, longId, name, salary, salaryHistoty, childNames);

        Gson gson = new Gson();

        System.out.printf("userType: %s, example: %s\n", "UserSimple", gson.toJson(userSimple));
        System.out.printf("userType: %s, example: %s\n", "UserWithArray", gson.toJson(userWithArray));
        System.out.printf("userType: %s, example: %s\n", "UserWithList", gson.toJson(userWithList));
        System.out.printf("userType: %s, example: %s\n", "UserWithMap", gson.toJson(userWithMap));
        System.out.printf("userType: %s, example: %s\n", "UserWithMapAndAddress", gson.toJson(userWithMapAndAddress));
        System.out.printf("userType: %s, example: %s\n", "UserWithMapsArrayList", gson.toJson(userWithMapsArrayList));

        /*
        userType: UserSimple, example: {"localId":3,"longId":1234,"name":"Ivan","salary":300.5}
        userType: UserWithArray, example: {"localId":3,"longId":1234,"name":"Ivan","salary":300.5,"cityLivingArray":["Kiev","Kharkiv","Lviv"]}
        userType: UserWithList, example: {"localId":3,"longId":1234,"name":"Ivan","salary":300.5,"companiesList":["EPAM","INCOM","ArtCode"]}
        userType: UserWithMap, example: {"localId":3,"longId":1234,"name":"Ivan","salary":300.5,"salaryHistoty":{"may":250.1,"april":123.0,"march":350.4}}
        userType: UserWithMapAndAddress, example: {"localId":3,"longId":1234,"name":"Ivan","salary":300.5,"salaryHistoty":{"may":250.1,"april":123.0,"march":350.4},"currentAddress":{"city":"Kiev","buildingNumber":"31/33"}}
        userType: UserWithMapsArrayList, example: {"localId":3,"longId":1234,"name":"Ivan","salary":300.5,"salaryHistoty":{"may":250.1,"april":123.0,"march":350.4},"childNames":["Sasha","Elena","Petro"]}
        */

    }

}
