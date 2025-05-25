package org.thingsboard.server.dao.sqlts.timescale;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.postgresql.util.PSQLWarning;

@RunWith(MockitoJUnitRunner.class)
public class TimescaleTimeseriesDaoDiffblueTest {
  @Mock
  private DataSource dataSource;

  @InjectMocks
  private TimescaleTimeseriesDao timescaleTimeseriesDao;

  /**
   * Test {@link TimescaleTimeseriesDao#cleanup(long)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ResultSet#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimescaleTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenTrue_thenCallsClose() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    timescaleTimeseriesDao.cleanup(1L);

    // Assert
    verify(connection).close();
    verify(connection).prepareStatement(eq("call cleanup_timeseries_by_ttl(?,?,?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setObject(eq(1), isA(Object.class));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(eq(3600));
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link TimescaleTimeseriesDao#cleanup(long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimescaleTimeseriesDao.cleanup(long)"})
  public void testCleanup_thenThrowIllegalArgumentException() throws SQLException {
    // Arrange
    PSQLWarning psqlWarning = mock(PSQLWarning.class);
    when(psqlWarning.getMessage()).thenThrow(new IllegalArgumentException("foo"));
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(psqlWarning);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> timescaleTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement(eq("call cleanup_timeseries_by_ttl(?,?,?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setObject(eq(1), isA(Object.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(eq(3600));
    verify(dataSource).getConnection();
    verify(psqlWarning).getMessage();
  }
}
