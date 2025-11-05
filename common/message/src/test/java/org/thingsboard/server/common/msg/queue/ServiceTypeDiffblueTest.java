package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceTypeDiffblueTest {
  /**
   * Test {@link ServiceType#of(String)}.
   *
   * <ul>
   *   <li>When {@code JS_EXECUTOR}.
   *   <li>Then return {@code JS_EXECUTOR}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceType#of(String)}
   */
  @Test
  @DisplayName("Test of(String); when 'JS_EXECUTOR'; then return 'JS_EXECUTOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServiceType ServiceType.of(String)"})
  void testOf_whenJsExecutor_thenReturnJsExecutor() {
    // Arrange, Act and Assert
    assertEquals(ServiceType.JS_EXECUTOR, ServiceType.of("JS_EXECUTOR"));
  }

  /**
   * Test {@link ServiceType#of(String)}.
   *
   * <ul>
   *   <li>When {@code Service Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceType#of(String)}
   */
  @Test
  @DisplayName("Test of(String); when 'Service Type'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServiceType ServiceType.of(String)"})
  void testOf_whenServiceType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ServiceType.of("Service Type"));
  }

  /**
   * Test {@link ServiceType#getLabel()}.
   *
   * <p>Method under test: {@link ServiceType#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ServiceType.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("TB Core", ServiceType.valueOf("TB_CORE").getLabel());
  }
}
