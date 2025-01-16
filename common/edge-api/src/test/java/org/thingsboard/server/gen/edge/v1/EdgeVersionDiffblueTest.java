package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EdgeVersionDiffblueTest {
  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code V_3_8_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when eight; then return 'V_3_8_0'")
  void testForNumber_whenEight_thenReturnV380() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_8_0, EdgeVersion.forNumber(8));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code V_3_6_2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'V_3_6_2'")
  void testForNumber_whenFive_thenReturnV362() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_2, EdgeVersion.forNumber(5));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EdgeVersion.forNumber(42));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code V_3_6_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'V_3_6_1'")
  void testForNumber_whenFour_thenReturnV361() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_1, EdgeVersion.forNumber(4));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code V_3_3_3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'V_3_3_3'")
  void testForNumber_whenOne_thenReturnV333() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_3_3, EdgeVersion.forNumber(1));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code V_3_7_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when seven; then return 'V_3_7_0'")
  void testForNumber_whenSeven_thenReturnV370() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_7_0, EdgeVersion.forNumber(7));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code V_3_6_4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when six; then return 'V_3_6_4'")
  void testForNumber_whenSix_thenReturnV364() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_4, EdgeVersion.forNumber(6));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code V_3_6_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'V_3_6_0'")
  void testForNumber_whenThree_thenReturnV360() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_0, EdgeVersion.forNumber(3));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code V_3_4_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'V_3_4_0'")
  void testForNumber_whenTwo_thenReturnV340() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_4_0, EdgeVersion.forNumber(2));
  }

  /**
   * Test {@link EdgeVersion#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code V_3_3_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'V_3_3_0'")
  void testForNumber_whenZero_thenReturnV330() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_3_0, EdgeVersion.forNumber(0));
  }

  /**
   * Test {@link EdgeVersion#getNumber()}.
   * <ul>
   *   <li>Given {@link EdgeVersion#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> EdgeVersion.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link EdgeVersion#getNumber()}.
   * <ul>
   *   <li>Given {@code V_3_3_0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'V_3_3_0'; then return zero")
  void testGetNumber_givenV330_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, EdgeVersion.V_3_3_0.getNumber());
  }

  /**
   * Test {@link EdgeVersion#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link EdgeVersion#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> EdgeVersion.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber eight is {@code V_3_8_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber eight is 'V_3_8_0'")
  void testInternalGetValueMap_thenReturnFindValueByNumberEightIsV380() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_8_0, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is {@code V_3_6_2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'V_3_6_2'")
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsV362() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_2, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code V_3_6_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'V_3_6_1'")
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsV361() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_1, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code V_3_3_3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'V_3_3_3'")
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsV333() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_3_3, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber seven is {@code V_3_7_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber seven is 'V_3_7_0'")
  void testInternalGetValueMap_thenReturnFindValueByNumberSevenIsV370() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_7_0, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber six is {@code V_3_6_4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber six is 'V_3_6_4'")
  void testInternalGetValueMap_thenReturnFindValueByNumberSixIsV364() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_4, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link AlarmUpdateMsg#STARTTS_FIELD_NUMBER}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber STARTTS_FIELD_NUMBER is 'null'")
  void testInternalGetValueMap_thenReturnFindValueByNumberStartts_field_numberIsNull() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code V_3_6_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'V_3_6_0'")
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsV360() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_0, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code V_3_4_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'V_3_4_0'")
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsV340() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_4_0, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link EdgeVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code V_3_3_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'V_3_3_0'")
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsV330() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_3_0, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code V_3_8_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when eight; then return 'V_3_8_0'")
  void testValueOfWithValue_whenEight_thenReturnV380() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_8_0, EdgeVersion.valueOf(8));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code V_3_6_2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'V_3_6_2'")
  void testValueOfWithValue_whenFive_thenReturnV362() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_2, EdgeVersion.valueOf(5));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EdgeVersion.valueOf(42));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code V_3_6_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'V_3_6_1'")
  void testValueOfWithValue_whenFour_thenReturnV361() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_1, EdgeVersion.valueOf(4));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code V_3_3_3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'V_3_3_3'")
  void testValueOfWithValue_whenOne_thenReturnV333() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_3_3, EdgeVersion.valueOf(1));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code V_3_7_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when seven; then return 'V_3_7_0'")
  void testValueOfWithValue_whenSeven_thenReturnV370() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_7_0, EdgeVersion.valueOf(7));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code V_3_6_4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when six; then return 'V_3_6_4'")
  void testValueOfWithValue_whenSix_thenReturnV364() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_4, EdgeVersion.valueOf(6));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code V_3_6_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'V_3_6_0'")
  void testValueOfWithValue_whenThree_thenReturnV360() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_6_0, EdgeVersion.valueOf(3));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code V_3_4_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'V_3_4_0'")
  void testValueOfWithValue_whenTwo_thenReturnV340() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_4_0, EdgeVersion.valueOf(2));
  }

  /**
   * Test {@link EdgeVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code V_3_3_0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'V_3_3_0'")
  void testValueOfWithValue_whenZero_thenReturnV330() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_3_0, EdgeVersion.valueOf(0));
  }
}
