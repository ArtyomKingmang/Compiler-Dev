# Query Interpreter
Реализовать интерпретатор простой системы обработки данных, 
которая работает с csv-файлами.

Методы для реализации:

> Важно! Вместе с самими методами описана их сигнатура и примерная реализация. Полностью повторять ее не обязательно

`read(filename)` - Читает файл CSV, извлекает заголовки и создает поток объектов Row (Его вы должны определить сами) для каждой последующей строки.

`selectFields(row,  keys)` - Извлекает значения из строки Row в соответствии со списком ключей (keys)

`print(parent)`- Печатает каждую строку в потоке, соединяя значения через пробел.

`Filter(pred, parent)` - Фильтрует строки в потоке на основе заданного предиката (pred).

`Eq(x, y)` - Возвращает предикат, который проверяет равенство значений, полученных из двух функций.

`Ne(x, y)` - Возвращает предикат, который проверяет неравенство значений.

`Value(x)` - Возвращает функцию, которая всегда возвращает заданное значение x.

`Field(x)` - Возвращает функцию, которая извлекает значение из поля строки на основе имени поля x

`Project(newSchema, parentSchema, parent)` - Создает новый поток строк с новой схемой на основе существующего потока и схемы.

`Join(left, right)` - Объединяет два потока строк по общим полям. Для каждой строки из левого потока ищется соответствующая строка из правого потока, и если они совпадают по ключам, создается новая строка с объединенными полями