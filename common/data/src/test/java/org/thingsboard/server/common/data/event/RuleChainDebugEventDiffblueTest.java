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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleChainDebugEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEvent#equals(Object)}
   *   <li>{@link RuleChainDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainDebugEvent buildResult = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleChainDebugEvent buildResult2 = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEvent#equals(Object)}
   *   <li>{@link RuleChainDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainDebugEvent buildResult = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link RuleChainDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEvent.RuleChainDebugEventBuilder ruleChainDebugEventBuilder = mock(
        RuleChainDebugEvent.RuleChainDebugEventBuilder.class);
    when(ruleChainDebugEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(RuleChainDebugEvent.builder());
    RuleChainDebugEvent buildResult = ruleChainDebugEventBuilder.entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleChainDebugEvent buildResult2 = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RuleChainDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEvent buildResult = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link RuleChainDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEvent buildResult = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleChainDebugEvent");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEvent#setError(String)}
   *   <li>{@link RuleChainDebugEvent#setMessage(String)}
   *   <li>{@link RuleChainDebugEvent#toString()}
   *   <li>{@link RuleChainDebugEvent#getError()}
   *   <li>{@link RuleChainDebugEvent#getMessage()}
   *   <li>{@link RuleChainDebugEvent#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleChainDebugEvent buildResult = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    buildResult.setError("An error occurred");
    buildResult.setMessage("Not all who wander are lost");
    String actualToStringResult = buildResult.toString();
    String actualError = buildResult.getError();
    String actualMessage = buildResult.getMessage();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("RuleChainDebugEvent(message=Not all who wander are lost, error=An error occurred)",
        actualToStringResult);
    assertEquals(EventType.DEBUG_RULE_CHAIN, buildResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#build()}
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#entityId(UUID)}
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#error(String)}
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#id(UUID)}
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#message(String)}
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#serviceId(String)}
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#tenantId(TenantId)}
   *   <li>{@link RuleChainDebugEvent.RuleChainDebugEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  void testRuleChainDebugEventBuilderBuild() {
    // Arrange and Act
    RuleChainDebugEvent actualBuildResult = RuleChainDebugEvent.builder()
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .id(EntityId.NULL_UUID)
        .message("Not all who wander are lost")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getEntityId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Not all who wander are lost", actualBuildResult.getMessage());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.DEBUG_RULE_CHAIN, actualBuildResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
