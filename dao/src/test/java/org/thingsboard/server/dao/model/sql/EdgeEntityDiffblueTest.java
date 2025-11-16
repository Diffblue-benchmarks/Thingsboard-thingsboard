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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EdgeEntityDiffblueTest {
  /**
   * Test {@link EdgeEntity#equals(Object)}, and {@link EdgeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEntity#equals(Object)}
   *   <li>{@link EdgeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
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
    assertEquals(edgeEntity.hashCode(), edgeEntity2.hashCode());
  }

  /**
   * Test {@link EdgeEntity#equals(Object)}, and {@link EdgeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEntity#equals(Object)}
   *   <li>{@link EdgeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEntity#EdgeEntity()}
   *   <li>{@link EdgeEntity#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEntity.<init>()", "java.lang.String EdgeEntity.toString()"})
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
   *
   * <p>Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
  public void testNewEdgeEntity() {
    // Arrange
    Edge edge = new Edge();
    RuleChainId rootRuleChainId = new RuleChainId(ModelConstants.NULL_UUID);
    edge.setRootRuleChainId(rootRuleChainId);

    // Act
    EdgeEntity actualEdgeEntity = new EdgeEntity(edge);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualEdgeEntity.getRootRuleChainId().toString());
    assertEquals(rootRuleChainId, actualEdgeEntity.toData().getRootRuleChainId());
  }

  /**
   * Test {@link EdgeEntity#EdgeEntity(Edge)}.
   *
   * <ul>
   *   <li>Then return CustomerId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
  public void testNewEdgeEntity_thenReturnCustomerIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Edge edge = new Edge();
    edge.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);

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
   *
   * <ul>
   *   <li>Then return TenantId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
  public void testNewEdgeEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Edge edge = new Edge();
    edge.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    EdgeEntity actualEdgeEntity = new EdgeEntity(edge);

    // Assert
    UUID tenantId = actualEdgeEntity.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    TenantId tenantId2 = actualEdgeEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link EdgeEntity#EdgeEntity(Edge)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge()}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
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
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  public void testToData_givenEdgeEntityTenantIdIsNull_uuid_thenAdditionalInfoReturnObjectNode() {
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
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act
    Edge actualToDataResult = edgeEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Routing Key", actualToDataResult.getRoutingKey());
    assertEquals("Secret", actualToDataResult.getSecret());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  public void testToData_givenEdgeEntityTenantIdIsRandomUUID() {
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
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act
    Edge actualToDataResult = edgeEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualToDataResult.getLabel());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("Routing Key", actualToDataResult.getRoutingKey());
    assertEquals("Secret", actualToDataResult.getSecret());
    assertEquals("Type", actualToDataResult.getType());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  public void testToData_givenEdgeEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Edge actualToDataResult = new EdgeEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getRoutingKey());
    assertNull(actualToDataResult.getSecret());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getRootRuleChainId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }
}
