function input() { return ""; }
export {};

// DEL!
class Car{
    pass: number; // Passageiros
    passMax: number; // limite de Passageiros
    gas: number; // tanque
    gasMax: number; // limite do tanque
    km: number; // quantidade de quilometragem

    constructor() {
        this.pass = 0; // Passageiros
        this.passMax = 2; // limite de Passageiros
        this.gas = 0; // tanque
        this.gasMax = 100; // limite do tanque
        this.km = 0; // quantidade de quilometragem
    }

    enter(): void {
        if (this.pass < this.passMax) {
            this.pass += 1;
            return;
        }
        console.log("fail: limite de pessoas atingido");
    }

    leave(): void {
        if (this.pass > 0) {
            this.pass-=1;
            return;
        }
        console.log("fail: nao ha ninguem no carro");
    }

    fuel(gas: number): void {
        this.gas += gas;
        if(this.gas > this.gasMax) {
            this.gas = this.gasMax;
        }
    }
    
    drive (km: number): void {
        if(this.pass == 0) {
            console.log("fail: nao ha ninguem no carro");
            return;
        }
        if(this.gas == 0) {
            console.log("fail: tanque vazio");
            return;
        }
        if(this.gas < km) {
            console.log("fail: tanque vazio apos andar " + this.gas + " km");
            this.km += this.gas;
            this.gas = 0;
            return;
        }
        this.gas = this.gas - km;
        this.km = this.km + km;
    }

    toString(): string {
        return "pass: " + this.pass + ", gas: " + this.gas + ", km: " + this.km;
    }
};

// ADD!

function main() {
    // CRIE SEU CARRO AQUI
    // DEL!
    const car = new Car();
    // ADD!
    while(true) {
        let line = input();
        console.log("$" + line);

        const par = line.split(" ");
        const cmd = par[0];

        if (cmd == "end") {
            break;
        } 
        else if (cmd == "show") {
            // MOSTRE O CARRO
            // DEL!
            console.log(car.toString());
        } 
        else if (cmd == "enter") {
            // TENTE EMBARCAR UMA PESSOA
            // DEL!
            car.enter();
        } 
        else if (cmd == "leave") {
            // TENTE DESEMBARCAR UMA PESSOA
            // DEL!
            car.leave();
        } 
        else if (cmd == "fuel") {
            // INCREMENTE O COMBUSTIVEL
            // COM!
            const increment = parseInt(par[1]);
            // DEL!
            car.fuel(increment);
        } 
        else if (cmd == "drive") {
            // TENTE DIRIGIR CERTA DISTANCIA
            // COM!
            const distance = parseInt(par[1]);
            // DEL!
            car.drive(distance);
        } 
        else {
            console.log("fail: comando invalido");
        }
    }
}

main()
