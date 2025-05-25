package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AbstractSqlTsDatabaseUpgradeServiceDiffblueTest {
  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}.
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName("Test checkVersion(Connection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new RuntimeException("SELECT current_setting('server_version_num')"));
    Statement statement = mock(Statement.class);
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualCheckVersionResult = sqlTsDatabaseUpgradeService.checkVersion(conn);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).next();
    verify(statement).executeQuery(eq("SELECT current_setting('server_version_num')"));
    assertFalse(actualCheckVersionResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return {@link Long#MAX_VALUE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName("Test checkVersion(Connection); given ResultSet getLong(int) return MAX_VALUE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenResultSetGetLongReturnMax_value_thenReturnTrue() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(Long.MAX_VALUE);
    Statement statement = mock(Statement.class);
    doNothing().when(statement).close();
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualCheckVersionResult = sqlTsDatabaseUpgradeService.checkVersion(conn);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(statement).close();
    verify(statement).executeQuery(eq("SELECT current_setting('server_version_num')"));
    assertTrue(actualCheckVersionResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName("Test checkVersion(Connection); given ResultSet getLong(int) return one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenResultSetGetLongReturnOne_thenReturnFalse() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    Statement statement = mock(Statement.class);
    doNothing().when(statement).close();
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualCheckVersionResult = sqlTsDatabaseUpgradeService.checkVersion(conn);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(statement).close();
    verify(statement).executeQuery(eq("SELECT current_setting('server_version_num')"));
    assertFalse(actualCheckVersionResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}.
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#close()} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName("Test checkVersion(Connection); given Statement close() throw SQLException(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenStatementCloseThrowSQLException_thenReturnFalse() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    Statement statement = mock(Statement.class);
    doThrow(new SQLException()).when(statement).close();
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualCheckVersionResult = sqlTsDatabaseUpgradeService.checkVersion(conn);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(statement).close();
    verify(statement).executeQuery(eq("SELECT current_setting('server_version_num')"));
    assertFalse(actualCheckVersionResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one thousand.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName("Test isOldSchema(Connection, long); given ResultSet getLong(int) return one thousand; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetGetLongReturnOneThousand_thenReturnFalse() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1000L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    Statement statement = mock(Statement.class);
    doNothing().when(statement).close();
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualIsOldSchemaResult = sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(statement).close();
    verify(statement).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertFalse(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName("Test isOldSchema(Connection, long); given ResultSet getLong(int) return one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetGetLongReturnOne_thenReturnTrue() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    Statement statement = mock(Statement.class);
    doNothing().when(statement).close();
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualIsOldSchemaResult = sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(statement).close();
    verify(statement).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertTrue(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName("Test isOldSchema(Connection, long); given ResultSet getLong(int) throw SQLException(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetGetLongThrowSQLException_thenReturnTrue() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualIsOldSchemaResult = sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(statement).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertTrue(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then calls {@link ResultSet#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName("Test isOldSchema(Connection, long); given ResultSet next() return 'false'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetNextReturnFalse_thenCallsClose() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    Statement statement = mock(Statement.class);
    doNothing().when(statement).close();
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualIsOldSchemaResult = sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).close();
    verify(resultSet).next();
    verify(statement).close();
    verify(statement, atLeast(1)).execute(Mockito.<String>any());
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertTrue(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName("Test isOldSchema(Connection, long); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_thenThrowRuntimeException() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new RuntimeException(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema"
            + "_settings_pkey PRIMARY KEY (schema_version));"));
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L));
    verify(conn).createStatement();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(statement).execute(eq(
        "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
  }
}
