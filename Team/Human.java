package HW_1_1.Team;

import static HW_1_1.Tools.rnd;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    @Override
    public boolean isOnDistance() {
        return active;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = rnd(4500, 5500);
        this.maxJumpHeight = rnd(28, 32);
        this.maxSwimDistance = rnd(180, 220);
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " coped well with the cross");
        } else {
            System.out.println(name + " did not cope with cross");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " successfully jumped over the wall");
        } else {
            System.out.println(name + " could not jump over the wall");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.println(name + " swam well");
        } else {
            System.out.println(name + " could not swim");
            active = false;
        }
    }

    @Override
    public void info() {
        System.out.println(name + " - " + active);
    }

    @Override
    public String getFullName() {
        return name;
    }
}
