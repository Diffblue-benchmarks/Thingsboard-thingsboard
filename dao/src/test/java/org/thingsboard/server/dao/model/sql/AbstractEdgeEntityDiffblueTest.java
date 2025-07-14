package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractEdgeEntityDiffblueTest {
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
  @DisplayName(
      "Test toEdge(); given EdgeEntity() TenantId is randomUUID; then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  void testToEdge_givenEdgeEntityTenantIdIsRandomUUID_thenReturnTenantIdIdIsRandomUUID() {
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
  @DisplayName("Test toEdge(); given EdgeEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  void testToEdge_givenEdgeEntity_thenAdditionalInfoReturnNullNode() {
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
  @DisplayName(
      "Test toEdge(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  void testToEdge_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @DisplayName(
      "Test toEdge(); then return RootRuleChainId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  void testToEdge_thenReturnRootRuleChainIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @DisplayName(
      "Test toEdge(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge AbstractEdgeEntity.toEdge()"})
  void testToEdge_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @DisplayName("Test canEqual(Object); when EdgeEntity(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractEdgeEntity.canEqual(Object)"})
  void testCanEqual_whenEdgeEntity_thenReturnTrue() {
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
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractEdgeEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), "Different type to AbstractEdgeEntity");
  }

  /**
   * Test {@link AbstractEdgeEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode AbstractEdgeEntity.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEdgeEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getCustomerId()}
   */
  @Test
  @DisplayName("Test getCustomerId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractEdgeEntity.getCustomerId()"})
  void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getLabel()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractEdgeEntity.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getLabel());
  }

  /**
   * Test {@link AbstractEdgeEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractEdgeEntity.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getName());
  }

  /**
   * Test {@link AbstractEdgeEntity#getRootRuleChainId()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getRootRuleChainId()}
   */
  @Test
  @DisplayName("Test getRootRuleChainId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractEdgeEntity.getRootRuleChainId()"})
  void testGetRootRuleChainId() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getRootRuleChainId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getRoutingKey()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getRoutingKey()}
   */
  @Test
  @DisplayName("Test getRoutingKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractEdgeEntity.getRoutingKey()"})
  void testGetRoutingKey() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getRoutingKey());
  }

  /**
   * Test {@link AbstractEdgeEntity#getSecret()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getSecret()}
   */
  @Test
  @DisplayName("Test getSecret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractEdgeEntity.getSecret()"})
  void testGetSecret() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getSecret());
  }

  /**
   * Test {@link AbstractEdgeEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractEdgeEntity.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getTenantId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractEdgeEntity.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertNull(new EdgeEntity().getType());
  }

  /**
   * Test {@link AbstractEdgeEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractEdgeEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo() {
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
  @DisplayName("Test setCustomerId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setCustomerId(UUID)"})
  void testSetCustomerId() {
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
  @DisplayName("Test setLabel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setLabel(String)"})
  void testSetLabel() {
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
  @DisplayName("Test setName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setName(String)"})
  void testSetName() {
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
  @DisplayName("Test setRootRuleChainId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setRootRuleChainId(UUID)"})
  void testSetRootRuleChainId() {
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
  @DisplayName("Test setRoutingKey(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setRoutingKey(String)"})
  void testSetRoutingKey() {
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
  @DisplayName("Test setSecret(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setSecret(String)"})
  void testSetSecret() {
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
  @DisplayName("Test setTenantId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setTenantId(UUID)"})
  void testSetTenantId() {
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
  @DisplayName("Test setType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEdgeEntity.setType(String)"})
  void testSetType() {
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
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractEdgeEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EdgeEntity()", new EdgeEntity().toString());
  }
}
