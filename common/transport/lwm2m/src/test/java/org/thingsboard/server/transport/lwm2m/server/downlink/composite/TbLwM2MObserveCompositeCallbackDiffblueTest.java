package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.ObserveCompositeRequest;
import org.eclipse.leshan.core.response.ObserveCompositeResponse;
import org.eclipse.leshan.server.registration.RegistrationStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigService;
import org.thingsboard.server.transport.lwm2m.server.ota.LwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.session.LwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MDtlsSessionStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;

class TbLwM2MObserveCompositeCallbackDiffblueTest {
  /**
   * Test
   * {@link TbLwM2MObserveCompositeCallback#onSuccess(ObserveCompositeRequest, ObserveCompositeResponse)}
   * with {@code ObserveCompositeRequest}, {@code ObserveCompositeResponse}.
   * <ul>
   *   <li>Then calls
   * {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLwM2MObserveCompositeCallback#onSuccess(ObserveCompositeRequest, ObserveCompositeResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ObserveCompositeRequest, ObserveCompositeResponse) with 'ObserveCompositeRequest', 'ObserveCompositeResponse'; then calls log(LwM2mClient, String)")
  void testOnSuccessWithObserveCompositeRequestObserveCompositeResponse_thenCallsLog()
      throws InvalidLwM2mPathException {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(transportService, context,
        attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    TbLwM2MObserveCompositeCallback tbLwM2MObserveCompositeCallback = new TbLwM2MObserveCompositeCallback(handler,
        logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), new String[]{"1.0.2"});

    ArrayList<LwM2mPath> paths = new ArrayList<>();
    paths.add(new LwM2mPath(1));
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);
    ObserveCompositeRequest request = new ObserveCompositeRequest(requestContentFormat, ContentFormat.fromCode(1),
        paths);

    // Act
    tbLwM2MObserveCompositeCallback.onSuccess(request, ObserveCompositeResponse.methodNotAllowed());

    // Assert
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: ObserveCompositeRequest [[1.0.2]] failed to process successful. Result: ObserveCompositeResponse [code=METHOD_NOT_ALLOWED(405),  content=null, observation=null]"));
  }
}
