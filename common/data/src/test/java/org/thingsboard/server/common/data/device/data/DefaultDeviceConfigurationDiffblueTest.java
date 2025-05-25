package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileType;

class DefaultDeviceConfigurationDiffblueTest {
  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}, and {@link DefaultDeviceConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceConfiguration.equals(Object)", "int DefaultDeviceConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceConfiguration defaultDeviceConfiguration = new DefaultDeviceConfiguration();
    DefaultDeviceConfiguration defaultDeviceConfiguration2 = new DefaultDeviceConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceConfiguration, defaultDeviceConfiguration2);
    int expectedHashCodeResult = defaultDeviceConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceConfiguration2.hashCode());
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}, and {@link DefaultDeviceConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceConfiguration.equals(Object)", "int DefaultDeviceConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceConfiguration defaultDeviceConfiguration = new DefaultDeviceConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceConfiguration, defaultDeviceConfiguration);
    int expectedHashCodeResult = defaultDeviceConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceConfiguration.equals(Object)", "int DefaultDeviceConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), 1);
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceConfiguration.equals(Object)", "int DefaultDeviceConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), null);
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceConfiguration.equals(Object)", "int DefaultDeviceConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), "Different type to DefaultDeviceConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultDeviceConfiguration}
   *   <li>{@link DefaultDeviceConfiguration#toString()}
   *   <li>{@link DefaultDeviceConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultDeviceConfiguration.<init>()",
      "DeviceProfileType DefaultDeviceConfiguration.getType()", "String DefaultDeviceConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceConfiguration actualDefaultDeviceConfiguration = new DefaultDeviceConfiguration();
    String actualToStringResult = actualDefaultDeviceConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceConfiguration()", actualToStringResult);
    assertEquals(DeviceProfileType.DEFAULT, actualDefaultDeviceConfiguration.getType());
  }
}
