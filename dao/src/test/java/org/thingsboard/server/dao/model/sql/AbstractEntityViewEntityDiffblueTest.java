package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractEntityViewEntityDiffblueTest {
  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setKeys(
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(null));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    EntityId entityId = actualToEntityViewResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualToEntityViewResult.getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode additionalInfo = new ArrayNode(nf);
    entityViewEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    assertSame(additionalInfo, entityViewEntity.toEntityView().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityId is {@code null}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName(
      "Test toEntityView(); given EntityViewEntity() EntityId is 'null'; then return EntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityEntityIdIsNull_thenReturnEntityIdIsNull()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(telemetryEntityView));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getEntityId());
    assertEquals(telemetryEntityView, actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityType is {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName(
      "Test toEntityView(); given EntityViewEntity() EntityType is 'USER'; then EntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityEntityTypeIsUser_thenEntityIdReturnUserId()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.USER);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof UserId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); given EntityViewEntity() ExternalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityExternalIdIsNull() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(null);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(telemetryEntityView));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getExternalId());
    assertEquals(telemetryEntityView, actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); given EntityViewEntity() Keys is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityKeysIs42() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setKeys("42");

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); given EntityViewEntity() Keys is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityKeysIsEmptyString() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setKeys("");

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); given EntityViewEntity() Keys is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityKeysIsFoo() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setKeys("foo");

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); given EntityViewEntity(); then return CustomerId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntity_thenReturnCustomerIdIsNull() {
    // Arrange and Act
    EntityView actualToEntityViewResult = new EntityViewEntity().toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getCustomerId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertNull(actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then AdditionalInfo iterator next return BooleanNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenAdditionalInfoIteratorNextReturnBooleanNode() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    JsonNode additionalInfo = entityViewEntity.toEntityView().getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ArrayNode}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then AdditionalInfo return ArrayNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenAdditionalInfoReturnArrayNode() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode additionalInfo = new ArrayNode(nf);
    additionalInfo.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    JsonNode additionalInfo2 = entityViewEntity.toEntityView().getAdditionalInfo();
    assertTrue(additionalInfo2 instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = additionalInfo2.elements();
    JsonNode nextResult = elementsResult.next();
    assertFalse(elementsResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertFalse(additionalInfo2.isEmpty());
    Iterator<JsonNode> iteratorResult = additionalInfo2.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(nextResult, actualNextResult);
    assertEquals(1, additionalInfo2.size());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnAssetId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.ASSET);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnCustomerId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.CUSTOMER);
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(telemetryEntityView));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertTrue(actualToEntityViewResult.getEntityId() instanceof CustomerId);
    assertEquals(telemetryEntityView, actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnDashboardId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DASHBOARD);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnDeviceId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DEVICE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then return AdditionalInfo is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenReturnAdditionalInfoIsValueOfTen() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    DoubleNode additionalInfo = DoubleNode.valueOf(10.0d);
    entityViewEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    assertSame(additionalInfo, entityViewEntity.toEntityView().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then return EntityId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then return EntityId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenReturnEntityIdIdIsRandomUUID() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then return TenantId is EntityId.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then return TenantId is EntityId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenReturnTenantIdIsEntityId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    EntityId entityId = actualToEntityViewResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualToEntityViewResult.getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link EntityViewEntity#EntityViewEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when EntityViewEntity(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractEntityViewEntity.canEqual(Object)"})
  void testCanEqual_whenEntityViewEntity_thenReturnTrue() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act and Assert
    assertTrue(entityViewEntity.canEqual(new EntityViewEntity()));
  }

  /**
   * Test {@link AbstractEntityViewEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractEntityViewEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityViewEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}, and {@link
   * AbstractEntityViewEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = new EntityViewEntity();

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity2);
    assertEquals(entityViewEntity.hashCode(), entityViewEntity2.hashCode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}, and {@link
   * AbstractEntityViewEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity);
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity.hashCode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

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
    assertNotEquals(entityViewEntity, assetEntity);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getVersion()).thenReturn(1L);
    when(entityViewEntity2.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityViewEntity2.getCreatedTime()).thenReturn(1L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getVersion()).thenThrow(new IllegalArgumentException());
    when(entityViewEntity2.getId()).thenThrow(new IllegalArgumentException());
    when(entityViewEntity2.getCreatedTime()).thenThrow(new IllegalArgumentException());
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityViewEntity.equals(entityViewEntity2));
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewEntity(), null);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewEntity(), "Different type to AbstractEntityViewEntity");
  }

  /**
   * Test {@link AbstractEntityViewEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractEntityViewEntity.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getCustomerId()}
   */
  @Test
  @DisplayName("Test getCustomerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getCustomerId()"})
  void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEndTs()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getEndTs()}
   */
  @Test
  @DisplayName("Test getEndTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractEntityViewEntity.getEndTs()"})
  void testGetEndTs() {
    // Arrange, Act and Assert
    assertEquals(0L, new EntityViewEntity().getEndTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEntityId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getEntityId()"})
  void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getEntityId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEntityType()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType AbstractEntityViewEntity.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getEntityType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getExternalId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getExternalId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getKeys()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getKeys()}
   */
  @Test
  @DisplayName("Test getKeys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.getKeys()"})
  void testGetKeys() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getName());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getStartTs()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getStartTs()}
   */
  @Test
  @DisplayName("Test getStartTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractEntityViewEntity.getStartTs()"})
  void testGetStartTs() {
    // Arrange, Act and Assert
    assertEquals(0L, new EntityViewEntity().getStartTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractEntityViewEntity.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertNull(new EntityViewEntity().getType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    entityViewEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, entityViewEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, entityViewEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setCustomerId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setCustomerId(UUID)}
   */
  @Test
  @DisplayName("Test setCustomerId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setCustomerId(UUID)"})
  void testSetCustomerId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    entityViewEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = entityViewEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, entityViewEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEndTs(long)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setEndTs(long)}
   */
  @Test
  @DisplayName("Test setEndTs(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setEndTs(long)"})
  void testSetEndTs() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setEndTs(1L);

    // Assert
    assertEquals(1L, entityViewEntity.toData().getEndTimeMs());
    assertEquals(1L, entityViewEntity.getEndTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEntityId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setEntityId(UUID)}
   */
  @Test
  @DisplayName("Test setEntityId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setEntityId(UUID)"})
  void testSetEntityId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    entityViewEntity.setEntityId(entityId);

    // Assert
    assertSame(entityId, entityViewEntity.getEntityId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEntityType(EntityType)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test setEntityType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setEntityType(EntityType)"})
  void testSetEntityType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setEntityType(EntityType.TENANT);

    // Assert
    assertEquals(EntityType.TENANT, entityViewEntity.getEntityType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setExternalId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setExternalId(UUID)}
   */
  @Test
  @DisplayName("Test setExternalId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setExternalId(UUID)"})
  void testSetExternalId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    entityViewEntity.setExternalId(externalId);

    // Assert
    EntityViewId externalId2 = entityViewEntity.toData().getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, entityViewEntity.getExternalId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setKeys(String)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setKeys(String)}
   */
  @Test
  @DisplayName("Test setKeys(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setKeys(String)"})
  void testSetKeys() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setKeys("Keys");

    // Assert
    assertEquals("Keys", entityViewEntity.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setName(String)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setName(String)"})
  void testSetName() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setName("Name");

    // Assert
    assertEquals("Name", entityViewEntity.toData().getName());
    assertEquals("Name", entityViewEntity.getName());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setStartTs(long)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setStartTs(long)}
   */
  @Test
  @DisplayName("Test setStartTs(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setStartTs(long)"})
  void testSetStartTs() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setStartTs(1L);

    // Assert
    assertEquals(1L, entityViewEntity.toData().getStartTimeMs());
    assertEquals(1L, entityViewEntity.getStartTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setTenantId(UUID)}
   */
  @Test
  @DisplayName("Test setTenantId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setTenantId(UUID)"})
  void testSetTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    entityViewEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = entityViewEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, entityViewEntity.getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractEntityViewEntity.setType(String)"})
  void testSetType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setType("Type");

    // Assert
    assertEquals("Type", entityViewEntity.toData().getType());
    assertEquals("Type", entityViewEntity.getType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractEntityViewEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityViewEntity()", new EntityViewEntity().toString());
  }
}
