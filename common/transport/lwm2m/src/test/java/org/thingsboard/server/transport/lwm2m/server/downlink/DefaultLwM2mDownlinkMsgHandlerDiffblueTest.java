package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.CountDownLatch;
import org.eclipse.leshan.core.link.lwm2m.DefaultLwM2mLinkParser;
import org.eclipse.leshan.core.node.codec.DefaultLwM2mDecoder;
import org.eclipse.leshan.core.node.codec.DefaultLwM2mEncoder;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.eclipse.leshan.server.LeshanServer;
import org.eclipse.leshan.server.californium.endpoint.CaliforniumServerEndpointsProvider;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.observation.ObservationService;
import org.eclipse.leshan.server.observation.ObservationServiceImpl;
import org.eclipse.leshan.server.queue.ClientAwakeTimeProvider;
import org.eclipse.leshan.server.registration.Registration;
import org.eclipse.leshan.server.registration.RegistrationDataExtractor;
import org.eclipse.leshan.server.registration.RegistrationIdProvider;
import org.eclipse.leshan.server.security.Authorizer;
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
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MObserveRequest.TbLwM2MObserveRequestBuilder;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MReadRequest.TbLwM2MReadRequestBuilder;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest.TbLwM2MWriteReplaceRequestBuilder;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteUpdateRequest.TbLwM2MWriteUpdateRequestBuilder;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MCancelObserveCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MCancelObserveCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MReadCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MReadCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MWriteResponseCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.rpc.composite.RpcWriteCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemoryRegistrationStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbL2M2MDtlsSessionInMemoryStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2mDownlinkMsgHandlerDiffblueTest {
  @InjectMocks private DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler;

  @InjectMocks private LwM2MTransportServerConfig lwM2MTransportServerConfig;

  @Mock private LwM2mClientContext lwM2mClientContext;

  @Mock private LwM2mTransportContext lwM2mTransportContext;

  @Mock private LwM2mVersionedModelProvider lwM2mVersionedModelProvider;

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendReadRequest(LwM2mClient, TbLwM2MReadRequest,
   * DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendReadRequest(LwM2mClient,
   * TbLwM2MReadRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendReadRequest(LwM2mClient, TbLwM2MReadRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendReadRequest(LwM2mClient, TbLwM2MReadRequest, DownlinkRequestCallback)"
  })
  void testSendReadRequest() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new InvalidRequestException("/"));
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MReadRequestBuilder builderResult = TbLwM2MReadRequest.builder();
    TbLwM2MReadRequest request =
        builderResult
            .requestContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedId("/")
            .build();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendReadRequest(
                client,
                request,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MReadCallback(
                        handler,
                        logService2,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        "42"))));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion(eq("/"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendReadRequest(LwM2mClient, TbLwM2MReadRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendReadRequest(LwM2mClient,
   * TbLwM2MReadRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendReadRequest(LwM2mClient, TbLwM2MReadRequest, DownlinkRequestCallback); then throw InvalidRequestException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendReadRequest(LwM2mClient, TbLwM2MReadRequest, DownlinkRequestCallback)"
  })
  void testSendReadRequest_thenThrowInvalidRequestException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new InvalidRequestException("/"));
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MReadRequestBuilder builderResult = TbLwM2MReadRequest.builder();
    TbLwM2MReadRequest request =
        builderResult
            .requestContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedId("42")
            .build();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendReadRequest(
                client,
                request,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MReadCallback(
                        handler,
                        logService2,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        "42"))));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient,
   * TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add fromCode one.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient,
   * TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback); given LinkedHashSet() add fromCode one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendReadCompositeRequest_givenLinkedHashSetAddFromCodeOne() {
    // Arrange
    LinkedHashSet<ContentFormat> contentFormatSet = new LinkedHashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(1));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(
                client,
                null,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MReadCompositeCallback(
                        handler,
                        logService2,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        new String[] {"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient,
   * TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient,
   * TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback); given LinkedHashSet() add 'null'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendReadCompositeRequest_givenLinkedHashSetAddNull_thenThrowRuntimeException() {
    // Arrange
    LinkedHashSet<ContentFormat> contentFormatSet = new LinkedHashSet<>();
    contentFormatSet.add(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(
                client,
                null,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MReadCompositeCallback(
                        handler,
                        logService2,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        new String[] {"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendObserveRequest(LwM2mClient,
   * TbLwM2MObserveRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendObserveRequest(LwM2mClient,
   * TbLwM2MObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendObserveRequest(LwM2mClient, TbLwM2MObserveRequest, DownlinkRequestCallback); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendObserveRequest(LwM2mClient, TbLwM2MObserveRequest, DownlinkRequestCallback)"
  })
  void testSendObserveRequest_thenThrowIllegalArgumentException() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new IllegalArgumentException("/"));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MObserveRequestBuilder builderResult = TbLwM2MObserveRequest.builder();
    TbLwM2MObserveRequest request =
        builderResult
            .requestContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedId("42")
            .build();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendObserveRequest(
                client,
                request,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MObserveCallback(
                        handler,
                        logService2,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        "42"))));
    verify(lwM2mTransportContext).getServer();
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendObserveRequest(LwM2mClient,
   * TbLwM2MObserveRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>When {@link LwM2MTelemetryLogService} {@link LwM2MTelemetryLogService#log(LwM2mClient,
   *       String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendObserveRequest(LwM2mClient,
   * TbLwM2MObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendObserveRequest(LwM2mClient, TbLwM2MObserveRequest, DownlinkRequestCallback); when LwM2MTelemetryLogService log(LwM2mClient, String) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendObserveRequest(LwM2mClient, TbLwM2MObserveRequest, DownlinkRequestCallback)"
  })
  void testSendObserveRequest_whenLwM2MTelemetryLogServiceLogDoesNothing() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException("/"));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MObserveRequestBuilder builderResult = TbLwM2MObserveRequest.builder();
    TbLwM2MObserveRequest request =
        builderResult
            .requestContentFormat(ContentFormat.fromCode(1))
            .timeout(10L)
            .versionedId("42")
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService2,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    TbLwM2MObserveCallback callback =
        new TbLwM2MObserveCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendObserveRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(lwM2mTransportContext).getServer();
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendObserveAllRequest(LwM2mClient,
   * TbLwM2MObserveAllRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendObserveAllRequest(LwM2mClient,
   * TbLwM2MObserveAllRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendObserveAllRequest(LwM2mClient, TbLwM2MObserveAllRequest, DownlinkRequestCallback); then throw InvalidRequestException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendObserveAllRequest(LwM2mClient, TbLwM2MObserveAllRequest, DownlinkRequestCallback)"
  })
  void testSendObserveAllRequest_thenThrowInvalidRequestException() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException("foo"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendObserveAllRequest(
                client, null, new TbLwM2MLatchCallback<>(new CountDownLatch(1), null)));
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient,
   * TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add fromCode one.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient,
   * TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback); given LinkedHashSet() add fromCode one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendObserveCompositeRequest_givenLinkedHashSetAddFromCodeOne() {
    // Arrange
    LinkedHashSet<ContentFormat> contentFormatSet = new LinkedHashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(1));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(
                client,
                null,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MObserveCompositeCallback(
                        handler,
                        logService2,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        new String[] {"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient,
   * TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient,
   * TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback); given LinkedHashSet() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendObserveCompositeRequest_givenLinkedHashSetAddNull() {
    // Arrange
    LinkedHashSet<ContentFormat> contentFormatSet = new LinkedHashSet<>();
    contentFormatSet.add(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(
                client,
                null,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MObserveCompositeCallback(
                        handler,
                        logService2,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        new String[] {"1.0.2"}))));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest() {
    // Arrange
    when(lwM2mTransportContext.getServer())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserveComposite: {}."));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            new String[] {"1.0.2"});

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest2() {
    // Arrange
    CaliforniumServerEndpointsProvider endpointsProvider = new CaliforniumServerEndpointsProvider();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    Authorizer authorizer = mock(Authorizer.class);
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    DefaultLwM2mEncoder encoder = new DefaultLwM2mEncoder();
    DefaultLwM2mDecoder decoder = new DefaultLwM2mDecoder();
    ClientAwakeTimeProvider awakeTimeProvider = mock(ClientAwakeTimeProvider.class);
    RegistrationIdProvider registrationIdProvider = mock(RegistrationIdProvider.class);
    RegistrationDataExtractor registrationDataExtractor = mock(RegistrationDataExtractor.class);
    when(lwM2mTransportContext.getServer())
        .thenReturn(
            new LeshanServer(
                endpointsProvider,
                registrationStore,
                securityStore,
                authorizer,
                modelProvider,
                encoder,
                decoder,
                true,
                awakeTimeProvider,
                registrationIdProvider,
                registrationDataExtractor,
                true,
                true,
                new DefaultLwM2mLinkParser(),
                null));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            new String[] {"1.0.2"});

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest3() {
    // Arrange
    LeshanServer leshanServer = mock(LeshanServer.class);
    TbInMemoryRegistrationStore store = new TbInMemoryRegistrationStore();
    when(leshanServer.getObservationService())
        .thenReturn(new ObservationServiceImpl(store, new CaliforniumServerEndpointsProvider()));
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            new String[] {"1.0.2"});

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(leshanServer).getObservationService();
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest4() {
    // Arrange
    LeshanServer leshanServer = mock(LeshanServer.class);
    when(leshanServer.getObservationService())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserveComposite: {}."));
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            new String[] {"1.0.2"});

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(leshanServer).getObservationService();
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest5() {
    // Arrange
    ObservationService observationService = mock(ObservationService.class);
    when(observationService.cancelCompositeObservations(
            Mockito.<Registration>any(), Mockito.<String[]>any()))
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserveComposite: {}."));
    LeshanServer leshanServer = mock(LeshanServer.class);
    when(leshanServer.getObservationService()).thenReturn(observationService);
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            new String[] {"1.0.2"});

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(leshanServer).getObservationService();
    verify(observationService).cancelCompositeObservations(isNull(), isA(String[].class));
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback); given 'https://config.us-east-2.amazonaws.com'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest_givenHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserveComposite: {}."));
    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(logService, client2, new String[] {"1.0.2"});

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).getEndpoint();
    verify(client2).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserveComposite: {}."));
    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            new String[] {"1.0.2"});

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest_thenThrowIllegalArgumentException() {
    // Arrange
    when(lwM2mTransportContext.getServer())
        .thenThrow(new IllegalArgumentException("[{}] Send CancelObserveComposite: {}."));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
                client,
                request,
                new TbLwM2MLatchCallback<>(
                    countDownLatch,
                    new TbLwM2MCancelObserveCompositeCallback(
                        logService,
                        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                        new String[] {"1.0.2"}))));
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any()))
        .thenThrow(new InvalidRequestException("/"));
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(
        client,
        request,
        new TbLwM2MDeleteCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); given 'https://config.us-east-2.amazonaws.com'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_givenHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(
        client, request, new TbLwM2MDeleteCallback(logService, client2, "42"));

    // Assert
    verify(client2).getEndpoint();
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#isValidObjectVersion(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); then calls isValidObjectVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_thenCallsIsValidObjectVersion() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(
        client,
        request,
        new TbLwM2MDeleteCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); then throw InvalidRequestException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_thenThrowInvalidRequestException() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("424242").build();
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenThrow(new InvalidRequestException("/"));

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(
                client,
                request,
                new TbLwM2MDeleteCallback(mock(LwM2MTelemetryLogService.class), client2, "42")));
    verify(client2).getEndpoint();
    verify(client).isValidObjectVersion(eq("424242"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>When builder timeout ten versionedId {@code 42/} build.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); when builder timeout ten versionedId '42/' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_whenBuilderTimeoutTenVersionedId42Build() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42/").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(
        client, request, new TbLwM2MDeleteCallback(logService, client2, "42"));

    // Assert
    verify(client2).getEndpoint();
    verify(client).isValidObjectVersion(eq("42/"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>When builder timeout ten versionedId {@code 1.0.2} build.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); when builder timeout ten versionedId '1.0.2' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_whenBuilderTimeoutTenVersionedId102Build() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("1.0.2").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(
        client,
        request,
        new TbLwM2MDeleteCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).isValidObjectVersion(eq("1.0.2"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>When builder timeout ten versionedId {@code /} build.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); when builder timeout ten versionedId '/' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_whenBuilderTimeoutTenVersionedIdSlashBuild() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("/").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(
        client,
        request,
        new TbLwM2MDeleteCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).isValidObjectVersion(eq("/"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest() {
    // Arrange
    when(lwM2mTransportContext.getServer())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserve {}."));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client,
        request,
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest2() {
    // Arrange
    CaliforniumServerEndpointsProvider endpointsProvider = new CaliforniumServerEndpointsProvider();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    Authorizer authorizer = mock(Authorizer.class);
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    DefaultLwM2mEncoder encoder = new DefaultLwM2mEncoder();
    DefaultLwM2mDecoder decoder = new DefaultLwM2mDecoder();
    ClientAwakeTimeProvider awakeTimeProvider = mock(ClientAwakeTimeProvider.class);
    RegistrationIdProvider registrationIdProvider = mock(RegistrationIdProvider.class);
    RegistrationDataExtractor registrationDataExtractor = mock(RegistrationDataExtractor.class);
    when(lwM2mTransportContext.getServer())
        .thenReturn(
            new LeshanServer(
                endpointsProvider,
                registrationStore,
                securityStore,
                authorizer,
                modelProvider,
                encoder,
                decoder,
                true,
                awakeTimeProvider,
                registrationIdProvider,
                registrationDataExtractor,
                true,
                true,
                new DefaultLwM2mLinkParser(),
                null));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client,
        request,
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest3() {
    // Arrange
    LeshanServer leshanServer = mock(LeshanServer.class);
    TbInMemoryRegistrationStore store = new TbInMemoryRegistrationStore();
    when(leshanServer.getObservationService())
        .thenReturn(new ObservationServiceImpl(store, new CaliforniumServerEndpointsProvider()));
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client,
        request,
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(leshanServer).getObservationService();
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest4() {
    // Arrange
    LeshanServer leshanServer = mock(LeshanServer.class);
    when(leshanServer.getObservationService())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserve {}."));
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client,
        request,
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(leshanServer).getObservationService();
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest5() {
    // Arrange
    ObservationServiceImpl observationServiceImpl = mock(ObservationServiceImpl.class);
    when(observationServiceImpl.cancelObservations(
            Mockito.<Registration>any(), Mockito.<String>any()))
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserve {}."));
    LeshanServer leshanServer = mock(LeshanServer.class);
    when(leshanServer.getObservationService()).thenReturn(observationServiceImpl);
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client,
        request,
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(leshanServer).getObservationService();
    verify(observationServiceImpl).cancelObservations(isNull(), eq("42"));
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback); given 'https://config.us-east-2.amazonaws.com'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest_givenHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserve {}."));
    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client, request, new TbLwM2MCancelObserveCallback(logService, client2, "42"));

    // Assert
    verify(client).getEndpoint();
    verify(client2).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(new InvalidRequestException("[{}] Send CancelObserve {}."));
    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client,
        request,
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(client).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback); then calls log(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest_thenCallsLog() {
    // Arrange
    ObservationServiceImpl observationServiceImpl = mock(ObservationServiceImpl.class);
    when(observationServiceImpl.cancelObservations(
            Mockito.<Registration>any(), Mockito.<String>any()))
        .thenReturn(1);
    LeshanServer leshanServer = mock(LeshanServer.class);
    when(leshanServer.getObservationService()).thenReturn(observationServiceImpl);
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
        client,
        request,
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"));

    // Assert
    verify(leshanServer).getObservationService();
    verify(observationServiceImpl).cancelObservations(isNull(), eq("42"));
    verify(lwM2mTransportContext).getServer();
    verify(logService)
        .log(isA(LwM2mClient.class), eq("[info]: Cancel Observe for [42] successful. Result: [1]"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest_thenThrowIllegalArgumentException() {
    // Arrange
    when(lwM2mTransportContext.getServer())
        .thenThrow(new IllegalArgumentException("[{}] Send CancelObserve {}."));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(
                client,
                request,
                new TbLwM2MCancelObserveCallback(
                    logService,
                    new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                    "42")));
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveAllRequest(LwM2mClient,
   * TbLwM2MCancelAllRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LeshanServer#getObservationService()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveAllRequest(LwM2mClient,
   * TbLwM2MCancelAllRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveAllRequest(LwM2mClient, TbLwM2MCancelAllRequest, DownlinkRequestCallback); then calls getObservationService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveAllRequest(LwM2mClient, TbLwM2MCancelAllRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveAllRequest_thenCallsGetObservationService() {
    // Arrange
    ObservationServiceImpl observationServiceImpl = mock(ObservationServiceImpl.class);
    when(observationServiceImpl.cancelObservations(Mockito.<Registration>any())).thenReturn(1);
    LeshanServer leshanServer = mock(LeshanServer.class);
    when(leshanServer.getObservationService()).thenReturn(observationServiceImpl);
    when(lwM2mTransportContext.getServer()).thenReturn(leshanServer);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveAllRequest(
        client,
        null,
        new TbLwM2MCancelAllObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Assert
    verify(leshanServer).getObservationService();
    verify(observationServiceImpl).cancelObservations(isNull());
    verify(lwM2mTransportContext).getServer();
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq("[info]: Cancel of all observations was successful. Result: [1]"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveAllRequest(LwM2mClient,
   * TbLwM2MCancelAllRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveAllRequest(LwM2mClient,
   * TbLwM2MCancelAllRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveAllRequest(LwM2mClient, TbLwM2MCancelAllRequest, DownlinkRequestCallback); then throw InvalidRequestException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveAllRequest(LwM2mClient, TbLwM2MCancelAllRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveAllRequest_thenThrowInvalidRequestException() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException("foo"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendCancelObserveAllRequest(
                client,
                null,
                new TbLwM2MCancelAllObserveCallback(
                    logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))));
    verify(lwM2mTransportContext).getServer();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}.
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any()))
        .thenThrow(new InvalidRequestException("/"));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(
                client,
                request,
                new TbLwM2MDiscoverCallback(
                    logService,
                    new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                    "42")));
    verify(client).isValidObjectVersion(eq("42"));
    verify(lwM2mClientContext).isDownlinkAllowed(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any())).thenReturn(false);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new InvalidRequestException("/"));
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(
                client,
                request,
                new TbLwM2MDiscoverCallback(
                    logService,
                    new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                    "42")));
    verify(client).getEndpoint();
    verify(client).isValidObjectVersion(eq("42"));
    verify(lwM2mClientContext).isDownlinkAllowed(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getRegistration()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback); then calls getRegistration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest_thenCallsGetRegistration() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any())).thenReturn(true);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new InvalidRequestException("/"));
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(
                client,
                request,
                new TbLwM2MDiscoverCallback(
                    logService,
                    new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                    "42")));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion(eq("42"));
    verify(lwM2mClientContext).isDownlinkAllowed(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>When builder timeout ten versionedId {@code 42/} build.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDiscoverRequest(LwM2mClient,
   * TbLwM2MDiscoverRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback); when builder timeout ten versionedId '42/' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest_whenBuilderTimeoutTenVersionedId42Build() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any())).thenReturn(true);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new InvalidRequestException("/"));
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42/").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(
                client,
                request,
                new TbLwM2MDiscoverCallback(
                    logService,
                    new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
                    "42")));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion(eq("42/"));
    verify(lwM2mClientContext).isDownlinkAllowed(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteAttributesRequest(LwM2mClient,
   * TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteAttributesRequest(LwM2mClient,
   * TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)"
  })
  void testSendWriteAttributesRequest_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any()))
        .thenThrow(new InvalidRequestException("/"));

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
    TbLwM2MWriteAttributesRequest request =
        TbLwM2MWriteAttributesRequest.builder()
            .attributes(attributes)
            .timeout(10L)
            .versionedId("42")
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MWriteAttributesCallback callback =
        new TbLwM2MWriteAttributesCallback(logService, client2, "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client2).getEndpoint();
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteAttributesRequest(LwM2mClient,
   * TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#isValidObjectVersion(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteAttributesRequest(LwM2mClient,
   * TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback); then calls isValidObjectVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)"
  })
  void testSendWriteAttributesRequest_thenCallsIsValidObjectVersion() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any()))
        .thenThrow(new InvalidRequestException("/"));

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
    TbLwM2MWriteAttributesRequest request =
        TbLwM2MWriteAttributesRequest.builder()
            .attributes(attributes)
            .timeout(10L)
            .versionedId("42")
            .build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MWriteAttributesCallback callback =
        new TbLwM2MWriteAttributesCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).isValidObjectVersion(eq("42"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteReplaceRequest(LwM2mClient,
   * TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest,
   * DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)"
  })
  void testSendWriteReplaceRequest_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MWriteReplaceRequestBuilder builderResult = TbLwM2MWriteReplaceRequest.builder();
    TbLwM2MWriteReplaceRequest request =
        builderResult
            .contentFormat(ContentFormat.fromCode(1))
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
    TbLwM2MWriteResponseCallback callback =
        new TbLwM2MWriteResponseCallback(
            new DefaultLwM2mUplinkMsgHandler(
                null,
                lwM2mTransportContext,
                null,
                null,
                null,
                lwM2MTransportServerConfig,
                logService2,
                null,
                sessionStore,
                lwM2mClientContext,
                null,
                lwM2mVersionedModelProvider,
                registrationStore,
                null,
                new LwM2MModelConfigServiceImpl()),
            logService,
            client2,
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteReplaceRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client2).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient,
   * RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code
   * rpcWriteCompositeRequest}, {@code callback}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest,
   * DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService2,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback =
        new TbLwM2MWriteResponseCompositeCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(
        client,
        rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: Request [RpcWriteCompositeRequest(nodes={})] processing failed. Reason: java.lang.NullPointerException: Cannot invoke \"java.lang.Iterable.iterator()\" because \"iterable\" is null"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient,
   * RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code
   * rpcWriteCompositeRequest}, {@code callback}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest,
   * DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback2() {
    // Arrange
    LinkedHashSet<ContentFormat> contentFormatSet = new LinkedHashSet<>();
    contentFormatSet.add(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService2,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback =
        new TbLwM2MWriteResponseCompositeCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(
        client,
        rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).getClientSupportContentFormats();
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: Request [RpcWriteCompositeRequest(nodes={})] processing failed. Reason: java.lang.RuntimeException: This device does not support Composite Operation"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient,
   * RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code
   * rpcWriteCompositeRequest}, {@code callback}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest,
   * DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback3() {
    // Arrange
    LinkedHashSet<ContentFormat> contentFormatSet = new LinkedHashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(1));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService2,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback =
        new TbLwM2MWriteResponseCompositeCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(
        client,
        rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).getClientSupportContentFormats();
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: Request [RpcWriteCompositeRequest(nodes={})] processing failed. Reason: java.lang.RuntimeException: This device does not support Composite Operation"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient,
   * RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code
   * rpcWriteCompositeRequest}, {@code callback}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest,
   * DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback4() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats())
        .thenThrow(new InvalidRequestException("This device does not support Composite Operation"));

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService2,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback =
        new TbLwM2MWriteResponseCompositeCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(
        client,
        rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client).getClientSupportContentFormats();
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: Request [RpcWriteCompositeRequest(nodes={})] validation failed. Reason: This device does not support Composite Operation"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient,
   * RpcWriteCompositeRequest, DownlinkRequestCallback)} with {@code client}, {@code
   * rpcWriteCompositeRequest}, {@code callback}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest,
   * DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback) with 'client', 'rpcWriteCompositeRequest', 'callback'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(LwM2mClient, RpcWriteCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendWriteCompositeRequestWithClientRpcWriteCompositeRequestCallback_whenNull() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService2,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCompositeCallback callback =
        new TbLwM2MWriteResponseCompositeCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteCompositeRequest(
        null,
        rpcWriteCompositeRequest,
        new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: Request [RpcWriteCompositeRequest(nodes={})] processing failed. Reason: java.lang.NullPointerException: Cannot invoke \"org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient.getClientSupportContentFormats()\" because \"client\" is null"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient,
   * TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient,
   * TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)"
  })
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
    TbLwM2MWriteResponseCallback callback =
        new TbLwM2MWriteResponseCallback(
            new DefaultLwM2mUplinkMsgHandler(
                null,
                lwM2mTransportContext,
                null,
                null,
                null,
                lwM2MTransportServerConfig,
                logService2,
                null,
                sessionStore,
                lwM2mClientContext,
                null,
                lwM2mVersionedModelProvider,
                registrationStore,
                null,
                new LwM2MModelConfigServiceImpl()),
            logService,
            client2,
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(
        client, null, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client2).getEndpoint();
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: Request [] validation failed. Reason: Cannot invoke \"org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteUpdateRequest.getObjectId()\" because \"request\" is null"));
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient,
   * TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient,
   * TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)"
  })
  void testSendWriteUpdateRequest_thenCallsGetEndpoint2() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TbLwM2MWriteUpdateRequestBuilder builderResult = TbLwM2MWriteUpdateRequest.builder();
    TbLwM2MWriteUpdateRequest request =
        builderResult
            .objectContentFormat(ContentFormat.fromCode(1))
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
    TbLwM2MWriteResponseCallback callback =
        new TbLwM2MWriteResponseCallback(
            new DefaultLwM2mUplinkMsgHandler(
                null,
                lwM2mTransportContext,
                null,
                null,
                null,
                lwM2MTransportServerConfig,
                logService2,
                null,
                sessionStore,
                lwM2mClientContext,
                null,
                lwM2mVersionedModelProvider,
                registrationStore,
                null,
                new LwM2MModelConfigServiceImpl()),
            logService,
            client2,
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(
        client, request, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(client2).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient,
   * TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendWriteUpdateRequest(LwM2mClient,
   * TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback); when 'null'; then calls log(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(LwM2mClient, TbLwM2MWriteUpdateRequest, DownlinkRequestCallback)"
  })
  void testSendWriteUpdateRequest_whenNull_thenCallsLog() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler handler =
        new DefaultLwM2mUplinkMsgHandler(
            null,
            lwM2mTransportContext,
            null,
            null,
            null,
            lwM2MTransportServerConfig,
            logService2,
            null,
            sessionStore,
            lwM2mClientContext,
            null,
            lwM2mVersionedModelProvider,
            registrationStore,
            null,
            new LwM2MModelConfigServiceImpl());

    TbLwM2MWriteResponseCallback callback =
        new TbLwM2MWriteResponseCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteUpdateRequest(
        client, null, new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback));

    // Assert
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: Request [] validation failed. Reason: Cannot invoke \"org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteUpdateRequest.getObjectId()\" because \"request\" is null"));
  }
}
