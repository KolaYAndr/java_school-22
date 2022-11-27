package ru.croc.task12.classes;

import java.util.List;
import java.util.Set;

public interface BlackListFilter {

    /**
     * From the given list of comments replacing ones
     * that contain words from the black list to ****.
     *
     * @param comments list of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    void filterComments(List<String> comments, Set<String> blackList);
}
