package org.thingsboard.server.service.edge.rpc.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;
import org.thingsboard.server.service.edge.rpc.processor.alarm.AlarmEdgeProcessorV1;

class BaseEdgeProcessorDiffblueTest {
  /**
   * Test {@link BaseEdgeProcessor#handleUnsupportedMsgType(UpdateMsgType)}.
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#handleUnsupportedMsgType(UpdateMsgType)}
   */
  @Test
  @DisplayName("Test handleUnsupportedMsgType(UpdateMsgType)")
  void testHandleUnsupportedMsgType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(
        (new AlarmEdgeProcessorV1()).handleUnsupportedMsgType(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE).isDone());
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   * <ul>
   *   <li>When {@code ADDED}.</li>
   *   <li>Then return {@code ENTITY_CREATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName("Test getUpdateMsgType(EdgeEventActionType); when 'ADDED'; then return 'ENTITY_CREATED_RPC_MESSAGE'")
  void testGetUpdateMsgType_whenAdded_thenReturnEntityCreatedRpcMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        (new AlarmEdgeProcessorV1()).getUpdateMsgType(EdgeEventActionType.ADDED));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   * <ul>
   *   <li>When {@code ALARM_ACK}.</li>
   *   <li>Then return {@code ALARM_ACK_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName("Test getUpdateMsgType(EdgeEventActionType); when 'ALARM_ACK'; then return 'ALARM_ACK_RPC_MESSAGE'")
  void testGetUpdateMsgType_whenAlarmAck_thenReturnAlarmAckRpcMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ALARM_ACK_RPC_MESSAGE,
        (new AlarmEdgeProcessorV1()).getUpdateMsgType(EdgeEventActionType.ALARM_ACK));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   * <ul>
   *   <li>When {@code ALARM_ASSIGNED}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName("Test getUpdateMsgType(EdgeEventActionType); when 'ALARM_ASSIGNED'; then throw RuntimeException")
  void testGetUpdateMsgType_whenAlarmAssigned_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new AlarmEdgeProcessorV1()).getUpdateMsgType(EdgeEventActionType.ALARM_ASSIGNED));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   * <ul>
   *   <li>When {@code ALARM_CLEAR}.</li>
   *   <li>Then return {@code ALARM_CLEAR_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName("Test getUpdateMsgType(EdgeEventActionType); when 'ALARM_CLEAR'; then return 'ALARM_CLEAR_RPC_MESSAGE'")
  void testGetUpdateMsgType_whenAlarmClear_thenReturnAlarmClearRpcMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE,
        (new AlarmEdgeProcessorV1()).getUpdateMsgType(EdgeEventActionType.ALARM_CLEAR));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   * <ul>
   *   <li>When {@code DELETED}.</li>
   *   <li>Then return {@code ENTITY_DELETED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName("Test getUpdateMsgType(EdgeEventActionType); when 'DELETED'; then return 'ENTITY_DELETED_RPC_MESSAGE'")
  void testGetUpdateMsgType_whenDeleted_thenReturnEntityDeletedRpcMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        (new AlarmEdgeProcessorV1()).getUpdateMsgType(EdgeEventActionType.DELETED));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   * <ul>
   *   <li>When {@code UPDATED_COMMENT}.</li>
   *   <li>Then return {@code ENTITY_UPDATED_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName("Test getUpdateMsgType(EdgeEventActionType); when 'UPDATED_COMMENT'; then return 'ENTITY_UPDATED_RPC_MESSAGE'")
  void testGetUpdateMsgType_whenUpdatedComment_thenReturnEntityUpdatedRpcMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        (new AlarmEdgeProcessorV1()).getUpdateMsgType(EdgeEventActionType.UPDATED_COMMENT));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Id toString is
   * {@code 00000000-0000-0001-0000-000000000001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetEdgeId(long, long); when one; then return Id toString is '00000000-0000-0001-0000-000000000001'")
  void testSafeGetEdgeId_whenOne_thenReturnIdToStringIs00000000000000010000000000000001() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EdgeId actualSafeGetEdgeIdResult = (new AlarmEdgeProcessorV1()).safeGetEdgeId(1L, 1L);

    // Assert
    assertEquals("00000000-0000-0001-0000-000000000001", actualSafeGetEdgeIdResult.getId().toString());
    assertEquals(EntityType.EDGE, actualSafeGetEdgeIdResult.getEntityType());
    assertFalse(actualSafeGetEdgeIdResult.isNullUid());
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetEdgeId(long, long); when one; then return 'null'")
  void testSafeGetEdgeId_whenOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorV1()).safeGetEdgeId(1L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetEdgeId(long, long); when zero; then return 'null'")
  void testSafeGetEdgeId_whenZero_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorV1()).safeGetEdgeId(0L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetUUID(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetUUID(long, long)}
   */
  @Test
  @DisplayName("Test safeGetUUID(long, long); when one; then return 'null'")
  void testSafeGetUUID_whenOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorV1()).safeGetUUID(1L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetUUID(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return toString is
   * {@code 00000000-0000-0001-0000-000000000001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetUUID(long, long)}
   */
  @Test
  @DisplayName("Test safeGetUUID(long, long); when one; then return toString is '00000000-0000-0001-0000-000000000001'")
  void testSafeGetUUID_whenOne_thenReturnToStringIs00000000000000010000000000000001() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("00000000-0000-0001-0000-000000000001", (new AlarmEdgeProcessorV1()).safeGetUUID(1L, 1L).toString());
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetUUID(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetUUID(long, long)}
   */
  @Test
  @DisplayName("Test safeGetUUID(long, long); when zero; then return 'null'")
  void testSafeGetUUID_whenZero_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorV1()).safeGetUUID(0L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}.
   * <ul>
   *   <li>Then return Id toString is
   * {@code 00000000-0000-0001-0000-000000000001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetCustomerId(long, long); then return Id toString is '00000000-0000-0001-0000-000000000001'")
  void testSafeGetCustomerId_thenReturnIdToStringIs00000000000000010000000000000001() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CustomerId actualSafeGetCustomerIdResult = (new AlarmEdgeProcessorV1()).safeGetCustomerId(1L, 1L);

    // Assert
    assertEquals("00000000-0000-0001-0000-000000000001", actualSafeGetCustomerIdResult.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualSafeGetCustomerIdResult.getEntityType());
    assertFalse(actualSafeGetCustomerIdResult.isNullUid());
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetCustomerId(long, long); when one; then return 'null'")
  void testSafeGetCustomerId_whenOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorV1()).safeGetCustomerId(1L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetCustomerId(long, long); when zero; then return 'null'")
  void testSafeGetCustomerId_whenZero_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmEdgeProcessorV1()).safeGetCustomerId(0L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#isEntityExists(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#isEntityExists(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test isEntityExists(TenantId, EntityId); when AlarmId(UUID) with id is randomUUID; then return 'false'")
  void testIsEntityExists_whenAlarmIdWithIdIsRandomUUID_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertFalse(alarmEdgeProcessorV1.isEntityExists(tenantId, new AlarmId(UUID.randomUUID())));
  }

  /**
   * Test {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return Data {@code edgeName} is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}
   */
  @Test
  @DisplayName("Test getEdgeActionTbMsgMetaData(Edge, CustomerId); given 'Name'; then return Data 'edgeName' is 'Name'")
  void testGetEdgeActionTbMsgMetaData_givenName_thenReturnDataEdgeNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn("Name");
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act
    TbMsgMetaData actualEdgeActionTbMsgMetaData = alarmEdgeProcessorV1.getEdgeActionTbMsgMetaData(edge, null);

    // Assert
    verify(edge).getId();
    verify(edge).getName();
    Map<String, String> data = actualEdgeActionTbMsgMetaData.getData();
    assertEquals(2, data.size());
    assertEquals("Name", data.get("edgeName"));
    assertTrue(data.containsKey("edgeId"));
  }

  /**
   * Test {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return Data size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}
   */
  @Test
  @DisplayName("Test getEdgeActionTbMsgMetaData(Edge, CustomerId); given 'Name'; then return Data size is three")
  void testGetEdgeActionTbMsgMetaData_givenName_thenReturnDataSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn("Name");
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act
    TbMsgMetaData actualEdgeActionTbMsgMetaData = alarmEdgeProcessorV1.getEdgeActionTbMsgMetaData(edge,
        new CustomerId(UUID.randomUUID()));

    // Assert
    verify(edge).getId();
    verify(edge).getName();
    Map<String, String> data = actualEdgeActionTbMsgMetaData.getData();
    assertEquals(3, data.size());
    assertTrue(data.containsKey("customerId"));
    assertTrue(data.containsKey("edgeId"));
    assertTrue(data.containsKey("edgeName"));
  }

  /**
   * Test {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}
   */
  @Test
  @DisplayName("Test getEdgeActionTbMsgMetaData(Edge, CustomerId); then throw RuntimeException")
  void testGetEdgeActionTbMsgMetaData_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenThrow(new RuntimeException("edgeId"));
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> alarmEdgeProcessorV1.getEdgeActionTbMsgMetaData(edge, new CustomerId(UUID.randomUUID())));
    verify(edge).getId();
    verify(edge).getName();
  }

  /**
   * Test {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}.
   * <ul>
   *   <li>When {@link Edge} {@link Edge#getName()} return {@code null}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}
   */
  @Test
  @DisplayName("Test getEdgeActionTbMsgMetaData(Edge, CustomerId); when Edge getName() return 'null'; then return Data size is two")
  void testGetEdgeActionTbMsgMetaData_whenEdgeGetNameReturnNull_thenReturnDataSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn(null);
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act
    TbMsgMetaData actualEdgeActionTbMsgMetaData = alarmEdgeProcessorV1.getEdgeActionTbMsgMetaData(edge,
        new CustomerId(UUID.randomUUID()));

    // Assert
    verify(edge).getId();
    verify(edge).getName();
    Map<String, String> data = actualEdgeActionTbMsgMetaData.getData();
    assertEquals(2, data.size());
    assertTrue(data.containsKey("customerId"));
    assertTrue(data.containsKey("edgeId"));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#pushEntityEventToRuleEngine(TenantId, EntityId, CustomerId, TbMsgType, String, TbMsgMetaData)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#pushEntityEventToRuleEngine(TenantId, EntityId, CustomerId, TbMsgType, String, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test pushEntityEventToRuleEngine(TenantId, EntityId, CustomerId, TbMsgType, String, TbMsgMetaData); then throw RuntimeException")
  void testPushEntityEventToRuleEngine_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> alarmEdgeProcessorV1.pushEntityEventToRuleEngine(tenantId, entityId,
        null, TbMsgType.POST_ATTRIBUTES_REQUEST, "Msg Data", new TbMsgMetaData()));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion); then return AssetProfile()")
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge_thenReturnAssetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertSame(assetProfile, alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(tenantId, null,
        assetProfile, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion); then return AssetProfile()")
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge_thenReturnAssetProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertSame(assetProfile,
        alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(tenantId, null, assetProfile, null));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion); when EdgeId")
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge_whenEdgeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EdgeId edgeId = mock(EdgeId.class);
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertSame(assetProfile, alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(tenantId, edgeId,
        assetProfile, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion); when 'V_3_3_3'")
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge_whenV333() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertSame(assetProfile, alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(tenantId, null,
        assetProfile, EdgeVersion.V_3_3_3));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_4_0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion); when 'V_3_4_0'")
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge_whenV340() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertSame(assetProfile, alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(tenantId, null,
        assetProfile, EdgeVersion.V_3_4_0));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion); then return DeviceProfile()")
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge_thenReturnDeviceProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(tenantId, null,
        deviceProfile, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion); then return DeviceProfile()")
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge_thenReturnDeviceProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile,
        alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(tenantId, null, deviceProfile, null));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion); when EdgeId")
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge_whenEdgeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EdgeId edgeId = mock(EdgeId.class);
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(tenantId, edgeId,
        deviceProfile, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion); when 'V_3_3_3'")
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge_whenV333() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(tenantId, null,
        deviceProfile, EdgeVersion.V_3_3_3));
  }

  /**
   * Test
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_4_0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion); when 'V_3_4_0'")
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge_whenV340() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(tenantId, null,
        deviceProfile, EdgeVersion.V_3_4_0));
  }
}
