package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataConstantsDiffblueTest {
  /**
   * Test {@link DataConstants#allScopes()}.
   * <p>
   * Method under test: {@link DataConstants#allScopes()}
   */
  @Test
  @DisplayName("Test allScopes()")
  void testAllScopes() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{DataConstants.CLIENT_SCOPE, DataConstants.SHARED_SCOPE, DataConstants.SERVER_SCOPE},
        DataConstants.allScopes());
  }
}
