package org.thingsboard.server.common.data.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OtaPackageTypeDiffblueTest {
  /**
   * Test {@link OtaPackageType#getKeyPrefix()}.
   * <p>
   * Method under test: {@link OtaPackageType#getKeyPrefix()}
   */
  @Test
  @DisplayName("Test getKeyPrefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String OtaPackageType.getKeyPrefix()"})
  void testGetKeyPrefix() {
    // Arrange, Act and Assert
    assertEquals("fw", OtaPackageType.valueOf("FIRMWARE").getKeyPrefix());
  }
}
