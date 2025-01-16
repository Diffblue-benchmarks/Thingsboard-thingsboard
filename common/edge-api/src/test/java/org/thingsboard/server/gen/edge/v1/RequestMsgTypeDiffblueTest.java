package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestMsgTypeDiffblueTest {
  /**
   * Test {@link RequestMsgType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RequestMsgType.forNumber(42));
  }

  /**
   * Test {@link RequestMsgType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code UPLINK_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'UPLINK_RPC_MESSAGE'")
  void testForNumber_whenOne_thenReturnUplinkRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(RequestMsgType.UPLINK_RPC_MESSAGE, RequestMsgType.forNumber(1));
  }

  /**
   * Test {@link RequestMsgType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SYNC_REQUEST_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'SYNC_REQUEST_RPC_MESSAGE'")
  void testForNumber_whenTwo_thenReturnSyncRequestRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(RequestMsgType.SYNC_REQUEST_RPC_MESSAGE, RequestMsgType.forNumber(2));
  }

  /**
   * Test {@link RequestMsgType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CONNECT_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'CONNECT_RPC_MESSAGE'")
  void testForNumber_whenZero_thenReturnConnectRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(RequestMsgType.CONNECT_RPC_MESSAGE, RequestMsgType.forNumber(0));
  }

  /**
   * Test {@link RequestMsgType#getNumber()}.
   * <ul>
   *   <li>Given {@code CONNECT_RPC_MESSAGE}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'CONNECT_RPC_MESSAGE'; then return zero")
  void testGetNumber_givenConnectRpcMessage_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, RequestMsgType.CONNECT_RPC_MESSAGE.getNumber());
  }

  /**
   * Test {@link RequestMsgType#getNumber()}.
   * <ul>
   *   <li>Given {@link RequestMsgType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RequestMsgType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link RequestMsgType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link RequestMsgType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> RequestMsgType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link RequestMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code UPLINK_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'UPLINK_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsUplinkRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertEquals(RequestMsgType.UPLINK_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link RequestMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link AlarmUpdateMsg#STARTTS_FIELD_NUMBER}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber STARTTS_FIELD_NUMBER is 'null'")
  void testInternalGetValueMap_thenReturnFindValueByNumberStartts_field_numberIsNull() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Test {@link RequestMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is
   * {@code SYNC_REQUEST_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'SYNC_REQUEST_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsSyncRequestRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertEquals(RequestMsgType.SYNC_REQUEST_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link RequestMsgType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code CONNECT_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'CONNECT_RPC_MESSAGE'")
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsConnectRpcMessage() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertEquals(RequestMsgType.CONNECT_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link RequestMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RequestMsgType.valueOf(42));
  }

  /**
   * Test {@link RequestMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code UPLINK_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'UPLINK_RPC_MESSAGE'")
  void testValueOfWithValue_whenOne_thenReturnUplinkRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(RequestMsgType.UPLINK_RPC_MESSAGE, RequestMsgType.valueOf(1));
  }

  /**
   * Test {@link RequestMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SYNC_REQUEST_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'SYNC_REQUEST_RPC_MESSAGE'")
  void testValueOfWithValue_whenTwo_thenReturnSyncRequestRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(RequestMsgType.SYNC_REQUEST_RPC_MESSAGE, RequestMsgType.valueOf(2));
  }

  /**
   * Test {@link RequestMsgType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CONNECT_RPC_MESSAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsgType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'CONNECT_RPC_MESSAGE'")
  void testValueOfWithValue_whenZero_thenReturnConnectRpcMessage() {
    // Arrange, Act and Assert
    assertEquals(RequestMsgType.CONNECT_RPC_MESSAGE, RequestMsgType.valueOf(0));
  }
}
