package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeScope TbAttributeSubscriptionScope.getAttributeScope()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbAttributeSubscriptionScope TbAttributeSubscriptionScope.of(AttributeScope)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals(TbAttributeSubscriptionScope.CLIENT_SCOPE,
        TbAttributeSubscriptionScope.of(AttributeScope.CLIENT_SCOPE));
  }
}
