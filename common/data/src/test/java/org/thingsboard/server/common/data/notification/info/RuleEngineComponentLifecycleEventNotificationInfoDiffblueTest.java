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
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class RuleEngineComponentLifecycleEventNotificationInfoDiffblueTest {
  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(8, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("componentId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("ruleChainId"));
    assertEquals("Action", actualTemplateData.get("action"));
    assertEquals("An error occurred", actualTemplateData.get("error"));
    assertEquals("Component Name", actualTemplateData.get("componentName"));
    assertEquals("Rule Chain Name", actualTemplateData.get("ruleChainName"));
    assertEquals("Tenant", actualTemplateData.get("componentType"));
    assertEquals("created", actualTemplateData.get("eventType"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.action(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.randomUUID()))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED)
        .ruleChainId(null)
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName(null)
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("42")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(null)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED)
        .ruleChainId(null)
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED)
        .ruleChainId(null)
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName(null)
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(null)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(null)
        .componentName(null)
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder builderResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder();
    builderResult.componentId(TenantId.SYS_TENANT_ID);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(null)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder builderResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder();
    builderResult.componentName("Rule Chain Name");
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(null)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleEngineComponentLifecycleEventNotificationInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#RuleEngineComponentLifecycleEventNotificationInfo()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setAction(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentId(EntityId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentName(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setError(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setEventType(ComponentLifecycleEvent)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainId(RuleChainId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#toString()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getAction()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentId()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentName()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getError()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getEventType()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainId()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainName()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getStateEntityId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventNotificationInfo actualRuleEngineComponentLifecycleEventNotificationInfo = new RuleEngineComponentLifecycleEventNotificationInfo();
    actualRuleEngineComponentLifecycleEventNotificationInfo.setAction("Action");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentId(TenantId.SYS_TENANT_ID);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentName("Component Name");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setError("An error occurred");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setEventType(ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainId(ruleChainId);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainName("Rule Chain Name");
    String actualToStringResult = actualRuleEngineComponentLifecycleEventNotificationInfo.toString();
    String actualAction = actualRuleEngineComponentLifecycleEventNotificationInfo.getAction();
    EntityId actualComponentId = actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentId();
    String actualComponentName = actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentName();
    String actualError = actualRuleEngineComponentLifecycleEventNotificationInfo.getError();
    ComponentLifecycleEvent actualEventType = actualRuleEngineComponentLifecycleEventNotificationInfo.getEventType();
    RuleChainId actualRuleChainId = actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainId();
    String actualRuleChainName = actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainName();

    // Assert that nothing has changed
    assertEquals("Action", actualAction);
    assertEquals("An error occurred", actualError);
    assertEquals("Component Name", actualComponentName);
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertEquals("RuleEngineComponentLifecycleEventNotificationInfo(ruleChainId=13814000-1dd2-11b2-8080-808080808080,"
        + " ruleChainName=Rule Chain Name, componentId=13814000-1dd2-11b2-8080-808080808080, componentName=Component"
        + " Name, action=Action, eventType=CREATED, error=An error occurred)", actualToStringResult);
    assertEquals(ComponentLifecycleEvent.CREATED, actualEventType);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(ruleChainId, actualRuleEngineComponentLifecycleEventNotificationInfo.getStateEntityId());
    assertSame(((TenantId) actualComponentId).SYS_TENANT_ID, actualComponentId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#RuleEngineComponentLifecycleEventNotificationInfo(RuleChainId, String, EntityId, String, String, ComponentLifecycleEvent, String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setAction(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentId(EntityId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentName(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setError(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setEventType(ComponentLifecycleEvent)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainId(RuleChainId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#toString()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getAction()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentId()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentName()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getError()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getEventType()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainId()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainName()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo#getStateEntityId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventNotificationInfo actualRuleEngineComponentLifecycleEventNotificationInfo = new RuleEngineComponentLifecycleEventNotificationInfo(
        new RuleChainId(EntityId.NULL_UUID), "Rule Chain Name", TenantId.SYS_TENANT_ID, "Component Name", "Action",
        ComponentLifecycleEvent.CREATED, "An error occurred");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setAction("Action");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentId(TenantId.SYS_TENANT_ID);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentName("Component Name");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setError("An error occurred");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setEventType(ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainId(ruleChainId);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainName("Rule Chain Name");
    String actualToStringResult = actualRuleEngineComponentLifecycleEventNotificationInfo.toString();
    String actualAction = actualRuleEngineComponentLifecycleEventNotificationInfo.getAction();
    EntityId actualComponentId = actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentId();
    String actualComponentName = actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentName();
    String actualError = actualRuleEngineComponentLifecycleEventNotificationInfo.getError();
    ComponentLifecycleEvent actualEventType = actualRuleEngineComponentLifecycleEventNotificationInfo.getEventType();
    RuleChainId actualRuleChainId = actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainId();
    String actualRuleChainName = actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainName();

    // Assert that nothing has changed
    assertEquals("Action", actualAction);
    assertEquals("An error occurred", actualError);
    assertEquals("Component Name", actualComponentName);
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertEquals("RuleEngineComponentLifecycleEventNotificationInfo(ruleChainId=13814000-1dd2-11b2-8080-808080808080,"
        + " ruleChainName=Rule Chain Name, componentId=13814000-1dd2-11b2-8080-808080808080, componentName=Component"
        + " Name, action=Action, eventType=CREATED, error=An error occurred)", actualToStringResult);
    assertEquals(ComponentLifecycleEvent.CREATED, actualEventType);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(ruleChainId, actualRuleEngineComponentLifecycleEventNotificationInfo.getStateEntityId());
    assertSame(((TenantId) actualComponentId).SYS_TENANT_ID, actualComponentId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#build()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#action(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#componentId(EntityId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#componentName(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#error(String)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#eventType(ComponentLifecycleEvent)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#ruleChainId(RuleChainId)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder#ruleChainName(String)}
   * </ul>
   */
  @Test
  void testRuleEngineComponentLifecycleEventNotificationInfoBuilderBuild() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder()
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);

    // Act
    RuleEngineComponentLifecycleEventNotificationInfo actualBuildResult = eventTypeResult.ruleChainId(ruleChainId)
        .ruleChainName("Rule Chain Name")
        .build();

    // Assert
    assertTrue(actualBuildResult.getComponentId() instanceof TenantId);
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(8, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("componentId"));
    assertEquals("Action", templateData.get("action"));
    assertEquals("Action", actualBuildResult.getAction());
    assertEquals("An error occurred", templateData.get("error"));
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Component Name", templateData.get("componentName"));
    assertEquals("Component Name", actualBuildResult.getComponentName());
    assertEquals("Rule Chain Name", actualBuildResult.getRuleChainName());
    assertEquals("Tenant", templateData.get("componentType"));
    assertEquals("created", templateData.get("eventType"));
    assertNull(actualBuildResult.getAffectedCustomerId());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getAffectedTenantId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertEquals(ComponentLifecycleEvent.CREATED, actualBuildResult.getEventType());
    assertSame(ruleChainId, actualBuildResult.getRuleChainId());
    assertSame(ruleChainId, actualBuildResult.getStateEntityId());
  }
}
