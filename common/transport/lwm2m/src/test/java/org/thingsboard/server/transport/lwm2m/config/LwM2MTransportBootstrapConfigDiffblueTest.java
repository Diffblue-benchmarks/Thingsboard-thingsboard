package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MTransportBootstrapConfigDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MTransportBootstrapConfig#getHost()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getId()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getPort()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getSecureHost()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getSecurePort()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String LwM2MTransportBootstrapConfig.getHost()",
    "Integer LwM2MTransportBootstrapConfig.getId()",
    "Integer LwM2MTransportBootstrapConfig.getPort()",
    "String LwM2MTransportBootstrapConfig.getSecureHost()",
    "Integer LwM2MTransportBootstrapConfig.getSecurePort()"
  })
  void testGettersAndSetters() {
    // Arrange
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig =
        new LwM2MTransportBootstrapConfig();

    // Act
    String actualHost = lwM2MTransportBootstrapConfig.getHost();
    Integer actualId = lwM2MTransportBootstrapConfig.getId();
    Integer actualPort = lwM2MTransportBootstrapConfig.getPort();
    String actualSecureHost = lwM2MTransportBootstrapConfig.getSecureHost();

    // Assert
    assertNull(actualId);
    assertNull(actualPort);
    assertNull(lwM2MTransportBootstrapConfig.getSecurePort());
    assertNull(actualHost);
    assertNull(actualSecureHost);
  }
}
