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
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return {@code 110000}.
   *   <li>Then calls {@link ResultSet#getLong(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName(
      "Test checkVersion(Connection); given ResultSet getLong(int) return '110000'; then calls getLong(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenResultSetGetLongReturn110000_thenCallsGetLong() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(110000L);
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
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return {@code 110001}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName(
      "Test checkVersion(Connection); given ResultSet getLong(int) return '110001'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenResultSetGetLongReturn110001_thenReturnTrue() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(110001L);
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
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName(
      "Test checkVersion(Connection); given ResultSet next() throw SQLException(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenResultSetNextThrowSQLException_thenReturnFalse() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new SQLException());
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
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName("Test checkVersion(Connection); given SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenSQLException() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act
    boolean actualCheckVersionResult = sqlTsDatabaseUpgradeService.checkVersion(conn);

    // Assert
    verify(conn).createStatement();
    assertFalse(actualCheckVersionResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#close()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName(
      "Test checkVersion(Connection); given Statement close() throw SQLException(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenStatementCloseThrowSQLException_thenReturnTrue() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(110001L);
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
    assertTrue(actualCheckVersionResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#executeQuery(String)} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#checkVersion(Connection)}
   */
  @Test
  @DisplayName(
      "Test checkVersion(Connection); given Statement executeQuery(String) throw SQLException(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.checkVersion(Connection)"})
  void testCheckVersion_givenStatementExecuteQueryThrowSQLException_thenReturnFalse()
      throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    Statement statement = mock(Statement.class);
    when(statement.executeQuery(Mockito.<String>any())).thenThrow(new SQLException());
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualCheckVersionResult = sqlTsDatabaseUpgradeService.checkVersion(conn);

    // Assert
    verify(conn).createStatement();
    verify(statement).executeQuery(eq("SELECT current_setting('server_version_num')"));
    assertFalse(actualCheckVersionResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one thousand.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given ResultSet getLong(int) return one thousand; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetGetLongReturnOneThousand_thenReturnFalse()
      throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1000L);
    when(resultSet.next()).thenReturn(true);
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
    verify(statement)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertFalse(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.
   *   <li>Then calls {@link Statement#close()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given ResultSet getLong(int) return one; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetGetLongReturnOne_thenCallsClose() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true);
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
    verify(statement)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertTrue(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} throw {@link
   *       RuntimeException#RuntimeException(String)} with a string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given ResultSet getLong(int) throw RuntimeException(String) with a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetGetLongThrowRuntimeExceptionWithAString() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt()))
        .thenThrow(
            new RuntimeException(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema"
                    + "_settings_pkey PRIMARY KEY (schema_version));"));
    when(resultSet.next()).thenReturn(true);
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
    verify(statement)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then calls {@link ResultSet#getLong(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given ResultSet getLong(int) throw SQLException(); then calls getLong(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetGetLongThrowSQLException_thenCallsGetLong()
      throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true);
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
    verify(statement)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertTrue(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.
   *   <li>Then calls {@link ResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given ResultSet next() return 'false'; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetNextReturnFalse_thenCallsClose() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false);
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
   *
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given ResultSet next() throw SQLException(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenResultSetNextThrowSQLException_thenReturnTrue() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenThrow(new SQLException());
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenReturn(true);
    when(statement.executeQuery(Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualIsOldSchemaResult = sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L);

    // Assert
    verify(conn).createStatement();
    verify(resultSet).next();
    verify(statement)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    verify(statement).executeQuery(eq("SELECT schema_version FROM tb_schema_settings;"));
    assertTrue(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with a string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName("Test isOldSchema(Connection, long); given RuntimeException(String) with a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenRuntimeExceptionWithAString() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    Connection conn = mock(Connection.class);
    when(conn.createStatement())
        .thenThrow(
            new RuntimeException(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema"
                    + "_settings_pkey PRIMARY KEY (schema_version));"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L));
    verify(conn).createStatement();
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   *   <li>When {@link Connection} {@link Connection#createStatement()} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given SQLException(); when Connection createStatement() throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenSQLException_whenConnectionCreateStatementThrowSQLException()
      throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenThrow(new SQLException());

    // Act
    boolean actualIsOldSchemaResult = sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L);

    // Assert
    verify(conn).createStatement();
    assertTrue(actualIsOldSchemaResult);
  }

  /**
   * Test {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#execute(String)} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTsDatabaseUpgradeService#isOldSchema(Connection, long)}
   */
  @Test
  @DisplayName(
      "Test isOldSchema(Connection, long); given Statement execute(String) throw SQLException(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractSqlTsDatabaseUpgradeService.isOldSchema(Connection, long)"})
  void testIsOldSchema_givenStatementExecuteThrowSQLException_thenReturnTrue() throws SQLException {
    // Arrange
    SqlTsDatabaseUpgradeService sqlTsDatabaseUpgradeService = new SqlTsDatabaseUpgradeService();
    Statement statement = mock(Statement.class);
    when(statement.execute(Mockito.<String>any())).thenThrow(new SQLException());
    Connection conn = mock(Connection.class);
    when(conn.createStatement()).thenReturn(statement);

    // Act
    boolean actualIsOldSchemaResult = sqlTsDatabaseUpgradeService.isOldSchema(conn, 1L);

    // Assert
    verify(conn).createStatement();
    verify(statement)
        .execute(
            eq(
                "CREATE TABLE IF NOT EXISTS tb_schema_settings ( schema_version bigint NOT NULL, CONSTRAINT tb_schema_settings_pkey PRIMARY KEY (schema_version));"));
    assertTrue(actualIsOldSchemaResult);
  }
}
