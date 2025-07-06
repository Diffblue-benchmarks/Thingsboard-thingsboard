package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class DefaultDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * DefaultDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
    "int DefaultDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileTransportConfiguration defaultDeviceProfileTransportConfiguration =
        new DefaultDeviceProfileTransportConfiguration();
    DefaultDeviceProfileTransportConfiguration defaultDeviceProfileTransportConfiguration2 =
        new DefaultDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(
        defaultDeviceProfileTransportConfiguration, defaultDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = defaultDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * DefaultDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
    "int DefaultDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileTransportConfiguration defaultDeviceProfileTransportConfiguration =
        new DefaultDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(
        defaultDeviceProfileTransportConfiguration, defaultDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = defaultDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
    "int DefaultDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
    "int DefaultDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
    "int DefaultDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DefaultDeviceProfileTransportConfiguration(),
        "Different type to DefaultDeviceProfileTransportConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       DefaultDeviceProfileTransportConfiguration}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultDeviceProfileTransportConfiguration.<init>()",
    "DeviceTransportType DefaultDeviceProfileTransportConfiguration.getType()",
    "String DefaultDeviceProfileTransportConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceProfileTransportConfiguration actualDefaultDeviceProfileTransportConfiguration =
        new DefaultDeviceProfileTransportConfiguration();
    String actualToStringResult = actualDefaultDeviceProfileTransportConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceProfileTransportConfiguration()", actualToStringResult);
    assertEquals(
        DeviceTransportType.DEFAULT, actualDefaultDeviceProfileTransportConfiguration.getType());
  }
}
