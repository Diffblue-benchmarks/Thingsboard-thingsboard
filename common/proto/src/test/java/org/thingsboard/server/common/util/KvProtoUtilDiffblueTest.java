package org.thingsboard.server.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueType;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto.Builder;
import org.thingsboard.server.gen.transport.TransportProtos.TsValueProto;

class KvProtoUtilDiffblueTest {
  /**
   * Test {@link KvProtoUtil#toAttributeKvList(List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toAttributeKvList(List)}
   */
  @Test
  @DisplayName("Test toAttributeKvList(List); given DefaultInstance; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toAttributeKvList(List)"})
  void testToAttributeKvList_givenDefaultInstance_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<TsKvProto> dataList = new ArrayList<>();
    dataList.add(TsKvProto.getDefaultInstance());

    // Act
    List<AttributeKvEntry> actualToAttributeKvListResult = KvProtoUtil.toAttributeKvList(dataList);

    // Assert
    assertEquals(1, actualToAttributeKvListResult.size());
    AttributeKvEntry getResult = actualToAttributeKvListResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof BooleanDataEntry);
    assertEquals("", getResult.getKey());
    assertNull(getResult.getVersion());
    assertEquals(0L, getResult.getLastUpdateTs());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) getResult.getValue());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
  }

  /**
   * Test {@link KvProtoUtil#toAttributeKvList(List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toAttributeKvList(List)}
   */
  @Test
  @DisplayName("Test toAttributeKvList(List); given DefaultInstance; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toAttributeKvList(List)"})
  void testToAttributeKvList_givenDefaultInstance_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<TsKvProto> dataList = new ArrayList<>();
    dataList.add(TsKvProto.getDefaultInstance());
    dataList.add(TsKvProto.getDefaultInstance());

    // Act
    List<AttributeKvEntry> actualToAttributeKvListResult = KvProtoUtil.toAttributeKvList(dataList);

    // Assert
    assertEquals(2, actualToAttributeKvListResult.size());
    AttributeKvEntry getResult = actualToAttributeKvListResult.get(1);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertEquals(actualToAttributeKvListResult.get(0), getResult);
  }

  /**
   * Test {@link KvProtoUtil#toAttributeKvList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toAttributeKvList(List)}
   */
  @Test
  @DisplayName("Test toAttributeKvList(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toAttributeKvList(List)"})
  void testToAttributeKvList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<AttributeKvEntry> actualToAttributeKvListResult =
        KvProtoUtil.toAttributeKvList(new ArrayList<>());

    // Assert
    assertTrue(actualToAttributeKvListResult.isEmpty());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<String> emptyResult = Optional.empty();
    when(attributeKvEntry.getStrValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.STRING);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(
        new BaseAttributeKvEntry(1L, new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L)));
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getStrValue();
    assertEquals(2, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(1);
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, getResult.getAllFields().size());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link AttributeKvEntry#getDoubleValue()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); given AttributeKvEntry getDoubleValue() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_givenAttributeKvEntryGetDoubleValueReturnEmpty() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Double> emptyResult = Optional.empty();
    when(attributeKvEntry.getDoubleValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.DOUBLE);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getDoubleValue();
    verify(attributeKvEntry).getKey();
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    assertEquals(11, getResult.getSerializedSize());
    KeyValueProto kv = getResult.getKv();
    assertEquals(2, kv.getAllFields().size());
    assertEquals(2, kv.getTypeValue());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.DOUBLE_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link AttributeKvEntry#getLongValue()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); given AttributeKvEntry getLongValue() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_givenAttributeKvEntryGetLongValueReturnEmpty() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> emptyResult = Optional.empty();
    when(attributeKvEntry.getLongValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getLongValue();
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(1, kv.getTypeValue());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, kv.getAllFields().size());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return first Kv AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return first Kv AllFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnFirstKvAllFieldsSizeIsOne() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Boolean> emptyResult = Optional.empty();
    when(attributeKvEntry.getBooleanValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getBooleanValue();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(0, kv.getTypeValue());
    assertEquals(1, kv.getAllFields().size());
    assertEquals(5, kv.getSerializedSize());
    assertEquals(9, getResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return first Kv BoolV.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return first Kv BoolV")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnFirstKvBoolV() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Boolean> ofResult = Optional.of(true);
    when(attributeKvEntry.getBooleanValue()).thenReturn(ofResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getBooleanValue();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(0, kv.getTypeValue());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, kv.getAllFields().size());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, kv.getType());
    assertTrue(kv.getBoolV());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return first Kv DoubleV is ten.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return first Kv DoubleV is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnFirstKvDoubleVIsTen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Double> ofResult = Optional.<Double>of(10.0d);
    when(attributeKvEntry.getDoubleValue()).thenReturn(ofResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.DOUBLE);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getDoubleValue();
    verify(attributeKvEntry).getKey();
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(10.0d, kv.getDoubleV());
    assertEquals(2, kv.getTypeValue());
    assertEquals(20, getResult.getSerializedSize());
    assertEquals(KeyValueType.DOUBLE_V, kv.getType());
    assertEquals(Short.SIZE, kv.getSerializedSize());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return first Kv StringV is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return first Kv StringV is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnFirstKvStringVIs42() {
    // Arrange
    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(new BaseAttributeKvEntry(1L, new StringDataEntry("Key", "42")));

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    KeyValueProto kv = actualAttrToTsKvProtosResult.get(0).getKv();
    assertEquals("42", kv.getStringV());
    ByteString stringVBytes = kv.getStringVBytes();
    assertFalse(stringVBytes.isEmpty());
    ByteIterator iteratorResult = stringVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", stringVBytes.toStringUtf8());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return first Kv TypeValue is four.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return first Kv TypeValue is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnFirstKvTypeValueIsFour() {
    // Arrange
    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", null)));

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    assertEquals(11, getResult.getSerializedSize());
    KeyValueProto kv = getResult.getKv();
    assertEquals(2, kv.getAllFields().size());
    assertEquals(4, kv.getTypeValue());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.JSON_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return first Kv TypeValue is three.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return first Kv TypeValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnFirstKvTypeValueIsThree() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<String> emptyResult = Optional.empty();
    when(attributeKvEntry.getStrValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.STRING);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getStrValue();
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    assertEquals(11, getResult.getSerializedSize());
    KeyValueProto kv = getResult.getKv();
    assertEquals(2, kv.getAllFields().size());
    assertEquals(3, kv.getTypeValue());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return first SerializedSize is thirteen.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return first SerializedSize is thirteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnFirstSerializedSizeIsThirteen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(attributeKvEntry.getLongValue()).thenReturn(ofResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getLongValue();
    assertEquals(1, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(1, kv.getTypeValue());
    assertEquals(13, getResult.getSerializedSize());
    assertEquals(1L, kv.getLongV());
    assertEquals(9, kv.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return second is first.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return second is first")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnSecondIsFirst() {
    // Arrange
    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    result.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    assertEquals(2, actualAttrToTsKvProtosResult.size());
    assertEquals(actualAttrToTsKvProtosResult.get(0), actualAttrToTsKvProtosResult.get(1));
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>Then return second SerializedSize is eleven.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); then return second SerializedSize is eleven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_thenReturnSecondSerializedSizeIsEleven() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<String> emptyResult = Optional.empty();
    when(attributeKvEntry.getStrValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.STRING);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    ArrayList<AttributeKvEntry> result = new ArrayList<>();
    result.add(
        new BaseAttributeKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L)));
    result.add(attributeKvEntry);

    // Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(result);

    // Assert
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getStrValue();
    assertEquals(2, actualAttrToTsKvProtosResult.size());
    TsKvProto getResult = actualAttrToTsKvProtosResult.get(1);
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, getResult.getAllFields().size());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(new ArrayList<>());

    // Assert
    assertTrue(actualAttrToTsKvProtosResult.isEmpty());
  }

  /**
   * Test {@link KvProtoUtil#attrToTsKvProtos(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  @DisplayName("Test attrToTsKvProtos(List); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.attrToTsKvProtos(List)"})
  void testAttrToTsKvProtos_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(null);

    // Assert
    assertTrue(actualAttrToTsKvProtosResult.isEmpty());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    KeyValueProto kv = actualToTsKvProtoListResult.get(0).getKv();
    assertEquals("42", kv.getStringV());
    ByteString stringVBytes = kv.getStringVBytes();
    assertFalse(stringVBytes.isEmpty());
    ByteIterator iteratorResult = stringVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", stringVBytes.toStringUtf8());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Given {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoList(List); given DoubleDataEntry(String, Double) with 'Key' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_givenDoubleDataEntryWithKeyAndValueIsNull() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(2L, new DoubleDataEntry("Key", null)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    assertEquals(11, getResult.getSerializedSize());
    KeyValueProto kv = getResult.getKv();
    assertEquals(2, kv.getAllFields().size());
    assertEquals(2, kv.getTypeValue());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.DOUBLE_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoList(List); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_givenJsonDataEntryWithKeyAndValueIs42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    result.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(2, actualToTsKvProtoListResult.size());
    assertEquals(actualToTsKvProtoListResult.get(0), actualToTsKvProtoListResult.get(1));
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Given {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoList(List); given LongDataEntry(String, Long) with 'Key' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_givenLongDataEntryWithKeyAndValueIsNull() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(2L, new LongDataEntry("Key", null)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(1, kv.getTypeValue());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, kv.getAllFields().size());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Then return first Kv AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); then return first Kv AllFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_thenReturnFirstKvAllFieldsSizeIsOne() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(2L, new BooleanDataEntry("Key", null)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(0, kv.getTypeValue());
    assertEquals(1, kv.getAllFields().size());
    assertEquals(5, kv.getSerializedSize());
    assertEquals(9, getResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Then return first Kv BoolV.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); then return first Kv BoolV")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_thenReturnFirstKvBoolV() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(2L, new BooleanDataEntry("Key", true)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(0, kv.getTypeValue());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(2, kv.getAllFields().size());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, kv.getType());
    assertTrue(kv.getBoolV());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Then return first Kv DoubleV is ten.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); then return first Kv DoubleV is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_thenReturnFirstKvDoubleVIsTen() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(2L, new DoubleDataEntry("Key", 10.0d)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(10.0d, kv.getDoubleV());
    assertEquals(2, kv.getTypeValue());
    assertEquals(20, getResult.getSerializedSize());
    assertEquals(KeyValueType.DOUBLE_V, kv.getType());
    assertEquals(Short.SIZE, kv.getSerializedSize());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Then return first Kv StringV is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); then return first Kv StringV is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_thenReturnFirstKvStringVIs42() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(1L, new StringDataEntry("Key", "42")));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    KeyValueProto kv = actualToTsKvProtoListResult.get(0).getKv();
    assertEquals("42", kv.getStringV());
    ByteString stringVBytes = kv.getStringVBytes();
    assertFalse(stringVBytes.isEmpty());
    ByteIterator iteratorResult = stringVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", stringVBytes.toStringUtf8());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Then return first Kv TypeValue is four.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); then return first Kv TypeValue is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_thenReturnFirstKvTypeValueIsFour() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", null)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    assertEquals(11, getResult.getSerializedSize());
    KeyValueProto kv = getResult.getKv();
    assertEquals(2, kv.getAllFields().size());
    assertEquals(4, kv.getTypeValue());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.JSON_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Then return first Kv TypeValue is three.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); then return first Kv TypeValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_thenReturnFirstKvTypeValueIsThree() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(1L, new StringDataEntry("Key", null)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    assertEquals(11, getResult.getSerializedSize());
    KeyValueProto kv = getResult.getKv();
    assertEquals(2, kv.getAllFields().size());
    assertEquals(3, kv.getTypeValue());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Then return first SerializedSize is thirteen.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); then return first SerializedSize is thirteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_thenReturnFirstSerializedSizeIsThirteen() {
    // Arrange
    ArrayList<TsKvEntry> result = new ArrayList<>();
    result.add(new BasicTsKvEntry(2L, new LongDataEntry("Key", 42L)));

    // Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(result);

    // Assert
    assertEquals(1, actualToTsKvProtoListResult.size());
    TsKvProto getResult = actualToTsKvProtoListResult.get(0);
    KeyValueProto kv = getResult.getKv();
    assertEquals(1, kv.getTypeValue());
    assertEquals(13, getResult.getSerializedSize());
    assertEquals(42L, kv.getLongV());
    assertEquals(9, kv.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, kv.getType());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(new ArrayList<>());

    // Assert
    assertTrue(actualToTsKvProtoListResult.isEmpty());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test toTsKvProtoList(List); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.toTsKvProtoList(List)"})
  void testToTsKvProtoList_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(null);

    // Assert
    assertTrue(actualToTsKvProtoListResult.isEmpty());
  }

  /**
   * Test {@link KvProtoUtil#fromTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test fromTsKvProtoList(List); given DefaultInstance; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.fromTsKvProtoList(List)"})
  void testFromTsKvProtoList_givenDefaultInstance_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<TsKvProto> dataList = new ArrayList<>();
    dataList.add(TsKvProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsKvProtoListResult = KvProtoUtil.fromTsKvProtoList(dataList);

    // Assert
    assertEquals(1, actualFromTsKvProtoListResult.size());
    TsKvEntry getResult = actualFromTsKvProtoListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) getResult).getKv() instanceof BooleanDataEntry);
    assertEquals("", getResult.getKey());
    assertNull(getResult.getVersion());
    assertEquals(0L, getResult.getTs());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) getResult.getValue());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
  }

  /**
   * Test {@link KvProtoUtil#fromTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test fromTsKvProtoList(List); given DefaultInstance; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.fromTsKvProtoList(List)"})
  void testFromTsKvProtoList_givenDefaultInstance_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<TsKvProto> dataList = new ArrayList<>();
    dataList.add(TsKvProto.getDefaultInstance());
    dataList.add(TsKvProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsKvProtoListResult = KvProtoUtil.fromTsKvProtoList(dataList);

    // Assert
    assertEquals(2, actualFromTsKvProtoListResult.size());
    TsKvEntry getResult = actualFromTsKvProtoListResult.get(1);
    assertTrue(getResult instanceof BasicTsKvEntry);
    assertEquals(actualFromTsKvProtoListResult.get(0), getResult);
  }

  /**
   * Test {@link KvProtoUtil#fromTsKvProtoList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsKvProtoList(List)}
   */
  @Test
  @DisplayName("Test fromTsKvProtoList(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.fromTsKvProtoList(List)"})
  void testFromTsKvProtoList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvEntry> actualFromTsKvProtoListResult =
        KvProtoUtil.fromTsKvProtoList(new ArrayList<>());

    // Assert
    assertTrue(actualFromTsKvProtoListResult.isEmpty());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new JsonDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry2() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L, new AggTsKvEntry(2L, new AggTsKvEntry(2L, new JsonDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry3() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new BooleanDataEntry("Key", true), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry4() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new StringDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry5() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new DoubleDataEntry("Key", 10.0d), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry6() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new LongDataEntry("Key", 42L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry7() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new BooleanDataEntry("Key", true), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry8() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new StringDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry9() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new DoubleDataEntry("Key", 10.0d), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry10() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L, new AggTsKvEntry(2L, new AggTsKvEntry(2L, new LongDataEntry("Key", 42L), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new JsonDataEntry("Key", "42"), 3L), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion2() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new JsonDataEntry("Key", "42"), 3L), 3L),
            1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion3() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new StringDataEntry("Key", "42"), 3L), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion4() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L, new AggTsKvEntry(2L, new DoubleDataEntry("Key", 10.0d), 3L), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion5() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new AggTsKvEntry(2L, new LongDataEntry("Key", 42L), 3L), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion6() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new StringDataEntry("Key", "42"), 3L), 3L),
            1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion7() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new DoubleDataEntry("Key", 10.0d), 3L), 3L),
            1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion8() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new LongDataEntry("Key", 42L), 3L), 3L),
            1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>Then return Kv AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; then return Kv AllFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_thenReturnKvAllFieldsSizeIsOne() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L, new AggTsKvEntry(2L, new BooleanDataEntry("Key", null), 3L), 1L);

    // Assert
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertEquals(1, kv.getAllFields().size());
    assertEquals(5, kv.getSerializedSize());
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenBooleanDataEntryWithKeyAndValueIsTrue() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L, new AggTsKvEntry(2L, new BooleanDataEntry("Key", true), 3L), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenBooleanDataEntryWithKeyAndValueIsTrue2() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new BooleanDataEntry("Key", true), 3L), 3L),
            1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when DoubleDataEntry(String, Double) with 'Key' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenDoubleDataEntryWithKeyAndValueIsNull() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new DoubleDataEntry("Key", null), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when DoubleDataEntry(String, Double) with 'Key' and value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenDoubleDataEntryWithKeyAndValueIsTen() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new DoubleDataEntry("Key", 10.0d), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when JsonDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new JsonDataEntry("Key", "42"), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when JsonDataEntry(String, String) with 'Key' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenJsonDataEntryWithKeyAndValueIsNull() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new JsonDataEntry("Key", null), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when LongDataEntry(String, Long) with 'Key' and value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenLongDataEntryWithKeyAndValueIsFortyTwo() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new LongDataEntry("Key", 42L), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when LongDataEntry(String, Long) with 'Key' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenLongDataEntryWithKeyAndValueIsNull() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new LongDataEntry("Key", null), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Version is zero.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when 'null'; then return Version is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenNull_thenReturnVersionIsZero() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new BooleanDataEntry("Key", true), null);

    // Assert
    assertEquals(0L, actualToTsKvProtoResult.getVersion());
    assertEquals(2, actualToTsKvProtoResult.getAllFields().size());
    assertFalse(actualToTsKvProtoResult.hasVersion());
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenStringDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new StringDataEntry("Key", "42"), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)} with {@code ts}, {@code kvEntry},
   * {@code version}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry, Long)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry, Long) with 'ts', 'kvEntry', 'version'; when StringDataEntry(String, String) with 'Key' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry, Long)"})
  void testToTsKvProtoWithTsKvEntryVersion_whenStringDataEntryWithKeyAndValueIsNull() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new StringDataEntry("Key", null), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'; when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry_whenBooleanDataEntryWithKeyAndValueIsTrue() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new BooleanDataEntry("Key", true));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'; when DoubleDataEntry(String, Double) with 'Key' and value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry_whenDoubleDataEntryWithKeyAndValueIsTen() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new DoubleDataEntry("Key", 10.0d));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'; when JsonDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult = KvProtoUtil.toTsKvProto(1L, new JsonDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'; when LongDataEntry(String, Long) with 'Key' and value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry_whenLongDataEntryWithKeyAndValueIsFortyTwo() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult = KvProtoUtil.toTsKvProto(1L, new LongDataEntry("Key", 42L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProto(long, KvEntry)} with {@code ts}, {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProto(long, KvEntry) with 'ts', 'kvEntry'; when StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvProto KvProtoUtil.toTsKvProto(long, KvEntry)"})
  void testToTsKvProtoWithTsKvEntry_whenStringDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    TsKvProto actualToTsKvProtoResult =
        KvProtoUtil.toTsKvProto(1L, new StringDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualToTsKvProtoResult.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualToTsKvProtoResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#fromTsKvProto(KeyValueProto)} with {@code KeyValueProto}.
   *
   * <ul>
   *   <li>Then return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsKvProto(KeyValueProto)}
   */
  @Test
  @DisplayName(
      "Test fromTsKvProto(KeyValueProto) with 'KeyValueProto'; then return BooleanDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KvEntry KvProtoUtil.fromTsKvProto(KeyValueProto)"})
  void testFromTsKvProtoWithKeyValueProto_thenReturnBooleanDataEntry() {
    // Arrange and Act
    KvEntry actualFromTsKvProtoResult =
        KvProtoUtil.fromTsKvProto(KeyValueProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromTsKvProtoResult instanceof BooleanDataEntry);
    assertEquals("", actualFromTsKvProtoResult.getKey());
    assertEquals(DataType.BOOLEAN, actualFromTsKvProtoResult.getDataType());
    Optional<Boolean> booleanValue = actualFromTsKvProtoResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = actualFromTsKvProtoResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) actualFromTsKvProtoResult.getValue());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, actualFromTsKvProtoResult.getValueAsString());
    assertSame(doubleValue, actualFromTsKvProtoResult.getJsonValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getLongValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getStrValue());
  }

  /**
   * Test {@link KvProtoUtil#fromTsKvProto(TsKvProto)} with {@code TsKvProto}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@link BasicTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsKvProto(TsKvProto)}
   */
  @Test
  @DisplayName(
      "Test fromTsKvProto(TsKvProto) with 'TsKvProto'; when DefaultInstance; then return BasicTsKvEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry KvProtoUtil.fromTsKvProto(TsKvProto)"})
  void testFromTsKvProtoWithTsKvProto_whenDefaultInstance_thenReturnBasicTsKvEntry() {
    // Arrange and Act
    TsKvEntry actualFromTsKvProtoResult = KvProtoUtil.fromTsKvProto(TsKvProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromTsKvProtoResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualFromTsKvProtoResult).getKv() instanceof BooleanDataEntry);
    assertEquals("", actualFromTsKvProtoResult.getKey());
    assertNull(actualFromTsKvProtoResult.getVersion());
    assertEquals(0L, actualFromTsKvProtoResult.getTs());
    assertEquals(1, actualFromTsKvProtoResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, actualFromTsKvProtoResult.getDataType());
    Optional<Double> doubleValue = actualFromTsKvProtoResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) actualFromTsKvProtoResult.getValue());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, actualFromTsKvProtoResult.getValueAsString());
    assertSame(doubleValue, actualFromTsKvProtoResult.getJsonValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getLongValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getStrValue());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L, new AggTsKvEntry(2L, new JsonDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder2() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L, new AggTsKvEntry(2L, new AggTsKvEntry(2L, new JsonDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder3() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L, new AggTsKvEntry(2L, new BooleanDataEntry("Key", true), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder4() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L, new AggTsKvEntry(2L, new StringDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder5() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L, new AggTsKvEntry(2L, new DoubleDataEntry("Key", 10.0d), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder6() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(1L, new AggTsKvEntry(2L, new LongDataEntry("Key", 42L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder7() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new BooleanDataEntry("Key", true), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder8() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new StringDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder9() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L,
            new AggTsKvEntry(2L, new AggTsKvEntry(2L, new DoubleDataEntry("Key", 10.0d), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsKvProtoBuilder(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder10() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(
            1L, new AggTsKvEntry(2L, new AggTsKvEntry(2L, new LongDataEntry("Key", 42L), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoBuilder(long, KvEntry); when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder_whenBooleanDataEntryWithKeyAndValueIsTrue() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(1L, new BooleanDataEntry("Key", true));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoBuilder(long, KvEntry); when DoubleDataEntry(String, Double) with 'Key' and value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder_whenDoubleDataEntryWithKeyAndValueIsTen() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(1L, new DoubleDataEntry("Key", 10.0d));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoBuilder(long, KvEntry); when JsonDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(1L, new JsonDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoBuilder(long, KvEntry); when LongDataEntry(String, Long) with 'Key' and value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder_whenLongDataEntryWithKeyAndValueIsFortyTwo() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(1L, new LongDataEntry("Key", 42L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsKvProtoBuilder(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsKvProtoBuilder(long, KvEntry); when StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder KvProtoUtil.toTsKvProtoBuilder(long, KvEntry)"})
  void testToTsKvProtoBuilder_whenStringDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    Builder actualToTsKvProtoBuilderResult =
        KvProtoUtil.toTsKvProtoBuilder(1L, new StringDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvProtoBuilderResult.getUnknownFields();
    TsKvProto defaultInstanceForType = actualToTsKvProtoBuilderResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, actualToTsKvProtoBuilderResult.getKv().getUnknownFields());
    KeyValueProto.Builder kvBuilder = actualToTsKvProtoBuilderResult.getKvBuilder();
    assertSame(unknownFields, kvBuilder.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType, defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvBuilder, actualToTsKvProtoBuilderResult.getKvOrBuilder());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(DataType)} with {@code dataType}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code BOOLEAN_V}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(DataType)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(DataType) with 'dataType'; when 'BOOLEAN'; then return 'BOOLEAN_V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueType KvProtoUtil.toKeyValueTypeProto(DataType)"})
  void testToKeyValueTypeProtoWithDataType_whenBoolean_thenReturnBooleanV() {
    // Arrange, Act and Assert
    assertEquals(KeyValueType.BOOLEAN_V, KvProtoUtil.toKeyValueTypeProto(DataType.BOOLEAN));
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(DataType)} with {@code dataType}.
   *
   * <ul>
   *   <li>When {@code DOUBLE}.
   *   <li>Then return {@code DOUBLE_V}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(DataType)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(DataType) with 'dataType'; when 'DOUBLE'; then return 'DOUBLE_V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueType KvProtoUtil.toKeyValueTypeProto(DataType)"})
  void testToKeyValueTypeProtoWithDataType_whenDouble_thenReturnDoubleV() {
    // Arrange, Act and Assert
    assertEquals(KeyValueType.DOUBLE_V, KvProtoUtil.toKeyValueTypeProto(DataType.DOUBLE));
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(DataType)} with {@code dataType}.
   *
   * <ul>
   *   <li>When {@code JSON}.
   *   <li>Then return {@code JSON_V}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(DataType)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(DataType) with 'dataType'; when 'JSON'; then return 'JSON_V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueType KvProtoUtil.toKeyValueTypeProto(DataType)"})
  void testToKeyValueTypeProtoWithDataType_whenJson_thenReturnJsonV() {
    // Arrange, Act and Assert
    assertEquals(KeyValueType.JSON_V, KvProtoUtil.toKeyValueTypeProto(DataType.JSON));
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(DataType)} with {@code dataType}.
   *
   * <ul>
   *   <li>When {@code LONG}.
   *   <li>Then return {@code LONG_V}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(DataType)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(DataType) with 'dataType'; when 'LONG'; then return 'LONG_V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueType KvProtoUtil.toKeyValueTypeProto(DataType)"})
  void testToKeyValueTypeProtoWithDataType_whenLong_thenReturnLongV() {
    // Arrange, Act and Assert
    assertEquals(KeyValueType.LONG_V, KvProtoUtil.toKeyValueTypeProto(DataType.LONG));
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(DataType)} with {@code dataType}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@code STRING_V}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(DataType)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(DataType) with 'dataType'; when 'STRING'; then return 'STRING_V'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueType KvProtoUtil.toKeyValueTypeProto(DataType)"})
  void testToKeyValueTypeProtoWithDataType_whenString_thenReturnStringV() {
    // Arrange, Act and Assert
    assertEquals(KeyValueType.STRING_V, KvProtoUtil.toKeyValueTypeProto(DataType.STRING));
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry2() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry3() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(
            new AggTsKvEntry(1L, new BooleanDataEntry("Key", true), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry4() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry5() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(
            new AggTsKvEntry(1L, new DoubleDataEntry("Key", 10.0d), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry6() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new AggTsKvEntry(1L, new LongDataEntry("Key", 42L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry7() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new BooleanDataEntry("Key", true), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry8() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry9() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new DoubleDataEntry("Key", 10.0d), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName("Test toKeyValueTypeProto(KvEntry) with 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry10() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new LongDataEntry("Key", 42L), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(KvEntry) with 'kvEntry'; when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry_whenBooleanDataEntryWithKeyAndValueIsTrue() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new BooleanDataEntry("Key", true));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(KvEntry) with 'kvEntry'; when DoubleDataEntry(String, Double) with 'Key' and value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry_whenDoubleDataEntryWithKeyAndValueIsTen() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new DoubleDataEntry("Key", 10.0d));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(KvEntry) with 'kvEntry'; when JsonDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new JsonDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(KvEntry) with 'kvEntry'; when LongDataEntry(String, Long) with 'Key' and value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry_whenLongDataEntryWithKeyAndValueIsFortyTwo() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new LongDataEntry("Key", 42L));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)} with {@code kvEntry}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toKeyValueTypeProto(KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueTypeProto(KvEntry) with 'kvEntry'; when StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyValueProto KvProtoUtil.toKeyValueTypeProto(KvEntry)"})
  void testToKeyValueTypeProtoWithKvEntry_whenStringDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    KeyValueProto actualToKeyValueTypeProtoResult =
        KvProtoUtil.toKeyValueTypeProto(new StringDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToKeyValueTypeProtoResult.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualToKeyValueTypeProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#fromTsValueProtoList(String, List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsValueProtoList(String, List)}
   */
  @Test
  @DisplayName(
      "Test fromTsValueProtoList(String, List); given DefaultInstance; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.fromTsValueProtoList(String, List)"})
  void testFromTsValueProtoList_givenDefaultInstance_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<TsValueProto> dataList = new ArrayList<>();
    dataList.add(TsValueProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsValueProtoListResult =
        KvProtoUtil.fromTsValueProtoList("Key", dataList);

    // Assert
    assertEquals(1, actualFromTsValueProtoListResult.size());
    TsKvEntry getResult = actualFromTsValueProtoListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) getResult).getKv() instanceof BooleanDataEntry);
    assertEquals("Key", getResult.getKey());
    assertNull(getResult.getVersion());
    assertEquals(0L, getResult.getTs());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) getResult.getValue());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
  }

  /**
   * Test {@link KvProtoUtil#fromTsValueProtoList(String, List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsValueProtoList(String, List)}
   */
  @Test
  @DisplayName(
      "Test fromTsValueProtoList(String, List); given DefaultInstance; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.fromTsValueProtoList(String, List)"})
  void testFromTsValueProtoList_givenDefaultInstance_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<TsValueProto> dataList = new ArrayList<>();
    dataList.add(TsValueProto.getDefaultInstance());
    dataList.add(TsValueProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsValueProtoListResult =
        KvProtoUtil.fromTsValueProtoList("Key", dataList);

    // Assert
    assertEquals(2, actualFromTsValueProtoListResult.size());
    TsKvEntry getResult = actualFromTsValueProtoListResult.get(1);
    assertTrue(getResult instanceof BasicTsKvEntry);
    assertEquals(actualFromTsValueProtoListResult.get(0), getResult);
  }

  /**
   * Test {@link KvProtoUtil#fromTsValueProtoList(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsValueProtoList(String, List)}
   */
  @Test
  @DisplayName("Test fromTsValueProtoList(String, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List KvProtoUtil.fromTsValueProtoList(String, List)"})
  void testFromTsValueProtoList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvEntry> actualFromTsValueProtoListResult =
        KvProtoUtil.fromTsValueProtoList("Key", new ArrayList<>());

    // Assert
    assertTrue(actualFromTsValueProtoListResult.isEmpty());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto2() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(
            1L, new AggTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto3() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new AggTsKvEntry(1L, new BooleanDataEntry("Key", true), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto4() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto5() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new AggTsKvEntry(1L, new DoubleDataEntry("Key", 10.0d), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto6() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new AggTsKvEntry(1L, new LongDataEntry("Key", 42L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto7() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(
            1L,
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new BooleanDataEntry("Key", true), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto8() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(
            1L,
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto9() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(
            1L,
            new AggTsKvEntry(1L, new AggTsKvEntry(1L, new DoubleDataEntry("Key", 10.0d), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName("Test toTsValueProto(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto10() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(
            1L, new AggTsKvEntry(1L, new AggTsKvEntry(1L, new LongDataEntry("Key", 42L), 3L), 3L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsValueProto(long, KvEntry); when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto_whenBooleanDataEntryWithKeyAndValueIsTrue() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new BooleanDataEntry("Key", true));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value
   *       is ten.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsValueProto(long, KvEntry); when DoubleDataEntry(String, Double) with 'Key' and value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto_whenDoubleDataEntryWithKeyAndValueIsTen() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new DoubleDataEntry("Key", 10.0d));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsValueProto(long, KvEntry); when JsonDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new JsonDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsValueProto(long, KvEntry); when LongDataEntry(String, Long) with 'Key' and value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto_whenLongDataEntryWithKeyAndValueIsFortyTwo() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new LongDataEntry("Key", 42L));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#toTsValueProto(long, KvEntry)}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value
   *       is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#toTsValueProto(long, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test toTsValueProto(long, KvEntry); when StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.TsValueProto KvProtoUtil.toTsValueProto(long, KvEntry)"})
  void testToTsValueProto_whenStringDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    TsValueProto actualToTsValueProtoResult =
        KvProtoUtil.toTsValueProto(1L, new StringDataEntry("Key", "42"));

    // Assert
    UnknownFieldSet unknownFields = actualToTsValueProtoResult.getUnknownFields();
    TsValueProto defaultInstanceForType = actualToTsValueProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link KvProtoUtil#fromTsValueProto(String, TsValueProto)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromTsValueProto(String,
   * TransportProtos.TsValueProto)}
   */
  @Test
  @DisplayName(
      "Test fromTsValueProto(String, TsValueProto); when DefaultInstance; then return BooleanDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KvEntry KvProtoUtil.fromTsValueProto(String, TransportProtos.TsValueProto)"})
  void testFromTsValueProto_whenDefaultInstance_thenReturnBooleanDataEntry() {
    // Arrange and Act
    KvEntry actualFromTsValueProtoResult =
        KvProtoUtil.fromTsValueProto("Key", TsValueProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromTsValueProtoResult instanceof BooleanDataEntry);
    assertEquals("Key", actualFromTsValueProtoResult.getKey());
    assertEquals(DataType.BOOLEAN, actualFromTsValueProtoResult.getDataType());
    Optional<Boolean> booleanValue = actualFromTsValueProtoResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = actualFromTsValueProtoResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) actualFromTsValueProtoResult.getValue());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, actualFromTsValueProtoResult.getValueAsString());
    assertSame(doubleValue, actualFromTsValueProtoResult.getJsonValue());
    assertSame(doubleValue, actualFromTsValueProtoResult.getLongValue());
    assertSame(doubleValue, actualFromTsValueProtoResult.getStrValue());
  }

  /**
   * Test {@link KvProtoUtil#fromKeyValueTypeProto(KeyValueType)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN_V}.
   *   <li>Then return {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link KvProtoUtil#fromKeyValueTypeProto(KeyValueType)}
   */
  @Test
  @DisplayName("Test fromKeyValueTypeProto(KeyValueType); when 'BOOLEAN_V'; then return 'BOOLEAN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType KvProtoUtil.fromKeyValueTypeProto(KeyValueType)"})
  void testFromKeyValueTypeProto_whenBooleanV_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(DataType.BOOLEAN, KvProtoUtil.fromKeyValueTypeProto(KeyValueType.BOOLEAN_V));
  }
}
