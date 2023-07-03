Задача 4
Предположим, вы принимаете участие в разработке небольшого приложения по аннотированию (разметке) изображений с целью последующего использования этой разметки для обучения моделей computer vision. В этом приложении пользователь может выделять области на изображении с помощью прямоугольников и окружностей и подписывать их произвольным текстом.

Вся разметка для изображения представляется массивом Annotation[].



В приложении определен класс аннотированного изображения:

class AnnotatedImage {

   private final String imagePath;

   private final Annotation[] annotations;



   public AnnotatedImage(String imagePath, Annotation... annotations) {
       this.imagePath = imagePath;
       this.annotations = annotations;
   }

   public String getImagePath() {
       return this.imagePath;
   }

   public Annotation[] getAnnotations() {
       return this.annotations;
   }
}


Определите класс Annotation для представления данных разметки (данные: подпись и фигура) и классы Figure, Rectangle, Circle для задания размеченных областей.

Прямоугольники определяются координатами левого нижнего и правого верхнего углов, а окружности - координатами центра и радиусом.

Переопределите метод toString класса Annotation так, чтобы в результат выводилась информация о полях и вложенных объектах. Формат вывода:



Окружность:

“Circle (<X0>, <Y0>), <R>: <Подпись>”

Прямоугольник:

“Rectangle (<X1>, <Y1>), (<X2>, <Y2>): <Подпись>”

Например:

Circle (100, 100), 10: Tree
Rectangle (100, 100), (150, 200): Car
