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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.EntitiesLimitTrigger.EntitiesLimitTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {EntitiesLimitTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class EntitiesLimitTriggerDiffblueTest {
  @Autowired private EntitiesLimitTriggerBuilder entitiesLimitTriggerBuilder;

  /**
   * Test EntitiesLimitTriggerBuilder {@link EntitiesLimitTriggerBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitTriggerBuilder#build()}
   *   <li>{@link EntitiesLimitTriggerBuilder#currentCount(long)}
   *   <li>{@link EntitiesLimitTriggerBuilder#entityType(EntityType)}
   *   <li>{@link EntitiesLimitTriggerBuilder#limit(long)}
   *   <li>{@link EntitiesLimitTriggerBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntitiesLimitTriggerBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesLimitTriggerBuilder.<init>()",
    "EntitiesLimitTrigger EntitiesLimitTriggerBuilder.build()",
    "EntitiesLimitTriggerBuilder EntitiesLimitTriggerBuilder.currentCount(long)",
    "EntitiesLimitTriggerBuilder EntitiesLimitTriggerBuilder.entityType(EntityType)",
    "EntitiesLimitTriggerBuilder EntitiesLimitTriggerBuilder.limit(long)",
    "EntitiesLimitTriggerBuilder EntitiesLimitTriggerBuilder.tenantId(TenantId)",
    "String EntitiesLimitTriggerBuilder.toString()"
  })
  void testEntitiesLimitTriggerBuilderBuild() {
    // Arrange and Act
    EntitiesLimitTrigger actualEntitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Assert
    assertEquals(
        "ENTITIES_LIMIT:TENANT:13814000-1dd2-11b2-8080-808080808080",
        actualEntitiesLimitTrigger.getDeduplicationKey());
    assertEquals(0L, actualEntitiesLimitTrigger.getDefaultDeduplicationDuration());
    assertEquals(1L, actualEntitiesLimitTrigger.getLimit());
    assertEquals(3L, actualEntitiesLimitTrigger.getCurrentCount());
    assertEquals(EntityType.TENANT, actualEntitiesLimitTrigger.getEntityType());
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT, actualEntitiesLimitTrigger.getType());
    assertFalse(actualEntitiesLimitTrigger.deduplicate());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntitiesLimitTrigger.getOriginatorEntityId());
    assertSame(tenantId, actualEntitiesLimitTrigger.getTenantId());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}, and {@link EntitiesLimitTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitTrigger#equals(Object)}
   *   <li>{@link EntitiesLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    EntitiesLimitTrigger entitiesLimitTrigger2 =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(entitiesLimitTrigger, entitiesLimitTrigger2);
    assertEquals(entitiesLimitTrigger.hashCode(), entitiesLimitTrigger2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}, and {@link EntitiesLimitTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitTrigger#equals(Object)}
   *   <li>{@link EntitiesLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(null)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    EntitiesLimitTrigger entitiesLimitTrigger2 =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(null)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(entitiesLimitTrigger, entitiesLimitTrigger2);
    assertEquals(entitiesLimitTrigger.hashCode(), entitiesLimitTrigger2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}, and {@link EntitiesLimitTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitTrigger#equals(Object)}
   *   <li>{@link EntitiesLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(null)
            .build();
    EntitiesLimitTrigger entitiesLimitTrigger2 =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(null)
            .build();

    // Act and Assert
    assertEquals(entitiesLimitTrigger, entitiesLimitTrigger2);
    assertEquals(entitiesLimitTrigger.hashCode(), entitiesLimitTrigger2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}, and {@link EntitiesLimitTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitTrigger#equals(Object)}
   *   <li>{@link EntitiesLimitTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(entitiesLimitTrigger, entitiesLimitTrigger);
    int expectedHashCodeResult = entitiesLimitTrigger.hashCode();
    assertEquals(expectedHashCodeResult, entitiesLimitTrigger.hashCode());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(1L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitTrigger,
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(null)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitTrigger,
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.CUSTOMER)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitTrigger,
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(3L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitTrigger,
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(null)
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitTrigger,
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        entitiesLimitTrigger,
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(null)
            .build());
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        null);
  }

  /**
   * Test {@link EntitiesLimitTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitTrigger.equals(Object)",
    "int EntitiesLimitTrigger.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        "Different type to EntitiesLimitTrigger");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long EntitiesLimitTrigger.getCurrentCount()",
    "EntityType EntitiesLimitTrigger.getEntityType()",
    "long EntitiesLimitTrigger.getLimit()",
    "EntityId EntitiesLimitTrigger.getOriginatorEntityId()",
    "TenantId EntitiesLimitTrigger.getTenantId()",
    "NotificationRuleTriggerType EntitiesLimitTrigger.getType()",
    "void EntitiesLimitTrigger.setCurrentCount(long)",
    "void EntitiesLimitTrigger.setLimit(long)",
    "String EntitiesLimitTrigger.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    EntitiesLimitTrigger entitiesLimitTrigger =
        EntitiesLimitTrigger.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act
    entitiesLimitTrigger.setCurrentCount(3L);
    entitiesLimitTrigger.setLimit(1L);
    String actualToStringResult = entitiesLimitTrigger.toString();
    long actualCurrentCount = entitiesLimitTrigger.getCurrentCount();
    EntityType actualEntityType = entitiesLimitTrigger.getEntityType();
    long actualLimit = entitiesLimitTrigger.getLimit();
    EntityId actualOriginatorEntityId = entitiesLimitTrigger.getOriginatorEntityId();
    TenantId actualTenantId = entitiesLimitTrigger.getTenantId();

    // Assert
    assertEquals(
        "EntitiesLimitTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=TENANT, limit=1,"
            + " currentCount=3)",
        actualToStringResult);
    assertEquals(1L, actualLimit);
    assertEquals(3L, actualCurrentCount);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT, entitiesLimitTrigger.getType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link EntitiesLimitTrigger#EntitiesLimitTrigger(TenantId, EntityType, long, long)}.
   *
   * <p>Method under test: {@link EntitiesLimitTrigger#EntitiesLimitTrigger(TenantId, EntityType,
   * long, long)}
   */
  @Test
  @DisplayName("Test new EntitiesLimitTrigger(TenantId, EntityType, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesLimitTrigger.<init>(TenantId, EntityType, long, long)"})
  void testNewEntitiesLimitTrigger() {
    // Arrange and Act
    EntitiesLimitTrigger actualEntitiesLimitTrigger =
        new EntitiesLimitTrigger(TenantId.SYS_TENANT_ID, EntityType.TENANT, 1L, 3L);

    // Assert
    assertEquals(
        "ENTITIES_LIMIT:TENANT:13814000-1dd2-11b2-8080-808080808080",
        actualEntitiesLimitTrigger.getDeduplicationKey());
    assertEquals(0L, actualEntitiesLimitTrigger.getDefaultDeduplicationDuration());
    assertEquals(1L, actualEntitiesLimitTrigger.getLimit());
    assertEquals(3L, actualEntitiesLimitTrigger.getCurrentCount());
    assertEquals(EntityType.TENANT, actualEntitiesLimitTrigger.getEntityType());
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT, actualEntitiesLimitTrigger.getType());
    assertFalse(actualEntitiesLimitTrigger.deduplicate());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntitiesLimitTrigger.getOriginatorEntityId());
    assertSame(tenantId, actualEntitiesLimitTrigger.getTenantId());
  }
}
