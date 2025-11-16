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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractEntityViewEntityDiffblueTest {
  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys(
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(null));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    EntityId entityId = actualToEntityViewResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualToEntityViewResult.getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityId is {@code null}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_givenEntityViewEntityEntityIdIsNull_thenReturnEntityIdIsNull()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(telemetryEntityView));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getEntityId());
    assertEquals(telemetryEntityView, actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityType is {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_givenEntityViewEntityEntityTypeIsUser_thenEntityIdReturnUserId()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals(EntityType.USER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_givenEntityViewEntityExternalIdIsNull()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(null);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(telemetryEntityView));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getExternalId());
    assertEquals(telemetryEntityView, actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_givenEntityViewEntityKeysIs42() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("42");

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_givenEntityViewEntityKeysIsEmptyString() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("");

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_givenEntityViewEntityKeysIsFoo() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("foo");

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_givenEntityViewEntity_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    EntityView actualToEntityViewResult = new EntityViewEntity().toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getCustomerId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertNull(actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_thenAdditionalInfoIteratorNextReturnBooleanNode() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    JsonNode additionalInfo = entityViewEntity.toEntityView().getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(additionalInfo.isNull());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(iteratorResult.hasNext());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_thenEntityIdReturnAssetId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.ASSET);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_thenEntityIdReturnCustomerId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.CUSTOMER);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    assertTrue(entityViewEntity.toEntityView().getEntityId() instanceof CustomerId);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_thenEntityIdReturnDashboardId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DASHBOARD);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_thenEntityIdReturnDeviceId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DEVICE);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then return EntityId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_thenReturnEntityIdIdToStringIs138140001dd211b28080808080808080()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    EntityId entityId = actualToEntityViewResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualToEntityViewResult.getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then return not EntityId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  public void testToEntityView_thenReturnNotEntityIdNullUid() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link EntityViewEntity#EntityViewEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#canEqual(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractEntityViewEntity.canEqual(Object)"})
  public void testCanEqual_whenEntityViewEntity_thenReturnTrue() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act and Assert
    assertTrue(entityViewEntity.canEqual(new EntityViewEntity()));
  }

  /**
   * Test {@link AbstractEntityViewEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#canEqual(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractEntityViewEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityViewEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}, and {@link
   * AbstractEntityViewEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = new EntityViewEntity();

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity2);
    assertEquals(entityViewEntity.hashCode(), entityViewEntity2.hashCode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}, and {@link
   * AbstractEntityViewEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity);
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity.hashCode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(entityViewEntity, assetEntity);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getVersion()).thenReturn(1L);
    when(entityViewEntity2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityViewEntity2.getCreatedTime()).thenReturn(1L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getVersion()).thenThrow(new IllegalArgumentException());
    when(entityViewEntity2.getId()).thenThrow(new IllegalArgumentException());
    when(entityViewEntity2.getCreatedTime()).thenThrow(new IllegalArgumentException());
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityViewEntity.equals(entityViewEntity2));
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewEntity(), null);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewEntity(), "Different type to AbstractEntityViewEntity");
  }

  /**
   * Test {@link AbstractEntityViewEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getAdditionalInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractEntityViewEntity.getAdditionalInfo()"})
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getCustomerId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getCustomerId()"})
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEndTs()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getEndTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractEntityViewEntity.getEndTs()"})
  public void testGetEndTs() {
    // Arrange, Act and Assert
    assertEquals(0L, new EntityViewEntity().getEndTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEntityId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getEntityId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getEntityId()"})
  public void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getEntityId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEntityType()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType AbstractEntityViewEntity.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getEntityType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getExternalId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getExternalId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getExternalId()"})
  public void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getExternalId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getKeys()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getKeys()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.getKeys()"})
  public void testGetKeys() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getName());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getStartTs()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getStartTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractEntityViewEntity.getStartTs()"})
  public void testGetStartTs() {
    // Arrange, Act and Assert
    assertEquals(0L, new EntityViewEntity().getStartTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getTenantId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getTenantId()"})
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setAdditionalInfo(JsonNode)"})
  public void testSetAdditionalInfo() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    entityViewEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, entityViewEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, entityViewEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setCustomerId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setCustomerId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setCustomerId(UUID)"})
  public void testSetCustomerId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = entityViewEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, entityViewEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEndTs(long)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setEndTs(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setEndTs(long)"})
  public void testSetEndTs() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setEndTs(1L);

    // Assert
    assertEquals(1L, entityViewEntity.toData().getEndTimeMs());
    assertEquals(1L, entityViewEntity.getEndTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEntityId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setEntityId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setEntityId(UUID)"})
  public void testSetEntityId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setEntityId(entityId);

    // Assert
    assertSame(entityId, entityViewEntity.getEntityId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEntityType(EntityType)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setEntityType(EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setEntityType(EntityType)"})
  public void testSetEntityType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setEntityType(EntityType.TENANT);

    // Assert
    assertEquals(EntityType.TENANT, entityViewEntity.getEntityType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setExternalId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setExternalId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setExternalId(UUID)"})
  public void testSetExternalId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setExternalId(externalId);

    // Assert
    EntityViewId externalId2 = entityViewEntity.toData().getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId2.getEntityType());
    assertTrue(externalId2.isNullUid());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, entityViewEntity.getExternalId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setKeys(String)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setKeys(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setKeys(String)"})
  public void testSetKeys() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setKeys("Keys");

    // Assert
    assertEquals("Keys", entityViewEntity.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setName(String)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setName(String)"})
  public void testSetName() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setName("Name");

    // Assert
    assertEquals("Name", entityViewEntity.toData().getName());
    assertEquals("Name", entityViewEntity.getName());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setStartTs(long)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setStartTs(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setStartTs(long)"})
  public void testSetStartTs() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setStartTs(1L);

    // Assert
    assertEquals(1L, entityViewEntity.toData().getStartTimeMs());
    assertEquals(1L, entityViewEntity.getStartTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = entityViewEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, entityViewEntity.getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setType(String)"})
  public void testSetType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setType("Type");

    // Assert
    assertEquals("Type", entityViewEntity.toData().getType());
    assertEquals("Type", entityViewEntity.getType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityViewEntity()", new EntityViewEntity().toString());
  }
}
