package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttributeScopeDiffblueTest {
  /**
   * Test {@link AttributeScope#getId()}.
   * <p>
   * Method under test: {@link AttributeScope#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals(1, AttributeScope.valueOf(DataConstants.CLIENT_SCOPE).getId());
  }

  /**
   * Test {@link AttributeScope#valueOf(int)} with {@code id}.
   * <p>
   * Method under test: {@link AttributeScope#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'id'")
  void testValueOfWithId() {
    // Arrange, Act and Assert
    assertEquals(AttributeScope.CLIENT_SCOPE, AttributeScope.valueOf(1));
  }
}
