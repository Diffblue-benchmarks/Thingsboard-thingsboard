package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleEngineDeviceRpcRequestDiffblueTest {
  /**
   * Test {@link RuleEngineDeviceRpcRequest#RuleEngineDeviceRpcRequest(TenantId, DeviceId, int, UUID, String, boolean, boolean, String, String, long, boolean, String, Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return OriginServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineDeviceRpcRequest#RuleEngineDeviceRpcRequest(TenantId, DeviceId, int, UUID, String, boolean, boolean, String, String, long, boolean, String, Integer)}
   */
  @Test
  @DisplayName("Test new RuleEngineDeviceRpcRequest(TenantId, DeviceId, int, UUID, String, boolean, boolean, String, String, long, boolean, String, Integer); when 'null'; then return OriginServiceId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void RuleEngineDeviceRpcRequest.<init>(TenantId, DeviceId, int, UUID, String, boolean, boolean, String, String, long, boolean, String, Integer)"})
  void testNewRuleEngineDeviceRpcRequest_whenNull_thenReturnOriginServiceIdIs42() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID requestUUID = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    RuleEngineDeviceRpcRequest actualRuleEngineDeviceRpcRequest = new RuleEngineDeviceRpcRequest(tenantId, null, 1,
        requestUUID, "42", true, true, "Method", "Not all who wander are lost", 1L, true, "Additional Info", 1);

    // Assert
    assertEquals("42", actualRuleEngineDeviceRpcRequest.getOriginServiceId());
    assertEquals("Additional Info", actualRuleEngineDeviceRpcRequest.getAdditionalInfo());
    assertEquals("Method", actualRuleEngineDeviceRpcRequest.getMethod());
    assertEquals("Not all who wander are lost", actualRuleEngineDeviceRpcRequest.getBody());
    assertNull(actualRuleEngineDeviceRpcRequest.getDeviceId());
    assertEquals(1, actualRuleEngineDeviceRpcRequest.getRetries().intValue());
    assertEquals(1, actualRuleEngineDeviceRpcRequest.getRequestId());
    assertEquals(1L, actualRuleEngineDeviceRpcRequest.getExpirationTime());
    assertTrue(actualRuleEngineDeviceRpcRequest.isOneway());
    assertTrue(actualRuleEngineDeviceRpcRequest.isPersisted());
    assertTrue(actualRuleEngineDeviceRpcRequest.isRestApiCall());
    assertSame(tenantId, actualRuleEngineDeviceRpcRequest.getTenantId());
    assertSame(requestUUID, actualRuleEngineDeviceRpcRequest.getRequestUUID());
  }
}
