/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.server.downlink.composite;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.ReadCompositeRequest;
import org.eclipse.leshan.core.response.ReadCompositeResponse;
import org.eclipse.leshan.server.registration.RegistrationStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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

class TbLwM2MReadCompositeCallbackDiffblueTest {
  /**
   * Test {@link TbLwM2MReadCompositeCallback#onSuccess(ReadCompositeRequest,
   * ReadCompositeResponse)} with {@code ReadCompositeRequest}, {@code ReadCompositeResponse}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MReadCompositeCallback#onSuccess(ReadCompositeRequest,
   * ReadCompositeResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ReadCompositeRequest, ReadCompositeResponse) with 'ReadCompositeRequest', 'ReadCompositeResponse'; then calls log(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MReadCompositeCallback.onSuccess(ReadCompositeRequest, ReadCompositeResponse)"
  })
  void testOnSuccessWithReadCompositeRequestReadCompositeResponse_thenCallsLog() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);

    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            transportService,
            context,
            attributesService,
            sessionManager,
            otaService,
            new LwM2MTransportServerConfig(),
            mock(LwM2MTelemetryLogService.class),
            mock(LwM2mTransportServerHelper.class),
            mock(TbLwM2MDtlsSessionStore.class),
            mock(LwM2mClientContext.class),
            mock(LwM2mDownlinkMsgHandler.class),
            mock(LwM2mVersionedModelProvider.class),
            mock(RegistrationStore.class),
            mock(TbLwM2mSecurityStore.class),
            mock(LwM2MModelConfigService.class));
    String[] versionedIds = new String[] {"1.0.2"};

    TbLwM2MReadCompositeCallback tbLwM2MReadCompositeCallback =
        new TbLwM2MReadCompositeCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            versionedIds);

    ArrayList<String> paths = new ArrayList<>();
    paths.add("42");
    ContentFormat requestContentFormat = ContentFormat.fromCode(1);

    ReadCompositeRequest request =
        new ReadCompositeRequest(requestContentFormat, ContentFormat.fromCode(1), paths);

    // Act
    tbLwM2MReadCompositeCallback.onSuccess(request, ReadCompositeResponse.methodNotAllowed());

    // Assert
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: ReadCompositeRequest [[1.0.2]] failed to process successful. Result: ReadCompositeResponse [code=METHOD_NOT_ALLOWED(405), content=null]"));
  }
}
