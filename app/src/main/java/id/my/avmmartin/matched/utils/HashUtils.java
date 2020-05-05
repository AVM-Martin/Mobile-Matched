package id.my.avmmartin.matched.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    public static String sha512(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] message = messageDigest.digest(string.getBytes());

            BigInteger hashValue = new BigInteger(1, message);

            StringBuilder result = new StringBuilder(hashValue.toString(16));
            while (result.length() < 32) {
                result.insert(0, "0");
            }

            return result.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private HashUtils() {
        // none
    }
}
