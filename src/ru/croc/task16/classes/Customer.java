package ru.croc.task16.classes;

public record Customer(Coordinate coordinate, ComfortClass comfortClass, String... additions) {
}
