package org.thingsboard.server.service.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EdgeEventStorageSettingsDiffblueTest {
  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}, and
   * {@link EdgeEventStorageSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventStorageSettings#equals(Object)}
   *   <li>{@link EdgeEventStorageSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEventStorageSettings edgeEventStorageSettings = new EdgeEventStorageSettings();
    EdgeEventStorageSettings edgeEventStorageSettings2 = new EdgeEventStorageSettings();

    // Act and Assert
    assertEquals(edgeEventStorageSettings, edgeEventStorageSettings2);
    int expectedHashCodeResult = edgeEventStorageSettings.hashCode();
    assertEquals(expectedHashCodeResult, edgeEventStorageSettings2.hashCode());
  }

  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}, and
   * {@link EdgeEventStorageSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventStorageSettings#equals(Object)}
   *   <li>{@link EdgeEventStorageSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEventStorageSettings edgeEventStorageSettings = new EdgeEventStorageSettings();

    // Act and Assert
    assertEquals(edgeEventStorageSettings, edgeEventStorageSettings);
    int expectedHashCodeResult = edgeEventStorageSettings.hashCode();
    assertEquals(expectedHashCodeResult, edgeEventStorageSettings.hashCode());
  }

  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventStorageSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEventStorageSettings(), 1);
  }

  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventStorageSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEventStorageSettings edgeEventStorageSettings = new EdgeEventStorageSettings();
    edgeEventStorageSettings.setMaxReadRecordsCount(3);

    // Act and Assert
    assertNotEquals(edgeEventStorageSettings, new EdgeEventStorageSettings());
  }

  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventStorageSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeEventStorageSettings edgeEventStorageSettings = new EdgeEventStorageSettings();
    edgeEventStorageSettings.setNoRecordsSleepInterval(42L);

    // Act and Assert
    assertNotEquals(edgeEventStorageSettings, new EdgeEventStorageSettings());
  }

  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventStorageSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEventStorageSettings edgeEventStorageSettings = new EdgeEventStorageSettings();
    edgeEventStorageSettings.setSleepIntervalBetweenBatches(42L);

    // Act and Assert
    assertNotEquals(edgeEventStorageSettings, new EdgeEventStorageSettings());
  }

  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventStorageSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEventStorageSettings(), null);
  }

  /**
   * Test {@link EdgeEventStorageSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventStorageSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEventStorageSettings(), "Different type to EdgeEventStorageSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventStorageSettings#setMaxReadRecordsCount(int)}
   *   <li>{@link EdgeEventStorageSettings#setNoRecordsSleepInterval(long)}
   *   <li>{@link EdgeEventStorageSettings#setSleepIntervalBetweenBatches(long)}
   *   <li>{@link EdgeEventStorageSettings#toString()}
   *   <li>{@link EdgeEventStorageSettings#getMaxReadRecordsCount()}
   *   <li>{@link EdgeEventStorageSettings#getNoRecordsSleepInterval()}
   *   <li>{@link EdgeEventStorageSettings#getSleepIntervalBetweenBatches()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    EdgeEventStorageSettings edgeEventStorageSettings = new EdgeEventStorageSettings();

    // Act
    edgeEventStorageSettings.setMaxReadRecordsCount(3);
    edgeEventStorageSettings.setNoRecordsSleepInterval(42L);
    edgeEventStorageSettings.setSleepIntervalBetweenBatches(42L);
    String actualToStringResult = edgeEventStorageSettings.toString();
    int actualMaxReadRecordsCount = edgeEventStorageSettings.getMaxReadRecordsCount();
    long actualNoRecordsSleepInterval = edgeEventStorageSettings.getNoRecordsSleepInterval();

    // Assert that nothing has changed
    assertEquals(
        "EdgeEventStorageSettings(maxReadRecordsCount=3, noRecordsSleepInterval=42, sleepIntervalBetweenBatches"
            + "=42)",
        actualToStringResult);
    assertEquals(3, actualMaxReadRecordsCount);
    assertEquals(42L, actualNoRecordsSleepInterval);
    assertEquals(42L, edgeEventStorageSettings.getSleepIntervalBetweenBatches());
  }
}
