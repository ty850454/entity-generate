package com.dreammakerteam.entity.generate.utils;

import java.util.Objects;

public class CaseUtil {
    private CaseUtil() {
    }

    public static String toUpperCamelCase(String name) {
        return toCamelCase(name, true);
    }

    public static String toLowerCamelCase(String name) {
        return toCamelCase(name, false);
    }

    private static String toCamelCase(String name, boolean upperCameCase) {
        // 去掉空格与下划线，紧跟着的下一个字母大写
        char[] chars = name.toCharArray();
        boolean needUpperCase = upperCameCase;
        StringBuilder result = new StringBuilder(chars.length);


        for (char aChar : chars) {
            char c = aChar;
            if (Objects.equals(c, ' ') || Objects.equals(c, '_')) {
                needUpperCase = true;
                continue;
            }

            if (needUpperCase && c >= 'a' && c <= 'z') {
                c -= 32;
                needUpperCase = false;
            }
            result.append(c);
        }

        return result.toString();
    }

    public static String firstLowerCase(String str) {
        char[] chars = str.toCharArray();
        if (chars[0] >= 'A' && chars[0] <= 'Z') {
            chars[0] += 32;
        }
        return new String(chars);
    }

}
