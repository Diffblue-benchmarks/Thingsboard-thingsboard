package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CassandraBaseTimeseriesDaoDiffblueTest {
  @InjectMocks
  private CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraBaseTimeseriesDao#cleanup(long)}
   *   <li>{@link CassandraBaseTimeseriesDao#getPartitioning()}
   *   <li>{@link CassandraBaseTimeseriesDao#isUseTsKeyValuePartitioningOnRead()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CassandraBaseTimeseriesDao.cleanup(long)",
      "String CassandraBaseTimeseriesDao.getPartitioning()",
      "boolean CassandraBaseTimeseriesDao.isUseTsKeyValuePartitioningOnRead()"})
  public void testGettersAndSetters() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    // Act
    cassandraBaseTimeseriesDao.cleanup(1L);
    String actualPartitioning = cassandraBaseTimeseriesDao.getPartitioning();

    // Assert
    assertNull(actualPartitioning);
    assertFalse(cassandraBaseTimeseriesDao.isUseTsKeyValuePartitioningOnRead());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CassandraBaseTimeseriesDao.calculatePartitions(long, long)"})
  public void testCalculatePartitions_whenMax_value_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Long> actualCalculatePartitionsResult = cassandraBaseTimeseriesDao.calculatePartitions(Long.MAX_VALUE, 1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CassandraBaseTimeseriesDao.calculatePartitions(long, long)"})
  public void testCalculatePartitions_whenOne_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Long> actualCalculatePartitionsResult = cassandraBaseTimeseriesDao.calculatePartitions(1L, 1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }
}
