package src.ru.croc.task5;

import src.ru.croc.task5.classpackage.Annotation;
import src.ru.croc.task5.classpackage.Circle;
import src.ru.croc.task5.classpackage.Rectangle;

public class Task5 {
    public static void main(String[] args) {
        //создаём фигуры и передаём их в аннотации
        Rectangle rec = new Rectangle(0, 0, 1, 1);
        Annotation ann1 = new Annotation(rec, "Signa");
        Circle cir = new Circle(0, 0, 3);
        Annotation ann2 = new Annotation(cir, "Sign");

        //выводим в консоль
        System.out.println(ann1.pointIsInside(1, 0));
        System.out.println(ann2.pointIsInside(0, 3));
    }
}
