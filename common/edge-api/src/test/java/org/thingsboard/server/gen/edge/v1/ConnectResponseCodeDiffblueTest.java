package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectResponseCodeDiffblueTest {
  /**
   * Test {@link ConnectResponseCode#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ConnectResponseCode.forNumber(42));
  }

  /**
   * Test {@link ConnectResponseCode#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code BAD_CREDENTIALS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'BAD_CREDENTIALS'")
  void testForNumber_whenOne_thenReturnBadCredentials() {
    // Arrange, Act and Assert
    assertEquals(ConnectResponseCode.BAD_CREDENTIALS, ConnectResponseCode.forNumber(1));
  }

  /**
   * Test {@link ConnectResponseCode#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SERVER_UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'SERVER_UNAVAILABLE'")
  void testForNumber_whenTwo_thenReturnServerUnavailable() {
    // Arrange, Act and Assert
    assertEquals(ConnectResponseCode.SERVER_UNAVAILABLE, ConnectResponseCode.forNumber(2));
  }

  /**
   * Test {@link ConnectResponseCode#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code ACCEPTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'ACCEPTED'")
  void testForNumber_whenZero_thenReturnAccepted() {
    // Arrange, Act and Assert
    assertEquals(ConnectResponseCode.ACCEPTED, ConnectResponseCode.forNumber(0));
  }

  /**
   * Test {@link ConnectResponseCode#getNumber()}.
   * <ul>
   *   <li>Given {@code ACCEPTED}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'ACCEPTED'; then return zero")
  void testGetNumber_givenAccepted_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ConnectResponseCode.ACCEPTED.getNumber());
  }

  /**
   * Test {@link ConnectResponseCode#getNumber()}.
   * <ul>
   *   <li>Given {@link ConnectResponseCode#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ConnectResponseCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link ConnectResponseCode#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link ConnectResponseCode#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ConnectResponseCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link ConnectResponseCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code BAD_CREDENTIALS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'BAD_CREDENTIALS'")
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsBadCredentials() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertEquals(ConnectResponseCode.BAD_CREDENTIALS, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link ConnectResponseCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link AlarmUpdateMsg#STARTTS_FIELD_NUMBER}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber STARTTS_FIELD_NUMBER is 'null'")
  void testInternalGetValueMap_thenReturnFindValueByNumberStartts_field_numberIsNull() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Test {@link ConnectResponseCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code SERVER_UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'SERVER_UNAVAILABLE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsServerUnavailable() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertEquals(ConnectResponseCode.SERVER_UNAVAILABLE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link ConnectResponseCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code ACCEPTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'ACCEPTED'")
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsAccepted() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertEquals(ConnectResponseCode.ACCEPTED, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link ConnectResponseCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ConnectResponseCode.valueOf(42));
  }

  /**
   * Test {@link ConnectResponseCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code BAD_CREDENTIALS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'BAD_CREDENTIALS'")
  void testValueOfWithValue_whenOne_thenReturnBadCredentials() {
    // Arrange, Act and Assert
    assertEquals(ConnectResponseCode.BAD_CREDENTIALS, ConnectResponseCode.valueOf(1));
  }

  /**
   * Test {@link ConnectResponseCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SERVER_UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'SERVER_UNAVAILABLE'")
  void testValueOfWithValue_whenTwo_thenReturnServerUnavailable() {
    // Arrange, Act and Assert
    assertEquals(ConnectResponseCode.SERVER_UNAVAILABLE, ConnectResponseCode.valueOf(2));
  }

  /**
   * Test {@link ConnectResponseCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code ACCEPTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'ACCEPTED'")
  void testValueOfWithValue_whenZero_thenReturnAccepted() {
    // Arrange, Act and Assert
    assertEquals(ConnectResponseCode.ACCEPTED, ConnectResponseCode.valueOf(0));
  }
}
