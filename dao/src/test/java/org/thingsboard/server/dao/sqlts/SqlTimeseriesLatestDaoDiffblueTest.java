package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;

public class SqlTimeseriesLatestDaoDiffblueTest {
  /**
   * Test {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}.
   * <ul>
   *   <li>Then return {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts
   * is one and kv is {@link AggTsKvEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}
   */
  @Test
  public void testWrapNullTsKvEntry_thenReturnBasicTsKvEntryWithTsIsOneAndKvIsAggTsKvEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlTimeseriesLatestDao = new SqlTimeseriesLatestDao();
    BasicTsKvEntry latest = new BasicTsKvEntry(1L, mock(AggTsKvEntry.class));

    // Act and Assert
    assertSame(latest, sqlTimeseriesLatestDao.wrapNullTsKvEntry("Key", latest));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}.
   * <ul>
   *   <li>Then return {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts
   * is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}
   */
  @Test
  public void testWrapNullTsKvEntry_thenReturnBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlTimeseriesLatestDao = new SqlTimeseriesLatestDao();
    BasicTsKvEntry latest = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertSame(latest, sqlTimeseriesLatestDao.wrapNullTsKvEntry("Key", latest));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link BasicTsKvEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}
   */
  @Test
  public void testWrapNullTsKvEntry_whenNull_thenReturnBasicTsKvEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TsKvEntry actualWrapNullTsKvEntryResult = (new SqlTimeseriesLatestDao()).wrapNullTsKvEntry("Key", null);

    // Assert
    assertTrue(actualWrapNullTsKvEntryResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualWrapNullTsKvEntryResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    assertNull(kv.getValue());
    assertNull(kv.getValueAsString());
    assertEquals(DataType.STRING, kv.getDataType());
    assertEquals(DataType.STRING, actualWrapNullTsKvEntryResult.getDataType());
  }
}
