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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewInfoEntityDiffblueTest {
  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and
   * {@link EntityViewInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    EntityViewInfoEntity entityViewInfoEntity2 = new EntityViewInfoEntity();

    // Act and Assert
    assertEquals(entityViewInfoEntity, entityViewInfoEntity2);
    int expectedHashCodeResult = entityViewInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfoEntity2.hashCode());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and
   * {@link EntityViewInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerTitle("Dr");

    EntityViewInfoEntity entityViewInfoEntity2 = new EntityViewInfoEntity();
    entityViewInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(entityViewInfoEntity, entityViewInfoEntity2);
    int expectedHashCodeResult = entityViewInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfoEntity2.hashCode());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and
   * {@link EntityViewInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfoEntity(), mock(EntityViewEntity.class));
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, new EntityViewInfoEntity());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, new EntityViewInfoEntity());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, new EntityViewInfoEntity());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    EntityViewInfoEntity entityViewInfoEntity2 = new EntityViewInfoEntity();
    entityViewInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfoEntity, entityViewInfoEntity2);
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfoEntity(), null);
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfoEntity(), "Different type to EntityViewInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityViewInfoEntity actualEntityViewInfoEntity = new EntityViewInfoEntity();
    actualEntityViewInfoEntity.setCustomerIsPublic(true);
    actualEntityViewInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualEntityViewInfoEntity.toString();
    String actualCustomerTitle = actualEntityViewInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualEntityViewInfoEntity.isCustomerIsPublic();

    // Assert that nothing has changed
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("EntityViewInfoEntity(customerTitle=Dr, customerIsPublic=true)", actualToStringResult);
    assertEquals(0L, actualEntityViewInfoEntity.getCreatedTime());
    assertEquals(0L, actualEntityViewInfoEntity.getEndTs());
    assertEquals(0L, actualEntityViewInfoEntity.getStartTs());
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test
   * {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}
   */
  @Test
  public void testNewEntityViewInfoEntity_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
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
    EntityViewInfoEntity actualEntityViewInfoEntity = new EntityViewInfoEntity(entityViewEntity, "Dr",
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    JsonNode additionalInfo = actualEntityViewInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    EntityViewInfo toDataResult = actualEntityViewInfoEntity.toData();
    EntityViewId expectedId = toDataResult.getExternalId();
    assertEquals(expectedId, toDataResult.getId());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
  }

  /**
   * Test
   * {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}.
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}
   */
  @Test
  public void testNewEntityViewInfoEntity_whenBigIntegerNodeWithVIsValueOfOne() {
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
    EntityViewInfoEntity actualEntityViewInfoEntity = new EntityViewInfoEntity(entityViewEntity, "Dr",
        new BigIntegerNode(BigInteger.valueOf(1L)));

    // Assert
    JsonNode additionalInfo = actualEntityViewInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    EntityViewInfo toDataResult = actualEntityViewInfoEntity.toData();
    EntityViewId expectedId = toDataResult.getExternalId();
    assertEquals(expectedId, toDataResult.getId());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
  }

  /**
   * Test
   * {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewInfoEntity#EntityViewInfoEntity(EntityViewEntity, String, Object)}
   */
  @Test
  public void testNewEntityViewInfoEntity_whenNull() {
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
    EntityViewInfoEntity actualEntityViewInfoEntity = new EntityViewInfoEntity(entityViewEntity, "Dr", null);

    // Assert
    JsonNode additionalInfo = actualEntityViewInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    EntityViewInfo toDataResult = actualEntityViewInfoEntity.toData();
    EntityViewId expectedId = toDataResult.getExternalId();
    assertEquals(expectedId, toDataResult.getId());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData() throws JsonProcessingException {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    ObjectMapper objectMapper = new ObjectMapper();
    entityViewInfoEntity
        .setKeys(objectMapper.writeValueAsString(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true))));
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData2() throws JsonProcessingException {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys((new ObjectMapper()).writeValueAsString(""));
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} EntityType is
   * {@code ALARM}.</li>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewInfoEntityEntityTypeIsAlarm_thenEntityIdReturnAlarmId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ALARM);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ALARM, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} EntityType is
   * {@code ASSET}.</li>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewInfoEntityEntityTypeIsAsset_thenEntityIdReturnAssetId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.ASSET);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} EntityType is
   * {@code USER}.</li>
   *   <li>Then EntityId return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewInfoEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.USER);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.USER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} Keys is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewInfoEntityKeysIs42() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("42");
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
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
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} Keys is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewInfoEntityKeysIsEmptyString() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("");
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
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
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} Keys is
   * {@code foo}.</li>
   *   <li>Then return CustomerId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewInfoEntityKeysIsFoo_thenReturnCustomerIdIsNull() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys("foo");
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()}.</li>
   *   <li>Then return CustomerId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEntityViewInfoEntity_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    EntityViewInfo actualToDataResult = (new EntityViewInfoEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.CUSTOMER);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DASHBOARD);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnDeviceId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.DEVICE);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.DEVICE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnRuleChainId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.RULE_CHAIN);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnRuleNodeId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.RULE_NODE);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    EntityId entityId = entityViewInfoEntity.toData().getEntityId();
    assertTrue(entityId instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.RULE_NODE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnTenantId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setEntityType(EntityType.TENANT);
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

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
   * <ul>
   *   <li>Then return CustomerId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setExternalId(null);

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
   * <ul>
   *   <li>Then return ExternalId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
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
   * <ul>
   *   <li>Then return Keys is
   * {@link TelemetryEntityView#TelemetryEntityView()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnKeysIsTelemetryEntityView() throws JsonProcessingException {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    ObjectMapper objectMapper = new ObjectMapper();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewInfoEntity.setKeys(objectMapper.writeValueAsString(telemetryEntityView));
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(null);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act
    EntityViewInfo actualToDataResult = entityViewInfoEntity.toData();

    // Assert
    assertNull(actualToDataResult.getEntityId());
    assertEquals(telemetryEntityView, actualToDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(null);
    UUID tenantId = UUID.randomUUID();
    entityViewInfoEntity.setTenantId(tenantId);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId2 = entityViewInfoEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link EntityViewInfoEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setKeys(null);
    entityViewInfoEntity.setEntityId(null);
    entityViewInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewInfoEntity.setCustomerId(null);
    entityViewInfoEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = entityViewInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
