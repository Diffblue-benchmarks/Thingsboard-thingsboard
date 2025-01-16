package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MSecurityMode;

class X509LwM2MBootstrapServerCredentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link X509LwM2MBootstrapServerCredential}
   *   <li>{@link X509LwM2MBootstrapServerCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    X509LwM2MBootstrapServerCredential actualX509LwM2MBootstrapServerCredential = new X509LwM2MBootstrapServerCredential();
    LwM2MSecurityMode actualSecurityMode = actualX509LwM2MBootstrapServerCredential.getSecurityMode();

    // Assert
    assertEquals("U", actualX509LwM2MBootstrapServerCredential.getBinding());
    assertNull(actualX509LwM2MBootstrapServerCredential.getPort());
    assertNull(actualX509LwM2MBootstrapServerCredential.getHost());
    assertNull(actualX509LwM2MBootstrapServerCredential.getServerCertificate());
    assertNull(actualX509LwM2MBootstrapServerCredential.getServerPublicKey());
    assertEquals(0, actualX509LwM2MBootstrapServerCredential.getBootstrapServerAccountTimeout().intValue());
    assertEquals(1, actualX509LwM2MBootstrapServerCredential.getClientHoldOffTime().intValue());
    assertEquals(1, actualX509LwM2MBootstrapServerCredential.getDefaultMinPeriod().intValue());
    assertEquals(123, actualX509LwM2MBootstrapServerCredential.getShortServerId().intValue());
    assertEquals(300, actualX509LwM2MBootstrapServerCredential.getLifetime().intValue());
    assertEquals(LwM2MSecurityMode.X509, actualSecurityMode);
    assertFalse(actualX509LwM2MBootstrapServerCredential.isBootstrapServerIs());
    assertTrue(actualX509LwM2MBootstrapServerCredential.isNotifIfDisabled());
  }
}
