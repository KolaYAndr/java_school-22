package ru.croc.task12;

import ru.croc.task12.classes.TextWatcher;

import java.util.ArrayList;
import java.util.HashSet;

public class Task12 {
    public static void main(String[] args) {
        ArrayList<String> comments = new ArrayList<>();
        comments.add("Wow!");
        comments.add("wow scr");
        comments.add("Oooops");

        HashSet<String> blackList = new HashSet<>();
        blackList.add("Scr");

        TextWatcher tw = new TextWatcher();

        tw.filterCommentsReplacing(comments, blackList);

        for (Object comment : comments) System.out.println(comment);
    }
}
