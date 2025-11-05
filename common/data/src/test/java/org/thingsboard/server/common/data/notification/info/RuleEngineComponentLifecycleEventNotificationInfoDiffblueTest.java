package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
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
import org.thingsboard.server.common.data.notification.info.RuleEngineComponentLifecycleEventNotificationInfo.RuleEngineComponentLifecycleEventNotificationInfoBuilder;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

@ContextConfiguration(classes = {RuleEngineComponentLifecycleEventNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class RuleEngineComponentLifecycleEventNotificationInfoDiffblueTest {
  @Autowired
  private RuleEngineComponentLifecycleEventNotificationInfoBuilder
      ruleEngineComponentLifecycleEventNotificationInfoBuilder;

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return size is eight.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RuleEngineComponentLifecycleEventNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsEight() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act
    Map<String, String> actualTemplateData =
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build()
            .getTemplateData();

    // Assert
    assertEquals(8, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("componentId"));
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateData.get("ruleChainId"));
    assertEquals("Action", actualTemplateData.get("action"));
    assertEquals("An error occurred", actualTemplateData.get("error"));
    assertEquals("Component Name", actualTemplateData.get("componentName"));
    assertEquals("Rule Chain Name", actualTemplateData.get("ruleChainName"));
    assertEquals("Tenant", actualTemplateData.get("componentType"));
    assertEquals("created", actualTemplateData.get("eventType"));
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}, and {@link
   * RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo2 =
            eventTypeResult2
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        ruleEngineComponentLifecycleEventNotificationInfo2);
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo.hashCode(),
        ruleEngineComponentLifecycleEventNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}, and {@link
   * RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            RuleEngineComponentLifecycleEventNotificationInfo.builder()
                .action("Action")
                .componentId(TenantId.SYS_TENANT_ID)
                .componentName("Component Name")
                .error("An error occurred")
                .eventType(ComponentLifecycleEvent.CREATED)
                .ruleChainId(null)
                .ruleChainName("Rule Chain Name")
                .build();
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo2 =
            RuleEngineComponentLifecycleEventNotificationInfo.builder()
                .action("Action")
                .componentId(TenantId.SYS_TENANT_ID)
                .componentName("Component Name")
                .error("An error occurred")
                .eventType(ComponentLifecycleEvent.CREATED)
                .ruleChainId(null)
                .ruleChainName("Rule Chain Name")
                .build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        ruleEngineComponentLifecycleEventNotificationInfo2);
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo.hashCode(),
        ruleEngineComponentLifecycleEventNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}, and {@link
   * RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action(null)
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action(null)
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo2 =
            eventTypeResult2
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        ruleEngineComponentLifecycleEventNotificationInfo2);
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo.hashCode(),
        ruleEngineComponentLifecycleEventNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}, and {@link
   * RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(null)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(null)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo2 =
            eventTypeResult2
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        ruleEngineComponentLifecycleEventNotificationInfo2);
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo.hashCode(),
        ruleEngineComponentLifecycleEventNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}, and {@link
   * RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        ruleEngineComponentLifecycleEventNotificationInfo);
    int expectedHashCodeResult = ruleEngineComponentLifecycleEventNotificationInfo.hashCode();
    assertEquals(
        expectedHashCodeResult, ruleEngineComponentLifecycleEventNotificationInfo.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(new RuleChainId(EntityId.NULL_UUID))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            RuleEngineComponentLifecycleEventNotificationInfo.builder()
                .action("Action")
                .componentId(TenantId.SYS_TENANT_ID)
                .componentName("Component Name")
                .error("An error occurred")
                .eventType(ComponentLifecycleEvent.CREATED)
                .ruleChainId(null)
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Rule Chain Name")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action(null)
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(null)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder actionResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder().action("Action");

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        actionResult
            .componentId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Rule Chain Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName(null)
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("Rule Chain Name")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error(null)
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(null);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.STARTED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Rule Chain Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName("Component Name")
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationInfo
        ruleEngineComponentLifecycleEventNotificationInfo =
            eventTypeResult
                .ruleChainId(
                    new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ruleChainName(null)
                .build();

    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult2 =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationInfo,
        eventTypeResult2
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build(),
        null);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineComponentLifecycleEventNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationInfo.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationInfoBuilder eventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(
        eventTypeResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleChainName("Rule Chain Name")
            .build(),
        "Different type to RuleEngineComponentLifecycleEventNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationInfo#RuleEngineComponentLifecycleEventNotificationInfo()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setAction(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setError(String)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationInfo#setEventType(ComponentLifecycleEvent)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentLifecycleEventNotificationInfo.<init>()",
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
    "String RuleEngineComponentLifecycleEventNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventNotificationInfo
        actualRuleEngineComponentLifecycleEventNotificationInfo =
            new RuleEngineComponentLifecycleEventNotificationInfo();
    actualRuleEngineComponentLifecycleEventNotificationInfo.setAction("Action");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentId(TenantId.SYS_TENANT_ID);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentName("Component Name");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setError("An error occurred");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setEventType(
        ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainId(ruleChainId);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainName("Rule Chain Name");
    String actualToStringResult =
        actualRuleEngineComponentLifecycleEventNotificationInfo.toString();
    String actualAction = actualRuleEngineComponentLifecycleEventNotificationInfo.getAction();
    EntityId actualComponentId =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentId();
    String actualComponentName =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentName();
    String actualError = actualRuleEngineComponentLifecycleEventNotificationInfo.getError();
    ComponentLifecycleEvent actualEventType =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getEventType();
    RuleChainId actualRuleChainId =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainId();
    String actualRuleChainName =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainName();

    // Assert
    assertEquals("Action", actualAction);
    assertEquals("An error occurred", actualError);
    assertEquals("Component Name", actualComponentName);
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertEquals(
        "RuleEngineComponentLifecycleEventNotificationInfo(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " ruleChainName=Rule Chain Name, componentId=13814000-1dd2-11b2-8080-808080808080, componentName=Component"
            + " Name, action=Action, eventType=CREATED, error=An error occurred)",
        actualToStringResult);
    assertEquals(ComponentLifecycleEvent.CREATED, actualEventType);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(
        ruleChainId, actualRuleEngineComponentLifecycleEventNotificationInfo.getStateEntityId());
    assertSame(((TenantId) actualComponentId).SYS_TENANT_ID, actualComponentId);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationInfo#RuleEngineComponentLifecycleEventNotificationInfo(RuleChainId,
   *       String, EntityId, String, String, ComponentLifecycleEvent, String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setAction(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setComponentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfo#setError(String)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationInfo#setEventType(ComponentLifecycleEvent)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentLifecycleEventNotificationInfo.<init>()",
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
    "String RuleEngineComponentLifecycleEventNotificationInfo.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleEngineComponentLifecycleEventNotificationInfo
        actualRuleEngineComponentLifecycleEventNotificationInfo =
            new RuleEngineComponentLifecycleEventNotificationInfo(
                ruleChainId,
                "Rule Chain Name",
                TenantId.SYS_TENANT_ID,
                "Component Name",
                "Action",
                ComponentLifecycleEvent.CREATED,
                "An error occurred");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setAction("Action");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentId(TenantId.SYS_TENANT_ID);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setComponentName("Component Name");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setError("An error occurred");
    actualRuleEngineComponentLifecycleEventNotificationInfo.setEventType(
        ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainId(ruleChainId2);
    actualRuleEngineComponentLifecycleEventNotificationInfo.setRuleChainName("Rule Chain Name");
    String actualToStringResult =
        actualRuleEngineComponentLifecycleEventNotificationInfo.toString();
    String actualAction = actualRuleEngineComponentLifecycleEventNotificationInfo.getAction();
    EntityId actualComponentId =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentId();
    String actualComponentName =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentName();
    String actualError = actualRuleEngineComponentLifecycleEventNotificationInfo.getError();
    ComponentLifecycleEvent actualEventType =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getEventType();
    RuleChainId actualRuleChainId =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainId();
    String actualRuleChainName =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainName();

    // Assert
    assertEquals("Action", actualAction);
    assertEquals("An error occurred", actualError);
    assertEquals("Component Name", actualComponentName);
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertEquals(
        "RuleEngineComponentLifecycleEventNotificationInfo(ruleChainId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " ruleChainName=Rule Chain Name, componentId=13814000-1dd2-11b2-8080-808080808080, componentName=Component"
            + " Name, action=Action, eventType=CREATED, error=An error occurred)",
        actualToStringResult);
    assertEquals(ComponentLifecycleEvent.CREATED, actualEventType);
    assertSame(ruleChainId2, actualRuleChainId);
    assertSame(
        ruleChainId2, actualRuleEngineComponentLifecycleEventNotificationInfo.getStateEntityId());
    assertSame(((TenantId) actualComponentId).SYS_TENANT_ID, actualComponentId);
  }

  /**
   * Test RuleEngineComponentLifecycleEventNotificationInfoBuilder {@link
   * RuleEngineComponentLifecycleEventNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#build()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#action(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#componentId(EntityId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#componentName(String)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#error(String)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationInfoBuilder#eventType(ComponentLifecycleEvent)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#ruleChainId(RuleChainId)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationInfoBuilder#ruleChainName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleEngineComponentLifecycleEventNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentLifecycleEventNotificationInfoBuilder.<init>()",
    "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.action(String)",
    "RuleEngineComponentLifecycleEventNotificationInfo RuleEngineComponentLifecycleEventNotificationInfoBuilder.build()",
    "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.componentId(EntityId)",
    "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.componentName(String)",
    "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.error(String)",
    "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.eventType(ComponentLifecycleEvent)",
    "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.ruleChainId(RuleChainId)",
    "RuleEngineComponentLifecycleEventNotificationInfoBuilder RuleEngineComponentLifecycleEventNotificationInfoBuilder.ruleChainName(String)",
    "String RuleEngineComponentLifecycleEventNotificationInfoBuilder.toString()"
  })
  void testRuleEngineComponentLifecycleEventNotificationInfoBuilderBuild() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventNotificationInfoBuilder actualEventTypeResult =
        RuleEngineComponentLifecycleEventNotificationInfo.builder()
            .action("Action")
            .componentId(TenantId.SYS_TENANT_ID)
            .componentName("Component Name")
            .error("An error occurred")
            .eventType(ComponentLifecycleEvent.CREATED);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleEngineComponentLifecycleEventNotificationInfo
        actualRuleEngineComponentLifecycleEventNotificationInfo =
            actualEventTypeResult.ruleChainId(ruleChainId).ruleChainName("Rule Chain Name").build();

    // Assert
    Map<String, String> templateData =
        actualRuleEngineComponentLifecycleEventNotificationInfo.getTemplateData();
    assertEquals(8, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("componentId"));
    assertEquals("Action", templateData.get("action"));
    assertEquals("Action", actualRuleEngineComponentLifecycleEventNotificationInfo.getAction());
    assertEquals("An error occurred", templateData.get("error"));
    assertEquals(
        "An error occurred", actualRuleEngineComponentLifecycleEventNotificationInfo.getError());
    assertEquals("Component Name", templateData.get("componentName"));
    assertEquals(
        "Component Name",
        actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentName());
    assertEquals(
        "Rule Chain Name",
        actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainName());
    assertEquals("Tenant", templateData.get("componentType"));
    assertEquals("created", templateData.get("eventType"));
    assertNull(actualRuleEngineComponentLifecycleEventNotificationInfo.getAffectedCustomerId());
    assertNull(actualRuleEngineComponentLifecycleEventNotificationInfo.getDashboardId());
    assertNull(actualRuleEngineComponentLifecycleEventNotificationInfo.getAffectedTenantId());
    assertNull(actualRuleEngineComponentLifecycleEventNotificationInfo.getAffectedUserId());
    assertEquals(
        ComponentLifecycleEvent.CREATED,
        actualRuleEngineComponentLifecycleEventNotificationInfo.getEventType());
    assertSame(
        ruleChainId, actualRuleEngineComponentLifecycleEventNotificationInfo.getRuleChainId());
    assertSame(
        ruleChainId, actualRuleEngineComponentLifecycleEventNotificationInfo.getStateEntityId());
    assertSame(
        TenantId.SYS_TENANT_ID,
        actualRuleEngineComponentLifecycleEventNotificationInfo.getComponentId());
  }
}
