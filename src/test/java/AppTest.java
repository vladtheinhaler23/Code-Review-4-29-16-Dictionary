import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource().contains("Dictionary"));
    assertThat(pageSource().contains("Add a new Word"));
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new Word"));
    fill("#wordInput").with("Tonsil");
    submit(".btn");
    assertThat(pageSource().contains("Thank you for adding your word."));
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#wordInput").with("Tonsil");
    submit(".btn");
    click("a", withText("View Your Dictionary"));
    assertThat(pageSource().contains("Tonsil"));
  }

  @Test
  public void wordPageDisplaysName() {
    goTo("http://localhost:4567/words/new");
    fill("#wordInput").with("Tonsil");
    submit(".btn");
    click("a", withText("View Your Dictionary"));
    click("a", withText("Tonsil"));
    assertThat(pageSource().contains("Tonsil"));
  }

  @Test
  public void wordDefinitionFormIsDisplayed() {
    Word.clear();
    goTo("http://localhost:4567/words/new");
    fill("#wordInput").with("Tonsil");
    submit(".btn");
    click("a", withText("View Your Dictionary"));
    click("a", withText("Tonsil"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to Tonsil");
  }

  @Test
  public void definitionIsAddedAndDisplayed() {
    Word.clear();
    goTo("http://localhost:4567/words/new");
    fill("#wordInput").with("Tonsil");
    submit(".btn");
    click("a", withText("View Your Dictionary"));
    click("a", withText("Tonsil"));
    click("a", withText("Add a new definition"));
    fill("#definition").with("A part of the throat");
    submit(".btn");
    click("a", withText("View Word List"));
    click("a", withText("Tonsil"));
    assertThat(pageSource()).contains("A part of the throat");
  }
}
