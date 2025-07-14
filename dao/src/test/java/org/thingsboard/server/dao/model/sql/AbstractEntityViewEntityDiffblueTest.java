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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setExternalId(externalId);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityViewId externalId2 = entityViewEntity.toEntityView().getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ENTITY_VIEW, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView2() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setExternalId(externalId);
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(buildResult.writeValueAsString(telemetryEntityView));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    EntityViewId externalId2 = actualToEntityViewResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ENTITY_VIEW, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(telemetryEntityView, actualToEntityViewResult.getKeys());
    assertSame(externalId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView3() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setCustomerId(customerId);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    CustomerId customerId2 = entityViewEntity.toEntityView().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView4() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(null));

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertNull(actualToEntityViewResult.getKeys());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.USER);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof UserId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is {@code 42}.
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName(
      "Test toEntityView(); given EntityViewEntity() Keys is '42'; then return ExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityKeysIs42_thenReturnExternalIdIsNull() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("42");

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertNull(actualToEntityViewResult.getKeys());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityKeysIsEmptyString() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("");

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertNull(actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is {@code foo}.
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName(
      "Test toEntityView(); given EntityViewEntity() Keys is 'foo'; then return ExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntityKeysIsFoo_thenReturnExternalIdIsNull() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("foo");

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertNull(actualToEntityViewResult.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()}.
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); given EntityViewEntity(); then return ExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_givenEntityViewEntity_thenReturnExternalIdIsNull() {
    // Arrange and Act
    EntityView actualToEntityViewResult = new EntityViewEntity().toEntityView();

    // Assert
    assertNull(actualToEntityViewResult.getEntityId());
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
  @Tag("MaintainedByDiffblue")
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
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(additionalInfo.isNull());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(iteratorResult.hasNext());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnAlarmId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.ALARM);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ALARM, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnAssetId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.ASSET);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnCustomerId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.CUSTOMER);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof CustomerId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnDashboardId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DASHBOARD);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnDeviceId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DEVICE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof DeviceId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return RuleChainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnRuleChainId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.RULE_CHAIN);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof RuleChainId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_CHAIN, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return RuleNodeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnRuleNodeId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.RULE_NODE);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId2 instanceof RuleNodeId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.RULE_NODE, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then EntityId return TenantId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenEntityIdReturnTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(entityId.isNullUid());
    assertFalse(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then return Keys is {@link TelemetryEntityView#TelemetryEntityView()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then return Keys is TelemetryEntityView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenReturnKeysIsTelemetryEntityView() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    entityViewEntity.setKeys(buildResult.writeValueAsString(telemetryEntityView));

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
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName("Test toEntityView(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    UUID tenantId = UUID.randomUUID();
    entityViewEntity.setTenantId(tenantId);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("foo");

    // Act and Assert
    TenantId tenantId2 = entityViewEntity.toEntityView().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  @DisplayName(
      "Test toEntityView(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView AbstractEntityViewEntity.toEntityView()"})
  void testToEntityView_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity2);
    int notExpectedHashCodeResult = entityViewEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, entityViewEntity2.hashCode());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
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
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(1L);
    when(entityViewEntity2.getStartTs()).thenReturn(1L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(1L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn("foo");
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn("foo");
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn("foo");
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setType("Type");
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setName("Name");
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setKeys("Keys");
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenReturn(null);
    when(entityViewEntity2.getKeys()).thenReturn(null);
    when(entityViewEntity2.getName()).thenReturn(null);
    when(entityViewEntity2.getType()).thenReturn(null);
    when(entityViewEntity2.getCustomerId()).thenReturn(null);
    when(entityViewEntity2.getEntityId()).thenReturn(null);
    when(entityViewEntity2.getExternalId()).thenReturn(null);
    when(entityViewEntity2.getTenantId()).thenReturn(null);
    when(entityViewEntity2.getEntityType()).thenReturn(null);
    when(entityViewEntity2.getEndTs()).thenReturn(0L);
    when(entityViewEntity2.getStartTs()).thenReturn(0L);
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractEntityViewEntity.equals(Object)",
    "int AbstractEntityViewEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getAdditionalInfo()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getKeys()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getName()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getType()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getCustomerId()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getEntityId()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getExternalId()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getTenantId()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getEndTs()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getStartTs()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    when(entityViewEntity2.getVersion()).thenReturn(null);
    when(entityViewEntity2.getId()).thenReturn(null);
    when(entityViewEntity2.getCreatedTime()).thenReturn(0L);
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEntityViewEntity.setTenantId(UUID)"})
  void testSetTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    entityViewEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = entityViewEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId2.getId().toString());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractEntityViewEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityViewEntity()", new EntityViewEntity().toString());
  }
}
