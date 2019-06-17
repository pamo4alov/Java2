package HW_1_1.Team;

import static HW_1_1.Tools.rnd;

public class Cat extends Animal {
    public Cat(String name) {
        super("Cat", name, rnd(150, 250), rnd(18, 22), 0);
    }
}
