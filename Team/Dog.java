package HW_1_1.Team;

import static HW_1_1.Tools.rnd;

public class Dog extends Animal {
    public Dog(String name) {
        super("Dog", name, rnd(400, 600), rnd(2, 4), rnd(17, 23));
    }
}