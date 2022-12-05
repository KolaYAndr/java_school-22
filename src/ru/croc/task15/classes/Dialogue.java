package ru.croc.task15.classes;

import java.util.*;

public class Dialogue {
    private ArrayList<AgeGroup> ageGroups = new ArrayList<>();

    public void start(){
        Scanner scanner = new Scanner(System.in);

        String[] ages = getAgesLine(scanner).split(" ");

        ArrayList<Person> persons = getPersons(scanner);
        Collections.sort(persons);

        extractAgeGroups(ages);

        fillAgeGroups(persons);

        outputAgeGroups();
    }

    private void fillAgeGroups(ArrayList<Person> persons) {
        for (AgeGroup ageGroup: ageGroups) {
            for (int i = persons.size() - 1; i >= 0; i--){
                ageGroup.addIfFits(persons.get(i));
            }
        }
    }

    private void outputAgeGroups(){
        for (int i = ageGroups.size() - 1; i >= 0; i--) {
            if (ageGroups.get(i) == null) continue;
            System.out.println(ageGroups.get(i));
        }
    }

    private void extractAgeGroups(String[] ages) {
        int lastAgeIndex = ages.length;
        ageGroups.add(new AgeGroup(0, Integer.parseInt(ages[0])));
        for(int i = 1; i < lastAgeIndex; i++){
            ageGroups.add(new AgeGroup(Integer.parseInt(ages[i-1]), Integer.parseInt(ages[i])));
        }
        ageGroups.add(new AgeGroup(Integer.parseInt(ages[lastAgeIndex - 1]), Integer.MAX_VALUE));
    }

    private static String getAgesLine(Scanner scanner) {
        System.out.println("Input age groups");
        return scanner.nextLine();
    }

    private ArrayList<Person> getPersons(Scanner scanner){
        System.out.println("Input persons /*to stop input END*/");
        String line = scanner.nextLine();
        ArrayList<Person> personArrayList = new ArrayList<>();

        while (!Objects.equals(line, "END")){
            personArrayList.add(new Person(line));
            line = scanner.nextLine();
        }

        return personArrayList;
    }
}
