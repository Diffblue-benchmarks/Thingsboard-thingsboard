package org.thingsboard.rule.engine.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversationType;

class TbSlackNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSlackNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange and Act
    TbSlackNodeConfiguration actualDefaultConfigurationResult = (new TbSlackNodeConfiguration()).defaultConfiguration();

    // Assert
    assertEquals("Device ${deviceId}: temperature is $[temperature]",
        actualDefaultConfigurationResult.getMessageTemplate());
    assertEquals("xoxb-", actualDefaultConfigurationResult.getBotToken());
    assertNull(actualDefaultConfigurationResult.getConversation());
    assertEquals(SlackConversationType.PUBLIC_CHANNEL, actualDefaultConfigurationResult.getConversationType());
    assertTrue(actualDefaultConfigurationResult.isUseSystemSettings());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}, and
   * {@link TbSlackNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSlackNodeConfiguration#equals(Object)}
   *   <li>{@link TbSlackNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    TbSlackNodeConfiguration tbSlackNodeConfiguration2 = new TbSlackNodeConfiguration();

    // Act and Assert
    assertEquals(tbSlackNodeConfiguration, tbSlackNodeConfiguration2);
    int expectedHashCodeResult = tbSlackNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSlackNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}, and
   * {@link TbSlackNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSlackNodeConfiguration#equals(Object)}
   *   <li>{@link TbSlackNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();

    // Act and Assert
    assertEquals(tbSlackNodeConfiguration, tbSlackNodeConfiguration);
    int expectedHashCodeResult = tbSlackNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSlackNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSlackNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, new TbSlackNodeConfiguration());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration.setUseSystemSettings(true);

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, new TbSlackNodeConfiguration());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration.setMessageTemplate("Message Template");

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, new TbSlackNodeConfiguration());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration.setConversationType(SlackConversationType.DIRECT);

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, new TbSlackNodeConfiguration());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    SlackConversation conversation = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    tbSlackNodeConfiguration.setConversation(conversation);

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, new TbSlackNodeConfiguration());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();

    TbSlackNodeConfiguration tbSlackNodeConfiguration2 = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration2.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, tbSlackNodeConfiguration2);
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();

    TbSlackNodeConfiguration tbSlackNodeConfiguration2 = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration2.setMessageTemplate("Message Template");

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, tbSlackNodeConfiguration2);
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();

    TbSlackNodeConfiguration tbSlackNodeConfiguration2 = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration2.setConversationType(SlackConversationType.DIRECT);

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, tbSlackNodeConfiguration2);
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();

    TbSlackNodeConfiguration tbSlackNodeConfiguration2 = new TbSlackNodeConfiguration();
    SlackConversation conversation = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    tbSlackNodeConfiguration2.setConversation(conversation);

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, tbSlackNodeConfiguration2);
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SlackConversation.SlackConversationBuilder slackConversationBuilder = mock(
        SlackConversation.SlackConversationBuilder.class);
    when(slackConversationBuilder.email(Mockito.<String>any())).thenReturn(SlackConversation.builder());
    SlackConversation conversation = slackConversationBuilder.email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();

    TbSlackNodeConfiguration tbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    tbSlackNodeConfiguration.setConversation(conversation);

    // Act and Assert
    assertNotEquals(tbSlackNodeConfiguration, new TbSlackNodeConfiguration());
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSlackNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSlackNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSlackNodeConfiguration(), "Different type to TbSlackNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbSlackNodeConfiguration}
   *   <li>{@link TbSlackNodeConfiguration#setBotToken(String)}
   *   <li>{@link TbSlackNodeConfiguration#setConversation(SlackConversation)}
   *   <li>
   * {@link TbSlackNodeConfiguration#setConversationType(SlackConversationType)}
   *   <li>{@link TbSlackNodeConfiguration#setMessageTemplate(String)}
   *   <li>{@link TbSlackNodeConfiguration#setUseSystemSettings(boolean)}
   *   <li>{@link TbSlackNodeConfiguration#toString()}
   *   <li>{@link TbSlackNodeConfiguration#getBotToken()}
   *   <li>{@link TbSlackNodeConfiguration#getConversation()}
   *   <li>{@link TbSlackNodeConfiguration#getConversationType()}
   *   <li>{@link TbSlackNodeConfiguration#getMessageTemplate()}
   *   <li>{@link TbSlackNodeConfiguration#isUseSystemSettings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbSlackNodeConfiguration actualTbSlackNodeConfiguration = new TbSlackNodeConfiguration();
    actualTbSlackNodeConfiguration.setBotToken("ABC123");
    SlackConversation conversation = SlackConversation.builder()
        .email("jane.doe@example.org")
        .id("42")
        .name("Name")
        .type(SlackConversationType.DIRECT)
        .wholeName("Whole Name")
        .build();
    actualTbSlackNodeConfiguration.setConversation(conversation);
    actualTbSlackNodeConfiguration.setConversationType(SlackConversationType.DIRECT);
    actualTbSlackNodeConfiguration.setMessageTemplate("Message Template");
    actualTbSlackNodeConfiguration.setUseSystemSettings(true);
    String actualToStringResult = actualTbSlackNodeConfiguration.toString();
    String actualBotToken = actualTbSlackNodeConfiguration.getBotToken();
    SlackConversation actualConversation = actualTbSlackNodeConfiguration.getConversation();
    SlackConversationType actualConversationType = actualTbSlackNodeConfiguration.getConversationType();
    String actualMessageTemplate = actualTbSlackNodeConfiguration.getMessageTemplate();

    // Assert that nothing has changed
    assertEquals("ABC123", actualBotToken);
    assertEquals("Message Template", actualMessageTemplate);
    assertEquals("TbSlackNodeConfiguration(botToken=ABC123, useSystemSettings=true, messageTemplate=Message Template,"
        + " conversationType=DIRECT, conversation=SlackConversation(type=DIRECT, id=42, name=Name, wholeName=Whole"
        + " Name, email=jane.doe@example.org))", actualToStringResult);
    assertEquals(SlackConversationType.DIRECT, actualConversationType);
    assertTrue(actualTbSlackNodeConfiguration.isUseSystemSettings());
    assertSame(conversation, actualConversation);
  }
}
