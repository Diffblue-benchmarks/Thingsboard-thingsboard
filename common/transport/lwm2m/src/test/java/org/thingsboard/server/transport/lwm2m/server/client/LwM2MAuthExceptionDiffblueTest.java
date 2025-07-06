package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MAuthExceptionDiffblueTest {
  /**
   * Test new {@link LwM2MAuthException} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LwM2MAuthException}
   */
  @Test
  @DisplayName("Test new LwM2MAuthException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MAuthException.<init>()"})
  void testNewLwM2MAuthException() {
    // Arrange and Act
    LwM2MAuthException actualLwM2MAuthException = new LwM2MAuthException();

    // Assert
    assertNull(actualLwM2MAuthException.getMessage());
    assertNull(actualLwM2MAuthException.getCause());
    assertEquals(0, actualLwM2MAuthException.getSuppressed().length);
  }
}
