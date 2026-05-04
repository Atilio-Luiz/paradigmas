import java.text.DecimalFormat


// Implementar a classe Calculator aqui


fun main() {
    var calculator = Calculator(0)

    while (true) {
        val line = readln()
        println("$$line")

        val parts = line.split(" ")
        val cmd = parts[0]
        val args = parts.drop(1)

        when (cmd) {
            "end" -> return

            "init" -> {
                val batteryMax = args[0].toInt()
                calculator = Calculator(batteryMax)
            }

            "show" -> println(calculator)

            "charge" -> {
                val value = args[0].toInt()
                calculator.chargeBattery(value)
            }

            "sum" -> {
                val (a, b) = args.map { it.toInt() }
                calculator.sum(a, b)
            }

            "div" -> {
                val (num, den) = args.map { it.toInt() }
                calculator.division(num, den)
            }

            else -> println("fail: comando invalido")
        }
    }
}