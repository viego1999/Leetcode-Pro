package javaguide.ds.hashmap;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyHashMapMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DefaultMap<String, Integer> map = new MyHashMap<>();
        System.out.println("map is empty? " + map.isEmpty());
        System.out.println("map size = " + map.size());

        System.out.println("put a: " + map.put("a", 1));
        System.out.println("put b: " + map.put("b", 2));
        System.out.println("put c: " + map.put("c", 3));

        System.out.println("a = " + map.get("a"));
        System.out.println("b = " + map.get("b"));
        System.out.println("c = " + map.get("c"));
        System.out.println("d = " + map.get("d"));

        // 反射机制
        Class<MyHashMap> clazz = MyHashMap.class;
        System.out.println("method:");
        for (Method method : clazz.getMethods()) {
            System.out.println(method.getName());
        }

        Method get = clazz.getMethod("get", Object.class);
        System.out.println(get.invoke(map, "a"));

        System.out.println("field:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        System.out.println("constructor:");
        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println(constructor);
        }
    }
}
