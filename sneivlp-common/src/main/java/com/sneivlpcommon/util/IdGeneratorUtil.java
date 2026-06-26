package com.sneivlpcommon.util;

import java.util.UUID;

public final class IdGeneratorUtil {

    private IdGeneratorUtil(){}

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateCitizenId() {

        return "CIT-" + System.currentTimeMillis();
    }
}
