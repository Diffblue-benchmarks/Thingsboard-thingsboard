package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbQueueRuleEngineSettingsDiffblueTest {
  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}, and
   * {@link TbQueueRuleEngineSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
    int expectedHashCodeResult = tbQueueRuleEngineSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRuleEngineSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}, and
   * {@link TbQueueRuleEngineSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings.setTopic("Topic");

    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
    int expectedHashCodeResult = tbQueueRuleEngineSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRuleEngineSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}, and
   * {@link TbQueueRuleEngineSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings);
    int expectedHashCodeResult = tbQueueRuleEngineSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRuleEngineSettings.hashCode());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), 1);
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueRuleEngineSettings, new TbQueueRuleEngineSettings());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), null);
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), "Different type to TbQueueRuleEngineSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#setTopic(String)}
   *   <li>{@link TbQueueRuleEngineSettings#toString()}
   *   <li>{@link TbQueueRuleEngineSettings#getTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    // Act
    tbQueueRuleEngineSettings.setTopic("Topic");
    String actualToStringResult = tbQueueRuleEngineSettings.toString();

    // Assert that nothing has changed
    assertEquals("TbQueueRuleEngineSettings(topic=Topic)", actualToStringResult);
    assertEquals("Topic", tbQueueRuleEngineSettings.getTopic());
  }
}
