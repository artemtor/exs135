fun main() {
    println("Введите слова, разделяя их пробелами:")
    val input = readLine()

    if (input.isNullOrBlank()) {
        println("Вы не ввели слова.")
        return
    }

    val words = input.split(" ").distinct()
    val groupedWords = groupWordsBySameLetters(words)

    println("Группы слов по признаку 'состоят из одинаковых букв':")
    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}

fun groupWordsBySameLetters(words: List<String>): List<List<String>> {
    val groupedWords = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        if (groupedWords.containsKey(sortedWord)) {
            groupedWords[sortedWord]?.add(word)
        } else {
            groupedWords[sortedWord] = mutableListOf(word)
        }
    }
    return groupedWords.values.toList()
}