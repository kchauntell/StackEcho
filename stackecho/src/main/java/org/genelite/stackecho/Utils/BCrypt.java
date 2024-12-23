package org.genelite.stackecho.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCrypt {

    public static String hash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, hashedPassword);
    }
}