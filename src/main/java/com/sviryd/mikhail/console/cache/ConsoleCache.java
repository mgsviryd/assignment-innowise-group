package com.sviryd.mikhail.console.cache;

import java.util.HashMap;

public class ConsoleCache {
    private static final HashMap<String, Object> MAP = new HashMap<>();
    public static Object get(String string){
        return MAP.get(string);
    }
    public static Object put(String string, Object object){
        return MAP.put(string,object);
    }
    public static Object remove(String string){
        return MAP.remove(string);
    }
}
