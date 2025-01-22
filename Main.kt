import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    try {
        // 1. Функция для нахождения максимума
        println(findMax(5, 10)) // 10
        println(findMax(5, 5)) // Исключение
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        // 2. Калькулятор деления
        println(divide(10, 2)) // 5.0
        println(divide(10, 0)) // Исключение
    } catch (e: ArithmeticException) {
        println(e.message)
    }

    try {
        // 3. Конвертер строк в числа
        println(stringToInt("123")) // 123
        println(stringToInt("abc")) // Исключение
    } catch (e: NumberFormatException) {
        println(e.message)
    }

    try {
        // 4. Проверка возраста
        checkAge(25) // Ничего не происходит
        checkAge(151) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 5. Нахождение корня
        println(sqrt(16)) // 4.0
        println(sqrt(-1)) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 6. Факториал
        println(factorial(5)) // 120
        println(factorial(-1)) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 7. Проверка массива на нули
        checkArrayForZeros(intArrayOf(1, 2, 3)) // Ничего не происходит
        checkArrayForZeros(intArrayOf(1, 0, 3)) // Исключение
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        // 8. Калькулятор возведения в степень
        println(power(2, 3)) // 8
        println(power(2, -1)) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 9. Обрезка строки
        println(truncateString("Hello, World!", 5)) // "Hello"
        println(truncateString("Hello", 10)) // Исключение
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        // 10. Поиск элемента в массиве
        println(findElement(intArrayOf(1, 2, 3), 2)) // 2
        println(findElement(intArrayOf(1, 2, 3), 4)) // Исключение
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        // 11. Конвертация в двоичную систему
        println(toBinary(10)) // "1010"
        println(toBinary(-1)) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 12. Проверка делимости
        println(isDivisible(10, 2)) // true
        println(isDivisible(10, 0)) // Исключение
    } catch (e: ArithmeticException) {
        println(e.message)
    }

    try {
        // 13. Чтение элемента списка
        println(getListElement(listOf(1, 2, 3), 1)) // 2
        println(getListElement(listOf(1, 2, 3), 5)) // Исключение
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
    }

    try {
        // 14. Парольная проверка
        checkPassword("password123") // Ничего не происходит
        checkPassword("pass") // Исключение
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        // 15. Проверка даты
        println(isValidDate("20.01.2025")) // true
        println(isValidDate("32.01.2025")) // Исключение
    } catch (e: DateTimeParseException) {
        println(e.message)
    }

    try {
        // 16. Конкатенация строк
        println(concatStrings("Hello", "World")) // "HelloWorld"
        println(concatStrings("Hello", null)) // Исключение
    } catch (e: NullPointerException) {
        println(e.message)
    }

    try {
        // 17. Остаток от деления
        println(modulus(10, 3)) // 1
        println(modulus(10, 0)) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 18. Квадратный корень
        println(squareRoot(16)) // 4.0
        println(squareRoot(-1)) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 19. Конвертер температуры
        println(celsiusToFahrenheit(0.0)) // 32.0
        println(celsiusToFahrenheit(-300.0)) // Исключение
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        // 20. Проверка строки на пустоту
        checkEmptyString("Hello") // Ничего не происходит
        checkEmptyString("") // Исключение
    } catch (e: Exception) {
        println(e.message)
    }
}

// 1. Функция для нахождения максимума
fun findMax(a: Int, b: Int): Int {
    if (a == b) {
        throw Exception("Числа равны")
    }
    return if (a > b) a else b
}

// 2. Калькулятор деления
fun divide(a: Int, b: Int): Double {
    if (b == 0) {
        throw ArithmeticException("Деление на ноль недопустимо")
    }
    return a.toDouble() / b
}

// 3. Конвертер строк в числа
fun stringToInt(s: String): Int {
    return s.toIntOrNull() ?: throw NumberFormatException("Неверный формат строки")
}

// 4. Проверка возраста
fun checkAge(age: Int) {
    if (age < 0 || age > 150) {
        throw IllegalArgumentException("Недопустимый возраст")
    }
}

// 5. Нахождение корня
fun sqrt(number: Int): Double {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для извлечения корня")
    }
    return sqrt(number.toDouble())
}

// 6. Факториал
fun factorial(number: Int): Int {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для вычисления факториала")
    }
    var result = 1
    for (i in 1..number) {
        result *= i
    }
    return result
}

// 7. Проверка массива на нули
fun checkArrayForZeros(array: IntArray) {
    if (array.contains(0)) {
        throw Exception("Массив содержит нули")
    }
}

// 8. Калькулятор возведения в степень
fun power(base: Int, exponent: Int): Int {
    if (exponent < 0) {
        throw IllegalArgumentException("Недопустимая степень")
    }
    return base.toDouble().pow(exponent.toDouble()).toInt()
}

// 9. Обрезка строки
fun truncateString(s: String, length: Int): String {
    if (length > s.length) {
        throw Exception("Длина больше длины строки")
    }
    return s.substring(0, length)
}

// 10. Поиск элемента в массиве
fun findElement(array: IntArray, element: Int): Int {
    if (!array.contains(element)) {
        throw Exception("Элемент не найден")
    }
    return element
}

// 11. Конвертация в двоичную систему
fun toBinary(number: Int): String {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для конвертации")
    }
    return number.toString(2)
}

// 12. Проверка делимости
fun isDivisible(a: Int, b: Int): Boolean {
    if (b == 0) {
        throw ArithmeticException("Деление на ноль недопустимо")
    }
    return a % b == 0
}

// 13. Чтение элемента списка
fun getListElement(list: List<Int>, index: Int): Int {
    if (index < 0 || index >= list.size) {
        throw IndexOutOfBoundsException("Индекс выходит за пределы списка")
    }
    return list[index]
}

// 14. Парольная проверка
fun checkPassword(password: String) {
    if (password.length < 8) {
        throw Exception("Слабый пароль")
    }
}

// 15. Проверка даты
fun isValidDate(date: String): Boolean {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return try {
        LocalDate.parse(date, formatter)
        true
    } catch (e: DateTimeParseException) {
        throw IllegalArgumentException("Неверный формат даты: $date")
    }
}

// 16. Конкатенация строк
fun concatStrings(s1: String?, s2: String?): String {
    if (s1 == null || s2 == null) {
        throw NullPointerException("Одна из строк равна null")
    }
    return s1 + s2
}

// 17. Остаток от деления
fun modulus(a: Int, b: Int): Int {
    if (b == 0) {
        throw IllegalArgumentException("Деление на ноль недопустимо")
    }
    return a % b
}

// 18. Квадратный корень
fun squareRoot(number: Int): Double {
    if (number < 0) {
        throw IllegalArgumentException("Недопустимое число для извлечения корня")
    }
    return sqrt(number.toDouble())
}

// 19. Конвертер температуры
fun celsiusToFahrenheit(celsius: Double): Double {
    if (celsius < -273.15) {
        throw IllegalArgumentException("Температура ниже абсолютного нуля")
    }
    return (celsius * 9 / 5) + 32
}

// 20. Проверка строки на пустоту
fun checkEmptyString(s: String?) {
    if (s.isNullOrEmpty()) {
        throw Exception("Строка пустая или null")
    }
}
