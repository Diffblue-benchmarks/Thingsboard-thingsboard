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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.EntityActionTrigger.EntityActionTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {EntityActionTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityActionTriggerDiffblueTest {
  @Autowired private EntityActionTriggerBuilder entityActionTriggerBuilder;

  /**
   * Test EntityActionTriggerBuilder {@link EntityActionTriggerBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionTriggerBuilder#build()}
   *   <li>{@link EntityActionTriggerBuilder#actionType(ActionType)}
   *   <li>{@link EntityActionTriggerBuilder#entity(HasName)}
   *   <li>{@link EntityActionTriggerBuilder#entityId(EntityId)}
   *   <li>{@link EntityActionTriggerBuilder#tenantId(TenantId)}
   *   <li>{@link EntityActionTriggerBuilder#user(User)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityActionTriggerBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionTriggerBuilder.<init>()",
    "EntityActionTriggerBuilder EntityActionTriggerBuilder.actionType(ActionType)",
    "EntityActionTrigger EntityActionTriggerBuilder.build()",
    "EntityActionTriggerBuilder EntityActionTriggerBuilder.entity(HasName)",
    "EntityActionTriggerBuilder EntityActionTriggerBuilder.entityId(EntityId)",
    "EntityActionTriggerBuilder EntityActionTriggerBuilder.tenantId(TenantId)",
    "java.lang.String EntityActionTriggerBuilder.toString()",
    "EntityActionTriggerBuilder EntityActionTriggerBuilder.user(User)"
  })
  void testEntityActionTriggerBuilderBuild() {
    // Arrange
    HasName entity = mock(HasName.class);

    // Act
    EntityActionTriggerBuilder actualTenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(entity)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    User user = new User();
    EntityActionTrigger actualEntityActionTrigger = actualTenantIdResult.user(user).build();

    // Assert
    assertEquals(
        "ENTITY_ACTION:TENANT:13814000-1dd2-11b2-8080-808080808080",
        actualEntityActionTrigger.getDeduplicationKey());
    assertEquals(0L, actualEntityActionTrigger.getDefaultDeduplicationDuration());
    assertEquals(ActionType.ADDED, actualEntityActionTrigger.getActionType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualEntityActionTrigger.getType());
    assertFalse(actualEntityActionTrigger.deduplicate());
    assertSame(user, actualEntityActionTrigger.getUser());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityActionTrigger.getEntityId());
    assertSame(tenantId, actualEntityActionTrigger.getOriginatorEntityId());
    assertSame(tenantId, actualEntityActionTrigger.getTenantId());
    assertSame(entity, actualEntityActionTrigger.getEntity());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}, and {@link EntityActionTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(entityActionTrigger, entityActionTrigger2);
    assertEquals(entityActionTrigger.hashCode(), entityActionTrigger2.hashCode());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}, and {@link EntityActionTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityActionTrigger entityActionTrigger =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID)
            .user(null)
            .build();
    EntityActionTrigger entityActionTrigger2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID)
            .user(null)
            .build();

    // Act and Assert
    assertEquals(entityActionTrigger, entityActionTrigger2);
    assertEquals(entityActionTrigger.hashCode(), entityActionTrigger2.hashCode());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}, and {@link EntityActionTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(null)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(null)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(entityActionTrigger, entityActionTrigger2);
    assertEquals(entityActionTrigger.hashCode(), entityActionTrigger2.hashCode());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}, and {@link EntityActionTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertEquals(entityActionTrigger, entityActionTrigger);
    int expectedHashCodeResult = entityActionTrigger.hashCode();
    assertEquals(expectedHashCodeResult, entityActionTrigger.hashCode());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(null)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityActionTriggerBuilder entityResult =
        EntityActionTrigger.builder().actionType(ActionType.ADDED).entity(mock(HasName.class));

    EntityActionTriggerBuilder tenantIdResult =
        entityResult.entityId(new AlarmId(EntityId.NULL_UUID)).tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(null);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(null);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityActionTrigger entityActionTrigger =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID)
            .user(null)
            .build();

    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User(new User())).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(null)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(null)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(null);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(null);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(null)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.DELETED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger entityActionTrigger = tenantIdResult.user(new User()).build();

    EntityActionTriggerBuilder tenantIdResult2 =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityActionTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tenantIdResult.user(new User()).build(), null);
  }

  /**
   * Test {@link EntityActionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionTrigger.equals(Object)",
    "int EntityActionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityActionTriggerBuilder tenantIdResult =
        EntityActionTrigger.builder()
            .actionType(ActionType.ADDED)
            .entity(mock(HasName.class))
            .entityId(TenantId.SYS_TENANT_ID)
            .tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(
        tenantIdResult.user(new User()).build(), "Different type to EntityActionTrigger");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionTrigger#EntityActionTrigger(TenantId, EntityId, HasName, ActionType,
   *       User)}
   *   <li>{@link EntityActionTrigger#toString()}
   *   <li>{@link EntityActionTrigger#getActionType()}
   *   <li>{@link EntityActionTrigger#getEntity()}
   *   <li>{@link EntityActionTrigger#getEntityId()}
   *   <li>{@link EntityActionTrigger#getOriginatorEntityId()}
   *   <li>{@link EntityActionTrigger#getTenantId()}
   *   <li>{@link EntityActionTrigger#getType()}
   *   <li>{@link EntityActionTrigger#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionTrigger.<init>(TenantId, EntityId, HasName, ActionType, User)",
    "ActionType EntityActionTrigger.getActionType()",
    "HasName EntityActionTrigger.getEntity()",
    "EntityId EntityActionTrigger.getEntityId()",
    "EntityId EntityActionTrigger.getOriginatorEntityId()",
    "TenantId EntityActionTrigger.getTenantId()",
    "NotificationRuleTriggerType EntityActionTrigger.getType()",
    "User EntityActionTrigger.getUser()",
    "java.lang.String EntityActionTrigger.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HasName entity = mock(HasName.class);
    User user = new User();

    // Act
    EntityActionTrigger actualEntityActionTrigger =
        new EntityActionTrigger(
            TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, entity, ActionType.ADDED, user);
    actualEntityActionTrigger.toString();
    ActionType actualActionType = actualEntityActionTrigger.getActionType();
    HasName actualEntity = actualEntityActionTrigger.getEntity();
    EntityId actualEntityId = actualEntityActionTrigger.getEntityId();
    EntityId actualOriginatorEntityId = actualEntityActionTrigger.getOriginatorEntityId();
    TenantId actualTenantId = actualEntityActionTrigger.getTenantId();
    NotificationRuleTriggerType actualType = actualEntityActionTrigger.getType();

    // Assert
    assertEquals(ActionType.ADDED, actualActionType);
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualType);
    assertSame(user, actualEntityActionTrigger.getUser());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
    assertSame(entity, actualEntity);
  }
}
