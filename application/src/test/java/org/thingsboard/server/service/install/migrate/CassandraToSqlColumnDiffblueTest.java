package org.thingsboard.server.service.install.migrate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;

@DisabledInAotMode
class CassandraToSqlColumnDiffblueTest {
  @MockBean
  private CassandraToSqlColumn cassandraToSqlColumn;

  /**
   * Test {@link CassandraToSqlColumn#idColumn(String)}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#idColumn(String)}
   */
  @Test
  @DisplayName("Test idColumn(String)")
  void testIdColumn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CassandraToSqlColumn actualIdColumnResult = CassandraToSqlColumn.idColumn("Name");

    // Assert
    assertEquals("Name", actualIdColumnResult.getCassandraColumnName());
    assertEquals("Name", actualIdColumnResult.getSqlColumnName());
    assertNull(actualIdColumnResult.getEnumClass());
    assertEquals(0, actualIdColumnResult.getIndex());
    assertEquals(0, actualIdColumnResult.getSize());
    assertEquals(0, actualIdColumnResult.getSqlIndex());
    assertEquals(0, actualIdColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.ID, actualIdColumnResult.getType());
    assertFalse(actualIdColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#stringColumn(String, String)} with
   * {@code cassandraColumnName}, {@code sqlColumnName}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#stringColumn(String, String)}
   */
  @Test
  @DisplayName("Test stringColumn(String, String) with 'cassandraColumnName', 'sqlColumnName'")
  void testStringColumnWithCassandraColumnNameSqlColumnName() {
    // Arrange and Act
    CassandraToSqlColumn actualStringColumnResult = CassandraToSqlColumn.stringColumn("Cassandra Column Name",
        "Sql Column Name");

    // Assert
    assertEquals("Cassandra Column Name", actualStringColumnResult.getCassandraColumnName());
    assertEquals("Sql Column Name", actualStringColumnResult.getSqlColumnName());
    assertNull(actualStringColumnResult.getEnumClass());
    assertEquals(0, actualStringColumnResult.getIndex());
    assertEquals(0, actualStringColumnResult.getSize());
    assertEquals(0, actualStringColumnResult.getSqlIndex());
    assertEquals(0, actualStringColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualStringColumnResult.getType());
    assertFalse(actualStringColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#stringColumn(String)} with {@code name}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#stringColumn(String)}
   */
  @Test
  @DisplayName("Test stringColumn(String) with 'name'")
  void testStringColumnWithName() {
    // Arrange and Act
    CassandraToSqlColumn actualStringColumnResult = CassandraToSqlColumn.stringColumn("Name");

    // Assert
    assertEquals("Name", actualStringColumnResult.getCassandraColumnName());
    assertEquals("Name", actualStringColumnResult.getSqlColumnName());
    assertNull(actualStringColumnResult.getEnumClass());
    assertEquals(0, actualStringColumnResult.getIndex());
    assertEquals(0, actualStringColumnResult.getSize());
    assertEquals(0, actualStringColumnResult.getSqlIndex());
    assertEquals(0, actualStringColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualStringColumnResult.getType());
    assertFalse(actualStringColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#bigintColumn(String)}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#bigintColumn(String)}
   */
  @Test
  @DisplayName("Test bigintColumn(String)")
  void testBigintColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualBigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Assert
    assertEquals("Name", actualBigintColumnResult.getCassandraColumnName());
    assertEquals("Name", actualBigintColumnResult.getSqlColumnName());
    assertNull(actualBigintColumnResult.getEnumClass());
    assertEquals(0, actualBigintColumnResult.getIndex());
    assertEquals(0, actualBigintColumnResult.getSize());
    assertEquals(0, actualBigintColumnResult.getSqlIndex());
    assertEquals(0, actualBigintColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.BIGINT, actualBigintColumnResult.getType());
    assertFalse(actualBigintColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#doubleColumn(String)}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#doubleColumn(String)}
   */
  @Test
  @DisplayName("Test doubleColumn(String)")
  void testDoubleColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualDoubleColumnResult = CassandraToSqlColumn.doubleColumn("Name");

    // Assert
    assertEquals("Name", actualDoubleColumnResult.getCassandraColumnName());
    assertEquals("Name", actualDoubleColumnResult.getSqlColumnName());
    assertNull(actualDoubleColumnResult.getEnumClass());
    assertEquals(0, actualDoubleColumnResult.getIndex());
    assertEquals(0, actualDoubleColumnResult.getSize());
    assertEquals(0, actualDoubleColumnResult.getSqlIndex());
    assertEquals(0, actualDoubleColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.DOUBLE, actualDoubleColumnResult.getType());
    assertFalse(actualDoubleColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#booleanColumn(String)} with {@code name}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#booleanColumn(String)}
   */
  @Test
  @DisplayName("Test booleanColumn(String) with 'name'")
  void testBooleanColumnWithName() {
    // Arrange and Act
    CassandraToSqlColumn actualBooleanColumnResult = CassandraToSqlColumn.booleanColumn("Name");

    // Assert
    assertEquals("Name", actualBooleanColumnResult.getCassandraColumnName());
    assertEquals("Name", actualBooleanColumnResult.getSqlColumnName());
    assertNull(actualBooleanColumnResult.getEnumClass());
    assertEquals(0, actualBooleanColumnResult.getIndex());
    assertEquals(0, actualBooleanColumnResult.getSize());
    assertEquals(0, actualBooleanColumnResult.getSqlIndex());
    assertEquals(0, actualBooleanColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.BOOLEAN, actualBooleanColumnResult.getType());
    assertFalse(actualBooleanColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#booleanColumn(String, boolean)} with
   * {@code name}, {@code allowNullBoolean}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#booleanColumn(String, boolean)}
   */
  @Test
  @DisplayName("Test booleanColumn(String, boolean) with 'name', 'allowNullBoolean'")
  void testBooleanColumnWithNameAllowNullBoolean() {
    // Arrange and Act
    CassandraToSqlColumn actualBooleanColumnResult = CassandraToSqlColumn.booleanColumn("Name", true);

    // Assert
    assertEquals("Name", actualBooleanColumnResult.getCassandraColumnName());
    assertEquals("Name", actualBooleanColumnResult.getSqlColumnName());
    assertNull(actualBooleanColumnResult.getEnumClass());
    assertEquals(0, actualBooleanColumnResult.getIndex());
    assertEquals(0, actualBooleanColumnResult.getSize());
    assertEquals(0, actualBooleanColumnResult.getSqlIndex());
    assertEquals(0, actualBooleanColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.BOOLEAN, actualBooleanColumnResult.getType());
    assertTrue(actualBooleanColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#jsonColumn(String)}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#jsonColumn(String)}
   */
  @Test
  @DisplayName("Test jsonColumn(String)")
  void testJsonColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualJsonColumnResult = CassandraToSqlColumn.jsonColumn("Name");

    // Assert
    assertEquals("Name", actualJsonColumnResult.getCassandraColumnName());
    assertEquals("Name", actualJsonColumnResult.getSqlColumnName());
    assertNull(actualJsonColumnResult.getEnumClass());
    assertEquals(0, actualJsonColumnResult.getIndex());
    assertEquals(0, actualJsonColumnResult.getSize());
    assertEquals(0, actualJsonColumnResult.getSqlIndex());
    assertEquals(0, actualJsonColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.JSON, actualJsonColumnResult.getType());
    assertFalse(actualJsonColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#CassandraToSqlColumn(String)}.
   * <p>
   * Method under test: {@link CassandraToSqlColumn#CassandraToSqlColumn(String)}
   */
  @Test
  @DisplayName("Test new CassandraToSqlColumn(String)")
  void testNewCassandraToSqlColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualCassandraToSqlColumn = new CassandraToSqlColumn("Column Name");

    // Assert
    assertEquals("Column Name", actualCassandraToSqlColumn.getCassandraColumnName());
    assertEquals("Column Name", actualCassandraToSqlColumn.getSqlColumnName());
    assertNull(actualCassandraToSqlColumn.getEnumClass());
    assertEquals(0, actualCassandraToSqlColumn.getIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSize());
    assertEquals(0, actualCassandraToSqlColumn.getSqlIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualCassandraToSqlColumn.getType());
    assertFalse(actualCassandraToSqlColumn.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#CassandraToSqlColumn(String, String)}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#CassandraToSqlColumn(String, String)}
   */
  @Test
  @DisplayName("Test new CassandraToSqlColumn(String, String)")
  void testNewCassandraToSqlColumn2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CassandraToSqlColumn actualCassandraToSqlColumn = new CassandraToSqlColumn("Cassandra Column Name",
        "Sql Column Name");

    // Assert
    assertEquals("Cassandra Column Name", actualCassandraToSqlColumn.getCassandraColumnName());
    assertEquals("Sql Column Name", actualCassandraToSqlColumn.getSqlColumnName());
    assertNull(actualCassandraToSqlColumn.getEnumClass());
    assertEquals(0, actualCassandraToSqlColumn.getIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSize());
    assertEquals(0, actualCassandraToSqlColumn.getSqlIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualCassandraToSqlColumn.getType());
    assertFalse(actualCassandraToSqlColumn.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given bigintColumn {@code Name} Type is {@code BIGINT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given bigintColumn 'Name' Type is 'BIGINT'")
  void testSetColumnValue_givenBigintColumnNameTypeIsBigint() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setType(CassandraToSqlColumnType.BIGINT);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setLong(anyInt(), anyLong());

    // Act and Assert
    assertThrows(SQLException.class, () -> bigintColumnResult.setColumnValue(sqlInsertStatement, "42"));
    verify(sqlInsertStatement).setLong(eq(0), eq(42L));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given bigintColumn {@code Name} Type is {@code DOUBLE}.</li>
   *   <li>Then calls {@link PreparedStatement#setDouble(int, double)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given bigintColumn 'Name' Type is 'DOUBLE'; then calls setDouble(int, double)")
  void testSetColumnValue_givenBigintColumnNameTypeIsDouble_thenCallsSetDouble() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setType(CassandraToSqlColumnType.DOUBLE);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setDouble(anyInt(), anyDouble());

    // Act and Assert
    assertThrows(SQLException.class, () -> bigintColumnResult.setColumnValue(sqlInsertStatement, "42"));
    verify(sqlInsertStatement).setDouble(eq(0), eq(42.0d));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given bigintColumn {@code Name} Type is {@code FLOAT}.</li>
   *   <li>Then calls {@link PreparedStatement#setFloat(int, float)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given bigintColumn 'Name' Type is 'FLOAT'; then calls setFloat(int, float)")
  void testSetColumnValue_givenBigintColumnNameTypeIsFloat_thenCallsSetFloat() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setType(CassandraToSqlColumnType.FLOAT);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setFloat(anyInt(), anyFloat());

    // Act
    bigintColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert that nothing has changed
    verify(sqlInsertStatement).setFloat(eq(0), eq(42.0f));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given bigintColumn {@code Name} Type is {@code INTEGER}.</li>
   *   <li>Then calls {@link PreparedStatement#setInt(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given bigintColumn 'Name' Type is 'INTEGER'; then calls setInt(int, int)")
  void testSetColumnValue_givenBigintColumnNameTypeIsInteger_thenCallsSetInt() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setType(CassandraToSqlColumnType.INTEGER);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setInt(anyInt(), anyInt());

    // Act
    bigintColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert that nothing has changed
    verify(sqlInsertStatement).setInt(eq(0), eq(42));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given bigintColumn {@code Name}.</li>
   *   <li>Then calls {@link PreparedStatement#setLong(int, long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given bigintColumn 'Name'; then calls setLong(int, long)")
  void testSetColumnValue_givenBigintColumnName_thenCallsSetLong() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setLong(anyInt(), anyLong());

    // Act
    bigintColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert that nothing has changed
    verify(sqlInsertStatement).setLong(eq(0), eq(42L));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given doubleColumn {@code Name}.</li>
   *   <li>Then calls {@link PreparedStatement#setDouble(int, double)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given doubleColumn 'Name'; then calls setDouble(int, double)")
  void testSetColumnValue_givenDoubleColumnName_thenCallsSetDouble() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn doubleColumnResult = CassandraToSqlColumn.doubleColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setDouble(anyInt(), anyDouble());

    // Act
    doubleColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert that nothing has changed
    verify(sqlInsertStatement).setDouble(eq(0), eq(42.0d));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given idColumn {@code Name}.</li>
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given idColumn 'Name'; then calls setString(int, String)")
  void testSetColumnValue_givenIdColumnName_thenCallsSetString() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn idColumnResult = CassandraToSqlColumn.idColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setString(anyInt(), Mockito.<String>any());

    // Act
    idColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert that nothing has changed
    verify(sqlInsertStatement).setString(eq(0), eq("42"));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>Given idColumn {@code Name}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); given idColumn 'Name'; when 'null'; then calls setNull(int, int)")
  void testSetColumnValue_givenIdColumnName_whenNull_thenCallsSetNull() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn idColumnResult = CassandraToSqlColumn.idColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setNull(anyInt(), anyInt());

    // Act
    idColumnResult.setColumnValue(sqlInsertStatement, null);

    // Assert that nothing has changed
    verify(sqlInsertStatement).setNull(eq(0), eq(0));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement}
   * {@link PreparedStatement#setBoolean(int, boolean)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); when PreparedStatement setBoolean(int, boolean) does nothing")
  void testSetColumnValue_whenPreparedStatementSetBooleanDoesNothing() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setType(CassandraToSqlColumnType.BOOLEAN);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setBoolean(anyInt(), anyBoolean());

    // Act
    bigintColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert that nothing has changed
    verify(sqlInsertStatement).setBoolean(eq(0), eq(false));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement}
   * {@link PreparedStatement#setBoolean(int, boolean)} throw
   * {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); when PreparedStatement setBoolean(int, boolean) throw SQLException()")
  void testSetColumnValue_whenPreparedStatementSetBooleanThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setType(CassandraToSqlColumnType.BOOLEAN);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setBoolean(anyInt(), anyBoolean());

    // Act and Assert
    assertThrows(SQLException.class, () -> bigintColumnResult.setColumnValue(sqlInsertStatement, "42"));
    verify(sqlInsertStatement).setBoolean(eq(0), eq(false));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setInt(int, int)}
   * throw {@link SQLException#SQLException()}.</li>
   *   <li>Then calls {@link PreparedStatement#setInt(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); when PreparedStatement setInt(int, int) throw SQLException(); then calls setInt(int, int)")
  void testSetColumnValue_whenPreparedStatementSetIntThrowSQLException_thenCallsSetInt() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setType(CassandraToSqlColumnType.INTEGER);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setInt(anyInt(), anyInt());

    // Act and Assert
    assertThrows(SQLException.class, () -> bigintColumnResult.setColumnValue(sqlInsertStatement, "42"));
    verify(sqlInsertStatement).setInt(eq(0), eq(42));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement}
   * {@link PreparedStatement#setNull(int, int)} throw
   * {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); when PreparedStatement setNull(int, int) throw SQLException()")
  void testSetColumnValue_whenPreparedStatementSetNullThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn idColumnResult = CassandraToSqlColumn.idColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setNull(anyInt(), anyInt());

    // Act and Assert
    assertThrows(SQLException.class, () -> idColumnResult.setColumnValue(sqlInsertStatement, null));
    verify(sqlInsertStatement).setNull(eq(0), eq(0));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}, and
   * {@link CassandraToSqlColumn#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlColumn#equals(Object)}
   *   <li>{@link CassandraToSqlColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    assertEquals(bigintColumnResult, bigintColumnResult2);
    int expectedHashCodeResult = bigintColumnResult.hashCode();
    assertEquals(expectedHashCodeResult, bigintColumnResult2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}, and
   * {@link CassandraToSqlColumn#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlColumn#equals(Object)}
   *   <li>{@link CassandraToSqlColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn(null);
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn(null);

    // Act and Assert
    assertEquals(bigintColumnResult, bigintColumnResult2);
    int expectedHashCodeResult = bigintColumnResult.hashCode();
    assertEquals(expectedHashCodeResult, bigintColumnResult2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}, and
   * {@link CassandraToSqlColumn#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlColumn#equals(Object)}
   *   <li>{@link CassandraToSqlColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    assertEquals(bigintColumnResult, bigintColumnResult);
    int expectedHashCodeResult = bigintColumnResult.hashCode();
    assertEquals(expectedHashCodeResult, bigintColumnResult.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn(null);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn
        .bigintColumn("org.thingsboard.server.service.install.migrate.CassandraToSqlColumn");

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraToSqlColumn doubleColumnResult = CassandraToSqlColumn.doubleColumn("Name");

    // Act and Assert
    assertNotEquals(doubleColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setIndex(1);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setSqlIndex(1);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setSqlType(1);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setSize(3);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setAllowNullBoolean(true);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn
        .bigintColumn("org.thingsboard.server.service.install.migrate.CassandraToSqlColumn");
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult2.setCassandraColumnName("org.thingsboard.server.service.install.migrate.CassandraToSqlColumn");

    // Act and Assert
    assertNotEquals(bigintColumnResult, bigintColumnResult2);
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn(null);
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn(null);
    bigintColumnResult2.setSqlColumnName("Sql Column Name");

    // Act and Assert
    assertNotEquals(bigintColumnResult, bigintColumnResult2);
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CassandraToSqlColumn.bigintColumn("Name"), null);
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CassandraToSqlColumn.bigintColumn("Name"), "Different type to CassandraToSqlColumn");
  }
}
