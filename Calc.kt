fun main(args: Array) {
    val (operation, num1, num2) = parseArguments(args)
    val result = when (operation) {
        "multiplica" -> multiplica(num1, num2)
        "resta" -> resta(num1, num2)
        else -> throw IllegalArgumentException("Operación no soportada")
    }
    showResult(operation, result)
}
fun resta(num1: Int, num2: Int): Int {
    return num1 - num2
}