package HW_3_1;

public class WordsCount {

    String word;
    int wCount;

    public WordsCount(String word, int wCount) {
        this.word = word;
        this.wCount = wCount;
    }

    public WordsCount(String word) {
        this.word = word;
        wCount = 1;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return wCount;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(int count) {
        this.wCount = count;
    }
}
