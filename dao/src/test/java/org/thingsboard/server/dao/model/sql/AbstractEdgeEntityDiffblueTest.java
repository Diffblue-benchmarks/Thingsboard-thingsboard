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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractEdgeEntityDiffblueTest {
  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  public void testToEdge_givenEdgeEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID tenantId = UUID.randomUUID();
    edgeEntity.setTenantId(tenantId);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act
    Edge actualToEdgeResult = edgeEntity.toEdge();

    // Assert
    CustomerId customerId = actualToEdgeResult.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    RuleChainId rootRuleChainId = actualToEdgeResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    TenantId tenantId2 = actualToEdgeResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(customerId.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertSame(id, rootRuleChainId.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  public void testToEdge_givenEdgeEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Edge actualToEdgeResult = new EdgeEntity().toEdge();

    // Assert
    assertTrue(actualToEdgeResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToEdgeResult.getVersion());
    assertNull(actualToEdgeResult.getLabel());
    assertNull(actualToEdgeResult.getName());
    assertNull(actualToEdgeResult.getRoutingKey());
    assertNull(actualToEdgeResult.getSecret());
    assertNull(actualToEdgeResult.getType());
    assertNull(actualToEdgeResult.getUuidId());
    assertNull(actualToEdgeResult.getCustomerId());
    assertNull(actualToEdgeResult.getRootRuleChainId());
    assertNull(actualToEdgeResult.getTenantId());
    assertEquals(0L, actualToEdgeResult.getCreatedTime());
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  public void testToEdge_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act
    Edge actualToEdgeResult = edgeEntity.toEdge();

    // Assert
    CustomerId customerId = actualToEdgeResult.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    TenantId tenantId = actualToEdgeResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    RuleChainId rootRuleChainId = actualToEdgeResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(id, rootRuleChainId.getId());
  }

  /**
   * Test {@link AbstractEdgeEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link EdgeEntity#EdgeEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#canEqual(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractEdgeEntity.canEqual(Object)"})
  public void testCanEqual_whenEdgeEntity_thenReturnTrue() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act and Assert
    assertTrue(edgeEntity.canEqual(new EdgeEntity()));
  }

  /**
   * Test {@link AbstractEdgeEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#canEqual(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractEdgeEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EdgeEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and {@link AbstractEdgeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity2);
    assertEquals(edgeEntity.hashCode(), edgeEntity2.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and {@link AbstractEdgeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

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
    assertNotEquals(edgeEntity, assetEntity);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getVersion()).thenReturn(1L);
    when(edgeEntity2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(edgeEntity2.getCreatedTime()).thenReturn(1L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), null);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), "Different type to AbstractEdgeEntity");
  }

  /**
   * Test {@link AbstractEdgeEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getAdditionalInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractEdgeEntity.getAdditionalInfo()"})
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEdgeEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getCustomerId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEdgeEntity.getCustomerId()"})
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getLabel()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getLabel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEdgeEntity.getLabel()"})
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getLabel());
  }

  /**
   * Test {@link AbstractEdgeEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEdgeEntity.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getName());
  }

  /**
   * Test {@link AbstractEdgeEntity#getRootRuleChainId()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getRootRuleChainId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEdgeEntity.getRootRuleChainId()"})
  public void testGetRootRuleChainId() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getRootRuleChainId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getRoutingKey()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getRoutingKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEdgeEntity.getRoutingKey()"})
  public void testGetRoutingKey() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getRoutingKey());
  }

  /**
   * Test {@link AbstractEdgeEntity#getSecret()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getSecret()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEdgeEntity.getSecret()"})
  public void testGetSecret() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getSecret());
  }

  /**
   * Test {@link AbstractEdgeEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getTenantId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEdgeEntity.getTenantId()"})
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getTenantId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEdgeEntity.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getType());
  }

  /**
   * Test {@link AbstractEdgeEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setAdditionalInfo(JsonNode)"})
  public void testSetAdditionalInfo() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    edgeEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, edgeEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, edgeEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEdgeEntity#setCustomerId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setCustomerId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setCustomerId(UUID)"})
  public void testSetCustomerId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    edgeEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = edgeEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, edgeEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setLabel(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setLabel(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setLabel(String)"})
  public void testSetLabel() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setLabel("Label");

    // Assert
    assertEquals("Label", edgeEntity.toData().getLabel());
    assertEquals("Label", edgeEntity.getLabel());
  }

  /**
   * Test {@link AbstractEdgeEntity#setName(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setName(String)"})
  public void testSetName() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setName("Name");

    // Assert
    assertEquals("Name", edgeEntity.toData().getName());
    assertEquals("Name", edgeEntity.getName());
  }

  /**
   * Test {@link AbstractEdgeEntity#setRootRuleChainId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setRootRuleChainId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setRootRuleChainId(UUID)"})
  public void testSetRootRuleChainId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID rootRuleChainId = ModelConstants.NULL_UUID;

    // Act
    edgeEntity.setRootRuleChainId(rootRuleChainId);

    // Assert
    RuleChainId rootRuleChainId2 = edgeEntity.toData().getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    assertTrue(rootRuleChainId2.isNullUid());
    assertSame(rootRuleChainId, rootRuleChainId2.getId());
    assertSame(rootRuleChainId, edgeEntity.getRootRuleChainId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setRoutingKey(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setRoutingKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setRoutingKey(String)"})
  public void testSetRoutingKey() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setRoutingKey("Routing Key");

    // Assert
    assertEquals("Routing Key", edgeEntity.toData().getRoutingKey());
    assertEquals("Routing Key", edgeEntity.getRoutingKey());
  }

  /**
   * Test {@link AbstractEdgeEntity#setSecret(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setSecret(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setSecret(String)"})
  public void testSetSecret() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setSecret("Secret");

    // Assert
    assertEquals("Secret", edgeEntity.toData().getSecret());
    assertEquals("Secret", edgeEntity.getSecret());
  }

  /**
   * Test {@link AbstractEdgeEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    edgeEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = edgeEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, edgeEntity.getTenantId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEdgeEntity.setType(String)"})
  public void testSetType() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setType("Type");

    // Assert
    assertEquals("Type", edgeEntity.toData().getType());
    assertEquals("Type", edgeEntity.getType());
  }

  /**
   * Test {@link AbstractEdgeEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEdgeEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("EdgeEntity()", new EdgeEntity().toString());
  }
}
