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
package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class RuleEngineComponentLifecycleEventTriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.error(Mockito.<Throwable>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder7 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder7.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder6);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder7
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(null);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.randomUUID()))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger buildResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED)
        .ruleChainId(null)
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(null)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder2
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder2
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder3
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder2
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.error(Mockito.<Throwable>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder3
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder4);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder5
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(null);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder builderResult = RuleEngineComponentLifecycleEventTrigger
        .builder();
    builderResult.componentId(TenantId.SYS_TENANT_ID);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder builderResult = RuleEngineComponentLifecycleEventTrigger
        .builder();
    builderResult.componentName("Rule Chain Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder builderResult = RuleEngineComponentLifecycleEventTrigger
        .builder();
    builderResult.eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.error(Mockito.<Throwable>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder7 = mock(
        RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder7.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder6);
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder7
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(null);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleEngineComponentLifecycleEventTrigger");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger#RuleEngineComponentLifecycleEventTrigger(TenantId, RuleChainId, String, EntityId, String, ComponentLifecycleEvent, Throwable)}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#toString()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getComponentId()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getComponentName()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getError()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getEventType()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getOriginatorEntityId()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getRuleChainId()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getRuleChainName()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getTenantId()}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    Throwable error = new Throwable();

    // Act
    RuleEngineComponentLifecycleEventTrigger actualRuleEngineComponentLifecycleEventTrigger = new RuleEngineComponentLifecycleEventTrigger(
        TenantId.SYS_TENANT_ID, ruleChainId, "Rule Chain Name", TenantId.SYS_TENANT_ID, "Component Name",
        ComponentLifecycleEvent.CREATED, error);
    String actualToStringResult = actualRuleEngineComponentLifecycleEventTrigger.toString();
    EntityId actualComponentId = actualRuleEngineComponentLifecycleEventTrigger.getComponentId();
    String actualComponentName = actualRuleEngineComponentLifecycleEventTrigger.getComponentName();
    Throwable actualError = actualRuleEngineComponentLifecycleEventTrigger.getError();
    ComponentLifecycleEvent actualEventType = actualRuleEngineComponentLifecycleEventTrigger.getEventType();
    EntityId actualOriginatorEntityId = actualRuleEngineComponentLifecycleEventTrigger.getOriginatorEntityId();
    RuleChainId actualRuleChainId = actualRuleEngineComponentLifecycleEventTrigger.getRuleChainId();
    String actualRuleChainName = actualRuleEngineComponentLifecycleEventTrigger.getRuleChainName();
    TenantId actualTenantId = actualRuleEngineComponentLifecycleEventTrigger.getTenantId();

    // Assert
    assertEquals("Component Name", actualComponentName);
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertEquals(
        "RuleEngineComponentLifecycleEventTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, ruleChainId"
            + "=13814000-1dd2-11b2-8080-808080808080, ruleChainName=Rule Chain Name, componentId=13814000-1dd2-11b2"
            + "-8080-808080808080, componentName=Component Name, eventType=CREATED, error=java.lang.Throwable)",
        actualToStringResult);
    assertEquals(NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT,
        actualRuleEngineComponentLifecycleEventTrigger.getType());
    assertEquals(ComponentLifecycleEvent.CREATED, actualEventType);
    assertSame(error, actualError);
    assertSame(ruleChainId, actualRuleChainId);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualComponentId);
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#build()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#componentId(EntityId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#componentName(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#error(Throwable)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#eventType(ComponentLifecycleEvent)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#ruleChainId(RuleChainId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#ruleChainName(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  void testRuleEngineComponentLifecycleEventTriggerBuilderBuild() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    Throwable error = new Throwable();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult
        .error(error)
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);

    // Act
    RuleEngineComponentLifecycleEventTrigger actualBuildResult = eventTypeResult.ruleChainId(ruleChainId)
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    EntityId componentId = actualBuildResult.getComponentId();
    assertTrue(componentId instanceof TenantId);
    assertEquals("Component Name", actualBuildResult.getComponentName());
    assertEquals("RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT:TENANT:13814000-1dd2-11b2-8080-808080808080",
        actualBuildResult.getDeduplicationKey());
    assertEquals("Rule Chain Name", actualBuildResult.getRuleChainName());
    assertEquals(0L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT, actualBuildResult.getType());
    assertEquals(ComponentLifecycleEvent.CREATED, actualBuildResult.getEventType());
    assertFalse(actualBuildResult.deduplicate());
    assertSame(error, actualBuildResult.getError());
    assertSame(ruleChainId, actualBuildResult.getRuleChainId());
    assertSame(componentId, actualBuildResult.getOriginatorEntityId());
    assertSame(componentId, actualBuildResult.getTenantId());
  }
}
