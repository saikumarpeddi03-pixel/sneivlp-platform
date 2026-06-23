package com.sneivlpcommon.validation;

public final class MobileValidator {

    private MobileValidator(){}

    public static boolean isValid(String mobile) {

        return mobile != null
                && mobile.matches("^[6-9]\\d{9}$");
    }
}
