package org.thingsboard.monitoring.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceFailureNotificationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @MethodsUnderTest({"void ServiceFailureNotification.<init>(Object, Throwable, int)",
      "Throwable ServiceFailureNotification.getError()", "int ServiceFailureNotification.getFailuresCount()",
      "Object ServiceFailureNotification.getServiceKey()"})
  void testGettersAndSetters() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    ServiceFailureNotification actualServiceFailureNotification = new ServiceFailureNotification("Service Key", error,
        3);
    Throwable actualError = actualServiceFailureNotification.getError();
    int actualFailuresCount = actualServiceFailureNotification.getFailuresCount();

    // Assert
    assertEquals("Service Key", actualServiceFailureNotification.getServiceKey());
    assertEquals(3, actualFailuresCount);
    assertSame(error, actualError);
  }

  /**
   * Test {@link ServiceFailureNotification#getText()}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceFailureNotification#getText()}
   */
  @Test
  @DisplayName("Test getText(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ServiceFailureNotification.getText()"})
  void testGetText_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "Service Key - Failure: %s - Failure: %s (number of subsequent failures: %s) (number of subsequent"
            + " failures: 3)",
        (new ServiceFailureNotification("Service Key",
            new IOException("%s - Failure: %s (number of subsequent failures: %s)"), 3)).getText());
  }

  /**
   * Test {@link ServiceFailureNotification#getText()}.
   * <ul>
   *   <li>Then return {@code Service Key - Failure: null (number of subsequent failures: 3)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceFailureNotification#getText()}
   */
  @Test
  @DisplayName("Test getText(); then return 'Service Key - Failure: null (number of subsequent failures: 3)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ServiceFailureNotification.getText()"})
  void testGetText_thenReturnServiceKeyFailureNullNumberOfSubsequentFailures3() {
    // Arrange, Act and Assert
    assertEquals("Service Key - Failure: null (number of subsequent failures: 3)",
        (new ServiceFailureNotification("Service Key", new IOException("null"), 3)).getText());
  }

  /**
   * Test {@link ServiceFailureNotification#getText()}.
   * <ul>
   *   <li>Then return {@code Service Key - Failure: Throwable (number of subsequent failures: 3)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceFailureNotification#getText()}
   */
  @Test
  @DisplayName("Test getText(); then return 'Service Key - Failure: Throwable (number of subsequent failures: 3)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ServiceFailureNotification.getText()"})
  void testGetText_thenReturnServiceKeyFailureThrowableNumberOfSubsequentFailures3() {
    // Arrange, Act and Assert
    assertEquals("Service Key - Failure: Throwable (number of subsequent failures: 3)",
        (new ServiceFailureNotification("Service Key", new Throwable(), 3)).getText());
  }
}
