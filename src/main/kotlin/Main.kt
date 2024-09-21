/*
Написать игру камень ножницы бумага
*/

fun main() {
    println("Игра камень, ножницы бумага!")
    print("Выберите действие(1-камень/2-ножницы/3-бумага): ")
    val input = readln().toInt()

    val match = extracted(input)//вызов функции
    print(match)
}

private fun extracted(input: Int): String {
    val pcVibor = (1..3).random()
    var result = ""
    when (input) {
        1 -> if (pcVibor == 2) {
            result = "Соперник выбрал ножницы. Вы победили!"
        } else if (pcVibor == 3) {
            result = "Соперник выбрал бумагу. Вы проиграли..."
        } else {
            result = "Соперник выбрал камень. Ничья."
        }

        2 -> if (pcVibor == 2) {
            result = "Соперник выбрал ножницы. Ничья."
        } else if (pcVibor == 3) {
            result = "Соперник выбрал бумагу. Вы выиграли!"
        } else {
            result = "Соперник выбрал камень. Вы проиграли..."
        }

        3 -> if (pcVibor == 2) {
            result = "Соперник выбрал ножницы. Вы проиграли..."
        } else if (pcVibor == 3) {
            result = "Соперник выбрал бумагу. Ничья."
        } else {
            result = "Соперник выбрал камень. Вы выиграли!"
        }
    }
    return result
}