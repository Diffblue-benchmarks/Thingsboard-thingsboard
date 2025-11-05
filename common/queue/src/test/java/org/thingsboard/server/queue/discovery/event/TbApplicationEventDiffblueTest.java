package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbApplicationEventDiffblueTest {
  /**
   * Test {@link TbApplicationEvent#TbApplicationEvent(Object)}.
   *
   * <p>Method under test: {@link TbApplicationEvent#TbApplicationEvent(Object)}
   */
  @Test
  @DisplayName("Test new TbApplicationEvent(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbApplicationEvent.<init>(Object)"})
  void testNewTbApplicationEvent() {
    // Arrange, Act and Assert
    assertEquals("Source", new TbApplicationEvent("Source").getSource());
  }
}
