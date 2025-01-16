package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataTypeDiffblueTest {
  /**
   * Test {@link DataType#getProtoNumber()}.
   * <p>
   * Method under test: {@link DataType#getProtoNumber()}
   */
  @Test
  @DisplayName("Test getProtoNumber()")
  void testGetProtoNumber() {
    // Arrange, Act and Assert
    assertEquals(0, DataType.valueOf("BOOLEAN").getProtoNumber());
  }
}
