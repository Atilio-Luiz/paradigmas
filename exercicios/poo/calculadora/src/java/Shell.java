import java.util.*;
import java.text.DecimalFormat;

// DEL!
class Calculator {
    public int batteryMax;
    public int battery;
    public float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0.0f;
    }

    public void chargeBattery(int value) {
        if (value < 0) {
            return;
        }
        this.battery += value;
        if (this.battery > this.batteryMax) {
            this.battery = this.batteryMax;
        }
    }

    public void sum(int a, int b) {
        if (this.battery == 0) {
            System.out.println("fail: bateria insuficiente");
            return;
        }
        this.battery -= 1;
        this.display = (a + b);
    }

    public void division(int num, int den) {
        if (this.battery == 0) {
            System.out.println("fail: bateria insuficiente");
            return;
        }
        this.battery -= 1;
        if (den == 0) {
            System.out.println("fail: divisao por zero");
            return;
        }
        this.display = (float) num / den;
        
    }
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format("display = %s, battery = %d", df.format(this.display), this.battery);
    }
}

// ADD!

public class Shell {

    public static void main(String[] args) {
        // COM!
        Calculator calculator = new Calculator(0);
        // ADD!
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                // CHAME O CONSTRUTOR
                // COM!
                int batteryMax = Integer.parseInt(par[1]);
                // DEL!
                calculator = new Calculator(batteryMax);
            } 
            else if (cmd.equals("show")) {
                // MOSTRAR
                // DEL!
                System.out.println(calculator);
            } 
            else if (cmd.equals("charge")) {
                // RECARREGAR A BATERIA
                // COM!
                int value = Integer.parseInt(par[1]);
                // DEL!
                calculator.chargeBattery(value);
            } 
            else if (cmd.equals("sum")) {
                // SOMAR
                // COM!
                int a = Integer.parseInt(par[1]);
                int b = Integer.parseInt(par[2]);
                // DEL!
                calculator.sum(a, b);
            } 
            else if (cmd.equals("div")) {
                // DIVIDIR
                // COM!
                int num = Integer.parseInt(par[1]);
                int den = Integer.parseInt(par[2]);
                // DEL!
                calculator.division(num, den);
            } 
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
