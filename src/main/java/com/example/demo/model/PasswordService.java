package com.example.demo.model;

public class PasswordService {
    public static boolean isValid(String password) {
        return password.length() > 8 && password.matches(".*\\d.*");
    }
}