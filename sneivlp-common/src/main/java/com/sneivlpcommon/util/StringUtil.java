package com.sneivlpcommon.util;

public class StringUtil {

    private StringUtil(){}

    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
