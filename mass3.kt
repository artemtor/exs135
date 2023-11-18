fun main() {
    val alphabet = listOf(
        'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р',
        'С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я'
    )

    val alphabetMap = mapOf('А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22,
        'Е' to 1, 'Ё' to 25, 'Ж' to 12, 'З' to 24, 'И' to 14,
        'Й' to 2, 'К' to 28, 'Л' to 9, 'М' to 23, 'Н' to 3,
        'О' to 29, 'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11,
        'У' to 26, 'Ф' to 5, 'Х' to 30, 'Ц' to 27, 'Ч' to 8,
        'Ш' to 18, 'Щ' to 10, 'Ь' to 33, 'Ы' to 31, 'Ъ' to 32,
        'Э' to 19, 'Ю' to 7, 'Я' to 17) // Случайный словарь - alphabet.withIndex().associate { it.value to it.index + 1 }

    println("Введите текст:")
    val inputText = readLine()?.uppercase() ?: ""

    println("Введите ключевое слово:")
    val keyword = readLine()?.uppercase() ?: ""

    println("Выберите действие (1 - Зашифровать, 2 - Дешифровать):")
    val action = readLine()?.toInt() ?: 1

    when (action) {
        1 -> {
            val encryptedText = encrypt(inputText, keyword, alphabet, alphabetMap)
            println("Зашифрованный текст: $encryptedText")
        }
        2 -> {
            val decryptedText = decrypt(inputText, keyword, alphabet, alphabetMap)
            println("Дешифрованный текст: $decryptedText")
        }
        else -> {
            println("Неверный выбор действия.")
        }
    }
}

fun encrypt(inputText: String, keyword: String, alphabet: List<Char>, alphabetMap: Map<Char, Int>): String {
    val encryptedText = StringBuilder()
    val keywordLength = keyword.length
    for ((index, char) in inputText.withIndex()) {
        if (char in alphabetMap) {
            val charIndex = (alphabetMap[char]!! + alphabetMap[keyword[index % keywordLength]]!! - 2) % alphabet.size
            encryptedText.append(alphabet[charIndex])
        } else {
            encryptedText.append(char)
        }
    }
    return encryptedText.toString()
}

fun decrypt(inputText: String, keyword: String, alphabet: List<Char>, alphabetMap: Map<Char, Int>): String {
    val decryptedText = StringBuilder()
    val keywordLength = keyword.length
    for ((index, char) in inputText.withIndex()) {
        if (char in alphabetMap) {
            val charIndex = (alphabetMap[char]!! - alphabetMap[keyword[index % keywordLength]]!!) % alphabet.size
            val adjustedIndex = if (charIndex < 0) charIndex + alphabet.size else charIndex
            decryptedText.append(alphabet[adjustedIndex])
        } else {
            decryptedText.append(char)
        }
    }
    return decryptedText.toString()
}