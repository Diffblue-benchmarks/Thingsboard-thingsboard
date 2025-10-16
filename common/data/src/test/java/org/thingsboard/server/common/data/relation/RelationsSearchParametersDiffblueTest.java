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
package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;

class RelationsSearchParametersDiffblueTest {
  /**
   * Test {@link RelationsSearchParameters#equals(Object)}, and {@link
   * RelationsSearchParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    RelationsSearchParameters relationsSearchParameters2 =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    assertEquals(relationsSearchParameters.hashCode(), relationsSearchParameters2.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}, and {@link
   * RelationsSearchParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, null, 3, true);
    RelationsSearchParameters relationsSearchParameters2 =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, null, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    assertEquals(relationsSearchParameters.hashCode(), relationsSearchParameters2.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}, and {@link
   * RelationsSearchParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, null, 3, true);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.TO, 3, true);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 1, true);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, false);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(
            new AlarmId(EntityId.NULL_UUID), EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(
            new AlarmId(UUID.randomUUID()), EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(new AlarmId(null), EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(new AlarmId(null), EntitySearchDirection.FROM, 3, true);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        relationsSearchParameters,
        new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true),
        null);
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationsSearchParameters.equals(Object)",
    "int RelationsSearchParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true),
        "Different type to RelationsSearchParameters");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationsSearchParameters#RelationsSearchParameters(UUID, EntityType,
   *       EntitySearchDirection, RelationTypeGroup, int, boolean)}
   *   <li>{@link RelationsSearchParameters#setDirection(EntitySearchDirection)}
   *   <li>{@link RelationsSearchParameters#setFetchLastLevelOnly(boolean)}
   *   <li>{@link RelationsSearchParameters#setMaxLevel(int)}
   *   <li>{@link RelationsSearchParameters#setRelationTypeGroup(RelationTypeGroup)}
   *   <li>{@link RelationsSearchParameters#setRootId(UUID)}
   *   <li>{@link RelationsSearchParameters#setRootType(EntityType)}
   *   <li>{@link RelationsSearchParameters#toString()}
   *   <li>{@link RelationsSearchParameters#getDirection()}
   *   <li>{@link RelationsSearchParameters#getMaxLevel()}
   *   <li>{@link RelationsSearchParameters#getRelationTypeGroup()}
   *   <li>{@link RelationsSearchParameters#getRootId()}
   *   <li>{@link RelationsSearchParameters#getRootType()}
   *   <li>{@link RelationsSearchParameters#isFetchLastLevelOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationsSearchParameters.<init>(UUID, EntityType, EntitySearchDirection, RelationTypeGroup, int, boolean)",
    "EntitySearchDirection RelationsSearchParameters.getDirection()",
    "int RelationsSearchParameters.getMaxLevel()",
    "RelationTypeGroup RelationsSearchParameters.getRelationTypeGroup()",
    "UUID RelationsSearchParameters.getRootId()",
    "EntityType RelationsSearchParameters.getRootType()",
    "boolean RelationsSearchParameters.isFetchLastLevelOnly()",
    "void RelationsSearchParameters.setDirection(EntitySearchDirection)",
    "void RelationsSearchParameters.setFetchLastLevelOnly(boolean)",
    "void RelationsSearchParameters.setMaxLevel(int)",
    "void RelationsSearchParameters.setRelationTypeGroup(RelationTypeGroup)",
    "void RelationsSearchParameters.setRootId(UUID)",
    "void RelationsSearchParameters.setRootType(EntityType)",
    "String RelationsSearchParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RelationsSearchParameters actualRelationsSearchParameters =
        new RelationsSearchParameters(
            EntityId.NULL_UUID,
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true);
    actualRelationsSearchParameters.setDirection(EntitySearchDirection.FROM);
    actualRelationsSearchParameters.setFetchLastLevelOnly(true);
    actualRelationsSearchParameters.setMaxLevel(3);
    actualRelationsSearchParameters.setRelationTypeGroup(RelationTypeGroup.COMMON);
    UUID rootId = EntityId.NULL_UUID;
    actualRelationsSearchParameters.setRootId(rootId);
    actualRelationsSearchParameters.setRootType(EntityType.TENANT);
    String actualToStringResult = actualRelationsSearchParameters.toString();
    EntitySearchDirection actualDirection = actualRelationsSearchParameters.getDirection();
    int actualMaxLevel = actualRelationsSearchParameters.getMaxLevel();
    RelationTypeGroup actualRelationTypeGroup =
        actualRelationsSearchParameters.getRelationTypeGroup();
    UUID actualRootId = actualRelationsSearchParameters.getRootId();
    EntityType actualRootType = actualRelationsSearchParameters.getRootType();

    // Assert
    assertEquals(
        "RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080, rootType=TENANT, direction=FROM,"
            + " relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true)",
        actualToStringResult);
    assertEquals(3, actualMaxLevel);
    assertEquals(EntityType.TENANT, actualRootType);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertEquals(RelationTypeGroup.COMMON, actualRelationTypeGroup);
    assertTrue(actualRelationsSearchParameters.isFetchLastLevelOnly());
    assertSame(rootId, actualRootId);
  }

  /**
   * Test {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, RelationTypeGroup, boolean)}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, RelationTypeGroup, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RelationsSearchParameters(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean); then EntityId return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationsSearchParameters.<init>(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean)"
  })
  void testNewRelationsSearchParameters_thenEntityIdReturnAlarmId() {
    // Arrange
    AlarmId entityId = new AlarmId(EntityId.NULL_UUID);

    // Act
    RelationsSearchParameters actualRelationsSearchParameters =
        new RelationsSearchParameters(
            entityId, EntitySearchDirection.FROM, 3, RelationTypeGroup.COMMON, true);

    // Assert
    EntityId entityId2 = actualRelationsSearchParameters.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, actualRelationsSearchParameters.getRootType());
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, boolean)}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RelationsSearchParameters(EntityId, EntitySearchDirection, int, boolean); then EntityId return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationsSearchParameters.<init>(EntityId, EntitySearchDirection, int, boolean)"
  })
  void testNewRelationsSearchParameters_thenEntityIdReturnAlarmId2() {
    // Arrange
    AlarmId entityId = new AlarmId(EntityId.NULL_UUID);

    // Act
    RelationsSearchParameters actualRelationsSearchParameters =
        new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    // Assert
    EntityId entityId2 = actualRelationsSearchParameters.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, actualRelationsSearchParameters.getRootType());
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, RelationTypeGroup, boolean)}.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return RootType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, RelationTypeGroup, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RelationsSearchParameters(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean); when SYS_TENANT_ID; then return RootType is 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationsSearchParameters.<init>(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean)"
  })
  void testNewRelationsSearchParameters_whenSys_tenant_id_thenReturnRootTypeIsTenant() {
    // Arrange and Act
    RelationsSearchParameters actualRelationsSearchParameters =
        new RelationsSearchParameters(
            TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, RelationTypeGroup.COMMON, true);

    // Assert
    assertEquals(EntityType.TENANT, actualRelationsSearchParameters.getRootType());
    assertSame(TenantId.SYS_TENANT_ID, actualRelationsSearchParameters.getEntityId());
  }

  /**
   * Test {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, boolean)}.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return RootType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#RelationsSearchParameters(EntityId,
   * EntitySearchDirection, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RelationsSearchParameters(EntityId, EntitySearchDirection, int, boolean); when SYS_TENANT_ID; then return RootType is 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationsSearchParameters.<init>(EntityId, EntitySearchDirection, int, boolean)"
  })
  void testNewRelationsSearchParameters_whenSys_tenant_id_thenReturnRootTypeIsTenant2() {
    // Arrange and Act
    RelationsSearchParameters actualRelationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);

    // Assert
    assertEquals(EntityType.TENANT, actualRelationsSearchParameters.getRootType());
    assertSame(TenantId.SYS_TENANT_ID, actualRelationsSearchParameters.getEntityId());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnAlarmId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ALARM);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ALARM, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return ApiUsageStateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnApiUsageStateId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.API_USAGE_STATE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof ApiUsageStateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnAssetId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ASSET);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ASSET, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnAssetProfileId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ASSET_PROFILE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof AssetProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnCustomerId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.CUSTOMER);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnDashboardId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DASHBOARD);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnDeviceId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DEVICE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DEVICE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnDeviceProfileId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DEVICE_PROFILE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DeviceProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DomainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnDomainId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.DOMAIN);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof DomainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.DOMAIN, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return EdgeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnEdgeId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.EDGE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof EdgeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.EDGE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnEntityViewId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.ENTITY_VIEW);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return MobileAppId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnMobileAppId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.MOBILE_APP);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof MobileAppId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.MOBILE_APP, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnNotificationId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationRequestId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnNotificationRequestId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_REQUEST);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationRequestId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationRuleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnNotificationRuleId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_RULE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationRuleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationTargetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnNotificationTargetId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_TARGET);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationTargetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationTemplateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnNotificationTemplateId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.NOTIFICATION_TEMPLATE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof NotificationTemplateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return OAuth2ClientId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnOAuth2ClientId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.OAUTH2_CLIENT);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof OAuth2ClientId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnOtaPackageId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.OTA_PACKAGE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof OtaPackageId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return QueueId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnQueueId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.QUEUE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof QueueId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.QUEUE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return QueueStatsId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnQueueStatsId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.QUEUE_STATS);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof QueueStatsId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return RpcId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnRpcId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.RPC);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof RpcId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.RPC, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnRuleChainId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.RULE_CHAIN);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnRuleNodeId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.RULE_NODE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return SYS_TENANT_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnSys_tenant_id() {
    // Arrange and Act
    EntityId actualEntityId =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true)
            .getEntityId();

    // Assert
    assertSame(((TenantId) actualEntityId).SYS_TENANT_ID, actualEntityId);
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnTbResourceId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.TB_RESOURCE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof TbResourceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnTenantProfileId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.TENANT_PROFILE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof TenantProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnUserId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.USER);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.USER, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnWidgetTypeId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.WIDGET_TYPE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof WidgetTypeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   *
   * <ul>
   *   <li>Then return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId RelationsSearchParameters.getEntityId()"})
  void testGetEntityId_thenReturnWidgetsBundleId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    relationsSearchParameters.setRootType(EntityType.WIDGETS_BUNDLE);

    // Act
    EntityId actualEntityId = relationsSearchParameters.getEntityId();

    // Assert
    assertTrue(actualEntityId instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEntityId.getEntityType());
    assertTrue(actualEntityId.isNullUid());
  }
}
