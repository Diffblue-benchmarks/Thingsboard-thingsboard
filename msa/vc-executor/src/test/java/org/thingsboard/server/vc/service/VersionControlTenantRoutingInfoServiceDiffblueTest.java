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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TenantRoutingInfo actualRoutingInfo =
        versionControlTenantRoutingInfoService.getRoutingInfo(tenantId);

    // Assert
    assertNull(actualRoutingInfo.getProfileId());
    assertFalse(actualRoutingInfo.isIsolated());
    assertSame(tenantId, actualRoutingInfo.getTenantId());
  }
}
