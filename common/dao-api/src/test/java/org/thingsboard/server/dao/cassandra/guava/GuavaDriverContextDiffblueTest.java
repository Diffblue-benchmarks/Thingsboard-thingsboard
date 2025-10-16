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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.oss.driver.api.core.auth.AuthProvider;
import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.api.core.config.DriverOption;
import com.datastax.oss.driver.api.core.loadbalancing.LoadBalancingPolicy;
import com.datastax.oss.driver.api.core.metadata.NodeStateListenerBase;
import com.datastax.oss.driver.api.core.metadata.schema.SchemaChangeListenerBase;
import com.datastax.oss.driver.api.core.session.ProgrammaticArguments;
import com.datastax.oss.driver.api.core.session.ProgrammaticArguments.Builder;
import com.datastax.oss.driver.api.core.ssl.ProgrammaticSslEngineFactory;
import com.datastax.oss.driver.api.core.tracker.RequestTracker;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.internal.core.config.DerivedExecutionProfile;
import com.datastax.oss.driver.internal.core.config.composite.CompositeDriverConfig;
import com.datastax.oss.driver.internal.core.config.typesafe.DefaultDriverConfigLoader;
import com.datastax.oss.driver.internal.core.config.typesafe.TypesafeDriverConfig;
import com.datastax.oss.driver.internal.core.context.DefaultNettyOptions;
import com.datastax.oss.driver.internal.core.cql.CqlPrepareSyncProcessor;
import com.datastax.oss.driver.internal.core.cql.CqlRequestSyncProcessor;
import com.datastax.oss.driver.internal.core.metrics.DefaultMetricsFactory;
import com.datastax.oss.driver.internal.core.session.RequestProcessor;
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
import org.mockito.Mockito;

