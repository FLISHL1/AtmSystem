package ru.flish1.atmsystem.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServiceHashing {
    private static final String ALGORITHM = "MD5";
    private static final MessageDigest hashing;

    static {
        try {
            hashing = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error, Algorithm hashing not found");
            System.exit(1);
            throw new RuntimeException(e);
        }
    }

    public static byte[] hashText(String text){
        return hashing.digest(text.getBytes());
    }
}
