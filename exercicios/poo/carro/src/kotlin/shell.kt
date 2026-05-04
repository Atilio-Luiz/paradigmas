class Car {
    var pass = 0        // passageiros
    var passMax = 2     // capacidade máxima
    var gas = 0         // combustível atual
    var gasMax = 100    // capacidade do tanque
    var km = 0          // quilometragem total

    fun enter() {
        if (pass < passMax) {
            pass++
        } else {
            println("fail: limite de pessoas atingido")
        }
    }

    fun leave() {
        if (pass > 0) {
            pass--
        } else {
            println("fail: nao ha ninguem no carro")
        }
    }

    fun fuel(amount: Int) {
        gas = (gas + amount).coerceAtMost(gasMax)
    }

    fun drive(distance: Int) {
        when {
            pass == 0 -> println("fail: nao ha ninguem no carro")
            gas == 0 -> println("fail: tanque vazio")
            gas < distance -> {
                println("fail: tanque vazio apos andar $gas km")
                km += gas
                gas = 0
            }
            else -> {
                gas -= distance
                km += distance
            }
        }
    }

    override fun toString(): String =
        "pass: $pass, gas: $gas, km: $km"
}

fun main() {
    val car = Car()

    while (true) {
        val line = readln()
        println("$$line")
        
        val parts = line.split(" ")
        val cmd = parts[0]
        val args = parts.drop(1)

        when (cmd) {
            "end" -> return

            "show" -> println(car)

            "enter" -> car.enter()

            "leave" -> car.leave()

            "fuel" -> car.fuel(args[0].toInt())

            "drive" -> car.drive(args[0].toInt())

            else -> println("fail: comando invalido")
        }
    }
}