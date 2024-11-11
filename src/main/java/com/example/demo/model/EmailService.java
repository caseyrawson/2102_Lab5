package com.example.demo.model;

public class EmailService {
    public static boolean isValid(String email) {
        return email.contains("@") && email.contains(".");
    }
}