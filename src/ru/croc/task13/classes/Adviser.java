package ru.croc.task13.classes;

import java.io.*;
import java.util.*;

public class Adviser {
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<String, Double> recommendationMap = new HashMap<>();

    public Adviser(String filmsPath, String watchedPath) throws FileNotFoundException {

        //считываем из файла просмотренные фильмы всех пользователей
        initUsers(watchedPath);

        //создаём нового пользователя, после диалога с пользователем
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input new user's watched films");
        User newUser = new User(scanner.next());

        //инициализируем мапу, в которой лежат пары: просмотренные фильмы + вес для рекомендации
        createRecommendationMap(newUser.getWatchedFilms());

        //ищем рекомендацию
        getRecommendation(filmsPath, newUser.getWatchedFilms());
    }

    private void initUsers(String watchedPath) throws FileNotFoundException {
        File wathced = new File(watchedPath);
        FileReader fileReaderWatched = new FileReader(wathced);
        BufferedReader bufferedReader = new BufferedReader(fileReaderWatched);

        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                User user = new User(line);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createRecommendationMap(TreeSet<String> newUserWatchedFilms) {
        //проходим по всем пользователям и считаем их вес рекомендации
        for (User user : users) {
            Double recommendation = user.getWeight(newUserWatchedFilms);
            TreeSet<String> films = user.getWatchedFilms();
            for (String film : films) {
                if (recommendationMap.get(film) != null) {
                    //в мапе собираем значения суммарных рекомендаций для названия фильма
                    Double newRecommendation = recommendationMap.get(film) + recommendation;
                    recommendationMap.put(film, newRecommendation);
                } else recommendationMap.put(film, recommendation);
            }
        }
    }

    private String getRecommendation(String filmsPath, TreeSet<String> newUserWatchedFilms) throws FileNotFoundException {
        //находим максимальное значение в мапе
        Map.Entry<String, Double> maxEntry = null;
        for (Map.Entry<String, Double> entry : recommendationMap.entrySet()) {
            if ((maxEntry == null || entry.getValue() > maxEntry.getValue())
                    && !newUserWatchedFilms.contains(entry.toString().split("=")[0])) maxEntry = entry;
        }

        //защита от пустой мапы
        if (maxEntry == null) {
            System.out.println("Can't recommend anything");
            return "Can't recommend anything";
        }

        //далее ищем строку фильма с id как у рекомендованного
        String filmId = maxEntry.toString().split("=")[0];

        File films = new File(filmsPath);
        FileReader fileReaderFilms = new FileReader(films);
        BufferedReader bufferedReader = new BufferedReader(fileReaderFilms);

        try {
            String line = bufferedReader.readLine();
            String newId = line.split(",")[0];
            while (!newId.equals(filmId)) {
                line = bufferedReader.readLine();
                newId = line.split(",")[0];
            }
            System.out.println(line.split(",")[1]);
            return line.split(",")[1];
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Something went wrong";
    }
}
