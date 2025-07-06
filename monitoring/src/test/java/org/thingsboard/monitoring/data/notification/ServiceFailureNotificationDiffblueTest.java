package org.thingsboard.monitoring.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceFailureNotificationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServiceFailureNotification#ServiceFailureNotification(Object, Throwable, int)}
   *   <li>{@link ServiceFailureNotification#getError()}
   *   <li>{@link ServiceFailureNotification#getFailuresCount()}
   *   <li>{@link ServiceFailureNotification#getServiceKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ServiceFailureNotification.<init>(Object, Throwable, int)",
    "Throwable ServiceFailureNotification.getError()",
    "int ServiceFailureNotification.getFailuresCount()",
    "Object ServiceFailureNotification.getServiceKey()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    ServiceFailureNotification actualServiceFailureNotification =
        new ServiceFailureNotification("Service Key", error, 3);
    Throwable actualError = actualServiceFailureNotification.getError();
    int actualFailuresCount = actualServiceFailureNotification.getFailuresCount();

    // Assert
    assertEquals("Service Key", actualServiceFailureNotification.getServiceKey());
    assertEquals(3, actualFailuresCount);
    assertSame(error, actualError);
  }
}
