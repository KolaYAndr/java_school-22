package ru.croc.task14.classes;

import java.util.ArrayList;
import java.util.function.Predicate;

public interface BlackListFilter {

    ArrayList<String> filterComments(Iterable<? super String> comments, Predicate<? super String> filter);
}
