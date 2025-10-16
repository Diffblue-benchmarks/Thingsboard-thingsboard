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
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class EdgeInfoEntityDiffblueTest {
  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and {@link EdgeInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    EdgeInfoEntity edgeInfoEntity2 = new EdgeInfoEntity();

    // Act and Assert
    assertEquals(edgeInfoEntity, edgeInfoEntity2);
    assertEquals(edgeInfoEntity.hashCode(), edgeInfoEntity2.hashCode());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and {@link EdgeInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerTitle("Dr");

    EdgeInfoEntity edgeInfoEntity2 = new EdgeInfoEntity();
    edgeInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(edgeInfoEntity, edgeInfoEntity2);
    assertEquals(edgeInfoEntity.hashCode(), edgeInfoEntity2.hashCode());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and {@link EdgeInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(edgeInfoEntity, new EdgeInfoEntity());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(edgeInfoEntity, new EdgeInfoEntity());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeInfoEntity, new EdgeInfoEntity());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();

    EdgeInfoEntity edgeInfoEntity2 = new EdgeInfoEntity();
    edgeInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(edgeInfoEntity, edgeInfoEntity2);
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfoEntity(), null);
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfoEntity(), "Different type to EdgeInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeInfoEntity.<init>()",
    "String EdgeInfoEntity.getCustomerTitle()",
    "boolean EdgeInfoEntity.isCustomerIsPublic()",
    "void EdgeInfoEntity.setCustomerIsPublic(boolean)",
    "void EdgeInfoEntity.setCustomerTitle(String)",
    "String EdgeInfoEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity();
    actualEdgeInfoEntity.setCustomerIsPublic(true);
    actualEdgeInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualEdgeInfoEntity.toString();
    String actualCustomerTitle = actualEdgeInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualEdgeInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("EdgeInfoEntity(customerTitle=Dr, customerIsPublic=true)", actualToStringResult);
    assertNull(actualEdgeInfoEntity.getAdditionalInfo());
    assertNull(actualEdgeInfoEntity.getVersion());
    assertNull(actualEdgeInfoEntity.getLabel());
    assertNull(actualEdgeInfoEntity.getName());
    assertNull(actualEdgeInfoEntity.getRoutingKey());
    assertNull(actualEdgeInfoEntity.getSecret());
    assertNull(actualEdgeInfoEntity.getType());
    assertNull(actualEdgeInfoEntity.getId());
    assertNull(actualEdgeInfoEntity.getUuid());
    assertNull(actualEdgeInfoEntity.getCustomerId());
    assertNull(actualEdgeInfoEntity.getRootRuleChainId());
    assertNull(actualEdgeInfoEntity.getTenantId());
    assertEquals(0L, actualEdgeInfoEntity.getCreatedTime());
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}.
   *
   * <p>Method under test: {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeInfoEntity.<init>(EdgeEntity, String, Object)"})
  public void testNewEdgeInfoEntity() {
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
    assertTrue(actualEdgeInfoEntity.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Dr", actualEdgeInfoEntity.getCustomerTitle());
    assertEquals("Label", actualEdgeInfoEntity.getLabel());
    assertEquals("Name", actualEdgeInfoEntity.getName());
    assertEquals("Routing Key", actualEdgeInfoEntity.getRoutingKey());
    assertEquals("Secret", actualEdgeInfoEntity.getSecret());
    assertEquals("Type", actualEdgeInfoEntity.getType());
    assertEquals(1L, actualEdgeInfoEntity.getVersion().longValue());
    assertEquals(1L, actualEdgeInfoEntity.getCreatedTime());
    assertFalse(actualEdgeInfoEntity.isCustomerIsPublic());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EdgeInfoEntity#EdgeInfoEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  public void testToData_givenEdgeInfoEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    UUID tenantId = UUID.randomUUID();
    edgeInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = edgeInfoEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EdgeInfoEntity#EdgeInfoEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  public void testToData_givenEdgeInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EdgeInfo actualToDataResult = new EdgeInfoEntity().toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getRootRuleChainId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is Instance.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
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
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  public void testToData_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    // Act
    EdgeInfo actualToDataResult = edgeInfoEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return RootRuleChainId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  public void testToData_thenReturnRootRuleChainIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
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
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = edgeInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
