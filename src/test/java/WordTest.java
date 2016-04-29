import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

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
}
