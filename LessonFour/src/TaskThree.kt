fun main() {
    var arr = IntArray(0)
    arr = arr add 3 // create new array and add element at the end
    arr = arr add 7 add 1
    arr = arr add 9 add 6 add 8
    arr = arr insert 5 at 2 // insert 5 into position 2
    arr = arr `remove at` 3 // set to 0 at position 3
    arr = arr `remove at` 1
    arr print 2..5 // 5 0 6 8
//    println()
//    arr print first
//    arr print last

    // optional
    println()
    println(arr get size) // 6
    arr print all
    println()
    arr print size
}


private infix fun IntArray.print(intRange: IntRange) {
    for (k in intRange)
        print("${this[k]} ")

}

private infix fun IntArray.get(range: Range): String {
    return when(range ){
        Range.Size-> this.size.toString()
        Range.All-> this.toString()
    }


}

private infix fun IntArray.print(intRange: Range) {
    when (intRange) {
        Range.All -> {
            this print (0 until this.size)

        }

        Range.Size -> print(this.size)
    }

}

private infix fun IntArray.`remove at`(i: Int): IntArray {
    this[i] = 0
    return this
}

private infix fun Pair<IntArray, Int>.at(p: Int): IntArray {
    val k = this.first
    k[p] = this.second
    return k
}

private infix fun IntArray.insert(a: Int): Pair<IntArray, Int> {
    return Pair(this, a)
}


private infix fun IntArray.add(a: Int): IntArray = this.plus(a)

val all = Range.All

val size = Range.Size

enum class Range {
    All,
    Size
}

