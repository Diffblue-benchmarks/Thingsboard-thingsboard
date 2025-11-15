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
package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class TbMsgMetaDataDiffblueTest {
  /**
   * Method under test: {@link TbMsgMetaData#getValue(String)}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertNull(TbMsgMetaData.EMPTY.getValue("Key"));
  }

  /**
   * Method under test: {@link TbMsgMetaData#getValue(String)}
   */
  @Test
  void testGetValue2() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull((new TbMsgMetaData(data)).getValue("Key"));
  }

  /**
   * Method under test: {@link TbMsgMetaData#putValue(String, String)}
   */
  @Test
  void testPutValue() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();

    // Act
    tbMsgMetaData.putValue("Key", "42");

    // Assert
    Map<String, String> data = tbMsgMetaData.getData();
    assertEquals(1, data.size());
    assertEquals("42", data.get("Key"));
  }

  /**
   * Method under test: {@link TbMsgMetaData#putValue(String, String)}
   */
  @Test
  void testPutValue2() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData(data);

    // Act
    tbMsgMetaData.putValue("Key", "42");

    // Assert
    Map<String, String> data2 = tbMsgMetaData.getData();
    assertEquals(1, data2.size());
    assertEquals("42", data2.get("Key"));
  }

  /**
   * Method under test: {@link TbMsgMetaData#values()}
   */
  @Test
  void testValues() {
    // Arrange, Act and Assert
    assertTrue(TbMsgMetaData.EMPTY.values().isEmpty());
  }

  /**
   * Method under test: {@link TbMsgMetaData#values()}
   */
  @Test
  void testValues2() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue((new TbMsgMetaData(data)).values().isEmpty());
  }

  /**
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  void testCopy() {
    // Arrange, Act and Assert
    assertTrue(TbMsgMetaData.EMPTY.copy().getData().isEmpty());
  }

  /**
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  void testCopy2() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    // Act and Assert
    Map<String, String> data = tbMsgMetaData.copy().getData();
    assertEquals(1, data.size());
    assertEquals("42", data.get("Key"));
  }

  /**
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  void testCopy3() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("42", "Value");
    tbMsgMetaData.putValue("Key", "42");

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData.copy());
  }

  /**
   * Method under test: {@link TbMsgMetaData#copy()}
   */
  @Test
  void testCopy4() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData(data);

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData.copy());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#equals(Object)}
   *   <li>{@link TbMsgMetaData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = TbMsgMetaData.EMPTY;
    TbMsgMetaData tbMsgMetaData2 = TbMsgMetaData.EMPTY;

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData2);
    int expectedHashCodeResult = tbMsgMetaData.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgMetaData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#equals(Object)}
   *   <li>{@link TbMsgMetaData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    TbMsgMetaData tbMsgMetaData2 = TbMsgMetaData.EMPTY;

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData2);
    int expectedHashCodeResult = tbMsgMetaData.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgMetaData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#equals(Object)}
   *   <li>{@link TbMsgMetaData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = TbMsgMetaData.EMPTY;

    // Act and Assert
    assertEquals(tbMsgMetaData, tbMsgMetaData);
    int expectedHashCodeResult = tbMsgMetaData.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgMetaData.hashCode());
  }

  /**
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaData.EMPTY, 1);
  }

  /**
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    // Act and Assert
    assertNotEquals(tbMsgMetaData, TbMsgMetaData.EMPTY);
  }

  /**
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaData.EMPTY, null);
  }

  /**
   * Method under test: {@link TbMsgMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaData.EMPTY, "Different type to TbMsgMetaData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaData#TbMsgMetaData()}
   *   <li>{@link TbMsgMetaData#toString()}
   *   <li>{@link TbMsgMetaData#getData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgMetaData actualTbMsgMetaData = new TbMsgMetaData();
    String actualToStringResult = actualTbMsgMetaData.toString();

    // Assert
    assertEquals("TbMsgMetaData(data={})", actualToStringResult);
    assertTrue(actualTbMsgMetaData.getData().isEmpty());
  }

  /**
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  void testNewTbMsgMetaData() {
    // Arrange, Act and Assert
    assertTrue((new TbMsgMetaData(new HashMap<>())).getData().isEmpty());
  }

  /**
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  void testNewTbMsgMetaData2() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("foo", "foo");

    // Act and Assert
    Map<String, String> data2 = (new TbMsgMetaData(data)).getData();
    assertEquals(1, data2.size());
    assertEquals("foo", data2.get("foo"));
  }

  /**
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  void testNewTbMsgMetaData3() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("42", "42");
    data.put("foo", "foo");

    // Act and Assert
    assertEquals(data, (new TbMsgMetaData(data)).getData());
  }

  /**
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  void testNewTbMsgMetaData4() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    data.put("foo", "foo");

    // Act and Assert
    Map<String, String> data2 = (new TbMsgMetaData(data)).getData();
    assertEquals(1, data2.size());
    assertEquals("foo", data2.get("foo"));
  }

  /**
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  void testNewTbMsgMetaData5() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put(null, "foo");

    // Act and Assert
    assertTrue((new TbMsgMetaData(data)).getData().isEmpty());
  }

  /**
   * Method under test: {@link TbMsgMetaData#TbMsgMetaData(Map)}
   */
  @Test
  void testNewTbMsgMetaData6() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.put("foo", null);

    // Act and Assert
    assertTrue((new TbMsgMetaData(data)).getData().isEmpty());
  }
}
