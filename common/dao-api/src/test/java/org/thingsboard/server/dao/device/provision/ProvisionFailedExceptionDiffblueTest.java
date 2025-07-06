package org.thingsboard.server.dao.device.provision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProvisionFailedExceptionDiffblueTest {
  /**
   * Test {@link ProvisionFailedException#ProvisionFailedException(String)}.
   *
   * <p>Method under test: {@link ProvisionFailedException#ProvisionFailedException(String)}
   */
  @Test
  @DisplayName("Test new ProvisionFailedException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProvisionFailedException.<init>(String)"})
  void testNewProvisionFailedException() {
    // Arrange and Act
    ProvisionFailedException actualProvisionFailedException =
        new ProvisionFailedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualProvisionFailedException.getMessage());
    assertNull(actualProvisionFailedException.getCause());
    assertEquals(0, actualProvisionFailedException.getSuppressed().length);
  }
}
