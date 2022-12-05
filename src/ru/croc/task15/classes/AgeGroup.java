package ru.croc.task15.classes;

import java.util.ArrayList;

public class AgeGroup {
    private final int from;
    private final int to;


    private ArrayList<Person> groupMates = new ArrayList<>();

    public AgeGroup(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public void addIfFits(Person person) {
        int personsAge = person.getAge();
        if (personsAge <= to & personsAge > from) groupMates.add(person);
    }

    @Override
    public String toString() {
        if (!groupMates.isEmpty()) {
            if (to != Integer.MAX_VALUE) return (from + 1) + " - " + to + ": " + groupMatesOutput(groupMates);
            else return (from + 1) + "+: " + groupMatesOutput(groupMates);
        } else return null;
    }

    private String groupMatesOutput(ArrayList<Person> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).toString());
            if (i != list.size() - 1) stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
