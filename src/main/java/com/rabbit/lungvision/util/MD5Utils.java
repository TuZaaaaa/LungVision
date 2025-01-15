package com.rabbit.lungvision.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String calculateMD5(String input) {
        try {
            // Create an MD5 message digest instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Update the digest with the input bytes
            md.update(input.getBytes());

            // Generate the digest (hash)
            byte[] digest = md.digest();

            // Convert the digest to hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String hash = calculateMD5(input);
        System.out.println("MD5 Hash: " + hash);
    }
}