package HW_3_1;

import java.util.ArrayList;

/**
2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */

/*
 Желательно как можно меньше добавлять своего, чего нет в задании
(т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
делать взаимодействие с пользователем через консоль и т.д. Консоль желательно не использовать для ввода,
тестировать просто из метода main(), прописывая add() и get().
 */

public class PhoneBook {
    static ArrayList<Clients> clients = new ArrayList<>();

    public static void main(String[] args) {
        add("Smith", "+1 (213) 623-9200");
        add("Johnson", "+1 (310) 914-3222");
        add("Williams", "+1 (323) 656-5847");
        add("Brown", "+1 (213) 413-2617");
        add("Taylor", "+1 (818) 744-4955");
        add("Smith", "+1 (323) 465-5860");
        add("Robinson", "+1 (424) 278-5817");
        add("Brown", "+1 (800) 257-8826");

        get("Smith");
        get("Taylor");
        get("Brown");
        get("Trump");
    }

    public static void add(String name, String phone){
        clients.add(new Clients(name,phone));
    }

    public static void get(String name) {
        for (int i = 0; i < clients.size(); i++) {
            if ((clients.get(i).getName() == name)) {
                System.out.println(clients.get(i).toString());
            }
        }
    }
}
