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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class EntityActionTriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionTrigger.EntityActionTriggerBuilder#build()}
   *   <li>
   * {@link EntityActionTrigger.EntityActionTriggerBuilder#actionType(ActionType)}
   *   <li>{@link EntityActionTrigger.EntityActionTriggerBuilder#entity(HasName)}
   *   <li>{@link EntityActionTrigger.EntityActionTriggerBuilder#entityId(EntityId)}
   *   <li>{@link EntityActionTrigger.EntityActionTriggerBuilder#tenantId(TenantId)}
   *   <li>{@link EntityActionTrigger.EntityActionTriggerBuilder#user(User)}
   * </ul>
   */
  @Test
  void testEntityActionTriggerBuilderBuild() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    User user = new User();

    // Act
    EntityActionTrigger actualBuildResult = tenantIdResult.user(user).build();

    // Assert
    EntityId entityId = actualBuildResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("ENTITY_ACTION:TENANT:13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getDeduplicationKey());
    assertEquals(0L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(ActionType.ADDED, actualBuildResult.getActionType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualBuildResult.getType());
    assertFalse(actualBuildResult.deduplicate());
    assertSame(user, actualBuildResult.getUser());
    assertSame(entityId, actualBuildResult.getOriginatorEntityId());
    assertSame(entityId, actualBuildResult.getTenantId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = entityActionTriggerBuilder
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder2 = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder2.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = entityActionTriggerBuilder2
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger buildResult = entityActionTriggerBuilder.actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID)
        .user(null)
        .build();
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder2 = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder2.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger buildResult2 = entityActionTriggerBuilder2.actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID)
        .user(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionTrigger#equals(Object)}
   *   <li>{@link EntityActionTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(null)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder entityResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class));
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = entityResult
        .entityId(new AlarmId(EntityId.NULL_UUID))
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(null);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(null);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(null)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(null)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(null);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(null);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = entityActionTriggerBuilder
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger buildResult = entityActionTriggerBuilder.actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID)
        .user(null)
        .build();
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder2 = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder2.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = entityActionTriggerBuilder2
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = entityActionTriggerBuilder
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User(new User())).build();
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder2 = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder2.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = entityActionTriggerBuilder2
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder builderResult = EntityActionTrigger.builder();
    builderResult.actionType(ActionType.ADDED);
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder.actionType(Mockito.<ActionType>any())).thenReturn(builderResult);
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = entityActionTriggerBuilder
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();
    EntityActionTrigger.EntityActionTriggerBuilder entityActionTriggerBuilder2 = mock(
        EntityActionTrigger.EntityActionTriggerBuilder.class);
    when(entityActionTriggerBuilder2.actionType(Mockito.<ActionType>any())).thenReturn(EntityActionTrigger.builder());
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult2 = entityActionTriggerBuilder2
        .actionType(ActionType.ADDED)
        .entity(null)
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link EntityActionTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityActionTrigger.EntityActionTriggerBuilder tenantIdResult = EntityActionTrigger.builder()
        .actionType(ActionType.ADDED)
        .entity(mock(HasName.class))
        .entityId(TenantId.SYS_TENANT_ID)
        .tenantId(TenantId.SYS_TENANT_ID);
    EntityActionTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityActionTrigger");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityActionTrigger#EntityActionTrigger(TenantId, EntityId, HasName, ActionType, User)}
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
  void testGettersAndSetters() {
    // Arrange
    HasName entity = mock(HasName.class);
    User user = new User();

    // Act
    EntityActionTrigger actualEntityActionTrigger = new EntityActionTrigger(TenantId.SYS_TENANT_ID,
        TenantId.SYS_TENANT_ID, entity, ActionType.ADDED, user);
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
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
    assertSame(entity, actualEntity);
  }
}
