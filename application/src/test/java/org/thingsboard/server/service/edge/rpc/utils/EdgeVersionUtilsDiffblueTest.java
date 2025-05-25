package org.thingsboard.server.service.edge.rpc.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class EdgeVersionUtilsDiffblueTest {
  /**
   * Test {@link EdgeVersionUtils#isEdgeVersionOlderThan(EdgeVersion, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_0}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersionUtils#isEdgeVersionOlderThan(EdgeVersion, EdgeVersion)}
   */
  @Test
  @DisplayName("Test isEdgeVersionOlderThan(EdgeVersion, EdgeVersion); when 'V_3_3_0'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeVersionUtils.isEdgeVersionOlderThan(EdgeVersion, EdgeVersion)"})
  void testIsEdgeVersionOlderThan_whenV330_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EdgeVersionUtils.isEdgeVersionOlderThan(EdgeVersion.V_3_3_0, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link EdgeVersionUtils#isEdgeVersionOlderThan(EdgeVersion, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_3}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeVersionUtils#isEdgeVersionOlderThan(EdgeVersion, EdgeVersion)}
   */
  @Test
  @DisplayName("Test isEdgeVersionOlderThan(EdgeVersion, EdgeVersion); when 'V_3_3_3'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeVersionUtils.isEdgeVersionOlderThan(EdgeVersion, EdgeVersion)"})
  void testIsEdgeVersionOlderThan_whenV333_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EdgeVersionUtils.isEdgeVersionOlderThan(EdgeVersion.V_3_3_0, EdgeVersion.V_3_3_3));
  }
}
