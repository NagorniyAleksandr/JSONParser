package parser;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by nagornyyalek on 27.10.2016.
 */
public interface JSONConverter {

    String toJson(Object object) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;

    <T> T fromJson(String json, Class<T> objectClass);

}
