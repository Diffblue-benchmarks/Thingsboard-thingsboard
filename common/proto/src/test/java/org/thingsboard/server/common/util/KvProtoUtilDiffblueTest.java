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
package org.thingsboard.server.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.query.TsValue;
import org.thingsboard.server.gen.transport.TransportProtos;

class KvProtoUtilDiffblueTest {
  /**
   * Method under test: {@link KvProtoUtil#toAttributeKvList(List)}
   */
  @Test
  void testToAttributeKvList() {
    // Arrange and Act
    List<AttributeKvEntry> actualToAttributeKvListResult = KvProtoUtil.toAttributeKvList(new ArrayList<>());

    // Assert
    assertTrue(actualToAttributeKvListResult.isEmpty());
  }

  /**
   * Method under test: {@link KvProtoUtil#toAttributeKvList(List)}
   */
  @Test
  void testToAttributeKvList2() {
    // Arrange
    ArrayList<TransportProtos.TsKvProto> dataList = new ArrayList<>();
    dataList.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    List<AttributeKvEntry> actualToAttributeKvListResult = KvProtoUtil.toAttributeKvList(dataList);

    // Assert
    assertEquals(1, actualToAttributeKvListResult.size());
    AttributeKvEntry getResult = actualToAttributeKvListResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("", getResult.getKey());
    assertEquals("", kv.getKey());
    assertNull(getResult.getVersion());
    assertEquals(0L, getResult.getLastUpdateTs());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    String expectedValueAsString2 = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString2, kv.getValueAsString());
    assertEquals(booleanValue, kv.getBooleanValue());
    assertSame(doubleValue, kv.getDoubleValue());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, kv.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, kv.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
    assertSame(doubleValue, kv.getStrValue());
  }

  /**
   * Method under test: {@link KvProtoUtil#toAttributeKvList(List)}
   */
  @Test
  void testToAttributeKvList3() {
    // Arrange
    ArrayList<TransportProtos.TsKvProto> dataList = new ArrayList<>();
    dataList.add(TransportProtos.TsKvProto.getDefaultInstance());
    dataList.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    List<AttributeKvEntry> actualToAttributeKvListResult = KvProtoUtil.toAttributeKvList(dataList);

    // Assert
    assertEquals(2, actualToAttributeKvListResult.size());
    AttributeKvEntry getResult = actualToAttributeKvListResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    AttributeKvEntry getResult2 = actualToAttributeKvListResult.get(1);
    assertTrue(getResult2 instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("", getResult.getKey());
    assertEquals("", kv.getKey());
    assertNull(getResult.getVersion());
    assertEquals(0L, getResult.getLastUpdateTs());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    String expectedValueAsString2 = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString2, kv.getValueAsString());
    assertEquals(booleanValue, kv.getBooleanValue());
    assertEquals(getResult, getResult2);
    assertSame(doubleValue, kv.getDoubleValue());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, kv.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, kv.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
    assertSame(doubleValue, kv.getStrValue());
  }

  /**
   * Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  void testAttrToTsKvProtos() {
    // Arrange and Act
    List<TransportProtos.TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(new ArrayList<>());

    // Assert
    assertTrue(actualAttrToTsKvProtosResult.isEmpty());
  }

  /**
   * Method under test: {@link KvProtoUtil#attrToTsKvProtos(List)}
   */
  @Test
  void testAttrToTsKvProtos2() {
    // Arrange and Act
    List<TransportProtos.TsKvProto> actualAttrToTsKvProtosResult = KvProtoUtil.attrToTsKvProtos(null);

    // Assert
    assertTrue(actualAttrToTsKvProtosResult.isEmpty());
  }

  /**
   * Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  void testToTsKvProtoList() {
    // Arrange and Act
    List<TransportProtos.TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(new ArrayList<>());

    // Assert
    assertTrue(actualToTsKvProtoListResult.isEmpty());
  }

  /**
   * Method under test: {@link KvProtoUtil#toTsKvProtoList(List)}
   */
  @Test
  void testToTsKvProtoList2() {
    // Arrange and Act
    List<TransportProtos.TsKvProto> actualToTsKvProtoListResult = KvProtoUtil.toTsKvProtoList(null);

    // Assert
    assertTrue(actualToTsKvProtoListResult.isEmpty());
  }

  /**
   * Method under test: {@link KvProtoUtil#fromTsKvProtoList(List)}
   */
  @Test
  void testFromTsKvProtoList() {
    // Arrange and Act
    List<TsKvEntry> actualFromTsKvProtoListResult = KvProtoUtil.fromTsKvProtoList(new ArrayList<>());

    // Assert
    assertTrue(actualFromTsKvProtoListResult.isEmpty());
  }

  /**
   * Method under test: {@link KvProtoUtil#fromTsKvProtoList(List)}
   */
  @Test
  void testFromTsKvProtoList2() {
    // Arrange
    ArrayList<TransportProtos.TsKvProto> dataList = new ArrayList<>();
    dataList.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsKvProtoListResult = KvProtoUtil.fromTsKvProtoList(dataList);

    // Assert
    assertEquals(1, actualFromTsKvProtoListResult.size());
    TsKvEntry getResult = actualFromTsKvProtoListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("", getResult.getKey());
    assertEquals("", kv.getKey());
    assertNull(getResult.getVersion());
    TsValue toTsValueResult = getResult.toTsValue();
    assertNull(toTsValueResult.getCount());
    assertEquals(0L, getResult.getTs());
    assertEquals(0L, toTsValueResult.getTs());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    String expectedValueAsString2 = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString2, kv.getValueAsString());
    String expectedValue = Boolean.FALSE.toString();
    assertEquals(expectedValue, toTsValueResult.getValue());
    assertEquals(booleanValue, kv.getBooleanValue());
    assertSame(doubleValue, kv.getDoubleValue());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, kv.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, kv.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
    assertSame(doubleValue, kv.getStrValue());
  }

  /**
   * Method under test: {@link KvProtoUtil#fromTsKvProtoList(List)}
   */
  @Test
  void testFromTsKvProtoList3() {
    // Arrange
    ArrayList<TransportProtos.TsKvProto> dataList = new ArrayList<>();
    dataList.add(TransportProtos.TsKvProto.getDefaultInstance());
    dataList.add(TransportProtos.TsKvProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsKvProtoListResult = KvProtoUtil.fromTsKvProtoList(dataList);

    // Assert
    assertEquals(2, actualFromTsKvProtoListResult.size());
    TsKvEntry getResult = actualFromTsKvProtoListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    TsKvEntry getResult2 = actualFromTsKvProtoListResult.get(1);
    assertTrue(getResult2 instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("", getResult.getKey());
    assertEquals("", kv.getKey());
    assertNull(getResult.getVersion());
    TsValue toTsValueResult = getResult.toTsValue();
    assertNull(toTsValueResult.getCount());
    assertEquals(0L, getResult.getTs());
    assertEquals(0L, toTsValueResult.getTs());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    String expectedValueAsString2 = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString2, kv.getValueAsString());
    String expectedValue = Boolean.FALSE.toString();
    assertEquals(expectedValue, toTsValueResult.getValue());
    assertEquals(booleanValue, kv.getBooleanValue());
    assertEquals(getResult, getResult2);
    assertSame(doubleValue, kv.getDoubleValue());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, kv.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, kv.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
    assertSame(doubleValue, kv.getStrValue());
  }

  /**
   * Method under test:
   * {@link KvProtoUtil#fromTsKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  void testFromTsKvProto() {
    // Arrange and Act
    KvEntry actualFromTsKvProtoResult = KvProtoUtil.fromTsKvProto(TransportProtos.KeyValueProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromTsKvProtoResult instanceof BooleanDataEntry);
    assertEquals("", actualFromTsKvProtoResult.getKey());
    assertEquals(DataType.BOOLEAN, actualFromTsKvProtoResult.getDataType());
    Optional<Boolean> booleanValue = actualFromTsKvProtoResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = actualFromTsKvProtoResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, actualFromTsKvProtoResult.getValueAsString());
    assertSame(doubleValue, actualFromTsKvProtoResult.getJsonValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getLongValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getStrValue());
  }

  /**
   * Method under test:
   * {@link KvProtoUtil#fromTsKvProto(TransportProtos.TsKvProto)}
   */
  @Test
  void testFromTsKvProto2() {
    // Arrange and Act
    TsKvEntry actualFromTsKvProtoResult = KvProtoUtil.fromTsKvProto(TransportProtos.TsKvProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromTsKvProtoResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualFromTsKvProtoResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("", kv.getKey());
    assertEquals("", actualFromTsKvProtoResult.getKey());
    assertNull(actualFromTsKvProtoResult.getVersion());
    TsValue toTsValueResult = actualFromTsKvProtoResult.toTsValue();
    assertNull(toTsValueResult.getCount());
    assertEquals(0L, actualFromTsKvProtoResult.getTs());
    assertEquals(0L, toTsValueResult.getTs());
    assertEquals(1, actualFromTsKvProtoResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    assertEquals(DataType.BOOLEAN, actualFromTsKvProtoResult.getDataType());
    Optional<Boolean> booleanValue = actualFromTsKvProtoResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = actualFromTsKvProtoResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, kv.getValueAsString());
    String expectedValueAsString2 = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString2, actualFromTsKvProtoResult.getValueAsString());
    String expectedValue = Boolean.FALSE.toString();
    assertEquals(expectedValue, toTsValueResult.getValue());
    assertEquals(booleanValue, kv.getBooleanValue());
    assertSame(doubleValue, kv.getDoubleValue());
    assertSame(doubleValue, kv.getJsonValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getJsonValue());
    assertSame(doubleValue, kv.getLongValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getLongValue());
    assertSame(doubleValue, kv.getStrValue());
    assertSame(doubleValue, actualFromTsKvProtoResult.getStrValue());
  }

  /**
   * Method under test: {@link KvProtoUtil#toKeyValueTypeProto(DataType)}
   */
  @Test
  void testToKeyValueTypeProto() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, KvProtoUtil.toKeyValueTypeProto(DataType.BOOLEAN));
    assertEquals(TransportProtos.KeyValueType.LONG_V, KvProtoUtil.toKeyValueTypeProto(DataType.LONG));
    assertEquals(TransportProtos.KeyValueType.DOUBLE_V, KvProtoUtil.toKeyValueTypeProto(DataType.DOUBLE));
    assertEquals(TransportProtos.KeyValueType.STRING_V, KvProtoUtil.toKeyValueTypeProto(DataType.STRING));
    assertEquals(TransportProtos.KeyValueType.JSON_V, KvProtoUtil.toKeyValueTypeProto(DataType.JSON));
  }

  /**
   * Method under test: {@link KvProtoUtil#fromTsValueProtoList(String, List)}
   */
  @Test
  void testFromTsValueProtoList() {
    // Arrange and Act
    List<TsKvEntry> actualFromTsValueProtoListResult = KvProtoUtil.fromTsValueProtoList("Key", new ArrayList<>());

    // Assert
    assertTrue(actualFromTsValueProtoListResult.isEmpty());
  }

  /**
   * Method under test: {@link KvProtoUtil#fromTsValueProtoList(String, List)}
   */
  @Test
  void testFromTsValueProtoList2() {
    // Arrange
    ArrayList<TransportProtos.TsValueProto> dataList = new ArrayList<>();
    dataList.add(TransportProtos.TsValueProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsValueProtoListResult = KvProtoUtil.fromTsValueProtoList("Key", dataList);

    // Assert
    assertEquals(1, actualFromTsValueProtoListResult.size());
    TsKvEntry getResult = actualFromTsValueProtoListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("Key", getResult.getKey());
    assertEquals("Key", kv.getKey());
    assertNull(getResult.getVersion());
    TsValue toTsValueResult = getResult.toTsValue();
    assertNull(toTsValueResult.getCount());
    assertEquals(0L, getResult.getTs());
    assertEquals(0L, toTsValueResult.getTs());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    String expectedValueAsString2 = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString2, kv.getValueAsString());
    String expectedValue = Boolean.FALSE.toString();
    assertEquals(expectedValue, toTsValueResult.getValue());
    assertEquals(booleanValue, kv.getBooleanValue());
    assertSame(doubleValue, kv.getDoubleValue());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, kv.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, kv.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
    assertSame(doubleValue, kv.getStrValue());
  }

  /**
   * Method under test: {@link KvProtoUtil#fromTsValueProtoList(String, List)}
   */
  @Test
  void testFromTsValueProtoList3() {
    // Arrange
    ArrayList<TransportProtos.TsValueProto> dataList = new ArrayList<>();
    dataList.add(TransportProtos.TsValueProto.getDefaultInstance());
    dataList.add(TransportProtos.TsValueProto.getDefaultInstance());

    // Act
    List<TsKvEntry> actualFromTsValueProtoListResult = KvProtoUtil.fromTsValueProtoList("Key", dataList);

    // Assert
    assertEquals(2, actualFromTsValueProtoListResult.size());
    TsKvEntry getResult = actualFromTsValueProtoListResult.get(0);
    assertTrue(getResult instanceof BasicTsKvEntry);
    TsKvEntry getResult2 = actualFromTsValueProtoListResult.get(1);
    assertTrue(getResult2 instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) getResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("Key", getResult.getKey());
    assertEquals("Key", kv.getKey());
    assertNull(getResult.getVersion());
    TsValue toTsValueResult = getResult.toTsValue();
    assertNull(toTsValueResult.getCount());
    assertEquals(0L, getResult.getTs());
    assertEquals(0L, toTsValueResult.getTs());
    assertEquals(1, getResult.getDataPoints());
    assertEquals(DataType.BOOLEAN, getResult.getDataType());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    Optional<Boolean> booleanValue = getResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, getResult.getValueAsString());
    String expectedValueAsString2 = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString2, kv.getValueAsString());
    String expectedValue = Boolean.FALSE.toString();
    assertEquals(expectedValue, toTsValueResult.getValue());
    assertEquals(booleanValue, kv.getBooleanValue());
    assertEquals(getResult, getResult2);
    assertSame(doubleValue, kv.getDoubleValue());
    assertSame(doubleValue, getResult.getJsonValue());
    assertSame(doubleValue, kv.getJsonValue());
    assertSame(doubleValue, getResult.getLongValue());
    assertSame(doubleValue, kv.getLongValue());
    assertSame(doubleValue, getResult.getStrValue());
    assertSame(doubleValue, kv.getStrValue());
  }

  /**
   * Method under test:
   * {@link KvProtoUtil#fromTsValueProto(String, TransportProtos.TsValueProto)}
   */
  @Test
  void testFromTsValueProto() {
    // Arrange and Act
    KvEntry actualFromTsValueProtoResult = KvProtoUtil.fromTsValueProto("Key",
        TransportProtos.TsValueProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromTsValueProtoResult instanceof BooleanDataEntry);
    assertEquals("Key", actualFromTsValueProtoResult.getKey());
    assertEquals(DataType.BOOLEAN, actualFromTsValueProtoResult.getDataType());
    Optional<Boolean> booleanValue = actualFromTsValueProtoResult.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = actualFromTsValueProtoResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, actualFromTsValueProtoResult.getValueAsString());
    assertSame(doubleValue, actualFromTsValueProtoResult.getJsonValue());
    assertSame(doubleValue, actualFromTsValueProtoResult.getLongValue());
    assertSame(doubleValue, actualFromTsValueProtoResult.getStrValue());
  }

  /**
   * Method under test:
   * {@link KvProtoUtil#fromKeyValueTypeProto(TransportProtos.KeyValueType)}
   */
  @Test
  void testFromKeyValueTypeProto() {
    // Arrange, Act and Assert
    assertEquals(DataType.BOOLEAN, KvProtoUtil.fromKeyValueTypeProto(TransportProtos.KeyValueType.BOOLEAN_V));
  }
}
