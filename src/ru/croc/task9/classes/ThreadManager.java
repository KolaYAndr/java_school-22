package ru.croc.task9.classes;

import java.util.ArrayList;

public class ThreadManager {
    private static final int range = 'z' - 'a'; //разброс по значению char'ов
    private final int step; // шаг, с которым будем запускать Runner'ов
    private final int amount; //количество потоков


    public ThreadManager(int amount, String hashCode, int length) {
        this.amount = amount;
        this.step = range / amount;

        processThreads(length, hashCode);
    }

    private void processThreads(int length, String hashCode) {
        //создаём список, в котором будем хранить потоки, чтобы потом их запустить
        ArrayList<Thread> threads = new ArrayList<>(amount);

        //конструируем начальные и конечные строки для Runner'ов
        for (int i = 0; i < amount; i++){
            char toAddToStart = (char) (step * i + 'a'); //char, что добавляем к старту
            char toAddToEnd = (char) (step * (i + 1) + 'a'); //char, что добавляем к концу
            StringBuilder startPoint = new StringBuilder();
            StringBuilder endPoint = new StringBuilder();
            //добавляем char'ы к концу и к началу
            for(int l = 0; l < length; l++){
                startPoint.append(toAddToStart);
                endPoint.append(toAddToEnd);
            }
            //создаём поток и добавляем его в список
            Thread t = new Thread(new Runner(startPoint.toString(), endPoint.toString(), hashCode));
            threads.add(t);
        }
        //запускаем все потоки
        for (Thread t: threads) {
            t.start();
        }
    }
}
