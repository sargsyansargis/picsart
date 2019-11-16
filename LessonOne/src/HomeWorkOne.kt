import kotlin.random.Random

val levels = listOf(1, 2, 3)
val steps = listOf(7, 5, 3)

fun main() {
    var userNumber: Int

    val generatedNumber = Random.nextInt(100)
    println("Start Guessing Game ")

    var uStep = steps[getLevel() - 1]


    fun checkInputNumber() {
        if (uStep == 0) {
            println("You lose,number was $generatedNumber ,try again")
            return main()
        }
        println("You have $uStep steps")
        userNumber = getSelectedNumber()
        when {
            userNumber > generatedNumber -> {
                uStep--
                if (uStep > 0)
                    println("take lower")
                return checkInputNumber()
            }
            userNumber < generatedNumber -> {
                uStep--
                if (uStep > 0)
                    println("take higher")
                return checkInputNumber()
            }
            else -> {
                println("You win")
            }
        }
    }
    checkInputNumber()
}

fun getLevel(): Int {
    println("Please select levels 1,2,3")
    readLine()?.toIntOrNull()?.let { inputNumber ->
            if (levels.contains(inputNumber)) return inputNumber
        }
    return getLevel()
}

fun getSelectedNumber(): Int {
    println("Please enter your number in range from 0 to 100")
    readLine()?.toIntOrNull()?.let { inputNumber ->
            if (inputNumber in 0..100) return inputNumber
        }
    return getSelectedNumber()
}

