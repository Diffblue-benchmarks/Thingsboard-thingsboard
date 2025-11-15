/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ServiceInfo;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set DefaultTbServiceInfoProvider.getAssignedTenantProfiles()",
      "String DefaultTbServiceInfoProvider.getServiceId()", "ServiceInfo DefaultTbServiceInfoProvider.getServiceInfo()",
      "String DefaultTbServiceInfoProvider.getServiceType()"})
  void testGettersAndSetters() {
    // Arrange
    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider = new DefaultTbServiceInfoProvider();

    // Act
    Set<UUID> actualAssignedTenantProfiles = defaultTbServiceInfoProvider.getAssignedTenantProfiles();
    String actualServiceId = defaultTbServiceInfoProvider.getServiceId();
    ServiceInfo actualServiceInfo = defaultTbServiceInfoProvider.getServiceInfo();

    // Assert
    assertNull(actualServiceId);
    assertNull(defaultTbServiceInfoProvider.getServiceType());
    assertNull(actualAssignedTenantProfiles);
    assertNull(actualServiceInfo);
  }
}
