package org.thingsboard.server.service.edge.rpc.processor.asset;

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
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.asset.AssetMsgConstructorFactory;
import org.thingsboard.server.service.edge.rpc.constructor.asset.AssetMsgConstructorV1;

@ExtendWith(MockitoExtension.class)
class AssetEdgeProcessorDiffblueTest {
  @InjectMocks private AssetEdgeProcessorV1 assetEdgeProcessorV1;

  @Mock private AssetMsgConstructorFactory assetMsgConstructorFactory;

  /**
   * Test {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   *
   * <p>Method under test: {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId,
   * EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AssetEdgeProcessor.convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertAssetEventToDownlink() {
    // Arrange
    when(assetMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new AssetMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetEdgeProcessorV1.convertAssetEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(assetMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   *
   * <p>Method under test: {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId,
   * EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AssetEdgeProcessor.convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertAssetEventToDownlink2() {
    // Arrange
    when(assetMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new AssetMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetEdgeProcessorV1.convertAssetEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(assetMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is thirty-one.
   * </ul>
   *
   * <p>Method under test: {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId,
   * EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion); then return SerializedSize is thirty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AssetEdgeProcessor.convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertAssetEventToDownlink_thenReturnSerializedSizeIsThirtyOne() {
    // Arrange
    when(assetMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new AssetMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.DELETED);
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DownlinkMsg actualConvertAssetEventToDownlinkResult =
        assetEdgeProcessorV1.convertAssetEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(assetMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
    assertEquals("", actualConvertAssetEventToDownlinkResult.getInitializationErrorString());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAdminSettingsUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAlarmCommentUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAlarmUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAssetProfileUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getCustomerUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDashboardUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceCredentialsRequestMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceProfileUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceRpcCallMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getEntityDataCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getEntityViewUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getNotificationRuleUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getNotificationTargetUpdateMsgCount());
    assertEquals(
        0, actualConvertAssetEventToDownlinkResult.getNotificationTemplateUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getOAuth2ClientUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getOAuth2DomainUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getOtaPackageUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getQueueUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getRelationUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getResourceUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getRuleChainMetadataUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getRuleChainUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getTenantProfileUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getTenantUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getUserCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getUserUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getWidgetTypeUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getWidgetsBundleUpdateMsgCount());
    List<AssetUpdateMsg> assetUpdateMsgList =
        actualConvertAssetEventToDownlinkResult.getAssetUpdateMsgList();
    assertEquals(1, assetUpdateMsgList.size());
    assertEquals(1, actualConvertAssetEventToDownlinkResult.getAssetUpdateMsgCount());
    assertEquals(2, actualConvertAssetEventToDownlinkResult.getAllFields().size());
    assertEquals(31, actualConvertAssetEventToDownlinkResult.getSerializedSize());
    assertFalse(actualConvertAssetEventToDownlinkResult.hasEdgeConfiguration());
    assertFalse(actualConvertAssetEventToDownlinkResult.hasSyncCompletedMsg());
    assertTrue(actualConvertAssetEventToDownlinkResult.findInitializationErrors().isEmpty());
    List<AdminSettingsUpdateMsg> adminSettingsUpdateMsgList =
        actualConvertAssetEventToDownlinkResult.getAdminSettingsUpdateMsgList();
    assertTrue(adminSettingsUpdateMsgList.isEmpty());
    assertTrue(actualConvertAssetEventToDownlinkResult.isInitialized());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAdminSettingsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmCommentUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmCommentUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAssetProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAssetProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getCustomerUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getCustomerUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDashboardUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDashboardUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsRequestMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsRequestMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceRpcCallMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceRpcCallMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList, actualConvertAssetEventToDownlinkResult.getEntityDataList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getEntityDataOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getEntityViewUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getEntityViewUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationRuleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationRuleUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTargetUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTargetUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTemplateUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTemplateUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2ClientUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2ClientUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2DomainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2DomainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOtaPackageUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOtaPackageUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getQueueUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getQueueUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRelationUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRelationUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getResourceUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getResourceUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainMetadataUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainMetadataUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getUserCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getUserCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList, actualConvertAssetEventToDownlinkResult.getUserUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getUserUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetTypeUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetTypeUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetsBundleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetsBundleUpdateMsgOrBuilderList());
    assertSame(
        assetUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAssetUpdateMsgOrBuilderList());
  }

  /**
   * Test {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getAction()} return {@code UNASSIGNED_FROM_EDGE}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId,
   * EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion); when EdgeEvent getAction() return 'UNASSIGNED_FROM_EDGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AssetEdgeProcessor.convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"
  })
  void testConvertAssetEventToDownlink_whenEdgeEventGetActionReturnUnassignedFromEdge() {
    // Arrange
    when(assetMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new AssetMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.UNASSIGNED_FROM_EDGE);
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DownlinkMsg actualConvertAssetEventToDownlinkResult =
        assetEdgeProcessorV1.convertAssetEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(assetMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
    assertEquals("", actualConvertAssetEventToDownlinkResult.getInitializationErrorString());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAdminSettingsUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAlarmCommentUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAlarmUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getAssetProfileUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getCustomerUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDashboardUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceCredentialsRequestMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceProfileUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceRpcCallMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getDeviceUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getEntityDataCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getEntityViewUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getNotificationRuleUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getNotificationTargetUpdateMsgCount());
    assertEquals(
        0, actualConvertAssetEventToDownlinkResult.getNotificationTemplateUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getOAuth2ClientUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getOAuth2DomainUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getOtaPackageUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getQueueUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getRelationUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getResourceUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getRuleChainMetadataUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getRuleChainUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getTenantProfileUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getTenantUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getUserCredentialsUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getUserUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getWidgetTypeUpdateMsgCount());
    assertEquals(0, actualConvertAssetEventToDownlinkResult.getWidgetsBundleUpdateMsgCount());
    List<AssetUpdateMsg> assetUpdateMsgList =
        actualConvertAssetEventToDownlinkResult.getAssetUpdateMsgList();
    assertEquals(1, assetUpdateMsgList.size());
    assertEquals(1, actualConvertAssetEventToDownlinkResult.getAssetUpdateMsgCount());
    assertEquals(2, actualConvertAssetEventToDownlinkResult.getAllFields().size());
    assertFalse(actualConvertAssetEventToDownlinkResult.hasEdgeConfiguration());
    assertFalse(actualConvertAssetEventToDownlinkResult.hasSyncCompletedMsg());
    assertTrue(actualConvertAssetEventToDownlinkResult.findInitializationErrors().isEmpty());
    List<AdminSettingsUpdateMsg> adminSettingsUpdateMsgList =
        actualConvertAssetEventToDownlinkResult.getAdminSettingsUpdateMsgList();
    assertTrue(adminSettingsUpdateMsgList.isEmpty());
    assertTrue(actualConvertAssetEventToDownlinkResult.isInitialized());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAdminSettingsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmCommentUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmCommentUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAlarmUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAssetProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAssetProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getCustomerUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getCustomerUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDashboardUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDashboardUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsRequestMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsRequestMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceRpcCallMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceRpcCallMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getDeviceUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList, actualConvertAssetEventToDownlinkResult.getEntityDataList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getEntityDataOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getEntityViewUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getEntityViewUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationRuleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationRuleUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTargetUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTargetUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTemplateUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getNotificationTemplateUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2ClientUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2ClientUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2DomainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOAuth2DomainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOtaPackageUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getOtaPackageUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getQueueUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getQueueUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRelationUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRelationUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getResourceUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getResourceUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainMetadataUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainMetadataUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getRuleChainUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantProfileUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantProfileUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getTenantUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getUserCredentialsUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getUserCredentialsUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList, actualConvertAssetEventToDownlinkResult.getUserUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getUserUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetTypeUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetTypeUpdateMsgOrBuilderList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetsBundleUpdateMsgList());
    assertSame(
        adminSettingsUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getWidgetsBundleUpdateMsgOrBuilderList());
    assertSame(
        assetUpdateMsgList,
        actualConvertAssetEventToDownlinkResult.getAssetUpdateMsgOrBuilderList());
  }
}
