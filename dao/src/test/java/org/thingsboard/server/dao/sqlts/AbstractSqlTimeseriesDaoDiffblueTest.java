package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.sqlts.sql.JpaSqlTimeseriesDao;

public class AbstractSqlTimeseriesDaoDiffblueTest {
  /**
   * Test {@link AbstractSqlTimeseriesDao#computeTtl(long)}.
   * <p>
   * Method under test: {@link AbstractSqlTimeseriesDao#computeTtl(long)}
   */
  @Test
  public void testComputeTtl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1L, (new JpaSqlTimeseriesDao()).computeTtl(1L));
  }

  /**
   * Test {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}.
   * <ul>
   *   <li>Given {@code BOOLEAN}.</li>
   *   <li>Then calls {@link KvEntry#getDataType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}
   */
  @Test
  public void testGetDataPointDays_givenBoolean_thenCallsGetDataType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();
    KvEntry kv = mock(KvEntry.class);
    when(kv.getDataType()).thenReturn(DataType.BOOLEAN);

    // Act
    int actualDataPointDays = jpaSqlTimeseriesDao.getDataPointDays(new BasicTsKvEntry(1L, kv), 1L);

    // Assert
    verify(kv).getDataType();
    assertEquals(1, actualDataPointDays);
  }

  /**
   * Test {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key}
   * and value is {@code 42}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}
   */
  @Test
  public void testGetDataPointDays_whenJsonDataEntryWithKeyAndValueIs42_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    // Act and Assert
    assertEquals(1, jpaSqlTimeseriesDao.getDataPointDays(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), 1L));
  }
}
