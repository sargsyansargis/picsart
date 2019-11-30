fun main(args: Array<String>) {
    // Create forEachWord function
    "please print each word".forEachWord { word ->
        println(word)
    }

    // create toColor function
    val c = (0x775FB34F).toColor()
    println(c) // Color(a=136, r=160, g=76, b=177)

    // create bitIsOneAtPosition
    print(4.bitIsOneAtPosition(2))

}


private fun String.forEachWord(a: (String) -> Unit) {

    for (word in this.trim().splitToSequence(' '))
        println(word)
}

private fun Int.toColor(): List<Int> {
    val k = mutableListOf<Int>()
    for (i in 1..4) {

        k.add(0, (this shr (8 * (i - 1))) and 255)
    }
    return k
}

private fun Int.bitIsOneAtPosition(a: Int): Boolean = (this and (1 shl a)) != 0


