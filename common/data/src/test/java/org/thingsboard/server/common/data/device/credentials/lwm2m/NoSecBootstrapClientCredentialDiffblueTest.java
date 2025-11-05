package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NoSecBootstrapClientCredentialDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NoSecBootstrapClientCredential}
   *   <li>{@link NoSecBootstrapClientCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoSecBootstrapClientCredential.<init>()",
    "LwM2MSecurityMode NoSecBootstrapClientCredential.getSecurityMode()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(LwM2MSecurityMode.NO_SEC, new NoSecBootstrapClientCredential().getSecurityMode());
  }
}
