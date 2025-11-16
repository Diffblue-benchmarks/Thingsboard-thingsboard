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
package org.thingsboard.server.transport.lwm2m.server.uplink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.leshan.core.ResponseCode;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mIncompletePath;
import org.eclipse.leshan.core.node.LwM2mNode;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.TimestampedLwM2mNodes;
import org.eclipse.leshan.core.request.CreateRequest;
import org.eclipse.leshan.core.response.CancelCompositeObservationResponse;
import org.eclipse.leshan.core.response.CancelObservationResponse;
import org.eclipse.leshan.core.response.ReadCompositeResponse;
import org.eclipse.leshan.core.response.ReadResponse;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ResourceDeleteMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ResourceUpdateMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultLwM2mUplinkMsgHandlerDiffblueTest {
  @InjectMocks private DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler;

  @Mock private LwM2MAttributesService lwM2MAttributesService;

  @Mock private LwM2MTelemetryLogService lwM2MTelemetryLogService;

  @Mock private LwM2MTransportServerConfig lwM2MTransportServerConfig;

  @Mock private LwM2mClientContext lwM2mClientContext;

  @Mock private LwM2mTransportContext lwM2mTransportContext;

  @Mock private LwM2mVersionedModelProvider lwM2mVersionedModelProvider;

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#init()}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getScheduler()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getScheduler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.init()"})
  void testInit_thenCallsGetScheduler() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    Mockito.<ScheduledFuture<?>>when(
            defaultSchedulerComponent.scheduleAtFixedRate(
                Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    when(lwM2mTransportContext.getScheduler()).thenReturn(defaultSchedulerComponent);
    when(lwM2MTransportServerConfig.getSessionReportTimeout()).thenReturn(1L);
    when(lwM2MTransportServerConfig.getUplinkPoolSize()).thenReturn(3);

    // Act
    defaultLwM2mUplinkMsgHandler.init();

    // Assert
    verify(lwM2mTransportContext).getScheduler();
    verify(defaultSchedulerComponent)
        .scheduleAtFixedRate(isA(Runnable.class), eq(0L), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(lwM2MTransportServerConfig, atLeast(1)).getSessionReportTimeout();
    verify(lwM2MTransportServerConfig).getUplinkPoolSize();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#getExecutorSize()}.
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#getExecutorSize()}
   */
  @Test
  @DisplayName("Test getExecutorSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultLwM2mUplinkMsgHandler.getExecutorSize()"})
  void testGetExecutorSize() {
    // Arrange
    when(lwM2MTransportServerConfig.getUplinkPoolSize()).thenReturn(3);

    // Act
    int actualExecutorSize = defaultLwM2mUplinkMsgHandler.getExecutorSize();

    // Assert
    verify(lwM2MTransportServerConfig).getUplinkPoolSize();
    assertEquals(3, actualExecutorSize);
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onSleepingDev(Registration)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#asleep(LwM2mClient)} return
   *       {@code true}.
   *   <li>Then calls {@link Registration#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onSleepingDev(Registration)}
   */
  @Test
  @DisplayName(
      "Test onSleepingDev(Registration); given LwM2mClientContext asleep(LwM2mClient) return 'true'; then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onSleepingDev(Registration)"})
  void testOnSleepingDev_givenLwM2mClientContextAsleepReturnTrue_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mClientContext.asleep(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");

    // Act
    defaultLwM2mUplinkMsgHandler.onSleepingDev(registration);

    // Assert
    verify(registration, atLeast(1)).getEndpoint();
    verify(registration).getId();
    verify(lwM2mClientContext).asleep(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String,
   * ReadResponse)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String,
   * ReadResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadResponse(Registration, String, ReadResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(Registration, String, ReadResponse)"
  })
  void testOnUpdateValueAfterReadResponse() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    CancelObservationResponse response = mock(CancelObservationResponse.class);
    when(response.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(registration, "Path", response);

    // Assert
    verify(response).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"
  })
  void testOnUpdateValueAfterReadCompositeResponse() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"
  })
  void testOnUpdateValueAfterReadCompositeResponse2() throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(false);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(mock(LwM2mClient.class));
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1), mock(LwM2mNode.class));

    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getCode()).thenReturn(ResponseCode.fromCode(1));
    when(response.getContent()).thenReturn(lwM2mPathLwM2mNodeMap);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response).getCode();
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    verify(lwM2mClientContext, atLeast(1)).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}.
   *
   * <ul>
   *   <li>Given fromCode one.
   *   <li>Then calls {@link CancelCompositeObservationResponse#getCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}
   */
  @Test
  @DisplayName(
      "Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse); given fromCode one; then calls getCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"
  })
  void testOnUpdateValueAfterReadCompositeResponse_givenFromCodeOne_thenCallsGetCode()
      throws InvalidLwM2mPathException {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1), mock(LwM2mNode.class));

    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getCode()).thenReturn(ResponseCode.fromCode(1));
    when(response.getContent()).thenReturn(lwM2mPathLwM2mNodeMap);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response).getCode();
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration,
   * ReadCompositeResponse)}
   */
  @Test
  @DisplayName(
      "Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"
  })
  void testOnUpdateValueAfterReadCompositeResponse_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onErrorObservation(Registration, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Registration#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onErrorObservation(Registration,
   * String)}
   */
  @Test
  @DisplayName("Test onErrorObservation(Registration, String); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onErrorObservation(Registration, String)"})
  void testOnErrorObservation_thenCallsGetEndpoint() {
    // Arrange
    doNothing()
        .when(lwM2MTelemetryLogService)
        .log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.onErrorObservation(registration, "An error occurred");

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    verify(lwM2MTelemetryLogService).log(isA(LwM2mClient.class), eq("error: An error occurred"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest() throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1), mock(LwM2mNode.class));

    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest2() throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mIncompletePath(1), mock(LwM2mNode.class));

    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest3() throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mIncompletePath(1, 1), mock(LwM2mNode.class));

    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest4() throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1, 1), mock(LwM2mNode.class));

    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link LwM2mIncompletePath} is {@link LwM2mNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName(
      "Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashMap() LwM2mIncompletePath is LwM2mNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest_givenHashMapLwM2mIncompletePathIsLwM2mNode() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(mock(LwM2mIncompletePath.class), mock(LwM2mNode.class));

    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link LwM2mPath#LwM2mPath(String)} with path is {@code
   *       /} is {@link LwM2mNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName(
      "Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashMap() LwM2mPath(String) with path is '/' is LwM2mNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest_givenHashMapLwM2mPathWithPathIsSlashIsLwM2mNode()
      throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath("/"), mock(LwM2mNode.class));

    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link TimestampedLwM2mNodes#getNodesAt(Instant)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName(
      "Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashMap(); when 'null'; then calls getNodesAt(Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest_givenHashMap_whenNull_thenCallsGetNodesAt() {
    // Arrange
    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(new HashMap<>());
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(null, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration,
   * TimestampedLwM2mNodes)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link TimestampedLwM2mNodes#getTimestamps()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName(
      "Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashSet(); when 'null'; then calls getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"
  })
  void testOnUpdateValueWithSendRequest_givenHashSet_whenNull_thenCallsGetTimestamps() {
    // Arrange
    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getTimestamps()).thenReturn(new HashSet<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(null, data);

    // Assert
    verify(data).getTimestamps();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile() {
    // Arrange
    when(lwM2mClientContext.getLwM2mClients()).thenThrow(new RuntimeException());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile2() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile3() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_givenArrayListAddNull() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(null);
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getLwM2mClients()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; then calls getLwM2mClients()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_thenCallsGetLwM2mClients() {
    // Arrange
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; then calls getProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_thenCallsGetProfileId() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());

    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(lwM2mClient);
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClient, atLeast(1)).getProfileId();
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt() {
    // Arrange
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt2() {
    // Arrange
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any()))
        .thenThrow(new RuntimeException());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt3() {
    // Arrange
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any())).thenReturn(null);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt4() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getProfileId()).thenThrow(new RuntimeException());
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any())).thenReturn(lwM2mClient);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.empty();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(lwM2mClient).getProfileId();
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt5() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());
    doNothing()
        .when(lwM2mClient)
        .onDeviceUpdate(Mockito.<Device>any(), Mockito.<Optional<DeviceProfile>>any());
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(new Lwm2mDeviceProfileTransportConfiguration());
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any())).thenReturn(lwM2mClient);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.empty();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(lwM2mClient).getProfileId();
    verify(lwM2mClient).onDeviceUpdate(isA(Device.class), isA(Optional.class));
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt6() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any())).thenThrow(new RuntimeException());
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any())).thenReturn(lwM2mClient);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.empty();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(lwM2mClient).getProfileId();
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'; then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenThrow(new RuntimeException());
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any())).thenReturn(lwM2mClient);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> newDeviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, device, newDeviceProfileOpt);

    // Assert
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(SessionInfoProto, Device, Optional)}
   * with {@code sessionInfo}, {@code device}, {@code newDeviceProfileOpt}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceUpdate(TransportProtos.SessionInfoProto, Device,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, Device, Optional) with 'sessionInfo', 'device', 'newDeviceProfileOpt'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)"
  })
  void testOnDeviceUpdateWithSessionInfoDeviceNewDeviceProfileOpt_whenNull() {
    // Arrange
    when(lwM2mClientContext.getClientByDeviceId(Mockito.<UUID>any()))
        .thenReturn(mock(LwM2mClient.class));
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceUpdate(sessionInfo, new Device(), null);

    // Assert
    verify(lwM2mClientContext).getClientByDeviceId(isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName("Test onResourceUpdate(ResourceUpdateMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg)"
  })
  void testOnResourceUpdate() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName("Test onResourceUpdate(ResourceUpdateMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg)"
  })
  void testOnResourceUpdate2() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#updateResourceModel(String, LwM2mModelProvider)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test onResourceUpdate(ResourceUpdateMsg); then calls updateResourceModel(String, LwM2mModelProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg)"
  })
  void testOnResourceUpdate_thenCallsUpdateResourceModel() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing()
        .when(lwM2mClient)
        .updateResourceModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any());

    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(lwM2mClient);
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClient).updateResourceModel(eq(""), isA(LwM2mModelProvider.class));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceUpdate(ResourceUpdateMsg)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link LwM2mVersionedModelProvider#evict(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceUpdate(TransportProtos.ResourceUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test onResourceUpdate(ResourceUpdateMsg); when DefaultInstance; then calls evict(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceUpdate(TransportProtos.ResourceUpdateMsg)"
  })
  void testOnResourceUpdate_whenDefaultInstance_thenCallsEvict() {
    // Arrange
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceUpdate(ResourceUpdateMsg.getDefaultInstance());

    // Assert
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName("Test onResourceDelete(ResourceDeleteMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg)"
  })
  void testOnResourceDelete() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(ResourceDeleteMsg.getDefaultInstance());

    // Assert
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName("Test onResourceDelete(ResourceDeleteMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg)"
  })
  void testOnResourceDelete2() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(ResourceDeleteMsg.getDefaultInstance());

    // Assert
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   *
   * <ul>
   *   <li>Given {@code Resource Key}.
   *   <li>Then calls {@link TransportProtos.ResourceDeleteMsg#getResourceKey()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName(
      "Test onResourceDelete(ResourceDeleteMsg); given 'Resource Key'; then calls getResourceKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg)"
  })
  void testOnResourceDelete_givenResourceKey_thenCallsGetResourceKey() {
    // Arrange
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    ResourceDeleteMsg resourceDeleteMsgOpt = mock(ResourceDeleteMsg.class);
    when(resourceDeleteMsgOpt.getResourceKey()).thenReturn("Resource Key");
    when(resourceDeleteMsgOpt.getTenantIdLSB()).thenReturn(1L);
    when(resourceDeleteMsgOpt.getTenantIdMSB()).thenReturn(1L);

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(resourceDeleteMsgOpt);

    // Assert
    verify(resourceDeleteMsgOpt).getResourceKey();
    verify(resourceDeleteMsgOpt).getTenantIdLSB();
    verify(resourceDeleteMsgOpt).getTenantIdMSB();
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq("Resource Key"));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#deleteResources(String, LwM2mModelProvider)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName(
      "Test onResourceDelete(ResourceDeleteMsg); then calls deleteResources(String, LwM2mModelProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg)"
  })
  void testOnResourceDelete_thenCallsDeleteResources() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doNothing()
        .when(lwM2mClient)
        .deleteResources(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any());

    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(lwM2mClient);
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    ResourceDeleteMsg resourceDeleteMsgOpt = mock(ResourceDeleteMsg.class);
    when(resourceDeleteMsgOpt.getResourceKey()).thenReturn("Resource Key");
    when(resourceDeleteMsgOpt.getTenantIdLSB()).thenReturn(1L);
    when(resourceDeleteMsgOpt.getTenantIdMSB()).thenReturn(1L);

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(resourceDeleteMsgOpt);

    // Assert
    verify(resourceDeleteMsgOpt).getResourceKey();
    verify(resourceDeleteMsgOpt).getTenantIdLSB();
    verify(resourceDeleteMsgOpt).getTenantIdMSB();
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq("Resource Key"));
    verify(lwM2mClient).deleteResources(eq("Resource Key"), isA(LwM2mModelProvider.class));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onResourceDelete(ResourceDeleteMsg)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link LwM2mVersionedModelProvider#evict(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onResourceDelete(TransportProtos.ResourceDeleteMsg)}
   */
  @Test
  @DisplayName(
      "Test onResourceDelete(ResourceDeleteMsg); when DefaultInstance; then calls evict(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onResourceDelete(TransportProtos.ResourceDeleteMsg)"
  })
  void testOnResourceDelete_whenDefaultInstance_thenCallsEvict() {
    // Arrange
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    doNothing()
        .when(lwM2mVersionedModelProvider)
        .evict(Mockito.<TenantId>any(), Mockito.<String>any());

    // Act
    defaultLwM2mUplinkMsgHandler.onResourceDelete(ResourceDeleteMsg.getDefaultInstance());

    // Assert
    verify(lwM2mVersionedModelProvider).evict(isA(TenantId.class), eq(""));
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#awake(LwM2mClient)} return
   *       {@code true}.
   *   <li>Then calls {@link Registration#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}
   */
  @Test
  @DisplayName(
      "Test onAwakeDev(Registration); given LwM2mClientContext awake(LwM2mClient) return 'true'; then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onAwakeDev(Registration)"})
  void testOnAwakeDev_givenLwM2mClientContextAwakeReturnTrue_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");

    // Act
    defaultLwM2mUplinkMsgHandler.onAwakeDev(registration);

    // Assert
    verify(registration, atLeast(1)).getEndpoint();
    verify(registration).getId();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry() {
    // Arrange
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(new Lwm2mDeviceProfileTransportConfiguration());

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry2() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry3() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} addAll {@link ArrayList#ArrayList()}.
   *   <li>When {@code Path}.
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given HashSet() addAll ArrayList(); when 'Path'; then calls getProfile(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenHashSetAddAllArrayList_whenPath_thenCallsGetProfile() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("");
    attribute.addAll(new ArrayList<>());
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add empty string.
   *   <li>When {@code Path}.
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add empty string; when 'Path'; then calls getProfile(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenHashSetAddEmptyString_whenPath_thenCallsGetProfile() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("UpdateAttrTelemetry paths [{}]");

    HashSet<String> telemetry = new HashSet<>();
    telemetry.add("");
    telemetry.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Path}.
   *   <li>When {@code Path}.
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'Path'; when 'Path'; then calls getProfile(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenHashSetAddPath_whenPath_thenCallsGetProfile() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("Path");
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code UpdateAttrTelemetry paths [{}]}.
   *   <li>When {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'UpdateAttrTelemetry paths [{}]'; when 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenHashSetAddUpdateAttrTelemetryPaths_whenPath() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code UpdateAttrTelemetry}.
   *   <li>When {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'UpdateAttrTelemetry'; when 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenHashSetAddUpdateAttrTelemetry_whenPath() {
    // Arrange
    HashSet<String> telemetry = new HashSet<>();
    telemetry.add("UpdateAttrTelemetry");
    telemetry.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#getProfile(Registration)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given LwM2mClientContext getProfile(Registration) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenLwM2mClientContextGetProfileReturnNull() {
    // Arrange
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any())).thenReturn(null);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null,
        "UpdateAttrTelemetry paths [{}]",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#getProfile(Registration)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given LwM2mClientContext getProfile(Registration) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenLwM2mClientContextGetProfileThrowRuntimeException() {
    // Arrange
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenThrow(new RuntimeException());

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link TelemetryMappingConfiguration#TelemetryMappingConfiguration()} Attribute is
   *       {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration,
   * String, Instant)}
   */
  @Test
  @DisplayName(
      "Test updateAttrTelemetry(Registration, String, Instant); given TelemetryMappingConfiguration() Attribute is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"
  })
  void testUpdateAttrTelemetry_givenTelemetryMappingConfigurationAttributeIsHashSet() {
    // Arrange
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration();
    observeAttr.setAttribute(new HashSet<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(
        null, "Path", LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String,
   * CreateRequest)}.
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient,
   * String, CreateRequest)}
   */
  @Test
  @DisplayName("Test onCreateResponseOk(LwM2mClient, String, CreateRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    ArrayList<LwM2mObjectInstance> lwM2mObjectInstanceList = new ArrayList<>();
    lwM2mObjectInstanceList.add(new LwM2mObjectInstance(new ArrayList<>()));
    lwM2mObjectInstanceList.add(new LwM2mObjectInstance(new ArrayList<>()));

    CreateRequest request = mock(CreateRequest.class);
    when(request.getObjectInstances()).thenReturn(lwM2mObjectInstanceList);

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path", request);

    // Assert
    verify(request, atLeast(1)).getObjectInstances();
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String,
   * CreateRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link CreateRequest#getObjectInstances()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient,
   * String, CreateRequest)}
   */
  @Test
  @DisplayName(
      "Test onCreateResponseOk(LwM2mClient, String, CreateRequest); given ArrayList(); then calls getObjectInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk_givenArrayList_thenCallsGetObjectInstances() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    CreateRequest request = mock(CreateRequest.class);
    when(request.getObjectInstances()).thenReturn(new ArrayList<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path", request);

    // Assert
    verify(request, atLeast(1)).getObjectInstances();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String,
   * CreateRequest)}.
   *
   * <ul>
   *   <li>When {@link LwM2mObjectInstance#LwM2mObjectInstance(Collection)} with resources is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient,
   * String, CreateRequest)}
   */
  @Test
  @DisplayName(
      "Test onCreateResponseOk(LwM2mClient, String, CreateRequest); when LwM2mObjectInstance(Collection) with resources is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk_whenLwM2mObjectInstanceWithResourcesIsArrayList() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    CreateRequest request = new CreateRequest(1, new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path", request);

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}
   */
  @Test
  @DisplayName("Test getSessionInfoOrCloseSession(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.SessionInfoProto DefaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(Registration)"
  })
  void testGetSessionInfoOrCloseSession() {
    // Arrange
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    SessionInfoProto actualSessionInfoOrCloseSession =
        defaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    assertNull(actualSessionInfoOrCloseSession);
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}
   */
  @Test
  @DisplayName("Test getSessionInfoOrCloseSession(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.SessionInfoProto DefaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(Registration)"
  })
  void testGetSessionInfoOrCloseSession2() {
    // Arrange
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(null);

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    SessionInfoProto actualSessionInfoOrCloseSession =
        defaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    assertNull(actualSessionInfoOrCloseSession);
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   *
   * <ul>
   *   <li>Given randomUUID.
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName(
      "Test initAttributes(LwM2mClient, boolean); given randomUUID; then calls getProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_givenRandomUUID_thenCallsGetProfileId() {
    // Arrange
    SettableFuture<List<TsKvProto>> delegate = SettableFuture.create();
    ForwardingApiFuture<List<TsKvProto>> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(lwM2MAttributesService.getSharedAttributes(
            Mockito.<LwM2mClient>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    HashMap<String, String> keyName = new HashMap<>();
    keyName.put("Key", "42");
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getProfileId()).thenReturn(UUID.randomUUID());

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(lwM2MClient, true);

    // Assert
    verify(lwM2MAttributesService)
        .getSharedAttributes(isA(LwM2mClient.class), isA(Collection.class));
    verify(lwM2MClient).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName("Test initAttributes(LwM2mClient, boolean); then calls getProfile(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_thenCallsGetProfile() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(lwM2mClientContext).getProfile((UUID) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName(
      "Test initAttributes(LwM2mClient, boolean); then calls getSharedAttributes(LwM2mClient, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_thenCallsGetSharedAttributes() {
    // Arrange
    SettableFuture<List<TsKvProto>> delegate = SettableFuture.create();
    ForwardingApiFuture<List<TsKvProto>> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(lwM2MAttributesService.getSharedAttributes(
            Mockito.<LwM2mClient>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    HashMap<String, String> keyName = new HashMap<>();
    keyName.put("Key", "42");
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(lwM2MAttributesService)
        .getSharedAttributes(isA(LwM2mClient.class), isA(Collection.class));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
  }
}
