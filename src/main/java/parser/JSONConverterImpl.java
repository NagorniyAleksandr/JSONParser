package parser;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;

/**
 * Created by nagornyyalek on 27.10.2016.
 */
public class JSONConverterImpl implements JSONConverter {

    private static final String NAME_OF_LIST_CLASS = "java.util.List";
    private static final String NAME_OF_MAP_CLASS = "java.util.Map";

    private String beginBlockKeyValueSeparator;
    private String endBlockKeyValueSeparator;

    private String betweenKeyAndValueSeparator;
    private String afterKeyAndValueSeparator;

    public JSONConverterImpl() {
        beginBlockKeyValueSeparator = "{";
        endBlockKeyValueSeparator = "}";
        betweenKeyAndValueSeparator = ":";
        afterKeyAndValueSeparator = ",";
    }

    public JSONConverterImpl(String beginBlockKeyValueSeparator, String endBlockKeyValueSeparator,
                             String betweenKeyAndValueSeparator, String afterKeyAndValueSeparator) {
        this.beginBlockKeyValueSeparator = beginBlockKeyValueSeparator;
        this.endBlockKeyValueSeparator = endBlockKeyValueSeparator;
        this.betweenKeyAndValueSeparator = betweenKeyAndValueSeparator;
        this.afterKeyAndValueSeparator = afterKeyAndValueSeparator;
    }

    public void setBeginBlockKeyValueSeparator(String beginBlockKeyValueSeparator) {
        this.beginBlockKeyValueSeparator = beginBlockKeyValueSeparator;
    }

    public void setEndBlockKeyValueSeparator(String endBlockKeyValueSeparator) {
        this.endBlockKeyValueSeparator = endBlockKeyValueSeparator;
    }

    public void setBetweenKeyAndValueSeparator(String betweenKeyAndValueSeparator) {
        this.betweenKeyAndValueSeparator = betweenKeyAndValueSeparator;
    }

    public void setAfterKeyAndValueSeparator(String afterKeyAndValueSeparator) {
        this.afterKeyAndValueSeparator = afterKeyAndValueSeparator;
    }

    @Override
    public String toJson(Object object) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        Class objClass = object.getClass();

        if (isObjClassPrimitiveButNotChar(objClass) ||
                isObjClassCharOrString(objClass) ||
                objClass.isArray() ||
                isObjClassAsList(objClass) ||
                isObjClassAsMap(objClass)) {

            return convertValueToJson(object);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(beginBlockKeyValueSeparator);
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                sb.append(String.format("\"%s\"%s%s%s",
                        field.getName(), betweenKeyAndValueSeparator,
                        toJson(field.get(object)), afterKeyAndValueSeparator));
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(endBlockKeyValueSeparator);
            return sb.toString();
        }
    }

    @Override
    public <T> T fromJson(String json, Class<T> objectClass) {
        return null;
    }

    private String convertValueToJson(Object variable) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        if (variable == null) return "null";

        Class variableClass = variable.getClass();

        if (isObjClassPrimitiveButNotChar(variableClass)) {
            return String.valueOf(variable);
        } else if (isObjClassCharOrString(variableClass)) {
            return "\"" + variable + "\"";
        } else if (variableClass.isArray()) {
            return convertAsArray(variable);
        } else if (isObjClassAsList(variableClass)) {
            return convertAsList(variable);
        } else if (isObjClassAsMap(variableClass)) {
            return convertAsMap(variable);
        }

        return null;
    }

    private boolean isObjClassPrimitiveButNotChar(Class variableClass) {
        return variableClass == Byte.class ||
                variableClass == Short.class ||
                variableClass == Integer.class ||
                variableClass == Long.class ||
                variableClass == Boolean.class ||
                variableClass == Float.class ||
                variableClass == Double.class ||
                variableClass == int.class;
    }

    private boolean isObjClassCharOrString(Class variableClass) {
        return variableClass == Character.class ||
                variableClass == String.class;
    }

    private boolean isObjClassAsList(Class objClass) {
        Class[] interfaces = objClass.getInterfaces();
        for (int i = 0, size = interfaces.length; i < size; i++) {
            if (interfaces[i].getName().equals(NAME_OF_LIST_CLASS)) {
                return true;
            }
        }
        return false;
    }

    private boolean isObjClassAsMap(Class objClass) {
        Class[] interfaces = objClass.getInterfaces();
        for (int i = 0, size = interfaces.length; i < size; i++) {
            if (interfaces[i].getName().equals(NAME_OF_MAP_CLASS)) {
                return true;
            }
        }
        return false;
    }

    private String convertAsArray(Object array) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        if (array == null) return "null";

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < Array.getLength(array); i++) {
            Class componentClass = array.getClass().getComponentType();
            Object el = Array.get(array, i);

            sb.append(i == 0 ? "" : ",");
            sb.append(toJson(el));
        }
        sb.append("]");
        return sb.toString();
    }

    private String convertAsList(Object list) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        if (list == null) return "null";
        Method toArrayMethod = list.getClass().getMethod("toArray", null);

        return convertAsArray(toArrayMethod.invoke(list, null));
    }

    private String convertAsMap(Object map) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        if (map == null) return "null";

        Method forEachMethod = map.getClass().getMethod("forEach", BiConsumer.class);

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        BiConsumer<Object, Object> biConsumer = ((key, value) -> {
            try {
                sb.append(toJson(key)).append(":").append(toJson(value)).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        forEachMethod.invoke(map, biConsumer);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }
}
