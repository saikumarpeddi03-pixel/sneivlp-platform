package com.sneivlpcommon.validation;

public final class AadhaarValidator {

    private AadhaarValidator(){}

    public static boolean isValid(String aadhaar) {

        return aadhaar != null
                && aadhaar.matches("\\d{12}");
    }
}
