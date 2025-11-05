package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class EdgeInfoEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();

    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setType("Type");
    edgeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeInfoEntity.<init>()",
    "String EdgeInfoEntity.getCustomerTitle()",
    "boolean EdgeInfoEntity.isCustomerIsPublic()",
    "void EdgeInfoEntity.setCustomerIsPublic(boolean)",
    "void EdgeInfoEntity.setCustomerTitle(String)",
    "String EdgeInfoEntity.toString()"
  })
  void testGettersAndSetters() {
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
   * <ul>
   *   <li>Then return toData CustomerIsPublic.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new EdgeInfoEntity(EdgeEntity, String, Object); then return toData CustomerIsPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeInfoEntity.<init>(EdgeEntity, String, Object)"})
  void testNewEdgeInfoEntity_thenReturnToDataCustomerIsPublic() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setType("Type");
    edgeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setVersion(1L);
    JsonNode jsonNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity(edgeEntity, "Dr", jsonNode);

    // Assert
    JsonNode additionalInfo = actualEdgeInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    EdgeInfo toDataResult = actualEdgeInfoEntity.toData();
    assertTrue(toDataResult.isCustomerIsPublic());
    assertTrue(actualEdgeInfoEntity.isCustomerIsPublic());
    assertSame(jsonNode, toDataResult.getAdditionalInfo());
    assertSame(jsonNode, additionalInfo);
  }

  /**
   * Test {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not toData CustomerIsPublic.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#EdgeInfoEntity(EdgeEntity, String, Object)}
   */
  @Test
  @DisplayName(
      "Test new EdgeInfoEntity(EdgeEntity, String, Object); when 'null'; then return not toData CustomerIsPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeInfoEntity.<init>(EdgeEntity, String, Object)"})
  void testNewEdgeInfoEntity_whenNull_thenReturnNotToDataCustomerIsPublic() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setType("Type");
    edgeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setVersion(1L);

    // Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity(edgeEntity, "Dr", null);

    // Assert
    JsonNode additionalInfo = actualEdgeInfoEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    EdgeInfo toDataResult = actualEdgeInfoEntity.toData();
    assertFalse(toDataResult.isCustomerIsPublic());
    assertFalse(actualEdgeInfoEntity.isCustomerIsPublic());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
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
  @DisplayName("Test toData(); given EdgeInfoEntity(); then AdditionalInfo return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  void testToData_givenEdgeInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EdgeInfo actualToDataResult = new EdgeInfoEntity().toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
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
   *
   * <ul>
   *   <li>Then return AdditionalInfo is Instance.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return AdditionalInfo is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  void testToData_thenReturnAdditionalInfoIsInstance() {
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
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeInfoEntity.setCustomerId(customerId);

    // Act and Assert
    CustomerId customerId2 = edgeInfoEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return RootRuleChainId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return RootRuleChainId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  void testToData_thenReturnRootRuleChainIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    UUID rootRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeInfoEntity.setRootRuleChainId(rootRuleChainId);

    // Act and Assert
    RuleChainId rootRuleChainId2 = edgeInfoEntity.toData().getRootRuleChainId();
    UUID id = rootRuleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    assertFalse(rootRuleChainId2.isNullUid());
    assertSame(rootRuleChainId, id);
  }

  /**
   * Test {@link EdgeInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
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
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeInfoEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = edgeInfoEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
