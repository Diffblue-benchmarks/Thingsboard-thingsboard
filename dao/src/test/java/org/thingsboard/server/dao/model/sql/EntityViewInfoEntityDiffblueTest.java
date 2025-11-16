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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewInfoEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewInfoEntity.equals(Object)",
    "int EntityViewInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewInfoEntity.<init>()",
    "String EntityViewInfoEntity.getCustomerTitle()",
    "boolean EntityViewInfoEntity.isCustomerIsPublic()",
    "void EntityViewInfoEntity.setCustomerIsPublic(boolean)",
    "void EntityViewInfoEntity.setCustomerTitle(String)",
    "String EntityViewInfoEntity.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewInfoEntity.<init>(EntityViewEntity, String, Object)"})
  public void testNewEntityViewInfoEntity_thenReturnToDataCustomerIsPublic() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewInfoEntity.<init>(EntityViewEntity, String, Object)"})
  public void testNewEntityViewInfoEntity_whenNull_thenReturnNotToDataCustomerIsPublic() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_givenEntityViewInfoEntityEntityTypeIsAlarm_thenEntityIdReturnAlarmId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ALARM);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ALARM, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_givenEntityViewInfoEntityEntityTypeIsAsset_thenEntityIdReturnAssetId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ASSET);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_givenEntityViewInfoEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.USER);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.USER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_givenEntityViewInfoEntityKeysIs42_thenAdditionalInfoReturnNullNode() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("42");

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_givenEntityViewInfoEntityKeysIsEmptyString() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("");

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_givenEntityViewInfoEntityKeysIsKeys_thenAdditionalInfoReturnNullNode() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("Keys");

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_givenEntityViewInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EntityViewInfo actualToDataResult = new EntityViewInfoEntity().toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualToDataResult.getCustomerId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.CUSTOMER);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DASHBOARD);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnDeviceId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DEVICE);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.DEVICE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnDeviceProfileId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DEVICE_PROFILE);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof DeviceProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnEntityViewId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ENTITY_VIEW);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnRuleChainId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.RULE_CHAIN);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnRuleNodeId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.RULE_NODE);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.RULE_NODE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnTenantId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.TENANT);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnTenantProfileId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.TENANT_PROFILE);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnWidgetTypeId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.WIDGET_TYPE);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof WidgetTypeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenEntityIdReturnWidgetsBundleId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.WIDGETS_BUNDLE);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenReturnAdditionalInfoIsInstance() {
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
   *   <li>Then return CustomerId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToDataResult.getEntityId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    EntityViewId externalId = actualToDataResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    assertNull(actualToDataResult.getEntityId());
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenReturnNotTenantIdNullUid() {
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
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo EntityViewInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = entityViewInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
