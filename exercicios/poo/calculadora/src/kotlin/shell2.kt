import java.text.DecimalFormat

class Calculator(var batteryMax: Int) {
    var battery = 0
    var display = 0.0f

    fun chargeBattery(value: Int) {
        if (value < 0) return
        battery = (battery + value).coerceAtMost(batteryMax)
    }

    fun sum(a: Int, b: Int) {
        if (battery == 0) {
            println("fail: bateria insuficiente")
            return
        }
        battery--
        display = (a + b).toFloat()
    }

    fun division(num: Int, den: Int) {
        if (battery == 0) {
            println("fail: bateria insuficiente")
            return
        }
        battery--
        if (den == 0) {
            println("fail: divisao por zero")
            return
        }
        display = num.toFloat() / den
    }

    override fun toString(): String {
        val df = DecimalFormat("0.00")
        return "display = ${df.format(display)}, battery = $battery"
    }
}

fun main() {
    var calculator = Calculator(0)

    while (true) {
        val line = readln()
        println("$$line")

        val (cmd, *args) = line.split(" ")

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