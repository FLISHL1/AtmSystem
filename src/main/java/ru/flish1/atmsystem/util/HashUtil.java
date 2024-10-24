package ru.flish1.atmsystem.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
public class HashUtil {
    private final MessageDigest hashing;

    public HashUtil(String algorithm) {
        try {
            hashing = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            log.error("Error, Algorithm hashing not found {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String hashText(String text){
        return Base64.getEncoder().encodeToString(hashing.digest(text.getBytes(StandardCharsets.UTF_8)));
    }
}
