package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class EdgeVersionDiffblueTest {
  /**
   * Method under test: {@link EdgeVersion#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(EdgeVersion.forNumber(42));
    assertEquals(EdgeVersion.V_3_3_0, EdgeVersion.forNumber(0));
    assertEquals(EdgeVersion.V_3_3_3, EdgeVersion.forNumber(1));
    assertEquals(EdgeVersion.V_3_4_0, EdgeVersion.forNumber(2));
    assertEquals(EdgeVersion.V_3_6_0, EdgeVersion.forNumber(3));
    assertEquals(EdgeVersion.V_3_6_1, EdgeVersion.forNumber(4));
    assertEquals(EdgeVersion.V_3_6_2, EdgeVersion.forNumber(5));
    assertEquals(EdgeVersion.V_3_6_4, EdgeVersion.forNumber(6));
    assertEquals(EdgeVersion.V_3_7_0, EdgeVersion.forNumber(7));
    assertEquals(EdgeVersion.V_3_8_0, EdgeVersion.forNumber(8));
  }

  /**
   * Method under test: {@link EdgeVersion#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, EdgeVersion.V_3_3_0.getNumber());
    assertThrows(IllegalArgumentException.class, () -> EdgeVersion.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link EdgeVersion#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> EdgeVersion.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AlarmUpdateMsg.STARTTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_3_3, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_4_0, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_0, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_1, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_2, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_3_0, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_6_4, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap9() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_7_0, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Method under test: {@link EdgeVersion#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap10() {
    // Arrange and Act
    Internal.EnumLiteMap<EdgeVersion> actualInternalGetValueMapResult = EdgeVersion.internalGetValueMap();

    // Assert
    assertEquals(EdgeVersion.V_3_8_0, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Method under test: {@link EdgeVersion#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(EdgeVersion.valueOf(42));
    assertEquals(EdgeVersion.V_3_3_0, EdgeVersion.valueOf(0));
    assertEquals(EdgeVersion.V_3_3_3, EdgeVersion.valueOf(1));
    assertEquals(EdgeVersion.V_3_4_0, EdgeVersion.valueOf(2));
    assertEquals(EdgeVersion.V_3_6_0, EdgeVersion.valueOf(3));
    assertEquals(EdgeVersion.V_3_6_1, EdgeVersion.valueOf(4));
    assertEquals(EdgeVersion.V_3_6_2, EdgeVersion.valueOf(5));
    assertEquals(EdgeVersion.V_3_6_4, EdgeVersion.valueOf(6));
    assertEquals(EdgeVersion.V_3_7_0, EdgeVersion.valueOf(7));
    assertEquals(EdgeVersion.V_3_8_0, EdgeVersion.valueOf(8));
  }
}
