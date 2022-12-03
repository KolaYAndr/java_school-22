package ru.croc.task15.classes;

public class Person implements Comparable<Person> {
    private String fullName;
    private int age;

    public Person(String person){
        String[] divided = person.split(", ");
        this.fullName = divided[0];
        this.age = Integer.parseInt(divided[1]);
    }

    @Override
    public String toString() {
        return fullName + " (" + age + ")";
    }

    @Override
    public int compareTo(Person o) {
        if (this.age == o.age) return this.fullName.compareTo(o.fullName);
        if (this.age > o.age) return 1;
        else return -1;
    }

    public int getAge() {
        return age;
    }
}
