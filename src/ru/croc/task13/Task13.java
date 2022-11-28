package ru.croc.task13;

import java.io.FileInputStream;
import java.io.IOException;

public class Task13 {
    private static final String WATCHED_PATH = "C:/Users/kolay/IdeaProjects/java_school-22/src/ru/croc/task13/container/watched.txt";
    private static final String FILMS_PATH = "C:/Users/kolay/IdeaProjects/java_school-22/src/ru/croc/task13/container/films.txt";
    public static void main(String[] args) {
        try {
            FileInputStream films = new FileInputStream(FILMS_PATH);
            FileInputStream watched = new FileInputStream(WATCHED_PATH);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}