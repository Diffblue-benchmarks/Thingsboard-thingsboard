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
package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.exception.ClientSleepingException;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MReadCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MReadCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MWriteResponseCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.rpc.composite.RpcWriteCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemoryRegistrationStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbL2M2MDtlsSessionInMemoryStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2mDownlinkMsgHandlerDiffblueTest {
  @InjectMocks
  private DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler;

  @Mock
  private LwM2mClientContext lwM2mClientContext;

  @InjectMocks
  private LwM2MTransportServerConfig lwM2MTransportServerConfig;

  @Mock
  private LwM2mTransportContext lwM2mTransportContext;

  @Mock
  private LwM2mVersionedModelProvider lwM2mVersionedModelProvider;

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add fromCode two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback); given HashSet() add fromCode two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)"})
  void testSendReadCompositeRequest_givenHashSetAddFromCodeTwo() {
    // Arrange
    HashSet<ContentFormat> contentFormatSet = new HashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(2));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(client, null,
            new TbLwM2MLatchCallback<>(countDownLatch, new TbLwM2MReadCompositeCallback(handler, logService2,
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), new String[]{"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback); given HashSet(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)"})
  void testSendReadCompositeRequest_givenHashSet_thenThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(new HashSet<>());
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(client, null,
            new TbLwM2MLatchCallback<>(countDownLatch, new TbLwM2MReadCompositeCallback(handler, logService2,
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), new String[]{"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add fromCode two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback); given HashSet() add fromCode two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)"})
  void testSendObserveCompositeRequest_givenHashSetAddFromCodeTwo() {
    // Arrange
    HashSet<ContentFormat> contentFormatSet = new HashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(2));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(client, null,
            new TbLwM2MLatchCallback<>(countDownLatch, new TbLwM2MObserveCompositeCallback(handler, logService2,
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), new String[]{"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback); given HashSet(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)"})
  void testSendObserveCompositeRequest_givenHashSet_thenThrowRuntimeException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(new HashSet<>());
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(client, null,
            new TbLwM2MLatchCallback<>(countDownLatch, new TbLwM2MObserveCompositeCallback(handler, logService2,
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), new String[]{"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link LwM2mClient#isValidObjectVersion(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); given empty string; then calls isValidObjectVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"})
  void testSendDeleteRequest_givenEmptyString_thenCallsIsValidObjectVersion() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(client, request,
        new TbLwM2MDeleteCallback(logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.</li>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); given 'https://config.us-east-2.amazonaws.com'; then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"})
  void testSendDeleteRequest_givenHttpsConfigUsEast2AmazonawsCom_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(client, request,
        new TbLwM2MDeleteCallback(logService, client2, "42"));

    // Assert
    verify(client2).getEndpoint();
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>When builder timeout ten versionedId {@code 1.0.2} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); when builder timeout ten versionedId '1.0.2' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"})
  void testSendDeleteRequest_whenBuilderTimeoutTenVersionedId102Build() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("1.0.2").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(client, request,
        new TbLwM2MDeleteCallback(logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).isValidObjectVersion(eq("1.0.2"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>When builder timeout ten versionedId {@code /} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); when builder timeout ten versionedId '/' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"})
  void testSendDeleteRequest_whenBuilderTimeoutTenVersionedIdSlashBuild() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request = TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("/").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(client, request,
        new TbLwM2MDeleteCallback(logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).isValidObjectVersion(eq("/"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Then throw {@link ClientSleepingException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback); then throw ClientSleepingException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"})
  void testSendDiscoverRequest_thenThrowClientSleepingException() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any())).thenReturn(true);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new ClientSleepingException("An error occurred", "Args"));
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request = TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(ClientSleepingException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(client, request, new TbLwM2MDiscoverCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42")));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion(eq("42"));
    verify(lwM2mClientContext).isDownlinkAllowed(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#isValidObjectVersion(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback); then calls isValidObjectVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)"})
  void testSendWriteAttributesRequest_thenCallsIsValidObjectVersion() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenThrow(new InvalidRequestException("/"));

    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");
    TbLwM2MWriteAttributesRequest request = TbLwM2MWriteAttributesRequest.builder()
        .attributes(attributes)
        .timeout(10L)
        .versionedId("42")
        .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MWriteAttributesCallback callback = new TbLwM2MWriteAttributesCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(client, request,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)"})
  void testSendWriteReplaceRequest_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MWriteReplaceRequestBuilder builderResult = TbLwM2MWriteReplaceRequest.builder();
    TbLwM2MWriteReplaceRequest request = builderResult.contentFormat(ContentFormat.fromCode(1))
        .timeout(10L)
        .value("Value")
        .versionedId("42")
        .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    TbLwM2MWriteResponseCallback callback = new TbLwM2MWriteResponseCallback(
        new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null, null, lwM2MTransportServerConfig,
            logService2, null, sessionStore, lwM2mClientContext, null, lwM2mVersionedModelProvider, registrationStore,
            null, new LwM2MModelConfigServiceImpl()),
        logService, client2, "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteReplaceRequest(client, request,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client2).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code rpcWriteCompositeRequest}, {@code callback}.
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"})
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(new HashSet<>());

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService2, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback = new TbLwM2MWriteResponseCompositeCallback(handler, logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(client, rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).getClientSupportContentFormats();
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: Request [RpcWriteCompositeRequest(nodes={})] processing failed. Reason: java.lang.RuntimeException: This device does not support Composite Operation"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code rpcWriteCompositeRequest}, {@code callback}.
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"})
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback2() {
    // Arrange
    HashSet<ContentFormat> contentFormatSet = new HashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(2));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService2, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback = new TbLwM2MWriteResponseCompositeCallback(handler, logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(client, rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).getClientSupportContentFormats();
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: Request [RpcWriteCompositeRequest(nodes={})] processing failed. Reason: java.lang.RuntimeException: This device does not support Composite Operation"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code rpcWriteCompositeRequest}, {@code callback}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"})
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback_whenNull() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService2, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback = new TbLwM2MWriteResponseCompositeCallback(handler, logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(null, rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: Request [RpcWriteCompositeRequest(nodes={})] processing failed. Reason: java.lang.NullPointerException: Cannot invoke \"org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient.getClientSupportContentFormats()\" because \"client\" is null"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)"})
  void testSendWriteUpdateRequest_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    TbLwM2MWriteResponseCallback callback = new TbLwM2MWriteResponseCallback(
        new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null, null, lwM2MTransportServerConfig,
            logService2, null, sessionStore, lwM2mClientContext, null, lwM2mVersionedModelProvider, registrationStore,
            null, new LwM2MModelConfigServiceImpl()),
        logService, client2, "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(client, null,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client2).getEndpoint();
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: Request [] validation failed. Reason: Cannot invoke \"org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteUpdateRequest.getObjectId()\" because \"request\" is null"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback); when 'null'; then calls log(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)"})
  void testSendWriteUpdateRequest_whenNull_thenCallsLog() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(null, lwM2mTransportContext, null, null,
        null, lwM2MTransportServerConfig, logService2, null, sessionStore, lwM2mClientContext, null,
        lwM2mVersionedModelProvider, registrationStore, null, new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCallback callback = new TbLwM2MWriteResponseCallback(handler, logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(client, null,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: Request [] validation failed. Reason: Cannot invoke \"org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteUpdateRequest.getObjectId()\" because \"request\" is null"));
  }
}
