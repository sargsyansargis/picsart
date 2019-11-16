import kotlin.random.Random

val levels = listOf(1, 2, 3)
val steps = listOf(7, 5, 3)

fun main() {
    var userNumber: Int

    val generatedNumber = (1..100).random()
    println("Start Guessing Game ")

    var userStep = steps[getLevel() - 1]


    fun checkInputNumber() {
        if (userStep == 0) {
            println("You lose,number was $generatedNumber ,try again")
            println("Restart")
            return main()
        }
        println("You have $userStep steps")
        userNumber = getSelectedNumber()
        when {
            userNumber > generatedNumber -> {
                userStep--
                if (userStep > 0)
                    println("take lower")
                return checkInputNumber()
            }
            userNumber < generatedNumber -> {
                userStep--
                if (userStep > 0)
                    println("take higher")
                return checkInputNumber()
            }
            else -> {
                println("You won")
            }
        }
    }
    checkInputNumber()
}

fun getLevel(): Int {
    println("Please select levels (1- Easy, 2- Medium, 3- Hard)")
    readLine()?.toIntOrNull()?.let { inputNumber ->
            if (levels.contains(inputNumber)) return inputNumber
        }
    return getLevel()
}

fun getSelectedNumber(): Int {
    println("Please enter your number in range from 1 to 100")
    readLine()?.toIntOrNull()?.let { inputNumber ->
            if (inputNumber in 1..100) return inputNumber
        }
    return getSelectedNumber()
}

