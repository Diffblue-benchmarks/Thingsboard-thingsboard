package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard.ActionOpenUrl;
import org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard.AdaptiveCard;
import org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard.Attachment;
import org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard.BackgroundImage;
import org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard.TextBlock;

@ContextConfiguration(
    classes = {TextBlock.class, BackgroundImage.class, AdaptiveCard.class, ActionOpenUrl.class})
@ExtendWith(SpringExtension.class)
class TeamsAdaptiveCardDiffblueTest {
  @Autowired private ActionOpenUrl actionOpenUrl;

  @Autowired private AdaptiveCard adaptiveCard;

  @Autowired private BackgroundImage backgroundImage;

  @Autowired private TextBlock textBlock;

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and {@link ActionOpenUrl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionOpenUrl#equals(Object)}
   *   <li>{@link ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionOpenUrl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl("Dr", "https://example.org/example");
    ActionOpenUrl actionOpenUrl2 = new ActionOpenUrl("Dr", "https://example.org/example");

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl2);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl2.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and {@link ActionOpenUrl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionOpenUrl#equals(Object)}
   *   <li>{@link ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionOpenUrl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl(null, "https://example.org/example");
    ActionOpenUrl actionOpenUrl2 = new ActionOpenUrl(null, "https://example.org/example");

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl2);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl2.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and {@link ActionOpenUrl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionOpenUrl#equals(Object)}
   *   <li>{@link ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionOpenUrl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl("Dr", null);
    ActionOpenUrl actionOpenUrl2 = new ActionOpenUrl("Dr", null);

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl2);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl2.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and {@link ActionOpenUrl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionOpenUrl#equals(Object)}
   *   <li>{@link ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ActionOpenUrl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl("Dr", "https://example.org/example");

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl("Mr", "https://example.org/example");

    // Act and Assert
    assertNotEquals(actionOpenUrl, new ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl(null, "https://example.org/example");

    // Act and Assert
    assertNotEquals(actionOpenUrl, new ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl("Dr", "Action.OpenUrl");

    // Act and Assert
    assertNotEquals(actionOpenUrl, new ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ActionOpenUrl actionOpenUrl = new ActionOpenUrl("Dr", null);

    // Act and Assert
    assertNotEquals(actionOpenUrl, new ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ActionOpenUrl("Dr", "https://example.org/example"), null);
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionOpenUrl.equals(Object)", "int ActionOpenUrl.hashCode()"})
  void testActionOpenUrlEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ActionOpenUrl("Dr", "https://example.org/example"), "Different type to ActionOpenUrl");
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#getType()}.
   *
   * <p>Method under test: {@link ActionOpenUrl#getType()}
   */
  @Test
  @DisplayName("Test ActionOpenUrl getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ActionOpenUrl.getType()"})
  void testActionOpenUrlGetType() {
    // Arrange, Act and Assert
    assertEquals("Action.OpenUrl", actionOpenUrl.getType());
  }

  /**
   * Test ActionOpenUrl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionOpenUrl#ActionOpenUrl()}
   *   <li>{@link ActionOpenUrl#setTitle(String)}
   *   <li>{@link ActionOpenUrl#setUrl(String)}
   *   <li>{@link ActionOpenUrl#toString()}
   *   <li>{@link ActionOpenUrl#getTitle()}
   *   <li>{@link ActionOpenUrl#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ActionOpenUrl.<init>()",
    "void ActionOpenUrl.<init>(String, String)",
    "String ActionOpenUrl.getTitle()",
    "String ActionOpenUrl.getUrl()",
    "void ActionOpenUrl.setTitle(String)",
    "void ActionOpenUrl.setUrl(String)",
    "String ActionOpenUrl.toString()"
  })
  void testActionOpenUrlGettersAndSetters() {
    // Arrange and Act
    ActionOpenUrl actualActionOpenUrl = new ActionOpenUrl();
    actualActionOpenUrl.setTitle("Dr");
    actualActionOpenUrl.setUrl("https://example.org/example");
    String actualToStringResult = actualActionOpenUrl.toString();
    String actualTitle = actualActionOpenUrl.getTitle();

    // Assert
    assertEquals("Dr", actualTitle);
    assertEquals(
        "TeamsAdaptiveCard.ActionOpenUrl(type=Action.OpenUrl, title=Dr, url=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualActionOpenUrl.getUrl());
  }

  /**
   * Test ActionOpenUrl getters and setters.
   *
   * <ul>
   *   <li>When {@code Dr}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionOpenUrl#ActionOpenUrl(String, String)}
   *   <li>{@link ActionOpenUrl#setTitle(String)}
   *   <li>{@link ActionOpenUrl#setUrl(String)}
   *   <li>{@link ActionOpenUrl#toString()}
   *   <li>{@link ActionOpenUrl#getTitle()}
   *   <li>{@link ActionOpenUrl#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl getters and setters; when 'Dr'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ActionOpenUrl.<init>()",
    "void ActionOpenUrl.<init>(String, String)",
    "String ActionOpenUrl.getTitle()",
    "String ActionOpenUrl.getUrl()",
    "void ActionOpenUrl.setTitle(String)",
    "void ActionOpenUrl.setUrl(String)",
    "String ActionOpenUrl.toString()"
  })
  void testActionOpenUrlGettersAndSetters_whenDr() {
    // Arrange and Act
    ActionOpenUrl actualActionOpenUrl = new ActionOpenUrl("Dr", "https://example.org/example");
    actualActionOpenUrl.setTitle("Dr");
    actualActionOpenUrl.setUrl("https://example.org/example");
    String actualToStringResult = actualActionOpenUrl.toString();
    String actualTitle = actualActionOpenUrl.getTitle();

    // Assert
    assertEquals("Dr", actualTitle);
    assertEquals(
        "TeamsAdaptiveCard.ActionOpenUrl(type=Action.OpenUrl, title=Dr, url=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualActionOpenUrl.getUrl());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}, and {@link AdaptiveCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdaptiveCard#equals(Object)}
   *   <li>{@link AdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test AdaptiveCard equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdaptiveCard adaptiveCard = new AdaptiveCard();
    AdaptiveCard adaptiveCard2 = new AdaptiveCard();

    // Act and Assert
    assertEquals(adaptiveCard, adaptiveCard2);
    int expectedHashCodeResult = adaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, adaptiveCard2.hashCode());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}, and {@link AdaptiveCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdaptiveCard#equals(Object)}
   *   <li>{@link AdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test AdaptiveCard equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BackgroundImage backgroundImage =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    ArrayList<TextBlock> textBlocks = new ArrayList<>();
    AdaptiveCard adaptiveCard = new AdaptiveCard(backgroundImage, textBlocks, new ArrayList<>());
    BackgroundImage backgroundImage2 =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    ArrayList<TextBlock> textBlocks2 = new ArrayList<>();
    AdaptiveCard adaptiveCard2 = new AdaptiveCard(backgroundImage2, textBlocks2, new ArrayList<>());

    // Act and Assert
    assertEquals(adaptiveCard, adaptiveCard2);
    int expectedHashCodeResult = adaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, adaptiveCard2.hashCode());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}, and {@link AdaptiveCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdaptiveCard#equals(Object)}
   *   <li>{@link AdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test AdaptiveCard equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdaptiveCard adaptiveCard = new AdaptiveCard();

    // Act and Assert
    assertEquals(adaptiveCard, adaptiveCard);
    int expectedHashCodeResult = adaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, adaptiveCard.hashCode());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BackgroundImage backgroundImage =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    ArrayList<TextBlock> textBlocks = new ArrayList<>();
    AdaptiveCard adaptiveCard = new AdaptiveCard(backgroundImage, textBlocks, new ArrayList<>());

    // Act and Assert
    assertNotEquals(adaptiveCard, new AdaptiveCard());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdaptiveCard adaptiveCard = new AdaptiveCard();
    BackgroundImage backgroundImage =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    ArrayList<TextBlock> textBlocks = new ArrayList<>();

    // Act and Assert
    assertNotEquals(adaptiveCard, new AdaptiveCard(backgroundImage, textBlocks, new ArrayList<>()));
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<TextBlock> textBlocks = new ArrayList<>();
    textBlocks.add(
        new TextBlock(
            "http://adaptivecards.io/schemas/adaptive-card.json",
            "http://adaptivecards.io/schemas/adaptive-card.json",
            "http://adaptivecards.io/schemas/adaptive-card.json",
            "http://adaptivecards.io/schemas/adaptive-card.json",
            "http://adaptivecards.io/schemas/adaptive-card.json"));
    BackgroundImage backgroundImage =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    AdaptiveCard adaptiveCard = new AdaptiveCard(backgroundImage, textBlocks, new ArrayList<>());
    BackgroundImage backgroundImage2 =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    ArrayList<TextBlock> textBlocks2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        adaptiveCard, new AdaptiveCard(backgroundImage2, textBlocks2, new ArrayList<>()));
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<ActionOpenUrl> actions = new ArrayList<>();
    actions.add(new ActionOpenUrl("Dr", "https://example.org/example"));
    BackgroundImage backgroundImage =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    AdaptiveCard adaptiveCard = new AdaptiveCard(backgroundImage, new ArrayList<>(), actions);
    BackgroundImage backgroundImage2 =
        new BackgroundImage("http://adaptivecards.io/schemas/adaptive-card.json");
    ArrayList<TextBlock> textBlocks = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        adaptiveCard, new AdaptiveCard(backgroundImage2, textBlocks, new ArrayList<>()));
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdaptiveCard(), null);
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AdaptiveCard.equals(Object)", "int AdaptiveCard.hashCode()"})
  void testAdaptiveCardEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdaptiveCard(), "Different type to AdaptiveCard");
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#getSchema()}.
   *
   * <p>Method under test: {@link AdaptiveCard#getSchema()}
   */
  @Test
  @DisplayName("Test AdaptiveCard getSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdaptiveCard.getSchema()"})
  void testAdaptiveCardGetSchema() {
    // Arrange, Act and Assert
    assertEquals("http://adaptivecards.io/schemas/adaptive-card.json", adaptiveCard.getSchema());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#getType()}.
   *
   * <p>Method under test: {@link AdaptiveCard#getType()}
   */
  @Test
  @DisplayName("Test AdaptiveCard getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdaptiveCard.getType()"})
  void testAdaptiveCardGetType() {
    // Arrange, Act and Assert
    assertEquals("AdaptiveCard", adaptiveCard.getType());
  }

  /**
   * Test AdaptiveCard getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdaptiveCard#AdaptiveCard()}
   *   <li>{@link AdaptiveCard#setActions(List)}
   *   <li>{@link AdaptiveCard#setBackgroundImage(BackgroundImage)}
   *   <li>{@link AdaptiveCard#setTextBlocks(List)}
   *   <li>{@link AdaptiveCard#toString()}
   *   <li>{@link AdaptiveCard#getActions()}
   *   <li>{@link AdaptiveCard#getBackgroundImage()}
   *   <li>{@link AdaptiveCard#getTextBlocks()}
   * </ul>
   */
  @Test
  @DisplayName("Test AdaptiveCard getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AdaptiveCard.<init>()",
    "void AdaptiveCard.<init>(BackgroundImage, List, List)",
    "List AdaptiveCard.getActions()",
    "BackgroundImage AdaptiveCard.getBackgroundImage()",
    "List AdaptiveCard.getTextBlocks()",
    "void AdaptiveCard.setActions(List)",
    "void AdaptiveCard.setBackgroundImage(BackgroundImage)",
    "void AdaptiveCard.setTextBlocks(List)",
    "String AdaptiveCard.toString()"
  })
  void testAdaptiveCardGettersAndSetters() {
    // Arrange and Act
    AdaptiveCard actualAdaptiveCard = new AdaptiveCard();
    ArrayList<ActionOpenUrl> actions = new ArrayList<>();
    actualAdaptiveCard.setActions(actions);
    BackgroundImage backgroundImage = new BackgroundImage("Color");
    actualAdaptiveCard.setBackgroundImage(backgroundImage);
    ArrayList<TextBlock> textBlocks = new ArrayList<>();
    actualAdaptiveCard.setTextBlocks(textBlocks);
    String actualToStringResult = actualAdaptiveCard.toString();
    List<ActionOpenUrl> actualActions = actualAdaptiveCard.getActions();
    BackgroundImage actualBackgroundImage = actualAdaptiveCard.getBackgroundImage();
    List<TextBlock> actualTextBlocks = actualAdaptiveCard.getTextBlocks();

    // Assert
    assertEquals(
        "TeamsAdaptiveCard.AdaptiveCard(schema=http://adaptivecards.io/schemas/adaptive-card.json, type=AdaptiveCard,"
            + " backgroundImage=TeamsAdaptiveCard.BackgroundImage(url=null, fillMode=repeat), textBlocks=[],"
            + " actions=[])",
        actualToStringResult);
    assertTrue(actualActions.isEmpty());
    assertTrue(actualTextBlocks.isEmpty());
    assertSame(actions, actualActions);
    assertSame(textBlocks, actualTextBlocks);
    assertSame(backgroundImage, actualBackgroundImage);
  }

  /**
   * Test AdaptiveCard getters and setters.
   *
   * <ul>
   *   <li>When {@link BackgroundImage#BackgroundImage(String)} with {@code Color}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdaptiveCard#AdaptiveCard(BackgroundImage, List, List)}
   *   <li>{@link AdaptiveCard#setActions(List)}
   *   <li>{@link AdaptiveCard#setBackgroundImage(BackgroundImage)}
   *   <li>{@link AdaptiveCard#setTextBlocks(List)}
   *   <li>{@link AdaptiveCard#toString()}
   *   <li>{@link AdaptiveCard#getActions()}
   *   <li>{@link AdaptiveCard#getBackgroundImage()}
   *   <li>{@link AdaptiveCard#getTextBlocks()}
   * </ul>
   */
  @Test
  @DisplayName("Test AdaptiveCard getters and setters; when BackgroundImage(String) with 'Color'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AdaptiveCard.<init>()",
    "void AdaptiveCard.<init>(BackgroundImage, List, List)",
    "List AdaptiveCard.getActions()",
    "BackgroundImage AdaptiveCard.getBackgroundImage()",
    "List AdaptiveCard.getTextBlocks()",
    "void AdaptiveCard.setActions(List)",
    "void AdaptiveCard.setBackgroundImage(BackgroundImage)",
    "void AdaptiveCard.setTextBlocks(List)",
    "String AdaptiveCard.toString()"
  })
  void testAdaptiveCardGettersAndSetters_whenBackgroundImageWithColor() {
    // Arrange
    BackgroundImage backgroundImage = new BackgroundImage("Color");
    ArrayList<TextBlock> textBlocks = new ArrayList<>();

    // Act
    AdaptiveCard actualAdaptiveCard =
        new AdaptiveCard(backgroundImage, textBlocks, new ArrayList<>());
    ArrayList<ActionOpenUrl> actions = new ArrayList<>();
    actualAdaptiveCard.setActions(actions);
    BackgroundImage backgroundImage2 = new BackgroundImage("Color");
    actualAdaptiveCard.setBackgroundImage(backgroundImage2);
    ArrayList<TextBlock> textBlocks2 = new ArrayList<>();
    actualAdaptiveCard.setTextBlocks(textBlocks2);
    String actualToStringResult = actualAdaptiveCard.toString();
    List<ActionOpenUrl> actualActions = actualAdaptiveCard.getActions();
    BackgroundImage actualBackgroundImage = actualAdaptiveCard.getBackgroundImage();
    List<TextBlock> actualTextBlocks = actualAdaptiveCard.getTextBlocks();

    // Assert
    assertEquals(
        "TeamsAdaptiveCard.AdaptiveCard(schema=http://adaptivecards.io/schemas/adaptive-card.json, type=AdaptiveCard,"
            + " backgroundImage=TeamsAdaptiveCard.BackgroundImage(url=null, fillMode=repeat), textBlocks=[],"
            + " actions=[])",
        actualToStringResult);
    assertTrue(actualActions.isEmpty());
    assertTrue(actualTextBlocks.isEmpty());
    assertSame(actions, actualActions);
    assertSame(textBlocks2, actualTextBlocks);
    assertSame(backgroundImage2, actualBackgroundImage);
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}, and {@link Attachment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Attachment#equals(Object)}
   *   <li>{@link Attachment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Attachment equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Attachment attachment = new Attachment();
    Attachment attachment2 = new Attachment();

    // Act and Assert
    assertEquals(attachment, attachment2);
    int expectedHashCodeResult = attachment.hashCode();
    assertEquals(expectedHashCodeResult, attachment2.hashCode());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}, and {@link Attachment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Attachment#equals(Object)}
   *   <li>{@link Attachment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Attachment equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Attachment attachment = new Attachment("text/plain", new AdaptiveCard());
    Attachment attachment2 = new Attachment("text/plain", new AdaptiveCard());

    // Act and Assert
    assertEquals(attachment, attachment2);
    int expectedHashCodeResult = attachment.hashCode();
    assertEquals(expectedHashCodeResult, attachment2.hashCode());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}, and {@link Attachment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Attachment#equals(Object)}
   *   <li>{@link Attachment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test Attachment equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Attachment attachment = new Attachment();

    // Act and Assert
    assertEquals(attachment, attachment);
    int expectedHashCodeResult = attachment.hashCode();
    assertEquals(expectedHashCodeResult, attachment.hashCode());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Attachment attachment = new Attachment("text/plain", new AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, new Attachment());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Attachment attachment = new Attachment();
    attachment.setContent(new AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, new Attachment());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Attachment attachment = new Attachment(null, new AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, new Attachment());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Attachment attachment = new Attachment();

    Attachment attachment2 = new Attachment();
    attachment2.setContent(new AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, attachment2);
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Attachment(), null);
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Attachment.equals(Object)", "int Attachment.hashCode()"})
  void testAttachmentEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Attachment(), "Different type to Attachment");
  }

  /**
   * Test Attachment getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Attachment#Attachment()}
   *   <li>{@link Attachment#setContent(AdaptiveCard)}
   *   <li>{@link Attachment#setContentType(String)}
   *   <li>{@link Attachment#toString()}
   *   <li>{@link Attachment#getContent()}
   *   <li>{@link Attachment#getContentType()}
   * </ul>
   */
  @Test
  @DisplayName("Test Attachment getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Attachment.<init>()",
    "void Attachment.<init>(String, AdaptiveCard)",
    "AdaptiveCard Attachment.getContent()",
    "String Attachment.getContentType()",
    "void Attachment.setContent(AdaptiveCard)",
    "void Attachment.setContentType(String)",
    "String Attachment.toString()"
  })
  void testAttachmentGettersAndSetters() {
    // Arrange and Act
    Attachment actualAttachment = new Attachment();
    AdaptiveCard content = new AdaptiveCard();
    actualAttachment.setContent(content);
    actualAttachment.setContentType("text/plain");
    String actualToStringResult = actualAttachment.toString();
    AdaptiveCard actualContent = actualAttachment.getContent();

    // Assert
    assertEquals(
        "TeamsAdaptiveCard.Attachment(contentType=text/plain, content=TeamsAdaptiveCard.AdaptiveCard(schema"
            + "=http://adaptivecards.io/schemas/adaptive-card.json, type=AdaptiveCard, backgroundImage=null,"
            + " textBlocks=[], actions=[]))",
        actualToStringResult);
    assertEquals("text/plain", actualAttachment.getContentType());
    assertSame(content, actualContent);
  }

  /**
   * Test Attachment getters and setters.
   *
   * <ul>
   *   <li>When {@code text/plain}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Attachment#Attachment(String, AdaptiveCard)}
   *   <li>{@link Attachment#setContent(AdaptiveCard)}
   *   <li>{@link Attachment#setContentType(String)}
   *   <li>{@link Attachment#toString()}
   *   <li>{@link Attachment#getContent()}
   *   <li>{@link Attachment#getContentType()}
   * </ul>
   */
  @Test
  @DisplayName("Test Attachment getters and setters; when 'text/plain'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Attachment.<init>()",
    "void Attachment.<init>(String, AdaptiveCard)",
    "AdaptiveCard Attachment.getContent()",
    "String Attachment.getContentType()",
    "void Attachment.setContent(AdaptiveCard)",
    "void Attachment.setContentType(String)",
    "String Attachment.toString()"
  })
  void testAttachmentGettersAndSetters_whenTextPlain() {
    // Arrange and Act
    Attachment actualAttachment = new Attachment("text/plain", new AdaptiveCard());
    AdaptiveCard content = new AdaptiveCard();
    actualAttachment.setContent(content);
    actualAttachment.setContentType("text/plain");
    String actualToStringResult = actualAttachment.toString();
    AdaptiveCard actualContent = actualAttachment.getContent();

    // Assert
    assertEquals(
        "TeamsAdaptiveCard.Attachment(contentType=text/plain, content=TeamsAdaptiveCard.AdaptiveCard(schema"
            + "=http://adaptivecards.io/schemas/adaptive-card.json, type=AdaptiveCard, backgroundImage=null,"
            + " textBlocks=[], actions=[]))",
        actualToStringResult);
    assertEquals("text/plain", actualAttachment.getContentType());
    assertSame(content, actualContent);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}, and {@link
   * BackgroundImage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackgroundImage#equals(Object)}
   *   <li>{@link BackgroundImage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test BackgroundImage equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BackgroundImage backgroundImage = new BackgroundImage("Color");
    BackgroundImage backgroundImage2 = new BackgroundImage("Color");

    // Act and Assert
    assertEquals(backgroundImage, backgroundImage2);
    int expectedHashCodeResult = backgroundImage.hashCode();
    assertEquals(expectedHashCodeResult, backgroundImage2.hashCode());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}, and {@link
   * BackgroundImage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackgroundImage#equals(Object)}
   *   <li>{@link BackgroundImage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test BackgroundImage equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BackgroundImage backgroundImage = new BackgroundImage("Color");
    backgroundImage.setUrl("https://example.org/example");

    BackgroundImage backgroundImage2 = new BackgroundImage("Color");
    backgroundImage2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(backgroundImage, backgroundImage2);
    int expectedHashCodeResult = backgroundImage.hashCode();
    assertEquals(expectedHashCodeResult, backgroundImage2.hashCode());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}, and {@link
   * BackgroundImage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackgroundImage#equals(Object)}
   *   <li>{@link BackgroundImage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test BackgroundImage equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BackgroundImage backgroundImage = new BackgroundImage("Color");

    // Act and Assert
    assertEquals(backgroundImage, backgroundImage);
    int expectedHashCodeResult = backgroundImage.hashCode();
    assertEquals(expectedHashCodeResult, backgroundImage.hashCode());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test BackgroundImage equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BackgroundImage("Color"), 1);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test BackgroundImage equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BackgroundImage backgroundImage = new BackgroundImage("Color");
    backgroundImage.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(backgroundImage, new BackgroundImage("Color"));
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test BackgroundImage equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BackgroundImage backgroundImage = new BackgroundImage("Color");

    BackgroundImage backgroundImage2 = new BackgroundImage("Color");
    backgroundImage2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(backgroundImage, backgroundImage2);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BackgroundImage("Color"), null);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test BackgroundImage equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackgroundImage.equals(Object)", "int BackgroundImage.hashCode()"})
  void testBackgroundImageEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BackgroundImage("Color"), "Different type to BackgroundImage");
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#getFillMode()}.
   *
   * <p>Method under test: {@link BackgroundImage#getFillMode()}
   */
  @Test
  @DisplayName("Test BackgroundImage getFillMode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BackgroundImage.getFillMode()"})
  void testBackgroundImageGetFillMode() {
    // Arrange, Act and Assert
    assertEquals("repeat", backgroundImage.getFillMode());
  }

  /**
   * Test BackgroundImage getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackgroundImage#BackgroundImage()}
   *   <li>{@link BackgroundImage#setUrl(String)}
   *   <li>{@link BackgroundImage#toString()}
   *   <li>{@link BackgroundImage#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test BackgroundImage getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void BackgroundImage.<init>()",
    "String BackgroundImage.getUrl()",
    "void BackgroundImage.setUrl(String)",
    "String BackgroundImage.toString()"
  })
  void testBackgroundImageGettersAndSetters() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage();
    actualBackgroundImage.setUrl("https://example.org/example");
    String actualToStringResult = actualBackgroundImage.toString();

    // Assert
    assertEquals(
        "TeamsAdaptiveCard.BackgroundImage(url=https://example.org/example, fillMode=repeat)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage3() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage4() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "hslorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage5() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbrepeatFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage6() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgbrepeatorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage7() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgb#Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage8() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgb#org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage9() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbrgbFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage10() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgbrgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage11() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbhslFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage12() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgbhslorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage13() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbFailed to generate embedded image for color: {}repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage14() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbFailed to generate embedded image for color: {}#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage15() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbFailed to generate embedded image for color: {}rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage16() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbFailed to generate embedded image for color: {}hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage17() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgbFailed to generate embedded image for color: {}Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage18() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbFailed to generate embedded image for color: {}Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage19() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbFailed to generate embedded image for color: {}42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage20() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgbColorFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage21() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgbColororg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage22() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImagerepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage23() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage24() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImagergb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage25() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImagehsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage26() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImageColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage27() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage28() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("rgb42Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage29() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgb42org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage30() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslrepeatFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage31() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "hslrepeatorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage32() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hsl#Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage33() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "hsl#org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage34() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslrgbFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage35() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "hslrgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage36() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslhslFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage37() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "hslhslorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage38() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslFailed to generate embedded image for color: {}repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage39() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslFailed to generate embedded image for color: {}#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage40() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslFailed to generate embedded image for color: {}rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage41() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslFailed to generate embedded image for color: {}hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "hslFailed to generate embedded image for color: {}Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage43() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslFailed to generate embedded image for color: {}Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage44() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage("hslFailed to generate embedded image for color: {}42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When a string.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenAString() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgbFailed to generate embedded image for color: {}org.thingsboard.server.service.notification.channels"
                + ".TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When a string.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenAString2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImageFailed to"
                + " generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When a string.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenAString3() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImageorg.thingsboard"
                + ".server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When a string.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenAString4() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage =
        new BackgroundImage(
            "hslFailed to generate embedded image for color: {}org.thingsboard.server.service.notification.channels"
                + ".TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'Color'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHsl2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl##}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl##'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHsl3() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl##");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHsl42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl#42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHsl422() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl#42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl#Color}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#Color'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslColor2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl#Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslColor#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColor#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslColor3() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslColor#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslColorhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColorhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslColorhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslColorhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslColorrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColorrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslColorrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslColorrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslColorrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColorrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslColorrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslColorrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl#hsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#hsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslHsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl#hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl#repeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#repeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslRepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl#repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hsl#rgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#rgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslRgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hsl#rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslhsl#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhsl#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslhsl2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslhsl#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslhsl42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhsl42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslhsl42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslhsl42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslhslColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslhslColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslhslColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslhslhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslhslhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslhslhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslhslrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslhslrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslhslrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslhslrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslhslrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslhslrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrepeat#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeat#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrepeat2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrepeat#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrepeat42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeat42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrepeat42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrepeat42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrepeatColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeatColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrepeatColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrepeatColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrepeathsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeathsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrepeathsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrepeathsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrepeatrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeatrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrepeatrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrepeatrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrepeatrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeatrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrepeatrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrepeatrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgb#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgb#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrgb2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrgb#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgb42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgb42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrgb42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrgb42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgbColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrgbColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrgbColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgbhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrgbhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrgbhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgbrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrgbrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrgbrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgbrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenHslrgbrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("hslrgbrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code #}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenNumberSign() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb##}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb##'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb3() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb##");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb42Color}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42Color'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb42Color() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb42Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb42hsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42hsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb42hsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb42hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb42repeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42repeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb42repeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb42repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb42rgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42rgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb42rgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb42rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb#42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb422() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb#42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb42#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb423() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb42#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb4242}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgb4242() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb4242");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb#Color}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#Color'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColor2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb#Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColor#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColor#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColor3() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbColor#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColor42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColor42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColor42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbColor42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColorColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColorColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbColorColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColorhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColorhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbColorhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColorrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColorrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbColorrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColorrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbColorrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbColorrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb#hsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#hsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbHsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb#hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb#repeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#repeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbRepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb#repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgb#rgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#rgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbRgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgb#rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhsl#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhsl#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbhsl2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbhsl#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhsl42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhsl42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbhsl42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbhsl42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhslColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbhslColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbhslColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhslhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbhslhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbhslhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhslrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbhslrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbhslrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhslrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbhslrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbhslrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrepeat#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeat#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrepeat2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrepeat#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrepeat42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeat42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrepeat42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrepeat42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrepeatColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeatColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrepeatColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrepeatColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrepeathsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeathsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrepeathsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrepeathsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrepeatrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeatrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrepeatrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrepeatrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrepeatrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeatrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrepeatrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrepeatrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgb#}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgb#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrgb2() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrgb#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgb42}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgb42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrgb42() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrgb42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgbColor}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbColor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrgbColor() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrgbColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgbhsl}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbhsl'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrgbhsl() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrgbhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgbrepeat}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbrepeat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrgbrepeat() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrgbrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgbrgb}.
   * </ul>
   *
   * <p>Method under test: {@link BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbrgb'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackgroundImage.<init>(String)"})
  void testBackgroundImageNewBackgroundImage_whenRgbrgbrgb() {
    // Arrange and Act
    BackgroundImage actualBackgroundImage = new BackgroundImage("rgbrgbrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}, and {@link TeamsAdaptiveCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard();
    TeamsAdaptiveCard teamsAdaptiveCard2 = new TeamsAdaptiveCard();

    // Act and Assert
    assertEquals(teamsAdaptiveCard, teamsAdaptiveCard2);
    int expectedHashCodeResult = teamsAdaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, teamsAdaptiveCard2.hashCode());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}, and {@link TeamsAdaptiveCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard("message", new ArrayList<>());
    TeamsAdaptiveCard teamsAdaptiveCard2 = new TeamsAdaptiveCard("message", new ArrayList<>());

    // Act and Assert
    assertEquals(teamsAdaptiveCard, teamsAdaptiveCard2);
    int expectedHashCodeResult = teamsAdaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, teamsAdaptiveCard2.hashCode());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}, and {@link TeamsAdaptiveCard#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard();

    // Act and Assert
    assertEquals(teamsAdaptiveCard, teamsAdaptiveCard);
    int expectedHashCodeResult = teamsAdaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, teamsAdaptiveCard.hashCode());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard("message", new ArrayList<>());

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard();

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard("message", new ArrayList<>()));
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard("Type", new ArrayList<>());

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard(null, new ArrayList<>());

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard(), null);
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TeamsAdaptiveCard.equals(Object)",
    "int TeamsAdaptiveCard.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard(), "Different type to TeamsAdaptiveCard");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#TeamsAdaptiveCard()}
   *   <li>{@link TeamsAdaptiveCard#setAttachments(List)}
   *   <li>{@link TeamsAdaptiveCard#setType(String)}
   *   <li>{@link TeamsAdaptiveCard#toString()}
   *   <li>{@link TeamsAdaptiveCard#getAttachments()}
   *   <li>{@link TeamsAdaptiveCard#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TeamsAdaptiveCard.<init>()",
    "void TeamsAdaptiveCard.<init>(String, List)",
    "List TeamsAdaptiveCard.getAttachments()",
    "String TeamsAdaptiveCard.getType()",
    "void TeamsAdaptiveCard.setAttachments(List)",
    "void TeamsAdaptiveCard.setType(String)",
    "String TeamsAdaptiveCard.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsAdaptiveCard actualTeamsAdaptiveCard = new TeamsAdaptiveCard();
    ArrayList<Attachment> attachments = new ArrayList<>();
    actualTeamsAdaptiveCard.setAttachments(attachments);
    actualTeamsAdaptiveCard.setType("Type");
    String actualToStringResult = actualTeamsAdaptiveCard.toString();
    List<Attachment> actualAttachments = actualTeamsAdaptiveCard.getAttachments();

    // Assert
    assertEquals("TeamsAdaptiveCard(type=Type, attachments=[])", actualToStringResult);
    assertEquals("Type", actualTeamsAdaptiveCard.getType());
    assertTrue(actualAttachments.isEmpty());
    assertSame(attachments, actualAttachments);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#TeamsAdaptiveCard(String, List)}
   *   <li>{@link TeamsAdaptiveCard#setAttachments(List)}
   *   <li>{@link TeamsAdaptiveCard#setType(String)}
   *   <li>{@link TeamsAdaptiveCard#toString()}
   *   <li>{@link TeamsAdaptiveCard#getAttachments()}
   *   <li>{@link TeamsAdaptiveCard#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TeamsAdaptiveCard.<init>()",
    "void TeamsAdaptiveCard.<init>(String, List)",
    "List TeamsAdaptiveCard.getAttachments()",
    "String TeamsAdaptiveCard.getType()",
    "void TeamsAdaptiveCard.setAttachments(List)",
    "void TeamsAdaptiveCard.setType(String)",
    "String TeamsAdaptiveCard.toString()"
  })
  void testGettersAndSetters_whenType() {
    // Arrange and Act
    TeamsAdaptiveCard actualTeamsAdaptiveCard = new TeamsAdaptiveCard("Type", new ArrayList<>());
    ArrayList<Attachment> attachments = new ArrayList<>();
    actualTeamsAdaptiveCard.setAttachments(attachments);
    actualTeamsAdaptiveCard.setType("Type");
    String actualToStringResult = actualTeamsAdaptiveCard.toString();
    List<Attachment> actualAttachments = actualTeamsAdaptiveCard.getAttachments();

    // Assert
    assertEquals("TeamsAdaptiveCard(type=Type, attachments=[])", actualToStringResult);
    assertEquals("Type", actualTeamsAdaptiveCard.getType());
    assertTrue(actualAttachments.isEmpty());
    assertSame(attachments, actualAttachments);
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and {@link TextBlock#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#equals(Object)}
   *   <li>{@link TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "Size", "Spacing", "Color");
    TextBlock textBlock2 = new TextBlock("Text", "Weight", "Size", "Spacing", "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and {@link TextBlock#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#equals(Object)}
   *   <li>{@link TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TextBlock textBlock = new TextBlock(null, "Weight", "Size", "Spacing", "Color");
    TextBlock textBlock2 = new TextBlock(null, "Weight", "Size", "Spacing", "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and {@link TextBlock#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#equals(Object)}
   *   <li>{@link TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", null, "Size", "Spacing", "Color");
    TextBlock textBlock2 = new TextBlock("Text", null, "Size", "Spacing", "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and {@link TextBlock#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#equals(Object)}
   *   <li>{@link TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", null, "Spacing", "Color");
    TextBlock textBlock2 = new TextBlock("Text", "Weight", null, "Spacing", "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and {@link TextBlock#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#equals(Object)}
   *   <li>{@link TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "Size", null, "Color");
    TextBlock textBlock2 = new TextBlock("Text", "Weight", "Size", null, "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and {@link TextBlock#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#equals(Object)}
   *   <li>{@link TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TextBlock equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "Size", "Spacing", "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TextBlock textBlock = new TextBlock("TextBlock", "Weight", "Size", "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TextBlock textBlock = new TextBlock(null, "Weight", "Size", "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "TextBlock", "Size", "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", null, "Size", "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "TextBlock", "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", null, "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "Size", "TextBlock", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "Size", null, "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "Size", "Spacing", "TextBlock");

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TextBlock textBlock = new TextBlock("Text", "Weight", "Size", "Spacing", null);

    // Act and Assert
    assertNotEquals(textBlock, new TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TextBlock("Text", "Weight", "Size", "Spacing", "Color"), null);
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.equals(Object)", "int TextBlock.hashCode()"})
  void testTextBlockEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TextBlock("Text", "Weight", "Size", "Spacing", "Color"), "Different type to TextBlock");
  }

  /**
   * Test TextBlock {@link TextBlock#getType()}.
   *
   * <p>Method under test: {@link TextBlock#getType()}
   */
  @Test
  @DisplayName("Test TextBlock getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TextBlock.getType()"})
  void testTextBlockGetType() {
    // Arrange, Act and Assert
    assertEquals("TextBlock", textBlock.getType());
  }

  /**
   * Test TextBlock getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#TextBlock()}
   *   <li>{@link TextBlock#setColor(String)}
   *   <li>{@link TextBlock#setSize(String)}
   *   <li>{@link TextBlock#setSpacing(String)}
   *   <li>{@link TextBlock#setText(String)}
   *   <li>{@link TextBlock#setWeight(String)}
   *   <li>{@link TextBlock#toString()}
   *   <li>{@link TextBlock#getColor()}
   *   <li>{@link TextBlock#getSize()}
   *   <li>{@link TextBlock#getSpacing()}
   *   <li>{@link TextBlock#getText()}
   *   <li>{@link TextBlock#getWeight()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TextBlock.<init>()",
    "void TextBlock.<init>(String, String, String, String, String)",
    "String TextBlock.getColor()",
    "String TextBlock.getSize()",
    "String TextBlock.getSpacing()",
    "String TextBlock.getText()",
    "String TextBlock.getWeight()",
    "void TextBlock.setColor(String)",
    "void TextBlock.setSize(String)",
    "void TextBlock.setSpacing(String)",
    "void TextBlock.setText(String)",
    "void TextBlock.setWeight(String)",
    "String TextBlock.toString()"
  })
  void testTextBlockGettersAndSetters() {
    // Arrange and Act
    TextBlock actualTextBlock = new TextBlock();
    actualTextBlock.setColor("Color");
    actualTextBlock.setSize("Size");
    actualTextBlock.setSpacing("Spacing");
    actualTextBlock.setText("Text");
    actualTextBlock.setWeight("Weight");
    String actualToStringResult = actualTextBlock.toString();
    String actualColor = actualTextBlock.getColor();
    String actualSize = actualTextBlock.getSize();
    String actualSpacing = actualTextBlock.getSpacing();
    String actualText = actualTextBlock.getText();

    // Assert
    assertEquals("Color", actualColor);
    assertEquals("Size", actualSize);
    assertEquals("Spacing", actualSpacing);
    assertEquals(
        "TeamsAdaptiveCard.TextBlock(type=TextBlock, text=Text, weight=Weight, size=Size, spacing=Spacing,"
            + " color=Color, wrap=true)",
        actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals("Weight", actualTextBlock.getWeight());
  }

  /**
   * Test TextBlock getters and setters.
   *
   * <ul>
   *   <li>When {@code Text}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextBlock#TextBlock(String, String, String, String, String)}
   *   <li>{@link TextBlock#setColor(String)}
   *   <li>{@link TextBlock#setSize(String)}
   *   <li>{@link TextBlock#setSpacing(String)}
   *   <li>{@link TextBlock#setText(String)}
   *   <li>{@link TextBlock#setWeight(String)}
   *   <li>{@link TextBlock#toString()}
   *   <li>{@link TextBlock#getColor()}
   *   <li>{@link TextBlock#getSize()}
   *   <li>{@link TextBlock#getSpacing()}
   *   <li>{@link TextBlock#getText()}
   *   <li>{@link TextBlock#getWeight()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock getters and setters; when 'Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TextBlock.<init>()",
    "void TextBlock.<init>(String, String, String, String, String)",
    "String TextBlock.getColor()",
    "String TextBlock.getSize()",
    "String TextBlock.getSpacing()",
    "String TextBlock.getText()",
    "String TextBlock.getWeight()",
    "void TextBlock.setColor(String)",
    "void TextBlock.setSize(String)",
    "void TextBlock.setSpacing(String)",
    "void TextBlock.setText(String)",
    "void TextBlock.setWeight(String)",
    "String TextBlock.toString()"
  })
  void testTextBlockGettersAndSetters_whenText() {
    // Arrange and Act
    TextBlock actualTextBlock = new TextBlock("Text", "Weight", "Size", "Spacing", "Color");
    actualTextBlock.setColor("Color");
    actualTextBlock.setSize("Size");
    actualTextBlock.setSpacing("Spacing");
    actualTextBlock.setText("Text");
    actualTextBlock.setWeight("Weight");
    String actualToStringResult = actualTextBlock.toString();
    String actualColor = actualTextBlock.getColor();
    String actualSize = actualTextBlock.getSize();
    String actualSpacing = actualTextBlock.getSpacing();
    String actualText = actualTextBlock.getText();

    // Assert
    assertEquals("Color", actualColor);
    assertEquals("Size", actualSize);
    assertEquals("Spacing", actualSpacing);
    assertEquals(
        "TeamsAdaptiveCard.TextBlock(type=TextBlock, text=Text, weight=Weight, size=Size, spacing=Spacing,"
            + " color=Color, wrap=true)",
        actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals("Weight", actualTextBlock.getWeight());
  }

  /**
   * Test TextBlock {@link TextBlock#isWrap()}.
   *
   * <p>Method under test: {@link TextBlock#isWrap()}
   */
  @Test
  @DisplayName("Test TextBlock isWrap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TextBlock.isWrap()"})
  void testTextBlockIsWrap() {
    // Arrange, Act and Assert
    assertTrue(textBlock.isWrap());
  }
}
