package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceTokenCredentialsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTokenCredentials#DeviceTokenCredentials(String)}
   *   <li>{@link DeviceTokenCredentials#toString()}
   *   <li>{@link DeviceTokenCredentials#getCredentialsId()}
   *   <li>{@link DeviceTokenCredentials#getCredentialsType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceTokenCredentials actualDeviceTokenCredentials = new DeviceTokenCredentials("ABC123");
    String actualToStringResult = actualDeviceTokenCredentials.toString();
    String actualCredentialsId = actualDeviceTokenCredentials.getCredentialsId();

    // Assert
    assertEquals("ABC123", actualCredentialsId);
    assertEquals("DeviceTokenCredentials [token=ABC123]", actualToStringResult);
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualDeviceTokenCredentials.getCredentialsType());
  }
}
