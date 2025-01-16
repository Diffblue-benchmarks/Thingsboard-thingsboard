package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTypeDiffblueTest {
  /**
   * Test {@link ServiceType#getLabel()}.
   * <p>
   * Method under test: {@link ServiceType#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("TB Core", ServiceType.valueOf("TB_CORE").getLabel());
  }

  /**
   * Test {@link ServiceType#of(String)}.
   * <ul>
   *   <li>When {@code JS_EXECUTOR}.</li>
   *   <li>Then return {@code JS_EXECUTOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceType#of(String)}
   */
  @Test
  @DisplayName("Test of(String); when 'JS_EXECUTOR'; then return 'JS_EXECUTOR'")
  void testOf_whenJsExecutor_thenReturnJsExecutor() {
    // Arrange, Act and Assert
    assertEquals(ServiceType.JS_EXECUTOR, ServiceType.of("JS_EXECUTOR"));
  }
}
