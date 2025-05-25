package org.thingsboard.server.dao.sqlts.insert.sql;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thingsboard.server.dao.timeseries.SqlPartition;

@RunWith(MockitoJUnitRunner.class)
public class DedicatedEventsSqlPartitioningRepositoryDiffblueTest {
  @InjectMocks
  private DedicatedEventsSqlPartitioningRepository dedicatedEventsSqlPartitioningRepository;

  @Mock
  private JdbcTemplate jdbcTemplate;

  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#save(SqlPartition)}.
   * <p>
   * Method under test: {@link DedicatedEventsSqlPartitioningRepository#save(SqlPartition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DedicatedEventsSqlPartitioningRepository.save(SqlPartition)"})
  public void testSave() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    dedicatedEventsSqlPartitioningRepository.save(new SqlPartition("Table", 1L, 1L, "2020-03-01"));

    // Assert
    verify(jdbcTemplate)
        .execute(eq("CREATE TABLE IF NOT EXISTS Table_2020-03-01 PARTITION OF Table FOR VALUES FROM (1) TO (1)"));
  }

  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#save(SqlPartition)}.
   * <ul>
   *   <li>Given {@code Query}.</li>
   *   <li>When {@link SqlPartition} {@link SqlPartition#getQuery()} return {@code Query}.</li>
   *   <li>Then calls {@link SqlPartition#getQuery()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DedicatedEventsSqlPartitioningRepository#save(SqlPartition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DedicatedEventsSqlPartitioningRepository.save(SqlPartition)"})
  public void testSave_givenQuery_whenSqlPartitionGetQueryReturnQuery_thenCallsGetQuery() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    SqlPartition partition = mock(SqlPartition.class);
    when(partition.getQuery()).thenReturn("Query");

    // Act
    dedicatedEventsSqlPartitioningRepository.save(partition);

    // Assert
    verify(jdbcTemplate).execute(eq("Query"));
    verify(partition).getQuery();
  }

  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#createPartitionIfNotExists(String, long, long)}.
   * <ul>
   *   <li>When {@code Table}.</li>
   *   <li>Then calls {@link JdbcTemplate#execute(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DedicatedEventsSqlPartitioningRepository#createPartitionIfNotExists(String, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DedicatedEventsSqlPartitioningRepository.createPartitionIfNotExists(String, long, long)"})
  public void testCreatePartitionIfNotExists_whenTable_thenCallsExecute() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    dedicatedEventsSqlPartitioningRepository.createPartitionIfNotExists("Table", 1L, 1L);

    // Assert
    verify(jdbcTemplate)
        .execute(eq("CREATE TABLE IF NOT EXISTS Table_1 PARTITION OF Table FOR VALUES FROM (1) TO (2)"));
  }

  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#getJdbcTemplate()}.
   * <p>
   * Method under test: {@link DedicatedEventsSqlPartitioningRepository#getJdbcTemplate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JdbcTemplate DedicatedEventsSqlPartitioningRepository.getJdbcTemplate()"})
  public void testGetJdbcTemplate() {
    // Arrange, Act and Assert
    assertNull((new DedicatedEventsSqlPartitioningRepository()).getJdbcTemplate());
  }
}
