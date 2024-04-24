package ru.maksmusic.service;

public class GenerateID {
    private static Long id;

    public static Long getId() {
        id++;
        return id;
    }
}
