package src.ru.croc.task4;

import src.ru.croc.task4.classpackage.Annotation;
import src.ru.croc.task4.classpackage.Circle;
import src.ru.croc.task4.classpackage.Rectangle;

public class Task4 {

    /*Задача 4
    Предположим, вы принимаете участие в разработке небольшого приложения по аннотированию (разметке) изображений с
    целью последующего использования этой разметки для обучения моделей computer vision.
    В этом приложении пользователь может выделять области на изображении с помощью прямоугольников и окружностей
    и подписывать их произвольным текстом.

    Вся разметка для изображения представляется массивом Annotation[].*/

    public static void main(String[] args) {
        //создаём фигуры и передаём их в аннотации
        Rectangle rec = new Rectangle(0, 0, 1, 1);
        Annotation ann1 = new Annotation(rec, "Signa");
        Circle cir = new Circle(0, 0, 3);
        Annotation ann2 = new Annotation(cir, "Sign");


        //выводим в консоль
        System.out.println(ann1);
        System.out.println(ann2);
    }
}