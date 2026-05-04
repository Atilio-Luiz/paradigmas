#include <iostream>
#include <sstream>
using namespace std;
// DEL!
class Car {
public:
    int pass;
    int passMax;
    int gas;
    int gasMax;
    int km;

    Car() {
        pass = 0;
        passMax = 2;
        gas = 0;
        gasMax = 100;
        km = 0;
    }

    void enter() {
        if (pass < passMax) {
            pass++;
        } 
        else {
            cout << "fail: limite de pessoas atingido\n";
        }
    }

    void leave() {
        if (pass > 0) {
            pass--;
        } 
        else {
            cout << "fail: nao ha ninguem no carro\n";
        }
    }

    void fuel(int gas) {
        this->gas += gas;
        if (this->gas > gasMax) {
            this->gas = gasMax;
        }
    }

    void drive(int km) {
        if (pass == 0) {
            cout << "fail: nao ha ninguem no carro\n";
        } 
        else if (gas == 0) {
            cout << "fail: tanque vazio\n";
        } 
        else if (this->gas < km) {
            cout << "fail: tanque vazio apos andar " << this->gas << " km\n";
            this->km += this->gas;
            this->gas = 0;
        } 
        else {
            this->km += km;
            this->gas -= km;
        }
    }

    string str() const {
        stringstream ss;
        ss << "pass: " << pass << ", gas: " << gas << ", km: " << km;
        return ss.str();
    }
};

// ADD!

int main() {
    // CRIE SEU CARRO AQUI
    // DEL!
    Car car;
    // ADD!
    while (true) {
        
        string line, cmd;
        getline(cin, line);
        cout << "$" << line << '\n';

        stringstream ss(line);
        ss >> cmd;
        
        if (cmd == "end")   {
            break;
        } 
        else if (cmd == "show") {
            // MOSTRE O CARRO
            // DEL!
            cout << car.str() << '\n';
        } 
        else if (cmd == "enter") {
            // TENTE EMBARCAR
            // DEL!
            car.enter();
        } 
        else if (cmd == "leave") {
            // TENTE DESCEMBARCAR
            // DEL!
            car.leave();
        } 
        else if (cmd == "fuel") {
            // AUMENTE O COMBUSTIVEL
            // COM!
            int increment{};
            ss >> increment;
            // DEL!
            car.fuel(increment);
        } 
        else if (cmd == "drive") {
            // TENTE DIRIGIR
            // COM!
            int distance {};
            ss >> distance;
            // DEL!
            car.drive(distance);
        } 
        else {
            cout << "fail: comando invalido\n";
        }
    }
}
