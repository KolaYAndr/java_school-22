Задача 18
Вы продолжаете разработку бэкенда интернет-магазина. Уже спроектирована схема данных и есть первичное наполнение, следующим шагом вы решаете разработать DAO-класс для работы с базой данных заказов. Для этого вы добавляете в приложение классы сущностей заказа (Order) и товара (Product) и определяетесь с составом необходимых методов DAO-класса:

Product findProduct(String productCode);
Поиск в базе данных товара с указанным артикулом. Если соответствующего товара в базе данных нет, метод возвращает null.

Product createProduct(Product product);
Создание нового товара. Если в базе данных существует товар с переданным артикулом, метод выбрасывает исключение.

Product updateProduct(Product product);
Изменение информации о товаре. Название и цена товара в базе данных заменяется на значения, указанные в полях параметра product. Артикул товара, данные которого должны быть изменены, также задается полем объекта product.

void deleteProduct(String productCode);
Удаление товара и всех упоминаний о нем в заказах. Вас смущает необходимость изменения уже выданных заказов, но заказчик настаивает.

Order createOrder(String userLogin, List<Product> products);
Создание заказа. Для указанного пользователя в базе данных создается новый заказ с заданным списком товаров.

Не забудьте протестировать собственное решение (любым способом, можно просто вызывать требуемые методы из main-метода с произвольными параметрами.
Реализуйте программу с указанными операциями.
