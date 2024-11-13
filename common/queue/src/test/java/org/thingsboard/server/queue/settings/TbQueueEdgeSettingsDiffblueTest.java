package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbQueueEdgeSettingsDiffblueTest {
  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}, and
   * {@link TbQueueEdgeSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#equals(Object)}
   *   <li>{@link TbQueueEdgeSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();
    TbQueueEdgeSettings tbQueueEdgeSettings2 = new TbQueueEdgeSettings();

    // Act and Assert
    assertEquals(tbQueueEdgeSettings, tbQueueEdgeSettings2);
    int expectedHashCodeResult = tbQueueEdgeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueEdgeSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}, and
   * {@link TbQueueEdgeSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#equals(Object)}
   *   <li>{@link TbQueueEdgeSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();
    tbQueueEdgeSettings.setTopic("Topic");

    TbQueueEdgeSettings tbQueueEdgeSettings2 = new TbQueueEdgeSettings();
    tbQueueEdgeSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueEdgeSettings, tbQueueEdgeSettings2);
    int expectedHashCodeResult = tbQueueEdgeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueEdgeSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}, and
   * {@link TbQueueEdgeSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#equals(Object)}
   *   <li>{@link TbQueueEdgeSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertEquals(tbQueueEdgeSettings, tbQueueEdgeSettings);
    int expectedHashCodeResult = tbQueueEdgeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueEdgeSettings.hashCode());
  }

  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueEdgeSettings(), 1);
  }

  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();
    tbQueueEdgeSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueEdgeSettings, new TbQueueEdgeSettings());
  }

  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();

    TbQueueEdgeSettings tbQueueEdgeSettings2 = new TbQueueEdgeSettings();
    tbQueueEdgeSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueEdgeSettings, tbQueueEdgeSettings2);
  }

  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueEdgeSettings(), null);
  }

  /**
   * Test {@link TbQueueEdgeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueEdgeSettings(), "Different type to TbQueueEdgeSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#setTopic(String)}
   *   <li>{@link TbQueueEdgeSettings#toString()}
   *   <li>{@link TbQueueEdgeSettings#getTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();

    // Act
    tbQueueEdgeSettings.setTopic("Topic");
    String actualToStringResult = tbQueueEdgeSettings.toString();

    // Assert that nothing has changed
    assertEquals("TbQueueEdgeSettings(topic=Topic)", actualToStringResult);
    assertEquals("Topic", tbQueueEdgeSettings.getTopic());
  }
}
