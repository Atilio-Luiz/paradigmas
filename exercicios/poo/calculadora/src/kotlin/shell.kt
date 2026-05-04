import java.text.DecimalFormat
import java.util.Scanner

class Calculator(var batteryMax: Int) {
    var battery: Int = 0
    var display: Float = 0.0f

    fun chargeBattery(value: Int) {
        if (value < 0) return

        battery += value
        if (battery > batteryMax) {
            battery = batteryMax
        }
    }

    fun sum(a: Int, b: Int) {
        if (battery == 0) {
            println("fail: bateria insuficiente")
            return
        }
        battery -= 1
        display = (a + b).toFloat()
    }

    fun division(num: Int, den: Int) {
        if (battery == 0) {
            println("fail: bateria insuficiente")
            return
        }
        battery -= 1
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
    val scanner = Scanner(System.`in`)
    var calculator = Calculator(0)

    while (true) {
        val line = scanner.nextLine()
        println("$$line")

        val par = line.split(" ")
        val cmd = par[0]

        when (cmd) {
            "end" -> break

            "init" -> {
                val batteryMax = par[1].toInt()
                calculator = Calculator(batteryMax)
            }

            "show" -> {
                println(calculator)
            }

            "charge" -> {
                val value = par[1].toInt()
                calculator.chargeBattery(value)
            }

            "sum" -> {
                val a = par[1].toInt()
                val b = par[2].toInt()
                calculator.sum(a, b)
            }

            "div" -> {
                val num = par[1].toInt()
                val den = par[2].toInt()
                calculator.division(num, den)
            }

            else -> println("fail: comando invalido")
        }
    }
}