package org.thingsboard.server.service.edge.rpc.processor.device.profile;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceProfileUpdateMsg;

@ExtendWith(MockitoExtension.class)
class DeviceProfileEdgeProcessorV1DiffblueTest {
  @InjectMocks private DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1;

  /**
   * Test {@link DeviceProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, DeviceProfile,
   * RuleChainId)}.
   *
   * <p>Method under test: {@link DeviceProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId,
   * DeviceProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileEdgeProcessorV1.setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)"
  })
  void testSetDefaultRuleChainId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = new DeviceProfile();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    deviceProfileEdgeProcessorV1.setDefaultRuleChainId(tenantId, deviceProfile, ruleChainId);

    // Assert
    assertSame(ruleChainId, deviceProfile.getDefaultRuleChainId());
  }

  /**
   * Test {@link DeviceProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId,
   * DeviceProfileUpdateMsg)}.
   *
   * <p>Method under test: {@link
   * DeviceProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId,
   * DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)"
  })
  void testSetDefaultEdgeRuleChainId() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    deviceProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(
        deviceProfile, ruleChainId, DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(ruleChainId, deviceProfile.getDefaultEdgeRuleChainId());
  }
}
