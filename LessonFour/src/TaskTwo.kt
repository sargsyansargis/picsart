class Node(
    val name: String
) {
    val node = mutableListOf<Node>()


}

// create root and node
fun main(args: Array<String>) {
    root {
        node("1") {
            node("3") {
                node("5")
            }
            node("4")
        }
        node("2")
    }
}

fun node(s: String, function: Node.() -> Node): Node {
    val n = Node(s)
    n.node.add(n.function())
    return n

}

fun node(s: String): Node {
    return Node(s)
}


fun root(function: Node.() -> Node) {
    val root = Node("root")
//    println("name ${root.name}")
    root.node.add(root.function())
}










