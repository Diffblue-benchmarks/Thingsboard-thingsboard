package org.thingsboard.monitoring.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceFailureExceptionDiffblueTest {
  /**
   * Test {@link ServiceFailureException#ServiceFailureException(String)}.
   * <p>
   * Method under test: {@link ServiceFailureException#ServiceFailureException(String)}
   */
  @Test
  @DisplayName("Test new ServiceFailureException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ServiceFailureException.<init>(String)"})
  void testNewServiceFailureException() {
    // Arrange and Act
    ServiceFailureException actualServiceFailureException = new ServiceFailureException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualServiceFailureException.getMessage());
    assertNull(actualServiceFailureException.getCause());
    assertEquals(0, actualServiceFailureException.getSuppressed().length);
  }

  /**
   * Test {@link ServiceFailureException#ServiceFailureException(Throwable)}.
   * <p>
   * Method under test: {@link ServiceFailureException#ServiceFailureException(Throwable)}
   */
  @Test
  @DisplayName("Test new ServiceFailureException(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ServiceFailureException.<init>(Throwable)"})
  void testNewServiceFailureException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServiceFailureException actualServiceFailureException = new ServiceFailureException(cause);

    // Assert
    assertNull(actualServiceFailureException.getLocalizedMessage());
    assertNull(actualServiceFailureException.getMessage());
    assertEquals(0, actualServiceFailureException.getSuppressed().length);
    assertSame(cause, actualServiceFailureException.getCause());
  }
}
