package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link RelationsSearchParameters#equals(Object)}, and
   * {@link RelationsSearchParameters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
    RelationsSearchParameters relationsSearchParameters2 = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters2.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}, and
   * {@link RelationsSearchParameters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(null);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters2 = new RelationsSearchParameters(entityId2,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters2.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}, and
   * {@link RelationsSearchParameters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(null);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(null);
    when(entityId2.getEntityType()).thenReturn(null);
    RelationsSearchParameters relationsSearchParameters2 = new RelationsSearchParameters(entityId2,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters2.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}, and
   * {@link RelationsSearchParameters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId, null, 3, true);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(null);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters2 = new RelationsSearchParameters(entityId2, null, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters2);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters2.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}, and
   * {@link RelationsSearchParameters#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationsSearchParameters#equals(Object)}
   *   <li>{@link RelationsSearchParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertEquals(relationsSearchParameters, relationsSearchParameters);
    int expectedHashCodeResult = relationsSearchParameters.hashCode();
    assertEquals(expectedHashCodeResult, relationsSearchParameters.hashCode());
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 1, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, false);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Act and Assert
    assertNotEquals(relationsSearchParameters, new RelationsSearchParameters(
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(null);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(null);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(entityId2, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId, null, 3, true);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(null);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(entityId2, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(null);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.TO, 3, true);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(null);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(relationsSearchParameters,
        new RelationsSearchParameters(entityId2, EntitySearchDirection.FROM, 3, true));
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true), null);
  }

  /**
   * Test {@link RelationsSearchParameters#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true),
        "Different type to RelationsSearchParameters");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RelationsSearchParameters#RelationsSearchParameters(UUID, EntityType, EntitySearchDirection, RelationTypeGroup, int, boolean)}
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
  void testGettersAndSetters() {
    // Arrange and Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), EntityType.TENANT, EntitySearchDirection.FROM,
        RelationTypeGroup.COMMON, 3, true);
    actualRelationsSearchParameters.setDirection(EntitySearchDirection.FROM);
    actualRelationsSearchParameters.setFetchLastLevelOnly(true);
    actualRelationsSearchParameters.setMaxLevel(3);
    actualRelationsSearchParameters.setRelationTypeGroup(RelationTypeGroup.COMMON);
    UUID rootId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationsSearchParameters.setRootId(rootId);
    actualRelationsSearchParameters.setRootType(EntityType.TENANT);
    String actualToStringResult = actualRelationsSearchParameters.toString();
    EntitySearchDirection actualDirection = actualRelationsSearchParameters.getDirection();
    int actualMaxLevel = actualRelationsSearchParameters.getMaxLevel();
    RelationTypeGroup actualRelationTypeGroup = actualRelationsSearchParameters.getRelationTypeGroup();
    UUID actualRootId = actualRelationsSearchParameters.getRootId();
    EntityType actualRootType = actualRelationsSearchParameters.getRootType();
    boolean actualIsFetchLastLevelOnlyResult = actualRelationsSearchParameters.isFetchLastLevelOnly();

    // Assert that nothing has changed
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRootId.toString());
    assertEquals(
        "RelationsSearchParameters(rootId=784f394c-42b6-435a-983c-b7beff2784f9, rootType=TENANT, direction=FROM,"
            + " relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true)",
        actualToStringResult);
    assertEquals(3, actualMaxLevel);
    assertEquals(EntityType.TENANT, actualRootType);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertEquals(RelationTypeGroup.COMMON, actualRelationTypeGroup);
    assertTrue(actualIsFetchLastLevelOnlyResult);
    assertSame(rootId, actualRootId);
  }

  /**
   * Test
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean)}.
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean)}
   */
  @Test
  @DisplayName("Test new RelationsSearchParameters(EntityId, EntitySearchDirection, int, RelationTypeGroup, boolean); then EntityId return AlarmId")
  void testNewRelationsSearchParameters_thenEntityIdReturnAlarmId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId entityId = new AlarmId(id);

    // Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, RelationTypeGroup.COMMON, true);

    // Assert
    EntityId entityId2 = actualRelationsSearchParameters.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    UUID rootId = actualRelationsSearchParameters.getRootId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", rootId.toString());
    assertEquals(EntityType.ALARM, actualRelationsSearchParameters.getRootType());
    assertEquals(entityId, entityId2);
    assertSame(id, rootId);
  }

  /**
   * Test
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, boolean)}.
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelationsSearchParameters#RelationsSearchParameters(EntityId, EntitySearchDirection, int, boolean)}
   */
  @Test
  @DisplayName("Test new RelationsSearchParameters(EntityId, EntitySearchDirection, int, boolean); then EntityId return AlarmId")
  void testNewRelationsSearchParameters_thenEntityIdReturnAlarmId2() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId entityId = new AlarmId(id);

    // Act
    RelationsSearchParameters actualRelationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, 3, true);

    // Assert
    EntityId entityId2 = actualRelationsSearchParameters.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    UUID rootId = actualRelationsSearchParameters.getRootId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", rootId.toString());
    assertEquals(EntityType.ALARM, actualRelationsSearchParameters.getRootType());
    assertEquals(entityId, entityId2);
    assertSame(id, rootId);
  }

  /**
   * Test {@link RelationsSearchParameters#getEntityId()}.
   * <ul>
   *   <li>Then return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return AlarmId")
  void testGetEntityId_thenReturnAlarmId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link ApiUsageStateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return ApiUsageStateId")
  void testGetEntityId_thenReturnApiUsageStateId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return AssetId")
  void testGetEntityId_thenReturnAssetId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link AssetProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return AssetProfileId")
  void testGetEntityId_thenReturnAssetProfileId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return CustomerId")
  void testGetEntityId_thenReturnCustomerId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DashboardId")
  void testGetEntityId_thenReturnDashboardId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DeviceId")
  void testGetEntityId_thenReturnDeviceId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link DeviceProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DeviceProfileId")
  void testGetEntityId_thenReturnDeviceProfileId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link DomainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return DomainId")
  void testGetEntityId_thenReturnDomainId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link EdgeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return EdgeId")
  void testGetEntityId_thenReturnEdgeId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link EntityViewId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return EntityViewId")
  void testGetEntityId_thenReturnEntityViewId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link MobileAppId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return MobileAppId")
  void testGetEntityId_thenReturnMobileAppId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link NotificationId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationId")
  void testGetEntityId_thenReturnNotificationId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link NotificationRequestId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationRequestId")
  void testGetEntityId_thenReturnNotificationRequestId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link NotificationRuleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationRuleId")
  void testGetEntityId_thenReturnNotificationRuleId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link NotificationTargetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationTargetId")
  void testGetEntityId_thenReturnNotificationTargetId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link NotificationTemplateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return NotificationTemplateId")
  void testGetEntityId_thenReturnNotificationTemplateId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link OAuth2ClientId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return OAuth2ClientId")
  void testGetEntityId_thenReturnOAuth2ClientId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link OtaPackageId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return OtaPackageId")
  void testGetEntityId_thenReturnOtaPackageId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link QueueId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return QueueId")
  void testGetEntityId_thenReturnQueueId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link QueueStatsId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return QueueStatsId")
  void testGetEntityId_thenReturnQueueStatsId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link RpcId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return RpcId")
  void testGetEntityId_thenReturnRpcId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return RuleChainId")
  void testGetEntityId_thenReturnRuleChainId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return RuleNodeId")
  void testGetEntityId_thenReturnRuleNodeId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link TbResourceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return TbResourceId")
  void testGetEntityId_thenReturnTbResourceId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link TenantProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return TenantProfileId")
  void testGetEntityId_thenReturnTenantProfileId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return UserId")
  void testGetEntityId_thenReturnUserId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link WidgetTypeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return WidgetTypeId")
  void testGetEntityId_thenReturnWidgetTypeId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
   * <ul>
   *   <li>Then return {@link WidgetsBundleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationsSearchParameters#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return WidgetsBundleId")
  void testGetEntityId_thenReturnWidgetsBundleId() {
    // Arrange
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);
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
