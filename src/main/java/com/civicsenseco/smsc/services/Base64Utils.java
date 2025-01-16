package com.civicsenseco.smsc.services;

import java.util.Base64;

public class Base64Utils {


    // Method to encode a string
    public static String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    // Method to decode a Base64-encoded string
    public static String decodeFromBase64(String encoded) {
        return new String(Base64.getDecoder().decode(encoded));
    }
}
