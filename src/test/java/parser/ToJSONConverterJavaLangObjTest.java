package parser;

import com.google.gson.Gson;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by nagornyyalek on 27.10.2016.
 */
public class ToJSONConverterJavaLangObjTest {

    private static String str;
    private static int integer;
    private static double dobl;
    private static char ch;

    private static int[] intArray;
    private static String[] stringArray;

    private static List<Integer> intList;
    private static List<String> stringList;

    private static Map<String, Integer> intHashMap;
    private static Map<String, String> stringHashMap;

    private static JSONConverter myConverter;
    private static Gson gson;

    @BeforeClass
    public static void setUp() throws Exception {

        str = "Ivan";

        integer = 3;

        dobl = 3.5;
        ch = 'c';

        intArray = new int[]{1, 2, 3, 4};
        stringArray = new String[]{"ivan", "q", "7", ""};

        intList = new ArrayList<>();
        intList.add(22);
        intList.add(11);
        intList.add(44);
        intList.add(55);

        stringList = new ArrayList<>();
        stringList.add("Ivan");
        stringList.add("Petro");
        stringList.add("");
        stringList.add("12");

        intHashMap = new HashMap<>();
        intHashMap.put("key1", 11);
        intHashMap.put("key2", 21);
        intHashMap.put("key3", 33);

        stringHashMap = new HashMap<>();
        stringHashMap.put("key1", "value1");
        stringHashMap.put("key2", "value2");
        stringHashMap.put("key3", "value3");

        gson = new Gson();
        myConverter = new JSONConverterImpl();
    }

    @Test
    public void toJsonInteger() throws Exception {
        assertEquals(gson.toJson(integer), myConverter.toJson(integer));
    }

    @Test
    public void toJsonDouble() throws Exception {
        assertEquals(gson.toJson(dobl), myConverter.toJson(dobl));
    }

    @Test
    public void toJsonString() throws Exception {
        assertEquals(gson.toJson(str), myConverter.toJson(str));
    }

    @Test
    public void toJsonIntegerArray() throws Exception {
        assertEquals(gson.toJson(intArray), myConverter.toJson(intArray));
    }

    @Test
    public void toJsonStringArray() throws Exception {
        assertEquals(gson.toJson(stringArray), myConverter.toJson(stringArray));
    }

    @Test
    public void toJsonIntegerArrayList() throws Exception {
        assertEquals(gson.toJson(intList), myConverter.toJson(intList));
    }

    @Test
    public void toJsonStringArrayList() throws Exception {
        assertEquals(gson.toJson(stringList), myConverter.toJson(stringList));
    }

    @Test
    public void toJsonIntegerHashMap() throws Exception {
        assertEquals(gson.toJson(intHashMap), myConverter.toJson(intHashMap));
    }

    @Test
    public void toJsonStringHashMap() throws Exception {
        assertEquals(gson.toJson(stringHashMap), myConverter.toJson(stringHashMap));
    }
}