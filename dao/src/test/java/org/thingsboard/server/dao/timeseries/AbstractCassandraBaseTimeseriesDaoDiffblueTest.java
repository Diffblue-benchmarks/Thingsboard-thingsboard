package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.oss.driver.api.core.cql.ColumnDefinitions;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.data.GettableByName;
import com.datastax.oss.driver.internal.core.cql.DefaultColumnDefinition;
import com.datastax.oss.driver.internal.core.cql.DefaultRow;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.query.TsValue;
import org.thingsboard.server.dao.cassandra.CassandraCluster;
import org.thingsboard.server.dao.nosql.CassandraBufferedRateReadExecutor;
import org.thingsboard.server.dao.nosql.CassandraBufferedRateWriteExecutor;

@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class AbstractCassandraBaseTimeseriesDaoDiffblueTest {
  @MockBean
  private CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor;

  @MockBean
  private CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor;

  @MockBean(name = "CassandraCluster")
  private CassandraCluster cassandraCluster;

  /**
   * Test {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}.
   * <ul>
   *   <li>Given {@code Get}.</li>
   *   <li>When {@link DefaultRow} {@link GettableByName#get(String, Class)} return
   * {@code Get}.</li>
   *   <li>Then return {@link StringDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DefaultRow} {@link GettableByName#get(String, Class)} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#toKvEntry(Row, String)}
   */
  @Test
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
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   * <ul>
   *   <li>Given {@link Row} {@link GettableByName#get(String, Class)} return
   * {@code Get}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  public void testConvertResultToTsKvEntryList_givenRowGetReturnGet_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    List<TsKvEntry> actualConvertResultToTsKvEntryListResult = cassandraBaseTimeseriesDao
        .convertResultToTsKvEntryList(rows);

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(defaultRow).get(eq("str_v"), isA(Class.class));
    verify(row).getLong(eq("ts"));
    verify(defaultRow).getLong(eq("ts"));
    verify(row).getString(eq("key"));
    verify(defaultRow).getString(eq("key"));
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
    TsValue toTsValueResult = getResult.toTsValue();
    assertEquals("Get", toTsValueResult.getValue());
    assertEquals("Get", getResult.getValue());
    assertEquals("Get", kv.getValue());
    assertEquals("String", getResult.getKey());
    assertEquals("String", kv.getKey());
    assertNull(getResult.getVersion());
    assertNull(toTsValueResult.getCount());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(1L, getResult.getTs());
    assertEquals(1L, toTsValueResult.getTs());
    assertEquals(DataType.STRING, getResult.getDataType());
    assertEquals(DataType.STRING, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv.getStrValue());
    assertEquals(getResult, getResult2);
    assertSame(booleanValue, kv.getBooleanValue());
    assertSame(booleanValue, getResult.getDoubleValue());
    assertSame(booleanValue, kv.getDoubleValue());
    assertSame(booleanValue, getResult.getJsonValue());
    assertSame(booleanValue, kv.getJsonValue());
    assertSame(booleanValue, getResult.getLongValue());
    assertSame(booleanValue, kv.getLongValue());
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryList(List)}
   */
  @Test
  public void testConvertResultToTsKvEntryList_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    // Act and Assert
    assertTrue(cassandraBaseTimeseriesDao.convertResultToTsKvEntryList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   * with {@code key}, {@code row}.
   * <ul>
   *   <li>Given {@code Get}.</li>
   *   <li>Then return StrValue is {@code Get}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryWithKeyRow_givenGet_thenReturnStrValueIsGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    new IllegalArgumentException("foo");
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    TsKvEntry actualConvertResultToTsKvEntryResult = cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key", row);

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong(eq("ts"));
    verify(row).getString(eq("key"));
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = actualConvertResultToTsKvEntryResult.getStrValue();
    assertEquals("Get", strValue.get());
    assertEquals("Get", kv.getValueAsString());
    assertEquals("Get", actualConvertResultToTsKvEntryResult.getValueAsString());
    TsValue toTsValueResult = actualConvertResultToTsKvEntryResult.toTsValue();
    assertEquals("Get", toTsValueResult.getValue());
    assertEquals("Get", kv.getValue());
    assertEquals("Get", actualConvertResultToTsKvEntryResult.getValue());
    assertEquals("String", kv.getKey());
    assertEquals("String", actualConvertResultToTsKvEntryResult.getKey());
    assertEquals(1, actualConvertResultToTsKvEntryResult.getDataPoints());
    assertEquals(1L, toTsValueResult.getTs());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv.getStrValue());
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   * with {@code key}, {@code row}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Version is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryWithKeyRow_givenNull_thenReturnVersionIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    new IllegalArgumentException("foo");
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(null);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    TsKvEntry actualConvertResultToTsKvEntryResult = cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong(eq("ts"));
    verify(row).getString(eq("key"));
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    assertNull(actualConvertResultToTsKvEntryResult.getVersion());
    assertNull(((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv());
    assertEquals(1L, actualConvertResultToTsKvEntryResult.getTs());
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   * with {@code key}, {@code row}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryWithKeyRow_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    DefaultColumnDefinition defaultColumnDefinition = mock(DefaultColumnDefinition.class);
    when(defaultColumnDefinition.getType()).thenThrow(new IllegalArgumentException("foo"));
    ColumnDefinitions definitions = mock(ColumnDefinitions.class);
    when(definitions.get(anyInt())).thenReturn(defaultColumnDefinition);
    when(definitions.firstIndexOf(Mockito.<String>any())).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> cassandraBaseTimeseriesDao.convertResultToTsKvEntry("Key",
        new DefaultRow(definitions, new ArrayList<>())));
    verify(definitions, atLeast(1)).firstIndexOf(Mockito.<String>any());
    verify(definitions, atLeast(1)).get(eq(1));
    verify(defaultColumnDefinition, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   * with {@code key}, {@code row}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Kv Key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntry(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryWithKeyRow_whenNull_thenReturnKvKeyIsKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TsKvEntry actualConvertResultToTsKvEntryResult = (new CassandraBaseTimeseriesDao()).convertResultToTsKvEntry("Key",
        null);

    // Assert
    assertTrue(actualConvertResultToTsKvEntryResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualConvertResultToTsKvEntryResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    assertEquals("Key", kv.getKey());
    assertEquals("Key", actualConvertResultToTsKvEntryResult.getKey());
    assertNull(kv.getValue());
    assertNull(actualConvertResultToTsKvEntryResult.getValue());
    assertNull(kv.getValueAsString());
    assertNull(actualConvertResultToTsKvEntryResult.getValueAsString());
    assertNull(actualConvertResultToTsKvEntryResult.toTsValue().getValue());
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   * <ul>
   *   <li>Given {@code Get}.</li>
   *   <li>Then {@link Optional#get()} Kv return {@link StringDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryOpt_givenGet_thenGetKvReturnStringDataEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    new IllegalArgumentException("foo");
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn("Get");
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    Optional<TsKvEntry> actualConvertResultToTsKvEntryOptResult = cassandraBaseTimeseriesDao
        .convertResultToTsKvEntryOpt("Key", row);

    // Assert
    verify(row).get(eq("str_v"), isA(Class.class));
    verify(row).getLong(eq("ts"));
    verify(row).getString(eq("key"));
    TsKvEntry getResult = actualConvertResultToTsKvEntryOptResult.get();
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = getResult.getStrValue();
    assertEquals("Get", strValue.get());
    assertEquals("Get", getResult.getValueAsString());
    assertEquals("Get", kv.getValueAsString());
    TsValue toTsValueResult = getResult.toTsValue();
    assertEquals("Get", toTsValueResult.getValue());
    assertEquals("Get", getResult.getValue());
    assertEquals("Get", kv.getValue());
    assertEquals("String", getResult.getKey());
    assertEquals("String", kv.getKey());
    assertNull(toTsValueResult.getCount());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(1L, toTsValueResult.getTs());
    assertEquals(DataType.STRING, getResult.getDataType());
    assertEquals(DataType.STRING, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, kv.getBooleanValue());
    assertSame(booleanValue, getResult.getDoubleValue());
    assertSame(booleanValue, kv.getDoubleValue());
    assertSame(booleanValue, getResult.getJsonValue());
    assertSame(booleanValue, kv.getJsonValue());
    assertSame(booleanValue, getResult.getLongValue());
    assertSame(booleanValue, kv.getLongValue());
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@link Optional#get()} Version is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryOpt_givenNull_thenReturnGetVersionIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    new IllegalArgumentException("foo");
    DefaultRow row = mock(DefaultRow.class);
    when(row.get(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(null);
    when(row.getString(Mockito.<String>any())).thenReturn("String");
    when(row.getLong(Mockito.<String>any())).thenReturn(1L);

    // Act
    Optional<TsKvEntry> actualConvertResultToTsKvEntryOptResult = cassandraBaseTimeseriesDao
        .convertResultToTsKvEntryOpt("Key", row);

    // Assert
    verify(row, atLeast(1)).get(Mockito.<String>any(), Mockito.<Class<Object>>any());
    verify(row).getLong(eq("ts"));
    verify(row).getString(eq("key"));
    TsKvEntry getResult = actualConvertResultToTsKvEntryOptResult.get();
    assertTrue(getResult instanceof BasicTsKvEntry);
    assertNull(getResult.getVersion());
    assertNull(((BasicTsKvEntry) getResult).getKv());
    assertEquals(1L, getResult.getTs());
    assertTrue(actualConvertResultToTsKvEntryOptResult.isPresent());
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryOpt_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    DefaultColumnDefinition defaultColumnDefinition = mock(DefaultColumnDefinition.class);
    when(defaultColumnDefinition.getType()).thenThrow(new IllegalArgumentException("foo"));
    ColumnDefinitions definitions = mock(ColumnDefinitions.class);
    when(definitions.get(anyInt())).thenReturn(defaultColumnDefinition);
    when(definitions.firstIndexOf(Mockito.<String>any())).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> cassandraBaseTimeseriesDao.convertResultToTsKvEntryOpt("Key",
        new DefaultRow(definitions, new ArrayList<>())));
    verify(definitions, atLeast(1)).firstIndexOf(Mockito.<String>any());
    verify(definitions, atLeast(1)).get(eq(1));
    verify(defaultColumnDefinition, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCassandraBaseTimeseriesDao#convertResultToTsKvEntryOpt(String, Row)}
   */
  @Test
  public void testConvertResultToTsKvEntryOpt_whenNull_thenReturnNotPresent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CassandraBaseTimeseriesDao()).convertResultToTsKvEntryOpt("Key", null).isPresent());
  }
}
