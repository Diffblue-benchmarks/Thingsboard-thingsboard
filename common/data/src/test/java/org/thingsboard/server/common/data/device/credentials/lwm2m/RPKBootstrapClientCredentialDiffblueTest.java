package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RPKBootstrapClientCredentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link RPKBootstrapClientCredential}
   *   <li>{@link RPKBootstrapClientCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    RPKBootstrapClientCredential actualRpkBootstrapClientCredential = new RPKBootstrapClientCredential();
    LwM2MSecurityMode actualSecurityMode = actualRpkBootstrapClientCredential.getSecurityMode();

    // Assert
    assertNull(actualRpkBootstrapClientCredential.getClientPublicKeyOrId());
    assertNull(actualRpkBootstrapClientCredential.getClientSecretKey());
    assertEquals(LwM2MSecurityMode.RPK, actualSecurityMode);
  }
}
