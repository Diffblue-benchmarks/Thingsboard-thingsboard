package org.thingsboard.server.service.edge.rpc.processor.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.AdminSettingsUpdateMsg;
import org.thingsboard.server.gen.edge.v1.DeviceProfileUpdateMsg;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorFactory;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorV1;

@ExtendWith(MockitoExtension.class)
class DeviceProfileEdgeProcessorDiffblueTest {
  @Mock private DeviceMsgConstructorFactory deviceMsgConstructorFactory;

  @InjectMocks private DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1;

  /**
   * Test {@link DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId,
   * EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg DeviceProfileEdgeProcessor.convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertDeviceProfileEventToDownlink() {
    // Arrange
    when(deviceMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new DeviceMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.DELETED);
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DownlinkMsg actualConvertDeviceProfileEventToDownlinkResult =
        deviceProfileEdgeProcessorV1.convertDeviceProfileEventToDownlink(
            edgeEvent, null, EdgeVersion.V_3_3_0);

    // Assert
    boolean actualIsEmptyResult =
        actualConvertDeviceProfileEventToDownlinkResult.findInitializationErrors().isEmpty();
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
    assertEquals(
        "", actualConvertDeviceProfileEventToDownlinkResult.getInitializationErrorString());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getAdminSettingsUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getAlarmCommentUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getAlarmUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getAssetProfileUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getAssetUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getCustomerUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getDashboardUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getDeviceCredentialsRequestMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getDeviceCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getDeviceRpcCallMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getDeviceUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getEntityDataCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getEntityViewUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getNotificationRuleUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getNotificationTargetUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getNotificationTemplateUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getOAuth2ClientUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getOAuth2DomainUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getOtaPackageUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getQueueUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getRelationUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getResourceUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getRuleChainMetadataUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getRuleChainUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getTenantProfileUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getTenantUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getUserCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getUserUpdateMsgCount());
    assertEquals(0, actualConvertDeviceProfileEventToDownlinkResult.getWidgetTypeUpdateMsgCount());
    assertEquals(
        0, actualConvertDeviceProfileEventToDownlinkResult.getWidgetsBundleUpdateMsgCount());
    List<DeviceProfileUpdateMsg> deviceProfileUpdateMsgList =
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceProfileUpdateMsgList();
    assertEquals(1, deviceProfileUpdateMsgList.size());
    assertEquals(
        1, actualConvertDeviceProfileEventToDownlinkResult.getDeviceProfileUpdateMsgCount());
    assertEquals(2, actualConvertDeviceProfileEventToDownlinkResult.getAllFields().size());
    assertEquals(31, actualConvertDeviceProfileEventToDownlinkResult.getSerializedSize());
    assertFalse(actualConvertDeviceProfileEventToDownlinkResult.hasEdgeConfiguration());
    assertFalse(actualConvertDeviceProfileEventToDownlinkResult.hasSyncCompletedMsg());
    assertTrue(actualIsEmptyResult);
    List<AdminSettingsUpdateMsg> adminSettingsUpdateMsgList =
        actualConvertDeviceProfileEventToDownlinkResult.getAdminSettingsUpdateMsgList();
    assertTrue(adminSettingsUpdateMsgList.isEmpty());
    assertTrue(actualConvertDeviceProfileEventToDownlinkResult.isInitialized());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAdminSettingsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAlarmCommentUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAlarmCommentUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAlarmUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAlarmUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAssetProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAssetProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAssetUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getAssetUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getCustomerUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getCustomerUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDashboardUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDashboardUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceCredentialsRequestMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult
            .getDeviceCredentialsRequestMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult
            .getDeviceCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceRpcCallMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceRpcCallMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getEntityDataList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getEntityDataOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getEntityViewUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getEntityViewUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getNotificationRuleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult
            .getNotificationRuleUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getNotificationTargetUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult
            .getNotificationTargetUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getNotificationTemplateUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult
            .getNotificationTemplateUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getOAuth2ClientUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getOAuth2ClientUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getOAuth2DomainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getOAuth2DomainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getOtaPackageUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getOtaPackageUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getQueueUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getQueueUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getRelationUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getRelationUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getResourceUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getResourceUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getRuleChainMetadataUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult
            .getRuleChainMetadataUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getRuleChainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getRuleChainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getTenantProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getTenantProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getTenantUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getTenantUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getUserCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getUserCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getUserUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getUserUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getWidgetTypeUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getWidgetTypeUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getWidgetsBundleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getWidgetsBundleUpdateMsgOrBuilderList());
    assertSame(
        deviceProfileUpdateMsgList,
        actualConvertDeviceProfileEventToDownlinkResult.getDeviceProfileUpdateMsgOrBuilderList());
  }

  /**
   * Test {@link DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId,
   * EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg DeviceProfileEdgeProcessor.convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertDeviceProfileEventToDownlink2() {
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
            deviceProfileEdgeProcessorV1.convertDeviceProfileEventToDownlink(
                edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId,
   * EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg DeviceProfileEdgeProcessor.convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertDeviceProfileEventToDownlink3() {
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
            deviceProfileEdgeProcessorV1.convertDeviceProfileEventToDownlink(
                edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }
}
