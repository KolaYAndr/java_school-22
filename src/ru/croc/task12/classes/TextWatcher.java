package ru.croc.task12.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TextWatcher implements BlackListFilter {

    // метод, удаляющий слова в комментариях по черному листу
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        ArrayList<String> censoredComments = new ArrayList<>();

        for (String comment : comments)
            for (String banWord : blackList)
                if (comment.toLowerCase().contains(banWord.toLowerCase())) { //проверяем на совпадение в нижнем регистре
                    String newComment = comment.replace(banWord.toLowerCase(), "****");
                    censoredComments.add(newComment);
                    comments.remove(comment);
                }


        comments.addAll(censoredComments);
    }
}
