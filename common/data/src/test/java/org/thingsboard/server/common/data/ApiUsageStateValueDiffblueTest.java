package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiUsageStateValueDiffblueTest {
  /**
   * Test {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)}.
   * <ul>
   *   <li>When {@code ENABLED}.</li>
   *   <li>Then return {@code ENABLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)}
   */
  @Test
  @DisplayName("Test toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue); when 'ENABLED'; then return 'ENABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue ApiUsageStateValue.toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)"})
  void testToMoreRestricted_whenEnabled_thenReturnEnabled() {
    // Arrange, Act and Assert
    assertEquals(ApiUsageStateValue.ENABLED,
        ApiUsageStateValue.toMoreRestricted(ApiUsageStateValue.ENABLED, ApiUsageStateValue.ENABLED));
  }

  /**
   * Test {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)}.
   * <ul>
   *   <li>When {@code WARNING}.</li>
   *   <li>Then return {@code WARNING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateValue#toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)}
   */
  @Test
  @DisplayName("Test toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue); when 'WARNING'; then return 'WARNING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageStateValue ApiUsageStateValue.toMoreRestricted(ApiUsageStateValue, ApiUsageStateValue)"})
  void testToMoreRestricted_whenWarning_thenReturnWarning() {
    // Arrange, Act and Assert
    assertEquals(ApiUsageStateValue.WARNING,
        ApiUsageStateValue.toMoreRestricted(ApiUsageStateValue.WARNING, ApiUsageStateValue.ENABLED));
  }
}
