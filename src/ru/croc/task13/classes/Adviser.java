package ru.croc.task13.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Adviser {
    private ArrayList<User> users;

    public Adviser(String filmsPath, String watchedPath) throws FileNotFoundException {
        File films = new File(filmsPath);
        File wathced = new File(watchedPath);
    }
}
