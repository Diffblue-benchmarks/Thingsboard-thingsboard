package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class EntityViewInfoEntityDiffblueTest {
  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and {@link EntityViewInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    EntityViewInfoEntity entityViewInfoEntity2 = new EntityViewInfoEntity();

    // Act and Assert
    assertEquals(entityViewInfoEntity, entityViewInfoEntity2);
    assertEquals(entityViewInfoEntity.hashCode(), entityViewInfoEntity2.hashCode());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and {@link EntityViewInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerTitle("Dr");

    EntityViewInfoEntity entityViewInfoEntity2 = new EntityViewInfoEntity();
    entityViewInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(entityViewInfoEntity, entityViewInfoEntity2);
    assertEquals(entityViewInfoEntity.hashCode(), entityViewInfoEntity2.hashCode());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and {@link EntityViewInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    // Act and Assert
    assertEquals(entityViewInfoEntity, entityViewInfoEntity);
    int expectedHashCodeResult = entityViewInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfoEntity.hashCode());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, entityViewEntity);
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, new EntityViewInfoEntity());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, new EntityViewInfoEntity());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, new EntityViewInfoEntity());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    EntityViewInfoEntity entityViewInfoEntity2 = new EntityViewInfoEntity();
    entityViewInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, entityViewInfoEntity2);
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfoEntity(), null);
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfoEntity(), "Different type to EntityViewInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewInfoEntity#EntityViewInfoEntity()}
   *   <li>{@link EntityViewInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link EntityViewInfoEntity#setCustomerTitle(String)}
   *   <li>{@link EntityViewInfoEntity#toString()}
   *   <li>{@link EntityViewInfoEntity#getCustomerTitle()}
   *   <li>{@link EntityViewInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewInfoEntity.<init>()",
    "String EntityViewInfoEntity.getCustomerTitle()",
    "boolean EntityViewInfoEntity.isCustomerIsPublic()",
    "void EntityViewInfoEntity.setCustomerIsPublic(boolean)",
    "void EntityViewInfoEntity.setCustomerTitle(String)",
    "String EntityViewInfoEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityViewInfoEntity actualEntityViewInfoEntity = new EntityViewInfoEntity();
    actualEntityViewInfoEntity.setCustomerIsPublic(true);
    actualEntityViewInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualEntityViewInfoEntity.toString();
    String actualCustomerTitle = actualEntityViewInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualEntityViewInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals("Dr", actualCustomerTitle);
    assertEquals(
        "EntityViewInfoEntity(customerTitle=Dr, customerIsPublic=true)", actualToStringResult);
    assertNull(actualEntityViewInfoEntity.getAdditionalInfo());
    assertNull(actualEntityViewInfoEntity.getVersion());
    assertNull(actualEntityViewInfoEntity.getKeys());
    assertNull(actualEntityViewInfoEntity.getName());
    assertNull(actualEntityViewInfoEntity.getType());
    assertNull(actualEntityViewInfoEntity.getId());
    assertNull(actualEntityViewInfoEntity.getUuid());
    assertNull(actualEntityViewInfoEntity.getCustomerId());
    assertNull(actualEntityViewInfoEntity.getEntityId());
    assertNull(actualEntityViewInfoEntity.getExternalId());
    assertNull(actualEntityViewInfoEntity.getTenantId());
    assertNull(actualEntityViewInfoEntity.getEntityType());
    assertEquals(0L, actualEntityViewInfoEntity.getCreatedTime());
    assertEquals(0L, actualEntityViewInfoEntity.getEndTs());
    assertEquals(0L, actualEntityViewInfoEntity.getStartTs());
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}.
   *
   * <ul>
   *   <li>Then return toData CustomerIsPublic.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity,
   * String, Object)}
   */
  @Test
  @DisplayName(
      "Test new EntityViewInfoEntity(EntityViewEntity, String, Object); then return toData CustomerIsPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewInfoEntity.<init>(EntityViewEntity, String, Object)"})
  void testNewEntityViewInfoEntity_thenReturnToDataCustomerIsPublic() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setVersion(1L);
    JsonNode jsonNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    EntityViewInfoEntity actualEntityViewInfoEntity =
        new EntityViewInfoEntity(entityViewEntity, "Dr", jsonNode);

    // Assert
    EntityViewInfo toDataResult = actualEntityViewInfoEntity.toData();
    assertTrue(toDataResult.isCustomerIsPublic());
    assertTrue(actualEntityViewInfoEntity.isCustomerIsPublic());
    assertSame(jsonNode, toDataResult.getAdditionalInfo());
    assertSame(jsonNode, actualEntityViewInfoEntity.getAdditionalInfo());
  }

  /**
   * Test {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not toData CustomerIsPublic.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity,
   * String, Object)}
   */
  @Test
  @DisplayName(
      "Test new EntityViewInfoEntity(EntityViewEntity, String, Object); when 'null'; then return not toData CustomerIsPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewInfoEntity.<init>(EntityViewEntity, String, Object)"})
  void testNewEntityViewInfoEntity_whenNull_thenReturnNotToDataCustomerIsPublic() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setVersion(1L);

    // Act
    EntityViewInfoEntity actualEntityViewInfoEntity =
        new EntityViewInfoEntity(entityViewEntity, "Dr", null);

    // Assert
    assertFalse(actualEntityViewInfoEntity.toData().isCustomerIsPublic());
    assertFalse(actualEntityViewInfoEntity.isCustomerIsPublic());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} EntityType is {@code ALARM}.
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given EntityViewInfoEntity() EntityType is 'ALARM'; then EntityId return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_givenEntityViewInfoEntityEntityTypeIsAlarm_thenEntityIdReturnAlarmId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ALARM);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} EntityType is {@code ASSET}.
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given EntityViewInfoEntity() EntityType is 'ASSET'; then EntityId return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_givenEntityViewInfoEntityEntityTypeIsAsset_thenEntityIdReturnAssetId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ASSET);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} EntityType is {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given EntityViewInfoEntity() EntityType is 'USER'; then EntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_givenEntityViewInfoEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.USER);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof UserId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} Keys is {@code 42}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given EntityViewInfoEntity() Keys is '42'; then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_givenEntityViewInfoEntityKeysIs42_thenAdditionalInfoReturnNullNode() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("42");

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} Keys is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given EntityViewInfoEntity() Keys is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_givenEntityViewInfoEntityKeysIsEmptyString() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("");

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} Keys is {@code Keys}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given EntityViewInfoEntity() Keys is 'Keys'; then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_givenEntityViewInfoEntityKeysIsKeys_thenAdditionalInfoReturnNullNode() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("Keys");

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given EntityViewInfoEntity(); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_givenEntityViewInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EntityViewInfo actualToDataResult = new EntityViewInfoEntity().toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.CUSTOMER);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof CustomerId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DASHBOARD);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnDeviceId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DEVICE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnDeviceProfileId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DEVICE_PROFILE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof DeviceProfileId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE_PROFILE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnEntityViewId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ENTITY_VIEW);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof EntityViewId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ENTITY_VIEW, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnRuleChainId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.RULE_CHAIN);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnRuleNodeId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.RULE_NODE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnTenantId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.TENANT);
    entityViewInfoEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(entityId.isNullUid());
    assertFalse(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnTenantProfileId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.TENANT_PROFILE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof TenantProfileId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.TENANT_PROFILE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnWidgetTypeId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.WIDGET_TYPE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof WidgetTypeId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.WIDGET_TYPE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenEntityIdReturnWidgetsBundleId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.WIDGETS_BUNDLE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof WidgetsBundleId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is Instance.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return AdditionalInfo is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenReturnAdditionalInfoIsInstance() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    MissingNode additionalInfo = MissingNode.getInstance();
    entityViewInfoEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    assertSame(additionalInfo, entityViewInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setCustomerId(customerId);

    // Act and Assert
    CustomerId customerId2 = entityViewInfoEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewInfoEntity.setExternalId(externalId);

    // Act and Assert
    EntityViewId externalId2 = entityViewInfoEntity.toData().getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ENTITY_VIEW, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, id);
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    UUID tenantId = UUID.randomUUID();
    entityViewInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = entityViewInfoEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = entityViewInfoEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
