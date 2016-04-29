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
}
