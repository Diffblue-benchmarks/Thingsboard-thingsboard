package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EdgeEntityDiffblueTest {
  /**
   * Test {@link EdgeEntity#equals(Object)}, and {@link EdgeEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEntity#equals(Object)}
   *   <li>{@link EdgeEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    EdgeEntity edgeEntity2 = new EdgeEntity();
    edgeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity2.setCreatedTime(1L);
    edgeEntity2.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity2.setId(ModelConstants.NULL_UUID);
    edgeEntity2.setLabel("Label");
    edgeEntity2.setName("Name");
    edgeEntity2.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity2.setRoutingKey("Routing Key");
    edgeEntity2.setSecret("Secret");
    edgeEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity2.setType("Type");
    edgeEntity2.setUuid(ModelConstants.NULL_UUID);
    edgeEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity2);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity2.hashCode());
  }

  /**
   * Test {@link EdgeEntity#equals(Object)}, and {@link EdgeEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEntity#equals(Object)}
   *   <li>{@link EdgeEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity.hashCode());
  }

  /**
   * Test {@link EdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(MissingNode.getInstance());
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    EdgeEntity edgeEntity2 = new EdgeEntity();
    edgeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity2.setCreatedTime(1L);
    edgeEntity2.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity2.setId(ModelConstants.NULL_UUID);
    edgeEntity2.setLabel("Label");
    edgeEntity2.setName("Name");
    edgeEntity2.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity2.setRoutingKey("Routing Key");
    edgeEntity2.setSecret("Secret");
    edgeEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity2.setType("Type");
    edgeEntity2.setUuid(ModelConstants.NULL_UUID);
    edgeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
  }

  /**
   * Test {@link EdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(mock(JsonNode.class));
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    EdgeEntity edgeEntity2 = new EdgeEntity();
    edgeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity2.setCreatedTime(1L);
    edgeEntity2.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity2.setId(ModelConstants.NULL_UUID);
    edgeEntity2.setLabel("Label");
    edgeEntity2.setName("Name");
    edgeEntity2.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity2.setRoutingKey("Routing Key");
    edgeEntity2.setSecret("Secret");
    edgeEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity2.setType("Type");
    edgeEntity2.setUuid(ModelConstants.NULL_UUID);
    edgeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
  }

  /**
   * Test {@link EdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(edgeEntity, null);
  }

  /**
   * Test {@link EdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(edgeEntity, "Different type to EdgeEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEntity#EdgeEntity()}
   *   <li>{@link EdgeEntity#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EdgeEntity actualEdgeEntity = new EdgeEntity();

    // Assert
    assertEquals("EdgeEntity()", actualEdgeEntity.toString());
    assertNull(actualEdgeEntity.getAdditionalInfo());
    assertNull(actualEdgeEntity.getVersion());
    assertNull(actualEdgeEntity.getLabel());
    assertNull(actualEdgeEntity.getName());
    assertNull(actualEdgeEntity.getRoutingKey());
    assertNull(actualEdgeEntity.getSecret());
    assertNull(actualEdgeEntity.getType());
    assertNull(actualEdgeEntity.getId());
    assertNull(actualEdgeEntity.getUuid());
    assertNull(actualEdgeEntity.getCustomerId());
    assertNull(actualEdgeEntity.getRootRuleChainId());
    assertNull(actualEdgeEntity.getTenantId());
    assertEquals(0L, actualEdgeEntity.getCreatedTime());
  }

  /**
   * Test {@link EdgeEntity#EdgeEntity(Edge)}.
   * <p>
   * Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  public void testNewEdgeEntity() {
    // Arrange
    Edge edge = new Edge();
    edge.setTenantId(null);
    edge.setCustomerId(null);
    RuleChainId rootRuleChainId = new RuleChainId(ModelConstants.NULL_UUID);
    edge.setRootRuleChainId(rootRuleChainId);

    // Act
    EdgeEntity actualEdgeEntity = new EdgeEntity(edge);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEdgeEntity.getRootRuleChainId().toString());
    assertEquals(rootRuleChainId, actualEdgeEntity.toData().getRootRuleChainId());
  }

  /**
   * Test {@link EdgeEntity#EdgeEntity(Edge)}.
   * <ul>
   *   <li>Then return CustomerId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  public void testNewEdgeEntity_thenReturnCustomerIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Edge edge = new Edge();
    edge.setTenantId(null);
    edge.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    edge.setRootRuleChainId(null);

    // Act
    EdgeEntity actualEdgeEntity = new EdgeEntity(edge);

    // Assert
    UUID customerId = actualEdgeEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = actualEdgeEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
  }

  /**
   * Test {@link EdgeEntity#EdgeEntity(Edge)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return CustomerId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  public void testNewEdgeEntity_whenEdge_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    EdgeEntity actualEdgeEntity = new EdgeEntity(new Edge());

    // Assert
    assertNull(actualEdgeEntity.getCustomerId());
    assertNull(actualEdgeEntity.getRootRuleChainId());
    assertNull(actualEdgeEntity.getTenantId());
    Edge toDataResult = actualEdgeEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getRootRuleChainId());
    assertNull(toDataResult.getTenantId());
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} CustomerId is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return RootRuleChainId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  public void testToData_givenEdgeEntityCustomerIdIsNull_uuid_thenReturnRootRuleChainIdIsNull() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    edgeEntity.setTenantId(null);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setRootRuleChainId(null);

    // Act
    Edge actualToDataResult = edgeEntity.toData();

    // Assert
    assertNull(actualToDataResult.getRootRuleChainId());
    assertNull(actualToDataResult.getTenantId());
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  public void testToData_givenEdgeEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    edgeEntity.setTenantId(tenantId);
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId2 = edgeEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  public void testToData_givenEdgeEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Edge actualToDataResult = (new EdgeEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getRoutingKey());
    assertNull(actualToDataResult.getSecret());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    EdgeId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(0L, actualToDataResult.getCreatedTime());
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
   * Test {@link EdgeEntity#toData()}.
   * <ul>
   *   <li>Then return RootRuleChainId EntityType is {@code RULE_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  public void testToData_thenReturnRootRuleChainIdEntityTypeIsRuleChain() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    edgeEntity.setTenantId(null);
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act
    Edge actualToDataResult = edgeEntity.toData();

    // Assert
    assertNull(actualToDataResult.getTenantId());
    RuleChainId rootRuleChainId = actualToDataResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertTrue(rootRuleChainId.isNullUid());
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(null);

    // Act and Assert
    TenantId tenantId = edgeEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
