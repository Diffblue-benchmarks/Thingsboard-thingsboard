package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class DefaultTbServiceInfoProviderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbServiceInfoProvider#getAssignedTenantProfiles()}
   *   <li>{@link DefaultTbServiceInfoProvider#getServiceId()}
   *   <li>{@link DefaultTbServiceInfoProvider#getServiceInfo()}
   *   <li>{@link DefaultTbServiceInfoProvider#getServiceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider = new DefaultTbServiceInfoProvider();

    // Act
    Set<UUID> actualAssignedTenantProfiles = defaultTbServiceInfoProvider.getAssignedTenantProfiles();
    String actualServiceId = defaultTbServiceInfoProvider.getServiceId();
    TransportProtos.ServiceInfo actualServiceInfo = defaultTbServiceInfoProvider.getServiceInfo();

    // Assert
    assertNull(actualServiceId);
    assertNull(defaultTbServiceInfoProvider.getServiceType());
    assertNull(actualAssignedTenantProfiles);
    assertNull(actualServiceInfo);
  }
}
