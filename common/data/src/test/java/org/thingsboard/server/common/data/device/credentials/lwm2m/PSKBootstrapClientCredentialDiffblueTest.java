package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PSKBootstrapClientCredentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link PSKBootstrapClientCredential}
   *   <li>{@link PSKBootstrapClientCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    PSKBootstrapClientCredential actualPskBootstrapClientCredential = new PSKBootstrapClientCredential();
    LwM2MSecurityMode actualSecurityMode = actualPskBootstrapClientCredential.getSecurityMode();

    // Assert
    assertNull(actualPskBootstrapClientCredential.getClientPublicKeyOrId());
    assertNull(actualPskBootstrapClientCredential.getClientSecretKey());
    assertEquals(LwM2MSecurityMode.PSK, actualSecurityMode);
  }
}
