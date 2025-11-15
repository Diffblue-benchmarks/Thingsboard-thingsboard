package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class ConnectResponseCodeDiffblueTest {
  /**
   * Method under test: {@link ConnectResponseCode#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(ConnectResponseCode.forNumber(42));
    assertEquals(ConnectResponseCode.ACCEPTED, ConnectResponseCode.forNumber(0));
    assertEquals(ConnectResponseCode.BAD_CREDENTIALS, ConnectResponseCode.forNumber(1));
    assertEquals(ConnectResponseCode.SERVER_UNAVAILABLE, ConnectResponseCode.forNumber(2));
  }

  /**
   * Method under test: {@link ConnectResponseCode#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, ConnectResponseCode.ACCEPTED.getNumber());
    assertThrows(IllegalArgumentException.class, () -> ConnectResponseCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link ConnectResponseCode#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ConnectResponseCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertEquals(ConnectResponseCode.BAD_CREDENTIALS, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertEquals(ConnectResponseCode.SERVER_UNAVAILABLE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link ConnectResponseCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<ConnectResponseCode> actualInternalGetValueMapResult = ConnectResponseCode
        .internalGetValueMap();

    // Assert
    assertEquals(ConnectResponseCode.ACCEPTED, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link ConnectResponseCode#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(ConnectResponseCode.valueOf(42));
    assertEquals(ConnectResponseCode.ACCEPTED, ConnectResponseCode.valueOf(0));
    assertEquals(ConnectResponseCode.BAD_CREDENTIALS, ConnectResponseCode.valueOf(1));
    assertEquals(ConnectResponseCode.SERVER_UNAVAILABLE, ConnectResponseCode.valueOf(2));
  }
}
