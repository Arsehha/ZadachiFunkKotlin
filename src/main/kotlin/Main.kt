/*
Создать программу, для шифровки и расшифровки сообщений.
Программа запрашивает исходное сообщение, вспомогательный символ и спрашивает - использовать типовую таблицу или генерировать случайную.
Типовая таблица предоставлена на экране. При генерации случайной таблицы каждой паре букв сопоставляется случайное число от 1 до 999.
Числа в таблице не повторяются. Каждое число состоит из трех знаков. Если число меньше 100,
то оно дописывается до трех знаков путем добавления нулей перед числом.

В результате работы на консоль выводится исходное сообщение разбитое по парам букв с пробелами между парами,
зашифрованное сообщение состоящее из цифр разбитых в группы по три цифры и пробела между группами и шифровальная таблица.
Группа цифр из зашифрованного сообщения пишется под соответствующей парой символов исходного сообщения.

Шифр Порты, представленный им в виде таблицы, является первым известным биграммным шифром.
Размер его таблицы составлял 20 х 20 ячеек; наверху горизонтально и слева вертикально записывался
стандартный алфавит (в нем не было букв J, К, U, W, X и Z). В ячейках таблицы могли быть записаны любые числа,
буквы или символы - сам Джованни Порта пользовался символами - при условии, что содержимое ни одной из ячеек не повторялось.
Применительно к русскому языку таблица шифрозамен может выглядеть следующим образом.
*/

fun main() {
    val additionalSymbol: String
    print("Введите слово: ")
    var inputWord = readln().uppercase()
    if(inputWord.length % 2 != 0) {
        print("Введите доп символ: ")
        additionalSymbol = readln().uppercase()
        inputWord += additionalSymbol
    }
    if(inputWord.contains('Й')) {
        inputWord.replace('Й', 'И', true)
    }
    if(inputWord.contains('Ё')) {
        inputWord.replace('Ё', 'Е', true)
    }
    print("Выберите тип шифровки:\n1. Типовая таблица\n2. Рандомная таблица\n")
    val input = readln().toInt()
    when(input) {
        1 -> println(typicalTable(inputWord))
        2 -> println(randomTable(inputWord))
    }
}

private fun typicalTable(inputWord: String):String {
    var cryptTable = arrayOf<Array<String>>()
    var symbol = ""
    var number = 1
    for(i in 0..30) {
        var array = arrayOf<String>()
        for(j in 0..30) {
            if(number < 100) {
                if(number < 10) {
                    symbol = "00$number"
                } else {
                    symbol = "0$number"
                }
            } else {
                symbol = "$number"
            }
            array += arrayOf(symbol)
            number++
        }
        cryptTable += array
    }
    val result = generateArray(inputWord)
    var resulty = ""

    for(i in 0..result.size-1) {
        if(i == 0 || i % 2 != 1) {
            var j: Int
            if(i != result.size-1) {
                j = i + 1
            } else
                break
            val first = result[i]
            val second = result[j]
            resulty += cryptTable[first][second]
            resulty += " "
        }
    }

    var array = arrayOf<String>()
    var symbol2 = ""
    for(i in resulty) {
        if(i != ' ') {
            symbol2 += i
        } else {
            array += symbol2
            symbol2 = ""
        }
    }

    var str = 0
    var str1 = 0
    var str2 = 0
          for (i in array) {
              str1 = 0
              str2 = 0
        for(j in cryptTable) {
            str = j.indexOf(i)
            str1 += 1
            if(str != -1) {
                str2 = str1
                str = cryptTable.indexOf(j)
                break
            }
        }
        resulty += "${str.toInt()} ${str2.toInt()} "
    }

    //доделать

    return resulty
}//создаёт статичный массив уникальных чисел
 //принимает ключи букв и шифрует их по таблице

private fun randomTable(inputWord: String): String {
    var cryptTable = arrayOf<Array<String>>()
    var numberTable = mutableListOf<Int>()
    for(i in 1..999) {
        numberTable += i
    }
    var symbol = ""
    var number = 1
    var randomNumber = 0
    for(i in 0..30) {
        var array = arrayOf<String>()
        for(j in 0..30) {
            randomNumber = (0..numberTable.size-1).random()
            number = numberTable[randomNumber]
            if(number < 100) {
                if(number < 10) {
                    symbol = "00$number"
                } else {
                    symbol = "0$number"
                }
            } else {
                symbol = "$number"
            }
            array += arrayOf(symbol)
            numberTable.removeAt(randomNumber)
        }
        cryptTable += array
    }
    val result = generateArray(inputWord)
    var resulty = ""

    for(i in 0..result.size-1) {
        if(i == 0 || i % 2 != 1) {
            var j: Int
            if(i != result.size-1) {
                j = i + 1
            } else
                break
            val first = result[i]
            val second = result[j]
            resulty += cryptTable[first][second]
            resulty += " "
        }
    }
    return resulty
}//создаёт случайным массив уникальных чисел
 //принимает ключи букв и шифрует их по таблице

private fun generateArray(inputWord: String): Array<Int> {
    val bukvi = mapOf(0 to 'А', 1 to 'Б', 2 to 'В', 3 to 'Г', 4 to 'Д', 5 to 'Е', 6 to 'Ж', 7 to 'З',
        8 to 'И', 9 to 'К', 10 to 'Л', 11 to 'М', 12 to 'Н', 13 to 'О', 14 to 'П', 15 to 'Р', 16 to 'С',
        17 to 'Т', 18 to 'У', 19 to 'Ф', 20 to 'Х', 21 to 'Ц', 22 to 'Ч', 23 to 'Ш', 24 to 'Щ', 25 to 'Ъ', 26 to 'Ы',
        27 to 'Ь', 28 to 'Э', 29 to 'Ю', 30 to 'Я')
    var result = arrayOf<Int>()
    for(i in inputWord.indices) {
        var cKey = bukvi.keys.first {k ->
            bukvi[k] == inputWord[i]
        }
        result += cKey
    }
    return result
}//возвращает ключи символов из мапа(почти шифратор)

private fun generateString(inputEncryptedWord: Array<Int>) {
    val bukvi = mapOf(0 to 'А', 1 to 'Б', 2 to 'В', 3 to 'Г', 4 to 'Д', 5 to 'Е', 6 to 'Ж', 7 to 'З',
        8 to 'И', 9 to 'К', 10 to 'Л', 11 to 'М', 12 to 'Н', 13 to 'О', 14 to 'П', 15 to 'Р', 16 to 'С',
        17 to 'Т', 18 to 'У', 19 to 'Ф', 20 to 'Х', 21 to 'Ц', 22 to 'Ч', 23 to 'Ш', 24 to 'Щ', 25 to 'Ъ', 26 to 'Ы',
        27 to 'Ь', 28 to 'Э', 29 to 'Ю', 30 to 'Я')

} //функция перевода целочисленного массива по ключам(дешифратор)