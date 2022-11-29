package ru.croc.task13.classes;

import java.util.Arrays;
import java.util.TreeSet;

public class User {

    //поле, в котором храним просмотренные пользователем фильмы
    //я решил использовать TreeSet потому, что он отсортирован и исключает повторения
    private TreeSet<String> watchedFilms;

    public User(String films){
        String[] dividedStrings = films.split(",");
        watchedFilms = new TreeSet<>(Arrays.asList(dividedStrings));
    }


    //метод, который возвращает вес рекомендации пользователя
    double getWeight(TreeSet<String> anotherUserWatchedFilms) {
        int currentUserSize = watchedFilms.size();
        int originUserSize = anotherUserWatchedFilms.size();
        if (currentUserSize < originUserSize) return 0.0;

        int counter = 0;
        for (String filmId : anotherUserWatchedFilms) {
            if (watchedFilms.contains(filmId)) counter++;
        }

        if ((double) counter / originUserSize < 0.5) return 0.0;
        else return (double) counter / originUserSize;
    }


    public TreeSet<String> getWatchedFilms() {
        return watchedFilms;
    }
}
