package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.eclipse.leshan.core.request.WriteAttributesRequest;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.eclipse.leshan.core.response.WriteAttributesResponse;
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
import org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MCancelObserveCompositeCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MCancelObserveCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultLwM2mDownlinkMsgHandlerDiffblueTest {
  @InjectMocks private DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler;

  @Mock private LwM2MTransportServerConfig lwM2MTransportServerConfig;

  @Mock private LwM2mClientContext lwM2mClientContext;

  @Mock private LwM2mTransportContext lwM2mTransportContext;

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#init()}.
   *
   * <ul>
   *   <li>Given {@link LwM2MTransportServerConfig} {@link
   *       LwM2MTransportServerConfig#getDownlinkPoolSize()} return three.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#init()}
   */
  @Test
  @DisplayName("Test init(); given LwM2MTransportServerConfig getDownlinkPoolSize() return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mDownlinkMsgHandler.init()"})
  void testInit_givenLwM2MTransportServerConfigGetDownlinkPoolSizeReturnThree() {
    // Arrange
    when(lwM2MTransportServerConfig.getDownlinkPoolSize()).thenReturn(3);

    // Act
    defaultLwM2mDownlinkMsgHandler.init();

    // Assert
    verify(lwM2MTransportServerConfig).getDownlinkPoolSize();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#init()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#init()}
   */
  @Test
  @DisplayName("Test init(); then throw InvalidRequestException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mDownlinkMsgHandler.init()"})
  void testInit_thenThrowInvalidRequestException() {
    // Arrange
    when(lwM2MTransportServerConfig.getDownlinkPoolSize()).thenThrow(new InvalidRequestException());

    // Act and Assert
    assertThrows(InvalidRequestException.class, () -> defaultLwM2mDownlinkMsgHandler.init());
    verify(lwM2MTransportServerConfig).getDownlinkPoolSize();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#getExecutorSize()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#getExecutorSize()}
   */
  @Test
  @DisplayName("Test getExecutorSize(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultLwM2mDownlinkMsgHandler.getExecutorSize()"})
  void testGetExecutorSize_thenReturnThree() {
    // Arrange
    when(lwM2MTransportServerConfig.getDownlinkPoolSize()).thenReturn(3);

    // Act
    int actualExecutorSize = defaultLwM2mDownlinkMsgHandler.getExecutorSize();

    // Assert
    verify(lwM2MTransportServerConfig).getDownlinkPoolSize();
    assertEquals(3, actualExecutorSize);
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#getExecutorSize()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#getExecutorSize()}
   */
  @Test
  @DisplayName("Test getExecutorSize(); then throw InvalidRequestException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultLwM2mDownlinkMsgHandler.getExecutorSize()"})
  void testGetExecutorSize_thenThrowInvalidRequestException() {
    // Arrange
    when(lwM2MTransportServerConfig.getDownlinkPoolSize()).thenThrow(new InvalidRequestException());

    // Act and Assert
    assertThrows(
        InvalidRequestException.class, () -> defaultLwM2mDownlinkMsgHandler.getExecutorSize());
    verify(lwM2MTransportServerConfig).getDownlinkPoolSize();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendObserveAllRequest(LwM2mClient, TbLwM2MObserveAllRequest, DownlinkRequestCallback)"
  })
  void testSendObserveAllRequest_thenThrowInvalidRequestException() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    TbLwM2MLatchCallback<TbLwM2MObserveAllRequest, Set<String>> callback =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), null);

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendObserveAllRequest(client, null, callback));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new InvalidRequestException());
    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    String[] versionedIds = new String[] {"1.0.2"};

    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            versionedIds);
    TbLwM2MLatchCallback<TbLwM2MCancelObserveCompositeRequest, Integer> callback2 =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(client, request, callback2);

    // Assert
    verify(client).getEndpoint();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest2() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    String[] versionedIds = new String[] {"1.0.2"};

    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(logService, client2, versionedIds);
    TbLwM2MLatchCallback<TbLwM2MCancelObserveCompositeRequest, Integer> callback2 =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(client, request, callback2);

    // Assert
    verify(lwM2mTransportContext).getServer();
    verify(client).getEndpoint();
    verify(client2).getEndpoint();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest_givenHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    String[] versionedIds = new String[] {"1.0.2"};

    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            versionedIds);
    TbLwM2MLatchCallback<TbLwM2MCancelObserveCompositeRequest, Integer> callback2 =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(client, request, callback2);

    // Assert
    verify(lwM2mTransportContext).getServer();
    verify(client).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getServer()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveCompositeRequest(LwM2mClient,
   * TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback); then calls getServer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest_thenCallsGetServer() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    String[] versionedIds = new String[] {"1.0.2"};

    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            versionedIds);
    TbLwM2MLatchCallback<TbLwM2MCancelObserveCompositeRequest, Integer> callback2 =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(client, request, callback2);

    // Assert
    verify(lwM2mTransportContext).getServer();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(LwM2mClient, TbLwM2MCancelObserveCompositeRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveCompositeRequest_thenThrowIllegalArgumentException() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new IllegalArgumentException());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveCompositeRequest request =
        TbLwM2MCancelObserveCompositeRequest.builder()
            .timeout(10L)
            .versionedIds(new String[] {"1.0.2"})
            .build();
    CountDownLatch countDownLatch = new CountDownLatch(3);
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    String[] versionedIds = new String[] {"1.0.2"};

    TbLwM2MCancelObserveCompositeCallback callback =
        new TbLwM2MCancelObserveCompositeCallback(
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            versionedIds);

    TbLwM2MLatchCallback<TbLwM2MCancelObserveCompositeRequest, Integer> callback2 =
        new TbLwM2MLatchCallback<>(countDownLatch, callback);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2mDownlinkMsgHandler.sendCancelObserveCompositeRequest(
                client, request, callback2));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any()))
        .thenThrow(new InvalidRequestException());
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MDeleteCallback callback =
        new TbLwM2MDeleteCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(client, request, callback);

    // Assert
    verify(client).isValidObjectVersion("42");
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then calls {@link LwM2mClient#isValidObjectVersion(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); given empty string; then calls isValidObjectVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_givenEmptyString_thenCallsIsValidObjectVersion() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MDeleteCallback callback =
        new TbLwM2MDeleteCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(client, request, callback);

    // Assert
    verify(client).isValidObjectVersion("42");
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest,
   * DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mDownlinkMsgHandler#sendDeleteRequest(LwM2mClient,
   * TbLwM2MDeleteRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback); given 'https://config.us-east-2.amazonaws.com'; then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDeleteRequest(LwM2mClient, TbLwM2MDeleteRequest, DownlinkRequestCallback)"
  })
  void testSendDeleteRequest_givenHttpsConfigUsEast2AmazonawsCom_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDeleteRequest request =
        TbLwM2MDeleteRequest.builder().timeout(10L).versionedId("42").build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    TbLwM2MDeleteCallback callback = new TbLwM2MDeleteCallback(logService, client2, "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendDeleteRequest(client, request, callback);

    // Assert
    verify(client2).getEndpoint();
    verify(client).isValidObjectVersion("42");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new InvalidRequestException());
    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCallback callback =
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(client, request, callback);

    // Assert
    verify(client).getEndpoint();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest2() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    TbLwM2MCancelObserveCallback callback =
        new TbLwM2MCancelObserveCallback(logService, client2, "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(client, request, callback);

    // Assert
    verify(lwM2mTransportContext).getServer();
    verify(client).getEndpoint();
    verify(client2).getEndpoint();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest_givenHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCallback callback =
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(client, request, callback);

    // Assert
    verify(lwM2mTransportContext).getServer();
    verify(client).getEndpoint();
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getServer()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mDownlinkMsgHandler#sendCancelObserveRequest(LwM2mClient,
   * TbLwM2MCancelObserveRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName(
      "Test sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback); then calls getServer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest_thenCallsGetServer() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelObserveCallback callback =
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act
    defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(client, request, callback);

    // Assert
    verify(lwM2mTransportContext).getServer();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(LwM2mClient, TbLwM2MCancelObserveRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveRequest_thenThrowIllegalArgumentException() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new IllegalArgumentException());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelObserveRequest request =
        TbLwM2MCancelObserveRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbLwM2MCancelObserveCallback callback =
        new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendCancelObserveRequest(client, request, callback));
    verify(lwM2mTransportContext).getServer();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendCancelObserveAllRequest(LwM2mClient, TbLwM2MCancelAllRequest, DownlinkRequestCallback)"
  })
  void testSendCancelObserveAllRequest_thenThrowInvalidRequestException() {
    // Arrange
    when(lwM2mTransportContext.getServer()).thenThrow(new InvalidRequestException());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbLwM2MCancelAllObserveCallback callback =
        new TbLwM2MCancelAllObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendCancelObserveAllRequest(client, null, callback));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any()))
        .thenThrow(new InvalidRequestException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbLwM2MDiscoverCallback callback =
        new TbLwM2MDiscoverCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(client, request, callback));
    verify(client).isValidObjectVersion("42");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any())).thenReturn(false);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new InvalidRequestException());
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbLwM2MDiscoverCallback callback =
        new TbLwM2MDiscoverCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(client, request, callback));
    verify(client).getEndpoint();
    verify(client).isValidObjectVersion("42");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest_thenCallsGetRegistration() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any())).thenReturn(true);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new InvalidRequestException());
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbLwM2MDiscoverCallback callback =
        new TbLwM2MDiscoverCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(client, request, callback));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion("42");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(LwM2mClient, TbLwM2MDiscoverRequest, DownlinkRequestCallback)"
  })
  void testSendDiscoverRequest_whenBuilderTimeoutTenVersionedId42Build() {
    // Arrange
    when(lwM2mClientContext.isDownlinkAllowed(Mockito.<LwM2mClient>any())).thenReturn(true);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new InvalidRequestException());
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MDiscoverRequest request =
        TbLwM2MDiscoverRequest.builder().timeout(10L).versionedId("42/").build();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbLwM2MDiscoverCallback callback =
        new TbLwM2MDiscoverCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Act and Assert
    assertThrows(
        InvalidRequestException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendDiscoverRequest(client, request, callback));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion("42/");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)"
  })
  void testSendWriteAttributesRequest_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any()))
        .thenThrow(new InvalidRequestException());

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
    TbLwM2MLatchCallback<WriteAttributesRequest, WriteAttributesResponse> callback2 =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(client, request, callback2);

    // Assert
    verify(client2).getEndpoint();
    verify(client).isValidObjectVersion("42");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(LwM2mClient, TbLwM2MWriteAttributesRequest, DownlinkRequestCallback)"
  })
  void testSendWriteAttributesRequest_thenCallsIsValidObjectVersion() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isValidObjectVersion(Mockito.<String>any()))
        .thenThrow(new InvalidRequestException());

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
    TbLwM2MLatchCallback<WriteAttributesRequest, WriteAttributesResponse> callback2 =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    defaultLwM2mDownlinkMsgHandler.sendWriteAttributesRequest(client, request, callback2);

    // Assert
    verify(client).isValidObjectVersion("42");
  }
}
