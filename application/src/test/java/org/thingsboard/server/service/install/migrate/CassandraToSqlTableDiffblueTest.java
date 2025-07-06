package org.thingsboard.server.service.install.migrate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CassandraToSqlTableDiffblueTest {
  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int,
   * CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>Then return {@code Cassandra Cf}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, String, int, CassandraToSqlColumn[]); then return 'Cassandra Cf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void CassandraToSqlTable.<init>(String, String, int, CassandraToSqlColumn[])"
  })
  void testNewCassandraToSqlTable_thenReturnCassandraCf() {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable =
        new CassandraToSqlTable("Cassandra Cf", "Sql Table Name", 3, cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Cassandra Cf", actualCassandraToSqlTable.getCassandraCf());
    assertEquals("Sql Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(3, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, int, CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>Then return CassandraCf is {@code Table Name}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String, int,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, int, CassandraToSqlColumn[]); then return CassandraCf is 'Table Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.<init>(String, int, CassandraToSqlColumn[])"})
  void testNewCassandraToSqlTable_thenReturnCassandraCfIsTableName() {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable =
        new CassandraToSqlTable("Table Name", 3, cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Table Name", actualCassandraToSqlTable.getCassandraCf());
    assertEquals("Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(3, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>Then return CassandraCf is {@code Table Name}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, CassandraToSqlColumn[]); then return CassandraCf is 'Table Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.<init>(String, CassandraToSqlColumn[])"})
  void testNewCassandraToSqlTable_thenReturnCassandraCfIsTableName2() {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable =
        new CassandraToSqlTable("Table Name", cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Table Name", actualCassandraToSqlTable.getCassandraCf());
    assertEquals("Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(10000, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, String, CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>Then return {@code Sql Table Name}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String, String,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, String, CassandraToSqlColumn[]); then return 'Sql Table Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.<init>(String, String, CassandraToSqlColumn[])"})
  void testNewCassandraToSqlTable_thenReturnSqlTableName() {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable =
        new CassandraToSqlTable("Table Name", "Sql Table Name", cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Sql Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertEquals("Table Name", actualCassandraToSqlTable.getCassandraCf());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(10000, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, int, CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>When bigintColumn {@code Name}.
   *   <li>Then return Columns size is one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String, int,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, int, CassandraToSqlColumn[]); when bigintColumn 'Name'; then return Columns size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.<init>(String, int, CassandraToSqlColumn[])"})
  void testNewCassandraToSqlTable_whenBigintColumnName_thenReturnColumnsSizeIsOne() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns =
        new CassandraToSqlTable("Table Name", 3, bigintColumnResult).getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int,
   * CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>When bigintColumn {@code Name}.
   *   <li>Then return Columns size is one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, String, int, CassandraToSqlColumn[]); when bigintColumn 'Name'; then return Columns size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void CassandraToSqlTable.<init>(String, String, int, CassandraToSqlColumn[])"
  })
  void testNewCassandraToSqlTable_whenBigintColumnName_thenReturnColumnsSizeIsOne2() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns =
        new CassandraToSqlTable("Cassandra Cf", "Sql Table Name", 3, bigintColumnResult)
            .getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, String, CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>When bigintColumn {@code Name}.
   *   <li>Then return Columns size is one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String, String,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, String, CassandraToSqlColumn[]); when bigintColumn 'Name'; then return Columns size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.<init>(String, String, CassandraToSqlColumn[])"})
  void testNewCassandraToSqlTable_whenBigintColumnName_thenReturnColumnsSizeIsOne3() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns =
        new CassandraToSqlTable("Table Name", "Sql Table Name", bigintColumnResult).getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test {@link CassandraToSqlTable#CassandraToSqlTable(String, CassandraToSqlColumn[])}.
   *
   * <ul>
   *   <li>When bigintColumn {@code Name}.
   *   <li>Then return Columns size is one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#CassandraToSqlTable(String,
   * CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlTable(String, CassandraToSqlColumn[]); when bigintColumn 'Name'; then return Columns size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.<init>(String, CassandraToSqlColumn[])"})
  void testNewCassandraToSqlTable_whenBigintColumnName_thenReturnColumnsSizeIsOne4() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns =
        new CassandraToSqlTable("Table Name", bigintColumnResult).getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   *
   * <p>Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.batchInsert(List, Connection)"})
  void testBatchInsert() throws SQLException {
    // Arrange
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    when(sqlInsertStatement.executeUpdate()).thenReturn(1);

    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name");
    cassandraToSqlTable.setSqlInsertStatement(sqlInsertStatement);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[] {new CassandraToSqlColumnData("42")});
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert
    verify(conn).commit();
    verify(sqlInsertStatement).executeUpdate();
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   *
   * <ul>
   *   <li>Given {@link CassandraToSqlColumnData} {@link CassandraToSqlColumnData#getValue()} return
   *       {@code 42}.
   *   <li>Then calls {@link CassandraToSqlColumnData#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName(
      "Test batchInsert(List, Connection); given CassandraToSqlColumnData getValue() return '42'; then calls getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.batchInsert(List, Connection)"})
  void testBatchInsert_givenCassandraToSqlColumnDataGetValueReturn42_thenCallsGetValue()
      throws SQLException {
    // Arrange
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setString(anyInt(), Mockito.<String>any());
    when(sqlInsertStatement.executeUpdate()).thenReturn(1);

    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.idColumn("Name"));
    cassandraToSqlTable.setSqlInsertStatement(sqlInsertStatement);
    CassandraToSqlColumnData cassandraToSqlColumnData = mock(CassandraToSqlColumnData.class);
    when(cassandraToSqlColumnData.getValue()).thenReturn("42");

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[] {cassandraToSqlColumnData});
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert
    verify(conn).commit();
    verify(sqlInsertStatement).executeUpdate();
    verify(sqlInsertStatement).setString(eq(1), eq("42"));
    verify(cassandraToSqlColumnData).getValue();
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} does
   *       nothing.
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName(
      "Test batchInsert(List, Connection); given PreparedStatement setString(int, String) does nothing; then calls setString(int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.batchInsert(List, Connection)"})
  void testBatchInsert_givenPreparedStatementSetStringDoesNothing_thenCallsSetString()
      throws SQLException {
    // Arrange
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setString(anyInt(), Mockito.<String>any());
    when(sqlInsertStatement.executeUpdate()).thenReturn(1);

    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.idColumn("Name"));
    cassandraToSqlTable.setSqlInsertStatement(sqlInsertStatement);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[] {new CassandraToSqlColumnData("42")});
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert
    verify(conn).commit();
    verify(sqlInsertStatement).executeUpdate();
    verify(sqlInsertStatement).setString(eq(1), eq("42"));
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   *
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.
   *   <li>Then throw {@link SQLException}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection); given SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.batchInsert(List, Connection)"})
  void testBatchInsert_givenSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    Connection conn = mock(Connection.class);
    doThrow(new SQLException()).when(conn).commit();

    // Act and Assert
    assertThrows(SQLException.class, () -> cassandraToSqlTable.batchInsert(batchData, conn));
    verify(conn).commit();
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setDouble(int, double)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection); then calls setDouble(int, double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.batchInsert(List, Connection)"})
  void testBatchInsert_thenCallsSetDouble() throws SQLException {
    // Arrange
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setDouble(anyInt(), anyDouble());
    when(sqlInsertStatement.executeUpdate()).thenReturn(1);

    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.doubleColumn("Name"));
    cassandraToSqlTable.setSqlInsertStatement(sqlInsertStatement);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[] {new CassandraToSqlColumnData("42")});
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert
    verify(conn).commit();
    verify(sqlInsertStatement).executeUpdate();
    verify(sqlInsertStatement).setDouble(eq(1), eq(42.0d));
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setLong(int, long)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection); then calls setLong(int, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.batchInsert(List, Connection)"})
  void testBatchInsert_thenCallsSetLong() throws SQLException {
    // Arrange
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setLong(anyInt(), anyLong());
    when(sqlInsertStatement.executeUpdate()).thenReturn(1);

    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));
    cassandraToSqlTable.setSqlInsertStatement(sqlInsertStatement);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[] {new CassandraToSqlColumnData("42")});
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert
    verify(conn).commit();
    verify(sqlInsertStatement).executeUpdate();
    verify(sqlInsertStatement).setLong(eq(1), eq(42L));
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlTable.batchInsert(List, Connection)"})
  void testBatchInsert_whenArrayList() throws SQLException {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert
    verify(conn).commit();
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}, and {@link CassandraToSqlTable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlTable#equals(Object)}
   *   <li>{@link CassandraToSqlTable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));
    CassandraToSqlTable cassandraToSqlTable2 =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertEquals(cassandraToSqlTable, cassandraToSqlTable2);
    int expectedHashCodeResult = cassandraToSqlTable.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlTable2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}, and {@link CassandraToSqlTable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlTable#equals(Object)}
   *   <li>{@link CassandraToSqlTable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable(null, CassandraToSqlColumn.bigintColumn("Name"));
    CassandraToSqlTable cassandraToSqlTable2 =
        new CassandraToSqlTable(null, CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertEquals(cassandraToSqlTable, cassandraToSqlTable2);
    int expectedHashCodeResult = cassandraToSqlTable.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlTable2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}, and {@link CassandraToSqlTable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlTable#equals(Object)}
   *   <li>{@link CassandraToSqlTable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertEquals(cassandraToSqlTable, cassandraToSqlTable);
    int expectedHashCodeResult = cassandraToSqlTable.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlTable.hashCode());
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Name", CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertNotEquals(
        cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable(null, CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertNotEquals(
        cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Table Name"));

    // Act and Assert
    assertNotEquals(
        cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", 3, CassandraToSqlColumn.bigintColumn("Table Name"));

    // Act and Assert
    assertNotEquals(
        cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));
    cassandraToSqlTable.setSqlInsertStatement(mock(PreparedStatement.class));

    // Act and Assert
    assertNotEquals(
        cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));

    CassandraToSqlTable cassandraToSqlTable2 =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));
    cassandraToSqlTable2.setSqlInsertStatement(mock(PreparedStatement.class));

    // Act and Assert
    assertNotEquals(cassandraToSqlTable, cassandraToSqlTable2);
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Name", CassandraToSqlColumn.bigintColumn("Name"));

    CassandraToSqlTable cassandraToSqlTable2 =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));
    cassandraToSqlTable2.setCassandraCf("Name");

    // Act and Assert
    assertNotEquals(cassandraToSqlTable, cassandraToSqlTable2);
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable(null, CassandraToSqlColumn.bigintColumn("Name"));

    CassandraToSqlTable cassandraToSqlTable2 =
        new CassandraToSqlTable(null, CassandraToSqlColumn.bigintColumn("Name"));
    cassandraToSqlTable2.setSqlTableName("Name");

    // Act and Assert
    assertNotEquals(cassandraToSqlTable, cassandraToSqlTable2);
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")), null);
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlTable.equals(Object)",
    "int CassandraToSqlTable.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")),
        "Different type to CassandraToSqlTable");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlTable#setBatchSize(int)}
   *   <li>{@link CassandraToSqlTable#setCassandraCf(String)}
   *   <li>{@link CassandraToSqlTable#setColumns(List)}
   *   <li>{@link CassandraToSqlTable#setSqlInsertStatement(PreparedStatement)}
   *   <li>{@link CassandraToSqlTable#setSqlTableName(String)}
   *   <li>{@link CassandraToSqlTable#toString()}
   *   <li>{@link CassandraToSqlTable#getBatchSize()}
   *   <li>{@link CassandraToSqlTable#getCassandraCf()}
   *   <li>{@link CassandraToSqlTable#getColumns()}
   *   <li>{@link CassandraToSqlTable#getSqlInsertStatement()}
   *   <li>{@link CassandraToSqlTable#getSqlTableName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int CassandraToSqlTable.getBatchSize()",
    "String CassandraToSqlTable.getCassandraCf()",
    "List CassandraToSqlTable.getColumns()",
    "PreparedStatement CassandraToSqlTable.getSqlInsertStatement()",
    "String CassandraToSqlTable.getSqlTableName()",
    "void CassandraToSqlTable.setBatchSize(int)",
    "void CassandraToSqlTable.setCassandraCf(String)",
    "void CassandraToSqlTable.setColumns(List)",
    "void CassandraToSqlTable.setSqlInsertStatement(PreparedStatement)",
    "void CassandraToSqlTable.setSqlTableName(String)",
    "String CassandraToSqlTable.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable =
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name"));

    // Act
    cassandraToSqlTable.setBatchSize(3);
    cassandraToSqlTable.setCassandraCf("Cassandra Cf");
    ArrayList<CassandraToSqlColumn> columns = new ArrayList<>();
    cassandraToSqlTable.setColumns(columns);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    cassandraToSqlTable.setSqlInsertStatement(sqlInsertStatement);
    cassandraToSqlTable.setSqlTableName("Sql Table Name");
    cassandraToSqlTable.toString();
    int actualBatchSize = cassandraToSqlTable.getBatchSize();
    String actualCassandraCf = cassandraToSqlTable.getCassandraCf();
    List<CassandraToSqlColumn> actualColumns = cassandraToSqlTable.getColumns();
    PreparedStatement actualSqlInsertStatement = cassandraToSqlTable.getSqlInsertStatement();

    // Assert
    assertEquals("Cassandra Cf", actualCassandraCf);
    assertEquals("Sql Table Name", cassandraToSqlTable.getSqlTableName());
    assertEquals(3, actualBatchSize);
    assertTrue(actualColumns.isEmpty());
    assertSame(columns, actualColumns);
    assertSame(sqlInsertStatement, actualSqlInsertStatement);
  }
}
