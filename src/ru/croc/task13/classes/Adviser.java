package ru.croc.task13.classes;

import java.io.*;
import java.util.*;

public class Adviser {
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<TreeSet<String>, Double> usersFilmsWithWeight = new HashMap<>();

    public Adviser(String filmsPath, String watchedPath) throws FileNotFoundException{
        File films = new File(filmsPath);

        //считываем из файла просмотренные фильмы всех пользователей
        initUsers(watchedPath);

        //создаём нового пользователя, после диалога с пользователем
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input new user's watched films");
        User newUser = new User(scanner.next());

        //инициализируем мапу, в которой лежат пары: просмотренные фильмы + вес для рекомендации
        createMapWithUsersFilmsAndWeights(newUser.getWatchedFilms());
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

    private void createMapWithUsersFilmsAndWeights(TreeSet<String> newUserWatchedFilms){
        for (User user: users) {
            usersFilmsWithWeight.put(user.getWatchedFilms(), user.getWeight(newUserWatchedFilms));
        }
    }

    private void getRecommendation(){

    }
}
