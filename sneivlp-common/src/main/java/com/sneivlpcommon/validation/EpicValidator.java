package com.sneivlpcommon.validation;

public final class EpicValidator {

    private EpicValidator(){}

    public static boolean isValid(String epicNo) {

        return epicNo != null
                && epicNo.matches("^[A-Z]{3}[0-9]{7}$");
    }
}
