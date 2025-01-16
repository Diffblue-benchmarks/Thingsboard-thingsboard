package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;

class CheckPreProvisionedDevicesDeviceProfileProvisionConfigurationDiffblueTest {
  /**
   * Test
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)},
   * and
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration checkPreProvisionedDevicesDeviceProfileProvisionConfiguration = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2 = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");

    // Act and Assert
    assertEquals(checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2);
    int expectedHashCodeResult = checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Test
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)},
   * and
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration checkPreProvisionedDevicesDeviceProfileProvisionConfiguration = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        null);
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2 = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        null);

    // Act and Assert
    assertEquals(checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2);
    int expectedHashCodeResult = checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Test
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)},
   * and
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration checkPreProvisionedDevicesDeviceProfileProvisionConfiguration = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");

    // Act and Assert
    assertEquals(checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration);
    int expectedHashCodeResult = checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode());
  }

  /**
   * Test
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration checkPreProvisionedDevicesDeviceProfileProvisionConfiguration = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        null);

    // Act and Assert
    assertNotEquals(checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"));
  }

  /**
   * Test
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration checkPreProvisionedDevicesDeviceProfileProvisionConfiguration = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        "org.thingsboard.server.common.data.device.profile.CheckPreProvisionedDevicesDeviceProfileProvisionCo"
            + "nfiguration");

    // Act and Assert
    assertNotEquals(checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"));
  }

  /**
   * Test
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"), null);
  }

  /**
   * Test
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"),
        "Different type to CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(String)}
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#toString()}
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#getProvisionDeviceSecret()}
   *   <li>
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration = new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");
    String actualToStringResult = actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.toString();
    String actualProvisionDeviceSecret = actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        .getProvisionDeviceSecret();

    // Assert
    assertEquals("CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(provisionDeviceSecret=Provision Device"
        + " Secret)", actualToStringResult);
    assertEquals("Provision Device Secret", actualProvisionDeviceSecret);
    assertEquals(DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES,
        actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.getType());
  }
}
