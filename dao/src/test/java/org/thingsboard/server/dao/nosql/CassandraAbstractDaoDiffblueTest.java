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
package org.thingsboard.server.dao.nosql;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.ProtocolVersion;
import com.datastax.oss.driver.api.core.cql.ColumnDefinitions;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.metadata.token.Token;
import com.datastax.oss.driver.internal.core.cql.DefaultPreparedStatement;
import com.datastax.oss.driver.internal.core.type.codec.registry.DefaultCodecRegistry;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.dao.cassandra.CassandraCluster;
import org.thingsboard.server.dao.cassandra.guava.DefaultGuavaSession;
import org.thingsboard.server.dao.timeseries.CassandraBaseTimeseriesDao;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CassandraAbstractDaoDiffblueTest {
  @InjectMocks private CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao;

  @Mock private CassandraCluster cassandraCluster;

  /**
   * Test {@link CassandraAbstractDao#prepare(String)}.
   *
   * <p>Method under test: {@link CassandraAbstractDao#prepare(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PreparedStatement CassandraAbstractDao.prepare(String)"})
  public void testPrepare() throws UnsupportedEncodingException {
    // Arrange
    DefaultGuavaSession defaultGuavaSession = mock(DefaultGuavaSession.class);
    ByteBuffer id = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));
    ColumnDefinitions variableDefinitions = mock(ColumnDefinitions.class);
    ArrayList<Integer> partitionKeyIndices = new ArrayList<>();
    ByteBuffer resultMetadataId = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));
    ColumnDefinitions resultSetDefinitions = mock(ColumnDefinitions.class);
    CqlIdentifier keyspace = CqlIdentifier.fromInternal("Internal");
    HashMap<String, ByteBuffer> customPayloadForPrepare = new HashMap<>();
    CqlIdentifier routingKeyspaceForBoundStatements = CqlIdentifier.fromInternal("Internal");
    ByteBuffer routingKeyForBoundStatements = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));
    Token routingTokenForBoundStatements = mock(Token.class);
    HashMap<String, ByteBuffer> customPayloadForBoundStatements = new HashMap<>();
    Duration timeoutForBoundStatements = Duration.ofSeconds(1L);
    ByteBuffer pagingStateForBoundStatements = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));
    ConsistencyLevel consistencyLevelForBoundStatements = mock(ConsistencyLevel.class);
    ConsistencyLevel serialConsistencyLevelForBoundStatements = mock(ConsistencyLevel.class);

    DefaultPreparedStatement defaultPreparedStatement =
        new DefaultPreparedStatement(
            id,
            "Query",
            variableDefinitions,
            partitionKeyIndices,
            resultMetadataId,
            resultSetDefinitions,
            keyspace,
            customPayloadForPrepare,
            "foo.txt",
            null,
            routingKeyspaceForBoundStatements,
            routingKeyForBoundStatements,
            routingTokenForBoundStatements,
            customPayloadForBoundStatements,
            true,
            timeoutForBoundStatements,
            pagingStateForBoundStatements,
            3,
            consistencyLevelForBoundStatements,
            serialConsistencyLevelForBoundStatements,
            true,
            new DefaultCodecRegistry("Log Prefix"),
            mock(ProtocolVersion.class));
    when(defaultGuavaSession.prepare(Mockito.<String>any())).thenReturn(defaultPreparedStatement);
    when(cassandraCluster.getDefaultReadConsistencyLevel())
        .thenReturn(mock(ConsistencyLevel.class));
    when(cassandraCluster.getDefaultWriteConsistencyLevel())
        .thenReturn(mock(ConsistencyLevel.class));
    when(cassandraCluster.getSession()).thenReturn(defaultGuavaSession);

    // Act
    PreparedStatement actualPrepareResult = cassandraBaseTimeseriesDao.prepare("Query");

    // Assert
    verify(defaultGuavaSession).prepare("Query");
    verify(cassandraCluster).getDefaultReadConsistencyLevel();
    verify(cassandraCluster).getDefaultWriteConsistencyLevel();
    verify(cassandraCluster).getSession();
    assertSame(defaultPreparedStatement, actualPrepareResult);
  }
}
