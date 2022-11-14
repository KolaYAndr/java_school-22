package src.ru.croc.task4.classpackage;

public class Annotation {
    //определили поля
    private final Figure figure;
    private  String signature;

    //создали коструктор
    public Annotation(Figure fig, String sign){
        this.figure = fig;
        this.signature = sign;
    }

    public String getSignature() {
        return signature;
    }

    //переопределил метод
    @Override
    public String toString() {
        return figure.toString() + getSignature();
    }
}