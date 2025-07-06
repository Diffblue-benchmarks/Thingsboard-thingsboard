package org.thingsboard.server.service.edge.rpc.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;
import org.thingsboard.server.service.edge.rpc.processor.alarm.AlarmEdgeProcessorV1;

class BaseEdgeProcessorDiffblueTest {
  /**
   * Test {@link BaseEdgeProcessor#handleUnsupportedMsgType(UpdateMsgType)}.
   *
   * <p>Method under test: {@link BaseEdgeProcessor#handleUnsupportedMsgType(UpdateMsgType)}
   */
  @Test
  @DisplayName("Test handleUnsupportedMsgType(UpdateMsgType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture BaseEdgeProcessor.handleUnsupportedMsgType(UpdateMsgType)"
  })
  void testHandleUnsupportedMsgType() {
    // Arrange, Act and Assert
    assertTrue(
        new AlarmEdgeProcessorV1()
            .handleUnsupportedMsgType(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE)
            .isDone());
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   *
   * <ul>
   *   <li>When {@code ADDED}.
   *   <li>Then return {@code ENTITY_CREATED_RPC_MESSAGE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName(
      "Test getUpdateMsgType(EdgeEventActionType); when 'ADDED'; then return 'ENTITY_CREATED_RPC_MESSAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateMsgType BaseEdgeProcessor.getUpdateMsgType(EdgeEventActionType)"})
  void testGetUpdateMsgType_whenAdded_thenReturnEntityCreatedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        new AlarmEdgeProcessorV1().getUpdateMsgType(EdgeEventActionType.ADDED));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   *
   * <ul>
   *   <li>When {@code ALARM_ACK}.
   *   <li>Then return {@code ALARM_ACK_RPC_MESSAGE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName(
      "Test getUpdateMsgType(EdgeEventActionType); when 'ALARM_ACK'; then return 'ALARM_ACK_RPC_MESSAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateMsgType BaseEdgeProcessor.getUpdateMsgType(EdgeEventActionType)"})
  void testGetUpdateMsgType_whenAlarmAck_thenReturnAlarmAckRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(
        UpdateMsgType.ALARM_ACK_RPC_MESSAGE,
        new AlarmEdgeProcessorV1().getUpdateMsgType(EdgeEventActionType.ALARM_ACK));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   *
   * <ul>
   *   <li>When {@code ALARM_ASSIGNED}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName(
      "Test getUpdateMsgType(EdgeEventActionType); when 'ALARM_ASSIGNED'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateMsgType BaseEdgeProcessor.getUpdateMsgType(EdgeEventActionType)"})
  void testGetUpdateMsgType_whenAlarmAssigned_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new AlarmEdgeProcessorV1().getUpdateMsgType(EdgeEventActionType.ALARM_ASSIGNED));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   *
   * <ul>
   *   <li>When {@code ALARM_CLEAR}.
   *   <li>Then return {@code ALARM_CLEAR_RPC_MESSAGE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName(
      "Test getUpdateMsgType(EdgeEventActionType); when 'ALARM_CLEAR'; then return 'ALARM_CLEAR_RPC_MESSAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateMsgType BaseEdgeProcessor.getUpdateMsgType(EdgeEventActionType)"})
  void testGetUpdateMsgType_whenAlarmClear_thenReturnAlarmClearRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(
        UpdateMsgType.ALARM_CLEAR_RPC_MESSAGE,
        new AlarmEdgeProcessorV1().getUpdateMsgType(EdgeEventActionType.ALARM_CLEAR));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   *
   * <ul>
   *   <li>When {@code DELETED}.
   *   <li>Then return {@code ENTITY_DELETED_RPC_MESSAGE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName(
      "Test getUpdateMsgType(EdgeEventActionType); when 'DELETED'; then return 'ENTITY_DELETED_RPC_MESSAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateMsgType BaseEdgeProcessor.getUpdateMsgType(EdgeEventActionType)"})
  void testGetUpdateMsgType_whenDeleted_thenReturnEntityDeletedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        new AlarmEdgeProcessorV1().getUpdateMsgType(EdgeEventActionType.DELETED));
  }

  /**
   * Test {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}.
   *
   * <ul>
   *   <li>When {@code UPDATED_COMMENT}.
   *   <li>Then return {@code ENTITY_UPDATED_RPC_MESSAGE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getUpdateMsgType(EdgeEventActionType)}
   */
  @Test
  @DisplayName(
      "Test getUpdateMsgType(EdgeEventActionType); when 'UPDATED_COMMENT'; then return 'ENTITY_UPDATED_RPC_MESSAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateMsgType BaseEdgeProcessor.getUpdateMsgType(EdgeEventActionType)"})
  void testGetUpdateMsgType_whenUpdatedComment_thenReturnEntityUpdatedRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        new AlarmEdgeProcessorV1().getUpdateMsgType(EdgeEventActionType.UPDATED_COMMENT));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Id toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}
   */
  @Test
  @DisplayName(
      "Test safeGetEdgeId(long, long); when one; then return Id toString is '00000000-0000-0001-0000-000000000001'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeId BaseEdgeProcessor.safeGetEdgeId(long, long)"})
  void testSafeGetEdgeId_whenOne_thenReturnIdToStringIs00000000000000010000000000000001() {
    // Arrange and Act
    EdgeId actualSafeGetEdgeIdResult = new AlarmEdgeProcessorV1().safeGetEdgeId(1L, 1L);

    // Assert
    assertEquals(
        "00000000-0000-0001-0000-000000000001", actualSafeGetEdgeIdResult.getId().toString());
    assertEquals(EntityType.EDGE, actualSafeGetEdgeIdResult.getEntityType());
    assertFalse(actualSafeGetEdgeIdResult.isNullUid());
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetEdgeId(long, long); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeId BaseEdgeProcessor.safeGetEdgeId(long, long)"})
  void testSafeGetEdgeId_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEdgeProcessorV1().safeGetEdgeId(1L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetEdgeId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetEdgeId(long, long); when zero; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeId BaseEdgeProcessor.safeGetEdgeId(long, long)"})
  void testSafeGetEdgeId_whenZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEdgeProcessorV1().safeGetEdgeId(0L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetUUID(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetUUID(long, long)}
   */
  @Test
  @DisplayName("Test safeGetUUID(long, long); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID BaseEdgeProcessor.safeGetUUID(long, long)"})
  void testSafeGetUUID_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEdgeProcessorV1().safeGetUUID(1L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetUUID(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetUUID(long, long)}
   */
  @Test
  @DisplayName(
      "Test safeGetUUID(long, long); when one; then return toString is '00000000-0000-0001-0000-000000000001'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID BaseEdgeProcessor.safeGetUUID(long, long)"})
  void testSafeGetUUID_whenOne_thenReturnToStringIs00000000000000010000000000000001() {
    // Arrange, Act and Assert
    assertEquals(
        "00000000-0000-0001-0000-000000000001",
        new AlarmEdgeProcessorV1().safeGetUUID(1L, 1L).toString());
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetUUID(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetUUID(long, long)}
   */
  @Test
  @DisplayName("Test safeGetUUID(long, long); when zero; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID BaseEdgeProcessor.safeGetUUID(long, long)"})
  void testSafeGetUUID_whenZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEdgeProcessorV1().safeGetUUID(0L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}
   */
  @Test
  @DisplayName(
      "Test safeGetCustomerId(long, long); then return Id toString is '00000000-0000-0001-0000-000000000001'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomerId BaseEdgeProcessor.safeGetCustomerId(long, long)"})
  void testSafeGetCustomerId_thenReturnIdToStringIs00000000000000010000000000000001() {
    // Arrange and Act
    CustomerId actualSafeGetCustomerIdResult = new AlarmEdgeProcessorV1().safeGetCustomerId(1L, 1L);

    // Assert
    assertEquals(
        "00000000-0000-0001-0000-000000000001", actualSafeGetCustomerIdResult.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualSafeGetCustomerIdResult.getEntityType());
    assertFalse(actualSafeGetCustomerIdResult.isNullUid());
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetCustomerId(long, long); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomerId BaseEdgeProcessor.safeGetCustomerId(long, long)"})
  void testSafeGetCustomerId_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEdgeProcessorV1().safeGetCustomerId(1L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#safeGetCustomerId(long, long)}
   */
  @Test
  @DisplayName("Test safeGetCustomerId(long, long); when zero; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomerId BaseEdgeProcessor.safeGetCustomerId(long, long)"})
  void testSafeGetCustomerId_whenZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmEdgeProcessorV1().safeGetCustomerId(0L, 0L));
  }

  /**
   * Test {@link BaseEdgeProcessor#isEntityExists(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#isEntityExists(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test isEntityExists(TenantId, EntityId); when AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseEdgeProcessor.isEntityExists(TenantId, EntityId)"})
  void testIsEntityExists_whenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertFalse(
        alarmEdgeProcessorV1.isEntityExists(
            tenantId, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}
   */
  @Test
  @DisplayName("Test getEdgeActionTbMsgMetaData(Edge, CustomerId); then return Data size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsgMetaData BaseEdgeProcessor.getEdgeActionTbMsgMetaData(Edge, CustomerId)"
  })
  void testGetEdgeActionTbMsgMetaData_thenReturnDataSizeIsOne() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    Edge edge = new Edge();
    edge.setId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    Map<String, String> data =
        alarmEdgeProcessorV1.getEdgeActionTbMsgMetaData(edge, null).getData();
    assertEquals(1, data.size());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", data.get("edgeId"));
  }

  /**
   * Test {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}.
   *
   * <ul>
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeProcessor#getEdgeActionTbMsgMetaData(Edge, CustomerId)}
   */
  @Test
  @DisplayName("Test getEdgeActionTbMsgMetaData(Edge, CustomerId); then return Data size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.TbMsgMetaData BaseEdgeProcessor.getEdgeActionTbMsgMetaData(Edge, CustomerId)"
  })
  void testGetEdgeActionTbMsgMetaData_thenReturnDataSizeIsTwo() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();

    Edge edge = new Edge();
    edge.setId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    Map<String, String> data =
        alarmEdgeProcessorV1
            .getEdgeActionTbMsgMetaData(
                edge, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getData();
    assertEquals(2, data.size());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", data.get("customerId"));
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", data.get("edgeId"));
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetProfile BaseEdgeProcessor.checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)"
  })
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = new AssetProfile();

    // Act
    AssetProfile actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(
            tenantId, null, assetProfile, EdgeVersion.V_3_3_0);

    // Assert
    assertNull(assetProfile.getDefaultDashboardId());
    assertNull(assetProfile.getDefaultEdgeRuleChainId());
    assertSame(assetProfile, actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult);
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetProfile BaseEdgeProcessor.checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)"
  })
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge2() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = new AssetProfile();

    // Act
    AssetProfile actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(
            tenantId, null, assetProfile, null);

    // Assert
    assertNull(assetProfile.getDefaultDashboardId());
    assertNull(assetProfile.getDefaultEdgeRuleChainId());
    assertSame(assetProfile, actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult);
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_3_3}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion); when 'V_3_3_3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetProfile BaseEdgeProcessor.checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)"
  })
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge_whenV333() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = new AssetProfile();

    // Act
    AssetProfile actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(
            tenantId, null, assetProfile, EdgeVersion.V_3_3_3);

    // Assert
    assertNull(assetProfile.getDefaultDashboardId());
    assertNull(assetProfile.getDefaultEdgeRuleChainId());
    assertSame(assetProfile, actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult);
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_4_0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * AssetProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion); when 'V_3_4_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetProfile BaseEdgeProcessor.checkIfAssetProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, AssetProfile, EdgeVersion)"
  })
  void testCheckIfAssetProfileDefaultFieldsAssignedToEdge_whenV340() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = new AssetProfile();

    // Act
    AssetProfile actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfAssetProfileDefaultFieldsAssignedToEdge(
            tenantId, null, assetProfile, EdgeVersion.V_3_4_0);

    // Assert
    assertNull(assetProfile.getDefaultDashboardId());
    assertNull(assetProfile.getDefaultEdgeRuleChainId());
    assertSame(assetProfile, actualCheckIfAssetProfileDefaultFieldsAssignedToEdgeResult);
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceProfile BaseEdgeProcessor.checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)"
  })
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    DeviceProfile actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(
            tenantId, null, deviceProfile, EdgeVersion.V_3_3_0);

    // Assert
    assertNull(deviceProfile.getDefaultDashboardId());
    assertNull(deviceProfile.getDefaultEdgeRuleChainId());
    assertSame(deviceProfile, actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult);
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceProfile BaseEdgeProcessor.checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)"
  })
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge2() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    DeviceProfile actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(
            tenantId, null, deviceProfile, null);

    // Assert
    assertNull(deviceProfile.getDefaultDashboardId());
    assertNull(deviceProfile.getDefaultEdgeRuleChainId());
    assertSame(deviceProfile, actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult);
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_3_3}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion); when 'V_3_3_3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceProfile BaseEdgeProcessor.checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)"
  })
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge_whenV333() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    DeviceProfile actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(
            tenantId, null, deviceProfile, EdgeVersion.V_3_3_3);

    // Assert
    assertNull(deviceProfile.getDefaultDashboardId());
    assertNull(deviceProfile.getDefaultEdgeRuleChainId());
    assertSame(deviceProfile, actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult);
  }

  /**
   * Test {@link BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_4_0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseEdgeProcessor#checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId,
   * DeviceProfile, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion); when 'V_3_4_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeviceProfile BaseEdgeProcessor.checkIfDeviceProfileDefaultFieldsAssignedToEdge(TenantId, EdgeId, DeviceProfile, EdgeVersion)"
  })
  void testCheckIfDeviceProfileDefaultFieldsAssignedToEdge_whenV340() {
    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    DeviceProfile actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult =
        alarmEdgeProcessorV1.checkIfDeviceProfileDefaultFieldsAssignedToEdge(
            tenantId, null, deviceProfile, EdgeVersion.V_3_4_0);

    // Assert
    assertNull(deviceProfile.getDefaultDashboardId());
    assertNull(deviceProfile.getDefaultEdgeRuleChainId());
    assertSame(deviceProfile, actualCheckIfDeviceProfileDefaultFieldsAssignedToEdgeResult);
  }
}
