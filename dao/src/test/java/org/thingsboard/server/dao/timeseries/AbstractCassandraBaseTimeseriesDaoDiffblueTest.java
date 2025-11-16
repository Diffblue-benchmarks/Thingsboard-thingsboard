/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.internal.core.cql.DefaultRow;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;

public class AbstractCassandraBaseTimeseriesDaoDiffblueTest {
  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@link DefaultRow} {@link DefaultRow#get(String, Class)} return {@code Get}.
   *   <li>Then return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"KvEntry AbstractCassandraBaseTimeseriesDao.toKvEntry(Row, String)"})
  public void testToKvEntry_givenGet_whenDefaultRowGetReturnGet_thenReturnStringDataEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    // Act
    KvEntry actualToKvEntryResult = AbstractCassandraBaseTimeseriesDao.toKvEntry(row, "Key");

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    assertTrue(actualToKvEntryResult instanceof StringDataEntry);
    Optional<String> strValue = actualToKvEntryResult.getStrValue();
    assertEquals("Get", strValue.get());
    assertEquals("Get", actualToKvEntryResult.getValueAsString());
    assertEquals("Get", actualToKvEntryResult.getValue());
    assertEquals(DataType.STRING, actualToKvEntryResult.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link DefaultRow} {@link DefaultRow#get(String, Class)} return {@code null}.
   *   <li>Then return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"KvEntry AbstractCassandraBaseTimeseriesDao.toKvEntry(Row, String)"})
  public void testToKvEntry_givenNull_whenDefaultRowGetReturnNull_thenReturnBooleanDataEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    // Act
    KvEntry actualToKvEntryResult = AbstractCassandraBaseTimeseriesDao.toKvEntry(row, "Key");

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    assertTrue(actualToKvEntryResult instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, actualToKvEntryResult.getDataType());
    Optional<Double> doubleValue = actualToKvEntryResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = actualToKvEntryResult.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    assertTrue((Boolean) actualToKvEntryResult.getValue());
    assertEquals(Boolean.TRUE.toString(), actualToKvEntryResult.getValueAsString());
    assertSame(doubleValue, actualToKvEntryResult.getJsonValue());
    assertSame(doubleValue, actualToKvEntryResult.getLongValue());
    assertSame(doubleValue, actualToKvEntryResult.getStrValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link DefaultRow} {@link DefaultRow#get(String, Class)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"KvEntry AbstractCassandraBaseTimeseriesDao.toKvEntry(Row, String)"})
  public void testToKvEntry_givenNull_whenDefaultRowGetReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(null);

    // Act
    KvEntry actualToKvEntryResult = AbstractCassandraBaseTimeseriesDao.toKvEntry(row, "Key");

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    assertNull(actualToKvEntryResult);
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link DefaultRow} {@link DefaultRow#get(String, Class)} return one.
   *   <li>Then return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"KvEntry AbstractCassandraBaseTimeseriesDao.toKvEntry(Row, String)"})
  public void testToKvEntry_givenOne_whenDefaultRowGetReturnOne_thenReturnLongDataEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    // Act
    KvEntry actualToKvEntryResult = AbstractCassandraBaseTimeseriesDao.toKvEntry(row, "Key");

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    assertTrue(actualToKvEntryResult instanceof LongDataEntry);
    assertEquals("1", actualToKvEntryResult.getValueAsString());
    Optional<Long> longValue = actualToKvEntryResult.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(1L, ((Long) actualToKvEntryResult.getValue()).longValue());
    assertEquals(DataType.LONG, actualToKvEntryResult.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link DefaultRow} {@link DefaultRow#get(String, Class)} return ten.
   *   <li>Then return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"KvEntry AbstractCassandraBaseTimeseriesDao.toKvEntry(Row, String)"})
  public void testToKvEntry_givenTen_whenDefaultRowGetReturnTen_thenReturnDoubleDataEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    // Act
    KvEntry actualToKvEntryResult = AbstractCassandraBaseTimeseriesDao.toKvEntry(row, "Key");

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    assertTrue(actualToKvEntryResult instanceof DoubleDataEntry);
    assertEquals("10.0", actualToKvEntryResult.getValueAsString());
    Optional<Double> doubleValue = actualToKvEntryResult.getDoubleValue();
    assertEquals(10.0d, doubleValue.get().doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) actualToKvEntryResult.getValue()).doubleValue(), 0.0);
    assertEquals(DataType.DOUBLE, actualToKvEntryResult.getDataType());
    assertTrue(doubleValue.isPresent());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   *
   * <ul>
   *   <li>Then first Kv return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryList(List)"})
  public void testConvertResultToTsKvEntryList_thenFirstKvReturnBooleanDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    Row row = mock(Row.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    DefaultRow defaultRow = mock(DefaultRow.class);
    when(defaultRow.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(defaultRow.getString(Mockito.<String>any())).thenReturn("String");
    when(defaultRow.getLong(Mockito.<String>any())).thenReturn(1L);

    ArrayList<Row> rows = new ArrayList<>();
    rows.add(defaultRow);
    rows.add(row);

    // Act
    List<TsKvEntry> actualConvertResultToTsKvEntryListResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryList(rows);

    // Assert
    verify(defaultRow, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong("ts");
    verify(defaultRow).getLong("ts");
    verify(row).getString("key");
    verify(defaultRow).getString("key");
    assertEquals(2, actualConvertResultToTsKvEntryListResult.size());
    TsKvEntry getResult = actualConvertResultToTsKvEntryListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    TsKvEntry getResult2 = actualConvertResultToTsKvEntryListResult.get(1);
    assertTrue(getResult2 instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) getResult).getKv() instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue((Boolean) getResult.getValue());
    assertEquals(Boolean.TRUE.toString(), getResult.getValueAsString());
    assertSame(doubleValue, getResult2.getBooleanValue());
    assertSame(doubleValue, getResult2.getDoubleValue());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   *
   * <ul>
   *   <li>Then first Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryList(List)"})
  public void testConvertResultToTsKvEntryList_thenFirstKvReturnDoubleDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    Row row = mock(Row.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    DefaultRow defaultRow = mock(DefaultRow.class);
    when(defaultRow.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(defaultRow.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(defaultRow.getString(Mockito.<String>any())).thenReturn("String");
    when(defaultRow.getLong(Mockito.<String>any())).thenReturn(1L);

    ArrayList<Row> rows = new ArrayList<>();
    rows.add(defaultRow);
    rows.add(row);

    // Act
    List<TsKvEntry> actualConvertResultToTsKvEntryListResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryList(rows);

    // Assert
    verify(defaultRow, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong("ts");
    verify(defaultRow).getLong("ts");
    verify(row).getString("key");
    verify(defaultRow).getString("key");
    assertEquals(2, actualConvertResultToTsKvEntryListResult.size());
    TsKvEntry getResult = actualConvertResultToTsKvEntryListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof DoubleDataEntry);
    assertEquals("10.0", getResult.getValueAsString());
    assertEquals("10.0", kv.getValueAsString());
    assertEquals("10.0", getResult.toTsValue().getValue());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertEquals(10.0d, doubleValue.get().doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) getResult.getValue()).doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) kv.getValue()).doubleValue(), 0.0);
    assertEquals(DataType.DOUBLE, getResult.getDataType());
    assertEquals(DataType.DOUBLE, kv.getDataType());
    assertTrue(doubleValue.isPresent());
    assertEquals(doubleValue, kv.getDoubleValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   *
   * <ul>
   *   <li>Then first Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryList(List)"})
  public void testConvertResultToTsKvEntryList_thenFirstKvReturnLongDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    Row row = mock(Row.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    DefaultRow defaultRow = mock(DefaultRow.class);
    when(defaultRow.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(defaultRow.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(defaultRow.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(defaultRow.getString(Mockito.<String>any())).thenReturn("String");
    when(defaultRow.getLong(Mockito.<String>any())).thenReturn(1L);

    ArrayList<Row> rows = new ArrayList<>();
    rows.add(defaultRow);
    rows.add(row);

    // Act
    List<TsKvEntry> actualConvertResultToTsKvEntryListResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryList(rows);

    // Assert
    verify(defaultRow, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong("ts");
    verify(defaultRow).getLong("ts");
    verify(row).getString("key");
    verify(defaultRow).getString("key");
    assertEquals(2, actualConvertResultToTsKvEntryListResult.size());
    TsKvEntry getResult = actualConvertResultToTsKvEntryListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof LongDataEntry);
    assertEquals("1", getResult.getValueAsString());
    assertEquals("1", kv.getValueAsString());
    assertEquals("1", getResult.toTsValue().getValue());
    Optional<Long> longValue = getResult.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(1L, ((Long) getResult.getValue()).longValue());
    assertEquals(1L, ((Long) kv.getValue()).longValue());
    assertEquals(DataType.LONG, getResult.getDataType());
    assertEquals(DataType.LONG, kv.getDataType());
    assertTrue(longValue.isPresent());
    assertEquals(longValue, kv.getLongValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   *
   * <ul>
   *   <li>Then first Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryList(List)"})
  public void testConvertResultToTsKvEntryList_thenFirstKvReturnStringDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    Row row = mock(Row.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    DefaultRow defaultRow = mock(DefaultRow.class);
    when(defaultRow.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(defaultRow.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(defaultRow.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(defaultRow.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(defaultRow.getString(Mockito.<String>any())).thenReturn("String");
    when(defaultRow.getLong(Mockito.<String>any())).thenReturn(1L);

    ArrayList<Row> rows = new ArrayList<>();
    rows.add(defaultRow);
    rows.add(row);

    // Act
    List<TsKvEntry> actualConvertResultToTsKvEntryListResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryList(rows);

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(defaultRow).get(eq("str_v"), isA(Class.class));
    verify(row).getLong("ts");
    verify(defaultRow).getLong("ts");
    verify(row).getString("key");
    verify(defaultRow).getString("key");
    assertEquals(2, actualConvertResultToTsKvEntryListResult.size());
    TsKvEntry getResult = actualConvertResultToTsKvEntryListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    TsKvEntry getResult2 = actualConvertResultToTsKvEntryListResult.get(1);
    assertTrue(getResult2 instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = getResult.getStrValue();
    assertEquals("Get", strValue.get());
    assertEquals("Get", getResult.getValueAsString());
    assertEquals("Get", kv.getValueAsString());
    assertEquals("Get", getResult.toTsValue().getValue());
    assertEquals("Get", getResult.getValue());
    assertEquals("Get", kv.getValue());
    assertEquals(DataType.STRING, getResult.getDataType());
    assertEquals(DataType.STRING, kv.getDataType());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv.getStrValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   *
   * <ul>
   *   <li>Then second Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryList(List)"})
  public void testConvertResultToTsKvEntryList_thenSecondKvReturnStringDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    Row row = mock(Row.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    DefaultRow defaultRow = mock(DefaultRow.class);
    when(defaultRow.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(defaultRow.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(null);
    when(defaultRow.getString(Mockito.<String>any())).thenReturn("String");
    when(defaultRow.getLong(Mockito.<String>any())).thenReturn(1L);

    ArrayList<Row> rows = new ArrayList<>();
    rows.add(defaultRow);
    rows.add(row);

    // Act
    List<TsKvEntry> actualConvertResultToTsKvEntryListResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryList(rows);

    // Assert
    verify(defaultRow, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong("ts");
    verify(defaultRow).getLong("ts");
    verify(row).getString("key");
    verify(defaultRow).getString("key");
    assertEquals(2, actualConvertResultToTsKvEntryListResult.size());
    TsKvEntry getResult = actualConvertResultToTsKvEntryListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    TsKvEntry getResult2 = actualConvertResultToTsKvEntryListResult.get(1);
    assertTrue(getResult2 instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult2).getKv();
    assertTrue(kv instanceof StringDataEntry);
    assertNull(((BasicTsKvEntry) getResult).getKv());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(booleanValue, kv.getBooleanValue());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, kv.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, kv.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
    assertSame(booleanValue, kv.getLongValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryList(List)"})
  public void testConvertResultToTsKvEntryList_whenArrayList_thenReturnEmpty() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    // Act and Assert
    assertTrue(
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)} with
   * {@code key}, {@code row}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>Then Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntry AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntry(String, Row)"
  })
  public void testConvertResultToTsKvEntryWithKeyRow_givenGet_thenKvReturnStringDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    TsKvEntry actualConvertResultToTsKvEntryResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key", row);

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong("ts");
    verify(row).getString("key");
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = actualConvertResultToTsKvEntryResult.getStrValue();
    assertEquals("Get", strValue.get());
    assertEquals("Get", kv.getValueAsString());
    assertEquals("Get", actualConvertResultToTsKvEntryResult.getValueAsString());
    assertEquals("Get", actualConvertResultToTsKvEntryResult.toTsValue().getValue());
    assertEquals("Get", kv.getValue());
    assertEquals("Get", actualConvertResultToTsKvEntryResult.getValue());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv.getStrValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)} with
   * {@code key}, {@code row}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then Kv return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntry AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntry(String, Row)"
  })
  public void testConvertResultToTsKvEntryWithKeyRow_givenNull_thenKvReturnBooleanDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    TsKvEntry actualConvertResultToTsKvEntryResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    assertTrue(
        ((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv()
            instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, actualConvertResultToTsKvEntryResult.getDataType());
    Optional<Double> doubleValue = actualConvertResultToTsKvEntryResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue((Boolean) actualConvertResultToTsKvEntryResult.getValue());
    assertEquals(Boolean.TRUE.toString(), actualConvertResultToTsKvEntryResult.getValueAsString());
    assertSame(doubleValue, actualConvertResultToTsKvEntryResult.getJsonValue());
    assertSame(doubleValue, actualConvertResultToTsKvEntryResult.getLongValue());
    assertSame(doubleValue, actualConvertResultToTsKvEntryResult.getStrValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)} with
   * {@code key}, {@code row}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntry AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntry(String, Row)"
  })
  public void testConvertResultToTsKvEntryWithKeyRow_givenNull_thenReturnVersionIsNull() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(null);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    TsKvEntry actualConvertResultToTsKvEntryResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    assertNull(actualConvertResultToTsKvEntryResult.getVersion());
    assertNull(((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv());
    assertEquals(1L, actualConvertResultToTsKvEntryResult.getTs());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)} with
   * {@code key}, {@code row}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntry AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntry(String, Row)"
  })
  public void testConvertResultToTsKvEntryWithKeyRow_givenTen_thenKvReturnDoubleDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    TsKvEntry actualConvertResultToTsKvEntryResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv();
    assertTrue(kv instanceof DoubleDataEntry);
    assertEquals("10.0", kv.getValueAsString());
    assertEquals("10.0", actualConvertResultToTsKvEntryResult.getValueAsString());
    assertEquals("10.0", actualConvertResultToTsKvEntryResult.toTsValue().getValue());
    Optional<Double> doubleValue = actualConvertResultToTsKvEntryResult.getDoubleValue();
    assertEquals(10.0d, doubleValue.get().doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) kv.getValue()).doubleValue(), 0.0);
    assertEquals(
        10.0d, ((Double) actualConvertResultToTsKvEntryResult.getValue()).doubleValue(), 0.0);
    assertEquals(DataType.DOUBLE, kv.getDataType());
    assertEquals(DataType.DOUBLE, actualConvertResultToTsKvEntryResult.getDataType());
    assertTrue(doubleValue.isPresent());
    assertEquals(doubleValue, kv.getDoubleValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)} with
   * {@code key}, {@code row}.
   *
   * <ul>
   *   <li>Then Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntry AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntry(String, Row)"
  })
  public void testConvertResultToTsKvEntryWithKeyRow_thenKvReturnLongDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    TsKvEntry actualConvertResultToTsKvEntryResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv();
    assertTrue(kv instanceof LongDataEntry);
    assertEquals("1", kv.getValueAsString());
    assertEquals("1", actualConvertResultToTsKvEntryResult.getValueAsString());
    assertEquals("1", actualConvertResultToTsKvEntryResult.toTsValue().getValue());
    Optional<Long> longValue = actualConvertResultToTsKvEntryResult.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(1L, ((Long) kv.getValue()).longValue());
    assertEquals(1L, ((Long) actualConvertResultToTsKvEntryResult.getValue()).longValue());
    assertEquals(DataType.LONG, kv.getDataType());
    assertEquals(DataType.LONG, actualConvertResultToTsKvEntryResult.getDataType());
    assertTrue(longValue.isPresent());
    assertEquals(longValue, kv.getLongValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)} with
   * {@code key}, {@code row}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntry AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntry(String, Row)"
  })
  public void testConvertResultToTsKvEntryWithKeyRow_whenNull_thenReturnKey() {
    // Arrange and Act
    TsKvEntry actualConvertResultToTsKvEntryResult =
        new CassandraBaseTimeseriesDao().convertResultToTsKvEntry("Key", null);

    // Assert
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    assertEquals("Key", actualConvertResultToTsKvEntryResult.getKey());
    assertNull(actualConvertResultToTsKvEntryResult.getValue());
    assertNull(actualConvertResultToTsKvEntryResult.getValueAsString());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>Then {@link Optional#get()} Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt(String, Row)"
  })
  public void testConvertResultToTsKvEntryOpt_givenGet_thenGetKvReturnStringDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn("Get");
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    Optional<TsKvEntry> actualConvertResultToTsKvEntryOptResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt("Key", row);

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong("ts");
    verify(row).getString("key");
    TsKvEntry getResult = actualConvertResultToTsKvEntryOptResult.get();
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = getResult.getStrValue();
    assertEquals("Get", strValue.get());
    assertEquals("Get", getResult.getValueAsString());
    assertEquals("Get", kv.getValueAsString());
    assertEquals("Get", getResult.toTsValue().getValue());
    assertEquals("Get", getResult.getValue());
    assertEquals("Get", kv.getValue());
    assertEquals(DataType.STRING, getResult.getDataType());
    assertEquals(DataType.STRING, kv.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link Optional#get()} Kv return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt(String, Row)"
  })
  public void testConvertResultToTsKvEntryOpt_givenNull_thenGetKvReturnBooleanDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    Optional<TsKvEntry> actualConvertResultToTsKvEntryOptResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    TsKvEntry getResult = actualConvertResultToTsKvEntryOptResult.get();
    assertTrue(getResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) getResult).getKv() instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue((Boolean) getResult.getValue());
    assertEquals(Boolean.TRUE.toString(), getResult.getValueAsString());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@link Optional#get()} Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt(String, Row)"
  })
  public void testConvertResultToTsKvEntryOpt_givenNull_thenReturnGetVersionIsNull() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(null);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    Optional<TsKvEntry> actualConvertResultToTsKvEntryOptResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    TsKvEntry getResult = actualConvertResultToTsKvEntryOptResult.get();
    assertTrue(getResult instanceof BasicTsKvEntry);
    assertNull(getResult.getVersion());
    assertNull(((BasicTsKvEntry) getResult).getKv());
    assertEquals(1L, getResult.getTs());
    assertTrue(actualConvertResultToTsKvEntryOptResult.isPresent());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link Optional#get()} Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt(String, Row)"
  })
  public void testConvertResultToTsKvEntryOpt_givenTen_thenGetKvReturnDoubleDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    Optional<TsKvEntry> actualConvertResultToTsKvEntryOptResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    TsKvEntry getResult = actualConvertResultToTsKvEntryOptResult.get();
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof DoubleDataEntry);
    assertEquals("10.0", getResult.getValueAsString());
    assertEquals("10.0", kv.getValueAsString());
    assertEquals("10.0", getResult.toTsValue().getValue());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertEquals(10.0d, doubleValue.get().doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) getResult.getValue()).doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) kv.getValue()).doubleValue(), 0.0);
    assertEquals(DataType.DOUBLE, getResult.getDataType());
    assertEquals(DataType.DOUBLE, kv.getDataType());
    assertTrue(doubleValue.isPresent());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt(String, Row)"
  })
  public void testConvertResultToTsKvEntryOpt_thenGetKvReturnLongDataEntry() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), eq(String.class))).thenReturn(null);
    when(row.get(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);
    when(row.get(Mockito.<String>any(), eq(Double.class))).thenReturn(10.0d);
    when(row.get(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    Optional<TsKvEntry> actualConvertResultToTsKvEntryOptResult =
        cassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong("ts");
    verify(row).getString("key");
    TsKvEntry getResult = actualConvertResultToTsKvEntryOptResult.get();
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof LongDataEntry);
    assertEquals("1", getResult.getValueAsString());
    assertEquals("1", kv.getValueAsString());
    assertEquals("1", getResult.toTsValue().getValue());
    Optional<Long> longValue = getResult.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(1L, ((Long) getResult.getValue()).longValue());
    assertEquals(1L, ((Long) kv.getValue()).longValue());
    assertEquals(DataType.LONG, getResult.getDataType());
    assertEquals(DataType.LONG, kv.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional AbstractCassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt(String, Row)"
  })
  public void testConvertResultToTsKvEntryOpt_whenNull_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(
        new CassandraBaseTimeseriesDao().convertResultToTsKvEntryOpt("Key", null).isPresent());
  }
}
