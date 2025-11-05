package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MSecurityMode;

class RPKLwM2MBootstrapServerCredentialDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RPKLwM2MBootstrapServerCredential}
   *   <li>{@link RPKLwM2MBootstrapServerCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RPKLwM2MBootstrapServerCredential.<init>()",
    "LwM2MSecurityMode RPKLwM2MBootstrapServerCredential.getSecurityMode()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RPKLwM2MBootstrapServerCredential actualRpkLwM2MBootstrapServerCredential =
        new RPKLwM2MBootstrapServerCredential();
    LwM2MSecurityMode actualSecurityMode =
        actualRpkLwM2MBootstrapServerCredential.getSecurityMode();

    // Assert
    assertEquals("U", actualRpkLwM2MBootstrapServerCredential.getBinding());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getPort());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getHost());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getServerCertificate());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getServerPublicKey());
    assertEquals(
        0, actualRpkLwM2MBootstrapServerCredential.getBootstrapServerAccountTimeout().intValue());
    assertEquals(1, actualRpkLwM2MBootstrapServerCredential.getClientHoldOffTime().intValue());
    assertEquals(1, actualRpkLwM2MBootstrapServerCredential.getDefaultMinPeriod().intValue());
    assertEquals(123, actualRpkLwM2MBootstrapServerCredential.getShortServerId().intValue());
    assertEquals(300, actualRpkLwM2MBootstrapServerCredential.getLifetime().intValue());
    assertEquals(LwM2MSecurityMode.RPK, actualSecurityMode);
    assertFalse(actualRpkLwM2MBootstrapServerCredential.isBootstrapServerIs());
    assertTrue(actualRpkLwM2MBootstrapServerCredential.isNotifIfDisabled());
  }
}
