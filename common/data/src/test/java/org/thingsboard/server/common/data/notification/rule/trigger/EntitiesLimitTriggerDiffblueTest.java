package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.EntitiesLimitTrigger.EntitiesLimitTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class EntitiesLimitTriggerDiffblueTest {
  /**
   * Test EntitiesLimitTriggerBuilder {@link EntitiesLimitTriggerBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitTrigger.EntitiesLimitTriggerBuilder#build()}
   *   <li>
   * {@link EntitiesLimitTrigger.EntitiesLimitTriggerBuilder#currentCount(long)}
   *   <li>
   * {@link EntitiesLimitTrigger.EntitiesLimitTriggerBuilder#entityType(EntityType)}
   *   <li>{@link EntitiesLimitTrigger.EntitiesLimitTriggerBuilder#limit(long)}
   *   <li>
   * {@link EntitiesLimitTrigger.EntitiesLimitTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntitiesLimitTriggerBuilder build()")
  void testEntitiesLimitTriggerBuilderBuild() {
    // Arrange and Act
    EntitiesLimitTrigger actualBuildResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    EntityId originatorEntityId = actualBuildResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals("ENTITIES_LIMIT:TENANT:13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getDeduplicationKey());
    assertEquals(0L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(1L, actualBuildResult.getLimit());
    assertEquals(3L, actualBuildResult.getCurrentCount());
    assertEquals(EntityType.TENANT, actualBuildResult.getEntityType());
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT, actualBuildResult.getType());
    assertFalse(actualBuildResult.deduplicate());
    assertSame(originatorEntityId, actualBuildResult.getTenantId());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}, and
   * {@link EntitiesLimitTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitTrigger#equals(Object)}
   *   <li>{@link EntitiesLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesLimitTrigger buildResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    EntitiesLimitTrigger buildResult2 = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}, and
   * {@link EntitiesLimitTrigger#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitTrigger#equals(Object)}
   *   <li>{@link EntitiesLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesLimitTrigger buildResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitTrigger.EntitiesLimitTriggerBuilder entitiesLimitTriggerBuilder = mock(
        EntitiesLimitTrigger.EntitiesLimitTriggerBuilder.class);
    when(entitiesLimitTriggerBuilder.currentCount(anyLong())).thenReturn(EntitiesLimitTrigger.builder());
    EntitiesLimitTrigger buildResult = entitiesLimitTriggerBuilder.currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    EntitiesLimitTrigger buildResult2 = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesLimitTrigger.EntitiesLimitTriggerBuilder entitiesLimitTriggerBuilder = mock(
        EntitiesLimitTrigger.EntitiesLimitTriggerBuilder.class);
    when(entitiesLimitTriggerBuilder.currentCount(anyLong())).thenReturn(EntitiesLimitTrigger.builder());
    EntitiesLimitTrigger buildResult = entitiesLimitTriggerBuilder.currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(3L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    EntitiesLimitTrigger buildResult2 = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitTrigger buildResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitTrigger buildResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntitiesLimitTrigger");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitTrigger#setCurrentCount(long)}
   *   <li>{@link EntitiesLimitTrigger#setLimit(long)}
   *   <li>{@link EntitiesLimitTrigger#toString()}
   *   <li>{@link EntitiesLimitTrigger#getCurrentCount()}
   *   <li>{@link EntitiesLimitTrigger#getEntityType()}
   *   <li>{@link EntitiesLimitTrigger#getLimit()}
   *   <li>{@link EntitiesLimitTrigger#getOriginatorEntityId()}
   *   <li>{@link EntitiesLimitTrigger#getTenantId()}
   *   <li>{@link EntitiesLimitTrigger#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    EntitiesLimitTrigger buildResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act
    buildResult.setCurrentCount(3L);
    buildResult.setLimit(1L);
    String actualToStringResult = buildResult.toString();
    long actualCurrentCount = buildResult.getCurrentCount();
    EntityType actualEntityType = buildResult.getEntityType();
    long actualLimit = buildResult.getLimit();
    EntityId actualOriginatorEntityId = buildResult.getOriginatorEntityId();
    TenantId actualTenantId = buildResult.getTenantId();

    // Assert that nothing has changed
    assertEquals("EntitiesLimitTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=TENANT, limit=1,"
        + " currentCount=3)", actualToStringResult);
    assertEquals(1L, actualLimit);
    assertEquals(3L, actualCurrentCount);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT, buildResult.getType());
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link EntitiesLimitTrigger#EntitiesLimitTrigger(TenantId, EntityType, long, long)}.
   * <p>
   * Method under test:
   * {@link EntitiesLimitTrigger#EntitiesLimitTrigger(TenantId, EntityType, long, long)}
   */
  @Test
  @DisplayName("Test new EntitiesLimitTrigger(TenantId, EntityType, long, long)")
  void testNewEntitiesLimitTrigger() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    EntitiesLimitTrigger actualEntitiesLimitTrigger = new EntitiesLimitTrigger(tenantId, EntityType.TENANT, 1L, 3L);

    // Assert
    assertEquals("ENTITIES_LIMIT:TENANT:13814000-1dd2-11b2-8080-808080808080",
        actualEntitiesLimitTrigger.getDeduplicationKey());
    assertEquals(0L, actualEntitiesLimitTrigger.getDefaultDeduplicationDuration());
    assertEquals(1L, actualEntitiesLimitTrigger.getLimit());
    assertEquals(3L, actualEntitiesLimitTrigger.getCurrentCount());
    assertEquals(EntityType.TENANT, actualEntitiesLimitTrigger.getEntityType());
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT, actualEntitiesLimitTrigger.getType());
    assertFalse(actualEntitiesLimitTrigger.deduplicate());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntitiesLimitTrigger.getOriginatorEntityId());
    assertSame(tenantId2, actualEntitiesLimitTrigger.getTenantId());
  }
}
