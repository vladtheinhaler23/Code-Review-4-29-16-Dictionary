import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @After
  public void tearDown() {
    Word.clear();
    Definition.clear();
  }

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("Tonsil");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void Word_instantiatesWithName_true() {
    Word myWord =  new Word("Tonsil");
    assertEquals("Tonsil", myWord.getName());
  }

  @Test
  public void all_returnsAListOfAllWordsInputted_true() {
    Word myFirstWord = new Word("Tonsil");
    Word mySecondWord = new Word("Throat");
    assertTrue(Word.all().contains(myFirstWord));
    assertTrue(Word.all().contains(mySecondWord));
  }

  @Test
  public void clear_emptiesAllWordsFromArrayList_0() {
    Word myWord = new Word("Tonsil");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

  @Test
  public void getId_instantiatesWithAnId_1(){
    Word.clear();
    Word myWord = new Word("Tonsil");
    assertEquals(1, myWord.getId());
  }

  @Test
  public void find_returnsWordWithCorrectId_secondWord() {
    Word myFirstWord = new Word("Tonsil");
    Word mySecondWord = new Word("Throat");
    assertEquals(Word.find(mySecondWord.getId()), mySecondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordIsFound_null() {
    assertTrue(Word.find(999) == null);
  }

  @Test
  public void getDefinitions_initallyReturnsAnEmptyArrayList_ArrayList() {
    Word myWord = new Word("Tonsil");
    assertEquals(0, myWord.getDefinitions().size());
  }

  @Test
  public void addDefiniton_addsDefinitionsToList_true() {
    Word myWord = new Word("Tonsil");
    Definition myDefinition = new Definition("Part of the throat");
    myWord.addDefinition(myDefinition);
    assertTrue(myWord.getDefinitions().contains(myDefinition));
  }
}
