package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceX509CredentialsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceX509Credentials#DeviceX509Credentials(String)}
   *   <li>{@link DeviceX509Credentials#toString()}
   *   <li>{@link DeviceX509Credentials#getCredentialsId()}
   *   <li>{@link DeviceX509Credentials#getCredentialsType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceX509Credentials actualDeviceX509Credentials = new DeviceX509Credentials("Sha3 Hash");
    String actualToStringResult = actualDeviceX509Credentials.toString();
    String actualCredentialsId = actualDeviceX509Credentials.getCredentialsId();

    // Assert
    assertEquals("DeviceX509Credentials [SHA3=Sha3 Hash]", actualToStringResult);
    assertEquals("Sha3 Hash", actualCredentialsId);
    assertEquals(DeviceCredentialsType.X509_CERTIFICATE, actualDeviceX509Credentials.getCredentialsType());
  }
}
