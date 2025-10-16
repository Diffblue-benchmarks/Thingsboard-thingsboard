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
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;

@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
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
    // Arrange
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");

    // Act
    KvEntry actualToKvEntryResult = AbstractCassandraBaseTimeseriesDao.toKvEntry(row, "Key");

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    assertTrue(actualToKvEntryResult instanceof StringDataEntry);
    Optional<String> strValue = actualToKvEntryResult.getStrValue();
    assertEquals("Get", strValue.get());
    assertEquals("Get", actualToKvEntryResult.getValueAsString());
    assertEquals("Get", actualToKvEntryResult.getValue());
    assertEquals("Key", actualToKvEntryResult.getKey());
    assertEquals(DataType.STRING, actualToKvEntryResult.getDataType());
    Optional<Boolean> booleanValue = actualToKvEntryResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, actualToKvEntryResult.getDoubleValue());
    assertSame(booleanValue, actualToKvEntryResult.getJsonValue());
    assertSame(booleanValue, actualToKvEntryResult.getLongValue());
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
    // Arrange
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(null);

    // Act
    KvEntry actualToKvEntryResult = AbstractCassandraBaseTimeseriesDao.toKvEntry(row, "Key");

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    assertNull(actualToKvEntryResult);
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
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    DefaultRow defaultRow = mock(DefaultRow.class);
    when(defaultRow.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");
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
    assertTrue(((BasicTsKvEntry) getResult).getKv() instanceof StringDataEntry);
    assertEquals("Get", getResult.getValueAsString());
    assertEquals("Get", getResult.getValue());
    assertEquals("String", getResult.getKey());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.STRING, getResult.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertEquals(getResult, getResult2);
    assertSame(booleanValue, getResult.getDoubleValue());
    assertSame(booleanValue, getResult.getJsonValue());
    assertSame(booleanValue, getResult.getLongValue());
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
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    DefaultRow defaultRow = mock(DefaultRow.class);
    when(defaultRow.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(null);
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
    assertTrue(((BasicTsKvEntry) getResult2).getKv() instanceof StringDataEntry);
    assertNull(((BasicTsKvEntry) getResult).getKv());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
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
   *   <li>Then return ValueAsString is {@code Get}.
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
  public void testConvertResultToTsKvEntryWithKeyRow_givenGet_thenReturnValueAsStringIsGet() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");
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
    assertEquals("Get", actualConvertResultToTsKvEntryResult.getValueAsString());
    assertEquals("Get", actualConvertResultToTsKvEntryResult.getValue());
    assertEquals("String", actualConvertResultToTsKvEntryResult.getKey());
    assertEquals(1, actualConvertResultToTsKvEntryResult.getDataPoints());
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
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(null);
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
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");
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
    assertTrue(((BasicTsKvEntry) getResult).getKv() instanceof StringDataEntry);
    assertEquals("Get", getResult.getValueAsString());
    assertEquals("Get", getResult.getValue());
    assertEquals("String", getResult.getKey());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.STRING, getResult.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(booleanValue, getResult.getDoubleValue());
    assertSame(booleanValue, getResult.getJsonValue());
    assertSame(booleanValue, getResult.getLongValue());
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
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(null);
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
