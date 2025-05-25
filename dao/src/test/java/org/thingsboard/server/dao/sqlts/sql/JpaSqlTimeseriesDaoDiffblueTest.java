package org.thingsboard.server.dao.sqlts.sql;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import javax.sql.DataSource;
import org.hibernate.exception.ConstraintViolationException;
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
  @Mock
  private DataSource dataSource;

  @InjectMocks
  private JpaSqlTimeseriesDao jpaSqlTimeseriesDao;

  /**
   * Test {@link JpaSqlTimeseriesDao#init()}.
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.init()"})
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> jpaSqlTimeseriesDao.init());
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Going to cleanup old timeseries data partitions using partition type: {} and ttl: {}s"));
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Going to cleanup old timeseries data partitions using partition type: {} and ttl: {}s")).when(resultSet)
        .close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> jpaSqlTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement(eq("call drop_partitions_by_system_ttl(?,?,?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setString(eq(1), isNull());
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(eq(3600));
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Going to cleanup old timeseries data partitions using partition type: {} and ttl: {}s"))
        .when(preparedStatement)
        .setString(anyInt(), Mockito.<String>any());
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Going to cleanup old timeseries data partitions using partition type: {} and ttl: {}s"))
        .when(preparedStatement)
        .close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> jpaSqlTimeseriesDao.cleanup(Long.MAX_VALUE));
    verify(connection).close();
    verify(connection).prepareStatement(eq("call drop_partitions_by_system_ttl(?,?,?)"));
    verify(preparedStatement).setString(eq(1), isNull());
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   * <ul>
   *   <li>Given {@link DataSource} {@link DataSource#getConnection()} throw {@link SQLException#SQLException()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenDataSourceGetConnectionThrowSQLException_whenOne() throws SQLException {
    // Arrange
    when(dataSource.getConnection()).thenThrow(new SQLException());

    // Act
    jpaSqlTimeseriesDao.cleanup(1L);

    // Assert
    verify(dataSource, atLeast(1)).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When one.</li>
   *   <li>Then calls {@link ResultSet#getLong(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenTrue_whenOne_thenCallsGetLong() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
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
    verify(preparedStatement).setString(eq(1), isNull());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(preparedStatement, atLeast(1)).setQueryTimeout(eq(3600));
    verify(dataSource, atLeast(1)).getConnection();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   * <ul>
   *   <li>Then calls {@link PSQLWarning#getMessage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_thenCallsGetMessage() throws SQLException {
    // Arrange
    PSQLWarning psqlWarning = mock(PSQLWarning.class);
    when(psqlWarning.getMessage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
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
    assertThrows(ConstraintViolationException.class, () -> jpaSqlTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement(eq("call drop_partitions_by_system_ttl(?,?,?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setString(eq(1), isNull());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(eq(3600));
    verify(dataSource).getConnection();
    verify(psqlWarning).getMessage();
  }

  /**
   * Test {@link JpaSqlTimeseriesDao#cleanup(long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then calls {@link PreparedStatement#setObject(int, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaSqlTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaSqlTimeseriesDao.cleanup(long)"})
  public void testCleanup_whenZero_thenCallsSetObject() throws SQLException {
    // Arrange
    PSQLWarning psqlWarning = mock(PSQLWarning.class);
    when(psqlWarning.getMessage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(psqlWarning);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> jpaSqlTimeseriesDao.cleanup(0L));
    verify(connection).close();
    verify(connection).prepareStatement(eq("call cleanup_timeseries_by_ttl(?,?,?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(0L));
    verify(preparedStatement).setObject(eq(1), isA(Object.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(eq(3600));
    verify(dataSource).getConnection();
    verify(psqlWarning).getMessage();
  }
}
