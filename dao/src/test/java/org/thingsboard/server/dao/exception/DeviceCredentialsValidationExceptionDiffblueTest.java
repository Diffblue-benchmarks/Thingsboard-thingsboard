package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeviceCredentialsValidationExceptionDiffblueTest {
  /**
   * Test {@link DeviceCredentialsValidationException#DeviceCredentialsValidationException(String)}.
   * <p>
   * Method under test: {@link DeviceCredentialsValidationException#DeviceCredentialsValidationException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsValidationException.<init>(String)"})
  public void testNewDeviceCredentialsValidationException() {
    // Arrange and Act
    DeviceCredentialsValidationException actualDeviceCredentialsValidationException = new DeviceCredentialsValidationException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualDeviceCredentialsValidationException.getMessage());
    assertNull(actualDeviceCredentialsValidationException.getCause());
    assertEquals(0, actualDeviceCredentialsValidationException.getSuppressed().length);
  }
}
