package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class DefaultDeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}, and
   * {@link DefaultDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration = new DefaultDeviceTransportConfiguration();
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration2 = new DefaultDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceTransportConfiguration, defaultDeviceTransportConfiguration2);
    int expectedHashCodeResult = defaultDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}, and
   * {@link DefaultDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration = new DefaultDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceTransportConfiguration, defaultDeviceTransportConfiguration);
    int expectedHashCodeResult = defaultDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), 1);
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), "Different type to DefaultDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultDeviceTransportConfiguration}
   *   <li>{@link DefaultDeviceTransportConfiguration#toString()}
   *   <li>{@link DefaultDeviceTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceTransportConfiguration actualDefaultDeviceTransportConfiguration = new DefaultDeviceTransportConfiguration();
    String actualToStringResult = actualDefaultDeviceTransportConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceTransportConfiguration()", actualToStringResult);
    assertEquals(DeviceTransportType.DEFAULT, actualDefaultDeviceTransportConfiguration.getType());
  }
}
