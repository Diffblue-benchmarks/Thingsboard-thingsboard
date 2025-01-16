package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewEntityDiffblueTest {
  /**
   * Test {@link EntityViewEntity#equals(Object)}, and
   * {@link EntityViewEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewEntity#equals(Object)}
   *   <li>{@link EntityViewEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    EntityViewEntity entityViewEntity2 = new EntityViewEntity();
    entityViewEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity2.setCreatedTime(1L);
    entityViewEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEndTs(1L);
    entityViewEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEntityType(EntityType.TENANT);
    entityViewEntity2.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity2.setId(ModelConstants.NULL_UUID);
    entityViewEntity2.setKeys("Keys");
    entityViewEntity2.setName("Name");
    entityViewEntity2.setStartTs(1L);
    entityViewEntity2.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity2.setType("Type");
    entityViewEntity2.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity2);
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity2.hashCode());
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}, and
   * {@link EntityViewEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewEntity#equals(Object)}
   *   <li>{@link EntityViewEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity);
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity.hashCode());
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(MissingNode.getInstance());
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

    EntityViewEntity entityViewEntity2 = new EntityViewEntity();
    entityViewEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity2.setCreatedTime(1L);
    entityViewEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEndTs(1L);
    entityViewEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEntityType(EntityType.TENANT);
    entityViewEntity2.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity2.setId(ModelConstants.NULL_UUID);
    entityViewEntity2.setKeys("Keys");
    entityViewEntity2.setName("Name");
    entityViewEntity2.setStartTs(1L);
    entityViewEntity2.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity2.setType("Type");
    entityViewEntity2.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(mock(JsonNode.class));
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

    EntityViewEntity entityViewEntity2 = new EntityViewEntity();
    entityViewEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity2.setCreatedTime(1L);
    entityViewEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEndTs(1L);
    entityViewEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEntityType(EntityType.TENANT);
    entityViewEntity2.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity2.setId(ModelConstants.NULL_UUID);
    entityViewEntity2.setKeys("Keys");
    entityViewEntity2.setName("Name");
    entityViewEntity2.setStartTs(1L);
    entityViewEntity2.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity2.setType("Type");
    entityViewEntity2.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(entityViewEntity, null);
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(entityViewEntity, "Different type to EntityViewEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewEntity#EntityViewEntity()}
   *   <li>{@link EntityViewEntity#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity();

    // Assert
    assertEquals("EntityViewEntity()", actualEntityViewEntity.toString());
    assertNull(actualEntityViewEntity.getAdditionalInfo());
    assertNull(actualEntityViewEntity.getVersion());
    assertNull(actualEntityViewEntity.getKeys());
    assertNull(actualEntityViewEntity.getName());
    assertNull(actualEntityViewEntity.getType());
    assertNull(actualEntityViewEntity.getId());
    assertNull(actualEntityViewEntity.getUuid());
    assertNull(actualEntityViewEntity.getCustomerId());
    assertNull(actualEntityViewEntity.getEntityId());
    assertNull(actualEntityViewEntity.getExternalId());
    assertNull(actualEntityViewEntity.getTenantId());
    assertNull(actualEntityViewEntity.getEntityType());
    assertEquals(0L, actualEntityViewEntity.getCreatedTime());
    assertEquals(0L, actualEntityViewEntity.getEndTs());
    assertEquals(0L, actualEntityViewEntity.getStartTs());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   * <p>
   * Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  public void testNewEntityViewEntity() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setEntityId(null);
    entityView.setTenantId(null);
    entityView.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    entityView.setExternalId(null);
    entityView.setKeys(null);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    UUID customerId = actualEntityViewEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = actualEntityViewEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   * <p>
   * Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  public void testNewEntityViewEntity2() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setEntityId(null);
    entityView.setTenantId(null);
    entityView.setCustomerId(null);
    EntityViewId externalId = new EntityViewId(ModelConstants.NULL_UUID);
    entityView.setExternalId(externalId);
    entityView.setKeys(new TelemetryEntityView());

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityViewEntity.getExternalId().toString());
    assertEquals(externalId, actualEntityViewEntity.toData().getExternalId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   * <ul>
   *   <li>Then return Keys is {@code {"timeseries":null,"attributes":null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  public void testNewEntityViewEntity_thenReturnKeysIsTimeseriesNullAttributesNull() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setEntityId(null);
    entityView.setTenantId(null);
    entityView.setCustomerId(null);
    entityView.setExternalId(null);
    TelemetryEntityView keys = new TelemetryEntityView();
    entityView.setKeys(keys);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    assertEquals("{\"timeseries\":null,\"attributes\":null}", actualEntityViewEntity.getKeys());
    assertEquals(keys, actualEntityViewEntity.toData().getKeys());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   * <ul>
   *   <li>Then toData EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  public void testNewEntityViewEntity_thenToDataEntityIdReturnCustomerId() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    entityView.setTenantId(null);
    entityView.setCustomerId(null);
    entityView.setExternalId(null);
    entityView.setKeys(null);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    EntityId entityId = actualEntityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    UUID entityId2 = actualEntityViewEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId2.toString());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertEquals(EntityType.CUSTOMER, actualEntityViewEntity.getEntityType());
    assertTrue(entityId.isNullUid());
    assertSame(entityId2, entityId.getId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   * <ul>
   *   <li>Then toData EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  public void testNewEntityViewEntity_thenToDataEntityIdReturnTenantId() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setEntityId(ModelConstants.SYSTEM_TENANT);
    entityView.setTenantId(null);
    entityView.setCustomerId(null);
    entityView.setExternalId(null);
    entityView.setKeys(new TelemetryEntityView());

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    EntityId entityId = actualEntityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertEquals(EntityType.TENANT, actualEntityViewEntity.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   * <ul>
   *   <li>When {@link EntityView#EntityView()}.</li>
   *   <li>Then return Keys is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  public void testNewEntityViewEntity_whenEntityView_thenReturnKeysIsNull() {
    // Arrange and Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(new EntityView());

    // Assert
    assertNull(actualEntityViewEntity.getKeys());
    assertNull(actualEntityViewEntity.getEntityId());
    assertNull(actualEntityViewEntity.getEntityType());
    EntityView toDataResult = actualEntityViewEntity.toData();
    assertNull(toDataResult.getEntityId());
    assertNull(toDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityType is
   * {@code ASSET}.</li>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewEntityEntityTypeIsAsset_thenEntityIdReturnAssetId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.ASSET);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityType is
   * {@code USER}.</li>
   *   <li>Then EntityId return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals(EntityType.USER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is
   * {@code foo}.</li>
   *   <li>Then return ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewEntityKeysIsFoo_thenReturnExternalIdIsNull() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys("foo");
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act
    EntityView actualToDataResult = entityViewEntity.toData();

    // Assert
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    EntityViewId id = actualToDataResult.getId();
    assertEquals(EntityType.ENTITY_VIEW, id.getEntityType());
    assertTrue(id.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EntityView actualToDataResult = (new EntityViewEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    EntityViewId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getEndTimeMs());
    assertEquals(0L, actualToDataResult.getStartTimeMs());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.CUSTOMER);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.DASHBOARD);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(null);

    // Act
    EntityView actualToDataResult = entityViewEntity.toData();

    // Assert
    assertNull(actualToDataResult.getEntityId());
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then return EntityId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenReturnEntityIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code ENTITY_VIEW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdEntityTypeIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    EntityView actualToDataResult = entityViewEntity.toData();

    // Assert
    EntityViewId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then return Keys is
   * {@link TelemetryEntityView#TelemetryEntityView()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenReturnKeysIsTelemetryEntityView() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ObjectMapper objectMapper = new ObjectMapper();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(objectMapper.writeValueAsString(telemetryEntityView));
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act
    EntityView actualToDataResult = entityViewEntity.toData();

    // Assert
    assertNull(actualToDataResult.getEntityId());
    assertEquals(telemetryEntityView, actualToDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then return not EntityId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotEntityIdNullUid() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setKeys(null);
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = entityViewEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
