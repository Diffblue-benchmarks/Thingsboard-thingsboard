package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.notification.rule.trigger.RateLimitsTrigger.RateLimitsTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {RateLimitsTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class RateLimitsTriggerDiffblueTest {
  @Autowired private RateLimitsTriggerBuilder rateLimitsTriggerBuilder;

  /**
   * Test {@link RateLimitsTrigger#getOriginatorEntityId()}.
   *
   * <p>Method under test: {@link RateLimitsTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RateLimitsTrigger.getOriginatorEntityId()"})
  void testGetOriginatorEntityId() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        new RateLimitsTrigger(
            TenantId.SYS_TENANT_ID,
            LimitedApi.ENTITY_EXPORT,
            TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name");

    // Act
    EntityId actualOriginatorEntityId = rateLimitsTrigger.getOriginatorEntityId();

    // Assert
    TenantId tenantId = ((TenantId) actualOriginatorEntityId).SYS_TENANT_ID;
    assertSame(tenantId, rateLimitsTrigger.getLimitLevel());
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, rateLimitsTrigger.getTenantId());
  }

  /**
   * Test {@link RateLimitsTrigger#getOriginatorEntityId()}.
   *
   * <p>Method under test: {@link RateLimitsTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RateLimitsTrigger.getOriginatorEntityId()"})
  void testGetOriginatorEntityId2() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        new RateLimitsTrigger(
            TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, null, "Limit Level Entity Name");

    // Act
    EntityId actualOriginatorEntityId = rateLimitsTrigger.getOriginatorEntityId();

    // Assert
    assertNull(rateLimitsTrigger.getLimitLevel());
    TenantId tenantId = ((TenantId) actualOriginatorEntityId).SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, rateLimitsTrigger.getTenantId());
  }

  /**
   * Test {@link RateLimitsTrigger#deduplicate()}.
   *
   * <p>Method under test: {@link RateLimitsTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RateLimitsTrigger.deduplicate()"})
  void testDeduplicate() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        new RateLimitsTrigger(
            TenantId.SYS_TENANT_ID,
            LimitedApi.ENTITY_EXPORT,
            TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name");

    // Act and Assert
    assertTrue(rateLimitsTrigger.deduplicate());
  }

  /**
   * Test {@link RateLimitsTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link RateLimitsTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RateLimitsTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        new RateLimitsTrigger(
            TenantId.SYS_TENANT_ID,
            LimitedApi.ENTITY_EXPORT,
            TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name");

    // Act and Assert
    assertEquals(
        "RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        rateLimitsTrigger.getDeduplicationKey());
  }

  /**
   * Test {@link RateLimitsTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link RateLimitsTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RateLimitsTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey2() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        new RateLimitsTrigger(
            TenantId.SYS_TENANT_ID, LimitedApi.ENTITY_EXPORT, null, "Limit Level Entity Name");

    // Act and Assert
    assertEquals(
        "RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        rateLimitsTrigger.getDeduplicationKey());
  }

  /**
   * Test {@link RateLimitsTrigger#getDefaultDeduplicationDuration()}.
   *
   * <p>Method under test: {@link RateLimitsTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RateLimitsTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        new RateLimitsTrigger(
            TenantId.SYS_TENANT_ID,
            LimitedApi.ENTITY_EXPORT,
            TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name");

    // Act and Assert
    assertEquals(14400000L, rateLimitsTrigger.getDefaultDeduplicationDuration());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    RateLimitsTrigger rateLimitsTrigger2 =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(rateLimitsTrigger, rateLimitsTrigger2);
    assertEquals(rateLimitsTrigger.hashCode(), rateLimitsTrigger2.hashCode());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(null)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    RateLimitsTrigger rateLimitsTrigger2 =
        RateLimitsTrigger.builder()
            .api(null)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(rateLimitsTrigger, rateLimitsTrigger2);
    assertEquals(rateLimitsTrigger.hashCode(), rateLimitsTrigger2.hashCode());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(null)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    RateLimitsTrigger rateLimitsTrigger2 =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(null)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(rateLimitsTrigger, rateLimitsTrigger2);
    assertEquals(rateLimitsTrigger.hashCode(), rateLimitsTrigger2.hashCode());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    RateLimitsTrigger rateLimitsTrigger2 =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(rateLimitsTrigger, rateLimitsTrigger2);
    assertEquals(rateLimitsTrigger.hashCode(), rateLimitsTrigger2.hashCode());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(null)
            .build();
    RateLimitsTrigger rateLimitsTrigger2 =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(null)
            .build();

    // Act and Assert
    assertEquals(rateLimitsTrigger, rateLimitsTrigger2);
    assertEquals(rateLimitsTrigger.hashCode(), rateLimitsTrigger2.hashCode());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}, and {@link RateLimitsTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTrigger#equals(Object)}
   *   <li>{@link RateLimitsTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(rateLimitsTrigger, rateLimitsTrigger);
    int expectedHashCodeResult = rateLimitsTrigger.hashCode();
    assertEquals(expectedHashCodeResult, rateLimitsTrigger.hashCode());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(null)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_IMPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(null)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateLimitsTriggerBuilder apiResult = RateLimitsTrigger.builder().api(LimitedApi.ENTITY_EXPORT);
    RateLimitsTrigger rateLimitsTrigger =
        apiResult
            .limitLevel(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RateLimitsTriggerBuilder limitLevelEntityNameResult =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name");
    RateLimitsTrigger rateLimitsTrigger =
        limitLevelEntityNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RateLimitsTrigger rateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(null)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsTrigger,
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        null);
  }

  /**
   * Test {@link RateLimitsTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsTrigger.equals(Object)",
    "int RateLimitsTrigger.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        "Different type to RateLimitsTrigger");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTrigger#RateLimitsTrigger(TenantId, LimitedApi, EntityId, String)}
   *   <li>{@link RateLimitsTrigger#toString()}
   *   <li>{@link RateLimitsTrigger#getApi()}
   *   <li>{@link RateLimitsTrigger#getLimitLevel()}
   *   <li>{@link RateLimitsTrigger#getLimitLevelEntityName()}
   *   <li>{@link RateLimitsTrigger#getTenantId()}
   *   <li>{@link RateLimitsTrigger#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateLimitsTrigger.<init>(TenantId, LimitedApi, EntityId, String)",
    "LimitedApi RateLimitsTrigger.getApi()",
    "EntityId RateLimitsTrigger.getLimitLevel()",
    "String RateLimitsTrigger.getLimitLevelEntityName()",
    "TenantId RateLimitsTrigger.getTenantId()",
    "NotificationRuleTriggerType RateLimitsTrigger.getType()",
    "String RateLimitsTrigger.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RateLimitsTrigger actualRateLimitsTrigger =
        new RateLimitsTrigger(
            TenantId.SYS_TENANT_ID,
            LimitedApi.ENTITY_EXPORT,
            TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name");
    String actualToStringResult = actualRateLimitsTrigger.toString();
    LimitedApi actualApi = actualRateLimitsTrigger.getApi();
    EntityId actualLimitLevel = actualRateLimitsTrigger.getLimitLevel();
    String actualLimitLevelEntityName = actualRateLimitsTrigger.getLimitLevelEntityName();
    TenantId actualTenantId = actualRateLimitsTrigger.getTenantId();

    // Assert
    assertEquals("Limit Level Entity Name", actualLimitLevelEntityName);
    assertEquals(
        "RateLimitsTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, api=ENTITY_EXPORT, limitLevel=13814000"
            + "-1dd2-11b2-8080-808080808080, limitLevelEntityName=Limit Level Entity Name)",
        actualToStringResult);
    assertEquals(LimitedApi.ENTITY_EXPORT, actualApi);
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS, actualRateLimitsTrigger.getType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualLimitLevel);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test RateLimitsTriggerBuilder {@link RateLimitsTriggerBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsTriggerBuilder#build()}
   *   <li>{@link RateLimitsTriggerBuilder#api(LimitedApi)}
   *   <li>{@link RateLimitsTriggerBuilder#limitLevel(EntityId)}
   *   <li>{@link RateLimitsTriggerBuilder#limitLevelEntityName(String)}
   *   <li>{@link RateLimitsTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test RateLimitsTriggerBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateLimitsTriggerBuilder.<init>()",
    "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.api(LimitedApi)",
    "RateLimitsTrigger RateLimitsTriggerBuilder.build()",
    "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.limitLevel(EntityId)",
    "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.limitLevelEntityName(String)",
    "RateLimitsTriggerBuilder RateLimitsTriggerBuilder.tenantId(TenantId)",
    "String RateLimitsTriggerBuilder.toString()"
  })
  void testRateLimitsTriggerBuilderBuild() {
    // Arrange and Act
    RateLimitsTrigger actualRateLimitsTrigger =
        RateLimitsTrigger.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Assert
    assertEquals("Limit Level Entity Name", actualRateLimitsTrigger.getLimitLevelEntityName());
    assertEquals(
        "RATE_LIMITS:TENANT:13814000-1dd2-11b2-8080-808080808080:ENTITY_EXPORT",
        actualRateLimitsTrigger.getDeduplicationKey());
    assertEquals(14400000L, actualRateLimitsTrigger.getDefaultDeduplicationDuration());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualRateLimitsTrigger.getApi());
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS, actualRateLimitsTrigger.getType());
    assertTrue(actualRateLimitsTrigger.deduplicate());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualRateLimitsTrigger.getLimitLevel());
    assertSame(tenantId, actualRateLimitsTrigger.getOriginatorEntityId());
    assertSame(tenantId, actualRateLimitsTrigger.getTenantId());
  }
}
