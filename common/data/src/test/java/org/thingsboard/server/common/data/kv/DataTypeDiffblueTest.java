package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeDiffblueTest {
  /**
   * Test {@link DataType#getProtoNumber()}.
   *
   * <p>Method under test: {@link DataType#getProtoNumber()}
   */
  @Test
  @DisplayName("Test getProtoNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataType.getProtoNumber()"})
  void testGetProtoNumber() {
    // Arrange, Act and Assert
    assertEquals(0, DataType.valueOf("BOOLEAN").getProtoNumber());
  }
}
