package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbApplicationEventDiffblueTest {
  /**
   * Test {@link TbApplicationEvent#TbApplicationEvent(Object)}.
   * <p>
   * Method under test: {@link TbApplicationEvent#TbApplicationEvent(Object)}
   */
  @Test
  @DisplayName("Test new TbApplicationEvent(Object)")
  void testNewTbApplicationEvent() {
    // Arrange, Act and Assert
    assertEquals("Source", (new TbApplicationEvent("Source")).getSource());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbApplicationEvent#toString()}
   *   <li>{@link TbApplicationEvent#getSequenceNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     TbApplicationEvent.sequenceNumber
    //     ApplicationEvent.timestamp
    //     EventObject.source

    // Arrange
    TbApplicationEvent tbApplicationEvent = new TbApplicationEvent("Source");

    // Act
    tbApplicationEvent.toString();
    tbApplicationEvent.getSequenceNumber();
  }
}
