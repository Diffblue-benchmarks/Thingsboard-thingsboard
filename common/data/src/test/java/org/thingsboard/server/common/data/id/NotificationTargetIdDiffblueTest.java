package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class NotificationTargetIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTargetId#NotificationTargetId(UUID)}
   *   <li>{@link NotificationTargetId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    NotificationTargetId actualNotificationTargetId = new NotificationTargetId(id);
    EntityType actualEntityType = actualNotificationTargetId.getEntityType();

    // Assert
    UUID id2 = actualNotificationTargetId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEntityType);
    assertSame(id, id2);
  }
}
