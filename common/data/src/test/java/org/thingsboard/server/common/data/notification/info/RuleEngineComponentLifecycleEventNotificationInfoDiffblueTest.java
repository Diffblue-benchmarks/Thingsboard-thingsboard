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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

@ContextConfiguration(classes = {RuleEngineComponentLifecycleEventNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class RuleEngineComponentLifecycleEventNotificationInfoDiffblueTest {
  @Autowired
  private RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder;

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RuleEngineComponentLifecycleEventNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsEight() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}, and {@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
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
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}, and {@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.action(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.randomUUID()))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
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
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName(null)
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("42")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder2
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName(null)
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationInfo.builder());
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder builderResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder();
    builderResult.componentId(TenantId.SYS_TENANT_ID);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder builderResult = RuleEngineComponentLifecycleEventNotificationInfo
        .builder();
    builderResult.componentName("Rule Chain Name");
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(Mockito.<String>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder2 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder ruleEngineComponentLifecycleEventNotificationInfoBuilder3 = mock(
        RuleEngineComponentLifecycleEventNotificationInfoBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationInfoBuilder3.action(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventNotificationInfoBuilder2);
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = ruleEngineComponentLifecycleEventNotificationInfoBuilder3
        .action("Action")
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name")
        .error("An error occurred")
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .build();
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
      "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#RuleEngineComponentLifecycleEventNotificationInfo()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setAction(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setError(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setEventType(ComponentLifecycleEvent)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#toString()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getAction()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentId()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentName()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getError()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getEventType()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainId()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainName()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getStateEntityId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineComponentLifecycleEventNotificationInfo.<init>()",
      "void RuleEngineComponentLifecycleEventNotificationInfo.<init>(RuleChainId, String, EntityId, String, String, ComponentLifecycleEvent, String)",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getAction()",
      "EntityId RuleEngineComponentLifecycleEventNotificationInfo.getComponentId()",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getComponentName()",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getError()",
      "ComponentLifecycleEvent RuleEngineComponentLifecycleEventNotificationInfo.getEventType()",
      "RuleChainId RuleEngineComponentLifecycleEventNotificationInfo.getRuleChainId()",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getRuleChainName()",
      "EntityId RuleEngineComponentLifecycleEventNotificationInfo.getStateEntityId()",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setAction(String)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setComponentId(EntityId)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setComponentName(String)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setError(String)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setEventType(ComponentLifecycleEvent)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setRuleChainId(RuleChainId)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setRuleChainName(String)",
      "String RuleEngineComponentLifecycleEventNotificationInfo.toString()"})
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

    // Assert
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is {@link EntityId#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#RuleEngineComponentLifecycleEventNotificationInfo(RuleChainId, String, EntityId, String, String, ComponentLifecycleEvent, String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setAction(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setError(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setEventType(ComponentLifecycleEvent)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setRuleChainName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#toString()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getAction()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentId()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getComponentName()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getError()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getEventType()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainId()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getRuleChainName()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#getStateEntityId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when RuleChainId(UUID) with id is NULL_UUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineComponentLifecycleEventNotificationInfo.<init>()",
      "void RuleEngineComponentLifecycleEventNotificationInfo.<init>(RuleChainId, String, EntityId, String, String, ComponentLifecycleEvent, String)",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getAction()",
      "EntityId RuleEngineComponentLifecycleEventNotificationInfo.getComponentId()",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getComponentName()",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getError()",
      "ComponentLifecycleEvent RuleEngineComponentLifecycleEventNotificationInfo.getEventType()",
      "RuleChainId RuleEngineComponentLifecycleEventNotificationInfo.getRuleChainId()",
      "String RuleEngineComponentLifecycleEventNotificationInfo.getRuleChainName()",
      "EntityId RuleEngineComponentLifecycleEventNotificationInfo.getStateEntityId()",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setAction(String)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setComponentId(EntityId)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setComponentName(String)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setError(String)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setEventType(ComponentLifecycleEvent)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setRuleChainId(RuleChainId)",
      "void RuleEngineComponentLifecycleEventNotificationInfo.setRuleChainName(String)",
      "String RuleEngineComponentLifecycleEventNotificationInfo.toString()"})
  void testGettersAndSetters_whenRuleChainIdWithIdIsNull_uuid() {
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

    // Assert
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
   * Test RuleEngineComponentLifecycleEventNotificationInfoBuilder {@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#build()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#action(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#componentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#componentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#error(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#eventType(ComponentLifecycleEvent)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#ruleChainId(RuleChainId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#ruleChainName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleEngineComponentLifecycleEventNotificationInfoBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineComponentLifecycleEventNotificationInfoBuilder.<init>()",
      "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.action(String)",
      "RuleEngineComponentLifecycleEventNotificationInfo RuleEngineComponentLifecycleEventNotificationInfoBuilder.build()",
      "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(EntityId)",
      "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(String)",
      "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.error(String)",
      "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.eventType(ComponentLifecycleEvent)",
      "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.ruleChainId(RuleChainId)",
      "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.ruleChainName(String)",
      "String RuleEngineComponentLifecycleEventNotificationInfoBuilder.toString()"})
  void testRuleEngineComponentLifecycleEventNotificationInfoBuilderBuild() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult = RuleEngineComponentLifecycleEventNotificationInfo
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
