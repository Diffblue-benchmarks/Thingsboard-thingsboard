package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MqttSubscriptionDiffblueTest {
  /**
   * Test {@link MqttSubscription#MqttSubscription(String, MqttHandler, boolean)}.
   * <ul>
   *   <li>When {@link MqttHandler}.</li>
   *   <li>Then return {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttSubscription#MqttSubscription(String, MqttHandler, boolean)}
   */
  @Test
  @DisplayName("Test new MqttSubscription(String, MqttHandler, boolean); when MqttHandler; then return 'Topic'")
  void testNewMqttSubscription_whenMqttHandler_thenReturnTopic() {
    // Arrange
    MqttHandler handler = mock(MqttHandler.class);

    // Act
    MqttSubscription actualMqttSubscription = new MqttSubscription("Topic", handler, true);

    // Assert
    assertEquals("Topic", actualMqttSubscription.getTopic());
    assertFalse(actualMqttSubscription.isCalled());
    assertTrue(actualMqttSubscription.isOnce());
    assertSame(handler, actualMqttSubscription.getHandler());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttSubscription#setCalled(boolean)}
   *   <li>{@link MqttSubscription#getHandler()}
   *   <li>{@link MqttSubscription#getTopic()}
   *   <li>{@link MqttSubscription#isCalled()}
   *   <li>{@link MqttSubscription#isOnce()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), true);

    // Act
    mqttSubscription.setCalled(true);
    mqttSubscription.getHandler();
    String actualTopic = mqttSubscription.getTopic();
    boolean actualIsCalledResult = mqttSubscription.isCalled();

    // Assert that nothing has changed
    assertEquals("Topic", actualTopic);
    assertTrue(actualIsCalledResult);
    assertTrue(mqttSubscription.isOnce());
  }

  /**
   * Test {@link MqttSubscription#matches(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttSubscription#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); then return 'false'")
  void testMatches_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MqttSubscription("42", mock(MqttHandler.class), true)).matches("Topic"));
  }

  /**
   * Test {@link MqttSubscription#matches(String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttSubscription#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); then return 'true'")
  void testMatches_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MqttSubscription("Topic", mock(MqttHandler.class), true)).matches("Topic"));
  }

  /**
   * Test {@link MqttSubscription#equals(Object)}, and
   * {@link MqttSubscription#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttSubscription#equals(Object)}
   *   <li>{@link MqttSubscription#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), true);

    // Act and Assert
    assertEquals(mqttSubscription, mqttSubscription);
    int expectedHashCodeResult = mqttSubscription.hashCode();
    assertEquals(expectedHashCodeResult, mqttSubscription.hashCode());
  }

  /**
   * Test {@link MqttSubscription#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), true);

    // Act and Assert
    assertNotEquals(mqttSubscription, new MqttSubscription("Topic", mock(MqttHandler.class), true));
  }

  /**
   * Test {@link MqttSubscription#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("#", mock(MqttHandler.class), true);

    // Act and Assert
    assertNotEquals(mqttSubscription, new MqttSubscription("Topic", mock(MqttHandler.class), true));
  }

  /**
   * Test {@link MqttSubscription#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), false);

    // Act and Assert
    assertNotEquals(mqttSubscription, new MqttSubscription("Topic", mock(MqttHandler.class), true));
  }

  /**
   * Test {@link MqttSubscription#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttSubscription("Topic", mock(MqttHandler.class), true), null);
  }

  /**
   * Test {@link MqttSubscription#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttSubscription("Topic", mock(MqttHandler.class), true), "Different type to MqttSubscription");
  }
}
