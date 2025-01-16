package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class SaveDeviceWithCredentialsRequestDiffblueTest {
  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and
   * {@link SaveDeviceWithCredentialsRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());
    Device device2 = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 = new SaveDeviceWithCredentialsRequest(device2,
        new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and
   * {@link SaveDeviceWithCredentialsRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(null,
        new DeviceCredentials());
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 = new SaveDeviceWithCredentialsRequest(null,
        new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and
   * {@link SaveDeviceWithCredentialsRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(
        new Device(), null);
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest2 = new SaveDeviceWithCredentialsRequest(
        new Device(), null);

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest2);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest2.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}, and
   * {@link SaveDeviceWithCredentialsRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveDeviceWithCredentialsRequest#equals(Object)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());

    // Act and Assert
    assertEquals(saveDeviceWithCredentialsRequest, saveDeviceWithCredentialsRequest);
    int expectedHashCodeResult = saveDeviceWithCredentialsRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveDeviceWithCredentialsRequest.hashCode());
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(null,
        new DeviceCredentials());
    Device device = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()));
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceInfo device = new DeviceInfo();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());
    Device device2 = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials()));
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Device device = mock(Device.class);
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials());
    Device device2 = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials()));
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(
        new Device(), null);
    Device device = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()));
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Device device = new Device();
    SaveDeviceWithCredentialsRequest saveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(device,
        new DeviceCredentials(new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    Device device2 = new Device();

    // Act and Assert
    assertNotEquals(saveDeviceWithCredentialsRequest,
        new SaveDeviceWithCredentialsRequest(device2, new DeviceCredentials()));
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertNotEquals(new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()), null);
  }

  /**
   * Test {@link SaveDeviceWithCredentialsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveDeviceWithCredentialsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertNotEquals(new SaveDeviceWithCredentialsRequest(device, new DeviceCredentials()),
        "Different type to SaveDeviceWithCredentialsRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SaveDeviceWithCredentialsRequest#SaveDeviceWithCredentialsRequest(Device, DeviceCredentials)}
   *   <li>{@link SaveDeviceWithCredentialsRequest#toString()}
   *   <li>{@link SaveDeviceWithCredentialsRequest#getCredentials()}
   *   <li>{@link SaveDeviceWithCredentialsRequest#getDevice()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    Device device = new Device();
    DeviceCredentials credentials = new DeviceCredentials();

    // Act
    SaveDeviceWithCredentialsRequest actualSaveDeviceWithCredentialsRequest = new SaveDeviceWithCredentialsRequest(
        device, credentials);
    String actualToStringResult = actualSaveDeviceWithCredentialsRequest.toString();
    DeviceCredentials actualCredentials = actualSaveDeviceWithCredentialsRequest.getCredentials();

    // Assert
    assertEquals(
        "SaveDeviceWithCredentialsRequest(device=Device(super=BaseData [createdTime=0, id=null], tenantId=null,"
            + " customerId=null, name=null, type=null, label=null, deviceProfileId=null, deviceData=null, deviceDataBytes"
            + "=null, firmwareId=null, softwareId=null, externalId=null, version=null), credentials=DeviceCredentials"
            + " [deviceId=null, credentialsType=null, credentialsId=null, credentialsValue=null, createdTime=0,"
            + " id=null])",
        actualToStringResult);
    assertSame(device, actualSaveDeviceWithCredentialsRequest.getDevice());
    assertSame(credentials, actualCredentials);
  }
}
