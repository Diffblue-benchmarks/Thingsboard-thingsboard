package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.SessionEvent.SessionEventType;

class SessionEventDiffblueTest {
  /**
   * Test {@link SessionEvent#onEstablished()}.
   * <p>
   * Method under test: {@link SessionEvent#onEstablished()}
   */
  @Test
  @DisplayName("Test onEstablished()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SessionEvent SessionEvent.onEstablished()"})
  void testOnEstablished() {
    // Arrange and Act
    SessionEvent actualOnEstablishedResult = SessionEvent.onEstablished();

    // Assert
    assertEquals(SessionEventType.ESTABLISHED, actualOnEstablishedResult.getEventType());
    assertFalse(actualOnEstablishedResult.getError().isPresent());
  }

  /**
   * Test {@link SessionEvent#onClosed()}.
   * <p>
   * Method under test: {@link SessionEvent#onClosed()}
   */
  @Test
  @DisplayName("Test onClosed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SessionEvent SessionEvent.onClosed()"})
  void testOnClosed() {
    // Arrange and Act
    SessionEvent actualOnClosedResult = SessionEvent.onClosed();

    // Assert
    assertEquals(SessionEventType.CLOSED, actualOnClosedResult.getEventType());
    assertFalse(actualOnClosedResult.getError().isPresent());
  }

  /**
   * Test {@link SessionEvent#onError(Throwable)}.
   * <p>
   * Method under test: {@link SessionEvent#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SessionEvent SessionEvent.onError(Throwable)"})
  void testOnError() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    SessionEvent actualOnErrorResult = SessionEvent.onError(t);

    // Assert
    assertEquals(SessionEventType.ERROR, actualOnErrorResult.getEventType());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SessionEvent.getError()", "SessionEventType SessionEvent.getEventType()",
      "String SessionEvent.toString()"})
  void testGettersAndSetters() {
    // Arrange
    SessionEvent onClosedResult = SessionEvent.onClosed();

    // Act
    String actualToStringResult = onClosedResult.toString();
    Optional<Throwable> actualError = onClosedResult.getError();

    // Assert
    assertEquals("SessionEvent(eventType=CLOSED, error=Optional.empty)", actualToStringResult);
    assertEquals(SessionEventType.CLOSED, onClosedResult.getEventType());
    assertFalse(actualError.isPresent());
  }
}
