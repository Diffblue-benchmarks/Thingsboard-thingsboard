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
package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
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
import java.util.concurrent.ThreadFactory;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.net.ssl.SSLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.credentials.ClientCredentials;
import org.thingsboard.rule.engine.credentials.CredentialsType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

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
   *   <li>Given {@link ClientCredentials}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given ClientCredentials; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_givenClientCredentials_thenThrowIllegalArgumentException()
      throws TbNodeException {
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
   *   <li>Given {@code null}.
   *   <li>When {@code null}.
   *   <li>Then EventLoopGroup next return {@link NioEventLoop}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#TbHttpClient(TbRestApiCallNodeConfiguration,
   * EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test new TbHttpClient(TbRestApiCallNodeConfiguration, EventLoopGroup); given 'null'; when 'null'; then EventLoopGroup next return NioEventLoop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.<init>(TbRestApiCallNodeConfiguration, EventLoopGroup)"})
  void testNewTbHttpClient_givenNull_whenNull_thenEventLoopGroupNextReturnNioEventLoop()
      throws TbNodeException {
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
    TbHttpClient actualTbHttpClient = new TbHttpClient(config, null);

    // Assert
    EventLoopGroup eventLoopGroup = actualTbHttpClient.getEventLoopGroup();
    assertTrue(eventLoopGroup.next() instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    assertTrue(eventLoopGroup.terminationFuture() instanceof DefaultPromise);
    assertFalse(eventLoopGroup.isShuttingDown());
    assertFalse(eventLoopGroup.isShutdown());
    assertFalse(eventLoopGroup.isTerminated());
    assertTrue(eventLoopGroup.iterator().hasNext());
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
   * Test {@link TbHttpClient#getSharedOrCreateEventLoopGroup(EventLoopGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then next return {@link NioEventLoop}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#getSharedOrCreateEventLoopGroup(EventLoopGroup)}
   */
  @Test
  @DisplayName(
      "Test getSharedOrCreateEventLoopGroup(EventLoopGroup); when 'null'; then next return NioEventLoop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventLoopGroup TbHttpClient.getSharedOrCreateEventLoopGroup(EventLoopGroup)"})
  void testGetSharedOrCreateEventLoopGroup_whenNull_thenNextReturnNioEventLoop()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());

    // Act
    EventLoopGroup actualSharedOrCreateEventLoopGroup =
        tbHttpClient.getSharedOrCreateEventLoopGroup(null);

    // Assert
    assertTrue(actualSharedOrCreateEventLoopGroup.next() instanceof NioEventLoop);
    assertTrue(actualSharedOrCreateEventLoopGroup instanceof NioEventLoopGroup);
    assertTrue(actualSharedOrCreateEventLoopGroup.terminationFuture() instanceof DefaultPromise);
    assertFalse(actualSharedOrCreateEventLoopGroup.isShuttingDown());
    assertFalse(actualSharedOrCreateEventLoopGroup.isShutdown());
    assertFalse(actualSharedOrCreateEventLoopGroup.isTerminated());
    assertTrue(actualSharedOrCreateEventLoopGroup.iterator().hasNext());
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
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy2() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy3() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbHttpClient tbHttpClient = new TbHttpClient(new TbRestApiCallNodeConfiguration(), null);

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy4() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, null);

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy5() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    TbHttpClient tbHttpClient = new TbHttpClient(config, null);

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy6() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbHttpClient tbHttpClient = new TbHttpClient(new TbRestApiCallNodeConfiguration(), null);
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy7() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy8() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxInMemoryBufferSizeInKb(3);

    TbHttpClient tbHttpClient = new TbHttpClient(config, null);
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
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
  void testDestroy9() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");

    TbHttpClient tbHttpClient = new TbHttpClient(config, new NioEventLoopGroup());
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
  }

  /**
   * Test {@link TbHttpClient#destroy()}.
   *
   * <ul>
   *   <li>Given {@link DefaultThreadFactory#DefaultThreadFactory(String)} with {@code Pool Name}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given DefaultThreadFactory(String) with 'Pool Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.destroy()"})
  void testDestroy_givenDefaultThreadFactoryWithPoolName()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxInMemoryBufferSizeInKb(3);
    LocalEventLoopGroup eventLoopGroupShared =
        new LocalEventLoopGroup(new DefaultThreadFactory("Pool Name"));

    TbHttpClient tbHttpClient = new TbHttpClient(config, eventLoopGroupShared);
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
  }

  /**
   * Test {@link TbHttpClient#destroy()}.
   *
   * <ul>
   *   <li>Given {@link LocalEventLoopGroup#LocalEventLoopGroup(ThreadFactory)} with {@link
   *       ThreadFactory}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given LocalEventLoopGroup(ThreadFactory) with ThreadFactory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.destroy()"})
  void testDestroy_givenLocalEventLoopGroupWithThreadFactory()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxInMemoryBufferSizeInKb(3);
    LocalEventLoopGroup eventLoopGroupShared = new LocalEventLoopGroup(mock(ThreadFactory.class));

    TbHttpClient tbHttpClient = new TbHttpClient(config, eventLoopGroupShared);
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
  }

  /**
   * Test {@link TbHttpClient#destroy()}.
   *
   * <ul>
   *   <li>Given {@link LocalEventLoopGroup#LocalEventLoopGroup(ThreadFactory)} with threadFactory
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#destroy()}
   */
  @Test
  @DisplayName(
      "Test destroy(); given LocalEventLoopGroup(ThreadFactory) with threadFactory is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.destroy()"})
  void testDestroy_givenLocalEventLoopGroupWithThreadFactoryIsNull()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setMaxInMemoryBufferSizeInKb(3);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new LocalEventLoopGroup(null));
    tbHttpClient.setEventLoopGroup(new NioEventLoopGroup());

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
  }

  /**
   * Test {@link TbHttpClient#destroy()}.
   *
   * <ul>
   *   <li>Given {@link TbRestApiCallNodeConfiguration} (default constructor) RestEndpointUrlPattern
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#destroy()}
   */
  @Test
  @DisplayName(
      "Test destroy(); given TbRestApiCallNodeConfiguration (default constructor) RestEndpointUrlPattern is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.destroy()"})
  void testDestroy_givenTbRestApiCallNodeConfigurationRestEndpointUrlPatternIsNull()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern(null);
    TbHttpClient tbHttpClient = new TbHttpClient(config, null);

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
  }

  /**
   * Test {@link TbHttpClient#destroy()}.
   *
   * <ul>
   *   <li>Given {@link TbRestApiCallNodeConfiguration} (default constructor) RestEndpointUrlPattern
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#destroy()}
   */
  @Test
  @DisplayName(
      "Test destroy(); given TbRestApiCallNodeConfiguration (default constructor) RestEndpointUrlPattern is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.destroy()"})
  void testDestroy_givenTbRestApiCallNodeConfigurationRestEndpointUrlPatternIsNull2()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern(null);
    TbHttpClient tbHttpClient = new TbHttpClient(config, null);

    // Act
    tbHttpClient.destroy();

    // Assert
    EventLoopGroup eventLoopGroup = tbHttpClient.getEventLoopGroup();
    EventLoop nextResult = eventLoopGroup.next();
    assertTrue(nextResult instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    Future<?> terminationFutureResult = eventLoopGroup.terminationFuture();
    assertTrue(terminationFutureResult instanceof DefaultPromise);
    assertNull(terminationFutureResult.get());
    assertTrue(nextResult.isShuttingDown());
    assertTrue(eventLoopGroup.isShuttingDown());
    assertTrue(nextResult.isShutdown());
    assertTrue(eventLoopGroup.isShutdown());
    assertTrue(nextResult.isTerminated());
    assertTrue(eventLoopGroup.isTerminated());
    assertTrue(terminationFutureResult.isDone());
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link WebClient.RequestBodyUriSpec} {@link WebClient.RequestBodyUriSpec#uri(URI)}
   *       throw {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link WebClient.RequestBodyUriSpec#uri(URI)}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given RequestBodyUriSpec uri(URI) throw RuntimeException(); then calls uri(URI)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenRequestBodyUriSpecUriThrowRuntimeException_thenCallsUri()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    config.setRequestMethod("Request Method");

    RequestBodyUriSpec requestBodyUriSpec = mock(RequestBodyUriSpec.class);
    when(requestBodyUriSpec.uri(Mockito.<URI>any())).thenThrow(new RuntimeException());

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenReturn(requestBodyUriSpec);

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
    verify(webClient).method(isA(HttpMethod.class));
    verify(requestBodyUriSpec).uri(isA(URI.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Given {@link WebClient} {@link WebClient#method(HttpMethod)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link WebClient#method(HttpMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); given WebClient method(HttpMethod) throw RuntimeException(); then calls method(HttpMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_givenWebClientMethodThrowRuntimeException_thenCallsMethod()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRestEndpointUrlPattern("https://config.us-east-2.amazonaws.com");
    config.setRequestMethod("Request Method");

    WebClient webClient = mock(WebClient.class);
    when(webClient.method(Mockito.<HttpMethod>any())).thenThrow(new RuntimeException());

    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    tbHttpClient.setWebClient(webClient);
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
    verify(webClient).method(isA(HttpMethod.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbHttpClient#processMessage(TbContext, TbMsg, Consumer,
   * BiConsumer)}
   */
  @Test
  @DisplayName(
      "Test processMessage(TbContext, TbMsg, Consumer, BiConsumer); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbHttpClient.processMessage(TbContext, TbMsg, Consumer, BiConsumer)"})
  void testProcessMessage_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    config.setRequestMethod("Request Method");
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbHttpClient.processMessage(ctx, msg, mock(Consumer.class), mock(BiConsumer.class)));
    verify(msg).getData();
    verify(msg).getMetaData();
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
