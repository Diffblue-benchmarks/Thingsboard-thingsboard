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
package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleEngineDeviceRpcRequestDiffblueTest {
  /**
   * Test {@link RuleEngineDeviceRpcRequest#RuleEngineDeviceRpcRequest(TenantId, DeviceId, int,
   * UUID, String, boolean, boolean, String, String, long, boolean, String, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return OriginServiceId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineDeviceRpcRequest#RuleEngineDeviceRpcRequest(TenantId,
   * DeviceId, int, UUID, String, boolean, boolean, String, String, long, boolean, String, Integer)}
   */
  @Test
  @DisplayName(
      "Test new RuleEngineDeviceRpcRequest(TenantId, DeviceId, int, UUID, String, boolean, boolean, String, String, long, boolean, String, Integer); when 'null'; then return OriginServiceId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineDeviceRpcRequest.<init>(TenantId, DeviceId, int, UUID, String, boolean, boolean, String, String, long, boolean, String, Integer)"
  })
  void testNewRuleEngineDeviceRpcRequest_whenNull_thenReturnOriginServiceIdIs42() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID requestUUID = UUID.randomUUID();

    // Act
    RuleEngineDeviceRpcRequest actualRuleEngineDeviceRpcRequest =
        new RuleEngineDeviceRpcRequest(
            tenantId,
            null,
            1,
            requestUUID,
            "42",
            true,
            true,
            "Method",
            "Not all who wander are lost",
            1L,
            true,
            "Additional Info",
            1);

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
