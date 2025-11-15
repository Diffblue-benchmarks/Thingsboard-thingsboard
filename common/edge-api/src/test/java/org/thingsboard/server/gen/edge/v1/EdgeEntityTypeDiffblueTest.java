package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class EdgeEntityTypeDiffblueTest {
  /**
   * Method under test: {@link EdgeEntityType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(EdgeEntityType.forNumber(42));
    assertEquals(EdgeEntityType.DEVICE, EdgeEntityType.forNumber(0));
    assertEquals(EdgeEntityType.ASSET, EdgeEntityType.forNumber(1));
  }

  /**
   * Method under test: {@link EdgeEntityType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, EdgeEntityType.DEVICE.getNumber());
    assertThrows(IllegalArgumentException.class, () -> EdgeEntityType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link EdgeEntityType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> EdgeEntityType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link EdgeEntityType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeEntityType> actualInternalGetValueMapResult = EdgeEntityType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link EdgeEntityType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeEntityType> actualInternalGetValueMapResult = EdgeEntityType.internalGetValueMap();

    // Assert
    assertEquals(EdgeEntityType.ASSET, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link EdgeEntityType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeEntityType> actualInternalGetValueMapResult = EdgeEntityType.internalGetValueMap();

    // Assert
    assertEquals(EdgeEntityType.DEVICE, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link EdgeEntityType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(EdgeEntityType.valueOf(42));
    assertEquals(EdgeEntityType.DEVICE, EdgeEntityType.valueOf(0));
    assertEquals(EdgeEntityType.ASSET, EdgeEntityType.valueOf(1));
  }
}
