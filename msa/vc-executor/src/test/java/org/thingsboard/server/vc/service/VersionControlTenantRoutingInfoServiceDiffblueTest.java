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
package org.thingsboard.server.vc.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.queue.discovery.TenantRoutingInfo;

@ContextConfiguration(classes = {VersionControlTenantRoutingInfoService.class})
@ExtendWith(SpringExtension.class)
class VersionControlTenantRoutingInfoServiceDiffblueTest {
  @Autowired private VersionControlTenantRoutingInfoService versionControlTenantRoutingInfoService;

  /**
   * Test {@link VersionControlTenantRoutingInfoService#getRoutingInfo(TenantId)}.
   *
   * <p>Method under test: {@link VersionControlTenantRoutingInfoService#getRoutingInfo(TenantId)}
   */
  @Test
  @DisplayName("Test getRoutingInfo(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantRoutingInfo VersionControlTenantRoutingInfoService.getRoutingInfo(TenantId)"
  })
  void testGetRoutingInfo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TenantRoutingInfo actualRoutingInfo =
        versionControlTenantRoutingInfoService.getRoutingInfo(tenantId);

    // Assert
    assertNull(actualRoutingInfo.getProfileId());
    assertFalse(actualRoutingInfo.isIsolated());
    assertSame(tenantId, actualRoutingInfo.getTenantId());
  }
}
