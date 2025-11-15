package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class RequestMsgTypeDiffblueTest {
  /**
   * Method under test: {@link RequestMsgType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(RequestMsgType.forNumber(42));
    assertEquals(RequestMsgType.CONNECT_RPC_MESSAGE, RequestMsgType.forNumber(0));
    assertEquals(RequestMsgType.UPLINK_RPC_MESSAGE, RequestMsgType.forNumber(1));
    assertEquals(RequestMsgType.SYNC_REQUEST_RPC_MESSAGE, RequestMsgType.forNumber(2));
  }

  /**
   * Method under test: {@link RequestMsgType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, RequestMsgType.CONNECT_RPC_MESSAGE.getNumber());
    assertThrows(IllegalArgumentException.class, () -> RequestMsgType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link RequestMsgType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> RequestMsgType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertEquals(RequestMsgType.UPLINK_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertEquals(RequestMsgType.SYNC_REQUEST_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link RequestMsgType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<RequestMsgType> actualInternalGetValueMapResult = RequestMsgType.internalGetValueMap();

    // Assert
    assertEquals(RequestMsgType.CONNECT_RPC_MESSAGE, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link RequestMsgType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(RequestMsgType.valueOf(42));
    assertEquals(RequestMsgType.CONNECT_RPC_MESSAGE, RequestMsgType.valueOf(0));
    assertEquals(RequestMsgType.UPLINK_RPC_MESSAGE, RequestMsgType.valueOf(1));
    assertEquals(RequestMsgType.SYNC_REQUEST_RPC_MESSAGE, RequestMsgType.valueOf(2));
  }
}
