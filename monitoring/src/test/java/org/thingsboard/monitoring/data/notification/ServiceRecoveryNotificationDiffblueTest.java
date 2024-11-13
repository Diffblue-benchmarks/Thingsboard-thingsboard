package org.thingsboard.monitoring.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceRecoveryNotificationDiffblueTest {
  /**
   * Test {@link ServiceRecoveryNotification#ServiceRecoveryNotification(Object)}.
   * <p>
   * Method under test:
   * {@link ServiceRecoveryNotification#ServiceRecoveryNotification(Object)}
   */
  @Test
  @DisplayName("Test new ServiceRecoveryNotification(Object)")
  void testNewServiceRecoveryNotification() {
    // Arrange, Act and Assert
    assertEquals("Service Key is OK", (new ServiceRecoveryNotification("Service Key")).getText());
  }

  /**
   * Test {@link ServiceRecoveryNotification#getText()}.
   * <p>
   * Method under test: {@link ServiceRecoveryNotification#getText()}
   */
  @Test
  @DisplayName("Test getText()")
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("Service Key is OK", (new ServiceRecoveryNotification("Service Key")).getText());
  }
}
