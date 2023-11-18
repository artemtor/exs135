fun main() {
    println("Введите количество строк:")
    val numRows = readLine()?.toIntOrNull() ?: 0
    println("Введите количество столбцов:")
    val numCols = readLine()?.toIntOrNull() ?: 0

    if (numRows <= 0 || numCols <= 0) {
        println("Некорректные входные данные. Пожалуйста, введите положительные числа для строк и столбцов.")
        return
    }

    val array = Array(numRows) { IntArray(numCols) }

    println("Введите $numRows x $numCols трехзначные числа:")
    val digits = mutableSetOf<Char>()
    for (i in 0 until numRows) {
        for (j in 0 until numCols) {
            var validInput = false
            while (!validInput) {
                val input = readLine()
                if (input != null) {
                    val number = input.toIntOrNull()
                    if (number != null && number in 100..999) {
                        array[i][j] = number
                        digits.addAll(number.toString().toSet())
                        validInput = true // Устанавливаем флаг валидного ввода, чтобы выйти из цикла
                    } else {
                        println("Введите трехзначное число.")
                    }
                }
            }
        }
    }

    println("Двумерный массив из введенных чисел:")
    for (row in array) {
        for (value in row) {
            print("$value ")
        }
        println()
    }

    println("В массиве использовано ${digits.size} различных цифр.")
}