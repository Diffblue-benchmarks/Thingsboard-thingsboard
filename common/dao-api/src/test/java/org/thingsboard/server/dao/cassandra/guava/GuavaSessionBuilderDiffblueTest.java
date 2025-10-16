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
package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.api.core.context.DriverContext;
import com.datastax.oss.driver.api.core.loadbalancing.LoadBalancingPolicy;
import com.datastax.oss.driver.api.core.metadata.NodeStateListenerBase;
import com.datastax.oss.driver.api.core.metadata.schema.SchemaChangeListenerBase;
import com.datastax.oss.driver.api.core.session.ProgrammaticArguments;
import com.datastax.oss.driver.api.core.session.ProgrammaticArguments.Builder;
import com.datastax.oss.driver.api.core.session.Session;
import com.datastax.oss.driver.api.core.ssl.ProgrammaticSslEngineFactory;
import com.datastax.oss.driver.api.core.tracker.RequestTracker;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.internal.core.config.composite.CompositeDriverConfig;
import com.datastax.oss.driver.internal.core.config.composite.CompositeDriverConfigLoader;
import com.datastax.oss.driver.internal.core.config.typesafe.DefaultDriverConfigLoader;
import com.datastax.oss.driver.internal.core.config.typesafe.TypesafeDriverConfig;
import com.datastax.oss.driver.internal.core.context.DefaultNettyOptions;
import com.datastax.oss.driver.internal.core.metrics.DefaultMetricsFactory;
import com.datastax.oss.driver.internal.core.session.SessionWrapper;
import com.datastax.oss.driver.internal.core.type.codec.registry.DefaultCodecRegistry;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.management.loading.MLet;
import javax.net.ssl.SSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GuavaSessionBuilderDiffblueTest {
  /**
   * Test {@link GuavaSessionBuilder#buildContext(DriverConfigLoader, ProgrammaticArguments)} with
   * {@code configLoader}, {@code programmaticArguments}.
   *
   * <p>Method under test: {@link GuavaSessionBuilder#buildContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName(
      "Test buildContext(DriverConfigLoader, ProgrammaticArguments) with 'configLoader', 'programmaticArguments'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DriverContext GuavaSessionBuilder.buildContext(DriverConfigLoader, ProgrammaticArguments)"
  })
  void testBuildContextWithConfigLoaderProgrammaticArguments() throws NoSuchAlgorithmException {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DefaultDriverConfigLoader configLoader = new DefaultDriverConfigLoader();

    Builder builderResult2 = ProgrammaticArguments.builder();

    Builder withAuthProviderResult =
        builderResult2.withAuthProvider(
            new ProgrammaticPlainTextAuthProvider("janedoe", "iloveyou"));

    Builder withClassLoaderResult = withAuthProviderResult.withClassLoader(new MLet());

    Builder withCloudProxyAddressResult =
        withClassLoaderResult.withCloudProxyAddress(InetSocketAddress.createUnresolved("foo", 1));

    Builder withMetricRegistryResult =
        withCloudProxyAddressResult
            .withCodecRegistry(new DefaultCodecRegistry("Log Prefix"))
            .withMetricRegistry("Metric Registry");

    Builder withRequestTrackerResult =
        withMetricRegistryResult
            .withNodeStateListener(new NodeStateListenerBase())
            .withRequestTracker(mock(RequestTracker.class));

    Builder withSchemaChangeListenerResult =
        withRequestTrackerResult.withSchemaChangeListener(new SchemaChangeListenerBase());

    Builder withStartupApplicationVersionResult =
        withSchemaChangeListenerResult
            .withSslEngineFactory(new ProgrammaticSslEngineFactory(SSLContext.getDefault()))
            .withStartupApplicationName("Startup Application Name")
            .withStartupApplicationVersion("1.0.2");

    // Act
    DriverContext actualBuildContextResult =
        builderResult.buildContext(
            configLoader,
            withStartupApplicationVersionResult.withStartupClientId(UUID.randomUUID()).build());

    // Assert
    assertTrue(
        ((GuavaDriverContext) actualBuildContextResult).getNettyOptions()
            instanceof DefaultNettyOptions);
    assertTrue(
        ((GuavaDriverContext) actualBuildContextResult).getMetricsFactory()
            instanceof DefaultMetricsFactory);
    assertTrue(actualBuildContextResult instanceof GuavaDriverContext);
    assertNotNull(((GuavaDriverContext) actualBuildContextResult).getClassLoader());
    Map<String, LoadBalancingPolicy> loadBalancingPolicies =
        actualBuildContextResult.getLoadBalancingPolicies();
    assertEquals(1, loadBalancingPolicies.size());
    assertTrue(loadBalancingPolicies.containsKey("default"));
  }

  /**
   * Test {@link GuavaSessionBuilder#buildContext(DriverConfigLoader, ProgrammaticArguments)} with
   * {@code configLoader}, {@code programmaticArguments}.
   *
   * <p>Method under test: {@link GuavaSessionBuilder#buildContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName(
      "Test buildContext(DriverConfigLoader, ProgrammaticArguments) with 'configLoader', 'programmaticArguments'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DriverContext GuavaSessionBuilder.buildContext(DriverConfigLoader, ProgrammaticArguments)"
  })
  void testBuildContextWithConfigLoaderProgrammaticArguments2() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DefaultDriverConfigLoader configLoader = new DefaultDriverConfigLoader();

    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener())
        .thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    when(programmaticArguments.getCodecRegistry())
        .thenReturn(new DefaultCodecRegistry("Log Prefix"));
    when(programmaticArguments.getClassLoader()).thenReturn(new MLet());
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress())
        .thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    org.mockito.Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs())
        .thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    DriverContext actualBuildContextResult =
        builderResult.buildContext(configLoader, programmaticArguments);

    // Assert
    verify(programmaticArguments).getClassLoader();
    verify(programmaticArguments).getCloudProxyAddress();
    verify(programmaticArguments).getCodecRegistry();
    verify(programmaticArguments).getLocalDatacenters();
    verify(programmaticArguments).getMetricRegistry();
    verify(programmaticArguments).getNodeDistanceEvaluators();
    verify(programmaticArguments).getNodeFilters();
    verify(programmaticArguments).getNodeStateListener();
    verify(programmaticArguments).getRequestTracker();
    verify(programmaticArguments).getSchemaChangeListener();
    verify(programmaticArguments).getStartupApplicationName();
    verify(programmaticArguments).getStartupApplicationVersion();
    verify(programmaticArguments).getStartupClientId();
    verify(programmaticArguments).getTypeCodecs();
    assertTrue(actualBuildContextResult.getConfigLoader() instanceof DefaultDriverConfigLoader);
    assertTrue(actualBuildContextResult.getConfig() instanceof TypesafeDriverConfig);
    assertTrue(actualBuildContextResult instanceof GuavaDriverContext);
    assertNotNull(((GuavaDriverContext) actualBuildContextResult).getClassLoader());
  }

  /**
   * Test {@link GuavaSessionBuilder#buildContext(DriverConfigLoader, ProgrammaticArguments)} with
   * {@code configLoader}, {@code programmaticArguments}.
   *
   * <p>Method under test: {@link GuavaSessionBuilder#buildContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName(
      "Test buildContext(DriverConfigLoader, ProgrammaticArguments) with 'configLoader', 'programmaticArguments'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DriverContext GuavaSessionBuilder.buildContext(DriverConfigLoader, ProgrammaticArguments)"
  })
  void testBuildContextWithConfigLoaderProgrammaticArguments3() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DefaultDriverConfigLoader primaryConfigLoader = new DefaultDriverConfigLoader();
    CompositeDriverConfigLoader configLoader =
        new CompositeDriverConfigLoader(primaryConfigLoader, new DefaultDriverConfigLoader());

    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener())
        .thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    when(programmaticArguments.getCodecRegistry())
        .thenReturn(new DefaultCodecRegistry("Log Prefix"));
    when(programmaticArguments.getClassLoader()).thenReturn(new MLet());
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress())
        .thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    org.mockito.Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs())
        .thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    DriverContext actualBuildContextResult =
        builderResult.buildContext(configLoader, programmaticArguments);

    // Assert
    verify(programmaticArguments).getClassLoader();
    verify(programmaticArguments).getCloudProxyAddress();
    verify(programmaticArguments).getCodecRegistry();
    verify(programmaticArguments).getLocalDatacenters();
    verify(programmaticArguments).getMetricRegistry();
    verify(programmaticArguments).getNodeDistanceEvaluators();
    verify(programmaticArguments).getNodeFilters();
    verify(programmaticArguments).getNodeStateListener();
    verify(programmaticArguments).getRequestTracker();
    verify(programmaticArguments).getSchemaChangeListener();
    verify(programmaticArguments).getStartupApplicationName();
    verify(programmaticArguments).getStartupApplicationVersion();
    verify(programmaticArguments).getStartupClientId();
    verify(programmaticArguments).getTypeCodecs();
    assertTrue(actualBuildContextResult.getConfig() instanceof CompositeDriverConfig);
    DriverConfigLoader configLoader2 = actualBuildContextResult.getConfigLoader();
    assertTrue(configLoader2 instanceof CompositeDriverConfigLoader);
    assertTrue(actualBuildContextResult instanceof GuavaDriverContext);
    assertNotNull(((GuavaDriverContext) actualBuildContextResult).getClassLoader());
    assertSame(configLoader, configLoader2);
  }

  /**
   * Test {@link GuavaSessionBuilder#buildContext(DriverConfigLoader, ProgrammaticArguments)} with
   * {@code configLoader}, {@code programmaticArguments}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GuavaSessionBuilder#buildContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName(
      "Test buildContext(DriverConfigLoader, ProgrammaticArguments) with 'configLoader', 'programmaticArguments'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DriverContext GuavaSessionBuilder.buildContext(DriverConfigLoader, ProgrammaticArguments)"
  })
  void testBuildContextWithConfigLoaderProgrammaticArguments_givenNull() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DefaultDriverConfigLoader configLoader = new DefaultDriverConfigLoader();

    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener())
        .thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    when(programmaticArguments.getCodecRegistry()).thenReturn(null);
    when(programmaticArguments.getClassLoader()).thenReturn(new MLet());
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress())
        .thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    org.mockito.Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs())
        .thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    DriverContext actualBuildContextResult =
        builderResult.buildContext(configLoader, programmaticArguments);

    // Assert
    verify(programmaticArguments).getClassLoader();
    verify(programmaticArguments).getCloudProxyAddress();
    verify(programmaticArguments).getCodecRegistry();
    verify(programmaticArguments).getLocalDatacenters();
    verify(programmaticArguments).getMetricRegistry();
    verify(programmaticArguments).getNodeDistanceEvaluators();
    verify(programmaticArguments).getNodeFilters();
    verify(programmaticArguments).getNodeStateListener();
    verify(programmaticArguments).getRequestTracker();
    verify(programmaticArguments).getSchemaChangeListener();
    verify(programmaticArguments).getStartupApplicationName();
    verify(programmaticArguments).getStartupApplicationVersion();
    verify(programmaticArguments).getStartupClientId();
    verify(programmaticArguments).getTypeCodecs();
    assertTrue(actualBuildContextResult.getConfigLoader() instanceof DefaultDriverConfigLoader);
    assertTrue(actualBuildContextResult.getConfig() instanceof TypesafeDriverConfig);
    assertTrue(actualBuildContextResult instanceof GuavaDriverContext);
    assertNotNull(((GuavaDriverContext) actualBuildContextResult).getClassLoader());
  }

  /**
   * Test {@link GuavaSessionBuilder#wrap(CqlSession)}.
   *
   * <p>Method under test: {@link GuavaSessionBuilder#wrap(CqlSession)}
   */
  @Test
  @DisplayName("Test wrap(CqlSession)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GuavaSession GuavaSessionBuilder.wrap(CqlSession)"})
  void testWrap() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DefaultGuavaSession delegate = new DefaultGuavaSession(mock(Session.class));
    SessionWrapper delegate2 = new SessionWrapper(delegate);
    DefaultDseSession defaultSession = new DefaultDseSession(delegate2);

    // Act
    GuavaSession actualWrapResult = builderResult.wrap(defaultSession);

    // Assert
    assertTrue(actualWrapResult instanceof DefaultGuavaSession);
    assertNull(actualWrapResult.getContext());
    assertNull(actualWrapResult.getMetadata());
    assertNull(actualWrapResult.getName());
    assertFalse(actualWrapResult.isSchemaMetadataEnabled());
    Optional<CqlIdentifier> keyspace = actualWrapResult.getKeyspace();
    assertFalse(keyspace.isPresent());
    assertSame(defaultSession, ((DefaultGuavaSession) actualWrapResult).getDelegate());
    assertSame(keyspace, actualWrapResult.getMetrics());
  }

  /**
   * Test new {@link GuavaSessionBuilder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GuavaSessionBuilder}
   */
  @Test
  @DisplayName("Test new GuavaSessionBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GuavaSessionBuilder.<init>()"})
  void testNewGuavaSessionBuilder() {
    // Arrange, Act and Assert
    GuavaSession wrapResult = new GuavaSessionBuilder().wrap(null);
    assertTrue(wrapResult instanceof DefaultGuavaSession);
    assertNull(((DefaultGuavaSession) wrapResult).getDelegate());
  }
}
