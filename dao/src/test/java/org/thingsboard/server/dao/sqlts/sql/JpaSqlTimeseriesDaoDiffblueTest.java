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
package org.thingsboard.server.dao.sqlts.sql;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.LocalDateTime;
import javax.sql.DataSource;
import oracle.jdbc.rowset.OracleCachedRowSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.timeseries.NoSqlTsPartitionDate;
import org.thingsboard.server.dao.timeseries.SqlTsPartitionDate;

@RunWith(MockitoJUnitRunner.class)
public class JpaSqlTimeseriesDaoDiffblueTest {
  @Mock private DataSource dataSource;

  @InjectMocks private JpaSqlTimeseriesDao jpaSqlTimeseriesDao;

  @Mock private SqlTsPartitionDate sqlTsPartitionDate;

  /**
   * Test {@link JpaSqlTimeseriesDao#init()}.
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.init()"})
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new JpaSqlTimeseriesDao().init());
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given {@link SqlTsPartitionDate} {@link SqlTsPartitionDate#plusTo(LocalDateTime)} throw
   *       {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaSqlTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenSqlTsPartitionDatePlusToThrowRuntimeException_thenCallsPlusTo() {
    // Arrange
    when(sqlTsPartitionDate.plusTo(Mockito.<LocalDateTime>any())).thenThrow(new RuntimeException());
    when(sqlTsPartitionDate.trancateTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaSqlTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 1L));
    verify(sqlTsPartitionDate).plusTo(isA(LocalDateTime.class));
    verify(sqlTsPartitionDate).trancateTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given {@link SqlTsPartitionDate} {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaSqlTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenSqlTsPartitionDateTrancateToThrowRuntimeException() {
    // Arrange
    when(sqlTsPartitionDate.trancateTo(Mockito.<LocalDateTime>any()))
        .thenThrow(new RuntimeException());
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaSqlTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 1L));
    verify(sqlTsPartitionDate).trancateTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Then calls {@link SqlTsPartitionDate#getPattern()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaSqlTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_thenCallsGetPattern() {
    // Arrange
    when(sqlTsPartitionDate.getPattern()).thenThrow(new RuntimeException());
    when(sqlTsPartitionDate.plusTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    when(sqlTsPartitionDate.trancateTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaSqlTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 1L));
    verify(sqlTsPartitionDate).getPattern();
    verify(sqlTsPartitionDate).plusTo(isA(LocalDateTime.class));
    verify(sqlTsPartitionDate).trancateTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#prepareStatement(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenConnectionPrepareStatementThrowRuntimeException()
      throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenThrow(new RuntimeException());
    doThrow(new RuntimeException()).when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaSqlTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement("call drop_partitions_by_system_ttl(?,?,?)");
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link DataSource} {@link DataSource#getConnection()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenDataSourceGetConnectionThrowRuntimeException() throws SQLException {
    // Arrange
    when(dataSource.getConnection()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaSqlTimeseriesDao.cleanup(1L));
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link DataSource} {@link DataSource#getConnection()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then calls {@link DataSource#getConnection()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenDataSourceGetConnectionThrowSQLException_thenCallsGetConnection()
      throws SQLException {
    // Arrange
    when(dataSource.getConnection()).thenThrow(new SQLException());

    // Act
    jpaSqlTimeseriesDao.cleanup(1L);

    // Assert
    verify(dataSource, atLeast(1)).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenPreparedStatementSetStringThrowRuntimeException()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new RuntimeException())
        .when(preparedStatement)
        .setString(anyInt(), Mockito.<String>any());
    doThrow(new RuntimeException()).when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaSqlTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement("call drop_partitions_by_system_ttl(?,?,?)");
    verify(preparedStatement).setString(1, null);
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_thenCallsExecute() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getResultSet()).thenReturn(new OracleCachedRowSet());
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    jpaSqlTimeseriesDao.cleanup(1L);

    // Assert
    verify(connection, atLeast(1)).close();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setObject(eq(1), isA(Object.class));
    verify(preparedStatement).setString(1, null);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(preparedStatement, atLeast(1)).setQueryTimeout(3600);
    verify(dataSource, atLeast(1)).getConnection();
  }
}
