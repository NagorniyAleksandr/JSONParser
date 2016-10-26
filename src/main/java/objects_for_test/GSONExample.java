package objects_for_test;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nagornyyalek on 26.10.2016.
 */
public class GSONExample {

    public static void main(String[] args) {

        String str = "Ivan";

        int integer = 3;

        double dobl = 3.5;
        char ch = 'c';

        int[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"ivan", "q", "7", ""};

        List<Integer> intList = new ArrayList<>();
        intList.add(22);
        intList.add(11);
        intList.add(44);
        intList.add(00);

        List<String> stringList = new ArrayList<>();
        stringList.add("Ivan");
        stringList.add("Petro");
        stringList.add("");
        stringList.add("12");

        Map<String, Integer> intHashMap = new HashMap<>();
        intHashMap.put("key1", 11);
        intHashMap.put("key2", 21);
        intHashMap.put("key3", 33);

        Map<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("key1", "value1");
        stringHashMap.put("key2", "value2");
        stringHashMap.put("key3", "value3");


        Gson gson = new Gson();

        System.out.println("int: " + gson.toJson(integer));
        System.out.println("double: " + gson.toJson(dobl));
        System.out.println("char: " + gson.toJson(ch));
        System.out.println("String: " + gson.toJson(str));
        System.out.println("intArray: " + gson.toJson(intArray));
        System.out.println("stringArray: " + gson.toJson(stringArray));
        System.out.println("intList: " + gson.toJson(intList));
        System.out.println("stringList: " + gson.toJson(stringList));
        System.out.println("intHashMap<String, String>: " + gson.toJson(intHashMap));
        System.out.println("stringHashMap<String, String>: " + gson.toJson(stringHashMap));

        /*

        int: 3
        double: 3.5
        char: "c"
        String: "Ivan"
        intArray: [1,2,3,4]
        stringArray: ["ivan","q","7",""]
        intList: [22,11,44,0]
        stringList: ["Ivan","Petro","","12"]
        intHashMap<String, String>: {"key1":11,"key2":21,"key3":33}
        stringHashMap<String, String>: {"key1":"value1","key2":"value2","key3":"value3"}

        */

    }
}
