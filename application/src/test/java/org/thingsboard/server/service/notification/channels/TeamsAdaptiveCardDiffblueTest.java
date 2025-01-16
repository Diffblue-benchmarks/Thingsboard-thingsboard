package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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

@ContextConfiguration(classes = {TeamsAdaptiveCard.ActionOpenUrl.class, TeamsAdaptiveCard.AdaptiveCard.class,
    TeamsAdaptiveCard.BackgroundImage.class, TeamsAdaptiveCard.TextBlock.class})
@ExtendWith(SpringExtension.class)
class TeamsAdaptiveCardDiffblueTest {
  @Autowired
  private TeamsAdaptiveCard.TextBlock textBlock;

  @Autowired
  private TeamsAdaptiveCard.BackgroundImage backgroundImage;

  @Autowired
  private TeamsAdaptiveCard.AdaptiveCard adaptiveCard;

  @Autowired
  private TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl;

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and
   * {@link ActionOpenUrl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl("Dr",
        "https://example.org/example");
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl2 = new TeamsAdaptiveCard.ActionOpenUrl("Dr",
        "https://example.org/example");

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl2);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl2.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and
   * {@link ActionOpenUrl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl(null,
        "https://example.org/example");
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl2 = new TeamsAdaptiveCard.ActionOpenUrl(null,
        "https://example.org/example");

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl2);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl2.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and
   * {@link ActionOpenUrl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object), and hashCode(); when other is equal; then return equal")
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl("Dr", null);
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl2 = new TeamsAdaptiveCard.ActionOpenUrl("Dr", null);

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl2);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl2.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}, and
   * {@link ActionOpenUrl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object), and hashCode(); when other is same; then return equal")
  void testActionOpenUrlEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl("Dr",
        "https://example.org/example");

    // Act and Assert
    assertEquals(actionOpenUrl, actionOpenUrl);
    int expectedHashCodeResult = actionOpenUrl.hashCode();
    assertEquals(expectedHashCodeResult, actionOpenUrl.hashCode());
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl("Mr",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(actionOpenUrl, new TeamsAdaptiveCard.ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl(null,
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(actionOpenUrl, new TeamsAdaptiveCard.ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl("Dr", "Action.OpenUrl");

    // Act and Assert
    assertNotEquals(actionOpenUrl, new TeamsAdaptiveCard.ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is different; then return not equal")
  void testActionOpenUrlEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsAdaptiveCard.ActionOpenUrl actionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl("Dr", null);

    // Act and Assert
    assertNotEquals(actionOpenUrl, new TeamsAdaptiveCard.ActionOpenUrl("Dr", "https://example.org/example"));
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is 'null'; then return not equal")
  void testActionOpenUrlEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.ActionOpenUrl("Dr", "https://example.org/example"), null);
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.ActionOpenUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test ActionOpenUrl equals(Object); when other is wrong type; then return not equal")
  void testActionOpenUrlEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.ActionOpenUrl("Dr", "https://example.org/example"),
        "Different type to ActionOpenUrl");
  }

  /**
   * Test ActionOpenUrl {@link ActionOpenUrl#getType()}.
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.ActionOpenUrl#getType()}
   */
  @Test
  @DisplayName("Test ActionOpenUrl getType()")
  void testActionOpenUrlGetType() {
    // Arrange, Act and Assert
    assertEquals("Action.OpenUrl", actionOpenUrl.getType());
  }

  /**
   * Test ActionOpenUrl getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#ActionOpenUrl()}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#setTitle(String)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#setUrl(String)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#toString()}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#getTitle()}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl getters and setters")
  void testActionOpenUrlGettersAndSetters() {
    // Arrange and Act
    TeamsAdaptiveCard.ActionOpenUrl actualActionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl();
    actualActionOpenUrl.setTitle("Dr");
    actualActionOpenUrl.setUrl("https://example.org/example");
    String actualToStringResult = actualActionOpenUrl.toString();
    String actualTitle = actualActionOpenUrl.getTitle();

    // Assert that nothing has changed
    assertEquals("Dr", actualTitle);
    assertEquals("TeamsAdaptiveCard.ActionOpenUrl(type=Action.OpenUrl, title=Dr, url=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualActionOpenUrl.getUrl());
  }

  /**
   * Test ActionOpenUrl getters and setters.
   * <ul>
   *   <li>When {@code Dr}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#ActionOpenUrl(String, String)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#setTitle(String)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#setUrl(String)}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#toString()}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#getTitle()}
   *   <li>{@link TeamsAdaptiveCard.ActionOpenUrl#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test ActionOpenUrl getters and setters; when 'Dr'")
  void testActionOpenUrlGettersAndSetters_whenDr() {
    // Arrange and Act
    TeamsAdaptiveCard.ActionOpenUrl actualActionOpenUrl = new TeamsAdaptiveCard.ActionOpenUrl("Dr",
        "https://example.org/example");
    actualActionOpenUrl.setTitle("Dr");
    actualActionOpenUrl.setUrl("https://example.org/example");
    String actualToStringResult = actualActionOpenUrl.toString();
    String actualTitle = actualActionOpenUrl.getTitle();

    // Assert that nothing has changed
    assertEquals("Dr", actualTitle);
    assertEquals("TeamsAdaptiveCard.ActionOpenUrl(type=Action.OpenUrl, title=Dr, url=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualActionOpenUrl.getUrl());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}, and
   * {@link AdaptiveCard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object), and hashCode(); when other is equal; then return equal")
  void testAdaptiveCardEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard();
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard2 = new TeamsAdaptiveCard.AdaptiveCard();

    // Act and Assert
    assertEquals(adaptiveCard, adaptiveCard2);
    int expectedHashCodeResult = adaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, adaptiveCard2.hashCode());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}, and
   * {@link AdaptiveCard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object), and hashCode(); when other is equal; then return equal")
  void testAdaptiveCardEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard(backgroundImage, textBlocks,
        new ArrayList<>());
    TeamsAdaptiveCard.BackgroundImage backgroundImage2 = new TeamsAdaptiveCard.BackgroundImage("Color");
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks2 = new ArrayList<>();
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard2 = new TeamsAdaptiveCard.AdaptiveCard(backgroundImage2, textBlocks2,
        new ArrayList<>());

    // Act and Assert
    assertEquals(adaptiveCard, adaptiveCard2);
    int expectedHashCodeResult = adaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, adaptiveCard2.hashCode());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}, and
   * {@link AdaptiveCard#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object), and hashCode(); when other is same; then return equal")
  void testAdaptiveCardEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard();

    // Act and Assert
    assertEquals(adaptiveCard, adaptiveCard);
    int expectedHashCodeResult = adaptiveCard.hashCode();
    assertEquals(expectedHashCodeResult, adaptiveCard.hashCode());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard(backgroundImage, textBlocks,
        new ArrayList<>());

    // Act and Assert
    assertNotEquals(adaptiveCard, new TeamsAdaptiveCard.AdaptiveCard());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard();
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();

    // Act and Assert
    assertNotEquals(adaptiveCard, new TeamsAdaptiveCard.AdaptiveCard(backgroundImage, textBlocks, new ArrayList<>()));
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = mock(TeamsAdaptiveCard.BackgroundImage.class);
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard(backgroundImage, textBlocks,
        new ArrayList<>());

    // Act and Assert
    assertNotEquals(adaptiveCard, new TeamsAdaptiveCard.AdaptiveCard());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();
    textBlocks.add(new TeamsAdaptiveCard.TextBlock("http://adaptivecards.io/schemas/adaptive-card.json",
        "http://adaptivecards.io/schemas/adaptive-card.json", "http://adaptivecards.io/schemas/adaptive-card.json",
        "http://adaptivecards.io/schemas/adaptive-card.json", "http://adaptivecards.io/schemas/adaptive-card.json"));
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard(backgroundImage, textBlocks,
        new ArrayList<>());
    TeamsAdaptiveCard.BackgroundImage backgroundImage2 = new TeamsAdaptiveCard.BackgroundImage("Color");
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(adaptiveCard, new TeamsAdaptiveCard.AdaptiveCard(backgroundImage2, textBlocks2, new ArrayList<>()));
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is different; then return not equal")
  void testAdaptiveCardEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<TeamsAdaptiveCard.ActionOpenUrl> actions = new ArrayList<>();
    actions.add(new TeamsAdaptiveCard.ActionOpenUrl("Dr", "https://example.org/example"));
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    TeamsAdaptiveCard.AdaptiveCard adaptiveCard = new TeamsAdaptiveCard.AdaptiveCard(backgroundImage, new ArrayList<>(),
        actions);
    TeamsAdaptiveCard.BackgroundImage backgroundImage2 = new TeamsAdaptiveCard.BackgroundImage("Color");
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();

    // Act and Assert
    assertNotEquals(adaptiveCard, new TeamsAdaptiveCard.AdaptiveCard(backgroundImage2, textBlocks, new ArrayList<>()));
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is 'null'; then return not equal")
  void testAdaptiveCardEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.AdaptiveCard(), null);
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test AdaptiveCard equals(Object); when other is wrong type; then return not equal")
  void testAdaptiveCardEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.AdaptiveCard(), "Different type to AdaptiveCard");
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#getSchema()}.
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#getSchema()}
   */
  @Test
  @DisplayName("Test AdaptiveCard getSchema()")
  void testAdaptiveCardGetSchema() {
    // Arrange, Act and Assert
    assertEquals("http://adaptivecards.io/schemas/adaptive-card.json", adaptiveCard.getSchema());
  }

  /**
   * Test AdaptiveCard {@link AdaptiveCard#getType()}.
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.AdaptiveCard#getType()}
   */
  @Test
  @DisplayName("Test AdaptiveCard getType()")
  void testAdaptiveCardGetType() {
    // Arrange, Act and Assert
    assertEquals("AdaptiveCard", adaptiveCard.getType());
  }

  /**
   * Test AdaptiveCard getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#AdaptiveCard()}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#setActions(List)}
   *   <li>
   * {@link TeamsAdaptiveCard.AdaptiveCard#setBackgroundImage(TeamsAdaptiveCard.BackgroundImage)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#setTextBlocks(List)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#toString()}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#getActions()}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#getBackgroundImage()}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#getTextBlocks()}
   * </ul>
   */
  @Test
  @DisplayName("Test AdaptiveCard getters and setters")
  void testAdaptiveCardGettersAndSetters() {
    // Arrange and Act
    TeamsAdaptiveCard.AdaptiveCard actualAdaptiveCard = new TeamsAdaptiveCard.AdaptiveCard();
    ArrayList<TeamsAdaptiveCard.ActionOpenUrl> actions = new ArrayList<>();
    actualAdaptiveCard.setActions(actions);
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    actualAdaptiveCard.setBackgroundImage(backgroundImage);
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();
    actualAdaptiveCard.setTextBlocks(textBlocks);
    String actualToStringResult = actualAdaptiveCard.toString();
    List<TeamsAdaptiveCard.ActionOpenUrl> actualActions = actualAdaptiveCard.getActions();
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = actualAdaptiveCard.getBackgroundImage();
    List<TeamsAdaptiveCard.TextBlock> actualTextBlocks = actualAdaptiveCard.getTextBlocks();

    // Assert that nothing has changed
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
   * <ul>
   *   <li>When {@link BackgroundImage#BackgroundImage(String)} with
   * {@code Color}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TeamsAdaptiveCard.AdaptiveCard#AdaptiveCard(TeamsAdaptiveCard.BackgroundImage, List, List)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#setActions(List)}
   *   <li>
   * {@link TeamsAdaptiveCard.AdaptiveCard#setBackgroundImage(TeamsAdaptiveCard.BackgroundImage)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#setTextBlocks(List)}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#toString()}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#getActions()}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#getBackgroundImage()}
   *   <li>{@link TeamsAdaptiveCard.AdaptiveCard#getTextBlocks()}
   * </ul>
   */
  @Test
  @DisplayName("Test AdaptiveCard getters and setters; when BackgroundImage(String) with 'Color'")
  void testAdaptiveCardGettersAndSetters_whenBackgroundImageWithColor() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks = new ArrayList<>();

    // Act
    TeamsAdaptiveCard.AdaptiveCard actualAdaptiveCard = new TeamsAdaptiveCard.AdaptiveCard(backgroundImage, textBlocks,
        new ArrayList<>());
    ArrayList<TeamsAdaptiveCard.ActionOpenUrl> actions = new ArrayList<>();
    actualAdaptiveCard.setActions(actions);
    TeamsAdaptiveCard.BackgroundImage backgroundImage2 = new TeamsAdaptiveCard.BackgroundImage("Color");
    actualAdaptiveCard.setBackgroundImage(backgroundImage2);
    ArrayList<TeamsAdaptiveCard.TextBlock> textBlocks2 = new ArrayList<>();
    actualAdaptiveCard.setTextBlocks(textBlocks2);
    String actualToStringResult = actualAdaptiveCard.toString();
    List<TeamsAdaptiveCard.ActionOpenUrl> actualActions = actualAdaptiveCard.getActions();
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = actualAdaptiveCard.getBackgroundImage();
    List<TeamsAdaptiveCard.TextBlock> actualTextBlocks = actualAdaptiveCard.getTextBlocks();

    // Assert that nothing has changed
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
   * Test Attachment {@link Attachment#equals(Object)}, and
   * {@link Attachment#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.Attachment#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.Attachment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Attachment equals(Object), and hashCode(); when other is equal; then return equal")
  void testAttachmentEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment();
    TeamsAdaptiveCard.Attachment attachment2 = new TeamsAdaptiveCard.Attachment();

    // Act and Assert
    assertEquals(attachment, attachment2);
    int expectedHashCodeResult = attachment.hashCode();
    assertEquals(expectedHashCodeResult, attachment2.hashCode());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}, and
   * {@link Attachment#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.Attachment#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.Attachment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Attachment equals(Object), and hashCode(); when other is equal; then return equal")
  void testAttachmentEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment("text/plain",
        new TeamsAdaptiveCard.AdaptiveCard());
    TeamsAdaptiveCard.Attachment attachment2 = new TeamsAdaptiveCard.Attachment("text/plain",
        new TeamsAdaptiveCard.AdaptiveCard());

    // Act and Assert
    assertEquals(attachment, attachment2);
    int expectedHashCodeResult = attachment.hashCode();
    assertEquals(expectedHashCodeResult, attachment2.hashCode());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}, and
   * {@link Attachment#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.Attachment#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.Attachment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Attachment equals(Object), and hashCode(); when other is same; then return equal")
  void testAttachmentEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment();

    // Act and Assert
    assertEquals(attachment, attachment);
    int expectedHashCodeResult = attachment.hashCode();
    assertEquals(expectedHashCodeResult, attachment.hashCode());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment("text/plain",
        new TeamsAdaptiveCard.AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, new TeamsAdaptiveCard.Attachment());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment();
    attachment.setContent(new TeamsAdaptiveCard.AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, new TeamsAdaptiveCard.Attachment());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment(null,
        new TeamsAdaptiveCard.AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, new TeamsAdaptiveCard.Attachment());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment("text/plain",
        mock(TeamsAdaptiveCard.AdaptiveCard.class));

    // Act and Assert
    assertNotEquals(attachment, new TeamsAdaptiveCard.Attachment());
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is different; then return not equal")
  void testAttachmentEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TeamsAdaptiveCard.Attachment attachment = new TeamsAdaptiveCard.Attachment();

    TeamsAdaptiveCard.Attachment attachment2 = new TeamsAdaptiveCard.Attachment();
    attachment2.setContent(new TeamsAdaptiveCard.AdaptiveCard());

    // Act and Assert
    assertNotEquals(attachment, attachment2);
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is 'null'; then return not equal")
  void testAttachmentEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.Attachment(), null);
  }

  /**
   * Test Attachment {@link Attachment#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.Attachment#equals(Object)}
   */
  @Test
  @DisplayName("Test Attachment equals(Object); when other is wrong type; then return not equal")
  void testAttachmentEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.Attachment(), "Different type to Attachment");
  }

  /**
   * Test Attachment getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.Attachment#Attachment()}
   *   <li>
   * {@link TeamsAdaptiveCard.Attachment#setContent(TeamsAdaptiveCard.AdaptiveCard)}
   *   <li>{@link TeamsAdaptiveCard.Attachment#setContentType(String)}
   *   <li>{@link TeamsAdaptiveCard.Attachment#toString()}
   *   <li>{@link TeamsAdaptiveCard.Attachment#getContent()}
   *   <li>{@link TeamsAdaptiveCard.Attachment#getContentType()}
   * </ul>
   */
  @Test
  @DisplayName("Test Attachment getters and setters")
  void testAttachmentGettersAndSetters() {
    // Arrange and Act
    TeamsAdaptiveCard.Attachment actualAttachment = new TeamsAdaptiveCard.Attachment();
    TeamsAdaptiveCard.AdaptiveCard content = new TeamsAdaptiveCard.AdaptiveCard();
    actualAttachment.setContent(content);
    actualAttachment.setContentType("text/plain");
    String actualToStringResult = actualAttachment.toString();
    TeamsAdaptiveCard.AdaptiveCard actualContent = actualAttachment.getContent();

    // Assert that nothing has changed
    assertEquals("TeamsAdaptiveCard.Attachment(contentType=text/plain, content=TeamsAdaptiveCard.AdaptiveCard(schema"
        + "=http://adaptivecards.io/schemas/adaptive-card.json, type=AdaptiveCard, backgroundImage=null,"
        + " textBlocks=[], actions=[]))", actualToStringResult);
    assertEquals("text/plain", actualAttachment.getContentType());
    assertSame(content, actualContent);
  }

  /**
   * Test Attachment getters and setters.
   * <ul>
   *   <li>When {@code text/plain}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TeamsAdaptiveCard.Attachment#Attachment(String, TeamsAdaptiveCard.AdaptiveCard)}
   *   <li>
   * {@link TeamsAdaptiveCard.Attachment#setContent(TeamsAdaptiveCard.AdaptiveCard)}
   *   <li>{@link TeamsAdaptiveCard.Attachment#setContentType(String)}
   *   <li>{@link TeamsAdaptiveCard.Attachment#toString()}
   *   <li>{@link TeamsAdaptiveCard.Attachment#getContent()}
   *   <li>{@link TeamsAdaptiveCard.Attachment#getContentType()}
   * </ul>
   */
  @Test
  @DisplayName("Test Attachment getters and setters; when 'text/plain'")
  void testAttachmentGettersAndSetters_whenTextPlain() {
    // Arrange and Act
    TeamsAdaptiveCard.Attachment actualAttachment = new TeamsAdaptiveCard.Attachment("text/plain",
        new TeamsAdaptiveCard.AdaptiveCard());
    TeamsAdaptiveCard.AdaptiveCard content = new TeamsAdaptiveCard.AdaptiveCard();
    actualAttachment.setContent(content);
    actualAttachment.setContentType("text/plain");
    String actualToStringResult = actualAttachment.toString();
    TeamsAdaptiveCard.AdaptiveCard actualContent = actualAttachment.getContent();

    // Assert that nothing has changed
    assertEquals("TeamsAdaptiveCard.Attachment(contentType=text/plain, content=TeamsAdaptiveCard.AdaptiveCard(schema"
        + "=http://adaptivecards.io/schemas/adaptive-card.json, type=AdaptiveCard, backgroundImage=null,"
        + " textBlocks=[], actions=[]))", actualToStringResult);
    assertEquals("text/plain", actualAttachment.getContentType());
    assertSame(content, actualContent);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}, and
   * {@link BackgroundImage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object), and hashCode(); when other is equal; then return equal")
  void testBackgroundImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    TeamsAdaptiveCard.BackgroundImage backgroundImage2 = new TeamsAdaptiveCard.BackgroundImage("Color");

    // Act and Assert
    assertEquals(backgroundImage, backgroundImage2);
    int expectedHashCodeResult = backgroundImage.hashCode();
    assertEquals(expectedHashCodeResult, backgroundImage2.hashCode());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}, and
   * {@link BackgroundImage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object), and hashCode(); when other is equal; then return equal")
  void testBackgroundImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    backgroundImage.setUrl("https://example.org/example");

    TeamsAdaptiveCard.BackgroundImage backgroundImage2 = new TeamsAdaptiveCard.BackgroundImage("Color");
    backgroundImage2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(backgroundImage, backgroundImage2);
    int expectedHashCodeResult = backgroundImage.hashCode();
    assertEquals(expectedHashCodeResult, backgroundImage2.hashCode());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}, and
   * {@link BackgroundImage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object), and hashCode(); when other is same; then return equal")
  void testBackgroundImageEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");

    // Act and Assert
    assertEquals(backgroundImage, backgroundImage);
    int expectedHashCodeResult = backgroundImage.hashCode();
    assertEquals(expectedHashCodeResult, backgroundImage.hashCode());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object); when other is different; then return not equal")
  void testBackgroundImageEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.BackgroundImage("Color"), 1);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object); when other is different; then return not equal")
  void testBackgroundImageEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");
    backgroundImage.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(backgroundImage, new TeamsAdaptiveCard.BackgroundImage("Color"));
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object); when other is different; then return not equal")
  void testBackgroundImageEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsAdaptiveCard.BackgroundImage backgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");

    TeamsAdaptiveCard.BackgroundImage backgroundImage2 = new TeamsAdaptiveCard.BackgroundImage("Color");
    backgroundImage2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(backgroundImage, backgroundImage2);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object); when other is 'null'; then return not equal")
  void testBackgroundImageEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.BackgroundImage("Color"), null);
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.BackgroundImage#equals(Object)}
   */
  @Test
  @DisplayName("Test BackgroundImage equals(Object); when other is wrong type; then return not equal")
  void testBackgroundImageEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.BackgroundImage("Color"), "Different type to BackgroundImage");
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#getFillMode()}.
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.BackgroundImage#getFillMode()}
   */
  @Test
  @DisplayName("Test BackgroundImage getFillMode()")
  void testBackgroundImageGetFillMode() {
    // Arrange, Act and Assert
    assertEquals("repeat", backgroundImage.getFillMode());
  }

  /**
   * Test BackgroundImage getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage()}
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#setUrl(String)}
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#toString()}
   *   <li>{@link TeamsAdaptiveCard.BackgroundImage#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test BackgroundImage getters and setters")
  void testBackgroundImageGettersAndSetters() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage();
    actualBackgroundImage.setUrl("https://example.org/example");
    String actualToStringResult = actualBackgroundImage.toString();

    // Assert that nothing has changed
    assertEquals("TeamsAdaptiveCard.BackgroundImage(url=https://example.org/example, fillMode=repeat)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage3() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage4() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage5() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbrepeatFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage6() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbrepeatorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage7() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgb#Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage8() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgb#org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage9() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbrgbFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage10() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbrgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage11() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbhslFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage12() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbhslorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage13() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage14() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage15() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage16() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage17() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage18() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage19() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage20() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbColorFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage21() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbColororg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage22() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImagerepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage23() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage24() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImagergb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage25() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImagehsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage26() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImageColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage27() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage28() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgb42Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage29() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgb42org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage30() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslrepeatFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage31() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslrepeatorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage32() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hsl#Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage33() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hsl#org.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage34() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslrgbFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage35() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslrgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage36() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslhslFailed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage37() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslhslorg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage38() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage39() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage40() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage41() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}Failed to generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage43() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String)")
  void testBackgroundImageNewBackgroundImage44() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  void testBackgroundImageNewBackgroundImage_whenAString() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgbFailed to generate embedded image for color: {}org.thingsboard.server.service.notification.channels"
            + ".TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  void testBackgroundImageNewBackgroundImage_whenAString2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImageFailed to"
            + " generate embedded image for color: {}");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  void testBackgroundImageNewBackgroundImage_whenAString3() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "rgborg.thingsboard.server.service.notification.channels.TeamsAdaptiveCard$BackgroundImageorg.thingsboard"
            + ".server.service.notification.channels.TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when a string")
  void testBackgroundImageNewBackgroundImage_whenAString4() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage(
        "hslFailed to generate embedded image for color: {}org.thingsboard.server.service.notification.channels"
            + ".TeamsAdaptiveCard$BackgroundImage");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code Color}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'Color'")
  void testBackgroundImageNewBackgroundImage_whenColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl'")
  void testBackgroundImageNewBackgroundImage_whenHsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#'")
  void testBackgroundImageNewBackgroundImage_whenHsl2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl##}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl##'")
  void testBackgroundImageNewBackgroundImage_whenHsl3() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl##");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl42'")
  void testBackgroundImageNewBackgroundImage_whenHsl42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl#42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#42'")
  void testBackgroundImageNewBackgroundImage_whenHsl422() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl#42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColor'")
  void testBackgroundImageNewBackgroundImage_whenHslColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl#Color}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#Color'")
  void testBackgroundImageNewBackgroundImage_whenHslColor2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl#Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslColor#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColor#'")
  void testBackgroundImageNewBackgroundImage_whenHslColor3() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslColor#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslColorhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColorhsl'")
  void testBackgroundImageNewBackgroundImage_whenHslColorhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslColorhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslColorrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColorrepeat'")
  void testBackgroundImageNewBackgroundImage_whenHslColorrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslColorrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslColorrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslColorrgb'")
  void testBackgroundImageNewBackgroundImage_whenHslColorrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslColorrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl#hsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#hsl'")
  void testBackgroundImageNewBackgroundImage_whenHslHsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl#hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl#repeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#repeat'")
  void testBackgroundImageNewBackgroundImage_whenHslRepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl#repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hsl#rgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hsl#rgb'")
  void testBackgroundImageNewBackgroundImage_whenHslRgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hsl#rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhsl'")
  void testBackgroundImageNewBackgroundImage_whenHslhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslhsl#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhsl#'")
  void testBackgroundImageNewBackgroundImage_whenHslhsl2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslhsl#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslhsl42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhsl42'")
  void testBackgroundImageNewBackgroundImage_whenHslhsl42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslhsl42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslhslColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslColor'")
  void testBackgroundImageNewBackgroundImage_whenHslhslColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslhslColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslhslhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslhsl'")
  void testBackgroundImageNewBackgroundImage_whenHslhslhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslhslhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslhslrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslrepeat'")
  void testBackgroundImageNewBackgroundImage_whenHslhslrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslhslrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslhslrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslhslrgb'")
  void testBackgroundImageNewBackgroundImage_whenHslhslrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslhslrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeat'")
  void testBackgroundImageNewBackgroundImage_whenHslrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrepeat#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeat#'")
  void testBackgroundImageNewBackgroundImage_whenHslrepeat2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrepeat#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrepeat42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeat42'")
  void testBackgroundImageNewBackgroundImage_whenHslrepeat42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrepeat42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrepeatColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeatColor'")
  void testBackgroundImageNewBackgroundImage_whenHslrepeatColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrepeatColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrepeathsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeathsl'")
  void testBackgroundImageNewBackgroundImage_whenHslrepeathsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrepeathsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrepeatrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeatrepeat'")
  void testBackgroundImageNewBackgroundImage_whenHslrepeatrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrepeatrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrepeatrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrepeatrgb'")
  void testBackgroundImageNewBackgroundImage_whenHslrepeatrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrepeatrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgb'")
  void testBackgroundImageNewBackgroundImage_whenHslrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrgb#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgb#'")
  void testBackgroundImageNewBackgroundImage_whenHslrgb2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrgb#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrgb42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgb42'")
  void testBackgroundImageNewBackgroundImage_whenHslrgb42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrgb42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrgbColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbColor'")
  void testBackgroundImageNewBackgroundImage_whenHslrgbColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrgbColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrgbhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbhsl'")
  void testBackgroundImageNewBackgroundImage_whenHslrgbhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrgbhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrgbrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbrepeat'")
  void testBackgroundImageNewBackgroundImage_whenHslrgbrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrgbrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code hslrgbrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'hslrgbrgb'")
  void testBackgroundImageNewBackgroundImage_whenHslrgbrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("hslrgbrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code #}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when '#'")
  void testBackgroundImageNewBackgroundImage_whenNumberSign() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb'")
  void testBackgroundImageNewBackgroundImage_whenRgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#'")
  void testBackgroundImageNewBackgroundImage_whenRgb2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb##}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb##'")
  void testBackgroundImageNewBackgroundImage_whenRgb3() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb##");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42'")
  void testBackgroundImageNewBackgroundImage_whenRgb42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb42Color}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42Color'")
  void testBackgroundImageNewBackgroundImage_whenRgb42Color() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb42Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb42hsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42hsl'")
  void testBackgroundImageNewBackgroundImage_whenRgb42hsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb42hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb42repeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42repeat'")
  void testBackgroundImageNewBackgroundImage_whenRgb42repeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb42repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb42rgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42rgb'")
  void testBackgroundImageNewBackgroundImage_whenRgb42rgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb42rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb#42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#42'")
  void testBackgroundImageNewBackgroundImage_whenRgb422() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb#42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb42#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb42#'")
  void testBackgroundImageNewBackgroundImage_whenRgb423() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb42#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb4242}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb4242'")
  void testBackgroundImageNewBackgroundImage_whenRgb4242() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb4242");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColor'")
  void testBackgroundImageNewBackgroundImage_whenRgbColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb#Color}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#Color'")
  void testBackgroundImageNewBackgroundImage_whenRgbColor2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb#Color");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbColor#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColor#'")
  void testBackgroundImageNewBackgroundImage_whenRgbColor3() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbColor#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbColor42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColor42'")
  void testBackgroundImageNewBackgroundImage_whenRgbColor42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbColor42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbColorColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorColor'")
  void testBackgroundImageNewBackgroundImage_whenRgbColorColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbColorColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbColorhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorhsl'")
  void testBackgroundImageNewBackgroundImage_whenRgbColorhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbColorhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbColorrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorrepeat'")
  void testBackgroundImageNewBackgroundImage_whenRgbColorrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbColorrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbColorrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbColorrgb'")
  void testBackgroundImageNewBackgroundImage_whenRgbColorrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbColorrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb#hsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#hsl'")
  void testBackgroundImageNewBackgroundImage_whenRgbHsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb#hsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb#repeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#repeat'")
  void testBackgroundImageNewBackgroundImage_whenRgbRepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb#repeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgb#rgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgb#rgb'")
  void testBackgroundImageNewBackgroundImage_whenRgbRgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgb#rgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhsl'")
  void testBackgroundImageNewBackgroundImage_whenRgbhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbhsl#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhsl#'")
  void testBackgroundImageNewBackgroundImage_whenRgbhsl2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbhsl#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbhsl42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhsl42'")
  void testBackgroundImageNewBackgroundImage_whenRgbhsl42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbhsl42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbhslColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslColor'")
  void testBackgroundImageNewBackgroundImage_whenRgbhslColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbhslColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbhslhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslhsl'")
  void testBackgroundImageNewBackgroundImage_whenRgbhslhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbhslhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbhslrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslrepeat'")
  void testBackgroundImageNewBackgroundImage_whenRgbhslrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbhslrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbhslrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbhslrgb'")
  void testBackgroundImageNewBackgroundImage_whenRgbhslrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbhslrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeat'")
  void testBackgroundImageNewBackgroundImage_whenRgbrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrepeat#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeat#'")
  void testBackgroundImageNewBackgroundImage_whenRgbrepeat2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrepeat#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrepeat42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeat42'")
  void testBackgroundImageNewBackgroundImage_whenRgbrepeat42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrepeat42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrepeatColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeatColor'")
  void testBackgroundImageNewBackgroundImage_whenRgbrepeatColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrepeatColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrepeathsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeathsl'")
  void testBackgroundImageNewBackgroundImage_whenRgbrepeathsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrepeathsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrepeatrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeatrepeat'")
  void testBackgroundImageNewBackgroundImage_whenRgbrepeatrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrepeatrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrepeatrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrepeatrgb'")
  void testBackgroundImageNewBackgroundImage_whenRgbrepeatrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrepeatrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgb'")
  void testBackgroundImageNewBackgroundImage_whenRgbrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrgb#}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgb#'")
  void testBackgroundImageNewBackgroundImage_whenRgbrgb2() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrgb#");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrgb42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgb42'")
  void testBackgroundImageNewBackgroundImage_whenRgbrgb42() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrgb42");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrgbColor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbColor'")
  void testBackgroundImageNewBackgroundImage_whenRgbrgbColor() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrgbColor");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrgbhsl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbhsl'")
  void testBackgroundImageNewBackgroundImage_whenRgbrgbhsl() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrgbhsl");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrgbrepeat}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbrepeat'")
  void testBackgroundImageNewBackgroundImage_whenRgbrgbrepeat() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrgbrepeat");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test BackgroundImage {@link BackgroundImage#BackgroundImage(String)}.
   * <ul>
   *   <li>When {@code rgbrgbrgb}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TeamsAdaptiveCard.BackgroundImage#BackgroundImage(String)}
   */
  @Test
  @DisplayName("Test BackgroundImage new BackgroundImage(String); when 'rgbrgbrgb'")
  void testBackgroundImageNewBackgroundImage_whenRgbrgbrgb() {
    // Arrange and Act
    TeamsAdaptiveCard.BackgroundImage actualBackgroundImage = new TeamsAdaptiveCard.BackgroundImage("rgbrgbrgb");

    // Assert
    assertEquals("repeat", actualBackgroundImage.getFillMode());
    assertNull(actualBackgroundImage.getUrl());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}, and
   * {@link TeamsAdaptiveCard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link TeamsAdaptiveCard#equals(Object)}, and
   * {@link TeamsAdaptiveCard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link TeamsAdaptiveCard#equals(Object)}, and
   * {@link TeamsAdaptiveCard#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard("message", new ArrayList<>());

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard();

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard("message", new ArrayList<>()));
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard("Type", new ArrayList<>());

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard(null, new ArrayList<>());

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<TeamsAdaptiveCard.Attachment> attachments = new ArrayList<>();
    attachments.add(mock(TeamsAdaptiveCard.Attachment.class));
    TeamsAdaptiveCard teamsAdaptiveCard = new TeamsAdaptiveCard("message", attachments);

    // Act and Assert
    assertNotEquals(teamsAdaptiveCard, new TeamsAdaptiveCard());
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard(), null);
  }

  /**
   * Test {@link TeamsAdaptiveCard#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard(), "Different type to TeamsAdaptiveCard");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsAdaptiveCard actualTeamsAdaptiveCard = new TeamsAdaptiveCard();
    ArrayList<TeamsAdaptiveCard.Attachment> attachments = new ArrayList<>();
    actualTeamsAdaptiveCard.setAttachments(attachments);
    actualTeamsAdaptiveCard.setType("Type");
    String actualToStringResult = actualTeamsAdaptiveCard.toString();
    List<TeamsAdaptiveCard.Attachment> actualAttachments = actualTeamsAdaptiveCard.getAttachments();

    // Assert that nothing has changed
    assertEquals("TeamsAdaptiveCard(type=Type, attachments=[])", actualToStringResult);
    assertEquals("Type", actualTeamsAdaptiveCard.getType());
    assertTrue(actualAttachments.isEmpty());
    assertSame(attachments, actualAttachments);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Methods under test:
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
  void testGettersAndSetters_whenType() {
    // Arrange and Act
    TeamsAdaptiveCard actualTeamsAdaptiveCard = new TeamsAdaptiveCard("Type", new ArrayList<>());
    ArrayList<TeamsAdaptiveCard.Attachment> attachments = new ArrayList<>();
    actualTeamsAdaptiveCard.setAttachments(attachments);
    actualTeamsAdaptiveCard.setType("Type");
    String actualToStringResult = actualTeamsAdaptiveCard.toString();
    List<TeamsAdaptiveCard.Attachment> actualAttachments = actualTeamsAdaptiveCard.getAttachments();

    // Assert that nothing has changed
    assertEquals("TeamsAdaptiveCard(type=Type, attachments=[])", actualToStringResult);
    assertEquals("Type", actualTeamsAdaptiveCard.getType());
    assertTrue(actualAttachments.isEmpty());
    assertSame(attachments, actualAttachments);
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and
   * {@link TextBlock#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing",
        "Color");
    TeamsAdaptiveCard.TextBlock textBlock2 = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing",
        "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and
   * {@link TextBlock#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock(null, "Weight", "Size", "Spacing", "Color");
    TeamsAdaptiveCard.TextBlock textBlock2 = new TeamsAdaptiveCard.TextBlock(null, "Weight", "Size", "Spacing",
        "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and
   * {@link TextBlock#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", null, "Size", "Spacing", "Color");
    TeamsAdaptiveCard.TextBlock textBlock2 = new TeamsAdaptiveCard.TextBlock("Text", null, "Size", "Spacing", "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and
   * {@link TextBlock#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock equals(Object), and hashCode(); when other is equal; then return equal")
  void testTextBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", null, "Spacing", "Color");
    TeamsAdaptiveCard.TextBlock textBlock2 = new TeamsAdaptiveCard.TextBlock("Text", "Weight", null, "Spacing",
        "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock2);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock2.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}, and
   * {@link TextBlock#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock equals(Object), and hashCode(); when other is same; then return equal")
  void testTextBlockEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing",
        "Color");

    // Act and Assert
    assertEquals(textBlock, textBlock);
    int expectedHashCodeResult = textBlock.hashCode();
    assertEquals(expectedHashCodeResult, textBlock.hashCode());
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("TextBlock", "Weight", "Size", "Spacing",
        "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock(null, "Weight", "Size", "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "TextBlock", "Size", "Spacing",
        "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", null, "Size", "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "TextBlock", "Spacing",
        "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", null, "Spacing", "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "TextBlock",
        "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", null, "Color");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing",
        "TextBlock");

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is different; then return not equal")
  void testTextBlockEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TeamsAdaptiveCard.TextBlock textBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", null);

    // Act and Assert
    assertNotEquals(textBlock, new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"));
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is 'null'; then return not equal")
  void testTextBlockEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"), null);
  }

  /**
   * Test TextBlock {@link TextBlock#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#equals(Object)}
   */
  @Test
  @DisplayName("Test TextBlock equals(Object); when other is wrong type; then return not equal")
  void testTextBlockEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing", "Color"),
        "Different type to TextBlock");
  }

  /**
   * Test TextBlock {@link TextBlock#getType()}.
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#getType()}
   */
  @Test
  @DisplayName("Test TextBlock getType()")
  void testTextBlockGetType() {
    // Arrange, Act and Assert
    assertEquals("TextBlock", textBlock.getType());
  }

  /**
   * Test TextBlock getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsAdaptiveCard.TextBlock#TextBlock()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setColor(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setSize(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setSpacing(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setText(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setWeight(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#toString()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getColor()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getSize()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getSpacing()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getText()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getWeight()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock getters and setters")
  void testTextBlockGettersAndSetters() {
    // Arrange and Act
    TeamsAdaptiveCard.TextBlock actualTextBlock = new TeamsAdaptiveCard.TextBlock();
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

    // Assert that nothing has changed
    assertEquals("Color", actualColor);
    assertEquals("Size", actualSize);
    assertEquals("Spacing", actualSpacing);
    assertEquals("TeamsAdaptiveCard.TextBlock(type=TextBlock, text=Text, weight=Weight, size=Size, spacing=Spacing,"
        + " color=Color, wrap=true)", actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals("Weight", actualTextBlock.getWeight());
  }

  /**
   * Test TextBlock getters and setters.
   * <ul>
   *   <li>When {@code Text}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TeamsAdaptiveCard.TextBlock#TextBlock(String, String, String, String, String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setColor(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setSize(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setSpacing(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setText(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#setWeight(String)}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#toString()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getColor()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getSize()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getSpacing()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getText()}
   *   <li>{@link TeamsAdaptiveCard.TextBlock#getWeight()}
   * </ul>
   */
  @Test
  @DisplayName("Test TextBlock getters and setters; when 'Text'")
  void testTextBlockGettersAndSetters_whenText() {
    // Arrange and Act
    TeamsAdaptiveCard.TextBlock actualTextBlock = new TeamsAdaptiveCard.TextBlock("Text", "Weight", "Size", "Spacing",
        "Color");
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

    // Assert that nothing has changed
    assertEquals("Color", actualColor);
    assertEquals("Size", actualSize);
    assertEquals("Spacing", actualSpacing);
    assertEquals("TeamsAdaptiveCard.TextBlock(type=TextBlock, text=Text, weight=Weight, size=Size, spacing=Spacing,"
        + " color=Color, wrap=true)", actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals("Weight", actualTextBlock.getWeight());
  }

  /**
   * Test TextBlock {@link TextBlock#isWrap()}.
   * <p>
   * Method under test: {@link TeamsAdaptiveCard.TextBlock#isWrap()}
   */
  @Test
  @DisplayName("Test TextBlock isWrap()")
  void testTextBlockIsWrap() {
    // Arrange, Act and Assert
    assertTrue(textBlock.isWrap());
  }
}
