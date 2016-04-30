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
}
