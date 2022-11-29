package ru.croc.task13;

import ru.croc.task13.classes.Adviser;

import java.io.FileNotFoundException;

public class Task13 {
    private static final String FILMS_PATH = "C:/Users/kolay/IdeaProjects/java_school-22/src/ru/croc/task13/container/films.txt";
    private static final String WATCHED_PATH = "C:/Users/kolay/IdeaProjects/java_school-22/src/ru/croc/task13/container/watched.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Adviser ad = new Adviser(FILMS_PATH, WATCHED_PATH);
    }
}