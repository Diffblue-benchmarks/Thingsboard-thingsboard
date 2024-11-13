package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EdgeIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeId#EdgeId(UUID)}
   *   <li>{@link EdgeId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    EdgeId actualEdgeId = new EdgeId(id);
    EntityType actualEntityType = actualEdgeId.getEntityType();

    // Assert
    UUID id2 = actualEdgeId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals(EntityType.EDGE, actualEntityType);
    assertSame(id, id2);
  }

  /**
   * Test {@link EdgeId#fromUUID(UUID)}.
   * <p>
   * Method under test: {@link EdgeId#fromUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromUUID(UUID)")
  void testFromUUID() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    EdgeId actualFromUUIDResult = EdgeId.fromUUID(id);

    // Assert
    assertEquals(EntityType.EDGE, actualFromUUIDResult.getEntityType());
    assertTrue(actualFromUUIDResult.isNullUid());
    assertSame(id, actualFromUUIDResult.getId());
  }
}
