package org.thingsboard.server.dao.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceConnectivityConfigurationDiffblueTest {
  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and {@link
   * DeviceConnectivityConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#equals(Object)}
   *   <li>{@link DeviceConnectivityConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();
    DeviceConnectivityConfiguration deviceConnectivityConfiguration2 =
        new DeviceConnectivityConfiguration();

    // Act and Assert
    assertEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration2);
    assertEquals(
        deviceConnectivityConfiguration.hashCode(), deviceConnectivityConfiguration2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and {@link
   * DeviceConnectivityConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#equals(Object)}
   *   <li>{@link DeviceConnectivityConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();

    // Act and Assert
    assertEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration);
    int expectedHashCodeResult = deviceConnectivityConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityConfiguration.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceConnectivityConfiguration(), 1);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.put("Key", deviceConnectivityInfo);

    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    // Act and Assert
    assertNotEquals(deviceConnectivityConfiguration, new DeviceConnectivityConfiguration());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceConnectivityConfiguration(), null);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceConnectivityConfiguration(), "Different type to DeviceConnectivityConfiguration");
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#getConnectivity(String)} with {@code String}.
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#getConnectivity(String)}
   */
  @Test
  @DisplayName("Test getConnectivity(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceConnectivityInfo DeviceConnectivityConfiguration.getConnectivity(String)"
  })
  void testGetConnectivityWithString() {
    // Arrange, Act and Assert
    assertNull(new DeviceConnectivityConfiguration().getConnectivity("Protocol"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#setConnectivity(Map)}
   *   <li>{@link DeviceConnectivityConfiguration#toString()}
   *   <li>{@link DeviceConnectivityConfiguration#getConnectivity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DeviceConnectivityConfiguration.getConnectivity()",
    "void DeviceConnectivityConfiguration.setConnectivity(Map)",
    "String DeviceConnectivityConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();
    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();

    // Act
    deviceConnectivityConfiguration.setConnectivity(connectivity);
    String actualToStringResult = deviceConnectivityConfiguration.toString();
    Map<String, DeviceConnectivityInfo> actualConnectivity =
        deviceConnectivityConfiguration.getConnectivity();

    // Assert
    assertEquals("DeviceConnectivityConfiguration(connectivity={})", actualToStringResult);
    assertTrue(actualConnectivity.isEmpty());
    assertSame(connectivity, actualConnectivity);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#isEnabled(String)}.
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#isEnabled(String)}
   */
  @Test
  @DisplayName("Test isEnabled(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.isEnabled(String)"})
  void testIsEnabled() {
    // Arrange, Act and Assert
    assertFalse(new DeviceConnectivityConfiguration().isEnabled("Protocol"));
  }
}