class GuavaDriverContextDiffblueTest {
  /**
   * Test {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments)}.
   *
   * <p>Method under test: {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName("Test new GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GuavaDriverContext.<init>(DriverConfigLoader, ProgrammaticArguments)"})
  void testNewGuavaDriverContext() {
    // Arrange
    DerivedExecutionProfile derivedExecutionProfile = mock(DerivedExecutionProfile.class);
    when(derivedExecutionProfile.getString(Mockito.<DriverOption>any())).thenReturn("String");
    when(derivedExecutionProfile.isDefined(Mockito.<DriverOption>any())).thenReturn(true);

    CompositeDriverConfig compositeDriverConfig = mock(CompositeDriverConfig.class);
    when(compositeDriverConfig.getDefaultProfile()).thenReturn(derivedExecutionProfile);

    DefaultDriverConfigLoader configLoader = mock(DefaultDriverConfigLoader.class);
    when(configLoader.getInitialConfig()).thenReturn(compositeDriverConfig);

    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener())
        .thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    DefaultCodecRegistry defaultCodecRegistry = new DefaultCodecRegistry("Log Prefix");
    when(programmaticArguments.getCodecRegistry()).thenReturn(defaultCodecRegistry);
    when(programmaticArguments.getClassLoader()).thenReturn(new MLet());
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress())
        .thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs())
        .thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    GuavaDriverContext actualGuavaDriverContext =
        new GuavaDriverContext(configLoader, programmaticArguments);

    // Assert
    verify(compositeDriverConfig).getDefaultProfile();
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
    verify(derivedExecutionProfile).getString(isA(DriverOption.class));
    verify(derivedExecutionProfile).isDefined(isA(DriverOption.class));
    verify(configLoader).getInitialConfig();
    assertEquals("String", actualGuavaDriverContext.getSessionName());
    assertNotNull(actualGuavaDriverContext.getClassLoader());
    Map<String, LoadBalancingPolicy> loadBalancingPolicies =
        actualGuavaDriverContext.getLoadBalancingPolicies();
    assertTrue(loadBalancingPolicies.isEmpty());
    assertSame(defaultCodecRegistry, actualGuavaDriverContext.getCodecRegistry());
    assertSame(loadBalancingPolicies, actualGuavaDriverContext.getRetryPolicies());
    assertSame(loadBalancingPolicies, actualGuavaDriverContext.getSpeculativeExecutionPolicies());
    assertSame(configLoader, actualGuavaDriverContext.getConfigLoader());
  }

  /**
   * Test {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments)}.
   *
   * <ul>
   *   <li>Then ConfigLoader return {@link DefaultDriverConfigLoader}.
   * </ul>
   *
   * <p>Method under test: {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName(
      "Test new GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments); then ConfigLoader return DefaultDriverConfigLoader")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GuavaDriverContext.<init>(DriverConfigLoader, ProgrammaticArguments)"})
  void testNewGuavaDriverContext_thenConfigLoaderReturnDefaultDriverConfigLoader()
      throws NoSuchAlgorithmException {
    // Arrange
    DefaultDriverConfigLoader configLoader = new DefaultDriverConfigLoader();

    Builder builderResult = ProgrammaticArguments.builder();

    Builder withAuthProviderResult =
        builderResult.withAuthProvider(
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
    ProgrammaticArguments programmaticArguments =
        withStartupApplicationVersionResult.withStartupClientId(UUID.randomUUID()).build();

    // Act
    GuavaDriverContext actualGuavaDriverContext =
        new GuavaDriverContext(configLoader, programmaticArguments);

    // Assert
    assertTrue(actualGuavaDriverContext.getConfigLoader() instanceof DefaultDriverConfigLoader);
    assertTrue(actualGuavaDriverContext.getConfig() instanceof TypesafeDriverConfig);
    assertTrue(actualGuavaDriverContext.getNettyOptions() instanceof DefaultNettyOptions);
    assertTrue(actualGuavaDriverContext.getMetricsFactory() instanceof DefaultMetricsFactory);
    assertNotNull(actualGuavaDriverContext.getClassLoader());
    Map<String, LoadBalancingPolicy> loadBalancingPolicies =
        actualGuavaDriverContext.getLoadBalancingPolicies();
    assertEquals(1, loadBalancingPolicies.size());
    assertTrue(loadBalancingPolicies.containsKey("default"));
  }

  /**
   * Test {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments)}.
   *
   * <ul>
   *   <li>Then return not AuthProvider Present.
   * </ul>
   *
   * <p>Method under test: {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName(
      "Test new GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments); then return not AuthProvider Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GuavaDriverContext.<init>(DriverConfigLoader, ProgrammaticArguments)"})
  void testNewGuavaDriverContext_thenReturnNotAuthProviderPresent() {
    // Arrange
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
    Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs())
        .thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    GuavaDriverContext actualGuavaDriverContext =
        new GuavaDriverContext(configLoader, programmaticArguments);

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
    assertNotNull(actualGuavaDriverContext.getClassLoader());
    Optional<AuthProvider> authProvider = actualGuavaDriverContext.getAuthProvider();
    assertFalse(authProvider.isPresent());
    assertSame(authProvider, actualGuavaDriverContext.getSslEngineFactory());
    assertSame(authProvider, actualGuavaDriverContext.getSslHandlerFactory());
  }

  /**
   * Test {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments)}.
   *
   * <ul>
   *   <li>When {@link ProgrammaticArguments} {@link ProgrammaticArguments#getCodecRegistry()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GuavaDriverContext#GuavaDriverContext(DriverConfigLoader,
   * ProgrammaticArguments)}
   */
  @Test
  @DisplayName(
      "Test new GuavaDriverContext(DriverConfigLoader, ProgrammaticArguments); when ProgrammaticArguments getCodecRegistry() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GuavaDriverContext.<init>(DriverConfigLoader, ProgrammaticArguments)"})
  void testNewGuavaDriverContext_whenProgrammaticArgumentsGetCodecRegistryReturnNull() {
    // Arrange
    DerivedExecutionProfile derivedExecutionProfile = mock(DerivedExecutionProfile.class);
    when(derivedExecutionProfile.getString(Mockito.<DriverOption>any())).thenReturn("String");
    when(derivedExecutionProfile.isDefined(Mockito.<DriverOption>any())).thenReturn(true);

    CompositeDriverConfig compositeDriverConfig = mock(CompositeDriverConfig.class);
    when(compositeDriverConfig.getDefaultProfile()).thenReturn(derivedExecutionProfile);

    DefaultDriverConfigLoader configLoader = mock(DefaultDriverConfigLoader.class);
    when(configLoader.getInitialConfig()).thenReturn(compositeDriverConfig);

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
    Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs())
        .thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    GuavaDriverContext actualGuavaDriverContext =
        new GuavaDriverContext(configLoader, programmaticArguments);

    // Assert
    verify(compositeDriverConfig).getDefaultProfile();
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
    verify(derivedExecutionProfile).getString(isA(DriverOption.class));
    verify(derivedExecutionProfile).isDefined(isA(DriverOption.class));
    verify(configLoader).getInitialConfig();
    assertEquals("String", actualGuavaDriverContext.getSessionName());
    assertNotNull(actualGuavaDriverContext.getClassLoader());
    Map<String, LoadBalancingPolicy> loadBalancingPolicies =
        actualGuavaDriverContext.getLoadBalancingPolicies();
    assertTrue(loadBalancingPolicies.isEmpty());
    assertSame(loadBalancingPolicies, actualGuavaDriverContext.getRetryPolicies());
    assertSame(loadBalancingPolicies, actualGuavaDriverContext.getSpeculativeExecutionPolicies());
    assertSame(configLoader, actualGuavaDriverContext.getConfigLoader());
  }

  /**
   * Test {@link GuavaDriverContext#buildRequestProcessorRegistry()}.
   *
   * <p>Method under test: {@link GuavaDriverContext#buildRequestProcessorRegistry()}
   */
  @Test
  @DisplayName("Test buildRequestProcessorRegistry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RequestProcessorRegistry GuavaDriverContext.buildRequestProcessorRegistry()"})
  void testBuildRequestProcessorRegistry() throws NoSuchAlgorithmException {
    // Arrange
    DefaultDriverConfigLoader configLoader = new DefaultDriverConfigLoader();

    Builder builderResult = ProgrammaticArguments.builder();

    Builder withAuthProviderResult =
        builderResult.withAuthProvider(
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
    ProgrammaticArguments programmaticArguments =
        withStartupApplicationVersionResult.withStartupClientId(UUID.randomUUID()).build();

    GuavaDriverContext guavaDriverContext =
        new GuavaDriverContext(configLoader, programmaticArguments);

    // Act and Assert
    Iterable<RequestProcessor<?, ?>> processors =
        guavaDriverContext.buildRequestProcessorRegistry().getProcessors();
    assertEquals(4, ((List<RequestProcessor<?, ?>>) processors).size());
    assertTrue(
        ((List<RequestProcessor<?, ?>>) processors).get(1) instanceof CqlPrepareSyncProcessor);
    assertTrue(
        ((List<RequestProcessor<?, ?>>) processors).get(0) instanceof CqlRequestSyncProcessor);
    assertTrue(processors instanceof List);
    assertTrue(
        ((List<RequestProcessor<?, ?>>) processors).get(2) instanceof GuavaRequestAsyncProcessor);
    assertTrue(
        ((List<RequestProcessor<?, ?>>) processors).get(3) instanceof GuavaRequestAsyncProcessor);
  }
}
