package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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

public class AbstractEdgeEntityDiffblueTest {
  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  public void testToEdge_givenEdgeEntityTenantIdIsRandomUUID_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID tenantId = UUID.randomUUID();
    edgeEntity.setTenantId(tenantId);
    edgeEntity.setCustomerId(null);
    UUID rootRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeEntity.setRootRuleChainId(rootRuleChainId);

    // Act
    Edge actualToEdgeResult = edgeEntity.toEdge();

    // Assert
    RuleChainId rootRuleChainId2 = actualToEdgeResult.getRootRuleChainId();
    UUID id = rootRuleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    TenantId tenantId2 = actualToEdgeResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(rootRuleChainId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(rootRuleChainId, id);
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
  @Category(MaintainedByDiffblue.class)
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
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  public void testToEdge_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeEntity.setCustomerId(customerId);
    edgeEntity.setRootRuleChainId(null);

    // Act and Assert
    CustomerId customerId2 = edgeEntity.toEdge().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   *
   * <ul>
   *   <li>Then return RootRuleChainId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  public void testToEdge_thenReturnRootRuleChainIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(null);
    edgeEntity.setCustomerId(null);
    UUID rootRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeEntity.setRootRuleChainId(rootRuleChainId);

    // Act and Assert
    RuleChainId rootRuleChainId2 = edgeEntity.toEdge().getRootRuleChainId();
    UUID id = rootRuleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    assertFalse(rootRuleChainId2.isNullUid());
    assertSame(rootRuleChainId, id);
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  public void testToEdge_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(null);

    // Act and Assert
    TenantId tenantId = edgeEntity.toEdge().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity2);
    int notExpectedHashCodeResult = edgeEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, edgeEntity2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(1L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(edgeEntity2.getLabel()).thenReturn("Label");
    when(edgeEntity2.getName()).thenReturn("Name");
    when(edgeEntity2.getRoutingKey()).thenReturn("Routing Key");
    when(edgeEntity2.getSecret()).thenReturn("Secret");
    when(edgeEntity2.getType()).thenReturn("Type");
    when(edgeEntity2.getCustomerId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getRootRuleChainId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn("foo");
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn("foo");
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn("foo");
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn("foo");
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn("foo");
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setRootRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setType("Type");
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setName("Name");
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setLabel("Label");
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setRoutingKey("Routing Key");
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setSecret("Secret");
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo()).thenReturn(null);
    when(edgeEntity2.getLabel()).thenReturn(null);
    when(edgeEntity2.getName()).thenReturn(null);
    when(edgeEntity2.getRoutingKey()).thenReturn(null);
    when(edgeEntity2.getSecret()).thenReturn(null);
    when(edgeEntity2.getType()).thenReturn(null);
    when(edgeEntity2.getCustomerId()).thenReturn(null);
    when(edgeEntity2.getRootRuleChainId()).thenReturn(null);
    when(edgeEntity2.getTenantId()).thenReturn(null);
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(edgeEntity2.getLabel()).thenReturn("Label");
    when(edgeEntity2.getName()).thenReturn("Name");
    when(edgeEntity2.getRoutingKey()).thenReturn("Routing Key");
    when(edgeEntity2.getSecret()).thenReturn("Secret");
    when(edgeEntity2.getType()).thenReturn("Type");
    when(edgeEntity2.getCustomerId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getRootRuleChainId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getVersion()).thenReturn(null);
    when(edgeEntity2.getId()).thenReturn(null);
    when(edgeEntity2.getCreatedTime()).thenReturn(0L);
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractEdgeEntity.setCustomerId(UUID)"})
  public void testSetCustomerId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    edgeEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = edgeEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, edgeEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setLabel(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setLabel(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractEdgeEntity.setRootRuleChainId(UUID)"})
  public void testSetRootRuleChainId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID rootRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    edgeEntity.setRootRuleChainId(rootRuleChainId);

    // Assert
    RuleChainId rootRuleChainId2 = edgeEntity.toData().getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    assertFalse(rootRuleChainId2.isNullUid());
    assertSame(rootRuleChainId, rootRuleChainId2.getId());
    assertSame(rootRuleChainId, edgeEntity.getRootRuleChainId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setRoutingKey(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setRoutingKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractEdgeEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    edgeEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = edgeEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, edgeEntity.getTenantId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractEdgeEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("EdgeEntity()", new EdgeEntity().toString());
  }
}
