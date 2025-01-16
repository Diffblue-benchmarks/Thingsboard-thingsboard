package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EdgeEntityTypeDiffblueTest {
  /**
   * Test {@link EdgeEntityType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EdgeEntityType.forNumber(42));
  }

  /**
   * Test {@link EdgeEntityType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'ASSET'")
  void testForNumber_whenOne_thenReturnAsset() {
    // Arrange, Act and Assert
    assertEquals(EdgeEntityType.ASSET, EdgeEntityType.forNumber(1));
  }

  /**
   * Test {@link EdgeEntityType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'DEVICE'")
  void testForNumber_whenZero_thenReturnDevice() {
    // Arrange, Act and Assert
    assertEquals(EdgeEntityType.DEVICE, EdgeEntityType.forNumber(0));
  }

  /**
   * Test {@link EdgeEntityType#getNumber()}.
   * <ul>
   *   <li>Given {@code DEVICE}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'DEVICE'; then return zero")
  void testGetNumber_givenDevice_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, EdgeEntityType.DEVICE.getNumber());
  }

  /**
   * Test {@link EdgeEntityType#getNumber()}.
   * <ul>
   *   <li>Given {@link EdgeEntityType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> EdgeEntityType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link EdgeEntityType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link EdgeEntityType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> EdgeEntityType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link EdgeEntityType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'ASSET'")
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsAsset() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeEntityType> actualInternalGetValueMapResult = EdgeEntityType.internalGetValueMap();

    // Assert
    assertEquals(EdgeEntityType.ASSET, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link EdgeEntityType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link AlarmUpdateMsg#STARTTS_FIELD_NUMBER}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber STARTTS_FIELD_NUMBER is 'null'")
  void testInternalGetValueMap_thenReturnFindValueByNumberStartts_field_numberIsNull() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeEntityType> actualInternalGetValueMapResult = EdgeEntityType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Test {@link EdgeEntityType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'DEVICE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsDevice() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeEntityType> actualInternalGetValueMapResult = EdgeEntityType.internalGetValueMap();

    // Assert
    assertEquals(EdgeEntityType.DEVICE, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link EdgeEntityType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EdgeEntityType.valueOf(42));
  }

  /**
   * Test {@link EdgeEntityType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'ASSET'")
  void testValueOfWithValue_whenOne_thenReturnAsset() {
    // Arrange, Act and Assert
    assertEquals(EdgeEntityType.ASSET, EdgeEntityType.valueOf(1));
  }

  /**
   * Test {@link EdgeEntityType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEntityType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'DEVICE'")
  void testValueOfWithValue_whenZero_thenReturnDevice() {
    // Arrange, Act and Assert
    assertEquals(EdgeEntityType.DEVICE, EdgeEntityType.valueOf(0));
  }
}
