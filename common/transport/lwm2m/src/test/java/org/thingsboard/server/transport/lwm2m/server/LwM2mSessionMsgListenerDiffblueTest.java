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
package org.thingsboard.server.transport.lwm2m.server;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToTransportUpdateCredentialsProto;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.rpc.LwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class LwM2mSessionMsgListenerDiffblueTest {
  /**
   * Test {@link LwM2mSessionMsgListener#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <p>Method under test: {@link
   * LwM2mSessionMsgListener#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test onGetAttributesResponse(GetAttributeResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mSessionMsgListener.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse() {
    // Arrange
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    doNothing()
        .when(attributesService)
        .onGetAttributesResponse(
            Mockito.<GetAttributeResponseMsg>any(), Mockito.<SessionInfoProto>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            mock(LwM2mUplinkMsgHandler.class),
            attributesService,
            mock(LwM2MRpcRequestHandler.class),
            mock(SessionInfoProto.class),
            mock(TransportService.class));

    // Act
    lwM2mSessionMsgListener.onGetAttributesResponse(GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(attributesService)
        .onGetAttributesResponse(isA(GetAttributeResponseMsg.class), isA(SessionInfoProto.class));
  }

  /**
   * Test {@link LwM2mSessionMsgListener#onAttributeUpdate(UUID, AttributeUpdateNotificationMsg)}.
   *
   * <p>Method under test: {@link LwM2mSessionMsgListener#onAttributeUpdate(UUID,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName("Test onAttributeUpdate(UUID, AttributeUpdateNotificationMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mSessionMsgListener.onAttributeUpdate(UUID, AttributeUpdateNotificationMsg)"
  })
  void testOnAttributeUpdate() {
    // Arrange
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    doNothing()
        .when(attributesService)
        .onAttributesUpdate(
            Mockito.<AttributeUpdateNotificationMsg>any(), Mockito.<SessionInfoProto>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            mock(LwM2mUplinkMsgHandler.class),
            attributesService,
            mock(LwM2MRpcRequestHandler.class),
            mock(SessionInfoProto.class),
            mock(TransportService.class));

    // Act
    lwM2mSessionMsgListener.onAttributeUpdate(
        UUID.randomUUID(), AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(attributesService)
        .onAttributesUpdate(isA(AttributeUpdateNotificationMsg.class), isA(SessionInfoProto.class));
  }

  /**
   * Test {@link
   * LwM2mSessionMsgListener#onToTransportUpdateCredentials(ToTransportUpdateCredentialsProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mSessionMsgListener#onToTransportUpdateCredentials(TransportProtos.ToTransportUpdateCredentialsProto)}
   */
  @Test
  @DisplayName("Test onToTransportUpdateCredentials(ToTransportUpdateCredentialsProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mSessionMsgListener.onToTransportUpdateCredentials(TransportProtos.ToTransportUpdateCredentialsProto)"
  })
  void testOnToTransportUpdateCredentials() {
    // Arrange
    LwM2mUplinkMsgHandler handler = mock(LwM2mUplinkMsgHandler.class);
    doNothing()
        .when(handler)
        .onToTransportUpdateCredentials(
            Mockito.<SessionInfoProto>any(), Mockito.<ToTransportUpdateCredentialsProto>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            handler,
            mock(LwM2MAttributesService.class),
            mock(LwM2MRpcRequestHandler.class),
            mock(SessionInfoProto.class),
            mock(TransportService.class));

    // Act
    lwM2mSessionMsgListener.onToTransportUpdateCredentials(
        ToTransportUpdateCredentialsProto.getDefaultInstance());

    // Assert
    verify(handler)
        .onToTransportUpdateCredentials(
            isA(SessionInfoProto.class), isA(ToTransportUpdateCredentialsProto.class));
  }

  /**
   * Test {@link LwM2mSessionMsgListener#onDeviceProfileUpdate(SessionInfoProto, DeviceProfile)}.
   *
   * <p>Method under test: {@link
   * LwM2mSessionMsgListener#onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mSessionMsgListener.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdate() {
    // Arrange
    LwM2mUplinkMsgHandler handler = mock(LwM2mUplinkMsgHandler.class);
    doNothing()
        .when(handler)
        .onDeviceProfileUpdate(Mockito.<SessionInfoProto>any(), Mockito.<DeviceProfile>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            handler,
            mock(LwM2MAttributesService.class),
            mock(LwM2MRpcRequestHandler.class),
            mock(SessionInfoProto.class),
            mock(TransportService.class));
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mSessionMsgListener.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(handler).onDeviceProfileUpdate(isA(SessionInfoProto.class), isA(DeviceProfile.class));
  }

  /**
   * Test {@link LwM2mSessionMsgListener#onDeviceUpdate(SessionInfoProto, Device, Optional)}.
   *
   * <p>Method under test: {@link
   * LwM2mSessionMsgListener#onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)}
   */
  @Test
  @DisplayName("Test onDeviceUpdate(SessionInfoProto, Device, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mSessionMsgListener.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdate() {
    // Arrange
    LwM2mUplinkMsgHandler handler = mock(LwM2mUplinkMsgHandler.class);
    doNothing()
        .when(handler)
        .onDeviceUpdate(
            Mockito.<SessionInfoProto>any(),
            Mockito.<Device>any(),
            Mockito.<Optional<DeviceProfile>>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            handler,
            mock(LwM2MAttributesService.class),
            mock(LwM2MRpcRequestHandler.class),
            mock(SessionInfoProto.class),
            mock(TransportService.class));
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> deviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    lwM2mSessionMsgListener.onDeviceUpdate(sessionInfo, device, deviceProfileOpt);

    // Assert
    verify(handler)
        .onDeviceUpdate(isA(SessionInfoProto.class), isA(Device.class), isA(Optional.class));
  }

  /**
   * Test {@link LwM2mSessionMsgListener#onToDeviceRpcRequest(UUID, ToDeviceRpcRequestMsg)}.
   *
   * <p>Method under test: {@link LwM2mSessionMsgListener#onToDeviceRpcRequest(UUID,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName("Test onToDeviceRpcRequest(UUID, ToDeviceRpcRequestMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mSessionMsgListener.onToDeviceRpcRequest(UUID, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testOnToDeviceRpcRequest() {
    // Arrange
    LwM2MRpcRequestHandler rpcHandler = mock(LwM2MRpcRequestHandler.class);
    doNothing()
        .when(rpcHandler)
        .onToDeviceRpcRequest(
            Mockito.<ToDeviceRpcRequestMsg>any(), Mockito.<SessionInfoProto>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            mock(LwM2mUplinkMsgHandler.class),
            mock(LwM2MAttributesService.class),
            rpcHandler,
            mock(SessionInfoProto.class),
            mock(TransportService.class));

    // Act
    lwM2mSessionMsgListener.onToDeviceRpcRequest(
        UUID.randomUUID(), ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(rpcHandler)
        .onToDeviceRpcRequest(isA(ToDeviceRpcRequestMsg.class), isA(SessionInfoProto.class));
  }

  /**
   * Test {@link LwM2mSessionMsgListener#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <p>Method under test: {@link
   * LwM2mSessionMsgListener#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test onToServerRpcResponse(ToServerRpcResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mSessionMsgListener.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse() {
    // Arrange
    LwM2MRpcRequestHandler rpcHandler = mock(LwM2MRpcRequestHandler.class);
    doNothing().when(rpcHandler).onToServerRpcResponse(Mockito.<ToServerRpcResponseMsg>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            mock(LwM2mUplinkMsgHandler.class),
            mock(LwM2MAttributesService.class),
            rpcHandler,
            mock(SessionInfoProto.class),
            mock(TransportService.class));

    // Act
    lwM2mSessionMsgListener.onToServerRpcResponse(ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(rpcHandler).onToServerRpcResponse(isA(ToServerRpcResponseMsg.class));
  }

  /**
   * Test {@link LwM2mSessionMsgListener#onDeviceDeleted(DeviceId)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mUplinkMsgHandler#onDeviceDelete(DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mSessionMsgListener#onDeviceDeleted(DeviceId)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(DeviceId); then calls onDeviceDelete(DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mSessionMsgListener.onDeviceDeleted(DeviceId)"})
  void testOnDeviceDeleted_thenCallsOnDeviceDelete() {
    // Arrange
    LwM2mUplinkMsgHandler handler = mock(LwM2mUplinkMsgHandler.class);
    doNothing().when(handler).onDeviceDelete(Mockito.<DeviceId>any());
    LwM2mSessionMsgListener lwM2mSessionMsgListener =
        new LwM2mSessionMsgListener(
            handler,
            mock(LwM2MAttributesService.class),
            mock(LwM2MRpcRequestHandler.class),
            mock(SessionInfoProto.class),
            mock(TransportService.class));

    // Act
    lwM2mSessionMsgListener.onDeviceDeleted(null);

    // Assert
    verify(handler).onDeviceDelete(isNull());
  }
}
