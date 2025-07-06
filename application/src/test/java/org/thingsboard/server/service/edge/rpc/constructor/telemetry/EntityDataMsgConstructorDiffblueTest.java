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
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("[{}][{}] Can't convert to telemetry proto, entityData [{}]", new JsonArray(3));
    jsonObject.add("ts", new JsonArray(3));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg2() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("scope", new JsonArray(3));
    jsonObject.add("ts", mock(JsonElement.class));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.ATTRIBUTES_DELETED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given end of transmission.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given end of transmission")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
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
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code scope} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'scope' and '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyScopeAnd42() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("scope", "42");
    jsonObject.add("ts", mock(JsonElement.class));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.ATTRIBUTES_DELETED, entityData);

    // Assert
    verify(entityData, atLeast(1)).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code scope} and valueOf two.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'scope' and valueOf two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyScopeAndValueOfTwo() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("scope", Integer.valueOf(2));
    jsonObject.add("ts", mock(JsonElement.class));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult =
        entityDataMsgConstructor.constructEntityDataMsg(
            tenantId, entityId, EdgeEventActionType.ATTRIBUTES_DELETED, entityData);

    // Assert
    verify(entityData, atLeast(1)).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    assertEquals(
        2,
        actualConstructEntityDataMsgResult
            .getAttributeDeleteMsg()
            .getDescriptorForType()
            .getFields()
            .size());
    assertEquals(
        2,
        actualConstructEntityDataMsgResult
            .getAttributesUpdatedMsg()
            .getDescriptorForType()
            .getFields()
            .size());
    assertEquals(8, actualConstructEntityDataMsgResult.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'ts' and '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyTsAnd42() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", "42");
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'ts' and 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyTsAndTrue() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", true);
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and valueOf two.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'ts' and valueOf two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyTsAndValueOfTwo() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", Integer.valueOf(2));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult =
        entityDataMsgConstructor.constructEntityDataMsg(
            tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    assertEquals(
        2,
        actualConstructEntityDataMsgResult
            .getAttributeDeleteMsg()
            .getDescriptorForType()
            .getFields()
            .size());
    assertEquals(
        2,
        actualConstructEntityDataMsgResult
            .getAttributesUpdatedMsg()
            .getDescriptorForType()
            .getFields()
            .size());
    assertEquals(8, actualConstructEntityDataMsgResult.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code ts} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) add 'ts' and JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObjectAddTsAndJsonArrayWithCapacityIsThree() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray(3));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code ts} and {@code null}.
   *   <li>Then calls {@link JsonElement#getAsJsonObject()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) add 'ts' and 'null'; then calls getAsJsonObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObjectAddTsAndNull_thenCallsGetAsJsonObject() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", null);
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   *   <li>Then calls {@link JsonElement#getAsJsonObject()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor); then calls getAsJsonObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenJsonObject_thenCallsGetAsJsonObject() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(new JsonObject());

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link JsonElement} {@link JsonElement#getAsJsonObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'null'; when JsonElement getAsJsonObject() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenNull_whenJsonElementGetAsJsonObjectReturnNull() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(null);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when JsonNull (default constructor); then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenTenant_whenJsonNull_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonNull());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when JsonObject (default constructor); then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenTenant_whenJsonObject_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonObject());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when 'null'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenTenant_whenNull_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, null);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@code POST_ATTRIBUTES}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'TENANT'; when 'POST_ATTRIBUTES'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenTenant_whenPostAttributes_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.POST_ATTRIBUTES, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
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
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Given valueOf two.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given valueOf two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_givenValueOfTwo() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonArray entityData = new JsonArray(3);
    entityData.add(Integer.valueOf(2));

    // Act
    EntityDataProto actualConstructEntityDataMsgResult =
        entityDataMsgConstructor.constructEntityDataMsg(
            tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    assertEquals(
        2,
        actualConstructEntityDataMsgResult
            .getAttributeDeleteMsg()
            .getDescriptorForType()
            .getFields()
            .size());
    assertEquals(
        2,
        actualConstructEntityDataMsgResult
            .getAttributesUpdatedMsg()
            .getDescriptorForType()
            .getFields()
            .size());
    assertEquals(8, actualConstructEntityDataMsgResult.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonElement#isJsonNull()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); then calls isJsonNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_thenCallsIsJsonNull() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    JsonElement value = mock(JsonElement.class);
    when(value.isJsonNull()).thenReturn(false);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", value);
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(value).isJsonNull();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>Then return EntityType is {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); then return EntityType is 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_thenReturnEntityTypeIsAlarm() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntityDataProto actualConstructEntityDataMsgResult =
        entityDataMsgConstructor.constructEntityDataMsg(
            tenantId, entityId, EdgeEventActionType.ADDED, new JsonArray(3));

    // Assert
    assertEquals("ALARM", actualConstructEntityDataMsgResult.getEntityType());
    assertEquals(28, actualConstructEntityDataMsgResult.getSerializedSize());
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@code ATTRIBUTES_DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_DELETED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenAttributesDeleted() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", mock(JsonElement.class));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.ATTRIBUTES_DELETED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@code ATTRIBUTES_DELETED}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_DELETED'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenAttributesDeleted_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.ATTRIBUTES_DELETED, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@code ATTRIBUTES_UPDATED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_UPDATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenAttributesUpdated() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", mock(JsonElement.class));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.ATTRIBUTES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@code ATTRIBUTES_UPDATED}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_UPDATED'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenAttributesUpdated_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.ATTRIBUTES_UPDATED, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenJsonArrayWithCapacityIsThree() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenJsonPrimitiveWithBoolIsTrue() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonPrimitive(true));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonPrimitive(String) with 'String'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenJsonPrimitiveWithString_thenCallsGetEntityType() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonPrimitive("String"));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId,
   * EdgeEventActionType, JsonElement)}.
   *
   * <ul>
   *   <li>When {@code POST_ATTRIBUTES}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId,
   * EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'POST_ATTRIBUTES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataProto EntityDataMsgConstructor.constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)"
  })
  void testConstructEntityDataMsg_whenPostAttributes() {
    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray(3));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    entityDataMsgConstructor.constructEntityDataMsg(
        tenantId, entityId, EdgeEventActionType.POST_ATTRIBUTES, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }
}
