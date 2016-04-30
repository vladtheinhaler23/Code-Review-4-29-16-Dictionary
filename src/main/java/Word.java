import java.util.ArrayList;

public class Word {

  private String mWordName;
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Word(String wordInput) {
    mWordName = wordInput;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
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

  public int getId() {
    return mId;
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }
}
