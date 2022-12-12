package ru.croc.task14;

import ru.croc.task14.classes.BlackListFilter;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Task14 {
    public static void main(String[] args) {
        ArrayList<String> comments = new ArrayList<>();
        comments.add("Wow!");
        comments.add("wow scr");
        comments.add("Oooops");

        Predicate<String> filter = s -> s.toLowerCase().contains("scr");
        BlackListFilter<String> blackListFilter = new BlackListFilter<>() {};

        ArrayList<String> pureComments = blackListFilter.filterComments(comments, filter);

        for (String pureComment: pureComments) {
            System.out.println(pureComment);
        }
    }
}
