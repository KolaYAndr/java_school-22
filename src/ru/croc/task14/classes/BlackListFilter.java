package ru.croc.task14.classes;

import java.util.ArrayList;
import java.util.function.Predicate;

public interface BlackListFilter<T> {

    default ArrayList<T> filterComments(Iterable<T> comments, Predicate<T> filter){
        ArrayList<T> filtered = new ArrayList<>();

        for (T comment: comments) {
            if (!filter.test(comment)) filtered.add(comment);
        }

        return filtered;
    }
}
