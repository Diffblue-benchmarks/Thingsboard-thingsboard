package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.thingsboard.server.common.data.id.AlarmId;
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
  private RuleEngineComponentLifecycleEventTriggerBuilder
      ruleEngineComponentLifecycleEventTriggerBuilder;

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}, and {@link
   * RuleEngineComponentLifecycleEventTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventTrigger, ruleEngineComponentLifecycleEventTrigger);
    int expectedHashCodeResult = ruleEngineComponentLifecycleEventTrigger.hashCode();
    assertEquals(expectedHashCodeResult, ruleEngineComponentLifecycleEventTrigger.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        componentNameResult
            .error(new Throwable())
            .eventType(ComponentLifecycleEvent.CREATED)
            .ruleChainId(null)
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(null)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder builderResult =
        RuleEngineComponentLifecycleEventTrigger.builder();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        builderResult
            .componentId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Rule Chain Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName(null);

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error(null)
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(null);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.STARTED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Component Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    RuleEngineComponentLifecycleEventTriggerBuilder ruleChainNameResult =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name");
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        ruleChainNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(null)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        componentNameResult
            .error(new Throwable())
            .eventType(ComponentLifecycleEvent.CREATED)
            .ruleChainId(null)
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        componentNameResult2
            .error(new Throwable())
            .eventType(ComponentLifecycleEvent.CREATED)
            .ruleChainId(null)
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(null)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(null)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName(null);

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventTrigger ruleEngineComponentLifecycleEventTrigger =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult2 =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName(null);

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult2 =
        componentNameResult2.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventTrigger,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        null);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventTrigger.equals(Object)",
    "int RuleEngineComponentLifecycleEventTrigger.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventTriggerBuilder componentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");

    RuleEngineComponentLifecycleEventTriggerBuilder eventTypeResult =
        componentNameResult.error(new Throwable()).eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        "Different type to RuleEngineComponentLifecycleEventTrigger");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventTrigger#RuleEngineComponentLifecycleEventTrigger(TenantId,
   *       RuleChainId, String, EntityId, String, ComponentLifecycleEvent, Throwable)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    "String RuleEngineComponentLifecycleEventTrigger.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Throwable error = new Throwable();

    // Act
    RuleEngineComponentLifecycleEventTrigger actualRuleEngineComponentLifecycleEventTrigger =
        new RuleEngineComponentLifecycleEventTrigger(
            TenantId.SYS_TENANT_ID,
            ruleChainId,
            "Rule Chain Name",
            TenantId.SYS_TENANT_ID,
            "Component Name",
            ComponentLifecycleEvent.CREATED,
            error);
    String actualToStringResult = actualRuleEngineComponentLifecycleEventTrigger.toString();
    EntityId actualComponentId = actualRuleEngineComponentLifecycleEventTrigger.getComponentId();
    String actualComponentName = actualRuleEngineComponentLifecycleEventTrigger.getComponentName();
    Throwable actualError = actualRuleEngineComponentLifecycleEventTrigger.getError();
    ComponentLifecycleEvent actualEventType =
        actualRuleEngineComponentLifecycleEventTrigger.getEventType();
    EntityId actualOriginatorEntityId =
        actualRuleEngineComponentLifecycleEventTrigger.getOriginatorEntityId();
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
    assertEquals(
        NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT,
        actualRuleEngineComponentLifecycleEventTrigger.getType());
    assertEquals(ComponentLifecycleEvent.CREATED, actualEventType);
    assertSame(error, actualError);
    assertSame(ruleChainId, actualRuleChainId);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualComponentId);
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test RuleEngineComponentLifecycleEventTriggerBuilder {@link
   * RuleEngineComponentLifecycleEventTriggerBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#build()}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#componentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#componentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#error(Throwable)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventTriggerBuilder#eventType(ComponentLifecycleEvent)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#ruleChainId(RuleChainId)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#ruleChainName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleEngineComponentLifecycleEventTriggerBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentLifecycleEventTriggerBuilder.<init>()",
    "RuleEngineComponentLifecycleEventTrigger RuleEngineComponentLifecycleEventTriggerBuilder.build()",
    "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.componentId(EntityId)",
    "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.componentName(String)",
    "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.error(Throwable)",
    "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.eventType(ComponentLifecycleEvent)",
    "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.ruleChainId(RuleChainId)",
    "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.ruleChainName(String)",
    "RuleEngineComponentLifecycleEventTriggerBuilder RuleEngineComponentLifecycleEventTriggerBuilder.tenantId(TenantId)",
    "String RuleEngineComponentLifecycleEventTriggerBuilder.toString()"
  })
  void testRuleEngineComponentLifecycleEventTriggerBuilderBuild() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventTriggerBuilder actualComponentNameResult =
        RuleEngineComponentLifecycleEventTrigger.builder()
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name");
    Throwable error = new Throwable();
    RuleEngineComponentLifecycleEventTriggerBuilder actualEventTypeResult =
        actualComponentNameResult.error(error).eventType(ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleEngineComponentLifecycleEventTrigger actualRuleEngineComponentLifecycleEventTrigger =
        actualEventTypeResult
            .ruleChainId(ruleChainId)
            .ruleChainName("Rule Chain Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Assert
    assertEquals(
        "Component Name", actualRuleEngineComponentLifecycleEventTrigger.getComponentName());
    assertEquals(
        "RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT:TENANT:13814000-1dd2-11b2-8080-808080808080",
        actualRuleEngineComponentLifecycleEventTrigger.getDeduplicationKey());
    assertEquals(
        "Rule Chain Name", actualRuleEngineComponentLifecycleEventTrigger.getRuleChainName());
    assertEquals(
        0L, actualRuleEngineComponentLifecycleEventTrigger.getDefaultDeduplicationDuration());
    assertEquals(
        NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT,
        actualRuleEngineComponentLifecycleEventTrigger.getType());
    assertEquals(
        ComponentLifecycleEvent.CREATED,
        actualRuleEngineComponentLifecycleEventTrigger.getEventType());
    assertFalse(actualRuleEngineComponentLifecycleEventTrigger.deduplicate());
    assertSame(error, actualRuleEngineComponentLifecycleEventTrigger.getError());
    assertSame(ruleChainId, actualRuleEngineComponentLifecycleEventTrigger.getRuleChainId());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualRuleEngineComponentLifecycleEventTrigger.getComponentId());
    assertSame(tenantId, actualRuleEngineComponentLifecycleEventTrigger.getOriginatorEntityId());
    assertSame(tenantId, actualRuleEngineComponentLifecycleEventTrigger.getTenantId());
  }
}
