package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class EdgeInfoEntityDiffblueTest {
  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and
   * {@link EdgeInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    EdgeInfoEntity edgeInfoEntity2 = new EdgeInfoEntity();

    // Act and Assert
    assertEquals(edgeInfoEntity, edgeInfoEntity2);
    int expectedHashCodeResult = edgeInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeInfoEntity2.hashCode());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and
   * {@link EdgeInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerTitle("Dr");

    EdgeInfoEntity edgeInfoEntity2 = new EdgeInfoEntity();
    edgeInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(edgeInfoEntity, edgeInfoEntity2);
    int expectedHashCodeResult = edgeInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeInfoEntity2.hashCode());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and
   * {@link EdgeInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();

    // Act and Assert
    assertEquals(edgeInfoEntity, edgeInfoEntity);
    int expectedHashCodeResult = edgeInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeInfoEntity.hashCode());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();

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
    assertNotEquals(edgeInfoEntity, edgeEntity);
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfoEntity(), mock(EdgeEntity.class));
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(edgeInfoEntity, new EdgeInfoEntity());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(edgeInfoEntity, new EdgeInfoEntity());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeInfoEntity, new EdgeInfoEntity());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();

    EdgeInfoEntity edgeInfoEntity2 = new EdgeInfoEntity();
    edgeInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(edgeInfoEntity, edgeInfoEntity2);
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfoEntity(), null);
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfoEntity(), "Different type to EdgeInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInfoEntity#EdgeInfoEntity()}
   *   <li>{@link EdgeInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link EdgeInfoEntity#setCustomerTitle(String)}
   *   <li>{@link EdgeInfoEntity#toString()}
   *   <li>{@link EdgeInfoEntity#getCustomerTitle()}
   *   <li>{@link EdgeInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity();
    actualEdgeInfoEntity.setCustomerIsPublic(true);
    actualEdgeInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualEdgeInfoEntity.toString();
    String actualCustomerTitle = actualEdgeInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualEdgeInfoEntity.isCustomerIsPublic();

    // Assert that nothing has changed
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("EdgeInfoEntity(customerTitle=Dr, customerIsPublic=true)", actualToStringResult);
    assertEquals(0L, actualEdgeInfoEntity.getCreatedTime());
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}
   */
  @Test
  public void testNewEdgeInfoEntity_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
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

    // Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity(edgeEntity, "Dr",
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    JsonNode additionalInfo = actualEdgeInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertSame(additionalInfo, actualEdgeInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}.
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}
   */
  @Test
  public void testNewEdgeInfoEntity_whenBigIntegerNodeWithVIsValueOfOne() {
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

    // Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity(edgeEntity, "Dr",
        new BigIntegerNode(BigInteger.valueOf(1L)));

    // Assert
    JsonNode additionalInfo = actualEdgeInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertSame(additionalInfo, actualEdgeInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}
   */
  @Test
  public void testNewEdgeInfoEntity_whenNull() {
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

    // Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity(edgeEntity, "Dr", null);

    // Assert
    JsonNode additionalInfo = actualEdgeInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertSame(additionalInfo, actualEdgeInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link EdgeInfoEntity#EdgeInfoEntity()} TenantId is
   * randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEdgeInfoEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    UUID tenantId = UUID.randomUUID();
    edgeInfoEntity.setTenantId(tenantId);
    edgeInfoEntity.setCustomerId(null);
    edgeInfoEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId2 = edgeInfoEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link EdgeInfoEntity#EdgeInfoEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  public void testToData_givenEdgeInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EdgeInfo actualToDataResult = (new EdgeInfoEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getRootRuleChainId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   * <ul>
   *   <li>Then return AdditionalInfo is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAdditionalInfoIsInstance() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    MissingNode additionalInfo = MissingNode.getInstance();
    edgeInfoEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    assertSame(additionalInfo, edgeInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   * <ul>
   *   <li>Then return CustomerId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(null);
    edgeInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeInfoEntity.setRootRuleChainId(null);

    // Act
    EdgeInfo actualToDataResult = edgeInfoEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToDataResult.getRootRuleChainId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   * <ul>
   *   <li>Then return RootRuleChainId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnRootRuleChainIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(null);
    edgeInfoEntity.setCustomerId(null);
    edgeInfoEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act
    EdgeInfo actualToDataResult = edgeInfoEntity.toData();

    // Assert
    RuleChainId rootRuleChainId = actualToDataResult.getRootRuleChainId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", rootRuleChainId.getId().toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertTrue(rootRuleChainId.isNullUid());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeInfoEntity.setCustomerId(null);
    edgeInfoEntity.setRootRuleChainId(null);

    // Act and Assert
    TenantId tenantId = edgeInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
