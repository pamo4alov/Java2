package HW_3_1;

import java.util.ArrayList;

/**
 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать, сколько раз встречается каждое слово.
 */

public class WordsArray {
    // Сurrencies
    static String[] words = {"euro", "dollar", "real", "dollar", "euro", "ruble", "euro", "yuan",
            "pound", "yen", "pound", "yuan"};

    static ArrayList<WordsCount> count = new ArrayList<>();
    static Boolean wordFound = false;

    public static void main(String[] args) {
        count.add(new WordsCount(words[0])); // first word is definitely missing, add immediately
        for (int i = 1; i < words.length; i++) {
            wordFound = false;
            for (int j = 0; j < count.size(); j++) {
                if ((count.get(j).getWord().equals(words[i]))) // if find a word
                {
                    // increase amount by 1
                    count.get(j).setCount(count.get(j).wCount + 1);
                    wordFound = true; // found
                    break;
                }
            }
            if (!wordFound) { // if not found, add to the list
                count.add(new WordsCount(words[i]));
            }
        }
        // Display a list of found words
        for (int i = 0; i < count.size(); i++) {
            System.out.println(count.get(i).getWord() + ": " + count.get(i).getCount());
        }
    }
}