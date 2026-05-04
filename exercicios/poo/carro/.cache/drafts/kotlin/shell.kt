
// Crie sua classe Car aqui

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