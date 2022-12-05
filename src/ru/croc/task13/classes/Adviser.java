package ru.croc.task13.classes;

import java.io.*;
import java.util.*;

public class Adviser {
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<String, Double> recommendationMap = new HashMap<>();

    public Adviser(String filmsPath, String watchedPath) throws FileNotFoundException{

        //считываем из файла просмотренные фильмы всех пользователей
        initUsers(watchedPath);

        //создаём нового пользователя, после диалога с пользователем
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input new user's watched films");
        User newUser = new User(scanner.next());

        //инициализируем мапу, в которой лежат пары: просмотренные фильмы + вес для рекомендации
        createRecommendationMap(newUser.getWatchedFilms());

        getRecommendation(filmsPath);
    }

    private void initUsers(String watchedPath) throws FileNotFoundException{
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
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createRecommendationMap(TreeSet<String> newUserWatchedFilms){
        for (User user: users) {
            Double recommendation = user.getWeight(newUserWatchedFilms);
            TreeSet<String> films = user.getWatchedFilms();

            for(String film : films){
                Double newRecommendation = recommendationMap.get(film) + recommendation;
                recommendationMap.put(film, newRecommendation);
            }
        }
    }

    private String getRecommendation(String filmsPath) throws FileNotFoundException{
        File films = new File(filmsPath);
        FileReader fileReaderFilms = new FileReader(films);
        BufferedReader bufferedReader = new BufferedReader(fileReaderFilms);
        //найти максимальное значение в мапе
        //пробежаться по мапе и смотреть на совпадение строки считанной в br и ключа мапы с максимальным значением
        //вернуть строку с названием фильма
        return null;
    }
}
