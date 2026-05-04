import java.util.*;

// DEL!

class Car{
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem

    public Car() {
        this.pass = 0; // Passageiros
        this.passMax = 2; // limite de Passageiros
        this.gas = 0; // tanque
        this.gasMax = 100; // limite do tanque
        this.km = 0; // quantidade de quilometragem
    }

    public void enter() {
        if (pass < passMax) {
            pass += 1;
            return;
        }
        System.out.println("fail: limite de pessoas atingido");
    }

    public void leave() {
        if (pass > 0) {
            pass-=1;
            return;
        }
        System.out.println("fail: nao ha ninguem no carro");
    }

    public void fuel(int gas) {
        this.gas += gas;
        if(this.gas > gasMax)
        this.gas = gasMax;
    }
    
    public void drive (int km) {
        if(this.pass == 0) {
            System.out.println("fail: nao ha ninguem no carro");
        } 
            else if(this.gas == 0) {
            System.out.println("fail: tanque vazio");
        }
        else if(this.gas < km) {
            System.out.println("fail: tanque vazio apos andar " + this.gas + " km");
            this.km += this.gas;
            this.gas = 0;
        } 
            else{
            this.gas = gas - km;
            this.km = this.km + km;
        }
    }

    public String toString() {
        return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    }
};
// ADD!

public class Shell {
    
    public static void main(String[] a) {
        // CRIE SEU CARRO AQUI
        // DEL!
        Car car = new Car();
        // ADD!
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) {
                // MOSTRE OS ATRIBUTOS DO CARRO
                // DEL!
                System.out.println(car);
            } 
            else if (cmd.equals("enter")) {
                // TENTE EMBARCAR UMA PESSOA
                // DEL!
                car.enter();
            } 
            else if (cmd.equals("leave")) {
                // TENTE DESEMBARCAR UMA PESSOA
                // DEL!
                car.leave();
            } 
            else if (cmd.equals("fuel")) {
                // AUMENTE A QUANTIDADE DE COMBUSTIVEL
                // COM!
                int increment = Integer.parseInt(par[1]);
                // DEL!
                car.fuel(increment);
            } 
            else if (cmd.equals("drive")) {
                // TENTE DIRIGIR UMA CERTA DISTANCIA
                // COM!
                int distance = Integer.parseInt(par[1]);
                // DEL!
                car.drive(distance);
            }  
            else {
                System.out.println("fail: comando invalido");
            }
        }   
    }
    private static Scanner scanner = new Scanner(System.in);
}
