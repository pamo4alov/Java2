package HW_1_1;

/**
 * Задание:
 * 1. Разобраться с имеющимся кодом;
 * 2. Добавить класс Team, который будет содержать: название команды, массив из 4-х участников (т.е. в конструкторе
 * можно сразу всех участников указывать), метод для вывода информации о членах команды прошедших дистанцию, метод вывода
 * информации обо всех членах команды.
 * 3. Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий, метод который будет
 * просить команду пройти всю полосу;
 */
/*
То есть в итоге должно быть что-то вроде:
public static void main(String[] args) {
        Course c = new Course(...); // Создаем полосу препятствий
        Team team = new Team(...);  // Создаем команду
        c.doIt(team);               // Просим команду пройти полосу
        team.showResults();         // Показываем результаты
        }
*/

import HW_1_1.Obstacle.Course;
import HW_1_1.Obstacle.Cross;
import HW_1_1.Obstacle.Wall;
import HW_1_1.Obstacle.Water;
import HW_1_1.Team.Cat;
import HW_1_1.Team.Dog;
import HW_1_1.Team.Human;
import HW_1_1.Team.Team;

public class Main {
    public static void main(String[] args) {

        Team team = new Team(new Human("Ron -"), new Human("Mark -"),new Cat("Musik -"),
                new Dog("Borz -"));
        Course course = new Course(new Cross(100), new Wall(5), new Water(25), new Cross(300));

        course.doIt(team);
        team.showResults();
    }

}