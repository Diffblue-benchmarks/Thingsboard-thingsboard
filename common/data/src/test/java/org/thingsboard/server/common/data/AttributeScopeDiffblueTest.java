package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttributeScopeDiffblueTest {
  /**
   * Test {@link AttributeScope#valueOf(int)} with {@code id}.
   *
   * <p>Method under test: {@link AttributeScope#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeScope AttributeScope.valueOf(int)"})
  void testValueOfWithId() {
    // Arrange, Act and Assert
    assertEquals(AttributeScope.CLIENT_SCOPE, AttributeScope.valueOf(1));
  }

  /**
   * Test {@link AttributeScope#getId()}.
   *
   * <p>Method under test: {@link AttributeScope#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AttributeScope.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals(1, AttributeScope.valueOf(DataConstants.CLIENT_SCOPE).getId());
  }
}
