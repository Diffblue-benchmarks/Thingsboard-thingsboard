package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.sqlts.sql.JpaSqlTimeseriesDao;

public class AbstractSqlTimeseriesDaoDiffblueTest {
  /**
   * Test {@link AbstractSqlTimeseriesDao#computeTtl(long)}.
   * <p>
   * Method under test: {@link AbstractSqlTimeseriesDao#computeTtl(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AbstractSqlTimeseriesDao.computeTtl(long)"})
  public void testComputeTtl() {
    // Arrange, Act and Assert
    assertEquals(1L, (new JpaSqlTimeseriesDao()).computeTtl(1L));
  }

  /**
   * Test {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AbstractSqlTimeseriesDao.getDataPointDays(TsKvEntry, long)"})
  public void testGetDataPointDays_whenJsonDataEntryWithKeyAndValueIs42_thenReturnOne() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    // Act and Assert
    assertEquals(1, jpaSqlTimeseriesDao.getDataPointDays(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L));
  }
}
