package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SystemUtilDiffblueTest {
  /**
   * Test {@link SystemUtil#getDiscSpaceUsage()}.
   *
   * <p>Method under test: {@link SystemUtil#getDiscSpaceUsage()}
   */
  @Test
  @DisplayName("Test getDiscSpaceUsage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SystemUtil.getDiscSpaceUsage()"})
  void testGetDiscSpaceUsage() {
    // Arrange and Act
    Optional<Integer> actualDiscSpaceUsage = SystemUtil.getDiscSpaceUsage();

    // Assert
    assertEquals(67, actualDiscSpaceUsage.get().intValue());
    assertTrue(actualDiscSpaceUsage.isPresent());
  }

  /**
   * Test {@link SystemUtil#getTotalDiscSpace()}.
   *
   * <p>Method under test: {@link SystemUtil#getTotalDiscSpace()}
   */
  @Test
  @DisplayName("Test getTotalDiscSpace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SystemUtil.getTotalDiscSpace()"})
  void testGetTotalDiscSpace() {
    // Arrange and Act
    Optional<Long> actualTotalDiscSpace = SystemUtil.getTotalDiscSpace();

    // Assert
    assertEquals(511082229760L, actualTotalDiscSpace.get().longValue());
    assertTrue(actualTotalDiscSpace.isPresent());
  }
}
