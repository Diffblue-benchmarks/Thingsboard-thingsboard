package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileType;

class DefaultDeviceProfileConfigurationDiffblueTest {
  /**
   * Test {@link DefaultDeviceProfileConfiguration#equals(Object)}, and
   * {@link DefaultDeviceProfileConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileConfiguration defaultDeviceProfileConfiguration = new DefaultDeviceProfileConfiguration();
    DefaultDeviceProfileConfiguration defaultDeviceProfileConfiguration2 = new DefaultDeviceProfileConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceProfileConfiguration, defaultDeviceProfileConfiguration2);
    int expectedHashCodeResult = defaultDeviceProfileConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileConfiguration2.hashCode());
  }

  /**
   * Test {@link DefaultDeviceProfileConfiguration#equals(Object)}, and
   * {@link DefaultDeviceProfileConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileConfiguration defaultDeviceProfileConfiguration = new DefaultDeviceProfileConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceProfileConfiguration, defaultDeviceProfileConfiguration);
    int expectedHashCodeResult = defaultDeviceProfileConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultDeviceProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileConfiguration(), 1);
  }

  /**
   * Test {@link DefaultDeviceProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileConfiguration(), null);
  }

  /**
   * Test {@link DefaultDeviceProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileConfiguration(), "Different type to DefaultDeviceProfileConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultDeviceProfileConfiguration}
   *   <li>{@link DefaultDeviceProfileConfiguration#toString()}
   *   <li>{@link DefaultDeviceProfileConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceProfileConfiguration actualDefaultDeviceProfileConfiguration = new DefaultDeviceProfileConfiguration();
    String actualToStringResult = actualDefaultDeviceProfileConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceProfileConfiguration()", actualToStringResult);
    assertEquals(DeviceProfileType.DEFAULT, actualDefaultDeviceProfileConfiguration.getType());
  }
}
