package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;

class TypeCastUtilDiffblueTest {
  /**
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code .42}.</li>
   *   <li>Then return Right doubleValue is {@code 0.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '.42'; then return Right doubleValue is '0.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_when42_thenReturnRightDoubleValueIs042() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code 42.}.</li>
   *   <li>Then return Right doubleValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '42.'; then return Right doubleValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_when42_thenReturnRightDoubleValueIsFortyTwo() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code ..42}.</li>
   *   <li>Then return Right is {@code ..42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '..42'; then return Right is '..42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_when42_thenReturnRightIs42() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Right longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '42'; then return Right longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_when42_thenReturnRightLongValueIsFortyTwo() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue("42");

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(42L, ((Long) actualCastValueResult.getRight()).longValue());
    assertEquals(42L, ((Long) actualCastValueResult.getValue()).longValue());
    assertEquals(DataType.LONG, actualCastValueResult.getKey());
    assertEquals(DataType.LONG, actualCastValueResult.getLeft());
  }

  /**
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code 42E42}.</li>
   *   <li>Then return Right is {@code 42E42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '42E42'; then return Right is '42E42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_when42e42_thenReturnRightIs42e42() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code 42E.}.</li>
   *   <li>Then return Right is {@code 42E.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '42E.'; then return Right is '42E.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_when42e_thenReturnRightIs42e() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code ..}.</li>
   *   <li>Then return Right is {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '..'; then return Right is '..'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenDotDot_thenReturnRightIsDotDot() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return Right is {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when '.'; then return Right is '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenDot_thenReturnRightIsDot() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code E42}.</li>
   *   <li>Then return Right is {@code E42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when 'E42'; then return Right is 'E42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenE42_thenReturnRightIsE42() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code e42}.</li>
   *   <li>Then return Right is {@code e42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when 'e42'; then return Right is 'e42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenE42_thenReturnRightIsE422() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code E}.</li>
   *   <li>Then return Right is {@code E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when 'E'; then return Right is 'E'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenE_thenReturnRightIsE() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@code e}.</li>
   *   <li>Then return Right is {@code e}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when 'e'; then return Right is 'e'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenE_thenReturnRightIsE2() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Right is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when empty string; then return Right is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenEmptyString_thenReturnRightIsEmptyString() {
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
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@link Boolean#FALSE} toString.</li>
   *   <li>Then return not Right.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when FALSE toString; then return not Right")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenFalseToString_thenReturnNotRight() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue(Boolean.FALSE.toString());

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getKey());
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getLeft());
    assertFalse((Boolean) actualCastValueResult.getRight());
    assertFalse((Boolean) actualCastValueResult.getValue());
  }

  /**
   * Test {@link TypeCastUtil#castValue(String)}.
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.</li>
   *   <li>Then return Right.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castValue(String)}
   */
  @Test
  @DisplayName("Test castValue(String); when TRUE toString; then return Right")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castValue(String)"})
  void testCastValue_whenTrueToString_thenReturnRight() {
    // Arrange and Act
    Pair<DataType, Object> actualCastValueResult = TypeCastUtil.castValue(Boolean.TRUE.toString());

    // Assert
    assertTrue(actualCastValueResult instanceof ImmutablePair);
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getKey());
    assertEquals(DataType.BOOLEAN, actualCastValueResult.getLeft());
    assertTrue((Boolean) actualCastValueResult.getRight());
    assertTrue((Boolean) actualCastValueResult.getValue());
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code .42}.</li>
   *   <li>Then return Right doubleValue is {@code 0.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '.42'; then return Right doubleValue is '0.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_when42_thenReturnRightDoubleValueIs042() {
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
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code 42.}.</li>
   *   <li>Then return Right doubleValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '42.'; then return Right doubleValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_when42_thenReturnRightDoubleValueIsFortyTwo() {
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
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Right longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '42'; then return Right longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_when42_thenReturnRightLongValueIsFortyTwo() {
    // Arrange and Act
    Pair<DataType, Number> actualCastToNumberResult = TypeCastUtil.castToNumber("42");

    // Assert
    assertTrue(actualCastToNumberResult instanceof ImmutablePair);
    assertEquals(42L, actualCastToNumberResult.getRight().longValue());
    assertEquals(42L, actualCastToNumberResult.getValue().longValue());
    assertEquals(DataType.LONG, actualCastToNumberResult.getKey());
    assertEquals(DataType.LONG, actualCastToNumberResult.getLeft());
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code ..42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '..42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("..42"));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code 42E.}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '42E.'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_when42e_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("42E."));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return Right longValue is {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '4242'; then return Right longValue is '4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_when4242_thenReturnRightLongValueIs4242() {
    // Arrange and Act
    Pair<DataType, Number> actualCastToNumberResult = TypeCastUtil.castToNumber("4242");

    // Assert
    assertTrue(actualCastToNumberResult instanceof ImmutablePair);
    assertEquals(4242L, actualCastToNumberResult.getRight().longValue());
    assertEquals(4242L, actualCastToNumberResult.getValue().longValue());
    assertEquals(DataType.LONG, actualCastToNumberResult.getKey());
    assertEquals(DataType.LONG, actualCastToNumberResult.getLeft());
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code ..}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '..'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenDotDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber(".."));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when '.'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("."));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code E42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when 'E42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenE42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("E42"));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code e42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when 'e42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenE42_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("e42"));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code E}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when 'E'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenE_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("E"));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code e}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when 'e'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenE_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("e"));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber(""));
  }

  /**
   * Test {@link TypeCastUtil#castToNumber(String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeCastUtil#castToNumber(String)}
   */
  @Test
  @DisplayName("Test castToNumber(String); when 'Value'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pair TypeCastUtil.castToNumber(String)"})
  void testCastToNumber_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TypeCastUtil.castToNumber("Value"));
  }
}
