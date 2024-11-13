package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AttributeScope;

class TbAttributeSubscriptionScopeDiffblueTest {
  /**
   * Test {@link TbAttributeSubscriptionScope#getAttributeScope()}.
   * <p>
   * Method under test: {@link TbAttributeSubscriptionScope#getAttributeScope()}
   */
  @Test
  @DisplayName("Test getAttributeScope()")
  void testGetAttributeScope() {
    // Arrange, Act and Assert
    assertNull(TbAttributeSubscriptionScope.valueOf("ANY_SCOPE").getAttributeScope());
  }

  /**
   * Test {@link TbAttributeSubscriptionScope#of(AttributeScope)}.
   * <p>
   * Method under test: {@link TbAttributeSubscriptionScope#of(AttributeScope)}
   */
  @Test
  @DisplayName("Test of(AttributeScope)")
  void testOf() {
    // Arrange, Act and Assert
    assertEquals(TbAttributeSubscriptionScope.CLIENT_SCOPE,
        TbAttributeSubscriptionScope.of(AttributeScope.CLIENT_SCOPE));
  }
}
