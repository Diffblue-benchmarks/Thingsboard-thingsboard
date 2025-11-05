package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class QueueIdDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueId#QueueId(UUID)}
   *   <li>{@link QueueId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueId.<init>(UUID)", "EntityType QueueId.getEntityType()"})
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    QueueId actualQueueId = new QueueId(id);
    EntityType actualEntityType = actualQueueId.getEntityType();

    // Assert
    UUID id2 = actualQueueId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.QUEUE, actualEntityType);
    assertSame(id, id2);
  }
}
