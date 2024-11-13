package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2MClientStateExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LwM2MClientStateException#LwM2MClientStateException(LwM2MClientState, String)}
   *   <li>{@link LwM2MClientStateException#getState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MClientStateException actualLwM2MClientStateException = new LwM2MClientStateException(LwM2MClientState.CREATED,
        "An error occurred");
    LwM2MClientState actualState = actualLwM2MClientStateException.getState();

    // Assert
    assertEquals("An error occurred", actualLwM2MClientStateException.getMessage());
    assertNull(actualLwM2MClientStateException.getCause());
    assertEquals(0, actualLwM2MClientStateException.getSuppressed().length);
    assertEquals(LwM2MClientState.CREATED, actualState);
  }
}
