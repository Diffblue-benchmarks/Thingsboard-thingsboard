package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.ssl.JdkSslClientContext;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.net.ssl.SSLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.credentials.ClientCredentials;
import org.thingsboard.rule.engine.credentials.CredentialsType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import reactor.core.publisher.Mono;

class TbHttpClientDiffblueTest {
  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName("Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient() throws SSLException, TbNodeException {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.initSslContext()).thenThrow(new SSLException("Just cause"));

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(false);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(credentials);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> new TbHttpClient(config, new DefaultEventLoop()));
    verify(credentials).initSslContext();
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Given {@code 25001}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given '25001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_given25001() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(false);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(null);
    config.setMaxInMemoryBufferSizeInKb(25001);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> new TbHttpClient(config, new DefaultEventLoop()));
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Given {@link ClientCredentials} {@link ClientCredentials#getType()} return {@link
   *       CredentialsType#CERT_PEM}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given ClientCredentials getType() return CERT_PEM")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_givenClientCredentialsGetTypeReturnCert_pem() throws TbNodeException {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.CERT_PEM);

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(true);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(credentials);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> new TbHttpClient(config, new DefaultEventLoop()));
    verify(credentials).getType();
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Given {@link ClientCredentials} {@link ClientCredentials#getType()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given ClientCredentials getType() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_givenClientCredentialsGetTypeThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenThrow(new RuntimeException());

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(true);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(credentials);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new TbHttpClient(config, new DefaultEventLoop()));
    verify(credentials).getType();
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Given {@link ClientCredentials} {@link ClientCredentials#initSslContext()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given ClientCredentials initSslContext() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_givenClientCredentialsInitSslContextThrowRuntimeException()
      throws SSLException, TbNodeException {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.initSslContext()).thenThrow(new RuntimeException());

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(false);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(credentials);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new TbHttpClient(config, new DefaultEventLoop()));
    verify(credentials).initSslContext();
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return EventLoopGroup is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given 'null'; then return EventLoopGroup is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_givenNull_thenReturnEventLoopGroupIsNull() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(false);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(null);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act
    TbHttpClient actualTbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Assert
    assertNull(actualTbHttpClient.getEventLoopGroup());
    assertNull(actualTbHttpClient.getSemaphore());
    assertSame(config, actualTbHttpClient.getConfig());
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return Semaphore QueueLength is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given three; then return Semaphore QueueLength is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_givenThree_thenReturnSemaphoreQueueLengthIsZero()
      throws SSLException, TbNodeException {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.initSslContext()).thenReturn(new JdkSslClientContext());

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(3);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(false);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(credentials);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act
    TbHttpClient actualTbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Assert
    verify(credentials).initSslContext();
    Semaphore semaphore = actualTbHttpClient.getSemaphore();
    assertEquals(0, semaphore.getQueueLength());
    assertEquals(3, actualTbHttpClient.getConfig().getMaxParallelRequestsCount());
    assertFalse(semaphore.hasQueuedThreads());
    assertFalse(semaphore.isFair());
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Then return Config UseSimpleClientHttpFactory.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); then return Config UseSimpleClientHttpFactory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_thenReturnConfigUseSimpleClientHttpFactory() throws TbNodeException {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.ANONYMOUS);

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(true);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(credentials);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act
    TbHttpClient actualTbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Assert
    verify(credentials).getType();
    TbRestApiCallNodeConfiguration config2 = actualTbHttpClient.getConfig();
    assertEquals("", config2.getProxyHost());
    assertNull(config2.getProxyPassword());
    assertNull(config2.getProxyScheme());
    assertNull(config2.getProxyUser());
    assertNull(config2.getRequestMethod());
    assertNull(config2.getRestEndpointUrlPattern());
    assertNull(config2.getHeaders());
    assertEquals(0, config2.getMaxParallelRequestsCount());
    assertEquals(0, config2.getProxyPort());
    assertEquals(0, config2.getReadTimeoutMs());
    assertEquals(25000, config2.getMaxInMemoryBufferSizeInKb());
    assertFalse(config2.isEnableProxy());
    assertFalse(config2.isIgnoreRequestBody());
    assertFalse(config2.isParseToPlainText());
    assertFalse(config2.isUseSystemProxyProperties());
    assertTrue(config2.isUseSimpleClientHttpFactory());
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Then return not Config UseSimpleClientHttpFactory.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); then return not Config UseSimpleClientHttpFactory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_thenReturnNotConfigUseSimpleClientHttpFactory()
      throws SSLException, TbNodeException {
    // Arrange
    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.initSslContext()).thenReturn(new JdkSslClientContext());

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(false);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(false);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(credentials);
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act
    TbHttpClient actualTbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Assert
    verify(credentials).initSslContext();
    TbRestApiCallNodeConfiguration config2 = actualTbHttpClient.getConfig();
    assertEquals("", config2.getProxyHost());
    assertNull(config2.getProxyPassword());
    assertNull(config2.getProxyScheme());
    assertNull(config2.getProxyUser());
    assertNull(config2.getRequestMethod());
    assertNull(config2.getRestEndpointUrlPattern());
    assertNull(config2.getHeaders());
    assertEquals(0, config2.getMaxParallelRequestsCount());
    assertEquals(0, config2.getProxyPort());
    assertEquals(0, config2.getReadTimeoutMs());
    assertEquals(25000, config2.getMaxInMemoryBufferSizeInKb());
    assertFalse(config2.isEnableProxy());
    assertFalse(config2.isIgnoreRequestBody());
    assertFalse(config2.isParseToPlainText());
    assertFalse(config2.isUseSimpleClientHttpFactory());
    assertFalse(config2.isUseSystemProxyProperties());
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_thenThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(0);
    config.setEnableProxy(true);
    config.setUseSystemProxyProperties(false);
    config.setUseSimpleClientHttpFactory(false);
    config.setProxyHost("");
    config.setProxyPort(0);
    config.setCredentials(mock(ClientCredentials.class));
    config.setMaxInMemoryBufferSizeInKb(25000);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new TbHttpClient(config, new DefaultEventLoop()));
  }

  /**
   * Test {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup)}.
   *
   * <ul>
   *   <li>When {@link TbRestApiCallNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); when TbRestApiCallNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_whenTbRestApiCallNodeConfiguration() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();

    // Act
    TbHttpClient actualTbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Assert
    assertNull(actualTbHttpClient.getEventLoopGroup());
    assertNull(actualTbHttpClient.getSemaphore());
    assertSame(config, actualTbHttpClient.getConfig());
  }

  /**
   * Test {@link TbHttpClient#getSharedOrCreateEventLoopGroup(EventLoopGroup)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#getSharedOrCreateEventLoopGroup(EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test getSharedOrCreateEventLoopGroup(EventLoopGroup); then return DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventLoopGroup TbHttpClient.getSharedOrCreateEventLoopGroup(EventLoopGroup)"})
  void testGetSharedOrCreateEventLoopGroup_thenReturnDefaultEventLoop() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    DefaultEventLoop eventLoopGroupShared = new DefaultEventLoop();

    // Act
    EventLoopGroup actualSharedOrCreateEventLoopGroup =
        tbHttpClient.getSharedOrCreateEventLoopGroup(eventLoopGroupShared);

    // Assert
    assertSame(eventLoopGroupShared, actualSharedOrCreateEventLoopGroup);
  }

  /**
   * Test {@link TbHttpClient#destroy()}.
   *
   * <p>Method under test: {@link TbHttpClient#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.destroy()"})
  void testDestroy() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setEventLoopGroup(new DefaultEventLoop());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    assertTrue(eventLoopGroup instanceof DefaultEventLoop);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(eventLoopGroup.isShuttingDown());
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage2() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class org.springframework.web.reactive.function.client.WebClientRequestException: channel not registered"
            + " to an event loop",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage3() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("Request Method");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class java.lang.IllegalArgumentException: invalid character in name", data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage4() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class java.lang.IllegalArgumentException: Param 'name' must not be empty",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage5() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("Request Method");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doThrow(new RuntimeException())
        .when(onFailure)
        .accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class java.lang.IllegalArgumentException: invalid character in name", data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage6() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setUseSimpleClientHttpFactory(true);
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class org.springframework.web.reactive.function.client.WebClientRequestException: channel not registered"
            + " to an event loop",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage7() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(3);
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class org.springframework.web.reactive.function.client.WebClientRequestException: channel not registered"
            + " to an event loop",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage8() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    ResponseSpec responseSpec = mock(ResponseSpec.class);
    Mono<ResponseEntity<String>> justResult = Mono.just(new ResponseEntity<>(HttpStatus.OK));
    when(responseSpec.toEntity(Mockito.<Class<String>>any())).thenReturn(justResult);

    RequestBodySpec requestBodySpec = mock(RequestBodySpec.class);
    when(requestBodySpec.retrieve()).thenReturn(responseSpec);

    RequestBodySpec requestBodySpec2 = mock(RequestBodySpec.class);
    when(requestBodySpec2.headers(Mockito.<Consumer<HttpHeaders>>any()))
        .thenReturn(requestBodySpec);

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenReturn(requestBodySpec2);

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodySpec2).headers(isA(Consumer.class));
    verify(requestBodySpec).retrieve();
    verify(responseSpec).toEntity(isA(Class.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(4, data.size());
    assertEquals("200", data.get("statusCode"));
    assertEquals("OK", data.get("status"));
    assertEquals("OK", data.get("statusReason"));
    assertEquals(
        "class java.lang.NullPointerException: Cannot invoke \"org.thingsboard.rule.engine.api.TbContext"
            + ".transformMsg(org.thingsboard.server.common.msg.TbMsg, org.thingsboard.server.common.msg.TbMsgMetaData,"
            + " String)\" because \"ctx\" is null",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage9() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    ResponseSpec responseSpec = mock(ResponseSpec.class);
    Mono<ResponseEntity<String>> justResult =
        Mono.just(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    when(responseSpec.toEntity(Mockito.<Class<String>>any())).thenReturn(justResult);

    RequestBodySpec requestBodySpec = mock(RequestBodySpec.class);
    when(requestBodySpec.retrieve()).thenReturn(responseSpec);

    RequestBodySpec requestBodySpec2 = mock(RequestBodySpec.class);
    when(requestBodySpec2.headers(Mockito.<Consumer<HttpHeaders>>any()))
        .thenReturn(requestBodySpec);

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenReturn(requestBodySpec2);

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isNull());
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodySpec2).headers(isA(Consumer.class));
    verify(requestBodySpec).retrieve();
    verify(responseSpec).toEntity(isA(Class.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(3, data.size());
    assertEquals("401", data.get("statusCode"));
    assertEquals("UNAUTHORIZED", data.get("status"));
    assertEquals("Unauthorized", data.get("statusReason"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage10() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    ResponseSpec responseSpec = mock(ResponseSpec.class);
    Mono<ResponseEntity<String>> justResult =
        Mono.just(new ResponseEntity<>("https://example.org/example", HttpStatus.OK));
    when(responseSpec.toEntity(Mockito.<Class<String>>any())).thenReturn(justResult);

    RequestBodySpec requestBodySpec = mock(RequestBodySpec.class);
    when(requestBodySpec.retrieve()).thenReturn(responseSpec);

    RequestBodySpec requestBodySpec2 = mock(RequestBodySpec.class);
    when(requestBodySpec2.headers(Mockito.<Consumer<HttpHeaders>>any()))
        .thenReturn(requestBodySpec);

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenReturn(requestBodySpec2);

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodySpec2).headers(isA(Consumer.class));
    verify(requestBodySpec).retrieve();
    verify(responseSpec).toEntity(isA(Class.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(4, data.size());
    assertEquals("200", data.get("statusCode"));
    assertEquals("OK", data.get("status"));
    assertEquals("OK", data.get("statusReason"));
    assertEquals(
        "class java.lang.NullPointerException: Cannot invoke \"org.thingsboard.rule.engine.api.TbContext"
            + ".transformMsg(org.thingsboard.server.common.msg.TbMsg, org.thingsboard.server.common.msg.TbMsgMetaData,"
            + " String)\" because \"ctx\" is null",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test processMessage(TbContext, TbMsg, Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage11() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxParallelRequestsCount(3);
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    ResponseSpec responseSpec = mock(ResponseSpec.class);
    Mono<ResponseEntity<String>> justResult = Mono.just(new ResponseEntity<>(HttpStatus.OK));
    when(responseSpec.toEntity(Mockito.<Class<String>>any())).thenReturn(justResult);

    RequestBodySpec requestBodySpec = mock(RequestBodySpec.class);
    when(requestBodySpec.retrieve()).thenReturn(responseSpec);

    RequestBodySpec requestBodySpec2 = mock(RequestBodySpec.class);
    when(requestBodySpec2.headers(Mockito.<Consumer<HttpHeaders>>any()))
        .thenReturn(requestBodySpec);

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenReturn(requestBodySpec2);

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodySpec2).headers(isA(Consumer.class));
    verify(requestBodySpec).retrieve();
    verify(responseSpec).toEntity(isA(Class.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(4, data.size());
    assertEquals("200", data.get("statusCode"));
    assertEquals("OK", data.get("status"));
    assertEquals("OK", data.get("statusReason"));
    assertEquals(
        "class java.lang.NullPointerException: Cannot invoke \"org.thingsboard.rule.engine.api.TbContext"
            + ".transformMsg(org.thingsboard.server.common.msg.TbMsg, org.thingsboard.server.common.msg.TbMsgMetaData,"
            + " String)\" because \"ctx\" is null",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code $[UU]} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given HashMap() '$[UU]' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenHashMapUuIs42() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("$[UU]", "42");
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doNothing().when(onFailure).accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class org.springframework.web.reactive.function.client.WebClientRequestException: channel not registered"
            + " to an event loop",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link RequestBodySpec} {@link RequestBodySpec#retrieve()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given RequestBodySpec retrieve() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenRequestBodySpecRetrieveThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    RequestBodySpec requestBodySpec = mock(RequestBodySpec.class);
    when(requestBodySpec.retrieve()).thenThrow(new RuntimeException());

    RequestBodySpec requestBodySpec2 = mock(RequestBodySpec.class);
    when(requestBodySpec2.headers(Mockito.<Consumer<HttpHeaders>>any()))
        .thenReturn(requestBodySpec);

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenReturn(requestBodySpec2);

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodySpec2).headers(isA(Consumer.class));
    verify(requestBodySpec).retrieve();
    verify(requestBodyUriSpec).uri(isA(URI.class));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link WebClient.RequestBodyUriSpec} {@link WebClient.RequestBodyUriSpec#uri(URI)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given RequestBodyUriSpec uri(URI) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenRequestBodyUriSpecUriThrowRuntimeException() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenThrow(new RuntimeException());

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link WebClient.ResponseSpec} {@link WebClient.ResponseSpec#toEntity(Class)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given ResponseSpec toEntity(Class) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenResponseSpecToEntityThrowRuntimeException() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    ResponseSpec responseSpec = mock(ResponseSpec.class);
    when(responseSpec.toEntity(Mockito.<Class<String>>any())).thenThrow(new RuntimeException());

    RequestBodySpec requestBodySpec = mock(RequestBodySpec.class);
    when(requestBodySpec.retrieve()).thenReturn(responseSpec);

    RequestBodySpec requestBodySpec2 = mock(RequestBodySpec.class);
    when(requestBodySpec2.headers(Mockito.<Consumer<HttpHeaders>>any()))
        .thenReturn(requestBodySpec);

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenReturn(requestBodySpec2);

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodySpec2).headers(isA(Consumer.class));
    verify(requestBodySpec).retrieve();
    verify(responseSpec).toEntity(isA(Class.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenRuntimeException() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    Consumer<TbMsg> onSuccess = mock(Consumer.class);

    BiConsumer<TbMsg, Throwable> onFailure = mock(BiConsumer.class);
    doThrow(new RuntimeException())
        .when(onFailure)
        .accept(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(TbMsg.class), isA(Throwable.class));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals(
        "class org.springframework.web.reactive.function.client.WebClientRequestException: channel not registered"
            + " to an event loop",
        data.get("error"));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link TbRestApiCallNodeConfiguration} (default constructor) RestEndpointUrlPattern
   *       is {@code $[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given TbRestApiCallNodeConfiguration (default constructor) RestEndpointUrlPattern is '$[UU]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenTbRestApiCallNodeConfigurationRestEndpointUrlPatternIsUu()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("$[UU]");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link WebClient} {@link WebClient#method(HttpMethod)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given WebClient method(HttpMethod) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenWebClientMethodThrowRuntimeException() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenThrow(new RuntimeException());

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
    verify(webClient).method(isA(HttpMethod.class));
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_thenCallsAccept() throws TbNodeException {
    // Arrange
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Delivered-To", "alice.liddell@example.org");

    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setHeaders(headers);
    config.setRequestMethod("$[UU]");
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    ResponseSpec responseSpec = mock(ResponseSpec.class);
    Mono<ResponseEntity<Object>> justResult = Mono.just(new ResponseEntity<>(HttpStatus.OK));
    when(responseSpec.toEntity(Mockito.<Class<Object>>any())).thenReturn(justResult);
    Mono<ResponseEntity<String>> justResult2 = Mono.just(new ResponseEntity<>(HttpStatus.OK));
    when(responseSpec.toEntity(Mockito.<Class<String>>any())).thenReturn(justResult2);

    RequestBodySpec requestBodySpec = mock(RequestBodySpec.class);
    when(requestBodySpec.retrieve()).thenReturn(responseSpec);

    RequestBodySpec requestBodySpec2 = mock(RequestBodySpec.class);
    when(requestBodySpec2.headers(Mockito.<Consumer<HttpHeaders>>any()))
        .thenReturn(requestBodySpec);

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenReturn(requestBodySpec2);

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);

    TbContext ctx = mock(TbContext.class);
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    when(ctx.transformMsg(
            Mockito.<TbMsg>any(), Mockito.<TbMsgMetaData>any(), Mockito.<String>any()))
        .thenReturn(telemetryMsgResult);
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    Consumer<TbMsg> onSuccess = mock(Consumer.class);
    doNothing().when(onSuccess).accept(Mockito.<TbMsg>any());

    // Act
    tbHttpClient.processMessage(ctx, msg, onSuccess, mock(BiConsumer.class));

    // Assert
    verify(onSuccess).accept(isA(TbMsg.class));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodySpec2).headers(isA(Consumer.class));
    verify(requestBodySpec).retrieve();
    verify(responseSpec, atLeast(1)).toEntity(isA(Class.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
    verify(ctx).transformMsg(isA(TbMsg.class), isA(TbMsgMetaData.class), eq("{}"));
    Map<String, String> data = msg.getMetaData().getData();
    assertEquals(3, data.size());
    assertEquals("200", data.get("statusCode"));
    assertEquals("OK", data.get("status"));
    assertEquals("OK", data.get("statusReason"));
  }

  /**
   * Test {@link TbHttpClient#buildEncodedUri(String)}.
   *
   * <ul>
   *   <li>Then return toString is {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#buildEncodedUri(String)}
   */
  @Test
  @DisplayName(
      "Test buildEncodedUri(String); then return toString is 'https://config.us-east-2.amazonaws.com'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URI TbHttpClient.buildEncodedUri(String)"})
  void testBuildEncodedUri_thenReturnToStringIsHttpsConfigUsEast2AmazonawsCom()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertEquals(
        "https://config.us-east-2.amazonaws.com",
        tbHttpClient.buildEncodedUri("https://config.us-east-2.amazonaws.com").toString());
  }

  /**
   * Test {@link TbHttpClient#buildEncodedUri(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#buildEncodedUri(String)}
   */
  @Test
  @DisplayName("Test buildEncodedUri(String); when empty string; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URI TbHttpClient.buildEncodedUri(String)"})
  void testBuildEncodedUri_whenEmptyString_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbHttpClient.buildEncodedUri(""));
  }

  /**
   * Test {@link TbHttpClient#buildEncodedUri(String)}.
   *
   * <ul>
   *   <li>When {@code Endpoint Url}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#buildEncodedUri(String)}
   */
  @Test
  @DisplayName("Test buildEncodedUri(String); when 'Endpoint Url'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URI TbHttpClient.buildEncodedUri(String)"})
  void testBuildEncodedUri_whenEndpointUrl_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbHttpClient.buildEncodedUri("Endpoint Url"));
  }

  /**
   * Test {@link TbHttpClient#buildEncodedUri(String)}.
   *
   * <ul>
   *   <li>When {@code https://config.us-east-2.amazonaws.comUrl string cannot be empty!}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#buildEncodedUri(String)}
   */
  @Test
  @DisplayName(
      "Test buildEncodedUri(String); when 'https://config.us-east-2.amazonaws.comUrl string cannot be empty!'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URI TbHttpClient.buildEncodedUri(String)"})
  void testBuildEncodedUri_whenHttpsConfigUsEast2AmazonawsComUrlStringCannotBeEmpty()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbHttpClient.buildEncodedUri(
                "https://config.us-east-2.amazonaws.comUrl string cannot be empty!"));
  }

  /**
   * Test {@link TbHttpClient#buildEncodedUri(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#buildEncodedUri(String)}
   */
  @Test
  @DisplayName("Test buildEncodedUri(String); when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URI TbHttpClient.buildEncodedUri(String)"})
  void testBuildEncodedUri_whenNull_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbHttpClient.buildEncodedUri(null));
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test headersToMetaData(Map, BiConsumer); given '42'; when HashMap() '42' is ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_given42_whenHashMap42IsArrayList_thenDoesNotThrow()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    HashMap<String, List<String>> headers = new HashMap<>();
    headers.put("42", new ArrayList<>());
    headers.put("Key", new ArrayList<>());

    // Act and Assert
    assertDoesNotThrow(() -> tbHttpClient.headersToMetaData(headers, mock(BiConsumer.class)));
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>When {@link BiConsumer} {@link BiConsumer#accept(Object, Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test headersToMetaData(Map, BiConsumer); given ArrayList() add '42'; when BiConsumer accept(Object, Object) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_givenArrayListAdd42_whenBiConsumerAcceptDoesNothing()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("foo");

    HashMap<String, List<String>> headers = new HashMap<>();
    headers.put("Key", stringList);

    BiConsumer<String, String> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<String>any());

    // Act
    tbHttpClient.headersToMetaData(headers, consumer);

    // Assert
    verify(consumer).accept("Key", "[\"42\",\"foo\"]");
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test headersToMetaData(Map, BiConsumer); given ArrayList() add empty string; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_givenArrayListAddEmptyString_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    stringList.add("foo");

    HashMap<String, List<String>> headers = new HashMap<>();
    headers.put("Key", stringList);

    BiConsumer<String, String> consumer = mock(BiConsumer.class);
    doThrow(new RuntimeException())
        .when(consumer)
        .accept(Mockito.<String>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbHttpClient.headersToMetaData(headers, consumer));
    verify(consumer).accept("Key", "[\"\",\"foo\"]");
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link BiConsumer}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test headersToMetaData(Map, BiConsumer); given ArrayList(); when BiConsumer; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_givenArrayList_whenBiConsumer_thenDoesNotThrow()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    HashMap<String, List<String>> headers = new HashMap<>();
    headers.put("Key", new ArrayList<>());

    // Act and Assert
    assertDoesNotThrow(() -> tbHttpClient.headersToMetaData(headers, mock(BiConsumer.class)));
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test headersToMetaData(Map, BiConsumer); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_givenRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    HashMap<String, List<String>> headers = new HashMap<>();
    headers.put("Key", stringList);

    BiConsumer<String, String> consumer = mock(BiConsumer.class);
    doThrow(new RuntimeException())
        .when(consumer)
        .accept(Mockito.<String>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbHttpClient.headersToMetaData(headers, consumer));
    verify(consumer).accept("Key", "foo");
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>When {@link BiConsumer} {@link BiConsumer#accept(Object, Object)} does nothing.
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test headersToMetaData(Map, BiConsumer); when BiConsumer accept(Object, Object) does nothing; then calls accept(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_whenBiConsumerAcceptDoesNothing_thenCallsAccept()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    HashMap<String, List<String>> headers = new HashMap<>();
    headers.put("Key", stringList);

    BiConsumer<String, String> consumer = mock(BiConsumer.class);
    doNothing().when(consumer).accept(Mockito.<String>any(), Mockito.<String>any());

    // Act
    tbHttpClient.headersToMetaData(headers, consumer);

    // Assert
    verify(consumer).accept("Key", "foo");
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName("Test headersToMetaData(Map, BiConsumer); when HashMap(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_whenHashMap_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertDoesNotThrow(
        () -> tbHttpClient.headersToMetaData(new HashMap<>(), mock(BiConsumer.class)));
  }

  /**
   * Test {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#headersToMetaData(Map, BiConsumer)}
   */
  @Test
  @DisplayName("Test headersToMetaData(Map, BiConsumer); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.headersToMetaData(Map, BiConsumer)"})
  void testHeadersToMetaData_whenNull_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertDoesNotThrow(() -> tbHttpClient.headersToMetaData(null, mock(BiConsumer.class)));
  }

  /**
   * Test {@link TbHttpClient#equals(Object)}, and {@link TbHttpClient#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbHttpClient#equals(Object)}
   *   <li>{@link TbHttpClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbHttpClient.equals(Object)", "int TbHttpClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertEquals(tbHttpClient, tbHttpClient);
    int notExpectedHashCodeResult = tbHttpClient.hashCode();
    assertNotEquals(notExpectedHashCodeResult, tbHttpClient.hashCode());
  }

  /**
   * Test {@link TbHttpClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbHttpClient.equals(Object)", "int TbHttpClient.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbRestApiCallNodeConfiguration config2 = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient2 = new TbHttpClient(config2, new DefaultEventLoop());

    // Act and Assert
    assertNotEquals(tbHttpClient, tbHttpClient2);
  }

  /**
   * Test {@link TbHttpClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbHttpClient.equals(Object)", "int TbHttpClient.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertNotEquals(tbHttpClient, null);
  }

  /**
   * Test {@link TbHttpClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbHttpClient.equals(Object)", "int TbHttpClient.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act and Assert
    assertNotEquals(tbHttpClient, "Different type to TbHttpClient");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbHttpClient#setSemaphore(Semaphore)}
   *   <li>{@link TbHttpClient#setWebClient(WebClient)}
   *   <li>{@link TbHttpClient#toString()}
   *   <li>{@link TbHttpClient#getConfig()}
   *   <li>{@link TbHttpClient#getEventLoopGroup()}
   *   <li>{@link TbHttpClient#getSemaphore()}
   *   <li>{@link TbHttpClient#getWebClient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbRestApiCallNodeConfiguration TbHttpClient.getConfig()",
    "EventLoopGroup TbHttpClient.getEventLoopGroup()",
    "Semaphore TbHttpClient.getSemaphore()",
    "WebClient TbHttpClient.getWebClient()",
    "void TbHttpClient.setEventLoopGroup(EventLoopGroup)",
    "void TbHttpClient.setSemaphore(Semaphore)",
    "void TbHttpClient.setWebClient(WebClient)",
    "String TbHttpClient.toString()"
  })
  void testGettersAndSetters() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    Semaphore semaphore = new Semaphore(1);

    // Act
    tbHttpClient.setSemaphore(semaphore);
    WebClient webClient = mock(WebClient.class);
    tbHttpClient.setWebClient(webClient);
    tbHttpClient.toString();
    TbRestApiCallNodeConfiguration actualConfig = tbHttpClient.getConfig();
    EventLoopGroup actualEventLoopGroup = tbHttpClient.getEventLoopGroup();
    Semaphore actualSemaphore = tbHttpClient.getSemaphore();

    // Assert
    assertNull(actualEventLoopGroup);
    assertSame(semaphore, actualSemaphore);
    assertSame(config, actualConfig);
    assertSame(webClient, tbHttpClient.getWebClient());
  }
}
