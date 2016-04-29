import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("some definition");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithDefinition_true() {
    Definition myDefinition =  new Definition("some definition");
    assertEquals("some definition", myDefinition.getDefinition());
  }

  @Test
  public void all_returnsAListOfAllDefinitionsInputted_true() {
    Definition myFirstDefinition = new Definition("some definition");
    Definition mySecondDefinition = new Definition("some other definition");
    assertTrue(Definition.all().contains(myFirstDefinition));
    assertTrue(Definition.all().contains(mySecondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("some definition");
    Definition.clear();
    assertEquals(0, Definition.all().size());
  }

  @Test
  public void getId_instantiatesWithAnId_1(){
    Definition.clear();
    Definition myDefinition = new Definition("some definition");
    assertEquals(1, myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithCorrectId_secondDefinition() {
    Definition myFirstDefinition = new Definition("some definition");
    Definition mySecondDefinition = new Definition("some other definition");
    assertEquals(Definition.find(mySecondDefinition.getId()), mySecondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionIsFound_null() {
    assertTrue(Definition.find(999) == null);
  }
}
