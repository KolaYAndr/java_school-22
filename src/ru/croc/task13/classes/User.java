package ru.croc.task13.classes;

import java.util.Collections;
import java.util.SortedSet;

public class User {
    private SortedSet watchedFilms;

    public User(String films){

    }


    private double getWieght(SortedSet anotherUserWatchedFimls) {
        int currentUserSize = watchedFilms.size();
        int originUserSize = anotherUserWatchedFimls.size();
        if (currentUserSize < originUserSize) return 0.0;

        int counter = 0;
        for (Object filmId : anotherUserWatchedFimls) {
            if (watchedFilms.contains(filmId)) counter++;
        }

        return (double) counter / originUserSize;
    }
}
