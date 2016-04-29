import java.util.ArrayList;

public class Word {

  private String mWordName;
  private static ArrayList<Word> instances = new ArrayList<Word>();

  public Word(String wordInput) {
    mWordName = wordInput;
    instances.add(this);
  }

  public String getName() {
    return mWordName;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }
}
