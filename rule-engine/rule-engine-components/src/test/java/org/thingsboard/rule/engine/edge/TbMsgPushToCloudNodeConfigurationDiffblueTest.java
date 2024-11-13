package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbMsgPushToCloudNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgPushToCloudNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbMsgPushToCloudNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals("SERVER_SCOPE", (new TbMsgPushToCloudNodeConfiguration()).defaultConfiguration().getScope());
  }

  /**
   * Test {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}, and
   * {@link TbMsgPushToCloudNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgPushToCloudNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgPushToCloudNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration = new TbMsgPushToCloudNodeConfiguration();
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration2 = new TbMsgPushToCloudNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgPushToCloudNodeConfiguration, tbMsgPushToCloudNodeConfiguration2);
    int expectedHashCodeResult = tbMsgPushToCloudNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgPushToCloudNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}, and
   * {@link TbMsgPushToCloudNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgPushToCloudNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgPushToCloudNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration = new TbMsgPushToCloudNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgPushToCloudNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
    int expectedHashCodeResult = tbMsgPushToCloudNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgPushToCloudNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgPushToCloudNodeConfiguration(), 1);
    assertNotEquals(new TbMsgPushToCloudNodeConfiguration(), mock(BaseTbMsgPushNodeConfiguration.class));
  }

  /**
   * Test {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration = new TbMsgPushToCloudNodeConfiguration();
    tbMsgPushToCloudNodeConfiguration.setScope("Scope");

    // Act and Assert
    assertNotEquals(tbMsgPushToCloudNodeConfiguration, new TbMsgPushToCloudNodeConfiguration());
  }

  /**
   * Test {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgPushToCloudNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToCloudNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgPushToCloudNodeConfiguration(), "Different type to TbMsgPushToCloudNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbMsgPushToCloudNodeConfiguration}
   *   <li>{@link TbMsgPushToCloudNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToCloudNodeConfiguration actualTbMsgPushToCloudNodeConfiguration = new TbMsgPushToCloudNodeConfiguration();

    // Assert
    assertEquals("TbMsgPushToCloudNodeConfiguration()", actualTbMsgPushToCloudNodeConfiguration.toString());
    assertNull(actualTbMsgPushToCloudNodeConfiguration.getScope());
  }
}
