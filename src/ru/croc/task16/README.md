Задача 16
Ваша команда разрабатывает приложение службы такси. Вы работаете над модулем подбора водителя. При этом модуль вы реализуете в виде отдельного Java-приложения, работающего со стандартными потоками ввода-вывода. На вход (System.in) оно принимает координаты клиента, класс комфорта и список особых пожеланий в текстовом виде, на выходе (System.out) выдает идентификатор ближайшего водителя на подходящем авто.

В качестве входных данных приложению указывается следующая последовательность: координаты в формате <Широта, долгота>, класс комфорта, список особых пожеланий.

Компаратор для сортировки реализуйте в виде лямбды.
Особые пожелания — конечный набор значений.
Пример
59.9386, 30.3141
Комфорт
Детское кресло

Выходные данные представлены как идентификатор водителя:

U-SnezhanaDenisovna-79995553535

При этом:

Класс автомобиля соответствует заявленному
Авто подходит под особые пожелания клиента
Расстояние до клиента - наименьшее среди водителей, подходящих под требования

