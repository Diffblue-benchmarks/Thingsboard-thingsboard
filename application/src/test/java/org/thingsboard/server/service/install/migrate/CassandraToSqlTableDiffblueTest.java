package org.thingsboard.server.service.install.migrate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.cql.Statement;
import com.datastax.oss.driver.internal.core.cql.DefaultSimpleStatement;
import com.datastax.oss.driver.internal.core.session.SessionWrapper;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.dao.cassandra.guava.DefaultGuavaSession;
import org.thingsboard.server.dao.cassandra.guava.GuavaSession;

@DisabledInAotMode
class CassandraToSqlTableDiffblueTest {
  @MockBean
  private CassandraToSqlTable cassandraToSqlTable;

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return {@code Cassandra Cf}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, String, int, CassandraToSqlColumn[]); then return 'Cassandra Cf'")
  void testNewCassandraToSqlTable_thenReturnCassandraCf() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable = new CassandraToSqlTable("Cassandra Cf", "Sql Table Name", 3,
        cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Cassandra Cf", actualCassandraToSqlTable.getCassandraCf());
    assertEquals("Sql Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(1, actualCassandraToSqlTable.getColumns().size());
    assertEquals(3, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, int, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return CassandraCf is {@code Table Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, int, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, int, CassandraToSqlColumn[]); then return CassandraCf is 'Table Name'")
  void testNewCassandraToSqlTable_thenReturnCassandraCfIsTableName() {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable = new CassandraToSqlTable("Table Name", 3, cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Table Name", actualCassandraToSqlTable.getCassandraCf());
    assertEquals("Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(1, actualCassandraToSqlTable.getColumns().size());
    assertEquals(3, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return CassandraCf is {@code Table Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, CassandraToSqlColumn[]); then return CassandraCf is 'Table Name'")
  void testNewCassandraToSqlTable_thenReturnCassandraCfIsTableName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Table Name", actualCassandraToSqlTable.getCassandraCf());
    assertEquals("Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(1, actualCassandraToSqlTable.getColumns().size());
    assertEquals(10000, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, int, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return Columns first is bigintColumn {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, int, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, int, CassandraToSqlColumn[]); then return Columns first is bigintColumn 'Name'")
  void testNewCassandraToSqlTable_thenReturnColumnsFirstIsBigintColumnName() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns = (new CassandraToSqlTable("Table Name", 3, bigintColumnResult)).getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return Columns first is bigintColumn {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, int, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, String, int, CassandraToSqlColumn[]); then return Columns first is bigintColumn 'Name'")
  void testNewCassandraToSqlTable_thenReturnColumnsFirstIsBigintColumnName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns = (new CassandraToSqlTable("Cassandra Cf", "Sql Table Name", 3,
        bigintColumnResult)).getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return Columns first is bigintColumn {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, String, CassandraToSqlColumn[]); then return Columns first is bigintColumn 'Name'")
  void testNewCassandraToSqlTable_thenReturnColumnsFirstIsBigintColumnName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns = (new CassandraToSqlTable("Table Name", "Sql Table Name", bigintColumnResult))
        .getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return Columns first is bigintColumn {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, CassandraToSqlColumn[]); then return Columns first is bigintColumn 'Name'")
  void testNewCassandraToSqlTable_thenReturnColumnsFirstIsBigintColumnName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    List<CassandraToSqlColumn> columns = (new CassandraToSqlTable("Table Name", bigintColumnResult)).getColumns();
    assertEquals(1, columns.size());
    assertSame(bigintColumnResult, columns.get(0));
  }

  /**
   * Test
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, CassandraToSqlColumn[])}.
   * <ul>
   *   <li>Then return {@code Sql Table Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#CassandraToSqlTable(String, String, CassandraToSqlColumn[])}
   */
  @Test
  @DisplayName("Test new CassandraToSqlTable(String, String, CassandraToSqlColumn[]); then return 'Sql Table Name'")
  void testNewCassandraToSqlTable_thenReturnSqlTableName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    CassandraToSqlTable actualCassandraToSqlTable = new CassandraToSqlTable("Table Name", "Sql Table Name",
        cassandraToSqlColumn);

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertEquals("Sql Table Name", actualCassandraToSqlTable.getSqlTableName());
    assertEquals("Table Name", actualCassandraToSqlTable.getCassandraCf());
    assertNull(actualCassandraToSqlTable.getSqlInsertStatement());
    assertEquals(1, actualCassandraToSqlTable.getColumns().size());
    assertEquals(10000, actualCassandraToSqlTable.getBatchSize());
  }

  /**
   * Test {@link CassandraToSqlTable#migrateToSql(GuavaSession, Connection)}.
   * <ul>
   *   <li>Then throw {@link PSQLException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#migrateToSql(GuavaSession, Connection)}
   */
  @Test
  @DisplayName("Test migrateToSql(GuavaSession, Connection); then throw PSQLException")
  void testMigrateToSql_thenThrowPSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));
    DefaultGuavaSession session = new DefaultGuavaSession(new DefaultDseSession(new SessionWrapper(null)));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(Mockito.<String>any())).thenThrow(new PSQLException(
        "[{}] Migrating data from cassandra '{}' Column Family to '{}' SQL table...", PSQLState.UNKNOWN_STATE));
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    DatabaseMetaData databaseMetaData = mock(DatabaseMetaData.class);
    when(databaseMetaData.getColumns(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(resultSet);
    Connection conn = mock(Connection.class);
    when(conn.getMetaData()).thenReturn(databaseMetaData);

    // Act and Assert
    assertThrows(PSQLException.class, () -> cassandraToSqlTable.migrateToSql(session, conn));
    verify(conn).getMetaData();
    verify(databaseMetaData).getColumns(isNull(), isNull(), eq("Table Name"), isNull());
    verify(resultSet).getString(eq("COLUMN_NAME"));
    verify(resultSet).next();
  }

  /**
   * Test
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test validateColumnData(CassandraToSqlColumnData[])")
  void testValidateColumnData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));
    CassandraToSqlColumnData[] data = new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")};

    // Act and Assert
    assertSame(data, cassandraToSqlTable.validateColumnData(data));
  }

  /**
   * Test
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test validateColumnData(CassandraToSqlColumnData[])")
  void testValidateColumnData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getType()).thenReturn(CassandraToSqlColumnType.STRING);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    CassandraToSqlColumnData[] data = new CassandraToSqlColumnData[]{new CassandraToSqlColumnData(null)};

    // Act
    CassandraToSqlColumnData[] actualValidateColumnDataResult = cassandraToSqlTable.validateColumnData(data);

    // Assert
    verify(cassandraToSqlColumn).getType();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertSame(data, actualValidateColumnDataResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test validateColumnData(CassandraToSqlColumnData[])")
  void testValidateColumnData3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSize()).thenReturn(3);
    when(cassandraToSqlColumn.getType()).thenReturn(CassandraToSqlColumnType.STRING);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    CassandraToSqlColumnData cassandraToSqlColumnData = mock(CassandraToSqlColumnData.class);
    when(cassandraToSqlColumnData.getValue()).thenReturn("42");
    CassandraToSqlColumnData[] data = new CassandraToSqlColumnData[]{cassandraToSqlColumnData};

    // Act
    CassandraToSqlColumnData[] actualValidateColumnDataResult = cassandraToSqlTable.validateColumnData(data);

    // Assert
    verify(cassandraToSqlColumn).getSize();
    verify(cassandraToSqlColumn).getType();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    verify(cassandraToSqlColumnData).getValue();
    assertSame(data, actualValidateColumnDataResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}.
   * <ul>
   *   <li>Given {@link CassandraToSqlColumn} {@link CassandraToSqlColumn#getSize()}
   * return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test validateColumnData(CassandraToSqlColumnData[]); given CassandraToSqlColumn getSize() return three")
  void testValidateColumnData_givenCassandraToSqlColumnGetSizeReturnThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSize()).thenReturn(3);
    when(cassandraToSqlColumn.getType()).thenReturn(CassandraToSqlColumnType.STRING);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    CassandraToSqlColumnData[] data = new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")};

    // Act
    CassandraToSqlColumnData[] actualValidateColumnDataResult = cassandraToSqlTable.validateColumnData(data);

    // Assert
    verify(cassandraToSqlColumn).getSize();
    verify(cassandraToSqlColumn).getType();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertSame(data, actualValidateColumnDataResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}.
   * <ul>
   *   <li>Given {@link CassandraToSqlColumn} {@link CassandraToSqlColumn#getType()}
   * return {@code ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test validateColumnData(CassandraToSqlColumnData[]); given CassandraToSqlColumn getType() return 'ID'")
  void testValidateColumnData_givenCassandraToSqlColumnGetTypeReturnId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getType()).thenReturn(CassandraToSqlColumnType.ID);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    CassandraToSqlColumnData[] data = new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")};

    // Act
    CassandraToSqlColumnData[] actualValidateColumnDataResult = cassandraToSqlTable.validateColumnData(data);

    // Assert
    verify(cassandraToSqlColumn).getType();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertSame(data, actualValidateColumnDataResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}.
   * <ul>
   *   <li>Then calls {@link CassandraToSqlColumnData#getLogValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test validateColumnData(CassandraToSqlColumnData[]); then calls getLogValue()")
  void testValidateColumnData_thenCallsGetLogValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSize()).thenReturn(1);
    when(cassandraToSqlColumn.getSqlColumnName()).thenReturn("Sql Column Name");
    when(cassandraToSqlColumn.getType()).thenReturn(CassandraToSqlColumnType.STRING);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    CassandraToSqlColumnData cassandraToSqlColumnData = mock(CassandraToSqlColumnData.class);
    when(cassandraToSqlColumnData.getLogValue()).thenReturn("42");
    doNothing().when(cassandraToSqlColumnData).setOriginalValue(Mockito.<String>any());
    doNothing().when(cassandraToSqlColumnData).setValue(Mockito.<String>any());
    when(cassandraToSqlColumnData.getValue()).thenReturn("42");
    CassandraToSqlColumnData[] data = new CassandraToSqlColumnData[]{cassandraToSqlColumnData};

    // Act
    CassandraToSqlColumnData[] actualValidateColumnDataResult = cassandraToSqlTable.validateColumnData(data);

    // Assert
    verify(cassandraToSqlColumn, atLeast(1)).getSize();
    verify(cassandraToSqlColumn, atLeast(1)).getSqlColumnName();
    verify(cassandraToSqlColumn).getType();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    verify(cassandraToSqlColumnData).getLogValue();
    verify(cassandraToSqlColumnData).getValue();
    verify(cassandraToSqlColumnData).setOriginalValue(eq("4"));
    verify(cassandraToSqlColumnData).setValue(eq("4"));
    assertSame(data, actualValidateColumnDataResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}.
   * <ul>
   *   <li>Then calls {@link CassandraToSqlColumn#getSqlColumnName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#validateColumnData(CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test validateColumnData(CassandraToSqlColumnData[]); then calls getSqlColumnName()")
  void testValidateColumnData_thenCallsGetSqlColumnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSize()).thenReturn(1);
    when(cassandraToSqlColumn.getSqlColumnName()).thenReturn("Sql Column Name");
    when(cassandraToSqlColumn.getType()).thenReturn(CassandraToSqlColumnType.STRING);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    CassandraToSqlColumnData[] data = new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")};

    // Act
    CassandraToSqlColumnData[] actualValidateColumnDataResult = cassandraToSqlTable.validateColumnData(data);

    // Assert
    verify(cassandraToSqlColumn, atLeast(1)).getSize();
    verify(cassandraToSqlColumn, atLeast(1)).getSqlColumnName();
    verify(cassandraToSqlColumn).getType();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertSame(data, actualValidateColumnDataResult);
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection); given SQLException(); then throw SQLException")
  void testBatchInsert_givenSQLException_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    Connection conn = mock(Connection.class);
    doThrow(new SQLException()).when(conn).commit();

    // Act and Assert
    assertThrows(SQLException.class, () -> cassandraToSqlTable.batchInsert(batchData, conn));
    verify(conn).commit();
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   * <ul>
   *   <li>Then calls {@link PreparedStatement#executeUpdate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection); then calls executeUpdate()")
  void testBatchInsert_thenCallsExecuteUpdate() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getIndex()).thenReturn(0);
    doNothing().when(cassandraToSqlColumn).setColumnValue(Mockito.<PreparedStatement>any(), Mockito.<String>any());
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    when(sqlInsertStatement.executeUpdate()).thenReturn(1);

    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    cassandraToSqlTable.setSqlInsertStatement(sqlInsertStatement);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")});
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert that nothing has changed
    verify(conn).commit();
    verify(sqlInsertStatement).executeUpdate();
    verify(cassandraToSqlColumn).getIndex();
    verify(cassandraToSqlColumn).setColumnValue(isA(PreparedStatement.class), eq("42"));
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
  }

  /**
   * Test {@link CassandraToSqlTable#batchInsert(List, Connection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Connection#commit()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#batchInsert(List, Connection)}
   */
  @Test
  @DisplayName("Test batchInsert(List, Connection); when ArrayList(); then calls commit()")
  void testBatchInsert_whenArrayList_thenCallsCommit() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    Connection conn = mock(Connection.class);
    doNothing().when(conn).commit();

    // Act
    cassandraToSqlTable.batchInsert(batchData, conn);

    // Assert that nothing has changed
    verify(conn).commit();
  }

  /**
   * Test
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}
   */
  @Test
  @DisplayName("Test onConstraintViolation(List, CassandraToSqlColumnData[], String)")
  void testOnConstraintViolation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();

    // Act and Assert
    assertFalse(cassandraToSqlTable.onConstraintViolation(batchData,
        new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")}, "Constraint"));
  }

  /**
   * Test
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}
   */
  @Test
  @DisplayName("Test onConstraintViolation(List, CassandraToSqlColumnData[], String)")
  void testOnConstraintViolation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")});

    // Act
    boolean actualOnConstraintViolationResult = cassandraToSqlTable.onConstraintViolation(batchData,
        new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")}, "Constraint");

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertFalse(actualOnConstraintViolationResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}
   */
  @Test
  @DisplayName("Test onConstraintViolation(List, CassandraToSqlColumnData[], String)")
  void testOnConstraintViolation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")});
    batchData.add(new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")});

    // Act
    boolean actualOnConstraintViolationResult = cassandraToSqlTable.onConstraintViolation(batchData,
        new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")}, "Constraint");

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertFalse(actualOnConstraintViolationResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link CassandraToSqlColumn#setIndex(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#onConstraintViolation(List, CassandraToSqlColumnData[], String)}
   */
  @Test
  @DisplayName("Test onConstraintViolation(List, CassandraToSqlColumnData[], String); when ArrayList(); then calls setIndex(int)")
  void testOnConstraintViolation_whenArrayList_thenCallsSetIndex() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();

    // Act
    boolean actualOnConstraintViolationResult = cassandraToSqlTable.onConstraintViolation(batchData,
        new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")}, "Constraint");

    // Assert
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertFalse(actualOnConstraintViolationResult);
  }

  /**
   * Test
   * {@link CassandraToSqlTable#ignoreRecord(List, CassandraToSqlColumnData[])}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then calls {@link CassandraToSqlColumnData#getLogValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#ignoreRecord(List, CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test ignoreRecord(List, CassandraToSqlColumnData[]); given '42'; then calls getLogValue()")
  void testIgnoreRecord_given42_thenCallsGetLogValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSqlColumnName()).thenReturn("Sql Column Name");
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    CassandraToSqlColumnData cassandraToSqlColumnData = mock(CassandraToSqlColumnData.class);
    when(cassandraToSqlColumnData.getLogValue()).thenReturn("42");

    // Act
    cassandraToSqlTable.ignoreRecord(batchData, new CassandraToSqlColumnData[]{cassandraToSqlColumnData});

    // Assert
    verify(cassandraToSqlColumn).getSqlColumnName();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    verify(cassandraToSqlColumnData).getLogValue();
  }

  /**
   * Test
   * {@link CassandraToSqlTable#ignoreRecord(List, CassandraToSqlColumnData[])}.
   * <ul>
   *   <li>Then calls {@link CassandraToSqlColumnData#getLogValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#ignoreRecord(List, CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test ignoreRecord(List, CassandraToSqlColumnData[]); then calls getLogValue()")
  void testIgnoreRecord_thenCallsGetLogValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSqlColumnName()).thenReturn("Sql Column Name");
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);

    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();
    batchData.add(new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")});
    batchData.add(new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")});
    CassandraToSqlColumnData cassandraToSqlColumnData = mock(CassandraToSqlColumnData.class);
    when(cassandraToSqlColumnData.getLogValue()).thenReturn("42");

    // Act
    cassandraToSqlTable.ignoreRecord(batchData, new CassandraToSqlColumnData[]{cassandraToSqlColumnData});

    // Assert
    verify(cassandraToSqlColumn).getSqlColumnName();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    verify(cassandraToSqlColumnData).getLogValue();
  }

  /**
   * Test
   * {@link CassandraToSqlTable#ignoreRecord(List, CassandraToSqlColumnData[])}.
   * <ul>
   *   <li>Then calls {@link CassandraToSqlColumn#getSqlColumnName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#ignoreRecord(List, CassandraToSqlColumnData[])}
   */
  @Test
  @DisplayName("Test ignoreRecord(List, CassandraToSqlColumnData[]); then calls getSqlColumnName()")
  void testIgnoreRecord_thenCallsGetSqlColumnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSqlColumnName()).thenReturn("Sql Column Name");
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);
    ArrayList<CassandraToSqlColumnData[]> batchData = new ArrayList<>();

    // Act
    cassandraToSqlTable.ignoreRecord(batchData, new CassandraToSqlColumnData[]{new CassandraToSqlColumnData("42")});

    // Assert
    verify(cassandraToSqlColumn).getSqlColumnName();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
  }

  /**
   * Test {@link CassandraToSqlTable#getColumn(String)}.
   * <p>
   * Method under test: {@link CassandraToSqlTable#getColumn(String)}
   */
  @Test
  @DisplayName("Test getColumn(String)")
  void testGetColumn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Sql Column Name");

    // Act and Assert
    assertSame(bigintColumnResult,
        (new CassandraToSqlTable("Table Name", bigintColumnResult)).getColumn("Sql Column Name"));
  }

  /**
   * Test {@link CassandraToSqlTable#getColumn(String)}.
   * <p>
   * Method under test: {@link CassandraToSqlTable#getColumn(String)}
   */
  @Test
  @DisplayName("Test getColumn(String)")
  void testGetColumn2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn("Sql Column Name");

    // Act and Assert
    assertSame(bigintColumnResult2,
        (new CassandraToSqlTable("Table Name", bigintColumnResult, bigintColumnResult2)).getColumn("Sql Column Name"));
  }

  /**
   * Test {@link CassandraToSqlTable#getColumn(String)}.
   * <ul>
   *   <li>Then calls {@link CassandraToSqlColumn#getSqlColumnName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#getColumn(String)}
   */
  @Test
  @DisplayName("Test getColumn(String); then calls getSqlColumnName()")
  void testGetColumn_thenCallsGetSqlColumnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getSqlColumnName()).thenReturn("Sql Column Name");
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    (new CassandraToSqlTable("Table Name", cassandraToSqlColumn)).getColumn("Sql Column Name");

    // Assert
    verify(cassandraToSqlColumn).getSqlColumnName();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
  }

  /**
   * Test
   * {@link CassandraToSqlTable#getColumnData(CassandraToSqlColumnData[], String)}.
   * <ul>
   *   <li>Then return
   * {@link CassandraToSqlColumnData#CassandraToSqlColumnData(String)} with value
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#getColumnData(CassandraToSqlColumnData[], String)}
   */
  @Test
  @DisplayName("Test getColumnData(CassandraToSqlColumnData[], String); then return CassandraToSqlColumnData(String) with value is '42'")
  void testGetColumnData_thenReturnCassandraToSqlColumnDataWithValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Sql Column Name"));
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData("42");

    // Act and Assert
    assertSame(cassandraToSqlColumnData,
        cassandraToSqlTable.getColumnData(new CassandraToSqlColumnData[]{cassandraToSqlColumnData}, "Sql Column Name"));
  }

  /**
   * Test {@link CassandraToSqlTable#createCassandraSelectStatement()}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#createCassandraSelectStatement()}
   */
  @Test
  @DisplayName("Test createCassandraSelectStatement()")
  void testCreateCassandraSelectStatement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Statement actualCreateCassandraSelectStatementResult = (new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"))).createCassandraSelectStatement();

    // Assert
    assertTrue(actualCreateCassandraSelectStatementResult instanceof DefaultSimpleStatement);
    assertEquals("SELECT Name FROM Table Name",
        ((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getQuery());
    assertNull(actualCreateCassandraSelectStatementResult.getConsistencyLevel());
    assertNull(actualCreateCassandraSelectStatementResult.getSerialConsistencyLevel());
    assertNull(actualCreateCassandraSelectStatementResult.getKeyspace());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingKeyspace());
    assertNull(actualCreateCassandraSelectStatementResult.getExecutionProfile());
    assertNull(actualCreateCassandraSelectStatementResult.getNode());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingToken());
    assertNull(actualCreateCassandraSelectStatementResult.isIdempotent());
    assertNull(actualCreateCassandraSelectStatementResult.getExecutionProfileName());
    assertNull(actualCreateCassandraSelectStatementResult.getPagingState());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingKey());
    assertNull(actualCreateCassandraSelectStatementResult.getTimeout());
    assertFalse(actualCreateCassandraSelectStatementResult.isTracing());
    assertTrue(((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getPositionalValues().isEmpty());
    Map<String, ByteBuffer> customPayload = actualCreateCassandraSelectStatementResult.getCustomPayload();
    assertTrue(customPayload.isEmpty());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getFetchSize());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getNowInSeconds());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getPageSize());
    assertEquals(Long.MIN_VALUE, actualCreateCassandraSelectStatementResult.getDefaultTimestamp());
    assertEquals(Long.MIN_VALUE, actualCreateCassandraSelectStatementResult.getQueryTimestamp());
    assertSame(customPayload, ((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getNamedValues());
  }

  /**
   * Test {@link CassandraToSqlTable#createCassandraSelectStatement()}.
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#createCassandraSelectStatement()}
   */
  @Test
  @DisplayName("Test createCassandraSelectStatement()")
  void testCreateCassandraSelectStatement2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    when(cassandraToSqlColumn.getCassandraColumnName()).thenReturn("Cassandra Column Name");
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());

    // Act
    Statement actualCreateCassandraSelectStatementResult = (new CassandraToSqlTable("Table Name", cassandraToSqlColumn))
        .createCassandraSelectStatement();

    // Assert
    verify(cassandraToSqlColumn).getCassandraColumnName();
    verify(cassandraToSqlColumn).setIndex(eq(0));
    verify(cassandraToSqlColumn).setSqlIndex(eq(1));
    assertTrue(actualCreateCassandraSelectStatementResult instanceof DefaultSimpleStatement);
    assertEquals("SELECT Cassandra Column Name FROM Table Name",
        ((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getQuery());
    assertNull(actualCreateCassandraSelectStatementResult.getConsistencyLevel());
    assertNull(actualCreateCassandraSelectStatementResult.getSerialConsistencyLevel());
    assertNull(actualCreateCassandraSelectStatementResult.getKeyspace());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingKeyspace());
    assertNull(actualCreateCassandraSelectStatementResult.getExecutionProfile());
    assertNull(actualCreateCassandraSelectStatementResult.getNode());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingToken());
    assertNull(actualCreateCassandraSelectStatementResult.isIdempotent());
    assertNull(actualCreateCassandraSelectStatementResult.getExecutionProfileName());
    assertNull(actualCreateCassandraSelectStatementResult.getPagingState());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingKey());
    assertNull(actualCreateCassandraSelectStatementResult.getTimeout());
    assertFalse(actualCreateCassandraSelectStatementResult.isTracing());
    assertTrue(((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getPositionalValues().isEmpty());
    Map<String, ByteBuffer> customPayload = actualCreateCassandraSelectStatementResult.getCustomPayload();
    assertTrue(customPayload.isEmpty());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getFetchSize());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getNowInSeconds());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getPageSize());
    assertEquals(Long.MIN_VALUE, actualCreateCassandraSelectStatementResult.getDefaultTimestamp());
    assertEquals(Long.MIN_VALUE, actualCreateCassandraSelectStatementResult.getQueryTimestamp());
    assertSame(customPayload, ((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getNamedValues());
  }

  /**
   * Test {@link CassandraToSqlTable#createCassandraSelectStatement()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add bigintColumn {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlTable#createCassandraSelectStatement()}
   */
  @Test
  @DisplayName("Test createCassandraSelectStatement(); given ArrayList() add bigintColumn 'Name'")
  void testCreateCassandraSelectStatement_givenArrayListAddBigintColumnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CassandraToSqlColumn> columns = new ArrayList<>();
    columns.add(CassandraToSqlColumn.bigintColumn("Name"));

    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));
    cassandraToSqlTable.setColumns(columns);

    // Act
    Statement actualCreateCassandraSelectStatementResult = cassandraToSqlTable.createCassandraSelectStatement();

    // Assert
    assertTrue(actualCreateCassandraSelectStatementResult instanceof DefaultSimpleStatement);
    assertEquals("SELECT Name FROM Table Name",
        ((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getQuery());
    assertNull(actualCreateCassandraSelectStatementResult.getConsistencyLevel());
    assertNull(actualCreateCassandraSelectStatementResult.getSerialConsistencyLevel());
    assertNull(actualCreateCassandraSelectStatementResult.getKeyspace());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingKeyspace());
    assertNull(actualCreateCassandraSelectStatementResult.getExecutionProfile());
    assertNull(actualCreateCassandraSelectStatementResult.getNode());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingToken());
    assertNull(actualCreateCassandraSelectStatementResult.isIdempotent());
    assertNull(actualCreateCassandraSelectStatementResult.getExecutionProfileName());
    assertNull(actualCreateCassandraSelectStatementResult.getPagingState());
    assertNull(actualCreateCassandraSelectStatementResult.getRoutingKey());
    assertNull(actualCreateCassandraSelectStatementResult.getTimeout());
    assertFalse(actualCreateCassandraSelectStatementResult.isTracing());
    assertTrue(((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getPositionalValues().isEmpty());
    Map<String, ByteBuffer> customPayload = actualCreateCassandraSelectStatementResult.getCustomPayload();
    assertTrue(customPayload.isEmpty());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getFetchSize());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getNowInSeconds());
    assertEquals(Integer.MIN_VALUE, actualCreateCassandraSelectStatementResult.getPageSize());
    assertEquals(Long.MIN_VALUE, actualCreateCassandraSelectStatementResult.getDefaultTimestamp());
    assertEquals(Long.MIN_VALUE, actualCreateCassandraSelectStatementResult.getQueryTimestamp());
    assertSame(customPayload, ((DefaultSimpleStatement) actualCreateCassandraSelectStatementResult).getNamedValues());
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}, and
   * {@link CassandraToSqlTable#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlTable#equals(Object)}
   *   <li>{@link CassandraToSqlTable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));
    CassandraToSqlTable cassandraToSqlTable2 = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertEquals(cassandraToSqlTable, cassandraToSqlTable2);
    int expectedHashCodeResult = cassandraToSqlTable.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlTable2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}, and
   * {@link CassandraToSqlTable#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlTable#equals(Object)}
   *   <li>{@link CassandraToSqlTable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertEquals(cassandraToSqlTable, cassandraToSqlTable);
    int expectedHashCodeResult = cassandraToSqlTable.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlTable.hashCode());
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Name",
        CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertNotEquals(cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable(null, CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertNotEquals(cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Table Name"));

    // Act and Assert
    assertNotEquals(cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = mock(CassandraToSqlColumn.class);
    doNothing().when(cassandraToSqlColumn).setIndex(anyInt());
    doNothing().when(cassandraToSqlColumn).setSqlIndex(anyInt());
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", cassandraToSqlColumn);

    // Act and Assert
    assertNotEquals(cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name", 3,
        CassandraToSqlColumn.bigintColumn("Name"));

    // Act and Assert
    assertNotEquals(cassandraToSqlTable,
        new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")));
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")), null);
  }

  /**
   * Test {@link CassandraToSqlTable#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlTable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraToSqlTable("Table Name", CassandraToSqlColumn.bigintColumn("Name")),
        "Different type to CassandraToSqlTable");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange
    CassandraToSqlTable cassandraToSqlTable = new CassandraToSqlTable("Table Name",
        CassandraToSqlColumn.bigintColumn("Name"));

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

    // Assert that nothing has changed
    assertEquals("Cassandra Cf", actualCassandraCf);
    assertEquals("Sql Table Name", cassandraToSqlTable.getSqlTableName());
    assertEquals(3, actualBatchSize);
    assertTrue(actualColumns.isEmpty());
    assertSame(columns, actualColumns);
    assertSame(sqlInsertStatement, actualSqlInsertStatement);
  }
}
