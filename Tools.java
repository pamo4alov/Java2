package HW_1_1;

public class Tools {

    public static int rnd(int min, int max) { // random integer in range
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}