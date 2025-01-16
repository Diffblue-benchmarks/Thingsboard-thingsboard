package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionEventDiffblueTest {
  /**
   * Test {@link SessionEvent#onEstablished()}.
   * <p>
   * Method under test: {@link SessionEvent#onEstablished()}
   */
  @Test
  @DisplayName("Test onEstablished()")
  void testOnEstablished() {
    // Arrange and Act
    SessionEvent actualOnEstablishedResult = SessionEvent.onEstablished();

    // Assert
    assertEquals(SessionEvent.SessionEventType.ESTABLISHED, actualOnEstablishedResult.getEventType());
    assertFalse(actualOnEstablishedResult.getError().isPresent());
  }

  /**
   * Test {@link SessionEvent#onClosed()}.
   * <p>
   * Method under test: {@link SessionEvent#onClosed()}
   */
  @Test
  @DisplayName("Test onClosed()")
  void testOnClosed() {
    // Arrange and Act
    SessionEvent actualOnClosedResult = SessionEvent.onClosed();

    // Assert
    assertEquals(SessionEvent.SessionEventType.CLOSED, actualOnClosedResult.getEventType());
    assertFalse(actualOnClosedResult.getError().isPresent());
  }

  /**
   * Test {@link SessionEvent#onError(Throwable)}.
   * <p>
   * Method under test: {@link SessionEvent#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  void testOnError() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    SessionEvent actualOnErrorResult = SessionEvent.onError(t);

    // Assert
    assertEquals(SessionEvent.SessionEventType.ERROR, actualOnErrorResult.getEventType());
    Optional<Throwable> error = actualOnErrorResult.getError();
    assertTrue(error.isPresent());
    assertSame(t, error.get());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SessionEvent#toString()}
   *   <li>{@link SessionEvent#getError()}
   *   <li>{@link SessionEvent#getEventType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    SessionEvent onClosedResult = SessionEvent.onClosed();

    // Act
    String actualToStringResult = onClosedResult.toString();
    Optional<Throwable> actualError = onClosedResult.getError();

    // Assert
    assertEquals("SessionEvent(eventType=CLOSED, error=Optional.empty)", actualToStringResult);
    assertEquals(SessionEvent.SessionEventType.CLOSED, onClosedResult.getEventType());
    assertFalse(actualError.isPresent());
  }
}
