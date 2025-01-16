package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NoSecClientCredentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NoSecClientCredential}
   *   <li>{@link NoSecClientCredential#getSecurityConfigClientMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NoSecClientCredential actualNoSecClientCredential = new NoSecClientCredential();
    LwM2MSecurityMode actualSecurityConfigClientMode = actualNoSecClientCredential.getSecurityConfigClientMode();

    // Assert
    assertNull(actualNoSecClientCredential.getEndpoint());
    assertEquals(LwM2MSecurityMode.NO_SEC, actualSecurityConfigClientMode);
  }
}
