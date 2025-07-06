package org.thingsboard.server.service.edge.rpc.processor.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.AdminSettingsUpdateMsg;
import org.thingsboard.server.gen.edge.v1.DeviceRpcCallMsg;
import org.thingsboard.server.gen.edge.v1.DeviceUpdateMsg;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorFactory;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorV1;

@ExtendWith(MockitoExtension.class)
class DeviceEdgeProcessorDiffblueTest {
  @InjectMocks private DeviceEdgeProcessorV1 deviceEdgeProcessorV1;

  @Mock private DeviceMsgConstructorFactory deviceMsgConstructorFactory;

  /**
   * Test {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge,
   * DeviceRpcCallMsg)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@link ListenableFuture#get()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge,
   * DeviceRpcCallMsg)}
   */
  @Test
  @DisplayName(
      "Test processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg); when DefaultInstance; then return get() is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ListenableFuture DeviceEdgeProcessor.processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)"
  })
  void testProcessDeviceRpcCallFromEdge_whenDefaultInstance_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    DeviceEdgeProcessorV1 deviceEdgeProcessorV1 = new DeviceEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessDeviceRpcCallFromEdgeResult =
        deviceEdgeProcessorV1.processDeviceRpcCallFromEdge(
            tenantId, edge, DeviceRpcCallMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessDeviceRpcCallFromEdgeResult.get());
    assertTrue(actualProcessDeviceRpcCallFromEdgeResult.isDone());
  }

  /**
   * Test {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   *
   * <p>Method under test: {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent,
   * EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg DeviceEdgeProcessor.convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertDeviceEventToDownlink() {
    // Arrange
    when(deviceMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new DeviceMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.DELETED);
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DownlinkMsg actualConvertDeviceEventToDownlinkResult =
        deviceEdgeProcessorV1.convertDeviceEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
    assertEquals("", actualConvertDeviceEventToDownlinkResult.getInitializationErrorString());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getAdminSettingsUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getAlarmCommentUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getAlarmUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getAssetProfileUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getAssetUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getCustomerUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getDashboardUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getDeviceCredentialsRequestMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getDeviceCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getDeviceProfileUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getDeviceRpcCallMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getEntityDataCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getEntityViewUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getNotificationRuleUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getNotificationTargetUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceEventToDownlinkResult.getNotificationTemplateUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getOAuth2ClientUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getOAuth2DomainUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getOtaPackageUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getQueueUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getRelationUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getResourceUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getRuleChainMetadataUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getRuleChainUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getTenantProfileUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getTenantUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getUserCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getUserUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getWidgetTypeUpdateMsgCount());
    assertEquals(0, actualConvertDeviceEventToDownlinkResult.getWidgetsBundleUpdateMsgCount());
    List<DeviceUpdateMsg> deviceUpdateMsgList =
        actualConvertDeviceEventToDownlinkResult.getDeviceUpdateMsgList();
    assertEquals(1, deviceUpdateMsgList.size());
    assertEquals(1, actualConvertDeviceEventToDownlinkResult.getDeviceUpdateMsgCount());
    assertEquals(2, actualConvertDeviceEventToDownlinkResult.getAllFields().size());
    assertFalse(actualConvertDeviceEventToDownlinkResult.hasEdgeConfiguration());
    assertFalse(actualConvertDeviceEventToDownlinkResult.hasSyncCompletedMsg());
    assertTrue(actualConvertDeviceEventToDownlinkResult.findInitializationErrors().isEmpty());
    List<AdminSettingsUpdateMsg> adminSettingsUpdateMsgList =
        actualConvertDeviceEventToDownlinkResult.getAdminSettingsUpdateMsgList();
    assertTrue(adminSettingsUpdateMsgList.isEmpty());
    assertTrue(actualConvertDeviceEventToDownlinkResult.isInitialized());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAdminSettingsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAlarmCommentUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAlarmCommentUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAlarmUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAlarmUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAssetProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAssetProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAssetUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getAssetUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getCustomerUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getCustomerUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDashboardUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDashboardUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceCredentialsRequestMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceCredentialsRequestMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceRpcCallMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceRpcCallMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList, actualConvertDeviceEventToDownlinkResult.getEntityDataList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getEntityDataOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getEntityViewUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getEntityViewUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getNotificationRuleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getNotificationRuleUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getNotificationTargetUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getNotificationTargetUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getNotificationTemplateUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getNotificationTemplateUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getOAuth2ClientUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getOAuth2ClientUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getOAuth2DomainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getOAuth2DomainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getOtaPackageUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getOtaPackageUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getQueueUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getQueueUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getRelationUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getRelationUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getResourceUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getResourceUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getRuleChainMetadataUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getRuleChainMetadataUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getRuleChainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getRuleChainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getTenantProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getTenantProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getTenantUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getTenantUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getUserCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getUserCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getUserUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getUserUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getWidgetTypeUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getWidgetTypeUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getWidgetsBundleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getWidgetsBundleUpdateMsgOrBuilderList());
    assertSame(
        deviceUpdateMsgList,
        actualConvertDeviceEventToDownlinkResult.getDeviceUpdateMsgOrBuilderList());
  }

  /**
   * Test {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   *
   * <p>Method under test: {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent,
   * EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg DeviceEdgeProcessor.convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertDeviceEventToDownlink2() {
    // Arrange
    when(deviceMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new DeviceMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceEdgeProcessorV1.convertDeviceEventToDownlink(
                edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   *
   * <p>Method under test: {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent,
   * EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg DeviceEdgeProcessor.convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertDeviceEventToDownlink3() {
    // Arrange
    when(deviceMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new DeviceMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceEdgeProcessorV1.convertDeviceEventToDownlink(
                edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }
}
