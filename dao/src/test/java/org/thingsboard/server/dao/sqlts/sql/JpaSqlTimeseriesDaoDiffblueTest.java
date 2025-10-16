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
import javax.sql.DataSource;
import oracle.jdbc.rowset.OracleCachedRowSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.postgresql.util.PSQLWarning;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class JpaSqlTimeseriesDaoDiffblueTest {
  @Mock private DataSource dataSource;

  @InjectMocks private JpaSqlTimeseriesDao jpaSqlTimeseriesDao;

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
    assertThrows(RuntimeException.class, () -> jpaSqlTimeseriesDao.init());
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
   *   <li>Given {@link PSQLWarning} {@link PSQLWarning#getMessage()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link PSQLWarning#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenPSQLWarningGetMessageThrowRuntimeException_thenCallsGetMessage()
      throws SQLException {
    // Arrange
    PSQLWarning psqlWarning = mock(PSQLWarning.class);
    when(psqlWarning.getMessage()).thenThrow(new RuntimeException());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(psqlWarning);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaSqlTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement("call drop_partitions_by_system_ttl(?,?,?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setString(1, null);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(3600);
    verify(dataSource).getConnection();
    verify(psqlWarning).getMessage();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@link
   *       OracleCachedRowSet#OracleCachedRowSet()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenPreparedStatementGetResultSetReturnOracleCachedRowSet()
      throws SQLException {
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
}
