package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class EdgeEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    EdgeEntity edgeEntity2 = new EdgeEntity();
    edgeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity2.setCreatedTime(1L);
    edgeEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setLabel("Label");
    edgeEntity2.setName("Name");
    edgeEntity2.setRootRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setRoutingKey("Routing Key");
    edgeEntity2.setSecret("Secret");
    edgeEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setType("Type");
    edgeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity2);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
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

    EdgeEntity edgeEntity2 = new EdgeEntity();
    edgeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity2.setCreatedTime(1L);
    edgeEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setLabel("Label");
    edgeEntity2.setName("Name");
    edgeEntity2.setRootRuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setRoutingKey("Routing Key");
    edgeEntity2.setSecret("Secret");
    edgeEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity2.setType("Type");
    edgeEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEntity.equals(Object)", "int EdgeEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeEntity.<init>()", "java.lang.String EdgeEntity.toString()"})
  void testGettersAndSetters() {
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
  @DisplayName("Test new EdgeEntity(Edge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
  void testNewEdgeEntity() {
    // Arrange
    Edge edge = new Edge(new Edge());
    edge.setTenantId(null);
    edge.setCustomerId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleChainId rootRuleChainId = new RuleChainId(id);
    edge.setRootRuleChainId(rootRuleChainId);

    // Act
    EdgeEntity actualEdgeEntity = new EdgeEntity(edge);

    // Assert
    UUID rootRuleChainId2 = actualEdgeEntity.getRootRuleChainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", rootRuleChainId2.toString());
    assertEquals(rootRuleChainId, actualEdgeEntity.toData().getRootRuleChainId());
    assertSame(id, rootRuleChainId2);
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
  @DisplayName(
      "Test new EdgeEntity(Edge); then return CustomerId toString is '13814000-1dd2-11b2-8080-808080808080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
  void testNewEdgeEntity_thenReturnCustomerIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Edge edge = new Edge(new Edge());
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
   *
   * <ul>
   *   <li>Then return TenantId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  @DisplayName(
      "Test new EdgeEntity(Edge); then return TenantId toString is '13814000-1dd2-11b2-8080-808080808080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
  void testNewEdgeEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Edge edge = new Edge(new Edge());
    edge.setTenantId(ModelConstants.SYSTEM_TENANT);
    edge.setCustomerId(null);
    edge.setRootRuleChainId(null);

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
   *   <li>Then toData AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#EdgeEntity(Edge)}
   */
  @Test
  @DisplayName("Test new EdgeEntity(Edge); when Edge(); then toData AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeEntity.<init>(Edge)"})
  void testNewEdgeEntity_whenEdge_thenToDataAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EdgeEntity actualEdgeEntity = new EdgeEntity(new Edge());

    // Assert
    assertTrue(actualEdgeEntity.toData().getAdditionalInfo() instanceof NullNode);
    assertNull(actualEdgeEntity.getAdditionalInfo());
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
  @DisplayName("Test toData(); given EdgeEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  void testToData_givenEdgeEntity_thenAdditionalInfoReturnNullNode() {
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
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setVersion(1L);
    edgeEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeEntity.setCustomerId(customerId);
    edgeEntity.setRootRuleChainId(null);

    // Act and Assert
    CustomerId customerId2 = edgeEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return RootRuleChainId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return RootRuleChainId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  void testToData_thenReturnRootRuleChainIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setVersion(1L);
    edgeEntity.setTenantId(null);
    edgeEntity.setCustomerId(null);
    UUID rootRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeEntity.setRootRuleChainId(rootRuleChainId);

    // Act and Assert
    RuleChainId rootRuleChainId2 = edgeEntity.toData().getRootRuleChainId();
    UUID id = rootRuleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    assertFalse(rootRuleChainId2.isNullUid());
    assertSame(rootRuleChainId, id);
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return RootRuleChainId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return RootRuleChainId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  void testToData_thenReturnRootRuleChainIdIdToStringIs784f394c42b6435a983cB7beff2784f92() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setVersion(1L);
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setCustomerId(null);
    UUID rootRuleChainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    edgeEntity.setRootRuleChainId(rootRuleChainId);

    // Act
    Edge actualToDataResult = edgeEntity.toData();

    // Assert
    RuleChainId rootRuleChainId2 = actualToDataResult.getRootRuleChainId();
    UUID id = rootRuleChainId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(rootRuleChainId2.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(rootRuleChainId, id);
  }

  /**
   * Test {@link EdgeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Edge EdgeEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setType("Type");
    edgeEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setVersion(1L);
    edgeEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(null);

    // Act and Assert
    TenantId tenantId = edgeEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
