package org.thingsboard.server.service.edge.rpc.constructor.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EntityDataProto;

class EntityDataMsgConstructorDiffblueTest {
  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given end of transmission.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given end of transmission")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_givenEndOfTransmission() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonArray entityData = new JsonArray(3);
    entityData.add('\u0004');

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED,
        entityData);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when JsonNull (default constructor); then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_givenTenant_whenJsonNull_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED,
        new JsonNull());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when JsonObject (default constructor); then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_givenTenant_whenJsonObject_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED,
        new JsonObject());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when 'null'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_givenTenant_whenNull_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, null);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>When {@code POST_ATTRIBUTES}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when 'POST_ATTRIBUTES'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_givenTenant_whenPostAttributes_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.POST_ATTRIBUTES,
        new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonArray entityData = new JsonArray(3);
    entityData.add(true);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED,
        entityData);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Then return EntityType is {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); then return EntityType is 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_thenReturnEntityTypeIsAlarm() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.ADDED, new JsonArray(3));

    // Assert
    assertEquals("ALARM", actualConstructEntityDataMsgResult.getEntityType());
    assertEquals(28, actualConstructEntityDataMsgResult.getSerializedSize());
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code ATTRIBUTES_DELETED}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_DELETED'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_whenAttributesDeleted_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.ATTRIBUTES_DELETED,
        new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code ATTRIBUTES_UPDATED}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_UPDATED'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_whenAttributesUpdated_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.ATTRIBUTES_UPDATED,
        new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_whenJsonArrayWithCapacityIsThree() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED,
        new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_whenJsonPrimitiveWithBoolIsTrue() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED,
        new JsonPrimitive(true));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonPrimitive(String) with 'String'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"})
  void testConstructEntityDataMsg_whenJsonPrimitiveWithString_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED,
        new JsonPrimitive("String"));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }
}
