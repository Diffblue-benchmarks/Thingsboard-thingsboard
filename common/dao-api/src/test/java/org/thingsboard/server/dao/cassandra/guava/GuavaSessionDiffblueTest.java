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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.cql.AsyncResultSet;
import com.datastax.oss.driver.api.core.cql.BatchType;
import com.datastax.oss.driver.api.core.cql.BatchableStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.cql.Statement;
import com.datastax.oss.driver.api.core.metadata.NodeStateListenerBase;
import com.datastax.oss.driver.api.core.metadata.schema.SchemaChangeListenerBase;
import com.datastax.oss.driver.api.core.metadata.token.Token;
import com.datastax.oss.driver.api.core.session.ProgrammaticArguments;
import com.datastax.oss.driver.api.core.session.Session;
import com.datastax.oss.driver.api.core.tracker.RequestTracker;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.reflect.GenericType;
import com.datastax.oss.driver.internal.core.config.typesafe.DefaultDriverConfigLoader;
import com.datastax.oss.driver.internal.core.cql.DefaultBatchStatement;
import com.datastax.oss.driver.internal.core.cql.DefaultPrepareRequest;
import com.datastax.oss.driver.internal.core.cql.DefaultSimpleStatement;
import com.datastax.oss.driver.internal.core.metadata.DefaultEndPoint;
import com.datastax.oss.driver.internal.core.metadata.DefaultNode;
import com.datastax.oss.driver.internal.core.type.codec.registry.DefaultCodecRegistry;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.management.loading.MLet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GuavaSessionDiffblueTest {
  /**
   * Method under test: {@link GuavaSession#executeAsync(Statement)}
   */
  @Test
  void testExecuteAsync() throws UnsupportedEncodingException {
    // Arrange
    Session delegate = mock(Session.class);
    SettableFuture<AsyncResultSet> createResult = SettableFuture.create();
    when(delegate.execute(Mockito.<DefaultBatchStatement>any(),
        Mockito.<GenericType<ListenableFuture<AsyncResultSet>>>any())).thenReturn(createResult);
    DefaultGuavaSession defaultGuavaSession = new DefaultGuavaSession(new DefaultDseSession(delegate));
    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener()).thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    when(programmaticArguments.getCodecRegistry()).thenReturn(new DefaultCodecRegistry("Log Prefix"));
    when(programmaticArguments.getClassLoader()).thenReturn(new MLet());
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs()).thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());
    GuavaDriverContext context = new GuavaDriverContext(new DefaultDriverConfigLoader(), programmaticArguments);

    DefaultNode node = new DefaultNode(new DefaultEndPoint(InetSocketAddress.createUnresolved("foo", 1)), context);

    BatchType batchType = mock(BatchType.class);
    ArrayList<BatchableStatement<?>> statements = new ArrayList<>();
    CqlIdentifier keyspace = CqlIdentifier.fromInternal("Internal");
    CqlIdentifier routingKeyspace = CqlIdentifier.fromInternal("Internal");
    ByteBuffer routingKey = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));
    Token routingToken = mock(Token.class);
    HashMap<String, ByteBuffer> customPayload = new HashMap<>();

    // Act
    ListenableFuture<AsyncResultSet> actualExecuteAsyncResult = defaultGuavaSession
        .executeAsync(new DefaultBatchStatement(batchType, statements, "foo.txt", null, keyspace, routingKeyspace,
            routingKey, routingToken, customPayload, true, true, 10L, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")), 3,
            mock(ConsistencyLevel.class), mock(ConsistencyLevel.class), null, node, 1));

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
    verify(delegate).execute(isA(DefaultBatchStatement.class), isA(GenericType.class));
    assertTrue(actualExecuteAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualExecuteAsyncResult);
  }

  /**
   * Method under test: {@link GuavaSession#executeAsync(String)}
   */
  @Test
  void testExecuteAsync2() {
    // Arrange
    Session delegate = mock(Session.class);
    SettableFuture<AsyncResultSet> createResult = SettableFuture.create();
    when(delegate.execute(Mockito.<DefaultSimpleStatement>any(),
        Mockito.<GenericType<ListenableFuture<AsyncResultSet>>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<AsyncResultSet> actualExecuteAsyncResult = (new DefaultGuavaSession(
        new DefaultDseSession(delegate))).executeAsync("MD");

    // Assert
    verify(delegate).execute(isA(DefaultSimpleStatement.class), isA(GenericType.class));
    assertTrue(actualExecuteAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualExecuteAsyncResult);
  }

  /**
   * Method under test: {@link GuavaSession#prepareAsync(SimpleStatement)}
   */
  @Test
  void testPrepareAsync() throws UnsupportedEncodingException {
    // Arrange
    Session delegate = mock(Session.class);
    SettableFuture<PreparedStatement> createResult = SettableFuture.create();
    when(delegate.execute(Mockito.<DefaultPrepareRequest>any(),
        Mockito.<GenericType<ListenableFuture<PreparedStatement>>>any())).thenReturn(createResult);
    DefaultGuavaSession defaultGuavaSession = new DefaultGuavaSession(new DefaultDseSession(delegate));
    ProgrammaticArguments programmaticArguments = mock(ProgrammaticArguments.class);
    when(programmaticArguments.getNodeStateListener()).thenReturn(new NodeStateListenerBase());
    when(programmaticArguments.getSchemaChangeListener()).thenReturn(new SchemaChangeListenerBase());
    when(programmaticArguments.getRequestTracker()).thenReturn(mock(RequestTracker.class));
    when(programmaticArguments.getCodecRegistry()).thenReturn(new DefaultCodecRegistry("Log Prefix"));
    when(programmaticArguments.getClassLoader()).thenReturn(new MLet());
    when(programmaticArguments.getMetricRegistry()).thenReturn("Metric Registry");
    when(programmaticArguments.getStartupApplicationName()).thenReturn("Startup Application Name");
    when(programmaticArguments.getStartupApplicationVersion()).thenReturn("1.0.2");
    when(programmaticArguments.getCloudProxyAddress()).thenReturn(InetSocketAddress.createUnresolved("foo", 1));
    Mockito.<List<TypeCodec<?>>>when(programmaticArguments.getTypeCodecs()).thenReturn(new ArrayList<>());
    when(programmaticArguments.getLocalDatacenters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeDistanceEvaluators()).thenReturn(new HashMap<>());
    when(programmaticArguments.getNodeFilters()).thenReturn(new HashMap<>());
    when(programmaticArguments.getStartupClientId()).thenReturn(UUID.randomUUID());
    GuavaDriverContext context = new GuavaDriverContext(new DefaultDriverConfigLoader(), programmaticArguments);

    DefaultNode node = new DefaultNode(new DefaultEndPoint(InetSocketAddress.createUnresolved("foo", 1)), context);

    ArrayList<Object> positionalValues = new ArrayList<>();
    HashMap<CqlIdentifier, Object> namedValues = new HashMap<>();
    CqlIdentifier keyspace = CqlIdentifier.fromInternal("Internal");
    CqlIdentifier routingKeyspace = CqlIdentifier.fromInternal("Internal");
    ByteBuffer routingKey = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));
    Token routingToken = mock(Token.class);
    HashMap<String, ByteBuffer> customPayload = new HashMap<>();

    // Act
    ListenableFuture<PreparedStatement> actualPrepareAsyncResult = defaultGuavaSession.prepareAsync(
        new DefaultSimpleStatement("Query", positionalValues, namedValues, "foo.txt", null, keyspace, routingKeyspace,
            routingKey, routingToken, customPayload, true, true, 10L, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")), 3,
            mock(ConsistencyLevel.class), mock(ConsistencyLevel.class), null, node, 1));

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
    verify(delegate).execute(isA(DefaultPrepareRequest.class), isA(GenericType.class));
    assertTrue(actualPrepareAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualPrepareAsyncResult);
  }

  /**
   * Method under test: {@link GuavaSession#prepareAsync(String)}
   */
  @Test
  void testPrepareAsync2() {
    // Arrange
    Session delegate = mock(Session.class);
    SettableFuture<PreparedStatement> createResult = SettableFuture.create();
    when(delegate.execute(Mockito.<DefaultPrepareRequest>any(),
        Mockito.<GenericType<ListenableFuture<PreparedStatement>>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<PreparedStatement> actualPrepareAsyncResult = (new DefaultGuavaSession(
        new DefaultDseSession(delegate))).prepareAsync("MD");

    // Assert
    verify(delegate).execute(isA(DefaultPrepareRequest.class), isA(GenericType.class));
    assertTrue(actualPrepareAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualPrepareAsyncResult);
  }
}
