package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificationDeliveryMethodDiffblueTest {
  /**
   * Test {@link NotificationDeliveryMethod#getName()}.
   * <p>
   * Method under test: {@link NotificationDeliveryMethod#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("web", NotificationDeliveryMethod.valueOf("WEB").getName());
  }
}
