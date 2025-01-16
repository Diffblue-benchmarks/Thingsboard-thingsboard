package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.netty.shaded.io.netty.channel.group.DefaultChannelGroup;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OtherServiceShutdownEventDiffblueTest {
  /**
   * Test
   * {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}
   */
  @Test
  @DisplayName("Test new OtherServiceShutdownEvent(Object, String, List); when ArrayList(); then return 'Source'")
  void testNewOtherServiceShutdownEvent_whenArrayList_thenReturnSource() {
    // Arrange, Act and Assert
    assertEquals("Source", (new OtherServiceShutdownEvent("Source", "42", new ArrayList<>())).getSource());
  }

  /**
   * Test
   * {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}.
   * <ul>
   *   <li>When {@link DefaultChannelGroup}.</li>
   *   <li>Then return ServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}
   */
  @Test
  @DisplayName("Test new OtherServiceShutdownEvent(Object, String, List); when DefaultChannelGroup; then return ServiceId is '42'")
  void testNewOtherServiceShutdownEvent_whenDefaultChannelGroup_thenReturnServiceIdIs42() {
    // Arrange
    DefaultChannelGroup defaultChannelGroup = mock(DefaultChannelGroup.class);

    // Act
    OtherServiceShutdownEvent actualOtherServiceShutdownEvent = new OtherServiceShutdownEvent(defaultChannelGroup, "42",
        new ArrayList<>());

    // Assert
    assertEquals("42", actualOtherServiceShutdownEvent.getServiceId());
    assertTrue(actualOtherServiceShutdownEvent.getServiceTypes().isEmpty());
    assertSame(defaultChannelGroup, actualOtherServiceShutdownEvent.getSource());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtherServiceShutdownEvent#getServiceId()}
   *   <li>{@link OtherServiceShutdownEvent#getServiceTypes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    OtherServiceShutdownEvent otherServiceShutdownEvent = new OtherServiceShutdownEvent("Source", "42",
        new ArrayList<>());

    // Act
    String actualServiceId = otherServiceShutdownEvent.getServiceId();

    // Assert
    assertEquals("42", actualServiceId);
    assertTrue(otherServiceShutdownEvent.getServiceTypes().isEmpty());
  }
}
