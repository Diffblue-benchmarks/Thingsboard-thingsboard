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
package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;

class TypeCastUtilDiffblueTest {
  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("42");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(DataType.LONG, actualCastValueResult.getKey());
    assertEquals(DataType.LONG, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue2() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue(Boolean.TRUE.toString());

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getKey());
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue3() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue(Boolean.FALSE.toString());

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getKey());
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue4() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue(".");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(".", actualCastValueResult.getRight());
    assertEquals(".", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue5() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("E");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("E", actualCastValueResult.getRight());
    assertEquals("E", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue6() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("", actualCastValueResult.getRight());
    assertEquals("", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue7() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("e");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("e", actualCastValueResult.getRight());
    assertEquals("e", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue8() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("42.");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(42.0d, ((Double) actualCastValueResult.getRight()).doubleValue());
    assertEquals(42.0d, ((Double) actualCastValueResult.getValue()).doubleValue());
    assertEquals(DataType.DOUBLE, actualCastValueResult.getKey());
    assertEquals(DataType.DOUBLE, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue9() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue(".42");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(0.42d, ((Double) actualCastValueResult.getRight()).doubleValue());
    assertEquals(0.42d, ((Double) actualCastValueResult.getValue()).doubleValue());
    assertEquals(DataType.DOUBLE, actualCastValueResult.getKey());
    assertEquals(DataType.DOUBLE, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue10() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("..");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("..", actualCastValueResult.getRight());
    assertEquals("..", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue11() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("E42");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("E42", actualCastValueResult.getRight());
    assertEquals("E42", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue12() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("e42");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("e42", actualCastValueResult.getRight());
    assertEquals("e42", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue13() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("42E42");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("42E42", actualCastValueResult.getRight());
    assertEquals("42E42", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue14() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("42E.");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("42E.", actualCastValueResult.getRight());
    assertEquals("42E.", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  void testCastValue15() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("..42");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals("..42", actualCastValueResult.getRight());
    assertEquals("..42", actualCastValueResult.getValue());
    assertEquals(DataType.STRING, actualCastValueResult.getKey());
    assertEquals(DataType.STRING, actualCastValueResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber() {
    // Arrange and Act
    Pair<DataType, Number> actualCastToNumberResult = TypeCastUtil.castToNumber("42");

    // Assert
    assertTrue(actualCastToNumberResult instanceof ImmutablePair);
    assertEquals(DataType.LONG, actualCastToNumberResult.getKey());
    assertEquals(DataType.LONG, actualCastToNumberResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("."));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("Value"));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("E"));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber(""));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("e"));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber7() {
    // Arrange and Act
    Pair<DataType, Number> actualCastToNumberResult = TypeCastUtil.castToNumber("4242");

    // Assert
    assertTrue(actualCastToNumberResult instanceof ImmutablePair);
    assertEquals(DataType.LONG, actualCastToNumberResult.getKey());
    assertEquals(DataType.LONG, actualCastToNumberResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber8() {
    // Arrange and Act
    Pair<DataType, Number> actualCastToNumberResult = TypeCastUtil.castToNumber("42.");

    // Assert
    assertTrue(actualCastToNumberResult instanceof ImmutablePair);
    assertEquals(42.0d, actualCastToNumberResult.getRight().doubleValue());
    assertEquals(42.0d, actualCastToNumberResult.getValue().doubleValue());
    assertEquals(DataType.DOUBLE, actualCastToNumberResult.getKey());
    assertEquals(DataType.DOUBLE, actualCastToNumberResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber9() {
    // Arrange and Act
    Pair<DataType, Number> actualCastToNumberResult = TypeCastUtil.castToNumber(".42");

    // Assert
    assertTrue(actualCastToNumberResult instanceof ImmutablePair);
    assertEquals(0.42d, actualCastToNumberResult.getRight().doubleValue());
    assertEquals(0.42d, actualCastToNumberResult.getValue().doubleValue());
    assertEquals(DataType.DOUBLE, actualCastToNumberResult.getKey());
    assertEquals(DataType.DOUBLE, actualCastToNumberResult.getLeft());
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber10() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber(".."));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber11() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("E42"));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber12() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("e42"));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber13() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("42E."));
  }

  /**
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  void testCastToNumber14() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("..42"));
  }
}
