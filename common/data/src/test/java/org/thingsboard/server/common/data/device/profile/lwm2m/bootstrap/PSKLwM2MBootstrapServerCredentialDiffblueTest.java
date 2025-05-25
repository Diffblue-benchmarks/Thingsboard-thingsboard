package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MSecurityMode;

class PSKLwM2MBootstrapServerCredentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PSKLwM2MBootstrapServerCredential}
   *   <li>{@link PSKLwM2MBootstrapServerCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PSKLwM2MBootstrapServerCredential.<init>()",
      "LwM2MSecurityMode PSKLwM2MBootstrapServerCredential.getSecurityMode()"})
  void testGettersAndSetters() {
    // Arrange and Act
    PSKLwM2MBootstrapServerCredential actualPskLwM2MBootstrapServerCredential = new PSKLwM2MBootstrapServerCredential();
    LwM2MSecurityMode actualSecurityMode = actualPskLwM2MBootstrapServerCredential.getSecurityMode();

    // Assert
    assertEquals("U", actualPskLwM2MBootstrapServerCredential.getBinding());
    assertNull(actualPskLwM2MBootstrapServerCredential.getPort());
    assertNull(actualPskLwM2MBootstrapServerCredential.getHost());
    assertNull(actualPskLwM2MBootstrapServerCredential.getServerCertificate());
    assertNull(actualPskLwM2MBootstrapServerCredential.getServerPublicKey());
    assertEquals(0, actualPskLwM2MBootstrapServerCredential.getBootstrapServerAccountTimeout().intValue());
    assertEquals(1, actualPskLwM2MBootstrapServerCredential.getClientHoldOffTime().intValue());
    assertEquals(1, actualPskLwM2MBootstrapServerCredential.getDefaultMinPeriod().intValue());
    assertEquals(123, actualPskLwM2MBootstrapServerCredential.getShortServerId().intValue());
    assertEquals(300, actualPskLwM2MBootstrapServerCredential.getLifetime().intValue());
    assertEquals(LwM2MSecurityMode.PSK, actualSecurityMode);
    assertFalse(actualPskLwM2MBootstrapServerCredential.isBootstrapServerIs());
    assertTrue(actualPskLwM2MBootstrapServerCredential.isNotifIfDisabled());
  }
}
