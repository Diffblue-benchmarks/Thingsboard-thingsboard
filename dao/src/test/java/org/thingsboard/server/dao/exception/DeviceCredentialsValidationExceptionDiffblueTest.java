package org.thingsboard.server.dao.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceCredentialsValidationExceptionDiffblueTest {
  /**
   * Test {@link DeviceCredentialsValidationException#DeviceCredentialsValidationException(String)}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsValidationException#DeviceCredentialsValidationException(String)}
   */
  @Test
  @DisplayName("Test new DeviceCredentialsValidationException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceCredentialsValidationException.<init>(String)"})
  void testNewDeviceCredentialsValidationException() {
    // Arrange and Act
    DeviceCredentialsValidationException actualDeviceCredentialsValidationException =
        new DeviceCredentialsValidationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDeviceCredentialsValidationException.getMessage());
    assertNull(actualDeviceCredentialsValidationException.getCause());
    assertEquals(0, actualDeviceCredentialsValidationException.getSuppressed().length);
  }
}
