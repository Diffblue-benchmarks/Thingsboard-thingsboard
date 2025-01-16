package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbActorSystemSettingsDiffblueTest {
  /**
   * Test {@link TbActorSystemSettings#equals(Object)}, and
   * {@link TbActorSystemSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbActorSystemSettings#equals(Object)}
   *   <li>{@link TbActorSystemSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 3, 3);
    TbActorSystemSettings tbActorSystemSettings2 = new TbActorSystemSettings(1, 3, 3);

    // Act and Assert
    assertEquals(tbActorSystemSettings, tbActorSystemSettings2);
    int expectedHashCodeResult = tbActorSystemSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbActorSystemSettings2.hashCode());
  }

  /**
   * Test {@link TbActorSystemSettings#equals(Object)}, and
   * {@link TbActorSystemSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbActorSystemSettings#equals(Object)}
   *   <li>{@link TbActorSystemSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 3, 3);

    // Act and Assert
    assertEquals(tbActorSystemSettings, tbActorSystemSettings);
    int expectedHashCodeResult = tbActorSystemSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbActorSystemSettings.hashCode());
  }

  /**
   * Test {@link TbActorSystemSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(3, 3, 3);

    // Act and Assert
    assertNotEquals(tbActorSystemSettings, new TbActorSystemSettings(1, 3, 3));
  }

  /**
   * Test {@link TbActorSystemSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 1, 3);

    // Act and Assert
    assertNotEquals(tbActorSystemSettings, new TbActorSystemSettings(1, 3, 3));
  }

  /**
   * Test {@link TbActorSystemSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 3, 1);

    // Act and Assert
    assertNotEquals(tbActorSystemSettings, new TbActorSystemSettings(1, 3, 3));
  }

  /**
   * Test {@link TbActorSystemSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbActorSystemSettings(1, 3, 3), null);
  }

  /**
   * Test {@link TbActorSystemSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbActorSystemSettings(1, 3, 3), "Different type to TbActorSystemSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbActorSystemSettings#TbActorSystemSettings(int, int, int)}
   *   <li>{@link TbActorSystemSettings#toString()}
   *   <li>{@link TbActorSystemSettings#getActorThroughput()}
   *   <li>{@link TbActorSystemSettings#getMaxActorInitAttempts()}
   *   <li>{@link TbActorSystemSettings#getSchedulerPoolSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbActorSystemSettings actualTbActorSystemSettings = new TbActorSystemSettings(1, 3, 3);
    String actualToStringResult = actualTbActorSystemSettings.toString();
    int actualActorThroughput = actualTbActorSystemSettings.getActorThroughput();
    int actualMaxActorInitAttempts = actualTbActorSystemSettings.getMaxActorInitAttempts();

    // Assert
    assertEquals("TbActorSystemSettings(actorThroughput=1, schedulerPoolSize=3, maxActorInitAttempts=3)",
        actualToStringResult);
    assertEquals(1, actualActorThroughput);
    assertEquals(3, actualMaxActorInitAttempts);
    assertEquals(3, actualTbActorSystemSettings.getSchedulerPoolSize());
  }
}
