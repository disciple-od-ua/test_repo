package com.company.newpackage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apeshkov on 29.10.2015.
 */
public class StringUtility {

    public static void main(String[] args) {
        System.out.println(areIsomorfic("abd", "bcd"));
        System.out.println(areIsomorfic("egg", "add"));
        System.out.println(areIsomorfic("foo", "bar"));
        System.out.println(areIsomorfic("afgth", "ddegy"));
        System.out.println(areIsomorfic("ddegy", "afgth"));
    }

    public static boolean areIsomorfic(String s1, String s2) {

        Map<Character, Character> mapping = new HashMap<>();

        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            Character c = getKey(mapping, c2);
            if (c != null && c != c1) {
                return false;
            } else if (mapping.containsKey(c1)) {
                if (mapping.get(c1) != c2) {
                    return false;
                }
            } else {
                mapping.put(c1, c2);
            }
        }
        return true;
    }

    private static Character getKey(Map<Character, Character> map, Character value) {
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
