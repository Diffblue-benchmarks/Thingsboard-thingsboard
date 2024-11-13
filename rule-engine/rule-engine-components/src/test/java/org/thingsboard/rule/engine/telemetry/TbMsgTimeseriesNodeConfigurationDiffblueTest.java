package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbMsgTimeseriesNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbMsgTimeseriesNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration = new TbMsgTimeseriesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgTimeseriesNodeConfiguration, tbMsgTimeseriesNodeConfiguration.defaultConfiguration());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}, and
   * {@link TbMsgTimeseriesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration = new TbMsgTimeseriesNodeConfiguration();
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration2 = new TbMsgTimeseriesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgTimeseriesNodeConfiguration, tbMsgTimeseriesNodeConfiguration2);
    int expectedHashCodeResult = tbMsgTimeseriesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgTimeseriesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}, and
   * {@link TbMsgTimeseriesNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration = new TbMsgTimeseriesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgTimeseriesNodeConfiguration, tbMsgTimeseriesNodeConfiguration);
    int expectedHashCodeResult = tbMsgTimeseriesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgTimeseriesNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgTimeseriesNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration = new TbMsgTimeseriesNodeConfiguration();
    tbMsgTimeseriesNodeConfiguration.setDefaultTTL(1L);

    // Act and Assert
    assertNotEquals(tbMsgTimeseriesNodeConfiguration, new TbMsgTimeseriesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration = new TbMsgTimeseriesNodeConfiguration();
    tbMsgTimeseriesNodeConfiguration.setSkipLatestPersistence(true);

    // Act and Assert
    assertNotEquals(tbMsgTimeseriesNodeConfiguration, new TbMsgTimeseriesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration = new TbMsgTimeseriesNodeConfiguration();
    tbMsgTimeseriesNodeConfiguration.setUseServerTs(true);

    // Act and Assert
    assertNotEquals(tbMsgTimeseriesNodeConfiguration, new TbMsgTimeseriesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgTimeseriesNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgTimeseriesNodeConfiguration(), "Different type to TbMsgTimeseriesNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbMsgTimeseriesNodeConfiguration}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#setDefaultTTL(long)}
   *   <li>
   * {@link TbMsgTimeseriesNodeConfiguration#setSkipLatestPersistence(boolean)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#setUseServerTs(boolean)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#toString()}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#getDefaultTTL()}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#isSkipLatestPersistence()}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#isUseServerTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgTimeseriesNodeConfiguration actualTbMsgTimeseriesNodeConfiguration = new TbMsgTimeseriesNodeConfiguration();
    actualTbMsgTimeseriesNodeConfiguration.setDefaultTTL(1L);
    actualTbMsgTimeseriesNodeConfiguration.setSkipLatestPersistence(true);
    actualTbMsgTimeseriesNodeConfiguration.setUseServerTs(true);
    String actualToStringResult = actualTbMsgTimeseriesNodeConfiguration.toString();
    long actualDefaultTTL = actualTbMsgTimeseriesNodeConfiguration.getDefaultTTL();
    boolean actualIsSkipLatestPersistenceResult = actualTbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence();

    // Assert that nothing has changed
    assertEquals("TbMsgTimeseriesNodeConfiguration(defaultTTL=1, skipLatestPersistence=true, useServerTs=true)",
        actualToStringResult);
    assertEquals(1L, actualDefaultTTL);
    assertTrue(actualIsSkipLatestPersistenceResult);
    assertTrue(actualTbMsgTimeseriesNodeConfiguration.isUseServerTs());
  }
}
