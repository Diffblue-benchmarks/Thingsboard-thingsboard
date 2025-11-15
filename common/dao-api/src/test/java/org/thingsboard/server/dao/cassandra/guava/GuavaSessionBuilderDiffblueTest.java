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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.dse.driver.internal.core.InsightsClientLifecycleListener;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.api.core.config.DriverOption;
import com.datastax.oss.driver.api.core.context.DriverContext;
import com.datastax.oss.driver.api.core.loadbalancing.LoadBalancingPolicy;
import com.datastax.oss.driver.api.core.metadata.NodeStateListenerBase;
import com.datastax.oss.driver.api.core.metadata.schema.SchemaChangeListenerBase;
import com.datastax.oss.driver.api.core.servererrors.DefaultWriteType;
import com.datastax.oss.driver.api.core.servererrors.WriteType;
import com.datastax.oss.driver.api.core.session.ProgrammaticArguments;
import com.datastax.oss.driver.api.core.session.Session;
import com.datastax.oss.driver.api.core.tracker.RequestTracker;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.codec.registry.CodecRegistry;
import com.datastax.oss.driver.internal.core.ConsistencyLevelRegistry;
import com.datastax.oss.driver.internal.core.DefaultConsistencyLevelRegistry;
import com.datastax.oss.driver.internal.core.DefaultProtocolVersionRegistry;
import com.datastax.oss.driver.internal.core.channel.DefaultWriteCoalescer;
import com.datastax.oss.driver.internal.core.config.DerivedExecutionProfile;
import com.datastax.oss.driver.internal.core.config.composite.CompositeDriverConfig;
import com.datastax.oss.driver.internal.core.config.typesafe.DefaultDriverConfigLoader;
import com.datastax.oss.driver.internal.core.context.LifecycleListener;
import com.datastax.oss.driver.internal.core.cql.CqlPrepareSyncProcessor;
import com.datastax.oss.driver.internal.core.cql.CqlRequestSyncProcessor;
import com.datastax.oss.driver.internal.core.metadata.schema.parsing.DefaultSchemaParserFactory;
import com.datastax.oss.driver.internal.core.metadata.schema.queries.DefaultSchemaQueriesFactory;
import com.datastax.oss.driver.internal.core.metadata.token.DefaultReplicationStrategyFactory;
import com.datastax.oss.driver.internal.core.metadata.token.DefaultTokenFactoryRegistry;
import com.datastax.oss.driver.internal.core.servererrors.DefaultWriteTypeRegistry;
import com.datastax.oss.driver.internal.core.servererrors.WriteTypeRegistry;
import com.datastax.oss.driver.internal.core.session.RequestProcessor;
import com.datastax.oss.driver.internal.core.type.codec.registry.DefaultCodecRegistry;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.management.loading.MLet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GuavaSessionBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link GuavaSessionBuilder#buildContext(DriverConfigLoader, ProgrammaticArguments)}
   */
  @Test
  void testBuildContext() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DerivedExecutionProfile derivedExecutionProfile = mock(DerivedExecutionProfile.class);
    when(derivedExecutionProfile.getString(Mockito.<DriverOption>any())).thenReturn("String");
    when(derivedExecutionProfile.isDefined(Mockito.<DriverOption>any())).thenReturn(true);
    CompositeDriverConfig compositeDriverConfig = mock(CompositeDriverConfig.class);
    when(compositeDriverConfig.getDefaultProfile()).thenReturn(derivedExecutionProfile);
    DefaultDriverConfigLoader configLoader = mock(DefaultDriverConfigLoader.class);
    when(configLoader.getInitialConfig()).thenReturn(compositeDriverConfig);
    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener()).thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    DefaultCodecRegistry defaultCodecRegistry = new DefaultCodecRegistry("Log Prefix");
    when(programmaticArguments.getCodecRegistry()).thenReturn(defaultCodecRegistry);
    MLet mLet = new MLet();
    when(programmaticArguments.getClassLoader()).thenReturn(mLet);
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs()).thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    DriverContext actualBuildContextResult = builderResult.buildContext(configLoader, programmaticArguments);

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
    List<LifecycleListener> lifecycleListeners = ((GuavaDriverContext) actualBuildContextResult)
        .getLifecycleListeners();
    assertEquals(1, lifecycleListeners.size());
    assertTrue(lifecycleListeners.get(0) instanceof InsightsClientLifecycleListener);
    ConsistencyLevelRegistry consistencyLevelRegistry = ((GuavaDriverContext) actualBuildContextResult)
        .getConsistencyLevelRegistry();
    Iterable<ConsistencyLevel> values = consistencyLevelRegistry.getValues();
    assertEquals(11, ((List<ConsistencyLevel>) values).size());
    ConsistencyLevel getResult = ((List<ConsistencyLevel>) values).get(0);
    assertTrue(getResult instanceof DefaultConsistencyLevel);
    ConsistencyLevel getResult2 = ((List<ConsistencyLevel>) values).get(1);
    assertTrue(getResult2 instanceof DefaultConsistencyLevel);
    ConsistencyLevel getResult3 = ((List<ConsistencyLevel>) values).get(10);
    assertTrue(getResult3 instanceof DefaultConsistencyLevel);
    ConsistencyLevel getResult4 = ((List<ConsistencyLevel>) values).get(9);
    assertTrue(getResult4 instanceof DefaultConsistencyLevel);
    WriteTypeRegistry writeTypeRegistry = ((GuavaDriverContext) actualBuildContextResult).getWriteTypeRegistry();
    Iterable<WriteType> values2 = writeTypeRegistry.getValues();
    WriteType getResult5 = ((List<WriteType>) values2).get(0);
    assertTrue(getResult5 instanceof DefaultWriteType);
    WriteType getResult6 = ((List<WriteType>) values2).get(1);
    assertTrue(getResult6 instanceof DefaultWriteType);
    WriteType getResult7 = ((List<WriteType>) values2).get(6);
    assertTrue(getResult7 instanceof DefaultWriteType);
    WriteType getResult8 = ((List<WriteType>) values2).get(7);
    assertTrue(getResult8 instanceof DefaultWriteType);
    assertTrue(consistencyLevelRegistry instanceof DefaultConsistencyLevelRegistry);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getProtocolVersionRegistry() instanceof DefaultProtocolVersionRegistry);
    assertTrue(((GuavaDriverContext) actualBuildContextResult).getWriteCoalescer() instanceof DefaultWriteCoalescer);
    Iterable<RequestProcessor<?, ?>> processors = ((GuavaDriverContext) actualBuildContextResult)
        .getRequestProcessorRegistry()
        .getProcessors();
    assertEquals(4, ((List<RequestProcessor<?, ?>>) processors).size());
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(1) instanceof CqlPrepareSyncProcessor);
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(0) instanceof CqlRequestSyncProcessor);
    assertTrue(
        ((GuavaDriverContext) actualBuildContextResult).getSchemaParserFactory() instanceof DefaultSchemaParserFactory);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getSchemaQueriesFactory() instanceof DefaultSchemaQueriesFactory);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getReplicationStrategyFactory() instanceof DefaultReplicationStrategyFactory);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getTokenFactoryRegistry() instanceof DefaultTokenFactoryRegistry);
    assertTrue(writeTypeRegistry instanceof DefaultWriteTypeRegistry);
    CodecRegistry codecRegistry = actualBuildContextResult.getCodecRegistry();
    assertTrue(codecRegistry instanceof DefaultCodecRegistry);
    assertTrue(values instanceof List);
    assertTrue(processors instanceof List);
    assertTrue(actualBuildContextResult instanceof GuavaDriverContext);
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(2) instanceof GuavaRequestAsyncProcessor);
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(3) instanceof GuavaRequestAsyncProcessor);
    assertEquals("Metric Registry", ((GuavaDriverContext) actualBuildContextResult).getMetricRegistry());
    assertEquals("String", actualBuildContextResult.getSessionName());
    ClassLoader classLoader = ((GuavaDriverContext) actualBuildContextResult).getClassLoader();
    assertNotNull(classLoader);
    assertEquals(8, ((List<WriteType>) values2).size());
    assertEquals(DefaultConsistencyLevel.ANY, getResult);
    assertEquals(DefaultConsistencyLevel.LOCAL_SERIAL, getResult3);
    assertEquals(DefaultConsistencyLevel.ONE, getResult2);
    assertEquals(DefaultConsistencyLevel.SERIAL, getResult4);
    assertEquals(DefaultWriteType.BATCH, getResult6);
    assertEquals(DefaultWriteType.CDC, getResult8);
    assertEquals(DefaultWriteType.SIMPLE, getResult5);
    assertEquals(DefaultWriteType.VIEW, getResult7);
    Map<String, LoadBalancingPolicy> loadBalancingPolicies = actualBuildContextResult.getLoadBalancingPolicies();
    assertTrue(loadBalancingPolicies.isEmpty());
    assertSame(defaultCodecRegistry, codecRegistry);
    assertSame(mLet, classLoader);
    assertSame(loadBalancingPolicies, actualBuildContextResult.getRetryPolicies());
    assertSame(loadBalancingPolicies, actualBuildContextResult.getSpeculativeExecutionPolicies());
    assertSame(configLoader, actualBuildContextResult.getConfigLoader());
  }

  /**
   * Method under test:
   * {@link GuavaSessionBuilder#buildContext(DriverConfigLoader, ProgrammaticArguments)}
   */
  @Test
  void testBuildContext2() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DerivedExecutionProfile derivedExecutionProfile = mock(DerivedExecutionProfile.class);
    when(derivedExecutionProfile.getString(Mockito.<DriverOption>any())).thenReturn("String");
    when(derivedExecutionProfile.isDefined(Mockito.<DriverOption>any())).thenReturn(true);
    CompositeDriverConfig compositeDriverConfig = mock(CompositeDriverConfig.class);
    when(compositeDriverConfig.getDefaultProfile()).thenReturn(derivedExecutionProfile);
    DefaultDriverConfigLoader configLoader = mock(DefaultDriverConfigLoader.class);
    when(configLoader.getInitialConfig()).thenReturn(compositeDriverConfig);
    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener()).thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    when(programmaticArguments.getCodecRegistry()).thenReturn(null);
    MLet mLet = new MLet();
    when(programmaticArguments.getClassLoader()).thenReturn(mLet);
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs()).thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());

    // Act
    DriverContext actualBuildContextResult = builderResult.buildContext(configLoader, programmaticArguments);

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
    List<LifecycleListener> lifecycleListeners = ((GuavaDriverContext) actualBuildContextResult)
        .getLifecycleListeners();
    assertEquals(1, lifecycleListeners.size());
    assertTrue(lifecycleListeners.get(0) instanceof InsightsClientLifecycleListener);
    ConsistencyLevelRegistry consistencyLevelRegistry = ((GuavaDriverContext) actualBuildContextResult)
        .getConsistencyLevelRegistry();
    Iterable<ConsistencyLevel> values = consistencyLevelRegistry.getValues();
    assertEquals(11, ((List<ConsistencyLevel>) values).size());
    ConsistencyLevel getResult = ((List<ConsistencyLevel>) values).get(0);
    assertTrue(getResult instanceof DefaultConsistencyLevel);
    ConsistencyLevel getResult2 = ((List<ConsistencyLevel>) values).get(1);
    assertTrue(getResult2 instanceof DefaultConsistencyLevel);
    ConsistencyLevel getResult3 = ((List<ConsistencyLevel>) values).get(10);
    assertTrue(getResult3 instanceof DefaultConsistencyLevel);
    ConsistencyLevel getResult4 = ((List<ConsistencyLevel>) values).get(9);
    assertTrue(getResult4 instanceof DefaultConsistencyLevel);
    WriteTypeRegistry writeTypeRegistry = ((GuavaDriverContext) actualBuildContextResult).getWriteTypeRegistry();
    Iterable<WriteType> values2 = writeTypeRegistry.getValues();
    WriteType getResult5 = ((List<WriteType>) values2).get(0);
    assertTrue(getResult5 instanceof DefaultWriteType);
    WriteType getResult6 = ((List<WriteType>) values2).get(1);
    assertTrue(getResult6 instanceof DefaultWriteType);
    WriteType getResult7 = ((List<WriteType>) values2).get(6);
    assertTrue(getResult7 instanceof DefaultWriteType);
    WriteType getResult8 = ((List<WriteType>) values2).get(7);
    assertTrue(getResult8 instanceof DefaultWriteType);
    assertTrue(consistencyLevelRegistry instanceof DefaultConsistencyLevelRegistry);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getProtocolVersionRegistry() instanceof DefaultProtocolVersionRegistry);
    assertTrue(((GuavaDriverContext) actualBuildContextResult).getWriteCoalescer() instanceof DefaultWriteCoalescer);
    Iterable<RequestProcessor<?, ?>> processors = ((GuavaDriverContext) actualBuildContextResult)
        .getRequestProcessorRegistry()
        .getProcessors();
    assertEquals(4, ((List<RequestProcessor<?, ?>>) processors).size());
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(1) instanceof CqlPrepareSyncProcessor);
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(0) instanceof CqlRequestSyncProcessor);
    assertTrue(
        ((GuavaDriverContext) actualBuildContextResult).getSchemaParserFactory() instanceof DefaultSchemaParserFactory);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getSchemaQueriesFactory() instanceof DefaultSchemaQueriesFactory);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getReplicationStrategyFactory() instanceof DefaultReplicationStrategyFactory);
    assertTrue(((GuavaDriverContext) actualBuildContextResult)
        .getTokenFactoryRegistry() instanceof DefaultTokenFactoryRegistry);
    assertTrue(writeTypeRegistry instanceof DefaultWriteTypeRegistry);
    assertTrue(actualBuildContextResult.getCodecRegistry() instanceof DefaultCodecRegistry);
    assertTrue(values instanceof List);
    assertTrue(processors instanceof List);
    assertTrue(actualBuildContextResult instanceof GuavaDriverContext);
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(2) instanceof GuavaRequestAsyncProcessor);
    assertTrue(((List<RequestProcessor<?, ?>>) processors).get(3) instanceof GuavaRequestAsyncProcessor);
    assertEquals("Metric Registry", ((GuavaDriverContext) actualBuildContextResult).getMetricRegistry());
    assertEquals("String", actualBuildContextResult.getSessionName());
    ClassLoader classLoader = ((GuavaDriverContext) actualBuildContextResult).getClassLoader();
    assertNotNull(classLoader);
    assertEquals(8, ((List<WriteType>) values2).size());
    assertEquals(DefaultConsistencyLevel.ANY, getResult);
    assertEquals(DefaultConsistencyLevel.LOCAL_SERIAL, getResult3);
    assertEquals(DefaultConsistencyLevel.ONE, getResult2);
    assertEquals(DefaultConsistencyLevel.SERIAL, getResult4);
    assertEquals(DefaultWriteType.BATCH, getResult6);
    assertEquals(DefaultWriteType.CDC, getResult8);
    assertEquals(DefaultWriteType.SIMPLE, getResult5);
    assertEquals(DefaultWriteType.VIEW, getResult7);
    Map<String, LoadBalancingPolicy> loadBalancingPolicies = actualBuildContextResult.getLoadBalancingPolicies();
    assertTrue(loadBalancingPolicies.isEmpty());
    assertSame(mLet, classLoader);
    assertSame(loadBalancingPolicies, actualBuildContextResult.getRetryPolicies());
    assertSame(loadBalancingPolicies, actualBuildContextResult.getSpeculativeExecutionPolicies());
    assertSame(configLoader, actualBuildContextResult.getConfigLoader());
  }

  /**
   * Method under test: {@link GuavaSessionBuilder#wrap(CqlSession)}
   */
  @Test
  void testWrap() {
    // Arrange
    GuavaSessionBuilder builderResult = GuavaSessionUtils.builder();
    DefaultDseSession defaultSession = new DefaultDseSession(new DefaultGuavaSession(mock(Session.class)));

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
   * Method under test: default or parameterless constructor of
   * {@link GuavaSessionBuilder}
   */
  @Test
  void testNewGuavaSessionBuilder() {
    // Arrange, Act and Assert
    GuavaSession wrapResult = (new GuavaSessionBuilder()).wrap(null);
    assertTrue(wrapResult instanceof DefaultGuavaSession);
    assertNull(((DefaultGuavaSession) wrapResult).getDelegate());
  }
}
