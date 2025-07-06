package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeEventIdDiffblueTest {
  /**
   * Test {@link EdgeEventId#EdgeEventId(UUID)}.
   *
   * <p>Method under test: {@link EdgeEventId#EdgeEventId(UUID)}
   */
  @Test
  @DisplayName("Test new EdgeEventId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeEventId.<init>(UUID)"})
  void testNewEdgeEventId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    UUID id2 = new EdgeEventId(id).getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
  }
}
