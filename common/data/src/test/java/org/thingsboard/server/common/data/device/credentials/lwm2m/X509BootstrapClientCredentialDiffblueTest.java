package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class X509BootstrapClientCredentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link X509BootstrapClientCredential}
   *   <li>{@link X509BootstrapClientCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    X509BootstrapClientCredential actualX509BootstrapClientCredential = new X509BootstrapClientCredential();
    LwM2MSecurityMode actualSecurityMode = actualX509BootstrapClientCredential.getSecurityMode();

    // Assert
    assertNull(actualX509BootstrapClientCredential.getClientPublicKeyOrId());
    assertNull(actualX509BootstrapClientCredential.getClientSecretKey());
    assertEquals(LwM2MSecurityMode.X509, actualSecurityMode);
  }
}
