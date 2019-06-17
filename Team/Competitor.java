package HW_1_1.Team;

public interface Competitor {
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    boolean isOnDistance();
    String getFullName();
    void info();
}
