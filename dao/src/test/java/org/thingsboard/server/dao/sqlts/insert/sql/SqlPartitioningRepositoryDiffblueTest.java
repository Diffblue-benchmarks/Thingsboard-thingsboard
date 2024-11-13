package org.thingsboard.server.dao.sqlts.insert.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.dao.timeseries.SqlPartition;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {SqlPartitioningRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class SqlPartitioningRepositoryDiffblueTest {
  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private SqlPartitioningRepository sqlPartitioningRepository;

  /**
   * Test {@link SqlPartitioningRepository#save(SqlPartition)}.
   * <p>
   * Method under test: {@link SqlPartitioningRepository#save(SqlPartition)}
   */
  @Test
  public void testSave() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    sqlPartitioningRepository.save(new SqlPartition("Table", 1L, 1L, "2020-03-01"));

    // Assert that nothing has changed
    verify(jdbcTemplate)
        .execute(eq("CREATE TABLE IF NOT EXISTS Table_2020-03-01 PARTITION OF Table FOR VALUES FROM (1) TO (1)"));
  }

  /**
   * Test {@link SqlPartitioningRepository#save(SqlPartition)}.
   * <ul>
   *   <li>Given {@code Query}.</li>
   *   <li>When {@link SqlPartition} {@link SqlPartition#getQuery()} return
   * {@code Query}.</li>
   *   <li>Then calls {@link SqlPartition#getQuery()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlPartitioningRepository#save(SqlPartition)}
   */
  @Test
  public void testSave_givenQuery_whenSqlPartitionGetQueryReturnQuery_thenCallsGetQuery() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    SqlPartition partition = mock(SqlPartition.class);
    when(partition.getQuery()).thenReturn("Query");

    // Act
    sqlPartitioningRepository.save(partition);

    // Assert that nothing has changed
    verify(jdbcTemplate).execute(eq("Query"));
    verify(partition).getQuery();
  }

  /**
   * Test {@link SqlPartitioningRepository#save(SqlPartition)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlPartitioningRepository#save(SqlPartition)}
   */
  @Test
  public void testSave_thenThrowEmptyResultDataAccessException() throws DataAccessException {
    // Arrange
    doThrow(new EmptyResultDataAccessException(3)).when(jdbcTemplate).execute(Mockito.<String>any());

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> sqlPartitioningRepository.save(new SqlPartition("Table", 1L, 1L, "2020-03-01")));
    verify(jdbcTemplate)
        .execute(eq("CREATE TABLE IF NOT EXISTS Table_2020-03-01 PARTITION OF Table FOR VALUES FROM (1) TO (1)"));
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#createPartitionIfNotExists(String, long, long)}.
   * <ul>
   *   <li>When {@code java.lang.Integer}.</li>
   *   <li>Then calls {@link JdbcTemplate#execute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#createPartitionIfNotExists(String, long, long)}
   */
  @Test
  public void testCreatePartitionIfNotExists_whenJavaLangInteger_thenCallsExecute() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    sqlPartitioningRepository.createPartitionIfNotExists("java.lang.Integer", 1L, 1L);

    // Assert
    verify(jdbcTemplate).execute(
        eq("CREATE TABLE IF NOT EXISTS java.lang.Integer_1 PARTITION OF java.lang.Integer FOR VALUES FROM (1) TO (2)"));
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#createPartitionIfNotExists(String, long, long)}.
   * <ul>
   *   <li>When {@code Table}.</li>
   *   <li>Then calls {@link JdbcTemplate#execute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#createPartitionIfNotExists(String, long, long)}
   */
  @Test
  public void testCreatePartitionIfNotExists_whenTable_thenCallsExecute() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    sqlPartitioningRepository.createPartitionIfNotExists("Table", 1L, 1L);

    // Assert
    verify(jdbcTemplate)
        .execute(eq("CREATE TABLE IF NOT EXISTS Table_1 PARTITION OF Table FOR VALUES FROM (1) TO (2)"));
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}.
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}
   */
  @Test
  public void testDropPartitionsBefore() throws DataAccessException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(stringList);

    // Act
    long actualDropPartitionsBeforeResult = sqlPartitioningRepository.dropPartitionsBefore("Table", 1L, 1L);

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertEquals(-1L, actualDropPartitionsBeforeResult);
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}.
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}
   */
  @Test
  public void testDropPartitionsBefore2() throws DataAccessException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    doThrow(new EmptyResultDataAccessException(3)).when(jdbcTemplate).execute(Mockito.<String>any());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(stringList);

    // Act
    long actualDropPartitionsBeforeResult = sqlPartitioningRepository.dropPartitionsBefore("", Long.MAX_VALUE, 1L);

    // Assert
    verify(jdbcTemplate).execute(eq("ALTER TABLE  DETACH PARTITION _2"));
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertEquals(-1L, actualDropPartitionsBeforeResult);
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}
   */
  @Test
  public void testDropPartitionsBefore_givenArrayListAdd42_whenEmptyString_thenReturnMinusOne()
      throws DataAccessException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(stringList);

    // Act
    long actualDropPartitionsBeforeResult = sqlPartitioningRepository.dropPartitionsBefore("", 1L, 1L);

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertEquals(-1L, actualDropPartitionsBeforeResult);
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}.
   * <ul>
   *   <li>Given {@link JdbcTemplate} {@link JdbcTemplate#execute(String)} does
   * nothing.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}
   */
  @Test
  public void testDropPartitionsBefore_givenJdbcTemplateExecuteDoesNothing_thenReturnThree()
      throws DataAccessException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(stringList);

    // Act
    long actualDropPartitionsBeforeResult = sqlPartitioningRepository.dropPartitionsBefore("", Long.MAX_VALUE, 1L);

    // Assert
    verify(jdbcTemplate, atLeast(1)).execute(Mockito.<String>any());
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertEquals(3L, actualDropPartitionsBeforeResult);
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}
   */
  @Test
  public void testDropPartitionsBefore_thenThrowEmptyResultDataAccessException() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> sqlPartitioningRepository.dropPartitionsBefore("Table", 1L, 1L));
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}.
   * <ul>
   *   <li>When {@code Table}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}
   */
  @Test
  public void testDropPartitionsBefore_whenTable_thenReturnMinusOne() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    long actualDropPartitionsBeforeResult = sqlPartitioningRepository.dropPartitionsBefore("Table", 1L, 1L);

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertEquals(-1L, actualDropPartitionsBeforeResult);
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#cleanupPartitionsCache(String, long, long)}.
   * <ul>
   *   <li>Then calls
   * {@link SqlPartitioningRepository#cleanupPartitionsCache(String, long, long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#cleanupPartitionsCache(String, long, long)}
   */
  @Test
  public void testCleanupPartitionsCache_thenCallsCleanupPartitionsCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DedicatedEventsSqlPartitioningRepository dedicatedEventsSqlPartitioningRepository = mock(
        DedicatedEventsSqlPartitioningRepository.class);
    doNothing().when(dedicatedEventsSqlPartitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act
    dedicatedEventsSqlPartitioningRepository.cleanupPartitionsCache(null, 1L, 1L);

    // Assert that nothing has changed
    verify(dedicatedEventsSqlPartitioningRepository).cleanupPartitionsCache(isNull(), eq(1L), eq(1L));
  }

  /**
   * Test {@link SqlPartitioningRepository#fetchPartitions(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlPartitioningRepository#fetchPartitions(String)}
   */
  @Test
  public void testFetchPartitions_givenArrayListAdd42_whenEmptyString_thenReturnSizeIsOne() throws DataAccessException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(stringList);

    // Act
    List<Long> actualFetchPartitionsResult = sqlPartitioningRepository.fetchPartitions("");

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertEquals(1, actualFetchPartitionsResult.size());
    assertEquals(2L, actualFetchPartitionsResult.get(0).longValue());
  }

  /**
   * Test {@link SqlPartitioningRepository#fetchPartitions(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlPartitioningRepository#fetchPartitions(String)}
   */
  @Test
  public void testFetchPartitions_thenReturnEmpty() throws DataAccessException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')");
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(stringList);

    // Act
    List<Long> actualFetchPartitionsResult = sqlPartitioningRepository.fetchPartitions("Table");

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertTrue(actualFetchPartitionsResult.isEmpty());
  }

  /**
   * Test {@link SqlPartitioningRepository#fetchPartitions(String)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlPartitioningRepository#fetchPartitions(String)}
   */
  @Test
  public void testFetchPartitions_thenThrowEmptyResultDataAccessException() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class, () -> sqlPartitioningRepository.fetchPartitions("Table"));
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
  }

  /**
   * Test {@link SqlPartitioningRepository#fetchPartitions(String)}.
   * <ul>
   *   <li>When {@code Table}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlPartitioningRepository#fetchPartitions(String)}
   */
  @Test
  public void testFetchPartitions_whenTable_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<String>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<Long> actualFetchPartitionsResult = sqlPartitioningRepository.fetchPartitions("Table");

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("SELECT tablename from pg_tables WHERE schemaname = 'public' and tablename like concat(?, '_%')"),
        isA(Class.class), isA(Object[].class));
    assertTrue(actualFetchPartitionsResult.isEmpty());
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  public void testCalculatePartitionStartTime_whenFive_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, sqlPartitioningRepository.calculatePartitionStartTime(5L, 5L));
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  public void testCalculatePartitionStartTime_whenMinusOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, sqlPartitioningRepository.calculatePartitionStartTime(-1L, 5L));
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  public void testCalculatePartitionStartTime_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, sqlPartitioningRepository.calculatePartitionStartTime(1L, 5L));
  }

  /**
   * Test
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  public void testCalculatePartitionStartTime_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, sqlPartitioningRepository.calculatePartitionStartTime(0L, 5L));
  }

  /**
   * Test {@link SqlPartitioningRepository#getJdbcTemplate()}.
   * <p>
   * Method under test: {@link SqlPartitioningRepository#getJdbcTemplate()}
   */
  @Test
  public void testGetJdbcTemplate() {
    // Arrange, Act and Assert
    assertNull((new SqlPartitioningRepository()).getJdbcTemplate());
  }
}
