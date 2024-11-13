package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EventType#getOldName()}
   *   <li>{@link EventType#getTable()}
   *   <li>{@link EventType#isDebug()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    EventType valueOfResult = EventType.valueOf("ERROR");

    // Act
    String actualOldName = valueOfResult.getOldName();
    String actualTable = valueOfResult.getTable();

    // Assert
    assertEquals("ERROR", actualOldName);
    assertEquals("error_event", actualTable);
    assertFalse(valueOfResult.isDebug());
  }
}
