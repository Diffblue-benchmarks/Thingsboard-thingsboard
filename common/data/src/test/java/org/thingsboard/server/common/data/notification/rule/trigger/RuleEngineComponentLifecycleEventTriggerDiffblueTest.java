package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class RuleEngineComponentLifecycleEventTriggerDiffblueTest {
  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}, and
   * {@link RuleEngineComponentLifecycleEventTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}, and
   * {@link RuleEngineComponentLifecycleEventTrigger#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder ruleChainNameResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name");
    RuleEngineComponentLifecycleEventTrigger buildResult = ruleChainNameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2
        .error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult2 = eventTypeResult2
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleEngineComponentLifecycleEventTrigger");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
            + "=784f394c-42b6-435a-983c-b7beff2784f9, ruleChainName=Rule Chain Name, componentId=13814000-1dd2-11b2"
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
   * Test RuleEngineComponentLifecycleEventTriggerBuilder
   * {@link RuleEngineComponentLifecycleEventTriggerBuilder#build()}.
   * <p>
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
  @DisplayName("Test RuleEngineComponentLifecycleEventTriggerBuilder build()")
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
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
