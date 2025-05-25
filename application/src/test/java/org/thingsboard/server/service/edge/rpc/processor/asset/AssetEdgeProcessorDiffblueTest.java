package org.thingsboard.server.service.edge.rpc.processor.asset;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.asset.AssetMsgConstructorFactory;
import org.thingsboard.server.service.edge.rpc.constructor.asset.AssetMsgConstructorV1;

@ExtendWith(MockitoExtension.class)
class AssetEdgeProcessorDiffblueTest {
  @InjectMocks
  private AssetEdgeProcessorV1 assetEdgeProcessorV1;

  @Mock
  private AssetMsgConstructorFactory assetMsgConstructorFactory;

  /**
   * Test {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetEdgeProcessor#convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg AssetEdgeProcessor.convertAssetEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"})
  void testConvertAssetEventToDownlink_thenThrowDataValidationException() {
    // Arrange
    when(assetMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new AssetMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);
    when(edgeEvent.getEntityId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetEdgeProcessorV1.convertAssetEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(assetMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }
}
