package org.thingsboard.server.install;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThingsboardInstallExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThingsboardInstallException#ThingsboardInstallException(String, Throwable)}
   *   <li>{@link ThingsboardInstallException#getExitCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ThingsboardInstallException.<init>(String, Throwable)",
    "int ThingsboardInstallException.getExitCode()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ThingsboardInstallException actualThingsboardInstallException =
        new ThingsboardInstallException("An error occurred", cause);
    int actualExitCode = actualThingsboardInstallException.getExitCode();

    // Assert
    assertEquals("An error occurred", actualThingsboardInstallException.getMessage());
    assertEquals(0, actualThingsboardInstallException.getSuppressed().length);
    assertEquals(1, actualExitCode);
    assertSame(cause, actualThingsboardInstallException.getCause());
  }
}
