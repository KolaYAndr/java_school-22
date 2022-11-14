package ru.croc.task3;

import java.util.Scanner;

public class Task3 {

    //вспомогательный класс для задания координат вершин
    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point p) {
            return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        Point a = new Point(x, y);

        x = scanner.nextDouble();
        y = scanner.nextDouble();

        Point b = new Point(x, y);

        x = scanner.nextDouble();
        y = scanner.nextDouble();

        Point c = new Point(x, y);

        System.out.println(triangleArea(a, b, c));
    }

    static double triangleArea(Point a, Point b, Point c) {
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ca = c.distanceTo(a);
        double hp = (ab + bc + ca) / 2;

        return Math.sqrt(hp * (hp - ab) * (hp - bc) * (hp - ca));
    }
}