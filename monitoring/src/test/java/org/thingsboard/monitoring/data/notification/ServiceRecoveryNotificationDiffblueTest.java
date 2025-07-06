package org.thingsboard.monitoring.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceRecoveryNotificationDiffblueTest {
  /**
   * Test {@link ServiceRecoveryNotification#ServiceRecoveryNotification(Object)}.
   *
   * <p>Method under test: {@link ServiceRecoveryNotification#ServiceRecoveryNotification(Object)}
   */
  @Test
  @DisplayName("Test new ServiceRecoveryNotification(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ServiceRecoveryNotification.<init>(Object)"})
  void testNewServiceRecoveryNotification() {
    // Arrange, Act and Assert
    assertEquals("Service Key is OK", new ServiceRecoveryNotification("Service Key").getText());
  }

  /**
   * Test {@link ServiceRecoveryNotification#getText()}.
   *
   * <p>Method under test: {@link ServiceRecoveryNotification#getText()}
   */
  @Test
  @DisplayName("Test getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ServiceRecoveryNotification.getText()"})
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("Service Key is OK", new ServiceRecoveryNotification("Service Key").getText());
  }
}
