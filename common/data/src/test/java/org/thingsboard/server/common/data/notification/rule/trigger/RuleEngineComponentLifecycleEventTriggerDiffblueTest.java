package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.notification.rule.trigger.RuleEngineComponentLifecycleEventTrigger.RuleEngineComponentLifecycleEventTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

@ContextConfiguration(classes = {RuleEngineComponentLifecycleEventTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class RuleEngineComponentLifecycleEventTriggerDiffblueTest {
  @Autowired
  private RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder;

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}, and {@link RuleEngineComponentLifecycleEventTrigger#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.error(Mockito.<Throwable>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder7 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder7.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder6);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder7
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}, and {@link RuleEngineComponentLifecycleEventTrigger#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger buildResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED)
        .ruleChainId(null)
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleChainNameResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name");
    RuleEngineComponentLifecycleEventTrigger buildResult = ruleChainNameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(null)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder2
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder2
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentId(Mockito.<EntityId>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder3
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder2
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.error(Mockito.<Throwable>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder3
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder4);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder5
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder builderResult = RuleEngineComponentLifecycleEventTrigger.builder();
    builderResult.componentId(TenantId.SYS_TENANT_ID);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder builderResult = RuleEngineComponentLifecycleEventTrigger.builder();
    builderResult.componentName("Rule Chain Name");
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.componentName(Mockito.<String>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder6
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder builderResult = RuleEngineComponentLifecycleEventTrigger.builder();
    builderResult.eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder.eventType(Mockito.<ComponentLifecycleEvent>any()))
        .thenReturn(builderResult);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder2 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder2.error(Mockito.<Throwable>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder3 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder3.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder2);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder4 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder4.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder3);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = ruleEngineComponentLifecycleEventTriggerBuilder4
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
        .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger buildResult = eventTypeResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ruleChainName("Rule Chain Name")
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder5 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder5.error(Mockito.<Throwable>any()))
        .thenReturn(RuleEngineComponentLifecycleEventTrigger.builder());
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder6 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder6.componentName(Mockito.<String>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder5);
    RuleEngineComponentLifecycleEventTriggerBuilder ruleEngineComponentLifecycleEventTriggerBuilder7 = mock(
        RuleEngineComponentLifecycleEventTriggerBuilder.class);
    when(ruleEngineComponentLifecycleEventTriggerBuilder7.componentId(Mockito.<EntityId>any()))
        .thenReturn(ruleEngineComponentLifecycleEventTriggerBuilder6);
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 = ruleEngineComponentLifecycleEventTriggerBuilder7
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 = componentNameResult2.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
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
   * Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
      "int RuleEngineComponentLifecycleEventTrigger.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(new Throwable())
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
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#RuleEngineComponentLifecycleEventTrigger(TenantId, RuleChainId, String, EntityId, String, ComponentLifecycleEvent, Throwable)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void RuleEngineComponentLifecycleEventTrigger.<init>(TenantId, RuleChainId, String, EntityId, String, ComponentLifecycleEvent, Throwable)",
      "EntityId RuleEngineComponentLifecycleEventTrigger.getComponentId()",
      "String RuleEngineComponentLifecycleEventTrigger.getComponentName()",
      "Throwable RuleEngineComponentLifecycleEventTrigger.getError()",
      "ComponentLifecycleEvent RuleEngineComponentLifecycleEventTrigger.getEventType()",
      "EntityId RuleEngineComponentLifecycleEventTrigger.getOriginatorEntityId()",
      "RuleChainId RuleEngineComponentLifecycleEventTrigger.getRuleChainId()",
      "String RuleEngineComponentLifecycleEventTrigger.getRuleChainName()",
      "TenantId RuleEngineComponentLifecycleEventTrigger.getTenantId()",
      "NotificationRuleTriggerType RuleEngineComponentLifecycleEventTrigger.getType()",
      "String RuleEngineComponentLifecycleEventTrigger.toString()"})
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
   * Test RuleEngineComponentLifecycleEventTriggerBuilder {@link RuleEngineComponentLifecycleEventTriggerBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#build()}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#componentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#componentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#error(Throwable)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#eventType(ComponentLifecycleEvent)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#ruleChainId(RuleChainId)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#ruleChainName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleEngineComponentLifecycleEventTriggerBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineComponentLifecycleEventTriggerBuilder.<init>()",
      "RuleEngineComponentLifecycleEventTrigger RuleEngineComponentLifecycleEventTriggerBuilder.build()",
      "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.componentId(EntityId)",
      "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.componentName(String)",
      "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.error(Throwable)",
      "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.eventType(ComponentLifecycleEvent)",
      "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.ruleChainId(RuleChainId)",
      "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.ruleChainName(String)",
      "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.tenantId(TenantId)",
      "String RuleEngineComponentLifecycleEventTriggerBuilder.toString()"})
  void testRuleEngineComponentLifecycleEventTriggerBuilderBuild() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult = RuleEngineComponentLifecycleEventTrigger
        .builder()
        .componentId(TenantId.SYS_TENANT_ID)
        .componentName("Component Name");
    Throwable error = new Throwable();
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult = componentNameResult.error(error)
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
